package gft.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gft.dto.compra.ConsultaCompraDTO;
import gft.dto.compra.ConsultaFornecedorCompraDTO;
import gft.dto.compra.RegistroCompraDTO;
import gft.dto.compra.RegistroItemCompraDTO;
import gft.entities.Compra;
import gft.entities.Fornecedor;
import gft.entities.Funcionario;
import gft.entities.ItemCompra;
import gft.entities.Produto;
import gft.exception.RegraNegocioException;
import gft.repositories.CompraRepository;
import gft.repositories.ItemCompraRepository;

@Service
public class CompraService extends AbstractComprasService {

	private CompraRepository compraRepository;
	private ItemCompraRepository itemCompraRepository;
	private FornecedorService fornecedorService;
	private FuncionarioService funcionarioService;
	private ProdutoService produtoService;

	@Autowired
	public CompraService(CompraRepository compraRepository, ItemCompraRepository itemCompraRepository,
			FornecedorService fornecedorService, FuncionarioService funcionarioService, ProdutoService produtoService) {
		this.compraRepository = compraRepository;
		this.itemCompraRepository = itemCompraRepository;
		this.fornecedorService = fornecedorService;
		this.funcionarioService = funcionarioService;
		this.produtoService = produtoService;
	}

	public List<ConsultaCompraDTO> listarTodasAsCompras() {
		List<ConsultaCompraDTO> consultaCompraDto = compraRepository.findAll().stream().map(
				compra -> criandoConsultaCompraDto(compra, itemCompraRepository.findByCompraCodigo(compra.getCodigo())))
				.collect(Collectors.toList());
		return consultaCompraDto;
	}

	public ConsultaFornecedorCompraDTO listarComprasPorFornecedor(Long idFornecedor) {
		Fornecedor fornecedor = fornecedorService.buscar(idFornecedor);
		List<ConsultaCompraDTO> consultaFornecedorCompraDTOs = compraRepository.findByFornecedorId(idFornecedor)
				.stream().map(compra -> criandoConsultaCompraDtoFornecedor(compra,
						itemCompraRepository.findByCompraCodigo(compra.getCodigo())))
				.collect(Collectors.toList());
		return new ConsultaFornecedorCompraDTO(fornecedor.getRazaoSocial(), consultaFornecedorCompraDTOs);
	}

	public ConsultaFornecedorCompraDTO listarPorCodigo(Long codigoCompra) {
		Compra compra = validarCompraExiste(codigoCompra);
		return new ConsultaFornecedorCompraDTO(compra.getFornecedor().getRazaoSocial(), Arrays
				.asList(criandoConsultaCompraDto(compra, itemCompraRepository.findByCompraCodigo(compra.getCodigo()))));
	}

	public ConsultaCompraDTO salvar(RegistroCompraDTO compraDto) {
		Fornecedor fornecedor = validarFornecedorExiste(compraDto.getFornecedorId());
		Funcionario funcionario = validarFuncionarioExiste(compraDto.getFuncionarioId());
		validarProdutoExisteESePertenceFornecedor(fornecedor, compraDto.getItensCompraDTO());
		Compra compraSalva = salvarCompra(fornecedor, funcionario, compraDto);
		return criandoConsultaCompraDtoFornecedor(compraSalva,
				itemCompraRepository.findByCompraCodigo(compraSalva.getCodigo()));
	}

	public Compra salvarCompra(Fornecedor fornecedor, Funcionario funcionario, RegistroCompraDTO compraDto) {
		Compra compraSalva = compraRepository.save(new Compra(compraDto.getData(), funcionario, fornecedor));
		compraDto.getItensCompraDTO().stream().map(item -> criandoItemCompra(compraSalva, item))
				.forEach(itemCompraRepository::save);
		return compraSalva;
	}

	public void deletar(Long codigoCompra) {
		Compra compra = validarCompraExiste(codigoCompra);
		List<ItemCompra> itensCompra = itemCompraRepository.findByCompraCodigo(codigoCompra);
		validarProdutoExisteEDevolverEstoque(itensCompra);
		itemCompraRepository.deleteAll(itensCompra);
		compraRepository.delete(compra);
	}

	private void validarProdutoExisteEDevolverEstoque(List<ItemCompra> itensCompra) {
		itensCompra.forEach(item -> {
			Produto produto = produtoService.buscarProduto(item.getProduto().getId());
			produto.getCaracteristicas()
					.setQuantidade(produto.getCaracteristicas().getQuantidade() + item.getQuantidade());
			produtoService.atualizarProduto(produto, produto.getId());
		});
	}

	private Compra validarCompraExiste(Long codigoCompra) {
		Optional<Compra> compra = compraRepository.findById(codigoCompra);
		if (compra.isEmpty()) {
			throw new RegraNegocioException(String.format("Compra de código %s não existe", codigoCompra));
		}
		return compra.get();
	}

	private Fornecedor validarFornecedorExiste(Long idFornecedor) {
		Fornecedor fornecedor = fornecedorService.buscar(idFornecedor);
		return fornecedor;
	}

	private Funcionario validarFuncionarioExiste(Long idFuncionario) {
		Funcionario funcionario = funcionarioService.buscar(idFuncionario);
		return funcionario;
	}

	private void validarProdutoExisteESePertenceFornecedor(Fornecedor fornecedor,
			List<RegistroItemCompraDTO> itensCompraDTO) {
		itensCompraDTO.forEach(item -> {
			Produto produto = produtoService.buscarProduto(item.getCodigoProduto());
			if (!produto.getCaracteristicas().getFornecedor().getId().equals(fornecedor.getId())) {
				throw new RegraNegocioException(String.format(
						"O item %s não é um produto do fornecedor escolhido. Escolha um novo item, ou mude o fornecedor",
						produto.getNome()));
			}
		});
	}

}
