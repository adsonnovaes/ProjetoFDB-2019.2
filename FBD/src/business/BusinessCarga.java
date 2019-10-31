package business;

import java.util.ArrayList;
import java.util.List;

import dao.DaoCarga;
import dao.IDaoCarga;
import exception.BusinessException;
import exception.DaoException;
import model.Carga;

public class BusinessCarga implements IBusinessCarga{

	private IDaoCarga daoCarga;

	public BusinessCarga(){
		this.daoCarga = new DaoCarga();
	}

	@Override
	public void SalvarCarga(Carga carga) throws BusinessException {
		try {
			this.daoCarga.SalvarCarga(carga);
		} catch (DaoException e) {
			throw new BusinessException("Erro na hora de salvar carga!");
		}
	}

	@Override
	public Carga EditarCarga(Carga carga) throws BusinessException {

		try {
			this.daoCarga.EditarCarga(carga);
		} catch (DaoException e) {
			throw new BusinessException("Erro! Não foi possível editar.");
		}


		return null;
	}

	@Override
	public Carga BuscarCargaID(int id) throws BusinessException {
		Carga busca = null;

		try {

			busca = this.daoCarga.BuscarCargaID(id);


		} catch (DaoException e) {
			throw new BusinessException("Erro!Não possível concluir a ação.");

		}

		return busca;
	}

	@Override
	public Carga BuscarCargaExpecifica(String carga) throws BusinessException{
		Carga busca = null;

		try {

			busca = this.daoCarga.BuscarCargaExpecifica(carga);


		} catch (Exception e) {
			throw new BusinessException("Erro!Não possível concluir a ação.");
		}

		return busca;
	}

	@Override
	public List<Carga> buscaAll(String i) throws BusinessException{
		ArrayList<Carga> cargas = new ArrayList<>();

		cargas = (ArrayList<Carga>) this.buscaAll(i);

		return cargas;
	}

}
