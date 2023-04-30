package gft.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import gft.dto.venda.Categoria;
import gft.dto.venda.ConsultaItemVendaDTO;
import gft.dto.venda.ConsultaVendaDTO;
import gft.dto.venda.RegistroItemVendaDTO;
import gft.entities.ItemVenda;
import gft.entities.Produto;
import gft.entities.Veiculo;
import gft.entities.Venda;
import gft.exception.RegraNegocioException;

public abstract class AbstractVendasService {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private VeiculoService veiculoService;

	protected ConsultaVendaDTO criandoConsultaVendaDTO(Venda venda, List<ItemVenda> listaItensVenda) {
		List<ConsultaItemVendaDTO> consultaItemVendaDTO = listaItensVenda.stream()
				.map(this::criandoConsultaItemVendaDTO).collect(Collectors.toList());

		return new ConsultaVendaDTO(venda.getCliente().getNome(), venda.getFuncionário().getNome(), venda.getCodigo(),
				venda.getData(), venda.getValorTotal(), consultaItemVendaDTO);
	}

	protected ConsultaVendaDTO criandoConsultaVendaDTOCliente(Venda venda, List<ItemVenda> listaItensVenda) {
		List<ConsultaItemVendaDTO> consultaItemVendaDTO = listaItensVenda.stream()
				.map(this::criandoConsultaItemVendaDTO).collect(Collectors.toList());

		return new ConsultaVendaDTO(venda.getFuncionário().getNome(), venda.getCodigo(), venda.getData(),
				venda.getValorTotal(), consultaItemVendaDTO);
	}

	protected ConsultaVendaDTO criandoConsultaVendaDTOFuncionario(Venda venda, List<ItemVenda> listaItensVenda) {
		List<ConsultaItemVendaDTO> consultaItemVendaDTO = listaItensVenda.stream()
				.map(this::criandoConsultaItemVendaDTO).collect(Collectors.toList());

		return new ConsultaVendaDTO(venda.getCliente().getNome(), venda.getCodigo(), venda.getData(),
				venda.getValorTotal(), consultaItemVendaDTO);
	}

	protected ConsultaItemVendaDTO criandoConsultaItemVendaDTO(ItemVenda itemVenda) {
		if (itemVenda.getVeiculo() == null) {
			return new ConsultaItemVendaDTO(itemVenda.getQuantidade(), itemVenda.getValor(),
					itemVenda.getProduto().getId(), itemVenda.getProduto().getNome());
		}
		return new ConsultaItemVendaDTO(itemVenda.getQuantidade(), itemVenda.getValor(), itemVenda.getVeiculo().getId(),
				itemVenda.getVeiculo().getModelo().toString());
	}

	protected ItemVenda criandoItemVenda(Venda venda, RegistroItemVendaDTO itemVendaDto) {
		if (itemVendaDto.getCategoria().equals(Categoria.PRODUTO)) {
			Produto produto = produtoService.buscarProduto(itemVendaDto.getCodigoProduto());
			atualizarValorTotalProduto(produto, venda, itemVendaDto);
			atualizarEstoqueProduto(produto, itemVendaDto);
			return new ItemVenda(itemVendaDto.getQuantidade(), produto.getCaracteristicas().getPrecoVenda(), produto,
					venda);
		}
		if (itemVendaDto.getCategoria().equals(Categoria.VEICULO)) {
			Veiculo veiculo = veiculoService.buscar(itemVendaDto.getCodigoProduto());
			atualizarValorTotalVeiculo(veiculo, venda, itemVendaDto);
			atualizarEstoqueVeiculo(veiculo, itemVendaDto);
			return new ItemVenda(itemVendaDto.getQuantidade(), veiculo.getPrecoVenda(), veiculo, venda);
		}
		return null;
	}

	private void atualizarEstoqueProduto(Produto produto, RegistroItemVendaDTO itemVendaDto) {
		Integer estoqueAtual = produto.getCaracteristicas().getQuantidade();
		if (itemVendaDto.getQuantidade() > estoqueAtual) {
			throw new RegraNegocioException(
					String.format("Quantidade solicitada do item %s é maior que o estoque atual", produto.getNome()));
		}
		Integer estoqueNovo = estoqueAtual - itemVendaDto.getQuantidade();
		produto.getCaracteristicas().setQuantidade(estoqueNovo);
	}

	private void atualizarValorTotalProduto(Produto produto, Venda venda, RegistroItemVendaDTO itemVendaDto) {
		BigDecimal valor = venda.getValorTotal();
		BigDecimal quantidade = new BigDecimal(itemVendaDto.getQuantidade());
		BigDecimal novoValor = valor.add(quantidade.multiply(produto.getCaracteristicas().getPrecoVenda()));
		venda.setValorTotal(novoValor);
	}

	protected void atualizarEstoqueVeiculo(Veiculo veiculo, RegistroItemVendaDTO itemVendaDto) {
		Integer estoqueAtual = veiculo.getQuantidade();
		if (itemVendaDto.getQuantidade() > estoqueAtual) {
			throw new RegraNegocioException(
					String.format("Quantidade solicitada do item %s é maior que o estoque atual", veiculo.getModelo()));
		}
		Integer estoqueNovo = estoqueAtual - itemVendaDto.getQuantidade();
		veiculo.setQuantidade(estoqueNovo);
	}

	private void atualizarValorTotalVeiculo(Veiculo veiculo, Venda venda, RegistroItemVendaDTO itemVendaDto) {
		BigDecimal valor = venda.getValorTotal();
		BigDecimal quantidade = new BigDecimal(itemVendaDto.getQuantidade());
		BigDecimal novoValor = valor.add(quantidade.multiply(veiculo.getPrecoVenda()));
		venda.setValorTotal(novoValor);
	}
}
