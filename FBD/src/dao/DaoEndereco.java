package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exception.DaoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


	@Override
	public ObservableList<Endereco> getAllEnderecos() {
		List<Endereco> ends = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Endereco.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){

				Endereco end = new Endereco();

				end.setId(rs.getInt("id_endereco"));
				end.setRua(rs.getString("rua"));
				end.setNum_casa(rs.getInt("num_casa"));
				end.setBairro(rs.getString("bairro"));
				end.setCidade(rs.getString("cidade"));
				end.setUf(rs.getString("uf"));

				ends.add(end);

			}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Endereco> obs = FXCollections.observableList(ends);
		return obs;
	}


	@Override
	public void DeleteEndereco(int id) {

        try {

        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Endereco.DELETE);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
