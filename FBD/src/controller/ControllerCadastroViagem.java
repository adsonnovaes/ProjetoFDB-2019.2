package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerCadastroViagem {

    @FXML
    private JFXTextField textVeiculo;

    @FXML
    private JFXTextField textIdRota;

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXTextArea areaDescricao;

    @FXML
    private JFXDatePicker dateSaida;

    @FXML
    private JFXDatePicker dateChegada;

    @FXML
    private JFXTextField textMotorista;

    @FXML
    private JFXTextField textCarga;

    @FXML
    private Label textStatus;

    @FXML
    private JFXTextField textCarga1;

    @FXML
    void ShowCancelarCadastro(ActionEvent event) {

    }

    @FXML
    void ShowConfirmarCadastro(ActionEvent event) {

    }

}
