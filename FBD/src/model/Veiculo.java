package model;

public class Veiculo {

	int id;

	private String placa;
	private String uf;
	private String tipoCarroceria;
	private String tipoVeiculo;
	private String modelo;
	private int ano;
	private String cor;
	private int codRenavam;
	private float kmRodado;
	private int capacidade;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTipoCarroceria() {
		return tipoCarroceria;
	}
	public void setTipoCarroceria(String tipoCarroceria) {
		this.tipoCarroceria = tipoCarroceria;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getCodRenavam() {
		return codRenavam;
	}
	public void setCodRenavam(int codRenavam) {
		this.codRenavam = codRenavam;
	}
	public float getKmRodado() {
		return kmRodado;
	}
	public void setKmRodado(float kmRodado) {
		this.kmRodado = kmRodado;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}



}
