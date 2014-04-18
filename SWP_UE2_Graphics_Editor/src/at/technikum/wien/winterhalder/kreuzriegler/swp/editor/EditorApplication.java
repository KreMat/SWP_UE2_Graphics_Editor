/**
 * 
 */
package at.technikum.wien.winterhalder.kreuzriegler.swp.editor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Matthias
 * 
 */
public class EditorApplication extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"ue2-gui.fxml"));
		AnchorPane root = (AnchorPane) fxmlLoader.load();

		// Szene
		Scene scene = new Scene(root);

		// Titel setzen
		primaryStage.setTitle("SWP - UE2 - Paint");

		// Szene setzen
		primaryStage.setScene(scene);

		// Stage anzeigen
		primaryStage.show();
	}

}
