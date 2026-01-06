import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// TODO: place MainCOntroller int he controlelr package, leave the other 2 files in the same directory for now

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400); // set window size
        stage.setScene(scene);
        stage.setTitle("My App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}