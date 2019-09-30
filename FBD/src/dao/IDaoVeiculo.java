package dao;

import model.Veiculo;

public interface IDaoVeiculo {
	
	public void salvarVeiculo(Veiculo veiculo);
	public void editarVeiculo(Veiculo veiculo);
	public void buscarVeiculoId(int id);

}
