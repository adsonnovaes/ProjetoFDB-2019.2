package sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class SqlConnection {

    private static Connection conexao = null;

//  private static String caminho = "jdbc:postgresql://localhost:5432/RotasViagens";
//	private static String usuario = "postgres";
//	private static String senha = "2301@adson";

    public SqlConnection() {

    }

    public static synchronized Connection getConnectionInstance(String bd) {
        try {
            if (conexao == null || conexao.isClosed()) {
            	conexao = DriverManager.getConnection(SqlUtil.URL,SqlUtil.USUARIO,SqlUtil.SENHA);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return conexao;

    }

}










//public class SqlConnection {
//
//	public Statement state;
//	public ResultSet rs;
//	private String driver = "org.postgresql.Driver";
//	private String caminho = "jdbc:postgresql://localhost:5432/RotasViagens";
//	private String usuario = "postgres";
//	private String senha = "2301@adson";
//	public Connection conexao;
//
//
//	public void Conexao(){
//		try {
//
//			System.setProperty("jdbc.Drivers", driver);
//			conexao = DriverManager.getConnection(caminho, usuario, senha);
//		} catch (SQLException e) {
//		}
//
//	}
//
//
//	public void Desconectar(){
//		try {
//			conexao.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
