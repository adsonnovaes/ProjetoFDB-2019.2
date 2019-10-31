package business;

import java.util.List;

import exception.BusinessException;
import model.Carga;

public interface IBusinessCarga {

	public void SalvarCarga(Carga carga) throws BusinessException;
	public Carga EditarCarga(Carga carga) throws BusinessException;
	public Carga BuscarCargaID(int id) throws BusinessException;
	public Carga BuscarCargaExpecifica(String carga) throws BusinessException;
	public List<Carga> buscaAll(String i) throws BusinessException;

}
