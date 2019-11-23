package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.TimeZone;

import fachada.Fachada;
import fachada.IFachada;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sql.FillData;

public class Main extends Application {

	public static String SENHA = "123";
	public static String LOGIN = "admin";

	public static Stage stage = null;

	private static Scene loginScene;
	private static Scene mainScene;

	public static IFachada fachada = Fachada.getInstance();



	@Override
	public void start(Stage primaryStage) throws IOException, SQLException {

		TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
		new FillData();

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
