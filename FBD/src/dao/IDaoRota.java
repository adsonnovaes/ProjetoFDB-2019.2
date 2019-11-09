package dao;

import exception.DaoException;
import javafx.collections.ObservableList;
import model.Rota;
import model.Veiculo;

public interface IDaoRota {

	public void salvarRota(Rota rota) throws DaoException;
	public Rota editarRota(Rota rota) throws DaoException;
	public Rota buscarRotaId(int id) throws DaoException;
	public Rota buscarRotaCidade(String cidade);
	public void DeleteRota(int id);
	public void UpdateRota(Rota i);
	public ObservableList<Rota> getAllRota();

}
