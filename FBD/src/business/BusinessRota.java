package business;

import java.util.List;

import dao.DaoRota;
import dao.IDaoRota;
import exception.BusinessException;
import exception.DaoException;
import model.Rota;

public class BusinessRota implements IBusinessRota{

	private IDaoRota daoRota;

	public BusinessRota(){
		daoRota = new DaoRota();

	}

	@Override
	public void salvarRota(Rota rota) throws BusinessException {
		try {
			daoRota.salvarRota(rota);
		} catch (DaoException e) {
			e.printStackTrace();
		}
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
