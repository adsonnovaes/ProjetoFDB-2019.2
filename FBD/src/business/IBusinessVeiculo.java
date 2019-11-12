package business;

import java.util.List;

import exception.BusinessException;
import model.Veiculo;

public interface IBusinessVeiculo {

	public void salvarVeiculo(Veiculo veiculo) throws BusinessException;
	public Veiculo editarVeiculo(Veiculo veiculo) throws BusinessException;
	public Veiculo buscarVeiculoId(int id) throws BusinessException;
	public Veiculo buscarVeiculoPlacaE(String placa);
	public boolean buscarVeiculoPlaca(String placa);
	public List<Veiculo> buscaAll(String i);

}
