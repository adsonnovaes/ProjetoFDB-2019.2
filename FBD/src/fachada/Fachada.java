package fachada;

import java.util.ArrayList;
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
import exception.BusinessException;
import model.Carga;
import model.Cidade;
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
    }



//	Carga
	@Override
	public void SalvarCarga(Carga carga) throws BusinessException {

	}

	@Override
	public Carga EditarCarga(Carga carga) throws BusinessException {
		return null;
	}

	@Override
	public Carga BuscarCargaID(int id) throws BusinessException {
		return null;
	}

	@Override
	public Carga BuscarCargaExpecifica(String carga) {
		return null;
	}

	@Override
	public List<Carga> buscaAllCarga(String i) {
		return null;
	}

//  Cidade

	@Override
	public void salvarCidade(Cidade cidade) throws BusinessException {

	}

	@Override
	public void editarCidade(Cidade cidade) throws BusinessException {

	}

	@Override
	public Cidade buscarCidadeId(int id) throws BusinessException {
		return null;
	}

	@Override
	public List<Cidade> buscaGeralCidade(String busca) throws BusinessException {
		return null;
	}


//	Endereço
	@Override
	public void salvarEndereco(Endereco end) throws BusinessException {

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
	public List<Funcionario> buscaGeralFuncionario(String busca) throws BusinessException {

		ArrayList<Funcionario> funcionarios = new ArrayList<>();

		funcionarios = (ArrayList<Funcionario>) this.businessFuncionario.buscaGeralFuncionario(busca);

		return funcionarios;

	}


//	Motorista
	@Override
	public void SalvarMotorista(Motorista motorista) throws BusinessException {

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
	public Motorista BuscarMotoristaCpf(String cpf) throws BusinessException {
		return null;
	}

	@Override
	public List<Motorista> buscarPorBusca(String busca) {
		return null;
	}


//	Rota
	@Override
	public void salvarRota(Rota rota) throws BusinessException {

	}

	@Override
	public Rota editarRota(Rota rota) throws BusinessException {
		return null;
	}

	@Override
	public Rota buscarRotaId(int id) throws BusinessException {
		return null;
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
	public Veiculo buscarVeiculoPlaca(String placa) {
		return null;
	}

	@Override
	public List<Veiculo> buscaAllVeiculo(String i) {
		return null;
	}


//	Viagem
	@Override
	public void salvarViagem(Viagem viagem) throws BusinessException {

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
