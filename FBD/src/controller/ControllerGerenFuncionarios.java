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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import mensagem.Mensagem;
import model.Endereco;
import model.Funcionario;
import util.Util;

public class ControllerGerenFuncionarios implements Initializable{


    @FXML
    private JFXButton btnDeletar;

    @FXML
    private JFXButton btnIdUser;

    @FXML
    private JFXButton btnIdEnd;

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
    void ShowCancelEdicao(ActionEvent event) throws IOException {
    	new Mensagem("Operação cancelada com sucesso!");
		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarFuncionarios.fxml"), scene, "x");

    }

    private void UpdateUser(){
    	    Funcionario fun = new Funcionario();
    		fun.setId(Integer.parseInt(textIdUser.getText()));
    		fun.setNome(textNewNome.getText());
    		fun.setEmail(textNewEmail.getText());
    		fun.setCpf(textNewCpf.getText());
    		fun.setIdentidade(Integer.parseInt(textNewIdentidade.getText()));

    		daoFuncionario.UpdateFuncionario(fun);

    }

    private void UpdateEnd(){

		Endereco end = new Endereco();
		end.setId(Integer.parseInt(textIdEnd.getText()));
		end.setBairro(textNewBairro.getText());
		end.setCidade(textNewCidade.getText());
		end.setNum_casa(Integer.parseInt(textNewNumero.getText()));
		end.setRua(textNewRua.getText());
		end.setUf(textNewUf.getText());

		daoEndereco.UpdateEndereco(end);

    }

    @FXML
    void ShowSalvarAlteracoes(ActionEvent event) throws IOException {

    	if(!textIdUser.getText().isEmpty() && textIdEnd.getText().isEmpty()){
    		UpdateUser();

    	}
    	else if(!textIdEnd.getText().isEmpty() && textIdUser.getText().isEmpty()){
    		UpdateEnd();
    	}
    	else if(textIdEnd.getText().isEmpty() && textIdUser.getText().isEmpty()){
    		new Mensagem("Preencha o ID respectivo ao que deseja mudar");
    	}

    	else{
    		UpdateEnd();
    		UpdateUser();
    	}

    	new Mensagem("Dados alterados com sucesso!");
		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarFuncionarios.fxml"), scene, "x");


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
    			else if(Integer.toString(Funcionario.getIdentidade()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Integer.toString(Funcionario.getId()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}

    			else if(Integer.toString(Funcionario.getId_endereco()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}

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
    			else if(Integer.toString(Endereco.getNum_casa()).toLowerCase().contains(lowerCaseFilter)){
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


    @FXML
    void showBuscarEnd(ActionEvent event) throws DaoException {
		Endereco editeEnd;
		try {
			editeEnd = daoEndereco.buscarEnderecoId(Integer.parseInt(textIdEnd.getText()));

			if(editeEnd.getCidade() != null){
				textNewRua.setText(editeEnd.getRua());
				textNewNumero.setText(Integer.toString(editeEnd.getNum_casa()));
				textNewBairro.setText(editeEnd.getBairro());
				textNewCidade.setText(editeEnd.getCidade());
				textNewUf.setText(editeEnd.getUf());

				new Mensagem("Modifique os campos desejados e clique em salvar.");

			}else{
					new Mensagem("Esse Endereço não está cadastrado.");

				}
			}catch (NumberFormatException e) {

				}


    }

    @FXML
    void showBuscarUser(ActionEvent event) {
    	try {

			Funcionario edite = daoFuncionario.BuscarFuncionarioID(Integer.parseInt(textIdUser.getText()));
			if(edite.getNome() != null){

				textNewNome.setText(edite.getNome());
				textNewEmail.setText(edite.getEmail());
				textNewCpf.setText(edite.getCpf());
				textNewIdentidade.setText(Integer.toString(edite.getIdentidade()));
				new Mensagem("Modifique os campos desejados e clique em salvar.");

			}else{

				new Mensagem("Esse Funcionario não está cadastrado.");
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		daoFuncionario = new DaoFuncionario();
		daoEndereco = new DaoEndereco();
		initTable();
	}

}
