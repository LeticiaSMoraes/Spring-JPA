package gft.dto.compra;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class RegistroCompraDTO {

	@NotNull(message = "Data")
	private LocalDate data;

	@NotNull(message = "Funcionário")
	private Long funcionarioId;

	@NotNull(message = "Cliente")
	private Long fornecedorId;

	@NotNull(message = "Itens venda")
	@Valid
	private List<RegistroItemCompraDTO> itensCompraDTO;

	public RegistroCompraDTO() {
	}

	public RegistroCompraDTO(LocalDate data, Long funcionarioId, Long fornecedorId,
			List<RegistroItemCompraDTO> itensCompraDTO) {
		this.data = data;
		this.funcionarioId = funcionarioId;
		this.fornecedorId = fornecedorId;
		this.itensCompraDTO = itensCompraDTO;
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

	public Long getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Long fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public List<RegistroItemCompraDTO> getItensCompraDTO() {
		return itensCompraDTO;
	}

	public void setItensCompraDTO(List<RegistroItemCompraDTO> itensCompraDTO) {
		this.itensCompraDTO = itensCompraDTO;
	}

}
