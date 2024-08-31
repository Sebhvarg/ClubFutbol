package clubfutbol.torerosclub;

import clubfutbol.torerosclub.conexion.JugadoresComb;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class conJugadorDT implements Initializable{
    @FXML
    private ComboBox boxPosicion;
    @FXML
    private ComboBox boxJugadores;
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot(Login.getUsrA());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxJugadores.getItems().addAll(JugadoresComb.cargarDatos());
        boxPosicion.getItems().add(0, "Portero");
        boxPosicion.getItems().add(1, "Defensa");
        boxPosicion.getItems().add(2, "Mediocampo");
        boxPosicion.getItems().add(3, "Delantero");
       
    }
    public void consultar(){
    
    }
    
    
}
