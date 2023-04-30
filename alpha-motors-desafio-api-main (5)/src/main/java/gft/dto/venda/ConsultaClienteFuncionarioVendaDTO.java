package gft.dto.venda;

import java.util.List;

public class ConsultaClienteFuncionarioVendaDTO {
	
	private String nome;
	
	private List<ConsultaVendaDTO> consultaVendaDTOs;

	public ConsultaClienteFuncionarioVendaDTO() {
	}

	public ConsultaClienteFuncionarioVendaDTO(String nome, List<ConsultaVendaDTO> listaConsultaVendaDTO) {
		this.nome = nome;
		this.consultaVendaDTOs = listaConsultaVendaDTO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ConsultaVendaDTO> getConsultaVendaDTOs() {
		return consultaVendaDTOs;
	}

	public void setConsultaVendaDTOs(List<ConsultaVendaDTO> consultaVendaDTOs) {
		this.consultaVendaDTOs = consultaVendaDTOs;
	}



	
}
