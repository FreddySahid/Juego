package sample;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ContenedorPrincipal extends BorderPane{

    private AreaPelota areaPelota;

    public ContenedorPrincipal(){
        areaPelota = new AreaPelota();
        setCenter(areaPelota);

    }
}
