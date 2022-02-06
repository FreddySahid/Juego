package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;




public class AreaPelota extends Pane {

    public static Circle circulo;
    public static Pane canvas;




    Circle circle;

    public AreaPelota(){
        canvas = new Pane();
        final Scene scene = new Scene(canvas, 800, 600);

        circulo = new Circle(15, Color.BLUE);
        circulo.relocate(100, 100);

        canvas.getChildren().addAll(circulo);

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
                }

                if (BordeInferior || BordeSuperior) {
                    deltaY *= -1;
                }
            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
        getChildren().add(canvas);




    }


}
