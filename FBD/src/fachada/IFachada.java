package fachada;

import java.util.List;

import exception.BusinessException;
import model.Carga;
import model.Cidade;
import model.Endereco;
import model.Funcionario;
import model.Motorista;
import model.Rota;
import model.Veiculo;
import model.Viagem;

public interface IFachada {

	public void SalvarCarga(Carga carga) throws BusinessException;
	public Carga EditarCarga(Carga carga) throws BusinessException;
	public Carga BuscarCargaID(int id) throws BusinessException;
	public Carga BuscarCargaExpecifica(String carga);
	public List<Carga> buscaAllCarga(String i);

	public void salvarCidade(Cidade cidade) throws BusinessException;
	public void editarCidade(Cidade cidade) throws BusinessException;
	public Cidade buscarCidadeId(int id) throws BusinessException;
	public List<Cidade> buscaGeralCidade(String busca) throws BusinessException;

	public void salvarEndereco(Endereco end) throws BusinessException;
	public void editarEndereco(Endereco end) throws BusinessException;
	public Endereco buscarEnderecoId(int id) throws BusinessException;
	public List<Endereco> buscaGeralEndereco(String busca) throws BusinessException;

	public void SalvarFuncionario(Funcionario funcionario) throws BusinessException;
	public void EditarFuncionario(Funcionario funcionario) throws BusinessException;
	public Funcionario BuscarFuncionarioID(int id) throws BusinessException;
	public List<Funcionario> buscaGeralFuncionario(String busca) throws BusinessException;

	public void SalvarMotorista(Motorista motorista) throws BusinessException;
	public Motorista EditarMotorista(Motorista motorista) throws BusinessException;
	public Motorista BuscarMotoristaID(int id) throws BusinessException;
	public Motorista BuscarMotoristaCpf(String cpf) throws BusinessException;
    public List<Motorista> buscarPorBusca(String busca);

	public void salvarRota(Rota rota) throws BusinessException;
	public Rota editarRota(Rota rota) throws BusinessException;
	public Rota buscarRotaId(int id) throws BusinessException;
	public Rota buscarRotaCidade(String cidade);
	public List<Rota> buscaAllRota(String i);

	public void salvarVeiculo(Veiculo veiculo) throws BusinessException;
	public Veiculo editarVeiculo(Veiculo veiculo) throws BusinessException;
	public Veiculo buscarVeiculoId(int id) throws BusinessException;
	public Veiculo buscarVeiculoPlaca(String placa);
	public List<Veiculo> buscaAllVeiculo(String i);

	public void salvarViagem(Viagem viagem) throws BusinessException;
	public Viagem editarViagem(Viagem viagem) throws BusinessException;
	public Viagem buscarViagemId(int id) throws BusinessException;
	public Viagem buscarCidade(String cidade);
	public Viagem buscarCargaViagem(String carga);
	public List<Viagem> buscaAllViagem(String i);




}
