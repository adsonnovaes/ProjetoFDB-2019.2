package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Caixa;

public class ControllerCaixa {

    @FXML
    private JFXButton btnVeiculo;

    @FXML
    private JFXButton btnRotas;

    @FXML
    private JFXButton btnCargas;

    @FXML
    private TableView<Caixa> tabCaixa;

    @FXML
    private TableColumn<Caixa, String> colVeiculo;

    @FXML
    private TableColumn<Caixa, String> colMotorista;

    @FXML
    private TableColumn<Caixa, String> colCarga;

    @FXML
    private TableColumn<Caixa, String> colValorTotal;

    @FXML
    private JFXDatePicker dateInicial;

    @FXML
    private JFXDatePicker dateFinal;

    @FXML
    void ShowCargas(ActionEvent event) {

    }

    @FXML
    void ShowRotas(ActionEvent event) {

    }

    @FXML
    void ShowVeiculos(ActionEvent event) {

    }

}




