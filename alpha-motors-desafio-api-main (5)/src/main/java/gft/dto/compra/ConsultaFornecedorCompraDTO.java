package gft.dto.compra;

import java.util.List;

public class ConsultaFornecedorCompraDTO {

	private String fornecedor;

	private List<ConsultaCompraDTO> consultaCompraDtos;

	public ConsultaFornecedorCompraDTO() {
	}

	public ConsultaFornecedorCompraDTO(String fornecedor, List<ConsultaCompraDTO> consultaCompraDtos) {
		this.fornecedor = fornecedor;
		this.consultaCompraDtos = consultaCompraDtos;
	}

	public String getNome() {
		return fornecedor;
	}

	public void setNome(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<ConsultaCompraDTO> getConsultaCompraDtos() {
		return consultaCompraDtos;
	}

	public void setConsultaCompraDtos(List<ConsultaCompraDTO> consultaCompraDtos) {
		this.consultaCompraDtos = consultaCompraDtos;
	}

}
