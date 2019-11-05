package sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SqlConnection {

    private static Connection connection = null;

    public static boolean bdExiste = false;

    public static Connection creatConnection() {

    	if(!bdExiste){
    		bdExiste = true;
    		creatSchema();
    	}

    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if(connection == null || connection.isClosed()){
				connection = DriverManager.getConnection(SqlUtil.URL,SqlUtil.USUARIO,SqlUtil.SENHA);
			}

		} catch (ClassNotFoundException e) {
			Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, e);
		} catch (SQLException e) {
			Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, e);
		}
		return connection;

    }


    private static void creatSchema(){

    	try{
    		Connection con = creatConnection();
    		Statement st = con.createStatement();
    		st.execute("CREATE SCHEMA IF NOT EXISTS 'rotasviagens' DEFAULT CHARACTER SET utf8;");
    		st.close();

    	}catch(Exception e){

    	}

    }



}


