package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import dao.DaoMotorista;
import dao.DaoVeiculo;
import dao.DaoViagem;
import dao.IDaoMotorista;
import dao.IDaoVeiculo;
import dao.IDaoViagem;
import exception.BusinessException;
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
import model.Carga;
import model.Motorista;
import model.Rota;
import model.Veiculo;
import model.Viagem;
import util.Util;

public class ControllerGerenViagem implements Initializable{

    @FXML
    private JFXButton btnDeletar;

    @FXML
    private TableView<Viagem> tabGerenViagens;

    @FXML
    private TableColumn<Viagem, String> colId;

    @FXML
    private TableColumn<Viagem, String> colMotorista;

    @FXML
    private TableColumn<Viagem, String> colVeiculo;

    @FXML
    private TableColumn<Viagem, String> colRota;

    @FXML
    private TableColumn<Viagem, String> colCarga;

    @FXML
    private TableColumn<Viagem, String> colSaida;

    @FXML
    private TableColumn<Viagem, String> colChegada;

    @FXML
    private TableColumn<Viagem, String> colStatus;

    @FXML
    private TableColumn<Viagem, String> colDescricao;

    @FXML
    private JFXTextField textSearch;

    @FXML
    private JFXButton btnSalvarAlt;

    @FXML
    private JFXButton btnCancelarEdicao;

    @FXML
    private JFXTextField textIdViagem;

    @FXML
    private JFXButton btnIdViagem;

    @FXML
    private TextArea areaDescricao;

    @FXML
    private JFXTextField textIdMotorista;

    @FXML
    private JFXButton btnIdMotorista;

    @FXML
    private JFXTextField textIdVeiculo;

    @FXML
    private JFXButton btnIdVeiculo;

    @FXML
    private JFXTextField textIdCarga;

    @FXML
    private JFXButton btnIdCarga;

    @FXML
    private JFXTextField textIdRota;

    @FXML
    private JFXButton btnIdRota;

    @FXML
    private JFXDatePicker dateSaida;

    @FXML
    private JFXDatePicker dateChegada;

    @FXML
    private JFXTextField textStatus;

    private IDaoViagem daoViagem;

    private IDaoMotorista daoMotorista;

    private IDaoVeiculo daoVeiculo;

    private FilteredList<Viagem> filteredData;

    private ObservableList<Viagem> oblist = FXCollections.observableArrayList();

    private void initTable(){
    	this.oblist.clear();

		oblist = daoViagem.getAllViagem();

    	filteredData = new FilteredList<>(oblist);

    	colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colMotorista.setCellValueFactory(new PropertyValueFactory<>("id_motorista"));
		colVeiculo.setCellValueFactory(new PropertyValueFactory<>("id_veiculo"));
		colRota.setCellValueFactory(new PropertyValueFactory<>("id_rota"));
		colCarga.setCellValueFactory(new PropertyValueFactory<>("id_carga"));
		colSaida.setCellValueFactory(new PropertyValueFactory<>("data_saida"));
		colChegada.setCellValueFactory(new PropertyValueFactory<>("data_chegada"));
		colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
		colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));

		tabGerenViagens.setItems(oblist);
    }

    @FXML
    void ShowDelete(ActionEvent event) {
    	try{

    		int id = tabGerenViagens.getSelectionModel().getSelectedItem().getId();
    		daoViagem.DeleteViagem(id);
    		new Mensagem("Viagem excluida da tabela com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarViagens.fxml"), scene, "x");

    	}catch(Exception e){
    		new Mensagem("Erro ao excluir, selecione a linha na tabela!");
    	}

    }

    @FXML
    void ShowCancelEdicao(ActionEvent event) throws IOException {
    	new Mensagem("Operação cancelada com sucesso.");
  		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarViagens.fxml"), scene, "x");

    }

    private void UpdateViagem(){

    	Viagem viagem = new Viagem();

		Date date1 = Date.valueOf(dateSaida.getValue());

		Date date2 = Date.valueOf(dateChegada.getValue());

    	viagem.setData_saida(date1);
    	viagem.setData_chegada(date2);
    	viagem.setStatus(textStatus.getText());
    	viagem.setDescricao(areaDescricao.getText());
    	viagem.setId_motorista(Integer.parseInt(textIdMotorista.getText()));
    	viagem.setId_veiculo(Integer.parseInt(textIdVeiculo.getText()));
    	viagem.setId_rota(Integer.parseInt(textIdRota.getText()));
    	viagem.setId_carga(Integer.parseInt(textIdCarga.getText()));
    	viagem.setId(Integer.parseInt(textIdViagem.getText()));

    	daoViagem.UpdateViagem(viagem);

    }


    @FXML
    void ShowSalvarAlteracoes(ActionEvent event) throws IOException {
    	if(!textIdViagem.getText().isEmpty()){
    		UpdateViagem();

    		new Mensagem("Dados atualizados com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarViagens.fxml"), scene, "x");

    	}else{
    		new Mensagem("Insira o ID da viagem que deseja alterar.");
    	}

    }

    @FXML
    void showBuscarViagem(ActionEvent event) {

    	try {

			Viagem edite = daoViagem.buscarViagemId(Integer.parseInt(textIdViagem.getText()));
			if(edite.getId() != 0){

				textIdMotorista.setText(Integer.toString(edite.getId_motorista()));
				textIdVeiculo.setText(Integer.toString(edite.getId_veiculo()));
				textIdRota.setText(Integer.toString(edite.getId_rota()));
				textIdCarga.setText(Integer.toString(edite.getId_carga()));
				areaDescricao.setText(edite.getDescricao());
				textStatus.setText(edite.getStatus());
				dateSaida.setPromptText(new SimpleDateFormat("dd/MM/yyyy").format(edite.getData_saida()));
				dateChegada.setPromptText(new SimpleDateFormat("dd/MM/yyyy").format(edite.getData_chegada()));

				new Mensagem("Modifique os campos desejados e clique em salvar.");

			}else{

				new Mensagem("Essa viagem não está cadastrada.");
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}



    }

    @FXML
    void showBuscarMotorista(ActionEvent event) throws NumberFormatException, DaoException {

    	Motorista moto = daoMotorista.BuscarMotoristaID(Integer.parseInt(textIdMotorista.getText()));

    	if(moto.getId()!= 0){
    		new Mensagem("Nome: " + moto.getNome() + "\nIdentidade: " + moto.getIdentidade());
    	}else{
    		new Mensagem("Essa ID não está cadastrado.");
    	}

    }

    @FXML
    void ShowBuscarVeiculo(ActionEvent event) throws NumberFormatException, DaoException {

    	Veiculo veiculo = daoVeiculo.buscarVeiculoId(Integer.parseInt(textIdVeiculo.getText()));

    	if(veiculo.getId() != 0){
    		new Mensagem("Modelo: " + veiculo.getModelo() + "\nPlaca: " + veiculo.getPlaca());
    	}else{
    		new Mensagem("Não existe nenhum correspondente para esse ID.");
    	}

    }

    @FXML
    void showBuscarRota(ActionEvent event) throws NumberFormatException, BusinessException {
    	Rota rota = Main.fachada.buscarRotaId(Integer.parseInt(textIdRota.getText()));

    	if(rota.getId() != 0){
    		new Mensagem("Origem: " + rota.getOrigem() + "\nDestino: " + rota.getDestino());

    	}else{
    		new Mensagem("Não existe nenhum correspondente para esse ID.");
    	}

    }

    @FXML
    void showBuscarCarga(ActionEvent event) throws NumberFormatException, BusinessException {
    	Carga carga = Main.fachada.BuscarCargaID(Integer.parseInt(textIdCarga.getText()));

    	if(carga.getId() != 0){
    		new Mensagem("Descrição: " + carga.getDescricao() + "\nTipo: " + carga.getTipo());


    	}else{
    		new Mensagem("Não existe nenhum correspondente para esse ID.");
    	}

    }


    @FXML
    void showSearch(KeyEvent event) {
    	textSearch.textProperty().addListener((observableValue, oldValue,newValue)->{
    		filteredData.setPredicate(Viagem->{
    			if(newValue==null || newValue.isEmpty()){
    				return true;
    			}
    			String lowerCaseFilter = newValue.toLowerCase();

    			if(String.valueOf(Viagem.getDescricao()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Viagem.getStatus().toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Integer.toString(Viagem.getId_carga()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}
    			else if(Viagem.getData_chegada().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).contains(lowerCaseFilter)){
    				return true;
    			}

    			else if(Viagem.getData_saida().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).contains(lowerCaseFilter)){
    				return true;
    			}

    			else if(Integer.toString(Viagem.getId_rota()).toLowerCase().contains(lowerCaseFilter)){
    				return true;
    			}

    			return false;
    		});
    	});
    	SortedList<Viagem> sortedData = new SortedList<>(filteredData);
    	sortedData.comparatorProperty().bind(tabGerenViagens.comparatorProperty());
    	tabGerenViagens.setItems(sortedData);

    }





	@Override
	public void initialize(URL location, ResourceBundle resources) {

		daoViagem = new DaoViagem();
		daoMotorista = new DaoMotorista();
		daoVeiculo = new DaoVeiculo();
		initTable();

	}

}
