package business;

import java.util.List;

import dao.DaoViagem;
import dao.IDaoViagem;
import exception.BusinessException;
import exception.DaoException;
import model.Viagem;

public class BusinessViagem implements IBusinessViagem{

	private IDaoViagem daoViagem;

	public BusinessViagem(){
		this.daoViagem = new DaoViagem();

	}

	@Override
	public void salvarViagem(Viagem viagem) throws BusinessException {
		try {
			daoViagem.salvarViagem(viagem);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Viagem editarViagem(Viagem viagem) throws BusinessException {
		return null;
	}

	@Override
	public Viagem buscarViagemId(int id) throws BusinessException {
		return null;
	}

	@Override
	public Viagem buscarCidade(String cidade) {
		return null;
	}

	@Override
	public Viagem buscarCargaViagem(String carga) {
		return null;
	}

	@Override
	public List<Viagem> buscaAll(String i) {
		return null;
	}

}
