package dao;

import java.util.List;

import exception.DaoException;
import model.Motorista;

public interface IDaoMotorista {

	public void SalvarMotorista(Motorista motorista) throws DaoException;
	public Motorista EditarMotorista(Motorista motorista) throws DaoException;
	public Motorista BuscarMotoristaID(int id) throws DaoException;
	public Motorista BuscarMotoristaCpf(String cpf) throws DaoException;
    public List<Motorista> buscarPorBusca(String busca);


}
