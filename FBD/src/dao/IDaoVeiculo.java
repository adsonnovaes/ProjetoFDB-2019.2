package dao;

import exception.DaoException;
import javafx.collections.ObservableList;
import model.Veiculo;

public interface IDaoVeiculo {

	public void salvarVeiculo(Veiculo veiculo) throws DaoException;
	public Veiculo editarVeiculo(Veiculo veiculo) throws DaoException;
	public Veiculo buscarVeiculoId(int id) throws DaoException;
	public boolean buscarVeiculoPlaca(String placa);
	public void DeleteVeiculo(int id);
	public void UpdateVeiculo(Veiculo i);
	public ObservableList<Veiculo> getAllVeiculo();

}
