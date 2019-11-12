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
import model.Veiculo;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoVeiculo implements IDaoVeiculo{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;

	@Override
	public void salvarVeiculo(Veiculo veiculo) throws DaoException {

		try {


            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Veiculo.INSERT_ALL);


            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getUf());
            statement.setString(3, veiculo.getTipoCarroceria());
            statement.setString(4, veiculo.getTipoVeiculo());
            statement.setString(5, veiculo.getModelo());
            statement.setInt(6,veiculo.getAno());
            statement.setString(7, veiculo.getCor());
            statement.setInt(8, veiculo.getCodRenavam());
            statement.setFloat(9, veiculo.getKmRodado());
            statement.setInt(10, veiculo.getCapacidade());



            statement.execute();

            this.conexao.close();


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar o Veículo.");
        }

	}

	@Override
	public Veiculo editarVeiculo(Veiculo veiculo) throws DaoException {
		return null;
	}

	@Override
	public Veiculo buscarVeiculoId(int id) throws DaoException {
		Veiculo car = new Veiculo();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Veiculo.GET);
			statement.setInt(1, id);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){

				car.setId(rs.getInt("id_veiculo"));
				car.setPlaca(rs.getString("placa"));
				car.setUf(rs.getString("uf"));
				car.setTipoCarroceria(rs.getString("tipo_carroceria"));
				car.setTipoVeiculo(rs.getString("tipo_veiculo"));
				car.setModelo(rs.getString("modelo"));
				car.setAno(rs.getInt("ano"));
				car.setCor(rs.getString("cor"));
				car.setCodRenavam(rs.getInt("cod_renavam"));
				car.setKmRodado(rs.getFloat("kms"));
				car.setCapacidade(rs.getInt("capacidade"));

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;
	}

	@Override
	public boolean buscarVeiculoPlaca(String i) {

        try {

        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Veiculo.GET_PLACA);
			statement.setString(1, i);

			this.rs = statement.executeQuery();

			if(rs.next()){
				if(rs.getString("placa").equals(i)){
					return false;
				}

			}


		} catch (SQLException e) {
			e.printStackTrace();

		}

		return true;
	}

	@Override
	public void DeleteVeiculo(int id) {

        try {

        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Veiculo.DELETE);

			statement.setInt(1, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void UpdateVeiculo(Veiculo i) {


        try {
        	this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Veiculo.UPDATE);

            statement.setString(1, i.getPlaca());
            statement.setString(2, i.getUf());
            statement.setString(3, i.getTipoCarroceria());
            statement.setString(4, i.getTipoVeiculo());
            statement.setString(5, i.getModelo());
            statement.setInt(6,i.getAno());
            statement.setString(7, i.getCor());
            statement.setInt(8, i.getCodRenavam());
            statement.setFloat(9, i.getKmRodado());
            statement.setInt(10, i.getCapacidade());

            statement.setInt(11, i.getId());

	        statement.execute();

	        this.conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ObservableList<Veiculo> getAllVeiculo() {
		List<Veiculo> veiculos = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Veiculo.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){

				Veiculo car = new Veiculo();

				car.setId(rs.getInt("id_veiculo"));
				car.setPlaca(rs.getString("placa"));
				car.setUf(rs.getString("uf"));
				car.setTipoCarroceria(rs.getString("tipo_carroceria"));
				car.setTipoVeiculo(rs.getString("tipo_veiculo"));
				car.setModelo(rs.getString("modelo"));
				car.setAno(rs.getInt("ano"));
				car.setCor(rs.getString("cor"));
				car.setCodRenavam(rs.getInt("cod_renavam"));
				car.setKmRodado(rs.getFloat("kms"));
				car.setCapacidade(rs.getInt("capacidade"));

				veiculos.add(car);
			}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Veiculo> obs = FXCollections.observableList(veiculos);
		return obs;
	}

	@Override
	public Veiculo buscarVeiculoPlacaE(String placa) {
		Veiculo car = new Veiculo();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Veiculo.GET_PLACA);
			statement.setString(1, placa);

			this.rs = statement.executeQuery();

			if(rs != null && rs.next()){

				car.setId(rs.getInt("id_veiculo"));
				car.setModelo(rs.getString("modelo"));


			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return car;
	}





}
