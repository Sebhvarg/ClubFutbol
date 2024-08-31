package clubfutbol.torerosclub;

import java.io.IOException;
import java.util.Calendar;
import javafx.fxml.FXML;

public class DT {
    public void cerrarSesion() throws IOException{
        System.out.println("Cerrando sesión a las: "+ Calendar.getInstance());
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("login");
        
    }
    public void editarPosicion() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("cambiarJugador");         
    }
    
    public void consultarJugador() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("conJugador");           
    }
    public void temporada() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("temporada");           
    }
    
    public void regPartido() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("rPartido");           
    }
    public void regRendimiento() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("rRendimiento");           
    }

    
}