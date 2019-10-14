package business;

import java.util.List;

import exception.BusinessException;
import exception.DaoException;
import model.Motorista;

public class BusinessMotorista implements IBusinessMotorista{

	@Override
	public Motorista salvarMotorista(Motorista motorista) throws BusinessException {
		return null;
	}

	@Override
	public void EditarMotorista(Motorista motorista) throws DaoException {

	}

	@Override
	public Motorista buscarPorId(int id) {
		return null;
	}

	@Override
	public Motorista buscarPorCpf(String identidade) throws BusinessException {
		return null;
	}

	@Override
	public List<Motorista> buscarPorBusca(String busca) {
		return null;
	}

}
