package gft.dto.veiculo;

import gft.entities.enumVeiculo.Modelo;

public class BuscaPorModeloDTO {

	private Modelo modelo;
	private int quantidade;
	
	public BuscaPorModeloDTO() {
		
	}
	public BuscaPorModeloDTO(Modelo modelo, int quantidade) {
		
		this.modelo = modelo;
		this.quantidade = quantidade;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
