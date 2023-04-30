package gft.dto.venda;

import java.math.BigDecimal;


public class ConsultaItemVendaDTO {

	private Integer quantidade;
	private BigDecimal valor;
	private Long codigoProduto;
	private String produto;
	
	public ConsultaItemVendaDTO() {
	}

	public ConsultaItemVendaDTO(Integer quantidade, BigDecimal valor, Long codigoProduto,
			String produto) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.codigoProduto = codigoProduto;
		this.produto = produto;
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

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long produto) {
		this.codigoProduto = produto;
	}

	public String getDescricaoProduto() {
		return produto;
	}

	public void setDescricaoProduto(String produto) {
		this.produto = produto;
	}
	
	

}
