package dao;

import java.util.List;

import exception.DaoException;
import model.Motorista;

public class DaoMotorista implements IDaoMotorista{

	@Override
	public void SalvarMotorista(Motorista motorista) throws DaoException {

	}

	@Override
	public Motorista EditarMotorista(Motorista motorista) throws DaoException {
		return null;
	}

	@Override
	public Motorista BuscarMotoristaID(int id) throws DaoException {
		return null;
	}

	@Override
	public Motorista BuscarMotoristaCpf(String cpf) throws DaoException {
		return null;
	}

	@Override
	public List<Motorista> buscarPorBusca(String busca) {
		return null;
	}



}
