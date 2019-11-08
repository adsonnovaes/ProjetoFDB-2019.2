package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import exception.BusinessException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import mensagem.Mensagem;
import model.Veiculo;
import util.Util;

public class ControllerCadastroVeiculo implements Initializable{

    @FXML
    private Pane paneVeiculo;

    @FXML
    private JFXTextField textMarca;

    @FXML
    private JFXTextField textPlaca;

    @FXML
    private JFXTextField textUf;

    @FXML
    private JFXTextField textCidade;

    @FXML
    private JFXComboBox<String> comboTipoCarroceria;

    @FXML
    private JFXTextField textAno;

    @FXML
    private JFXTextField textKm;

    @FXML
    private JFXTextField textCor;

    @FXML
    private JFXComboBox<String> comboTipoVeiculo;

    @FXML
    private JFXTextField textRenavam;

    @FXML
    private JFXTextField textCapacidadeKg;


    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnRetornar;

    @FXML
    void ShowCancelarCadastro(ActionEvent event) {


    }

    @FXML
    void ShowConfirmarCadastro(ActionEvent event) throws BusinessException, IOException {

    	boolean verificacao = Main.fachada.buscarVeiculoPlaca(textPlaca.getText());

    	if(verificacao){
    		    	if(textPlaca.getText().length() > 0 && textUf.getText().length() > 0
    		    	   && textMarca.getText().length() > 0 && textAno.getText().length() > 0
    		    	   && textCor.getText().length() > 0 && textRenavam.getText().length() > 0
			    	   && textKm.getText().length() > 0 && textCapacidadeKg.getText().length() > 0)

    		    	{

					    	Veiculo veiculo = new Veiculo();
					    	veiculo.setPlaca(textPlaca.getText());
					    	veiculo.setUf(textUf.getText());
					    	veiculo.setTipoCarroceria(comboTipoCarroceria.getSelectionModel().getSelectedItem());
					    	veiculo.setTipoVeiculo(comboTipoVeiculo.getSelectionModel().getSelectedItem());
					    	veiculo.setModelo(textMarca.getText());
					    	veiculo.setAno(Integer.parseInt(textAno.getText()));
					    	veiculo.setCor(textCor.getText());
					    	veiculo.setCodRenavam(Integer.parseInt(textRenavam.getText()));
					    	veiculo.setKmRodado(Float.parseFloat(textKm.getText()));
					    	veiculo.setCapacidade(Integer.parseInt(textCapacidadeKg.getText()));

					    	Main.fachada.salvarVeiculo(veiculo);
					    	new Mensagem("Veículo cadastrado com sucesso!");

				    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
				        	Util.LoadWindow(getClass().getResource("/view/TelaCadastroVeiculo.fxml"), scene, "x");

				    }else{
				    	new Mensagem("Preencha todos os campos!");
				    }
    	}else{
    		new Mensagem("Essa placa já consta no sistema.");
    	}



    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboTipoCarroceria.getItems().addAll("Baú","Graneleiro");
		comboTipoVeiculo.getItems().addAll("Eixo-duplo","Carreta","Bitrem");


	}

}