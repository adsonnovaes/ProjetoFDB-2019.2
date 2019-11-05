package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.DaoFuncionario;
import dao.IDaoFuncionario;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import mensagem.Mensagem;
import model.Funcionario;
import util.Util;

public class ControllerGerenFuncionarios implements Initializable{

    @FXML
    private JFXButton btnEditar;

    @FXML
    private JFXButton btnSalvar;

    @FXML
    private JFXButton btnDeletar;

    @FXML
    private JFXTextField textSearch;

    @FXML
    private TableView<Funcionario> tabGerenFuncionarios;

    @FXML
    private TableColumn<Funcionario, String> colId;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Funcionario,String> colCpf;

    @FXML
    private TableColumn<Funcionario,String> colEndereco;

    @FXML
    private TableColumn<Funcionario,String> colIdentidade;

    @FXML
    private TableColumn<Funcionario,String> colEmail;


    private IDaoFuncionario daoFuncionario;

    private FilteredList<Funcionario> filteredData;

    private ObservableList<Funcionario> oblist = FXCollections.observableArrayList();




    @FXML
    void ShowSalvar(ActionEvent event) throws IOException {
    }

    @FXML
    void ShowDelete(ActionEvent event) {
    	try{

    		int id = tabGerenFuncionarios.getSelectionModel().getSelectedItem().getId();
    		daoFuncionario.DeleteFuncionario(id);
    		new Mensagem("Funcionario excluido da tabela com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarFuncionarios.fxml"), scene, "x");

    	}catch(Exception e){
    		new Mensagem("Erro ao excluir, selecione a linha na tabela!");
    	}

    }

    void initTable(){
    	this.oblist.clear();

		oblist = daoFuncionario.getAllFuncionarios();

    	filteredData = new FilteredList<>(oblist);

    	colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colEndereco.setCellValueFactory(new PropertyValueFactory<>("id_endereco"));
		colIdentidade.setCellValueFactory(new PropertyValueFactory<>("identidade"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

		tabGerenFuncionarios.setItems(oblist);
    }

    @FXML
    void showSearch(KeyEvent event) {
    	textSearch.textProperty().addListener((observableValue, oldValue,newValue)->{
    		filteredData.setPredicate(Funcionario->{
    			if(newValue==null || newValue.isEmpty()){
    				return true;
    			}
    			String lowerCaseFilter = newValue.toLowerCase();
    			if(String.valueOf(Funcionario.getNome()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Funcionario.getCpf().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
//    			else if(Funcionario.getIdentidade().toString().toLowerCase().contains(lowerCaseFilter)){
//    				return true;
//    			}
    			else if(Funcionario.getEmail().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}


    			return false;
    		});
    	});
    	SortedList<Funcionario> sortedData = new SortedList<>(filteredData);
    	sortedData.comparatorProperty().bind(tabGerenFuncionarios.comparatorProperty());
    	tabGerenFuncionarios.setItems(sortedData);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		daoFuncionario = new DaoFuncionario();
		initTable();
	}

}
