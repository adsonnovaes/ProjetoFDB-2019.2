package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import exception.BusinessException;
import exception.ControllerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Endereco;
import model.Funcionario;

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
    private JFXTextField textRua;

    @FXML
    private JFXTextField textCidade;

    @FXML
    private JFXTextField textBairro;

    @FXML
    private JFXTextField textnumCasa;

    @FXML
    private JFXTextField textUf;

    @FXML
    void ShowCancelar(ActionEvent event) throws IOException {

    	textLogin.clear();
    	textCpf.clear();
    	passSenha.clear();
    	textNome.clear();
    	textRua.clear();
    	textCidade.clear();
    	textnumCasa.clear();
    	textUf.clear();

		Pane ap = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
    	Content.getChildren().removeAll();
    	Content.getChildren().setAll(ap);
    	Content.toFront();


    }

    @FXML
    void ShowConfirmar(ActionEvent event) throws BusinessException {
    	if(textLogin.getText().length() < 0 || textCpf.getText().length() < 11 || passSenha.getText().length() < 0
    		|| textNome.getText().length() < 0)
    	{
    		new ControllerException("Complete todos os campos corretamente.");
    	}else{

    		Endereco end = new Endereco();
    		end.setBairro(textBairro.getText());
    		end.setCidade(textCidade.getText());
    		end.setNum_casa(Integer.parseInt(textnumCasa.getText()));
    		end.setRua(textRua.getText());
    		end.setUf(textUf.getText());


    		Funcionario fun = new Funcionario();
    		fun.setNome(textNome.getText());
    		fun.setEmail(textLogin.getText());
    		fun.setSenha(passSenha.getText());
    		fun.setCpf(textCpf.getText());
    		fun.setIdentidade(888888);
    		fun.setEnd(end);
    		Main.fachada.SalvarFuncionario(fun);



    	}
    }

    @FXML
    void ShowRetornar(ActionEvent event) throws IOException {


    }

}
