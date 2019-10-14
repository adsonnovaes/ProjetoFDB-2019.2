package exception;

import javax.swing.JOptionPane;

public class ControllerException extends Exception{

	public ControllerException(String i){
		JOptionPane.showMessageDialog(null, i);
	}

}
