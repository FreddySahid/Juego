package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        ContenedorPrincipal contenido = new ContenedorPrincipal();

        ScrollPane root = new ScrollPane();
        root.setContent(contenido);
        root.setFitToHeight(true);
        root.setFitToWidth(true);



        Scene escena = new Scene(root, 800, 600);

        primaryStage.setTitle("Juego");
        primaryStage.setScene(escena);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
