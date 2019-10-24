package model;

public class Funcionario extends Pessoa{

	int id;

	private String email;
	private String senha;



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






}
