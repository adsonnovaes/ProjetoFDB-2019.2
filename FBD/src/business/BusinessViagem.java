package business;

import java.util.List;

import exception.BusinessException;
import model.Viagem;

public class BusinessViagem implements IBusinessViagem{

	@Override
	public void salvarViagem(Viagem viagem) throws BusinessException {

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
