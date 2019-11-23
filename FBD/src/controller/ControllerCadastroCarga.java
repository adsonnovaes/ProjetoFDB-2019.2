package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import exception.BusinessException;
import exception.DaoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import mensagem.Mensagem;
import model.Carga;
import util.Util;

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
    private TextArea areaDescricao;

    @FXML
    private ComboBox<String> boxTipo;

    @FXML
    private JFXDatePicker dateFabricacao;

    @FXML
    private JFXDatePicker dateValiadade;

    @FXML
    void ShowCancelarCadastro(ActionEvent event) throws DaoException, IOException {
    	new Mensagem("Operação cancelada com sucesso!");
		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroCarga.fxml"), scene, "x");



    }

    @FXML
    void ShowConfirmarCadastro(ActionEvent event) throws BusinessException, IOException {


    	if(txtQuantidade.getText().length() > 0 && textPesoTotal.getText().length() > 0
    		&& textValorCarga.getText().length() > 0 && areaDescricao.getText().length() > 0 ){

			Date date1 = Date.valueOf(dateValiadade.getValue());

			Date date2 = Date.valueOf(dateFabricacao.getValue());

	    	Carga carga = new Carga();
	    	carga.setTipo(boxTipo.getSelectionModel().getSelectedItem());
	    	carga.setQuantidadeUni(Integer.parseInt(txtQuantidade.getText()));
	    	carga.setPesoTotal(Float.parseFloat(textPesoTotal.getText()));
	    	carga.setValorTotal(Float.parseFloat(textValorCarga.getText()));
	    	carga.setFabricacao(date2);
	    	carga.setValidade(date1);
	    	carga.setDescricao(areaDescricao.getText());

	    	Main.fachada.SalvarCarga(carga);

    		new Mensagem("Carga cadastrada com sucesso.");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaCadastroCarga.fxml"), scene, "x");

    	}else{
    		new Mensagem("Preencha todos os campos");
    	}


    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boxTipo.getItems().addAll("Perecível","Não-Perecível");
	}


}
