package gft.dto.compra;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ConsultaCompraDTO {

	private Long codigoCompra;

	private String funcionario;

	private String fornecedor;

	private LocalDate data;

	private BigDecimal valorTotal;

	private List<ConsultaItemCompraDTO> itemCompraDTOs;

	public ConsultaCompraDTO() {
	}

	public ConsultaCompraDTO(Long codigoCompra, String funcionario, LocalDate data, BigDecimal valorTotal,
			List<ConsultaItemCompraDTO> itemCompraDTOs) {
		this.codigoCompra = codigoCompra;
		this.funcionario = funcionario;
		this.data = data;
		this.valorTotal = valorTotal;
		this.itemCompraDTOs = itemCompraDTOs;
	}

	public ConsultaCompraDTO(Long codigoCompra, String funcionario, String fornecedor, LocalDate data, BigDecimal valorTotal,
			List<ConsultaItemCompraDTO> itemCompraDTOs) {
		this.codigoCompra = codigoCompra;
		this.funcionario = funcionario;
		this.fornecedor = fornecedor;
		this.data = data;
		this.valorTotal = valorTotal;
		this.itemCompraDTOs = itemCompraDTOs;
	}

	public Long getCodigoCompra() {
		return codigoCompra;
	}

	public void setCodigoCompra(Long codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ConsultaItemCompraDTO> getItemCompraDTOs() {
		return itemCompraDTOs;
	}

	public void setItemCompraDTOs(List<ConsultaItemCompraDTO> itemCompraDTOs) {
		this.itemCompraDTOs = itemCompraDTOs;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

}
