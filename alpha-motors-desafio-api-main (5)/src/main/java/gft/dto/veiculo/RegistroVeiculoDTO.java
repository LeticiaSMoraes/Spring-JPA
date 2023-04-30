package gft.dto.veiculo;

import java.math.BigDecimal;

import gft.entities.enumVeiculo.Cor;
import gft.entities.enumVeiculo.Modelo;

public class RegistroVeiculoDTO {

	private Modelo modelo;

	private String ano;

	private Cor cor;

	private String descricao;

	private int quantidade;

	private BigDecimal precoCusto;

	public RegistroVeiculoDTO() {

	}

	public RegistroVeiculoDTO(Modelo modelo, String ano, Cor cor, String descricao, int quantidade,
			BigDecimal precoCusto) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

}
