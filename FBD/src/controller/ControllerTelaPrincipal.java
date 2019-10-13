package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import app.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import util.Util;

public class ControllerTelaPrincipal implements Initializable{

    @FXML
    private BorderPane borderPane;

    @FXML
    public StackPane contentPane;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private HBox top;

    @FXML
    private ImageView background;

    public Timer timer;

    private ControllerDrawer drawerController;

	private double xOffSet;

	private double yOffSet;


	public static JFXDrawer dr;

    @FXML
    void close_app(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void minimize_stage(MouseEvent event) {
    	Main.stage.setIconified(true);

    }

    private void makeStageDragable(){

		top.setOnMousePressed((event) ->{
			xOffSet = event.getSceneX();
			yOffSet = event.getSceneY();
		});

		top.setOnMouseDragged((event) -> {
			if(!Main.stage.isMaximized()){
				Main.stage.setX(event.getScreenX() - xOffSet);
				Main.stage.setY(event.getScreenY() - yOffSet);
				Main.stage.setOpacity(0.8f);
			}else{
				event.consume();
			}

		});

		top.setOnDragDone((event) -> {
			Main.stage.setOpacity(1.0f);
		});

		top.setOnMouseReleased((event) -> {
			Main.stage.setOpacity(1.0f);
		});


	}

    private void initDrawer(){
    	try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/view/Dashboard_drawer.fxml"));
			ScrollPane pane = loader.load();
			drawerController = loader.getController();
			drawerController.setMainTela(this);
			drawer.setSidePane(pane);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

    }

    private void initializeMenu(){

    	Util.contentPane = contentPane;

    	HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
		transition.setRate(-1);

		hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED,(e)->{
			transition.setRate(transition.getRate()*-1);
			transition.play();

			if(drawer.isShown()){
				drawer.close();
			}else{
				drawer.open();
			}
		});

    	drawer.setOnDrawerClosed(e -> {
    		if(transition.getRate() == 1){
    			transition.setRate(transition.getRate()*-1);
    			transition.play();
    		}
    	});

    }


    void enableHamburger(){
    	if(hamburger.isDisabled()){
    		hamburger.setDisable(false);
        	hamburger.setVisible(true);
    	}else{
    		hamburger.setDisable(true);
        	hamburger.setVisible(false);
    	}

    }

    void disableDrawer(){
    	if(drawer.isShown()){
    		drawer.close();
    	}
    	if(!drawer.isShown()){
    		drawer.setDisable(true);
    	}

    }

    void enableDrawer(){
    	if(drawer.isDisabled()){
    		drawer.setDisable(false);
    		drawer.open();
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {


		initDrawer();

		dr = drawer;

		enableHamburger();
		makeStageDragable();

		initDrawer();

		initializeMenu();

	}

	public StackPane getContentPane() {
		return contentPane;
	}

	public void setContentPane(StackPane contentPane) {
		this.contentPane = contentPane;
	}





}
