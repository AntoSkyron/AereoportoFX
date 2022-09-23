
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	@SuppressWarnings("unused")
	@Override
	public void start(Stage stage) {

		Stage due = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("GraficaRadar.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Radar");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
}