package model;

import java.sql.Date;

public class Carga {
	
	int id;
	
//	Tipo tipo;
	float peso;
	int quantidade;
	Date validade;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	public Tipo getTipo() {
//		return tipo;
//	}
//	public void setTipo(Tipo tipo) {
//		this.tipo = tipo;
//	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}

	

}
