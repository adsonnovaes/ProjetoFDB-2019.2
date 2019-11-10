package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.DaoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Carga;
import model.Funcionario;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoCarga implements IDaoCarga{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;

	@Override
	public void SalvarCarga(Carga carga) throws DaoException {

		try {

            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Carga.INSERT_ALL);


            statement.setString(1, carga.getTipo());
            statement.setInt(2, carga.getQuantidadeUni());
            statement.setFloat(3, carga.getPesoTotal());
            statement.setFloat(4, carga.getValorTotal());
            statement.setDate(5, carga.getFabricacao());
            statement.setDate(6,carga.getValidade());
            statement.setString(7, carga.getDescricao());

            statement.execute();

            this.conexao.close();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar a Carga.");
        }


	}

	@Override
	public Carga EditarCarga(Carga carga) throws DaoException {
		return null;
	}

	@Override
	public Carga BuscarCargaID(int id) throws DaoException {
		Carga carga = new Carga();


		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Carga.GET);
			statement.setInt(1, id);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){


				carga.setTipo(rs.getString("tipo"));
				carga.setQuantidadeUni(rs.getInt("quantidade_uni"));
				carga.setPesoTotal(rs.getFloat("peso_total"));
				carga.setValorTotal(rs.getFloat("valor_total"));
				carga.setFabricacao(rs.getDate("fabricacao"));
				carga.setValidade(rs.getDate("validade"));
				carga.setDescricao(rs.getString("descricao"));

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return carga;
	}


	@Override
	public void DeleteCarga(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateCarga(Carga i) {
		// TODO Auto-generated method stub

	}

	@Override
	public ObservableList<Carga> getAllCarga() {
		List<Carga> cargas = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Carga.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){

				Carga carga = new Carga();

				carga.setId(rs.getInt("id_carga"));
				carga.setTipo(rs.getString("tipo"));
				carga.setQuantidadeUni(rs.getInt("quantidade_uni"));
				carga.setPesoTotal(rs.getInt("peso_total"));
				carga.setValorTotal(rs.getInt("valor_total"));
				carga.setFabricacao(rs.getDate("fabricacao"));
				carga.setValidade(rs.getDate("validade"));
				carga.setDescricao(rs.getString("descricao"));
				cargas.add(carga);
			}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Carga> obs = FXCollections.observableList(cargas);
		return obs;
	}



}
