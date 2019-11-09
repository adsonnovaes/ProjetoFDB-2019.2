package dao;


import exception.DaoException;
import javafx.collections.ObservableList;
import model.Motorista;

public interface IDaoMotorista {

	public void SalvarMotorista(Motorista motorista) throws DaoException;
	public Motorista EditarMotorista(Motorista motorista) throws DaoException;
	public Motorista BuscarMotoristaID(int id) throws DaoException;
	public boolean BuscarMotoristaRg(int rg) throws DaoException;
	public void DeleteMotorista(int id);
	public void UpdateMotorista(Motorista i);
	public ObservableList<Motorista> getAllMotorista();


}
