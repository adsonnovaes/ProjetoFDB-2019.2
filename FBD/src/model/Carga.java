package model;

import java.sql.Date;

public class Carga {

	int id;

	String tipo;
	int quantidadeUni;
	float pesoTotal;
	float valorTotal;
	Date fabricacao;
	Date validade;
	String descricao;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getQuantidadeUni() {
		return quantidadeUni;
	}
	public void setQuantidadeUni(int quantidadeUni) {
		this.quantidadeUni = quantidadeUni;
	}
	public float getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public Date getFabricacao() {
		return fabricacao;
	}
	public void setFabricacao(Date fabricacao) {
		this.fabricacao = fabricacao;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}





}
