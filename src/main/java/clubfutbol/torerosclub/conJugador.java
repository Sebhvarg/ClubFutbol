package clubfutbol.torerosclub;

import java.io.IOException;

public class conJugador {
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("presidente");
    }
    
}
