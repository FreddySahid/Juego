package sample;
import javafx.scene.layout.BorderPane;

public class ContenedorPrincipal extends BorderPane{
    private AreaPelota areaPelota;
    public ContenedorPrincipal(){
        areaPelota = new AreaPelota();

        setCenter(areaPelota);


    }
}
