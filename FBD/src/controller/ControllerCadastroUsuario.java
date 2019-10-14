package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import exception.ControllerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControllerCadastroUsuario {

    @FXML
    private AnchorPane Content;

    @FXML
    private Pane PanelLogin;

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton sairCancelar;

    @FXML
    private JFXButton btnRetornar;

    @FXML
    private JFXTextField textNome;

    @FXML
    private JFXPasswordField passSenha;

    @FXML
    private JFXTextField textLogin;

    @FXML
    private JFXTextField textCpf;

    @FXML
    void ShowCancelar(ActionEvent event) {
    	textLogin.clear();
    	textCpf.clear();
    	passSenha.clear();
    	textNome.clear();


    }

    @FXML
    void ShowConfirmar(ActionEvent event) {
    	if(textLogin.getText().length() < 0 || textCpf.getText().length() < 11 || passSenha.getText().length() < 0
    		|| textNome.getText().length() < 0)
    	{
    		new ControllerException("Complete todos os campos corretamente.");
    	}else{
    		new ControllerException("cadastrado com sucesso!");
    	}
    }

    @FXML
    void ShowRetornar(ActionEvent event) throws IOException {
		Pane ap = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));

    	Content.getChildren().removeAll();
    	Content.getChildren().setAll(ap);
    	Content.toFront();

    }

}
