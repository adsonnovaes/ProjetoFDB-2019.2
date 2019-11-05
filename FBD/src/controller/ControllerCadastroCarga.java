package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import exception.ControllerException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import mensagem.Mensagem;

public class ControllerCadastroCarga implements Initializable{

    @FXML
    private JFXTextField textValorCarga;

    @FXML
    private JFXTextField txtQuantidade;

    @FXML
    private JFXTextField textPesoTotal;

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnCargas;

    @FXML
    private JFXTextArea areaDescricao;

    @FXML
    private ComboBox<String> boxTipo;

    @FXML
    private JFXDatePicker dateFabricacao;

    @FXML
    private JFXDatePicker dateValiadade;

    @FXML
    void ShowCancelarCadastro(ActionEvent event) {
    	textValorCarga.clear();
    	textPesoTotal.clear();
    	txtQuantidade.clear();
    	areaDescricao.clear();
    	new Mensagem("Cancelado com sucesso!");



    }

    @FXML
    void ShowConfirmarCadastro(ActionEvent event) {

    }

    @FXML
    void ShowCargas(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boxTipo.getItems().addAll("Perecível","Não-Perecível");
	}


}
