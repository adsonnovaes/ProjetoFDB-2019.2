package dao;

import model.Viagem;

public interface IDaoViagem {
	
	public void salvarViagem(Viagem viagem);
	public void editarViagem(Viagem viagem);
	public void buscarViagemId(int id);

}
