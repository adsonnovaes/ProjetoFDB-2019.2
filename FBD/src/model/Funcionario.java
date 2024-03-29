package model;

public class Funcionario extends Pessoa{

	int id;

	private String email;
	private String senha;
	private Endereco end;



	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ("Id:"+getId()+"\nNome:"+getNome()+"\nCPF:"+getCpf()+"\nEmail:"+getEmail());
	}






}
