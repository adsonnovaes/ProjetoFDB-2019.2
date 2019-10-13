package dao;

import exception.DaoException;
import model.Rota;

public interface IDaoRota {
	
	public void salvarRota(Rota rota) throws DaoException;
	public void editarRota(Rota rota) throws DaoException;
	public void buscarRotaId(int id) throws DaoException;

}
