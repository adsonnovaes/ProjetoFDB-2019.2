package model;

import java.sql.Date;

public class Viagem {
	
	int id;
	
	Motorista motorista;
	Rota rota;
	Cidade origem;
	Cidade destino;
	Date data_saida;
	Date data_chegada;
	Veiculo veiculo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Rota getRota() {
		return rota;
	}
	public void setRota(Rota rota) {
		this.rota = rota;
	}
	public Cidade getOrigem() {
		return origem;
	}
	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}
	public Cidade getDestino() {
		return destino;
	}
	public void setDestino(Cidade destino) {
		this.destino = destino;
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
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


}
