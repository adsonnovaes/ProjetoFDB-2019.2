package dao;

import exception.DaoException;
import model.Endereco;

public interface IDaoEndereco {

	public int getCurrentValorTabela(String nomeTabela) throws DaoException;
	public void salvarEndereco(Endereco end) throws DaoException;
	public void editarEndereco(Endereco end) throws DaoException;
	public void buscarEnderecoId(int id) throws DaoException;

}
