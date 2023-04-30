package gft.dto.compra;

import java.math.BigDecimal;

public class ConsultaItemCompraDTO {

	private Long codigoProduto;
	private Integer quantidade;
	private BigDecimal valor;
	private String produto;

	public ConsultaItemCompraDTO() {
	}

	public ConsultaItemCompraDTO(Long codigoProduto, Integer quantidade, BigDecimal valor, String produto) {
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.valor = valor;
		this.produto = produto;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

}
