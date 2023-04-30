package gft.dto.venda;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RegistroVendaDTO {

	@NotNull(message = "Data")
	private LocalDate data;

	@NotNull(message = "Funcionário")
	private Long funcionarioId;

	@NotNull(message = "Cliente")
	private Long clienteId;

	@NotNull(message = "Itens venda")
	@Valid
	private List<RegistroItemVendaDTO> itensVendaDTO;

	public RegistroVendaDTO() {
	}

	public RegistroVendaDTO(LocalDate data, Long funcionarioId, Long clienteId,
			List<RegistroItemVendaDTO> itensVendaDTO) {
		this.data = data;
		this.funcionarioId = funcionarioId;
		this.clienteId = clienteId;
		this.itensVendaDTO = itensVendaDTO;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<RegistroItemVendaDTO> getItensVendaDTO() {
		return itensVendaDTO;
	}

	public void setItensVendaDTO(List<RegistroItemVendaDTO> itensVendaDTO) {
		this.itensVendaDTO = itensVendaDTO;
	}

}
