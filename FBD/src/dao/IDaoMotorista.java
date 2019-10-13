package dao;

import exception.DaoException;
import model.Motorista;

public interface IDaoMotorista {
	
	public void SalvarMotorista(Motorista motorista) throws DaoException;
	public void EditarMotorista(Motorista motorista) throws DaoException;
	public void BuscarMotoristaID(int id) throws DaoException;
	

}
