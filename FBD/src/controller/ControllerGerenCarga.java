package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import dao.DaoCarga;
import dao.IDaoCarga;
import exception.DaoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import mensagem.Mensagem;
import model.Carga;
import util.Util;

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
    private TableColumn<Carga, Date> colFabricacao;

    @FXML
    private TableColumn<Carga, Date> colValidade;

    @FXML
    private TableColumn<Carga, String> colDescricao;

    @FXML
    private JFXTextField textSearch;

    @FXML
    private JFXButton btnSalvarAlt;

    @FXML
    private JFXButton btnCancelarEdicao;

    @FXML
    private JFXTextField textIdCarga;

    @FXML
    private JFXButton btnIdCarga;

    @FXML
    private JFXTextField textNewQuantidade;

    @FXML
    private JFXTextField textNewTipo;

    @FXML
    private JFXTextField textNewPeso;

    @FXML
    private JFXTextField textNewValor;

    @FXML
    private JFXDatePicker dateFabricacao;

    @FXML
    private JFXDatePicker dateValidade;

    @FXML
    private TextArea areaDescricao;


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

		colFabricacao.setCellFactory(column -> {
			TableCell<Carga, Date> cell = new TableCell<Carga, Date>() {
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

		colValidade.setCellValueFactory(new PropertyValueFactory<>("validade"));

		colValidade.setCellFactory(column -> {
			TableCell<Carga, Date> cell = new TableCell<Carga, Date>() {
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

		colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

		tabGerenCargas.setItems(oblist);
    }

    @FXML
    void ShowCancelEdicao(ActionEvent event) throws IOException {
    	new Mensagem("Operação cancelada com sucesso.");
  		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarCargas.fxml"), scene, "x");

    }

    @FXML
    void ShowDelete(ActionEvent event) {

    	try{

    		int id = tabGerenCargas.getSelectionModel().getSelectedItem().getId();
    		daoCarga.DeleteCarga(id);
    		new Mensagem("Carga excluida da tabela com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarCargas.fxml"), scene, "x");

    	}catch(Exception e){
    		new Mensagem("Erro ao excluir, selecione a linha na tabela!");
    	}

    }

    private void UpdateCarga(){

    	Carga carga = new Carga();


		Date date1 = Date.valueOf(dateValidade.getValue());

		Date date2 = Date.valueOf(dateFabricacao.getValue());


		carga.setId(Integer.parseInt(textIdCarga.getText()));
    	carga.setTipo(textNewTipo.getText());
    	carga.setQuantidadeUni(Integer.parseInt(textNewQuantidade.getText()));
    	carga.setPesoTotal(Float.parseFloat(textNewPeso.getText()));
    	carga.setValorTotal(Float.parseFloat(textNewValor.getText()));
    	carga.setFabricacao(date2);
    	carga.setValidade(date1);
    	carga.setDescricao(areaDescricao.getText());

    	daoCarga.UpdateCarga(carga);

    }

    @FXML
    void ShowSalvarAlteracoes(ActionEvent event) throws IOException {

    	if(!textIdCarga.getText().isEmpty()){
    		UpdateCarga();

    		new Mensagem("Dados atualizados com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarCargas.fxml"), scene, "x");

    	}else{
    		new Mensagem("Insira o ID da carga que deseja alterar.");
    	}



    }

    @FXML
    void showBuscarCarga(ActionEvent event) {

    	try {

			Carga edite = daoCarga.BuscarCargaID(Integer.parseInt(textIdCarga.getText()));
			if(edite.getTipo() != null){

				textNewQuantidade.setText(Integer.toString(edite.getQuantidadeUni()));
				textNewTipo.setText(edite.getTipo());
				textNewPeso.setText(Float.toString(edite.getPesoTotal()));
				textNewValor.setText(Float.toString(edite.getValorTotal()));
				areaDescricao.setText(edite.getDescricao());
				dateValidade.setPromptText((new SimpleDateFormat("dd/MM/yyyy").format(edite.getValidade())));
				dateFabricacao.setPromptText((new SimpleDateFormat("dd/MM/yyyy").format(edite.getFabricacao())));
				new Mensagem("Modifique os campos desejados e clique em salvar.");

			}else{

				new Mensagem("Essa Carga não está cadastrado.");
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}



    }

    @FXML
    void showSearch(KeyEvent event) {

     	textSearch.textProperty().addListener((observableValue, oldValue,newValue)->{
    		filteredData.setPredicate(Carga->{
    			if(newValue==null || newValue.isEmpty()){
    				return true;
    			}
    			String lowerCaseFilter = newValue.toLowerCase();

    			if(String.valueOf(Carga.getTipo()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Float.toString(Carga.getPesoTotal()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Integer.toString(Carga.getQuantidadeUni()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Carga.getDescricao().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}

    			else if(Float.toString(Carga.getValorTotal()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}


    			return false;
    		});
    	});
    	SortedList<Carga> sortedData = new SortedList<>(filteredData);
    	sortedData.comparatorProperty().bind(tabGerenCargas.comparatorProperty());
    	tabGerenCargas.setItems(sortedData);


    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoCarga = new DaoCarga();
		initTable();
	}

}
