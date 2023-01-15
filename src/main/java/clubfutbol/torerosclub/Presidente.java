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
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("addJugador");         
    }
    
    public void venderJugador() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("delJugador");         
    }
    
    public void consultarJugador() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("delJugador");           
    }
    public void temporada() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("temporada");           
    }
    public void liga() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("liga");           
    }
    public void fondos() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("fondos");           
    }
    public void addDT() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("addDT");           
    }
    public void delDT() throws IOException{
        App.getStage().setResizable(true);
        App.getStage().setMinHeight(480);
        App.getStage().setMinWidth(720);
        App.setRoot("delDT");           
    }
    
  
}
