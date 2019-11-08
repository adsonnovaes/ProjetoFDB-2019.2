package business;

import java.util.List;

import dao.DaoVeiculo;
import dao.IDaoVeiculo;
import exception.BusinessException;
import exception.DaoException;
import model.Veiculo;

public class BusinessVeiculo implements IBusinessVeiculo{

	IDaoVeiculo daoVeiculo;

	public BusinessVeiculo(){
		daoVeiculo = new DaoVeiculo();
	}

	@Override
	public void salvarVeiculo(Veiculo veiculo) throws BusinessException {
		try {

			daoVeiculo.salvarVeiculo(veiculo);
		} catch (DaoException e) {
			e.printStackTrace();
		}
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
