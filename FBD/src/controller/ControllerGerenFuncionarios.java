package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.DaoEndereco;
import dao.DaoFuncionario;
import dao.IDaoEndereco;
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
import model.Endereco;
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
    private JFXTextField textSearchEnd;

    @FXML
    private JFXButton btnDeletarEnd;

    @FXML
    private JFXButton btnSalvarAlt;

    @FXML
    private JFXButton btnCancelarEdicao;

    @FXML
    private JFXTextField textIdUser;

    @FXML
    private JFXTextField textNewNome;

    @FXML
    private JFXTextField textNewEmail;

    @FXML
    private JFXTextField textNewCpf;

    @FXML
    private JFXTextField textNewIdentidade;

    @FXML
    private JFXTextField textIdEnd;

    @FXML
    private JFXTextField textNewRua;

    @FXML
    private JFXTextField textNewNumero;

    @FXML
    private JFXTextField textNewBairro;

    @FXML
    private JFXTextField textNewCidade;

    @FXML
    private JFXTextField textNewUf;




//  Table Funcionarios

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


//  Table Endereços

    @FXML
    private TableView<Endereco> tabEndereco;

    @FXML
    private TableColumn<Endereco, String> colIdEnd;

    @FXML
    private TableColumn<Endereco, String> colRua;

    @FXML
    private TableColumn<Endereco, String> colNumCasa;

    @FXML
    private TableColumn<Endereco, String> colBairro;

    @FXML
    private TableColumn<Endereco, String> colCidade;

    @FXML
    private TableColumn<Endereco, String> colUf;



    private IDaoFuncionario daoFuncionario;
    private IDaoEndereco daoEndereco;

    private FilteredList<Funcionario> filteredData;
    private	FilteredList<Endereco> filteredDataEnd;

    private ObservableList<Funcionario> oblist = FXCollections.observableArrayList();
    private ObservableList<Endereco> oblistEnd = FXCollections.observableArrayList();



    @FXML
    void ShowCancelEdicao(ActionEvent event) {

    }

    @FXML
    void ShowSalvarAlteracoes(ActionEvent event) {

    }

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

    @FXML
    void showDeleteEnd(ActionEvent event) {
    	try{

    		int id = tabEndereco.getSelectionModel().getSelectedItem().getId();
    		daoEndereco.DeleteEndereco(id);
    		new Mensagem("Endereço excluido com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarFuncionarios.fxml"), scene, "x");

    	}catch(Exception e){
    		new Mensagem("Erro ao excluir, selecione a linha na tabela!");
    	}
    }

    void initTable(){

    	this.oblist.clear();
    	this.oblistEnd.clear();

		oblist = daoFuncionario.getAllFuncionarios();
		oblistEnd = daoEndereco.getAllEnderecos();

    	filteredData = new FilteredList<>(oblist);
    	filteredDataEnd = new FilteredList<>(oblistEnd);


//    	Table Funcionario
    	colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colEndereco.setCellValueFactory(new PropertyValueFactory<>("id_endereco"));
		colIdentidade.setCellValueFactory(new PropertyValueFactory<>("identidade"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

//		Table Endereço
		colIdEnd.setCellValueFactory(new PropertyValueFactory<>("id"));
		colRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
		colNumCasa.setCellValueFactory(new PropertyValueFactory<>("num_casa"));
		colBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		colCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		colUf.setCellValueFactory(new PropertyValueFactory<>("uf"));

		tabGerenFuncionarios.setItems(oblist);
		tabEndereco.setItems(oblistEnd);
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

    @FXML
    void showSearchEnd(KeyEvent event) {

    	textSearchEnd.textProperty().addListener((observableValue, oldValue,newValue)->{
    		filteredDataEnd.setPredicate(Endereco->{
    			if(newValue==null || newValue.isEmpty()){
    				return true;
    			}
    			String lowerCaseFilter = newValue.toLowerCase();
    			if(String.valueOf(Endereco.getBairro()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Endereco.getCidade().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Endereco.getRua().toString().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Endereco.getUf().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}


    			return false;
    		});
    	});
    	SortedList<Endereco> sortedData = new SortedList<>(filteredDataEnd);
    	sortedData.comparatorProperty().bind(tabEndereco.comparatorProperty());
    	tabEndereco.setItems(sortedData);

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		daoFuncionario = new DaoFuncionario();
		daoEndereco = new DaoEndereco();
		initTable();
	}

}
