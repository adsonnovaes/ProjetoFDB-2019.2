package model;

public class Endereco {
	
	
	int id;
	
	String rua;
	int num_casa;
	String bairro;
	String ponto_referencia;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNum_casa() {
		return num_casa;
	}
	public void setNum_casa(int num_casa) {
		this.num_casa = num_casa;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getPonto_referencia() {
		return ponto_referencia;
	}
	public void setPonto_referencia(String ponto_referencia) {
		this.ponto_referencia = ponto_referencia;
	}
	
}
