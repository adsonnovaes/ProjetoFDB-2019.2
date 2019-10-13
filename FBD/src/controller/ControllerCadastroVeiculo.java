package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

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
    private JFXTextField textRntrc;

    @FXML
    private JFXTextField textCapacidadeKg;

    @FXML
    private JFXTextField textTara;

    @FXML
    private JFXTextField textCapacidadeCub;

    @FXML
    private JFXTextField textCiot;

    @FXML
    private JFXTextField textMotorista;

    @FXML
    private JFXTextField textCpf;

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
    void ShowConfirmarCadastro(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboTipoCarroceria.getItems().addAll("Baú","Graneleiro");
		comboTipoVeiculo.getItems().addAll("Eixo-duplo","Carreta","Bitrem");


	}

}