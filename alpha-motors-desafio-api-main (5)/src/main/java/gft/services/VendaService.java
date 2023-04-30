package gft.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gft.dto.venda.ConsultaClienteFuncionarioVendaDTO;
import gft.dto.venda.ConsultaVendaDTO;
import gft.dto.venda.RegistroVendaDTO;
import gft.dto.venda.RegistroItemVendaDTO;
import gft.entities.Cliente;
import gft.entities.Funcionario;
import gft.entities.ItemVenda;
import gft.entities.Produto;
import gft.entities.Veiculo;
import gft.entities.Venda;
import gft.exception.RegraNegocioException;
import gft.repositories.ItemVendaRepository;
import gft.repositories.VendaRepository;

@Service
public class VendaService extends AbstractVendasService {

	private ClienteService clienteService;
	private ItemVendaRepository itemVendaRepository;
	private VendaRepository vendaRepository;
	private FuncionarioService funcionarioService;
	private ProdutoService produtoService;
	private VeiculoService veiculoService;

	@Autowired
	public VendaService(ClienteService clienteService, ItemVendaRepository itemVendaRepository,
			VendaRepository vendaRepository, FuncionarioService funcionarioService, ProdutoService produtoService,
			VeiculoService veiculoService) {
		this.clienteService = clienteService;
		this.itemVendaRepository = itemVendaRepository;
		this.vendaRepository = vendaRepository;
		this.funcionarioService = funcionarioService;
		this.produtoService = produtoService;
		this.veiculoService = veiculoService;
	}

	public List<ConsultaVendaDTO> listarTodasAsVendas() {
		List<ConsultaVendaDTO> listaConsultaVendaDTO = vendaRepository.findAll().stream()
				.map(venda -> criandoConsultaVendaDTO(venda, itemVendaRepository.findByVendaCodigo(venda.getCodigo())))
				.collect(Collectors.toList());
		return listaConsultaVendaDTO;
	}

	public ConsultaClienteFuncionarioVendaDTO listaPorCliente(Long idCliente) {
		Cliente cliente = validarClienteExiste(idCliente);
		List<ConsultaVendaDTO> listaConsultaVendaDTO = vendaRepository.findByClienteId(idCliente).stream()
				.map(venda -> criandoConsultaVendaDTOCliente(venda,
						itemVendaRepository.findByVendaCodigo(venda.getCodigo())))
				.collect(Collectors.toList());
		return new ConsultaClienteFuncionarioVendaDTO(cliente.getNome(), listaConsultaVendaDTO);
	}

	public ConsultaClienteFuncionarioVendaDTO listaPorFuncionario(Long idFuncionario) {
		Funcionario funcionario = validarFuncionarioExiste(idFuncionario);
		List<ConsultaVendaDTO> listaConsultaVendaDTO = vendaRepository.findByFuncionarioId(idFuncionario).stream()
				.map(venda -> criandoConsultaVendaDTOFuncionario(venda,
						itemVendaRepository.findByVendaCodigo(venda.getCodigo())))
				.collect(Collectors.toList());
		return new ConsultaClienteFuncionarioVendaDTO(funcionario.getNome(), listaConsultaVendaDTO);
	}

	public ConsultaClienteFuncionarioVendaDTO listarPorCodigoVenda(Long codigoVenda) {
		Venda venda = validarVendaExiste(codigoVenda);
		return new ConsultaClienteFuncionarioVendaDTO(venda.getCliente().getNome(), Arrays
				.asList(criandoConsultaVendaDTO(venda, itemVendaRepository.findByVendaCodigo(venda.getCodigo()))));
	}

	public ConsultaClienteFuncionarioVendaDTO salvar(RegistroVendaDTO vendaDTO) {
		Cliente cliente = validarClienteExiste(vendaDTO.getClienteId());
		Funcionario funcionario = validarFuncionarioExiste(vendaDTO.getFuncionarioId());
		validarProdutoExiste(vendaDTO.getItensVendaDTO());
		Venda vendaSalva = salvarVenda(cliente, funcionario, vendaDTO);
		return new ConsultaClienteFuncionarioVendaDTO(cliente.getNome(), Arrays.asList(
				criandoConsultaVendaDTOCliente(vendaSalva, itemVendaRepository.findByVendaCodigo(vendaSalva.getCodigo()))));
	}

	private Venda salvarVenda(Cliente cliente, Funcionario funcionario, RegistroVendaDTO vendaDTO) {
		Venda vendaSalva = vendaRepository.save(new Venda(vendaDTO.getData(), funcionario, cliente));
		vendaDTO.getItensVendaDTO().stream().map(itemVendaDto -> criandoItemVenda(vendaSalva, itemVendaDto))
				.forEach(itemVendaRepository::save);
		return vendaSalva;
	}

	private void validarProdutoExiste(List<RegistroItemVendaDTO> itensVendaDTO) {
		itensVendaDTO.forEach(item -> produtoService.buscarProduto(item.getCodigoProduto()));
	}

	private Venda validarVendaExiste(Long codigoVenda) {
		Optional<Venda> venda = vendaRepository.findById(codigoVenda);
		if (venda.isEmpty()) {
			throw new RegraNegocioException(String.format("Venda de código %s não existe", codigoVenda));
		}
		return venda.get();
	}

	private Cliente validarClienteExiste(Long idCliente) {
		Cliente cliente = clienteService.buscar(idCliente);
		return cliente;
	}

	private Funcionario validarFuncionarioExiste(Long idFuncionario) {
		Funcionario funcionario = funcionarioService.buscar(idFuncionario);
		return funcionario;
	}

	public void deletar(Long codigoVenda) {
		Venda venda = validarVendaExiste(codigoVenda);
		List<ItemVenda> itensVenda = itemVendaRepository.findByVendaCodigo(codigoVenda);
		validarProdutoExisteEDevolverEstoque(itensVenda);
		itemVendaRepository.deleteAll(itensVenda);
		vendaRepository.delete(venda);
	}

	private void validarProdutoExisteEDevolverEstoque(List<ItemVenda> itensVenda) {
		itensVenda.forEach(item -> {
			if (item.getVeiculo() == null) {
				Produto produto = produtoService.buscarProduto(item.getProduto().getId());
				produto.getCaracteristicas()
						.setQuantidade(produto.getCaracteristicas().getQuantidade() + item.getQuantidade());
				produtoService.atualizarProduto(produto, produto.getId());
			}
			if (item.getProduto() == null) {
				Veiculo veiculo = veiculoService.buscar(item.getVeiculo().getId());
				veiculo.setQuantidade(veiculo.getQuantidade() + item.getQuantidade());
				veiculoService.atualizar(veiculo, veiculo.getId());
			}
		});
	}

}
