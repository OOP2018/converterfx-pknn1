package converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Run the application.
 *
 * @author Pakanon Pantisawat
 */
public class Main extends Application {

    /**
     * Start the application.
     * @param stage FXML stage.
     */
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("ConverterUI.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Converter");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();
        } catch (Exception e) {
            System.err.println("Exception creating scene: " + e.getMessage());
        }
    }

    /**
     * Launch the application.
     * @param args argument of the java application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
