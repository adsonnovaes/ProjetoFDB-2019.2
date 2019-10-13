package dao;

import exception.DaoException;
import model.Veiculo;

public interface IDaoVeiculo {
	
	public void salvarVeiculo(Veiculo veiculo) throws DaoException;
	public void editarVeiculo(Veiculo veiculo) throws DaoException;
	public void buscarVeiculoId(int id) throws DaoException;

}
