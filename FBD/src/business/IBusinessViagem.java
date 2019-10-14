package business;

import java.util.List;

import exception.BusinessException;
import model.Viagem;

public interface IBusinessViagem {


	public void salvarViagem(Viagem viagem) throws BusinessException;
	public Viagem editarViagem(Viagem viagem) throws BusinessException;
	public Viagem buscarViagemId(int id) throws BusinessException;
	public Viagem buscarCidade(String cidade);
	public Viagem buscarCargaViagem(String carga);
	public List<Viagem> buscaAll(String i);
}
