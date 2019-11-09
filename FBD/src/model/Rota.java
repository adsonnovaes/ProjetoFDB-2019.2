package model;


public class Rota {

	int id;

	private String origem;
	private String destino;
	private float kms;
	private int combustivel;
	private int tempoPrevisto;
	private String descricao;


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public float getKm() {
		return kms;
	}
	public void setKm(float km) {
		this.kms = km;
	}
	public int getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}
	public int getTempoPrevisto() {
		return tempoPrevisto;
	}
	public void setTempoPrevisto(int tempoPrevisto) {
		this.tempoPrevisto = tempoPrevisto;
	}





}
