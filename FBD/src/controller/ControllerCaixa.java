package controller;

import java.net.URL;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import dao.DaoCaixa;
import dao.IDaoCaixa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
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
    private TableColumn<Caixa,Date> colSaida;

    @FXML
    private TableColumn<Caixa,Date> colEntrega;

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

		colSaida.setCellFactory(column -> {
			TableCell<Caixa, Date> cell = new TableCell<Caixa, Date>() {
				private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if(empty) {
						setText(null);
					}
					else {
						this.setText(format.format(item));
					}
				}
			};
			return cell;
		});

		colEntrega.setCellValueFactory(new PropertyValueFactory<>("dateEntrega"));

		colEntrega.setCellFactory(column -> {
			TableCell<Caixa, Date> cell = new TableCell<Caixa, Date>() {
				private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if(empty) {
						setText(null);
					}
					else {
						this.setText(format.format(item));
					}
				}
			};
			return cell;
		});

		colValorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));

		tabCaixa.setItems(oblist);
		DecimalFormat df = new DecimalFormat("0.000");
		textValor.setText("R$ " + df.format(valor));
    }


    @FXML
    void ShowFiltro(ActionEvent event) {

		filteredData.setPredicate(Caixa->{

			if(dateInicial==null || dateFinal == null){
				return true;
			}
			Date dateI = Date.valueOf(dateInicial.getValue());

			Date dateF = Date.valueOf(dateFinal.getValue());


			if(Caixa.getDateSaida().after(dateI) && Caixa.getDateEntrega().before(dateF)){
				return true;
			}

			else if(Caixa.getDateSaida().equals(dateI) || Caixa.getDateEntrega().equals(dateF)){
				return true;
			}

			return false;
		});

    	SortedList<Caixa> sortedData = new SortedList<>(filteredData);
    	sortedData.comparatorProperty().bind(tabCaixa.comparatorProperty());
    	tabCaixa.setItems(sortedData);


    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoCaixa = new DaoCaixa();
		initTable();
	}

}
