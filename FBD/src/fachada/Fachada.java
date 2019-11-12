package fachada;

import java.util.List;

import business.BusinessCarga;
import business.BusinessFuncionario;
import business.BusinessMotorista;
import business.BusinessRota;
import business.BusinessVeiculo;
import business.BusinessViagem;
import business.IBusinessCarga;
import business.IBusinessFuncionario;
import business.IBusinessMotorista;
import business.IBusinessRota;
import business.IBusinessVeiculo;
import business.IBusinessViagem;
import dao.DaoEndereco;
import dao.IDaoEndereco;
import exception.BusinessException;
import exception.DaoException;
import model.Carga;
import model.Endereco;
import model.Funcionario;
import model.Motorista;
import model.Rota;
import model.Veiculo;
import model.Viagem;

public class Fachada implements IFachada{


	private IBusinessViagem businessViagem;
	private IBusinessCarga businessCarga;
	private IBusinessRota businessRota;
	private IBusinessVeiculo businessVeiculo;
	private IBusinessMotorista businessMotorista;
	private IBusinessFuncionario businessFuncionario;
	private IDaoEndereco daoEndereco;

	private static Fachada fachada;


	public static Fachada getInstance() {
		if (fachada == null) {
			fachada = new Fachada();
		}

	    return fachada;
	}

    private Fachada() {
        businessViagem = new BusinessViagem();
        businessCarga = new BusinessCarga();
        businessRota = new BusinessRota();
        businessVeiculo = new BusinessVeiculo();
        businessMotorista = new BusinessMotorista();
        businessFuncionario = new BusinessFuncionario();
        daoEndereco = new DaoEndereco();
    }



//	Carga
	@Override
	public void SalvarCarga(Carga carga) throws BusinessException {
		businessCarga.SalvarCarga(carga);
	}

	@Override
	public Carga EditarCarga(Carga carga) throws BusinessException {
		return null;
	}

	@Override
	public Carga BuscarCargaID(int id) throws BusinessException {
		return businessCarga.BuscarCargaID(id);
	}

	@Override
	public Carga BuscarCargaExpecifica(String carga) {
		return null;
	}

	@Override
	public List<Carga> buscaAllCarga(String i) {
		return null;
	}

//	Endereço
	@Override
	public void salvarEndereco(Endereco end) throws BusinessException {
		try {
			daoEndereco.salvarEndereco(end);
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editarEndereco(Endereco end) throws BusinessException {

	}

	@Override
	public Endereco buscarEnderecoId(int id) throws BusinessException {
		return null;
	}

	@Override
	public List<Endereco> buscaGeralEndereco(String busca) throws BusinessException {
		return null;
	}


//	Funcionario
	@Override
	public void SalvarFuncionario(Funcionario funcionario) throws BusinessException {
		this.businessFuncionario.SalvarFuncionario(funcionario);

	}

	@Override
	public void EditarFuncionario(Funcionario funcionario) throws BusinessException {
		this.businessFuncionario.EditarFuncionario(funcionario);
	}

	@Override
	public Funcionario BuscarFuncionarioID(int id) throws BusinessException {
		Funcionario busca = this.businessFuncionario.BuscarFuncionarioID(id);
		return busca;
	}

	@Override
	public boolean BuscarFuncionarioRg(int rg) throws DaoException {
		return businessFuncionario.BuscarFuncionarioRg(rg);
	}

	@Override
	public boolean ValidarLogin(String email, String senha) {
		return businessFuncionario.ValidarLogin(email, senha);
	}



//	Motorista
	@Override
	public void SalvarMotorista(Motorista motorista) throws BusinessException {
		businessMotorista.salvarMotorista(motorista);

	}

	@Override
	public Motorista EditarMotorista(Motorista motorista) throws BusinessException {
		return null;
	}

	@Override
	public Motorista BuscarMotoristaID(int id) throws BusinessException {
		return null;
	}

	@Override
	public boolean BuscarMotoristaRg(int rg) throws DaoException {
		return businessMotorista.BuscarMotoristaRg(rg);
	}

	@Override
	public Motorista buscarMotoristaIden(int rg) throws DaoException {
		return businessMotorista.buscarMotoristaIden(rg);
	}

	@Override
	public List<Motorista> buscarPorBusca(String busca) {
		return null;
	}


//	Rota
	@Override
	public void salvarRota(Rota rota) throws BusinessException {
		businessRota.salvarRota(rota);

	}

	@Override
	public Rota editarRota(Rota rota) throws BusinessException {
		return null;
	}

	@Override
	public Rota buscarRotaId(int id) throws BusinessException {
		return businessRota.buscarRotaId(id);
	}

	@Override
	public Rota buscarRotaCidade(String cidade) {
		return null;
	}

	@Override
	public List<Rota> buscaAllRota(String i) {
		return null;
	}



//	Veiculo
	@Override
	public void salvarVeiculo(Veiculo veiculo) throws BusinessException {
		businessVeiculo.salvarVeiculo(veiculo);

	}

	@Override
	public Veiculo editarVeiculo(Veiculo veiculo) throws BusinessException {
		return null;
	}

	@Override
	public Veiculo buscarVeiculoId(int id) throws BusinessException {
		return null;
	}

	@Override
	public boolean buscarVeiculoPlaca(String placa) {
		return businessVeiculo.buscarVeiculoPlaca(placa);
	}

	@Override
	public Veiculo buscarVeiculoPlacaE(String placa) {
		return businessVeiculo.buscarVeiculoPlacaE(placa);
	}

	@Override
	public List<Veiculo> buscaAllVeiculo(String i) {
		return null;
	}


//	Viagem
	@Override
	public void salvarViagem(Viagem viagem) throws BusinessException {
		businessViagem.salvarViagem(viagem);

	}

	@Override
	public Viagem editarViagem(Viagem viagem) throws BusinessException {
		return null;
	}

	@Override
	public Viagem buscarViagemId(int id) throws BusinessException {
		return null;
	}

	@Override
	public Viagem buscarCidade(String cidade) {
		return null;
	}

	@Override
	public Viagem buscarCargaViagem(String carga) {
		return null;
	}

	@Override
	public List<Viagem> buscaAllViagem(String i) {
		return null;
	}











}
