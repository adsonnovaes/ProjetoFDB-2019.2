package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerLogin {

    @FXML
    private AnchorPane Content;

    @FXML
    private Pane PanelLogin;

    @FXML
    private PasswordField passSenha;

    @FXML
    private TextField textLogin;

    @FXML
    private Button entrarLoginButton;

    @FXML
    private Button sairLoginButton;

    @FXML
    private Button cadastrarBtn;



    @FXML
    void ShowLogin(ActionEvent event) {
    	if(passSenha.getText().equalsIgnoreCase(Main.SENHA) && textLogin.getText().equalsIgnoreCase(Main.LOGIN)){
    		Main.changerScene();
    	}else{
    		JOptionPane.showMessageDialog(null, "Login ou senha invalido.");
    	}


    }

    @FXML
    void ShowCadastrar(ActionEvent event) throws IOException {
		Pane ap = FXMLLoader.load(getClass().getResource("/view/TelaCadastroFuncionario.fxml"));

    	Content.getChildren().removeAll();
    	Content.getChildren().setAll(ap);
    	Content.toFront();

    }

    @FXML
    void ShowSairLogin(ActionEvent event) {
    	System.exit(0);

    }

}



