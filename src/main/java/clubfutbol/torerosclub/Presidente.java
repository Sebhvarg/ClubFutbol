package clubfutbol.torerosclub;
import java.io.IOException;
import java.util.Calendar;


public class Presidente{
    
    public void cerrarSesion() throws IOException{
        System.out.println("Cerrando sesión a las: "+ Calendar.getInstance());
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("login");
        
    }
    public void agregarJugador() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("login");
        
    }
        
}
