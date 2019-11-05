package dao;

import exception.DaoException;
import model.Endereco;

public interface IDaoEndereco {

	public int salvarEndereco(Endereco end) throws DaoException;
	public void editarEndereco(Endereco end) throws DaoException;
	public void buscarEnderecoId(int id) throws DaoException;

}
