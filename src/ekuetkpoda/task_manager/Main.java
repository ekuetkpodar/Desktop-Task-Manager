package ekuetkpoda.task_manager;

/**launch The Application
 * 
 * @author Ekue Kpodar
 *
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * launch The Application
 * 
 * @author Ekue Kpodar
 *
 */
public class Main extends Application {
	private static final String GUI_RESOURCE = "view/MainWindow.fxml";

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource(GUI_RESOURCE));
		Scene scene = new Scene(parent);
		primaryStage.setTitle("Task Manager");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Launch application
	 * 
	 * @param args
	 *            The main args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}