package dao;

import exception.DaoException;
import javafx.collections.ObservableList;
import model.Carga;

public interface IDaoCarga {

	public void SalvarCarga(Carga carga) throws DaoException;
	public Carga EditarCarga(Carga carga) throws DaoException;
	public Carga BuscarCargaID(int id) throws DaoException;
	public void DeleteCarga(int id);
	public void UpdateCarga(Carga i);
	public ObservableList<Carga> getAllCarga();

}
