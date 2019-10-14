package business;

import java.util.List;

import exception.BusinessException;
import model.Veiculo;

public class BusinessVeiculo implements IBusinessVeiculo{

	@Override
	public void salvarVeiculo(Veiculo veiculo) throws BusinessException {

	}

	@Override
	public Veiculo editarVeiculo(Veiculo veiculo) throws BusinessException {
		return null;
	}

	@Override
	public Veiculo buscarVeiculoId(int id) throws BusinessException {
		return null;
	}

	@Override
	public Veiculo buscarVeiculoPlaca(String placa) {
		return null;
	}

	@Override
	public List<Veiculo> buscaAll(String i) {
		return null;
	}

}
