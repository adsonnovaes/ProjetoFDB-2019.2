package dao;

import exception.DaoException;
import model.Cidade;

public interface IDaoCidade {

	public void salvarCidade(Cidade cidade) throws DaoException;
	public Cidade editarCidade(Cidade cidade) throws DaoException;
	public Cidade buscarCidadeId(int id) throws DaoException;

}
