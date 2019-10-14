package dao;

import java.util.List;

import exception.DaoException;
import model.Viagem;

public interface IDaoViagem {

	public void salvarViagem(Viagem viagem) throws DaoException;
	public Viagem editarViagem(Viagem viagem) throws DaoException;
	public Viagem buscarViagemId(int id) throws DaoException;
	public Viagem buscarCidade(String cidade);
	public Viagem buscarCargaViagem(String carga);
	public List<Viagem> buscaAll(String i);

}
