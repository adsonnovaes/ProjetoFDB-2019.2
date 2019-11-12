package business;

import java.util.List;

import exception.BusinessException;
import exception.DaoException;
import model.Motorista;

public interface IBusinessMotorista {


    public void salvarMotorista(Motorista motorista) throws BusinessException;
	public void EditarMotorista(Motorista motorista) throws BusinessException;
    public Motorista buscarPorId(int id)throws BusinessException;
    public boolean BuscarMotoristaRg(int rg) throws DaoException;
	public Motorista buscarMotoristaIden(int rg) throws DaoException;
    public List<Motorista> buscarPorBusca(String busca);


}
