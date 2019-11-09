package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import exception.BusinessException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import mensagem.Mensagem;
import model.Rota;
import util.Util;

public class ControllerCadastroRota {

    @FXML
    private JFXTextField textKm;

    @FXML
    private JFXTextField textOrigem;

    @FXML
    private JFXTextField textDestino;

    @FXML
    private JFXTextField textCombustivel;

    @FXML
    private JFXTextField textTempo;

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private TextArea areaDescricao;


    @FXML
    void ShowCancelarCadastro(ActionEvent event) throws IOException {

    	new Mensagem("Operação cancelada com sucesso.");

		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroRota.fxml"), scene, "x");

    }

    @FXML
    void ShowConfirmarCadastro(ActionEvent event) throws BusinessException, IOException {

    	if(textOrigem.getText().length() > 0 && textDestino.getText().length() > 0
    	    && textKm.getText().length() > 0 && textCombustivel.getText().length() > 0
    	    && textTempo.getText().length() > 0 && areaDescricao.getText().length() > 0){

	    	Rota rota = new Rota();
	    	rota.setOrigem(textOrigem.getText());
	    	rota.setDestino(textDestino.getText());
	    	rota.setKm(Float.parseFloat(textKm.getText()));
	    	rota.setCombustivel(Integer.parseInt(textCombustivel.getText()));
	    	rota.setTempoPrevisto(Integer.parseInt(textTempo.getText()));
	    	rota.setDescricao(areaDescricao.getText());

	    	Main.fachada.salvarRota(rota);

	    	new Mensagem("Rota cadastrada com sucesso.");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaCadastroRota.fxml"), scene, "x");


    	}else{
    			new Mensagem("Preencha todos os campos.");
    	}


    }

}
