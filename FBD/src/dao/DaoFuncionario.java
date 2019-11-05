package dao;

import java.sql.*;
import java.util.List;

import exception.DaoException;
import model.Funcionario;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoFuncionario implements IDaoFuncionario{

    private Connection conexao;
    private PreparedStatement statement;
    private IDaoEndereco daoEnd = new DaoEndereco();

	@Override
	public void SalvarFuncionario(Funcionario funcionario) throws DaoException {

		try {
			int id_endereco = daoEnd.salvarEndereco(funcionario.getEnd());

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Funcioario.INSERT_ALL);


            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCpf());
            statement.setInt(3, funcionario.getIdentidade());
            statement.setString(4, funcionario.getEmail());
            statement.setString(5, funcionario.getSenha());
            statement.setInt(6,id_endereco);

            statement.execute();

            this.conexao.close();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar o funcionario");
        }


	}

	@Override
	public Funcionario EditarFuncionario(Funcionario funcionario) throws DaoException {
		return null;
	}

	@Override
	public Funcionario BuscarFuncionarioID(int id) throws DaoException {
		return null;
	}

	@Override
	public List<Funcionario> buscaGeralFuncionario(String i) {
		return null;
	}





}
