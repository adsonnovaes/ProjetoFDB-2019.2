package model;

import java.sql.Date;

public class Viagem {

	int id;

	int id_motorista;
	int id_rota;
	int id_carga;
	int id_veiculo;
	String status;
	String descricao;

	Date data_saida;
	Date data_chegada;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_motorista() {
		return id_motorista;
	}
	public void setId_motorista(int id_motorista) {
		this.id_motorista = id_motorista;
	}
	public int getId_rota() {
		return id_rota;
	}
	public void setId_rota(int id_rota) {
		this.id_rota = id_rota;
	}
	public int getId_carga() {
		return id_carga;
	}
	public void setId_carga(int id_carga) {
		this.id_carga = id_carga;
	}
	public int getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData_saida() {
		return data_saida;
	}
	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}
	public Date getData_chegada() {
		return data_chegada;
	}
	public void setData_chegada(Date data_chegada) {
		this.data_chegada = data_chegada;
	}


}
