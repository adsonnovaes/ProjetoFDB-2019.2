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
	public void EditarCarga(Carga carga) throws BusinessException;
	public void BuscarCargaID(int id) throws BusinessException;
	public List<Carga> buscaGeralCarga(String busca) throws BusinessException;
	
	public void salvarCidade(Cidade cidade) throws BusinessException;
	public void editarCidade(Cidade cidade) throws BusinessException;
	public void buscarCidadeId(int id) throws BusinessException;
	public List<Cidade> buscaGeralCidade(String busca) throws BusinessException;
	
	public void salvarEndereco(Endereco end) throws BusinessException;
	public void editarEndereco(Endereco end) throws BusinessException;
	public void buscarEnderecoId(int id) throws BusinessException;
	public List<Endereco> buscaGeralEndereco(String busca) throws BusinessException;
	
	public void SalvarFuncionario(Funcionario funcionario) throws BusinessException;
	public void EditarFuncionario(Funcionario funcionario) throws BusinessException;
	public void BuscarFuncionarioID(int id) throws BusinessException;
	public List<Funcionario> buscaGeralFuncionario(String busca) throws BusinessException;
	
	public void SalvarMotorista(Motorista motorista) throws BusinessException;
	public void EditarMotorista(Motorista motorista) throws BusinessException;
	public void BuscarMotoristaID(int id) throws BusinessException;
	public List<Motorista> buscaGeralMotorista(String busca) throws BusinessException;
	
	public void salvarRota(Rota rota) throws BusinessException;
	public void editarRota(Rota rota) throws BusinessException;
	public void buscarRotaId(int id) throws BusinessException;
	public List<Rota> buscaGeralRota(String busca) throws BusinessException;
	
	public void salvarVeiculo(Veiculo veiculo) throws BusinessException;
	public void editarVeiculo(Veiculo veiculo) throws BusinessException;
	public void buscarVeiculoId(int id) throws BusinessException;
	public List<Veiculo> buscaGeralVeiculo(String busca) throws BusinessException;
	
	public void salvarViagem(Viagem viagem) throws BusinessException;
	public void editarViagem(Viagem viagem) throws BusinessException;
	public void buscarViagemId(int id) throws BusinessException;
	public List<Viagem> buscaGeralViagem(String busca) throws BusinessException;
	

}
