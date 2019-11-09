package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import exception.BusinessException;
import exception.DaoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import mensagem.Mensagem;
import model.Endereco;
import model.Motorista;
import util.Util;

public class ControllerCadastroMotorista implements Initializable{


    @FXML
    private JFXTextField textNome;


    @FXML
    private JFXTextField textRua;

    @FXML
    private JFXTextField textCidade;

    @FXML
    private JFXTextField textNumero;

    @FXML
    private JFXTextField textBairro;

    @FXML
    private JFXTextField textUf;

    @FXML
    private JFXTextField textCpf;

    @FXML
    private JFXTextField textRg;

    @FXML
    private JFXTextField textCnh;

    @FXML
    private JFXTextField textCategoria;

    @FXML
    private JFXTextField textDdd;

    @FXML
    private JFXTextField textTelefone;

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    void ShowCancelarCadastro(ActionEvent event) throws IOException {
    	new Mensagem("Operação cancelada com sucesso!");
		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroMotorista.fxml"), scene, "x");

    }


    @FXML
    void ShowConfirmarCadastro(ActionEvent event) throws BusinessException, DaoException, IOException {


    	boolean validar = Main.fachada.BuscarMotoristaRg(Integer.parseInt(textRg.getText()));

    	if(validar){

	    	if(textBairro.getText().length() > 0 && textCidade.getText().length() > 0 && textNumero.getText().length() > 0
	    	   && textRua.getText().length() > 0 && textUf.getText().length() > 0 && textNome.getText().length() > 0
	    	   && textCpf.getText().length() > 0 && textRg.getText().length() > 0 && textCnh.getText().length() > 0
	    	   && textDdd.getText().length() > 0 && textTelefone.getText().length() > 0){

				Endereco end = new Endereco();
				end.setBairro(textBairro.getText());
				end.setCidade(textCidade.getText());
				end.setNum_casa(Integer.parseInt(textNumero.getText()));
				end.setRua(textRua.getText());
				end.setUf(textUf.getText());

				Motorista moto = new Motorista();
				moto.setNome(textNome.getText());
				moto.setCpf(textCpf.getText());
				moto.setIdentidade(Integer.parseInt(textRg.getText()));
				moto.setCnh(textCnh.getText());
				moto.setCategoriaCnh(textCategoria.getText());
				moto.setTelefone("("+textDdd.getText()+")" + textTelefone.getText());
				moto.setEnd(end);

				Main.fachada.SalvarMotorista(moto);

	    		new Mensagem("Motorista cadastrado com sucesso.");

	    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
	        	Util.LoadWindow(getClass().getResource("/view/TelaCadastroMotorista.fxml"), scene, "x");


	    	}else{
	    		new Mensagem("Preencha todos os campos");
	    	}
    	}else{
    		new Mensagem("Essa identidade já consta no sistema");
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

		textNumero.textProperty().addListener((observable,oldValue,newValue) -> {

				if(newValue.length() > 7){
					textNumero.setText(oldValue);
					}
				if (!newValue.matches("\\d*")) {
					textNumero.setText(oldValue);
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
