package model;

public abstract class Pessoa {


	String nome;
	String cpf;
	Endereco end;
	int identidade;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
