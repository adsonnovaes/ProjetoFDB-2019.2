package dao;

import java.util.List;

import exception.DaoException;
import model.Carga;

public interface IDaoCarga {

	public void SalvarCarga(Carga carga) throws DaoException;
	public Carga EditarCarga(Carga carga) throws DaoException;
	public Carga BuscarCargaID(int id) throws DaoException;
	public Carga BuscarCargaExpecifica(String carga);
	public List<Carga> buscaAll(String i);

}
