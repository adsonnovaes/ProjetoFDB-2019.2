package dao;

import exception.DaoException;
import javafx.collections.ObservableList;
import model.Viagem;

public interface IDaoViagem {

	public void salvarViagem(Viagem viagem) throws DaoException;
	public Viagem editarViagem(Viagem viagem) throws DaoException;
	public Viagem buscarViagemId(int id) throws DaoException;
	public void DeleteViagem(int id);
	public void UpdateViagem(Viagem i);
	public ObservableList<Viagem> getAllViagem();

}
