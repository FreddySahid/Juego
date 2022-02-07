package sample;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ContenedorPrincipal extends Pane{

    AreaPelota areaPelota;

    public ContenedorPrincipal(){
        areaPelota = new AreaPelota();
        getChildren().add(areaPelota);

    }
}
