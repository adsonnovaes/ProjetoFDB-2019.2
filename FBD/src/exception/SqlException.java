package exception;

import javax.swing.JOptionPane;

public class SqlException extends Exception{

	public SqlException(String ex){
		JOptionPane.showMessageDialog(null, ex);
	}

}
