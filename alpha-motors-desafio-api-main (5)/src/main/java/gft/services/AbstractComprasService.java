package gft.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import gft.dto.compra.ConsultaCompraDTO;
import gft.dto.compra.ConsultaItemCompraDTO;
import gft.dto.compra.RegistroItemCompraDTO;
import gft.entities.Compra;
import gft.entities.ItemCompra;
import gft.entities.Produto;
import gft.exception.RegraNegocioException;

public abstract class AbstractComprasService {
	
	@Autowired
	private ProdutoService produtoService;
	
	protected ConsultaCompraDTO criandoConsultaCompraDto(Compra compra, List<ItemCompra> itensCompra) {
		List<ConsultaItemCompraDTO> itensCompraDto = itensCompra.stream().map(this::criandoItemCompraDto)
				.collect(Collectors.toList());
		return new ConsultaCompraDTO(compra.getCodigo(), compra.getFuncionario().getNome(),
				compra.getFornecedor().getRazaoSocial(), compra.getData(), compra.getValorTotal(), itensCompraDto);
	}

	protected ConsultaCompraDTO criandoConsultaCompraDtoFornecedor(Compra compra, List<ItemCompra> itensCompra) {
		List<ConsultaItemCompraDTO> itensCompraDto = itensCompra.stream().map(this::criandoItemCompraDto)
				.collect(Collectors.toList());
		return new ConsultaCompraDTO(compra.getCodigo(), compra.getFuncionario().getNome(), compra.getData(),
				compra.getValorTotal(), itensCompraDto);
	}

	protected ConsultaItemCompraDTO criandoItemCompraDto(ItemCompra itemCompra) {
		return new ConsultaItemCompraDTO(itemCompra.getProduto().getId(), itemCompra.getQuantidade(),
				itemCompra.getValor(), itemCompra.getProduto().getNome());
	}

	protected ItemCompra criandoItemCompra(Compra compra, RegistroItemCompraDTO itemCompraDto) {
		Produto produto = produtoService.buscarProduto(itemCompraDto.getCodigoProduto());
		atualizarValorTotal(produto, compra, itemCompraDto);
		atualizarEstoqueProduto(produto, itemCompraDto);
		return new ItemCompra(itemCompraDto.getQuantidade(), produto.getCaracteristicas().getPrecoCusto(), produto,
				compra);
	}

	private void atualizarValorTotal(Produto produto, Compra compra, RegistroItemCompraDTO itemCompraDto) {
		BigDecimal valor = compra.getValorTotal();
		BigDecimal quantidade = new BigDecimal(itemCompraDto.getQuantidade());
		BigDecimal novoValor = valor.add(quantidade.multiply(produto.getCaracteristicas().getPrecoCusto()));
		compra.setValorTotal(novoValor);
	}
	
	private void atualizarEstoqueProduto(Produto produto, RegistroItemCompraDTO itemCompraDto) {
		if (itemCompraDto.getQuantidade() > produto.getCaracteristicas().getQuantidade()) {
			throw new RegraNegocioException(String
					.format("Quantidade solicitada do item %s é maior que o estoque atual", produto.getNome()));
		} else {
			produto.getCaracteristicas()
					.setQuantidade(produto.getCaracteristicas().getQuantidade() - itemCompraDto.getQuantidade());
			produtoService.atualizarProduto(produto, produto.getId());
		}
	}
	
}
