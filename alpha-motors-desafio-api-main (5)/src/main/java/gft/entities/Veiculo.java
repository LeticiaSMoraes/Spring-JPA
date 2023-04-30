package gft.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import gft.entities.enumVeiculo.Cor;
import gft.entities.enumVeiculo.Modelo;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca = "Alpha Motors";

	@Enumerated(value = EnumType.STRING)
	private Modelo modelo;

	private String ano;

	@Enumerated(value = EnumType.STRING)
	private Cor cor;

	private String descricao;

	private int quantidade = 0;

	@JoinColumn(name = "preco_custo")
	private BigDecimal precoCusto;

	@JoinColumn(name = "preco_venda")
	private BigDecimal precoVenda;

	public Veiculo() {

	}

	public Veiculo(Long id, Modelo modelo, String ano, Cor cor, String descricao, int quantidade, BigDecimal precoCusto,
			BigDecimal precoVenda) {
		this.id = id;
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
