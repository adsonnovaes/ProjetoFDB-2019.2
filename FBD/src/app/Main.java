package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	public static String SENHA = "123";
	public static String LOGIN = "admin";

	public static Stage stage = null;

	private static Scene loginScene;
	private static Scene mainScene;


	@Override
	public void start(Stage primaryStage) throws IOException {

		Pane login = FXMLLoader.load(getClass().getResource("/view/TelaLogin.fxml"));
		loginScene = new Scene(login);

		Pane main = FXMLLoader.load(getClass().getResource("/view/TelaPrincipal.fxml"));
		mainScene = new Scene(main);


		primaryStage.setScene(loginScene);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		stage = primaryStage;
		primaryStage.show();

	}

	public static void changerScene() {
			stage.setMaximized(true);
			stage.setScene(mainScene);

	}

	public static void main(String[] args) {
	    launch(args);

	}

}
