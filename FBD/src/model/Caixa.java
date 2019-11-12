package model;

import java.sql.Date;

public class Caixa {

	private Date dateSaida;
	private Date dateEntrega;
	private float valorTotal;
	private String descricao;

	public Date getDateSaida() {
		return dateSaida;
	}
	public void setDateSaida(Date dateSaida) {
		this.dateSaida = dateSaida;
	}
	public Date getDateEntrega() {
		return dateEntrega;
	}
	public void setDateEntrega(Date dateEntrega) {
		this.dateEntrega = dateEntrega;
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
