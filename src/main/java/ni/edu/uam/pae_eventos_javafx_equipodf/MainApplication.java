package ni.edu.uam.pae_eventos_javafx_equipodf;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("EventosNavegacion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 600);
        scene.getStylesheets().add(MainApplication.class.getResource("styles.css").toExternalForm());
        stage.setTitle("Gestión de Eventos y Navegación");
        stage.setMinWidth(700);
        stage.setMinHeight(500);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}