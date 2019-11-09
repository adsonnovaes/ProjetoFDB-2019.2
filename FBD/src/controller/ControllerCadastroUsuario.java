package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import exception.BusinessException;
import exception.ControllerException;
import exception.DaoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import mensagem.Mensagem;
import model.Endereco;
import model.Funcionario;

public class ControllerCadastroUsuario implements Initializable{

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
    private JFXTextField textRg;

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
    private JFXTextField textCasa;

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
    	textCasa.clear();
    	textUf.clear();

		Pane ap = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
    	Content.getChildren().removeAll();
    	Content.getChildren().setAll(ap);
    	Content.toFront();


    }

    @FXML
    void ShowConfirmar(ActionEvent event) throws BusinessException, DaoException, IOException {

    	boolean validarRg = Main.fachada.BuscarFuncionarioRg(Integer.parseInt(textRg.getText()));
//    	boolean validarCpf = Main.fachada.BuscarFuncionarioCpf(textRg.getText());
    	if(validarRg){
	    	if(textLogin.getText().length() < 0 || textCpf.getText().length() < 11 || passSenha.getText().length() < 0
	    		|| textNome.getText().length() < 0 )
	    	{
	    		new ControllerException("Complete todos os campos corretamente.");
	    	}else{


	    		Endereco end = new Endereco();
	    		end.setBairro(textBairro.getText());
	    		end.setCidade(textCidade.getText());
	    		end.setNum_casa(Integer.parseInt(textCasa.getText()));
	    		end.setRua(textRua.getText());
	    		end.setUf(textUf.getText());


	    		Funcionario fun = new Funcionario();
	    		fun.setNome(textNome.getText());
	    		fun.setEmail(textLogin.getText());
	    		fun.setSenha(passSenha.getText());
	    		fun.setCpf(textCpf.getText());
	    		fun.setIdentidade(Integer.parseInt(textRg.getText()));
	    		fun.setEnd(end);
	    		Main.fachada.SalvarFuncionario(fun);
	    		new Mensagem("Funcionário cadastrado com sucesso.");

	    		Pane ap = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
	        	Content.getChildren().removeAll();
	        	Content.getChildren().setAll(ap);
	        	Content.toFront();

    	}


    	}else{
    		new Mensagem("Essa identidade já consta no sistema.");
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		textCpf.textProperty().addListener((observable,oldValue,newValue) -> {

				if(newValue.length() > 11){
					textCpf.setText(oldValue);
					}
				if (!newValue.matches("\\d*")) {
					textCpf.setText(oldValue);
				}
			});

		textRg.textProperty().addListener((observable,oldValue,newValue) -> {

				if(newValue.length() > 7){
					textRg.setText(oldValue);
					}
				if (!newValue.matches("\\d*")) {
					textRg.setText(oldValue);
				}
		});

		textCasa.textProperty().addListener((observable,oldValue,newValue) -> {

				if(newValue.length() > 7){
					textCasa.setText(oldValue);
					}
				if (!newValue.matches("\\d*")) {
					textCasa.setText(oldValue);
				}
		});

		textUf.textProperty().addListener((observable,oldValue,newValue) -> {

				if(newValue.length() > 2){
					textUf.setText(oldValue);
					}

				if (newValue.matches("\\d+")) {
					textUf.setText(oldValue);
				}
		});
	}




}
