package business;

import exception.BusinessException;
import exception.DaoException;
import model.Funcionario;

public interface IBusinessFuncionario {

	public void SalvarFuncionario(Funcionario funcionario) throws BusinessException;
	public void EditarFuncionario(Funcionario funcionario) throws BusinessException;
	public Funcionario BuscarFuncionarioID(int id) throws BusinessException;
	public boolean BuscarFuncionarioRg(int rg) throws DaoException;
}
