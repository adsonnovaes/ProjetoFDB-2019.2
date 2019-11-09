package business;

import java.util.List;

import dao.DaoMotorista;
import dao.IDaoMotorista;
import exception.BusinessException;
import exception.DaoException;
import model.Motorista;

public class BusinessMotorista implements IBusinessMotorista{

	private IDaoMotorista daoMotorista;

	public BusinessMotorista(){

		this.daoMotorista = new DaoMotorista();

	}

	@Override
	public void salvarMotorista(Motorista motorista) throws BusinessException {

		try {
			this.daoMotorista.SalvarMotorista(motorista);
		} catch (DaoException e) {
			throw new BusinessException("Erro no processo de salvar.");
		}

	}

	@Override
	public void EditarMotorista(Motorista motorista) throws BusinessException {
		try{
			this.daoMotorista.EditarMotorista(motorista);

		}catch(Exception e){
			throw new BusinessException("Erro na hora de Editar");
		}



	}

	@Override
	public Motorista buscarPorId(int id) throws BusinessException{
		Motorista busca = null;

		try {

			busca = this.daoMotorista.BuscarMotoristaID(id);


		} catch (DaoException e) {
			throw new BusinessException("Erro!Não possível concluir a ação.");

		}

		return busca;
	}

	@Override
	public List<Motorista> buscarPorBusca(String busca) {
		return null;
	}

	@Override
	public boolean BuscarMotoristaRg(int rg) throws DaoException {
		return daoMotorista.BuscarMotoristaRg(rg);
	}

}
