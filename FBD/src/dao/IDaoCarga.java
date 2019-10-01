package dao;

import exception.DaoException;
import model.Carga;

public interface IDaoCarga {
	
	public void SalvarCarga(Carga carga) throws DaoException;
	public void EditarCarga(Carga carga) throws DaoException;
	public void BuscarCargaID(int id) throws DaoException;

}
