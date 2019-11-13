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
import javafx.scene.control.TextArea;
import mensagem.Mensagem;
import model.Carga;
import model.Motorista;
import model.Rota;
import model.Veiculo;
import model.Viagem;
import util.Util;

public class ControllerCadastroViagem implements Initializable{

    @FXML
    private JFXTextField textVeiculo;

    @FXML
    private JFXTextField textIdRota;

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXDatePicker dateSaida;

    @FXML
    private JFXDatePicker dateChegada;

    @FXML
    private JFXTextField textMotorista;

    @FXML
    private JFXTextField textIdCarga;


    @FXML
    private TextArea areaDescricao;

    @FXML
    private JFXTextField textNome;

    @FXML
    private JFXTextField textModelo;

    @FXML
    private JFXTextField textOrigem;

    @FXML
    private JFXTextField textDestino;

    @FXML
    private JFXTextField textStatus;

    @FXML
    private JFXTextField textDescricao;

    @FXML
    private JFXButton btnMotorista;

    @FXML
    private JFXButton btnVeiculo;



    private Motorista moto = new Motorista();

    private Veiculo veiculo = new Veiculo();

    private Rota rota = new Rota();

    private Carga carga = new Carga();

    @FXML
    void ShowCancelarCadastro(ActionEvent event) throws IOException {
    	new Mensagem("Operação cancelada com sucesso.");
  		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroViagem.fxml"), scene, "x");

    }


    @FXML
    void ShowConfirmarCadastro(ActionEvent event) throws BusinessException, IOException {

    	if(textStatus.getText().length() > 0 && areaDescricao.getText().length() > 0
    	    && textIdCarga.getText().length() > 0 && textIdRota.getText().length() > 0
    	    && textMotorista.getText().length() > 0 && textVeiculo.getText().length() > 0){

		    	Viagem viagem = new Viagem();

				Date date1 = Date.valueOf(dateSaida.getValue());

				Date date2 = Date.valueOf(dateChegada.getValue());

		    	viagem.setData_saida(date1);
		    	viagem.setData_chegada(date2);
		    	viagem.setStatus(textStatus.getText());
		    	viagem.setDescricao(areaDescricao.getText());
		    	viagem.setId_motorista(moto.getId());
		    	viagem.setId_veiculo(veiculo.getId());
		    	viagem.setId_rota(rota.getId());
		    	viagem.setId_carga(carga.getId());

		    	Main.fachada.salvarViagem(viagem);

		    	new Mensagem("Viagem cadastrada com sucesso.");

		  		Scene scene = (Scene) ((Node) event.getSource()).getScene();
		    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroViagem.fxml"), scene, "x");


    	}else{
    		new Mensagem("Preencha todos os campos.");
    	}



    }


    @FXML
    void showBuscarMotorista(ActionEvent event) throws NumberFormatException, DaoException {

    	this.moto = Main.fachada.buscarMotoristaIden(Integer.parseInt(textMotorista.getText()));

    	if(moto.getId()!= 0){
    		textNome.setText(moto.getNome());

    	}else{
    		new Mensagem("Essa Identidade não está cadastrada.");
    	}


    }

    @FXML
    void showBuscarVeiculo(ActionEvent event) {

    	this.veiculo = Main.fachada.buscarVeiculoPlacaE(textVeiculo.getText());

    	if(veiculo.getId() != 0){
    		textModelo.setText(veiculo.getModelo());
    	}else{
    		new Mensagem("Essa Placa não está cadastrada.");
    	}



    }

    @FXML
    void showBuscarRota(ActionEvent event) throws NumberFormatException, BusinessException {

    	this.rota = Main.fachada.buscarRotaId(Integer.parseInt(textIdRota.getText()));

    	if(rota.getId() != 0){
    		textOrigem.setText(rota.getOrigem());
    		textDestino.setText(rota.getDestino());
    	}else{
    		new Mensagem("Não existe nenhum correspondente para esse ID.");
    	}


    }

    @FXML
    void showBuscarCarga(ActionEvent event) throws NumberFormatException, BusinessException {

    	this.carga = Main.fachada.BuscarCargaID(Integer.parseInt(textIdCarga.getText()));

    	if(carga.getId() != 0){
    		textDescricao.setText(carga.getDescricao());

    	}else{
    		new Mensagem("Não existe nenhum correspondente para esse ID.");
    	}


    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textMotorista.textProperty().addListener((observable,oldValue,newValue) -> {

			if(newValue.length() > 7){
				textMotorista.setText(oldValue);
			}
			if (!newValue.matches("\\d*")) {
				textMotorista.setText(oldValue);
			}
		});

		textVeiculo.textProperty().addListener((observable,oldValue,newValue) -> {

			if(newValue.length() > 7){
				textVeiculo.setText(oldValue);
			}

		});
	}

}
