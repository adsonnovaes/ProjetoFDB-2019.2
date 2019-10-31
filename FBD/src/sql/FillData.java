package sql;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class FillData {

	public CheckSQL sql;
	public Connection con;
	public PreparedStatement stmt;

	public FillData() throws SQLException, IOException {

		sql = new CheckSQL();

		if(!sql.checkTableExists("funcionario")){
			con = SqlConnection.creatConnection();
			ScriptRunner script = new ScriptRunner(con, false, false);

			BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/createData.sql"),"UTF8"));
			script.runScript(in);
		}
	}

}
