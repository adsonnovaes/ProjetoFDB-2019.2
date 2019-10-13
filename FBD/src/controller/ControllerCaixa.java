package controller;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Caixa;

public class ControllerCaixa {

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private TableView<Caixa> tabCaixa;

    @FXML
    private TableColumn<Caixa, String> colVeiculo;

    @FXML
    private TableColumn<Caixa, String> colMotorista;

    @FXML
    private TableColumn<Caixa, String> colCarga;

    @FXML
    private TableColumn<Caixa, String> colCombustivel;

    @FXML
    void ShowCancelarCadastro(ActionEvent event) {

    }

    @FXML
    void ShowConfirmarCadastro(ActionEvent event) {

    }

}
