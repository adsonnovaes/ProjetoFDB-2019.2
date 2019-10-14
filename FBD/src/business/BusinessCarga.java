package business;

import java.util.List;

import exception.BusinessException;
import model.Carga;

public class BusinessCarga implements IBusinessCarga{

	@Override
	public void SalvarCarga(Carga carga) throws BusinessException {

	}

	@Override
	public Carga EditarCarga(Carga carga) throws BusinessException {
		return null;
	}

	@Override
	public Carga BuscarCargaID(int id) throws BusinessException {
		return null;
	}

	@Override
	public Carga BuscarCargaExpecifica(String carga) {
		return null;
	}

	@Override
	public List<Carga> buscaAll(String i) {
		return null;
	}

}
