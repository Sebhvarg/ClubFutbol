package clubfutbol.torerosclub;

import static clubfutbol.torerosclub.addDT.capitalize;
import clubfutbol.torerosclub.conexion.ConexionMysql;
import clubfutbol.torerosclub.modulos.ventanas.Paises;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addJugador implements Initializable {
    
    @FXML     
    private ComboBox<String> box;
    @FXML     
    private TextField nombre1;
    @FXML     
    private TextField nombre2;
    @FXML     
    private TextField apellido1;
    @FXML     
    private TextField apellido2;
    @FXML     
    private TextField cedula;
    @FXML     
    private DatePicker fechaNac;
    @FXML     
    private DatePicker iniContr;
    @FXML     
    private DatePicker finContr;
    @FXML     
    private TextField sueldo;
    @FXML     
    private TextField celular;
    @FXML     
    private Label correofinal;
    @FXML     
    private Button borrar;
    @FXML     
    private Button next;
    @FXML     
    private CheckBox checkInfo;
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot("presidente");
    }
    public void borrarTodo() throws IOException{
        box.setValue(null);
        nombre1.clear();
        nombre2.clear();
        apellido1.clear();
        apellido2.clear();
        cedula.clear();
        fechaNac.setValue(null);
        iniContr.setValue(null);
        finContr.setValue(null);
        sueldo.clear();
        celular.clear();
        
    }
      public void revision() throws IOException{
        
        if(checkInfo.isSelected() != false && nombre1.getText() != null &&
        nombre2.getText() != null &&
        apellido1.getText() != null &&
        apellido2.getText() != null &&
        cedula.getText() != null &&
        fechaNac.getValue() != null &&
        iniContr.getValue() != null &&
        finContr.getValue() != null &&
        sueldo.getText() != null &&
        celular.getText() != null){
            next.setDisable(false);
        }else{
            next.setDisable(true);
        }
     }
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            box.getItems().addAll(Paises.getListapaises());
            box.promptTextProperty().setValue("Ecuatoriana");
            next.setDisable(true);
        } catch (IOException ex) {
            Logger.getLogger(addJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(checkInfo.isSelected() != false && nombre1.getText() != null &&
        nombre2.getText() != null &&
        apellido1.getText() != null &&
        apellido2.getText() != null &&
        cedula.getText() != null &&
        fechaNac.getValue() != null &&
        iniContr.getValue() != null &&
        finContr.getValue() != null &&
        sueldo.getText() != null &&
        celular.getText() != null){
            next.setDisable(false);
        }else{
            next.setDisable(true);
        }
            
        
    }
    public void siguiente() throws IOException{
        if(nombre1.getText().matches("^[a-zA-Z]*$") &&  
        apellido1.getText().matches("^[a-zA-Z]*$") &&
        cedula.getText().length() <=10 &&
        fechaNac.getValue() != null &&
        iniContr.getValue() != null &&
        finContr.getValue() != null &&
        sueldo.getText().matches("[0-9]+") &&
        celular.getText().matches("[0-9]+")){
            String n2 = "";
            String a2 = "";
            if (nombre2.getText() != null && nombre2.getText().matches("^[a-zA-Z]*$")){
                n2 = capitalize( nombre2.getText().strip().toLowerCase());
            }
            if (apellido2.getText() != null && apellido2.getText().matches("^[a-zA-Z]*$")){
                a2 = capitalize( apellido2.getText().strip().toLowerCase());
            }
         String n1 = capitalize( nombre1.getText().strip().toLowerCase());
         String a1 = capitalize( apellido1.getText().strip().toLowerCase());
         String fechN = String.valueOf(fechaNac.getValue());
         String iniC = String.valueOf(iniContr.getValue());
         String finC = String.valueOf(finContr.getValue());
         String cd = cedula.getText().strip().toUpperCase();
         float sd = Float.parseFloat(sueldo.getText().strip());
         String cell = celular.getText().strip();
         String ema = String.valueOf(n1.charAt(0))+String.valueOf(n1.charAt(1))+String.valueOf(a1.charAt(0))+String.valueOf(a1.charAt(3))+String.valueOf(a1.charAt(2))+String.valueOf(n1.charAt(3))+"@torerosfc.ec";
         ema = ema.toLowerCase();
         try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call addJugador(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1, cd);
            cst.setString(2, n1+ " "+ n2);
            cst.setString(3, a1+ " "+ a2);
            cst.setString(4, String.valueOf(box.getValue()));
            cst.setString(5, iniC);
            cst.setString(6, finC);
            cst.setFloat(7, sd);
            cst.setString(8, fechN);
            cst.setString(9, cell);
            cst.setString(10, ema);
            
            cst.registerOutParameter(11, Types.VARCHAR);
            cst.registerOutParameter(12, Types.VARCHAR);
            cst.execute();            
            String em = cst.getString(11);
            correofinal.setText("El correo es: "+ em);
            App.setRoot("addJugador2");
        } catch (IOException | SQLException e) {
        }        
         
        }else{
        correofinal.setText("Error: revise los datos");
        }
    }
}
