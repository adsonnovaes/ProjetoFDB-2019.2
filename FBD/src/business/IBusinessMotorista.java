package business;

import java.util.List;

import exception.BusinessException;
import model.Motorista;

public interface IBusinessMotorista {


    public void salvarMotorista(Motorista motorista) throws BusinessException;
	public void EditarMotorista(Motorista motorista) throws BusinessException;
    public Motorista buscarPorId(int id)throws BusinessException;
    public Motorista buscarPorCpf(String identidade) throws BusinessException;
    public List<Motorista> buscarPorBusca(String busca);


}
