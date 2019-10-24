package business;

import java.util.ArrayList;
import java.util.List;

import dao.DaoFuncionario;
import dao.IDaoFuncionario;
import exception.BusinessException;
import exception.DaoException;
import model.Funcionario;

public class BusinessFuncionario implements IBusinessFuncionario{

	private IDaoFuncionario daoFuncionario;

	public BusinessFuncionario(){
		this.daoFuncionario = new DaoFuncionario();
	}

	@Override
	public void SalvarFuncionario(Funcionario funcionario) throws BusinessException {
		try {

			this.daoFuncionario.SalvarFuncionario(funcionario);

		} catch (DaoException e) {
			throw new BusinessException("Erro na hora de salvar");
		}

	}

	@Override
	public void EditarFuncionario(Funcionario funcionario) throws BusinessException {

		try{
			this.daoFuncionario.EditarFuncionario(funcionario);
		}catch(Exception e){
			throw new BusinessException("Erro na hora de Editar");
		}

	}

	@Override
	public Funcionario BuscarFuncionarioID(int id) throws BusinessException {

		Funcionario busca = null;

		try {

			busca = this.daoFuncionario.BuscarFuncionarioID(id);


		} catch (DaoException e) {
			throw new BusinessException("Erro na hora de Editar");

		}

		return busca;

	}

	@Override
	public List<Funcionario> buscaGeralFuncionario(String busca) throws BusinessException {

		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		funcionarios = (ArrayList<Funcionario>) this.buscaGeralFuncionario(busca);

		return funcionarios;
	}

}
