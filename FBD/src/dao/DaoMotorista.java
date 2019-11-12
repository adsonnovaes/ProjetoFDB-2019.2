package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DaoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Motorista;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoMotorista implements IDaoMotorista{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;
    private IDaoEndereco daoEnd = new DaoEndereco();

	@Override
	public void SalvarMotorista(Motorista motorista) throws DaoException {
		try {

			int id_endereco = daoEnd.salvarEndereco(motorista.getEnd());

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Motorista.INSERT_ALL);


            statement.setString(1, motorista.getNome());
            statement.setString(2, motorista.getTelefone());
            statement.setString(3, motorista.getCnh());
            statement.setString(4, motorista.getCategoriaCnh());
            statement.setString(5, motorista.getCpf());
            statement.setInt(6, motorista.getIdentidade());
            statement.setInt(7,id_endereco);

            statement.execute();

            this.conexao.close();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar o Motorista.");
        }


	}

	@Override
	public Motorista EditarMotorista(Motorista motorista) throws DaoException {
		return null;
	}

	@Override
	public Motorista BuscarMotoristaID(int id) throws DaoException {
		Motorista moto = new Motorista();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Motorista.GET);
			statement.setInt(1, id);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){

				moto.setId(rs.getInt("id_motorista"));
				moto.setNome(rs.getString("nome"));
				moto.setTelefone(rs.getString("telefone"));
				moto.setCnh(rs.getString("cnh"));
				moto.setCategoriaCnh(rs.getString("categoria_cnh"));
				moto.setCpf(rs.getString("cpf"));
				moto.setIdentidade(rs.getInt("rg"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return moto;
	}

	@Override
	public boolean BuscarMotoristaRg(int rg) throws DaoException {

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

	@Override
	public void DeleteMotorista(int id) {
        try {

        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Motorista.DELETE);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void UpdateMotorista(Motorista i) {
        try {
        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Motorista.UPDATE);

			statement.setString(1, i.getNome());
			statement.setString(2, i.getTelefone());
			statement.setString(3, i.getCnh());
			statement.setString(4, i.getCategoriaCnh());
	        statement.setString(5, i.getCpf());
	        statement.setInt(6,i.getIdentidade());
	        statement.setInt(7, i.getId());

	        statement.execute();

	        this.conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ObservableList<Motorista> getAllMotorista() {
		List<Motorista> motoristas = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Motorista.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){

				Motorista moto = new Motorista();

				moto.setId(rs.getInt("id_motorista"));
				moto.setNome(rs.getString("nome"));
				moto.setTelefone(rs.getString("telefone"));
				moto.setCnh(rs.getString("cnh"));
				moto.setCategoriaCnh(rs.getString("categoria_cnh"));
				moto.setCpf(rs.getString("cpf"));
				moto.setIdentidade(rs.getInt("rg"));
				moto.setId_endereco(rs.getInt("endereco_id"));
				motoristas.add(moto);
			}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Motorista> obs = FXCollections.observableList(motoristas);
		return obs;
	}

	@Override
	public Motorista buscarMotoristaIden(int rg) throws DaoException {
		Motorista moto = new Motorista();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Motorista.GET_RG);
			statement.setInt(1, rg);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){

				moto.setId(rs.getInt("id_motorista"));
				moto.setNome(rs.getString("nome"));
				moto.setIdentidade(rs.getInt("rg"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return moto;
	}




}
