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
import model.Rota;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoRota implements IDaoRota{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;

	@Override
	public void salvarRota(Rota rota) throws DaoException {
		try {

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Rota.INSERT_ALL);


            statement.setString(1, rota.getOrigem());
            statement.setString(2, rota.getDestino());
            statement.setFloat(3, rota.getKm());
            statement.setInt(4, rota.getCombustivel());
            statement.setInt(5,rota.getTempoPrevisto());
            statement.setString(6,rota.getDescricao());

            statement.execute();

            this.conexao.close();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar o Rota.");
        }


	}

	@Override
	public Rota editarRota(Rota rota) throws DaoException {
		return null;
	}

	@Override
	public Rota buscarRotaId(int id) throws DaoException {
		Rota rota = new Rota();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Rota.GET);
			statement.setInt(1, id);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){

				rota.setId(rs.getInt("id_rota"));
				rota.setDestino(rs.getString("destino"));
				rota.setOrigem(rs.getString("origem"));
				rota.setKm(rs.getFloat("kms"));
				rota.setCombustivel(rs.getInt("combustivel"));
				rota.setTempoPrevisto(rs.getInt("tempo_previsto"));
				rota.setDescricao(rs.getString("descricao"));

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rota;
	}

	@Override
	public Rota buscarRotaCidade(String cidade) {
		return null;
	}

	@Override
	public void DeleteRota(int id) {
        try {

        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Rota.DELETE);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void UpdateRota(Rota i) {

		  try {

	        	this.conexao = SqlConnection.creatConnection();
				this.statement = conexao.prepareStatement(SqlUtil.Rota.UPDATE);

	            statement.setString(1, i.getOrigem());
	            statement.setString(2, i.getDestino());
	            statement.setFloat(3, i.getKm());
	            statement.setInt(4, i.getCombustivel());
	            statement.setInt(5,i.getTempoPrevisto());
	            statement.setString(6, i.getDescricao());

	            statement.setInt(7, i.getId());


		        statement.execute();
		        this.conexao.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

	@Override
	public ObservableList<Rota> getAllRota() {
		List<Rota> rotas = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Rota.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){

				Rota rota = new Rota();

				rota.setId(rs.getInt("id_rota"));
				rota.setDestino(rs.getString("destino"));
				rota.setOrigem(rs.getString("origem"));
				rota.setKm(rs.getFloat("kms"));
				rota.setCombustivel(rs.getInt("combustivel"));
				rota.setTempoPrevisto(rs.getInt("tempo_previsto"));
				rota.setDescricao(rs.getString("descricao"));

				rotas.add(rota);
			}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Rota> obs = FXCollections.observableList(rotas);
		return obs;
	}




}
