package dao;

import java.util.List;

import exception.DaoException;
import model.Funcionario;

public interface IDaoFuncionario {

	public void SalvarFuncionario(Funcionario funcionario) throws DaoException;
	public Funcionario EditarFuncionario(Funcionario funcionario) throws DaoException;
	public Funcionario BuscarFuncionarioID(int id) throws DaoException;
	public List<Funcionario> buscaGeralFuncionario(String i);

}
