package dao;

import java.util.List;

import exception.DaoException;
import model.Rota;

public interface IDaoRota {

	public void salvarRota(Rota rota) throws DaoException;
	public Rota editarRota(Rota rota) throws DaoException;
	public Rota buscarRotaId(int id) throws DaoException;
	public Rota buscarRotaCidade(String cidade);
	public List<Rota> buscaAll(String i);

}
