package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Caixa;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoCaixa implements IDaoCaixa{

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet rs;
    private static float total;

    public static float GetTotal(){
    	return total;
    }

	@Override
	public ObservableList<Caixa> getAllCaixa() {
		List<Caixa> all = new ArrayList<>();

		try {

			this.conexao = SqlConnection.creatConnection();
			this.statement = conexao.prepareStatement(SqlUtil.Caixa.GETALL);
			this.rs = statement.executeQuery();

			while(rs.next()){
				this.total += rs.getFloat("valor_total");
				Caixa caixa = new Caixa();

				caixa.setValorTotal(rs.getFloat("valor_total"));
				caixa.setDateSaida(rs.getDate("data_saida"));
				caixa.setDateEntrega(rs.getDate("data_chegada"));
				caixa.setDescricao(rs.getString("descricao"));
				all.add(caixa);
		}



		} catch (SQLException e) {
			e.printStackTrace();
		}


		ObservableList<Caixa> obs = FXCollections.observableList(all);
		return obs;
	}

}
