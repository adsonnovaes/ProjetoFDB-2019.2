package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import app.Main;
import dao.DaoVeiculo;
import dao.IDaoVeiculo;
import exception.DaoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import model.Veiculo;
import util.Util;

public class ControllerGerenVeiculo implements Initializable{

    @FXML
    private JFXButton btnDeletar;

    @FXML
    private TableView<Veiculo> tabGerenVeiculos;

    @FXML
    private TableColumn<Veiculo, String> colId;

    @FXML
    private TableColumn<Veiculo, String> colPlaca;

    @FXML
    private TableColumn<Veiculo, String> colUf;

    @FXML
    private TableColumn<Veiculo, String> colCarroceria;

    @FXML
    private TableColumn<Veiculo, String> colVeiculo;

    @FXML
    private TableColumn<Veiculo, String> colModelo;

    @FXML
    private TableColumn<Veiculo, String> colAno;

    @FXML
    private TableColumn<Veiculo, String> colRenavam;

    @FXML
    private TableColumn<Veiculo, String> colKm;

    @FXML
    private TableColumn<Veiculo, String> colCapacidade;

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

    private IDaoVeiculo daoVeiculo;

    private FilteredList<Veiculo> filteredData;

    private ObservableList<Veiculo> oblist = FXCollections.observableArrayList();

    private void initTable(){
    	this.oblist.clear();

		oblist = daoVeiculo.getAllVeiculo();

    	filteredData = new FilteredList<>(oblist);

    	colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		colUf.setCellValueFactory(new PropertyValueFactory<>("uf"));
		colCarroceria.setCellValueFactory(new PropertyValueFactory<>("tipoCarroceria"));
		colVeiculo.setCellValueFactory(new PropertyValueFactory<>("tipoVeiculo"));
		colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		colAno.setCellValueFactory(new PropertyValueFactory<>("ano"));
		colRenavam.setCellValueFactory(new PropertyValueFactory<>("codRenavam"));
		colKm.setCellValueFactory(new PropertyValueFactory<>("kmRodado"));
		colCapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));

		tabGerenVeiculos.setItems(oblist);
    }

    @FXML
    void ShowCancelEdicao(ActionEvent event) throws IOException {
    	new Mensagem("Operação cancelada com sucesso.");
  		Scene scene = (Scene) ((Node) event.getSource()).getScene();
    	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarVeiculos.fxml"), scene, "x");

    }

    @FXML
    void ShowDelete(ActionEvent event) {

    	try{

    		int id = tabGerenVeiculos.getSelectionModel().getSelectedItem().getId();
    		daoVeiculo.DeleteVeiculo(id);
    		new Mensagem("Veículo excluido da tabela com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarVeiculos.fxml"), scene, "x");

    	}catch(Exception e){
    		new Mensagem("Erro ao excluir, selecione a linha na tabela!");
    	}

    }

    private void UpdateCar(){

    	Veiculo veiculo = new Veiculo();

    	veiculo.setPlaca(textNewPlaca.getText());
    	veiculo.setUf(textNewUf.getText());
    	veiculo.setTipoCarroceria(textNewCarroceria.getText());
    	veiculo.setTipoVeiculo(textNewVeiculo.getText());
    	veiculo.setModelo(textNewModelo.getText());
    	veiculo.setAno(Integer.parseInt(textNewAno.getText()));
    	veiculo.setCor(textNewCor.getText());
    	veiculo.setCodRenavam(Integer.parseInt(textNewRenavam.getText()));
    	veiculo.setKmRodado(Float.parseFloat(textNewKm.getText()));
    	veiculo.setCapacidade(Integer.parseInt(textNewCapacidade.getText()));
    	veiculo.setId(Integer.parseInt(textIdCar.getText()));

    	daoVeiculo.UpdateVeiculo(veiculo);

    }

    @FXML
    void ShowSalvarAlteracoes(ActionEvent event) throws IOException{

    	if(!textIdCar.getText().isEmpty()){
    		UpdateCar();

    		new Mensagem("Dados atualizados com sucesso!");

    		Scene scene = (Scene) ((Node) event.getSource()).getScene();
        	Util.LoadWindow(getClass().getResource("/view/TelaGerenciarVeiculos.fxml"), scene, "x");

    	}else{
    		new Mensagem("Insira o ID do veículo que deseja alterar.");
    	}



    }

    @FXML
    void showBuscarVeiculo(ActionEvent event) {

    	try {

			Veiculo edite = daoVeiculo.buscarVeiculoId(Integer.parseInt(textIdCar.getText()));
			if(edite.getPlaca() != null){

				textNewPlaca.setText(edite.getPlaca());
				textNewUf.setText(edite.getUf());
				textNewCarroceria.setText(edite.getTipoCarroceria());
				textNewVeiculo.setText(edite.getTipoVeiculo());
				textNewRenavam.setText(Integer.toString(edite.getCodRenavam()));
				textNewCor.setText(edite.getCor());
				textNewAno.setText(Integer.toString(edite.getAno()));
				textNewModelo.setText(edite.getModelo());
				textNewKm.setText(""+edite.getKmRodado());
				textNewCapacidade.setText(Integer.toString(edite.getCapacidade()));
				new Mensagem("Modifique os campos desejados e clique em salvar.");

			}else{

				new Mensagem("Esse Veículo não está cadastrado.");
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void showSearch(KeyEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		daoVeiculo  = new DaoVeiculo();
		initTable();
	}

}
