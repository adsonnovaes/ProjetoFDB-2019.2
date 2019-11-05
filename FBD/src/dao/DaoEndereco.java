package dao;

import java.sql.*;

import exception.DaoException;
import model.Endereco;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoEndereco implements IDaoEndereco{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

	@Override
	public void salvarEndereco(Endereco end) throws DaoException {

        try {

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Endereco.INSERT_ALL);

            statement.setString(1, end.getRua());
            statement.setInt(2, end.getNum_casa());
            statement.setString(3, end.getBairro());
            statement.setString(4, end.getCidade());
            statement.setString(5, end.getUf());

            statement.execute();
            this.conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar o endereço");
        }


	}


	@Override
	public void editarEndereco(Endereco end) throws DaoException {

	}

	@Override
	public void buscarEnderecoId(int id) throws DaoException {

	}


	@Override
	public int getCurrentValorTabela(String nomeTabela) throws DaoException {

        try {

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement("select id from " + nomeTabela + " order by id desc limit 1");

            result = this.statement.executeQuery();
            int id;

            if (result.next()) {
                id = result.getInt(1);

            } else {
                throw new DaoException("Não há registro nessa tabela");
            }

            this.conexao.close();
            return id;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("PROBLEMA AO CONSULTAR " + nomeTabela + " - Contate o ADM");
        }
	}



}
