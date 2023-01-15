package clubfutbol.torerosclub;

import clubfutbol.torerosclub.modulos.ventanas.Paises;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 *
 * @author sebas
 */
public class addJugador implements Initializable {
    
    @FXML     
    private ComboBox<String> box;
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("presidente");
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            box.getItems().addAll(Paises.getListapaises());
            box.promptTextProperty().setValue("Ecuador");
        } catch (IOException ex) {
            Logger.getLogger(addJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
}
