package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import dao.DaoEndereco;
import dao.DaoMotorista;
import dao.IDaoEndereco;
import dao.IDaoMotorista;
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
import model.Motorista;
import util.Util;

public class ControllerGerenMotorista implements Initializable{

    @FXML
    private JFXButton btnDeletar;

    @FXML
    private TableView<Motorista> tabGerenMotoristas;

    @FXML
    private TableColumn<Motorista, String> colId;

    @FXML
    private TableColumn<Motorista, String> colNome;

    @FXML
    private TableColumn<Motorista, String> colTelefone;

    @FXML
    private TableColumn<Motorista, String> colEndereco;

    @FXML
    private TableColumn<Motorista, String> colIdentidade;

    @FXML
    private TableColumn<Motorista, String> colCpf;

    @FXML
    private TableColumn<Motorista, String> colCnh;

    @FXML
    private TableColumn<Motorista, String> colCategoria;

    @FXML
    private JFXTextField textSearch;

    @FXML
    private JFXTextField textSearchEnd;

    @FXML
    private JFXButton btnDeletarEnd;

    @FXML
    private TableView<Endereco> tabEndereco;

    @FXML
    private TableColumn<Endereco,String> colIdEnd;

    @FXML
    private TableColumn<Endereco,String> colRua;

    @FXML
    private TableColumn<Endereco,String> colNumCasa;

    @FXML
    private TableColumn<Endereco,String> colBairro;

    @FXML
    private TableColumn<Endereco,String> colCidade;

    @FXML
    private TableColumn<Endereco,String> colUf;

    @FXML
    private JFXButton btnSalvarAlt;

    @FXML
    private JFXButton btnCancelarEdicao;

    @FXML
    private JFXTextField textIdMoto;

    @FXML
    private JFXButton btnIdMoto;

    @FXML
    private JFXTextField textNewNome;

    @FXML
    private JFXTextField textNewCnh;

    @FXML
    private JFXTextField textNewCategoria;

    @FXML
    private JFXTextField textNewIdentidade;

    @FXML
    private JFXTextField textIdEnd;

    @FXML
    private JFXButton btnIdEnd;

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

    @FXML
    private JFXTextField textNewTelefone;

    @FXML
    private JFXTextField textNewCpf;

    private IDaoEndereco daoEndereco;
    private IDaoMotorista daoMotorista;

    private FilteredList<Motorista> filteredData;
    private	FilteredList<Endereco> filteredDataEnd;

    private ObservableList<Motorista> oblist = FXCollections.observableArrayList();
    private ObservableList<Endereco> oblistEnd = FXCollections.observableArrayList();

    void initTable(){

    	this.oblist.clear();
    	this.oblistEnd.clear();

		oblist = daoMotorista.getAllMotorista();
		oblistEnd = daoEndereco.getAllEnderecos();

    	filteredData = new FilteredList<>(oblist);
    	filteredDataEnd = new FilteredList<>(oblistEnd);


//    	Table Motorista
    	colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		colEndereco.setCellValueFactory(new PropertyValueFactory<>("id_endereco"));
		colIdentidade.setCellValueFactory(new PropertyValueFactory<>("identidade"));
		colCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colCnh.setCellValueFactory(new PropertyValueFactory<>("cnh"));
		colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoriaCnh"));

//		Table Endereço
		colIdEnd.setCellValueFactory(new PropertyValueFactory<>("id"));
		colRua.setCellValueFactory(new PropertyValueFactory<>("rua"));
		colNumCasa.setCellValueFactory(new PropertyValueFactory<>("num_casa"));
		colBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		colCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		colUf.setCellValueFactory(new PropertyValueFactory<>("uf"));

		tabGerenMotoristas.setItems(oblist);
		tabEndereco.setItems(oblistEnd);
    }

    @FXML
    void ShowCancelEdicao(ActionEvent event) throws IOException {
    	new Mensagem("Operação cancelada.");
		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarMotoristas.fxml"), scene, "x");
    }

    @FXML
    void ShowDelete(ActionEvent event) {
    	try{

    		int id = tabGerenMotoristas.getSelectionModel().getSelectedItem().getId();
    		daoMotorista.DeleteMotorista(id);
    		new Mensagem("Motorista excluido da tabela com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarMotoristas.fxml"), scene, "x");

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
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarMotoristas.fxml"), scene, "x");

    	}catch(Exception e){
    		new Mensagem("Erro ao excluir, selecione a linha na tabela!");
    	}
    }

    private void UpdateMotorista(){

	    Motorista moto = new Motorista();
		moto.setId(Integer.parseInt(textIdMoto.getText()));
		moto.setNome(textNewNome.getText());
		moto.setCnh(textNewCnh.getText());
		moto.setCategoriaCnh(textNewCategoria.getText());
		moto.setIdentidade(Integer.parseInt(textNewIdentidade.getText()));
		moto.setTelefone(textNewTelefone.getText());
		moto.setCpf(textNewCpf.getText());


		daoMotorista.UpdateMotorista(moto);
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

    	if(!textIdMoto.getText().isEmpty() && textIdEnd.getText().isEmpty()){
    		UpdateMotorista();

    	}
    	else if(!textIdEnd.getText().isEmpty() && textIdMoto.getText().isEmpty()){
    		UpdateEnd();
    	}
    	else if(textIdEnd.getText().isEmpty() && textIdMoto.getText().isEmpty()){
    		new Mensagem("Preencha o ID respectivo que deseja mudar.");
    	}

    	else{
    		UpdateEnd();
    		UpdateMotorista();
    	}

    	new Mensagem("Dados alterados com sucesso!");
		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarMotoristas.fxml"), scene, "x");
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
    void showBuscarMotorista(ActionEvent event) {
    	try {

			Motorista edite = daoMotorista.BuscarMotoristaID(Integer.parseInt(textIdMoto.getText()));
			if(edite.getNome() != null){

				textNewNome.setText(edite.getNome());
				textNewCnh.setText(edite.getCnh());
				textNewCategoria.setText(edite.getCategoriaCnh());
				textNewIdentidade.setText(Integer.toString(edite.getIdentidade()));
				textNewTelefone.setText(edite.getTelefone());
				textNewCpf.setText(edite.getCpf());


				new Mensagem("Modifique os campos desejados e clique em salvar.");

			}else{

				new Mensagem("Motorista não cadastrado.");
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}

    }



    @FXML
    void showSearch(KeyEvent event) {

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
	public void initialize(URL location, ResourceBundle resources) {
		daoMotorista = new DaoMotorista();
		daoEndereco = new DaoEndereco();
		initTable();
	}

}
