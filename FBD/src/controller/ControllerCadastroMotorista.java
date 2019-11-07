package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import exception.BusinessException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Endereco;
import model.Motorista;

public class ControllerCadastroMotorista {


    @FXML
    private JFXTextField textNome;


    @FXML
    private JFXTextField textRua;

    @FXML
    private JFXTextField textCidade;

    @FXML
    private JFXTextField textNumero;

    @FXML
    private JFXTextField textBairro;

    @FXML
    private JFXTextField textUf;

    @FXML
    private JFXTextField textCpf;

    @FXML
    private JFXTextField textRg;

    @FXML
    private JFXTextField textCnh;

    @FXML
    private JFXTextField textCategoria;

    @FXML
    private JFXTextField textDdd;

    @FXML
    private JFXTextField textTelefone;

    @FXML
    private JFXButton btnConfirmar;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    void ShowCancelarCadastro(ActionEvent event) {

    }


    @FXML
    void ShowConfirmarCadastro(ActionEvent event) throws BusinessException {
		Endereco end = new Endereco();
		end.setBairro(textBairro.getText());
		end.setCidade(textCidade.getText());
		end.setNum_casa(Integer.parseInt(textNumero.getText()));
		end.setRua(textRua.getText());
		end.setUf(textUf.getText());

		Motorista moto = new Motorista();
		moto.setNome(textNome.getText());
		moto.setCpf(textCpf.getText());
		moto.setIdentidade(Integer.parseInt(textRg.getText()));
		moto.setCnh(textCnh.getText());
		moto.setCategoriaCnh(textCategoria.getText());
		moto.setTelefone("("+textDdd.getText()+")" + textTelefone.getText());
		moto.setEnd(end);

		Main.fachada.SalvarMotorista(moto);



    }

}
