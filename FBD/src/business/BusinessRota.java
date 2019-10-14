package business;

import java.util.List;

import exception.BusinessException;
import model.Rota;

public class BusinessRota implements IBusinessRota{

	@Override
	public void salvarRota(Rota rota) throws BusinessException {

	}

	@Override
	public Rota editarRota(Rota rota) throws BusinessException {
		return null;
	}

	@Override
	public Rota buscarRotaId(int id) throws BusinessException {
		return null;
	}

	@Override
	public Rota buscarRotaCidade(String cidade) {
		return null;
	}

	@Override
	public List<Rota> buscaAll(String i) {
		return null;
	}

}
