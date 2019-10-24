package business;

import java.util.List;

import exception.BusinessException;
import model.Funcionario;

public interface IBusinessFuncionario {

	public void SalvarFuncionario(Funcionario funcionario) throws BusinessException;
	public void EditarFuncionario(Funcionario funcionario) throws BusinessException;
	public Funcionario BuscarFuncionarioID(int id) throws BusinessException;
	public List<Funcionario> buscaGeralFuncionario(String busca) throws BusinessException;

}
