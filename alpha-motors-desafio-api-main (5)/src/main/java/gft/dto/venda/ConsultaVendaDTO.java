package gft.dto.venda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ConsultaVendaDTO {

	private String cliente;

	private String funcionario;

	private Long codigo;

	private LocalDate data;

	private BigDecimal valorTotal;

	private List<ConsultaItemVendaDTO> itemVendaDTOs;

	public ConsultaVendaDTO() {
	}

	public ConsultaVendaDTO(String cliente, String funcionario, Long codigo, LocalDate data, BigDecimal valorTotal,
			List<ConsultaItemVendaDTO> itemVendaDTOs) {
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.codigo = codigo;
		this.data = data;
		this.valorTotal = valorTotal;
		this.itemVendaDTOs = itemVendaDTOs;
	}

	public ConsultaVendaDTO(String cliente, Long codigo, LocalDate data, BigDecimal valorTotal,
			List<ConsultaItemVendaDTO> itemVendaDTOs) {
		this.cliente = cliente;
		this.codigo = codigo;
		this.data = data;
		this.valorTotal = valorTotal;
		this.itemVendaDTOs = itemVendaDTOs;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public List<ConsultaItemVendaDTO> getItemVendaDTOs() {
		return itemVendaDTOs;
	}

	public void setItemVendaDTOs(List<ConsultaItemVendaDTO> itemVendaDTOs) {
		this.itemVendaDTOs = itemVendaDTOs;
	}

}
