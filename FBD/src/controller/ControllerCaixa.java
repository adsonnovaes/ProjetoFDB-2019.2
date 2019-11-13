package controller;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import dao.DaoCaixa;
import dao.IDaoCaixa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Caixa;

public class ControllerCaixa implements Initializable{

    @FXML
    private TableView<Caixa> tabCaixa;

    @FXML
    private TableColumn<Caixa,String> colCarga;

    @FXML
    private TableColumn<Caixa,String> colSaida;

    @FXML
    private TableColumn<Caixa,String> colEntrega;

    @FXML
    private TableColumn<Caixa,String> colValorTotal;

    @FXML
    private JFXDatePicker dateInicial;

    @FXML
    private JFXDatePicker dateFinal;

    @FXML
    private JFXButton btnFiltro;

    @FXML
    private JFXTextField textValor;

    private IDaoCaixa daoCaixa;

    private float valor;

    private FilteredList<Caixa> filteredData;

    private ObservableList<Caixa> oblist = FXCollections.observableArrayList();

    private void initTable(){
    	this.oblist.clear();

		oblist = daoCaixa.getAllCaixa();

		valor = DaoCaixa.GetTotal();

    	filteredData = new FilteredList<>(oblist);

		colCarga.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		colSaida.setCellValueFactory(new PropertyValueFactory<>("dateSaida"));
		colEntrega.setCellValueFactory(new PropertyValueFactory<>("dateEntrega"));
		colValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));

		tabCaixa.setItems(oblist);
		DecimalFormat df = new DecimalFormat("0.00");
		textValor.setText("R$ " + df.format(valor));
    }

    @FXML
    void ShowFiltro(ActionEvent event) {



    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoCaixa = new DaoCaixa();
		initTable();
	}

}
