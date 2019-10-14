package business;

import java.util.List;

import exception.BusinessException;
import model.Rota;

public interface IBusinessRota {

	public void salvarRota(Rota rota) throws BusinessException;
	public Rota editarRota(Rota rota) throws BusinessException;
	public Rota buscarRotaId(int id) throws BusinessException;
	public Rota buscarRotaCidade(String cidade);
	public List<Rota> buscaAll(String i);

}
