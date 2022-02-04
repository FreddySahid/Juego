package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ContenedorPrincipal contenido = new ContenedorPrincipal();
        ScrollPane root = new ScrollPane();
        root.setContent(contenido);
        root.setFitToHeight(true);
        root.setFitToWidth(true);


        Scene escena = new Scene(root, 1000, 550);


        primaryStage.setTitle("Super juego");
        primaryStage.setScene(escena);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
