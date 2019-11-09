package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.DaoRota;
import dao.IDaoRota;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import mensagem.Mensagem;
import model.Rota;
import util.Util;

public class ControllerGerenRotas implements Initializable{

    @FXML
    private JFXButton btnDeletar;

    @FXML
    private TableView<Rota> tabGerenRotas;

    @FXML
    private TableColumn<Rota, String> colId;

    @FXML
    private TableColumn<Rota, String> colOrigem;

    @FXML
    private TableColumn<Rota, String> colDestino;

    @FXML
    private TableColumn<Rota, String> colKm;

    @FXML
    private TableColumn<Rota, String> colCombustivel;

    @FXML
    private TableColumn<Rota, String> colTempo;

    @FXML
    private TableColumn<Rota, String> colDescricao;

    @FXML
    private JFXTextField textSearch;

    @FXML
    private JFXButton btnSalvarAlt;

    @FXML
    private JFXButton btnCancelarEdicao;

    @FXML
    private JFXTextField textIdRota;

    @FXML
    private JFXButton btnIdRota;

    @FXML
    private JFXTextField textNewOrigem;

    @FXML
    private JFXTextField textNewDestino;

    @FXML
    private JFXTextField textNewKm;

    @FXML
    private JFXTextField textNewCombustivel;

    @FXML
    private JFXTextField textNewTempo;

    @FXML
    private TextArea areaNewDescricao;

    private IDaoRota daoRota;

    private FilteredList<Rota> filteredData;

    private ObservableList<Rota> oblist = FXCollections.observableArrayList();



    private void initTable(){
    	this.oblist.clear();

		oblist = daoRota.getAllRota();

    	filteredData = new FilteredList<>(oblist);

    	colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colOrigem.setCellValueFactory(new PropertyValueFactory<>("origem"));
		colDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
		colKm.setCellValueFactory(new PropertyValueFactory<>("km"));
		colCombustivel.setCellValueFactory(new PropertyValueFactory<>("combustivel"));
		colTempo.setCellValueFactory(new PropertyValueFactory<>("tempoPrevisto"));
		colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

		tabGerenRotas.setItems(oblist);
    }

    @FXML
    void ShowCancelEdicao(ActionEvent event) throws IOException {

    	new Mensagem("Operação cancelada com sucesso.");
  		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarRotas.fxml"), scene, "x");

    }

    @FXML
    void ShowDelete(ActionEvent event) {

    	try{

    		int id = tabGerenRotas.getSelectionModel().getSelectedItem().getId();
    		daoRota.DeleteRota(id);
    		new Mensagem("Rota excluida da tabela com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarRotas.fxml"), scene, "x");

    	}catch(Exception e){
    		new Mensagem("Erro ao excluir, selecione a linha na tabela!");
    	}

    }


    private void UpdateRota(){

    	Rota rota = new Rota();
    	rota.setId(Integer.parseInt(textIdRota.getText()));
    	rota.setOrigem(textNewOrigem.getText());
    	rota.setDestino(textNewDestino.getText());
    	rota.setKm(Float.parseFloat(textNewKm.getText()));
    	rota.setCombustivel(Integer.parseInt(textNewCombustivel.getText()));
    	rota.setTempoPrevisto(Integer.parseInt(textNewTempo.getText()));
    	rota.setDescricao(areaNewDescricao.getText());

    	daoRota.UpdateRota(rota);


    }


    @FXML
    void ShowSalvarAlteracoes(ActionEvent event) throws IOException {

    	if(!textIdRota.getText().isEmpty()){
    		UpdateRota();

    		new Mensagem("Dados atualizados com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarRotas.fxml"), scene, "x");

    	}else{
    		new Mensagem("Insira o ID da Rota que deseja alterar.");
    	}

    }

    @FXML
    void showBuscarRota(ActionEvent event) {

    	try {

			Rota edite = daoRota.buscarRotaId(Integer.parseInt(textIdRota.getText()));
			if(edite.getDestino() != null){

				textNewOrigem.setText(edite.getOrigem());
				textNewDestino.setText(edite.getDestino());
				textNewKm.setText(Float.toString(edite.getKm()));
				textNewCombustivel.setText(Integer.toString(edite.getCombustivel()));
				textNewTempo.setText(Integer.toString(edite.getTempoPrevisto()));
				areaNewDescricao.setText(edite.getDescricao());

				new Mensagem("Modifique os campos desejados e clique em salvar.");

			}else{

				new Mensagem("Essa Rota não está cadastrada.");
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}


    }

    @FXML
    void showSearch(KeyEvent event) {

    	textSearch.textProperty().addListener((observableValue, oldValue,newValue)->{
    		filteredData.setPredicate(Rota->{
    			if(newValue==null || newValue.isEmpty()){
    				return true;
    			}

    			String lowerCaseFilter = newValue.toLowerCase();

    			if(String.valueOf(Rota.getOrigem()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Rota.getDestino().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Integer.toString(Rota.getCombustivel()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Rota.getDescricao().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}

    			else if(Integer.toString(Rota.getTempoPrevisto()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}

    			else if(Float.toString(Rota.getKm()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}


    			return false;
    		});
    	});
    	SortedList<Rota> sortedData = new SortedList<>(filteredData);
    	sortedData.comparatorProperty().bind(tabGerenRotas.comparatorProperty());
    	tabGerenRotas.setItems(sortedData);

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoRota = new DaoRota();
		initTable();
	}

}
