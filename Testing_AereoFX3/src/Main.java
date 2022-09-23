
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
			CreaFile p = new CreaFile("Lista Aerei Atterrati.txt");
			CreaFile g = new CreaFile("Lista Aerei Decollati.txt");
			CreaFile f = new CreaFile("atterraggi_incorso.txt");
			CreaFile m = new CreaFile("decolli_incorso.txt");
			Parent root = FXMLLoader.load(getClass().getResource("GraficaSuper.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Controllore");
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
}