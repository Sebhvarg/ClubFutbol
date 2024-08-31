
package clubfutbol.torerosclub;


import clubfutbol.torerosclub.conexion.mostrarFondos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class Fondos implements Initializable{
    @FXML
    private Label dineroClub;
    @FXML
    private Label dineroFichaje;
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot(Login.getUsrA());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       dineroFichaje.setText(mostrarFondos.recuperarFondos().get(1));
        dineroClub.setText(mostrarFondos.recuperarFondos().get(0));
    }
    
    
    
}
