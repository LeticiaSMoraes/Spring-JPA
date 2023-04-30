package gft.dto.veiculo;

import java.math.BigDecimal;

import gft.entities.enumVeiculo.Cor;
import gft.entities.enumVeiculo.Modelo;

public class ConsultaVeiculoDTO {

	private Long id;

	private String marca;

	private Modelo modelo;

	private String ano;

	private Cor cor;

	private String descricao;

	private int quantidade;

	private BigDecimal precoCusto;

	private BigDecimal precoVenda;

	public ConsultaVeiculoDTO() {

	}

	public ConsultaVeiculoDTO(Long id, String marca, Modelo modelo, String ano, Cor cor, String descricao,
			int quantidade, BigDecimal precoCusto, BigDecimal precoVenda) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

}
