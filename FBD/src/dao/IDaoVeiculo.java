package dao;

import java.util.List;

import exception.DaoException;
import model.Veiculo;

public interface IDaoVeiculo {

	public void salvarVeiculo(Veiculo veiculo) throws DaoException;
	public Veiculo editarVeiculo(Veiculo veiculo) throws DaoException;
	public Veiculo buscarVeiculoId(int id) throws DaoException;
	public Veiculo buscarVeiculoPlaca(String placa);
	public List<Veiculo> buscaAll(String i);

}
