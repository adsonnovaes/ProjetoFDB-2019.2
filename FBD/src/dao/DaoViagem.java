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
import model.Viagem;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoViagem implements IDaoViagem{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;

	@Override
	public void salvarViagem(Viagem viagem) throws DaoException {

		try {

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Viagem.INSERT_ALL);

            statement.setDate(1,viagem.getData_saida());
            statement.setDate(2, viagem.getData_chegada());
            statement.setString(3, viagem.getStatus());
            statement.setString(4, viagem.getDescricao());
            statement.setInt(5, viagem.getId_motorista());
            statement.setInt(6, viagem.getId_veiculo());
            statement.setInt(7, viagem.getId_rota());
            statement.setInt(8, viagem.getId_carga());


            statement.execute();

            this.conexao.close();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar a viagem.");
        }


	}

	@Override
	public Viagem editarViagem(Viagem viagem) throws DaoException {
		return null;
	}

	@Override
	public Viagem buscarViagemId(int id) throws DaoException {
		Viagem viagem = new Viagem();


		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Viagem.GET);
			statement.setInt(1, id);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){

				viagem.setId(rs.getInt("id_viagem"));
				viagem.setStatus((rs.getString("status")));
				viagem.setId_motorista((rs.getInt("motorista_id_motorista")));
				viagem.setId_veiculo((rs.getInt("veiculo_id_veiculo")));
				viagem.setId_rota((rs.getInt("rota_id_rota")));
				viagem.setId_carga((rs.getInt("carga_id_carga")));
				viagem.setData_saida((rs.getDate("data_saida")));
				viagem.setData_chegada(rs.getDate("data_chegada"));
				viagem.setDescricao(rs.getString("descricao"));

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return viagem;
	}


	@Override
	public void DeleteViagem(int id) {
        try {

        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Viagem.DELETE);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void UpdateViagem(Viagem i) {

        try {
        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Viagem.UPDATE);

            statement.setDate(1,i.getData_saida());
            statement.setDate(2, i.getData_chegada());
            statement.setString(3, i.getStatus());
            statement.setString(4, i.getDescricao());
            statement.setInt(5, i.getId_motorista());
            statement.setInt(6, i.getId_veiculo());
            statement.setInt(7, i.getId_rota());
            statement.setInt(8, i.getId_carga());
            statement.setInt(9, i.getId());

	        statement.execute();

	        this.conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ObservableList<Viagem> getAllViagem() {
		List<Viagem> viagens = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Viagem.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){

				Viagem viagem = new Viagem();

				viagem.setId(rs.getInt("id_viagem"));
				viagem.setStatus((rs.getString("status")));
				viagem.setId_motorista((rs.getInt("motorista_id_motorista")));
				viagem.setId_veiculo((rs.getInt("veiculo_id_veiculo")));
				viagem.setId_rota((rs.getInt("rota_id_rota")));
				viagem.setId_carga((rs.getInt("carga_id_carga")));
				viagem.setData_saida((rs.getDate("data_saida")));
				viagem.setData_chegada(rs.getDate("data_chegada"));
				viagem.setDescricao(rs.getString("descricao"));
				viagens.add(viagem);
		}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Viagem> obs = FXCollections.observableList(viagens);
		return obs;
	}



}
