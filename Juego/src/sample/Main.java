package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public Circle circulo;
    public static Pane canvas;
    BorderPane borderPane;
    public Label puntaje;
    public int cont;

    @Override
    public void start(Stage primaryStage) throws Exception{

        canvas = new Pane();
        borderPane = new BorderPane();
        borderPane.setCenter(canvas);


        circulo = new Circle(15, Color.RED);
        circulo.relocate(100, 100);

        canvas.getChildren().addAll(circulo);





        final Scene escena = new Scene(borderPane, 800, 600);

        primaryStage.setTitle("Juego");
        primaryStage.setScene(escena);
        primaryStage.show();

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

            double deltaX = 3;
            double deltaY = 3;

            @Override
            public void handle(final ActionEvent t) {
                circulo.setLayoutX(circulo.getLayoutX() + deltaX);
                circulo.setLayoutY(circulo.getLayoutY() + deltaY);

                final Bounds limites = canvas.getBoundsInLocal();
                final boolean BordeDerecho = circulo.getLayoutX() >= (limites.getMaxX() - circulo.getRadius());
                final boolean BordeIzquierdo = circulo.getLayoutX() <= (limites.getMinX() + circulo.getRadius());
                final boolean BordeInferior = circulo.getLayoutY() >= (limites.getMaxY() - circulo.getRadius());
                final boolean BordeSuperior = circulo.getLayoutY() <= (limites.getMinY() + circulo.getRadius());

                if (BordeDerecho || BordeIzquierdo) {
                    deltaX *= -1;
                    circulo.setFill(Color.color(Math.random(), Math.random(), Math.random()));


                }

                if (BordeInferior || BordeSuperior) {
                    deltaY *= -1;
                    circulo.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                }
            }
        }));



        cont = 0;
        puntaje = new Label("");
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {
                cont+=1;
                puntaje.setText("Número de clicks: " + cont);
                canvas.getChildren().add(puntaje);
            }
        });

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
