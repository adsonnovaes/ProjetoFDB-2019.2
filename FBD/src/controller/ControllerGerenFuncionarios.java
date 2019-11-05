package controller;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Funcionario;

public class ControllerGerenFuncionarios {

    @FXML
    private JFXButton btnEditar;

    @FXML
    private JFXButton btnSalvar;

    @FXML
    private TableView<Funcionario> tabGerenFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario,String> colCpf;

    @FXML
    private TableColumn<Funcionario,String> colEndereco;

    @FXML
    private TableColumn<Funcionario,String> colIdentidade;

    @FXML
    void ShowSalvar(ActionEvent event) {

    }

}
