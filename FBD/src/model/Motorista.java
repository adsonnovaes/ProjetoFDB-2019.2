package model;

public class Motorista extends Pessoa{
	
	
	int id;
	
	Endereco end;
	int identidade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Endereco getEnd() {
		return end;
	}
	public void setEnd(Endereco end) {
		this.end = end;
	}
	public int getIdentidade() {
		return identidade;
	}
	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}
	

}
