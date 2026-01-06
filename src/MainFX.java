import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// TODO: place controller.javafx_controller.MainController in the controller package, leave the other 2 files in the same directory for now
// TODO: ill have to communicate between 2 controllers (see more on that)
public class MainFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // open main window
        FXMLLoader primaryLoader = new FXMLLoader(getClass().getResource("view/javafx_view/MainView.fxml"));
        Scene primaryScene = new Scene(primaryLoader.load(), 600, 400);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("My Interpreter");
        primaryStage.show();

        // open programs window
        Stage secondaryStage = new Stage();
        FXMLLoader secondaryLoader = new FXMLLoader(getClass().getResource("view/javafx_view/ProgramsView.fxml"));
        Scene secondaryScene = new Scene(secondaryLoader.load(), 600, 400);
        secondaryStage.setScene(secondaryScene);
        secondaryStage.setTitle("All Programs");
        secondaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}