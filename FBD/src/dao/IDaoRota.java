package dao;

import model.Rota;

public interface IDaoRota {
	
	public void salvarRota(Rota rota);
	public void editarRota(Rota rota);
	public void buscarRotaId(int id);

}
