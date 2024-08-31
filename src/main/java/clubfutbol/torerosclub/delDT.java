
package clubfutbol.torerosclub;

import clubfutbol.torerosclub.conexion.ConexionMysql;
import static clubfutbol.torerosclub.modulos.seguridad.ComprobarUsr.usr;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class delDT implements Initializable{
    @FXML
    private Label nombreDT;
    @FXML
    private Label mensajeDt;
    @FXML
    private Button btnDespedirDt;
    private static String name;
    
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot(Login.getUsrA());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call nombreDT(?)}");
            cst.registerOutParameter(1, Types.VARCHAR);
            
            
            cst.execute(); 
            name =cst.getString(1);
            System.out.println(name);
            nombreDT.setText(name);
        } catch (Exception e) {
            e.printStackTrace();
        }        
        if(name == null){
            btnDespedirDt.setDisable(true);
        }else{
            btnDespedirDt.setDisable(false);
        }
        
    }
    public void  btnDespedir(){
        try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call despedirDT(?)}");
            cst.registerOutParameter(1, Types.VARCHAR);            
            cst.execute(); 
            name =cst.getString(1);
            System.out.println(name);
            mensajeDt.setText("Ha despedido al DT del club le deseamos éxitos en su futuro!");
        } catch (Exception e) {
        }
        if(name == null){
            btnDespedirDt.setDisable(true);
        }else{
            btnDespedirDt.setDisable(false);
        }
    
    }
    
    
}
