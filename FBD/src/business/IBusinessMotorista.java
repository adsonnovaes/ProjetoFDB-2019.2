package business;

import java.util.List;

import exception.BusinessException;
import exception.DaoException;
import model.Motorista;

public interface IBusinessMotorista {


    public Motorista salvarMotorista(Motorista motorista) throws BusinessException;
	public void EditarMotorista(Motorista motorista) throws DaoException;
    public Motorista buscarPorId(int id);
    public Motorista buscarPorCpf(String identidade) throws BusinessException;
    public List<Motorista> buscarPorBusca(String busca);


}
