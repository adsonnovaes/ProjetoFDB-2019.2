package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exception.DaoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Funcionario;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoFuncionario implements IDaoFuncionario{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;
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

		Funcionario funcionario = new Funcionario();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Funcioario.GET);
			statement.setInt(1, id);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){

				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setIdentidade(rs.getInt("identidade"));
				funcionario.setEmail(rs.getString("email"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionario;
	}


	@Override
	public ObservableList<Funcionario> getAllFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Funcioario.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){

				Funcionario funcionario = new Funcionario();

				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setId_endereco(rs.getInt("endereco_id"));
				funcionario.setIdentidade(rs.getInt("identidade"));
				funcionario.setEmail(rs.getString("email"));
				funcionarios.add(funcionario);
			}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Funcionario> obs = FXCollections.observableList(funcionarios);
		return obs;
	}

	@Override
	public void DeleteFuncionario(int id) {

        try {

        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Funcioario.DELETE);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void UpdateFuncionario(Funcionario i) {

        try {
        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Funcioario.UPDATE);

			statement.setString(1, i.getNome());
	        statement.setString(2, i.getCpf());
	        statement.setInt(3,i.getIdentidade());
	        statement.setString(4, i.getEmail());
	        statement.setInt(5, i.getId());

	        statement.execute();

	        this.conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean BuscarFuncionarioRg(int rg) throws DaoException {

        try {
        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Validar.GET_RG);
			statement.setInt(1, rg);
			statement.setInt(2, rg);

			this.rs = statement.executeQuery();
			if(rs.next()){
				if(rs.getInt("identidade") == rg || rs.getInt("rg") == rg){
					return false;
				}

			}


		} catch (SQLException e) {
			e.printStackTrace();

		}

		return true;
	}


}
