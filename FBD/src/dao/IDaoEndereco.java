package dao;

import exception.DaoException;
import javafx.collections.ObservableList;
import model.Endereco;

public interface IDaoEndereco {

	public int salvarEndereco(Endereco end) throws DaoException;
	public void editarEndereco(Endereco end) throws DaoException;
	public Endereco buscarEnderecoId(int id) throws DaoException;
	public void DeleteEndereco(int id);
	public void UpdateEndereco(Endereco end);
	public ObservableList<Endereco> getAllEnderecos();

}
