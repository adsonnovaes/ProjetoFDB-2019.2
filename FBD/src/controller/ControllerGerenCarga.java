package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.DaoCarga;
import dao.IDaoCarga;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Carga;

public class ControllerGerenCarga implements Initializable{

    @FXML
    private JFXButton btnDeletar;

    @FXML
    private TableView<Carga> tabGerenCargas;

    @FXML
    private TableColumn<Carga, String> colId;

    @FXML
    private TableColumn<Carga, String> colQuantidade;

    @FXML
    private TableColumn<Carga, String> colTipo;

    @FXML
    private TableColumn<Carga, String> colPeso;

    @FXML
    private TableColumn<Carga, String> colValor;

    @FXML
    private TableColumn<Carga, String> colFabricacao;

    @FXML
    private TableColumn<Carga, String> colValidade;

    @FXML
    private TableColumn<Carga, String> colDescricao;

    @FXML
    private JFXTextField textSearch;

    @FXML
    private JFXButton btnSalvarAlt;

    @FXML
    private JFXButton btnCancelarEdicao;

    @FXML
    private JFXTextField textIdCar;

    @FXML
    private JFXButton btnIdCar;

    @FXML
    private JFXTextField textNewPlaca;

    @FXML
    private JFXTextField textNewUf;

    @FXML
    private JFXTextField textNewCarroceria;

    @FXML
    private JFXTextField textNewVeiculo;

    @FXML
    private JFXTextField textNewCor;

    @FXML
    private JFXTextField textNewRenavam;

    @FXML
    private JFXTextField textNewKm;

    @FXML
    private JFXTextField textNewCapacidade;

    @FXML
    private JFXTextField textNewModelo;

    @FXML
    private JFXTextField textNewAno;

    private IDaoCarga daoCarga;

    private FilteredList<Carga> filteredData;

    private ObservableList<Carga> oblist = FXCollections.observableArrayList();



    private void initTable(){
    	this.oblist.clear();

		oblist = daoCarga.getAllCarga();

    	filteredData = new FilteredList<>(oblist);

    	colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidadeUni"));
		colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		colPeso.setCellValueFactory(new PropertyValueFactory<>("pesoTotal"));
		colValor.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
		colFabricacao.setCellValueFactory(new PropertyValueFactory<>("fabricacao"));
		colValidade.setCellValueFactory(new PropertyValueFactory<>("validade"));
		colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

		tabGerenCargas.setItems(oblist);
    }

    @FXML
    void ShowCancelEdicao(ActionEvent event) {

    }

    @FXML
    void ShowDelete(ActionEvent event) {

    }

    @FXML
    void ShowSalvarAlteracoes(ActionEvent event) {

    }

    @FXML
    void showBuscarVeiculo(ActionEvent event) {

    }

    @FXML
    void showSearch(KeyEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoCarga = new DaoCarga();
		initTable();
	}

}
