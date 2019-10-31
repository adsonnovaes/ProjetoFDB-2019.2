package dao;

import java.sql.*;
import java.util.List;

import exception.DaoException;
import model.Endereco;
import model.Funcionario;
import sql.SqlConnection;
import sql.SqlUtil;

public class DaoFuncionario implements IDaoFuncionario{

    private Connection conexao;
    private PreparedStatement statement;

	@Override
	public int SalvarFuncionario(Funcionario funcionario) throws DaoException {

		try {
			System.out.println("Inicio");
            this.conexao = SqlConnection.creatConnection();
            this.statement = conexao.prepareStatement(SqlUtil.Funcioario.INSERT_ALL);


            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getCpf());
            statement.setInt(3, funcionario.getIdentidade());
            statement.setString(4, funcionario.getEmail());
            statement.setString(5, funcionario.getSenha());

            System.out.println("Pos conexão");
            statement.execute();

            System.out.println("Salvou funcionario");
            int cod = 0;
            ResultSet rs = statement.executeQuery("SELECT LAST_INSERT_ID();");
            if(rs.next()){
            	cod = rs.getInt("LAST_INSERT_ID();");
            }

            rs.close();


            this.conexao.close();
            System.out.println(cod);
            return cod;


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
		return null;
	}

	@Override
	public List<Funcionario> buscaGeralFuncionario(String i) {
		return null;
	}





}
