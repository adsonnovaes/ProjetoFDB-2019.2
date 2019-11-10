package controller;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import dao.DaoCarga;
import exception.BusinessException;
import exception.DaoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import mensagem.Mensagem;
import model.Carga;

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
    void ShowCancelarCadastro(ActionEvent event) throws DaoException {
//    	String s = new SimpleDateFormat("dd/MM/yyyy").format(c.getFabricacao());



    }

    @FXML
    void ShowConfirmarCadastro(ActionEvent event) throws BusinessException {


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




    }

    @FXML
    void ShowCargas(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		boxTipo.getItems().addAll("Perecível","Não-Perecível");
	}


}
