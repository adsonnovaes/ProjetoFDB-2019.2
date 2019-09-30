package dao;

import model.Motorista;

public interface IDaoMotorista {
	
	public void SalvarMotorista(Motorista motorista);
	public void EditarMotorista(Motorista motorista);
	public void BuscarMotoristaID(int id);
	

}
