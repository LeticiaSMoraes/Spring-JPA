package gft.dto.compra;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class RegistroItemCompraDTO {

	@NotNull(message = "Produto")
	private Long codigoProduto;

	@NotNull(message = "Quantidade")
	@Min(value = 1, message = "Quantidade")
	private Integer quantidade;

	public RegistroItemCompraDTO() {
	}

	public RegistroItemCompraDTO(Long codigoProduto, Integer quantidade) {
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
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

}
