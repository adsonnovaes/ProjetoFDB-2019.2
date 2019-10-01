package dao;

import exception.DaoException;
import model.Cidade;

public interface IDaoCidade {
	
	public void salvarCidade(Cidade cidade) throws DaoException;
	public void editarCidade(Cidade cidade) throws DaoException;
	public void buscarCidadeId(int id) throws DaoException;

}
