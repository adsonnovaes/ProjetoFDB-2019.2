package sql;

import java.sql.*;

public class CheckSQL {

	public Connection con;
	public ResultSet rs;
	public PreparedStatement stmt;

	public boolean checkTableExists(String table) throws SQLException{

		this.con = SqlConnection.creatConnection();
		DatabaseMetaData dbm = con.getMetaData();
		ResultSet tables = dbm.getTables(null, null, table, null);
		if (tables.next()) {
			return true;
		}

		this.con.close();

		return false;
	}

}
