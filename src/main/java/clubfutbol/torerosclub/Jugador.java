package clubfutbol.torerosclub;

import java.io.IOException;
import java.util.Calendar;

public class Jugador {
     public void cerrarSesion() throws IOException{
        System.out.println("Cerrando sesión a las: "+ Calendar.getInstance());
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("login");
        
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

}
