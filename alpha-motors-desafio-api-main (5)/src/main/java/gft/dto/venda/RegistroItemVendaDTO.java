package gft.dto.venda;

import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RegistroItemVendaDTO {

	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;

	@Enumerated
	@NotNull(message = "Categoria")
	private Categoria categoria;

	@NotNull(message = "Produto")
	private Long codigoProduto;

	public RegistroItemVendaDTO() {
	}

	public RegistroItemVendaDTO(Integer quantidade, Categoria categoria, Long codigoProduto) {
		this.quantidade = quantidade;
		this.categoria = categoria;
		this.codigoProduto = codigoProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

}
