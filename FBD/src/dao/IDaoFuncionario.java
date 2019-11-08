package dao;

import exception.DaoException;
import javafx.collections.ObservableList;
import model.Funcionario;

public interface IDaoFuncionario {

	public void SalvarFuncionario(Funcionario funcionario) throws DaoException;
	public Funcionario EditarFuncionario(Funcionario funcionario) throws DaoException;
	public Funcionario BuscarFuncionarioID(int id) throws DaoException;
	public boolean BuscarFuncionarioRg(int rg) throws DaoException;
	public void DeleteFuncionario(int id);
	public void UpdateFuncionario(Funcionario i);
	public ObservableList<Funcionario> getAllFuncionarios();

}
