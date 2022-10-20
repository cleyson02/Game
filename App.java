import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tela.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        primaryStage.setTitle("Game On!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}