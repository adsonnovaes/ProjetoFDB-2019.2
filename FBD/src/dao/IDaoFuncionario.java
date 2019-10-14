package dao;

import exception.DaoException;
import model.Funcionario;

public interface IDaoFuncionario {

	public void SalvarFuncionario(Funcionario funcionario) throws DaoException;
	public void EditarFuncionario(Funcionario funcionario) throws DaoException;
	public Funcionario BuscarFuncionarioID(int id) throws DaoException;

}
