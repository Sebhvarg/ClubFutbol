package clubfutbol.torerosclub;

import clubfutbol.torerosclub.conexion.ConexionMysql;
import clubfutbol.torerosclub.conexion.JugadoresComb;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class conJugador implements Initializable{
    
    @FXML
    private ComboBox boxJugadores;
    @FXML
    private Label lcedula;
    @FXML
    private Label lcorreo;
    @FXML
    private Label lsueldo;
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot(Login.getUsrA());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxJugadores.getItems().addAll(JugadoresComb.cargarDatos());
       
    }
    public void consultar(){
         try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call consultarJugador(?, ?, ?, ?, ?)}");
            String ns = String.valueOf(boxJugadores.getValue());
            String[] na = ns.split(" ");
            cst.setString(1, na[0]+" "+na[1]);
            cst.setString(2, na[2]+" "+na[3]);
            cst.registerOutParameter(3, Types.VARCHAR);
            cst.registerOutParameter(4, Types.VARCHAR);
            cst.registerOutParameter(5, Types.VARCHAR);
            
            cst.execute();
            
            lcedula.setText(cst.getString(3));
            lcorreo.setText(cst.getString(4));
            lsueldo.setText(cst.getString(5));
             System.out.println( na[0]+" "+na[1]);
             System.out.println( na[2]+" "+na[3]);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
}
