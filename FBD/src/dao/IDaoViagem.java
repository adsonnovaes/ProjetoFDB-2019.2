package dao;

import exception.DaoException;
import model.Viagem;

public interface IDaoViagem {
	
	public void salvarViagem(Viagem viagem) throws DaoException;
	public void editarViagem(Viagem viagem) throws DaoException;
	public void buscarViagemId(int id) throws DaoException;

}
