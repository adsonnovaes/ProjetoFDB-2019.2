package dao;

import java.sql.*;

import exception.DaoException;
import model.Endereco;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoEndereco implements IDaoEndereco{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;

	@Override
	public int salvarEndereco(Endereco end) throws DaoException {

        try {

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Endereco.INSERT_ALL);

            statement.setString(1, end.getRua());
            statement.setInt(2, end.getNum_casa());
            statement.setString(3, end.getBairro());
            statement.setString(4, end.getCidade());
            statement.setString(5, end.getUf());

            statement.execute();


            String sql = "SELECT MAX(id_endereco) as id FROM rotasviagens.endereco";
            PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
            this.rs = stmt.executeQuery();
            rs.next();
            int lastId = rs.getInt("id");

            this.conexao.close();
            return lastId;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar o endereço!");
        }


	}


	@Override
	public void editarEndereco(Endereco end) throws DaoException {

	}

	@Override
	public void buscarEnderecoId(int id) throws DaoException {

	}

}
