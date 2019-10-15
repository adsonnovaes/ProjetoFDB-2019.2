package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Timer;

import com.jfoenix.controls.JFXButton;

import app.Main;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import util.Util;

public class ControllerDrawer implements Initializable{

	@FXML
    private FontAwesomeIconView icon_arrow;

    @FXML
    private Label label_user;

    @FXML
    private Button usuarios_btn;

    @FXML
    private Button cadastrar_btn;

    @FXML
    private VBox box_cadastrar;

    @FXML
    private VBox box_buttons;

    @FXML
    private Button pessoas_btn;

    @FXML
    private JFXButton btnVeiculo;

    @FXML
    private JFXButton btnCarga;

    @FXML
    private JFXButton btnMotorista;

    @FXML
    private JFXButton btnRota;

    @FXML
    private JFXButton btnViagem;

    @FXML
    private Button btnGenVeiculos;

    @FXML
    private Button btnGenFuncionarios;

    @FXML
    private Button btnGenRotas;

    @FXML
    private Button btnGenViagens;

    @FXML
    private Button btnCaixa;

    @FXML
    private Button btnHistorico;

    @FXML
    private ControllerTelaPrincipal mainController;

    @FXML
    void cadastrarDropDown(ActionEvent event) throws IOException {

    	if(!box_cadastrar.isVisible()){
    		icon_arrow.setGlyphName("CHEVRON_DOWN");
        	int idx = box_buttons.getChildren().indexOf(cadastrar_btn)+1;
//        	int from = box_buttons.getChildren().indexOf(box_cadastrar);

        	box_buttons.getChildren().add(idx, box_cadastrar);
        	box_cadastrar.setVisible(true);
    	}else{
    		icon_arrow.setGlyphName("CHEVRON_UP");
//    		int idx = box_buttons.getChildren().size()-1;
//    		int from = box_buttons.getChildren().indexOf(box_cadastrar);

    		box_buttons.getChildren().remove(box_cadastrar);
        	box_cadastrar.setVisible(false);
    	}

    }

    @FXML
    void showCadastrarVeiculo(ActionEvent event) throws IOException {
    	Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroVeiculo.fxml"), scene, "x");

    }

    @FXML
    void ShowCadastrarCarga(ActionEvent event) throws IOException {
    	Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroCarga.fxml"), scene, "x");
    }

    @FXML
    void ShowCadastrarMotorista(ActionEvent event) throws IOException {
    	Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroMotorista.fxml"), scene, "x");
    }

    @FXML
    void ShowCadastrarRota(ActionEvent event) throws IOException {
    	Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroRota.fxml"), scene, "x");

    }

    @FXML
    void ShowCadastrarViagem(ActionEvent event) throws IOException {
    	Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCadastroViagem.fxml"), scene, "x");

    }


    @FXML
    void ShowCaixa(ActionEvent event) throws IOException {
       	Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaCaixa.fxml"), scene, "x");
    }

    @FXML
    void ShowCarga(ActionEvent event) throws IOException {


    }

    @FXML
    void ShowHistorico(ActionEvent event) {

    }

    @FXML
    void ShowRotas(ActionEvent event) {

    }

    @FXML
    void ShowVeiculos(ActionEvent event) {

    }

    @FXML
    void ShowViagem(ActionEvent event) {

    }





    void setMainTela(ControllerTelaPrincipal mc){
    	this.mainController = mc;
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
