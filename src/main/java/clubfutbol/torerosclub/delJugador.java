
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class delJugador implements Initializable {
    @FXML
    private ComboBox cmbJugadores;
    @FXML
    private Button btnvender;
    @FXML
    private TextField club;
    @FXML
    private TextField precio;
    @FXML
    private Label confventa;
    @FXML
    private CheckBox conf;
    
    
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot(Login.getUsrA());
    }
    public void vender() throws IOException{
        try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call venderJugador(?, ?)}");
            String ns = String.valueOf(cmbJugadores.getValue());
            String[] na = ns.split(" ");
            cst.setString(1, na[0]+" "+na[1]);
            cst.setString(2, na[2]+" "+na[3]);
            cst.execute();
             System.out.println( na[0]+" "+na[1]);
             System.out.println( na[2]+" "+na[3]);
             
        } catch (Exception e) {
            e.printStackTrace();
        }        
        confventa.setText("El jugador ha sido vendido!");
    }
    public void confVen(){
    if(conf.isSelected()){
            btnvender.setDisable(false);
            
        }else{
        btnvender.setDisable(true);
         
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbJugadores.getItems().addAll(JugadoresComb.cargarDatos());
        btnvender.setDisable(true);
        
        
    }
    
}
