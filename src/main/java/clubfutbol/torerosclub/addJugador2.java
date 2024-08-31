
package clubfutbol.torerosclub;

import clubfutbol.torerosclub.conexion.ConexionMysql;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class addJugador2 implements Initializable{
    @FXML
    private ComboBox boxPH;
    @FXML
    private ComboBox boxAltura;
    @FXML
    private ComboBox boxPeso;
    @FXML
    private ComboBox boxPosicion;
    @FXML
    private ComboBox boxDorsal;
    @FXML
    private ComboBox boxFichaje;
    @FXML
    private CheckBox seleccion;
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("presidente");
    }
    public void borrarTodo(){
    }
    public void addJugadorFinal() throws IOException{
         try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call addJugador2(?,?,?,?,?,?,?,?)}");
           String a = String.valueOf(boxPH.getValue());
           String pos = String.valueOf(boxPosicion.getValue());
           String dor = String.valueOf(boxDorsal.getValue());
           String f = String.valueOf(boxFichaje.getValue());
           float al = Float.parseFloat((String) boxAltura.getValue());
           float p = Float.parseFloat((String) boxPeso.getValue());
            cst.setString(1, a);
            cst.setBoolean(2,seleccion.isSelected()); 
            cst.setFloat(3, al);
            cst.setFloat(4, p);
            cst.setString(5, pos);
            cst.setString(6, dor);
            cst.setString(7, f);
            cst.execute();  
           
         
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
         App.setRoot("presidente");
         }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         for (int i = 145; i<=210 ; i++){
            boxAltura.getItems().add((i-145), i);
        }
         for (int i = 44; i<=170 ; i++){
            boxPeso.getItems().add((i-44), i);
        }
        for (int i = 1; i<=99 ; i++){
            boxDorsal.getItems().add((i-1), i);
        }
        boxFichaje.getItems().add(0, "Contrato");
        boxFichaje.getItems().add(1, "Prestamo");
        boxPH.getItems().add(0, "Izquierda");
        boxPH.getItems().add(1, "Derecha");
        boxPosicion.getItems().add(0, "Portero");
        boxPosicion.getItems().add(1, "Defensa");
        boxPosicion.getItems().add(2, "Mediocampo");
        boxPosicion.getItems().add(3, "Delantero");
    }
    
}
