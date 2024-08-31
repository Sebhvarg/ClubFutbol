
package clubfutbol.torerosclub;

import clubfutbol.torerosclub.conexion.CiudadesComb;
import clubfutbol.torerosclub.conexion.EstadiosComb;
import clubfutbol.torerosclub.conexion.RivalesComb;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class rPartido implements Initializable{
    @FXML 
    private ComboBox boxRival;
    
    @FXML 
    private ComboBox boxCiudad;
    
    @FXML 
    private ComboBox boxEstadio;
    
    @FXML 
    private ComboBox boxTorneo;
    
    
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot(Login.getUsrA());
    }
    
    public void revision(){
    
    }
    public void borrarTodo(){
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       boxRival.getItems().addAll(RivalesComb.cargarDatos());
       boxCiudad.getItems().addAll(CiudadesComb.cargarDatos());
       boxEstadio.getItems().addAll(EstadiosComb.cargarDatos());
       boxRival.setEditable(true);
       boxEstadio.setEditable(true);
       boxCiudad.setEditable(true);
       boxTorneo.getItems().add(0, "Liga");
       boxTorneo.getItems().add(1, "Torneo Internacional");
       boxTorneo.getItems().add(2, "Amistoso");
    }
    
}
