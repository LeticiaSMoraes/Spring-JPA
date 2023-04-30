package gft.dto.venda;

import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReistroItemVendaDTO {
	
	@Enumerated
	@NotNull(message = "Categoria")
	private Categoria categoria;
	
	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;
	
	@NotNull(message = "Produto")
	private Long codigoProduto;
	
	public ReistroItemVendaDTO() {
	}
	
	

	public ReistroItemVendaDTO(Categoria categoria, Integer quantidade, Long codigoProduto) {
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.codigoProduto = codigoProduto;
	}



	public ReistroItemVendaDTO(Integer quantidade, Long codigoProduto) {
		this.quantidade = quantidade;
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Long getCodigoProduto() {
		return codigoProduto;
	}



	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}


	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	
	
	
	

}
