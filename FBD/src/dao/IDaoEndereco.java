package dao;

import model.Endereco;

public interface IDaoEndereco {
	
	public void salvarEndereco(Endereco end);
	public void editarEndereco(Endereco end);
	public void buscarEnderecoId(int id);

}
