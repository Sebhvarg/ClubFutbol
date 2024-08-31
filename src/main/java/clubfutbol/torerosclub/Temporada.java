/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubfutbol.torerosclub;

import static clubfutbol.torerosclub.ClubesLiga.clubes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import clubfutbol.torerosclub.conexion.Años;
import static clubfutbol.torerosclub.conexion.Años.datos;
import clubfutbol.torerosclub.conexion.ConexionMysql;
import clubfutbol.torerosclub.modulos.tablas.DatosTemporada;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class Temporada implements Initializable {
    @FXML
    private ComboBox comboAño;
    
    @FXML 
    private Button btnConsultar;
    
    @FXML 
    private Label datoPJ;
    @FXML 
    private Label datoPG;
    @FXML 
    private Label datoPE;
    @FXML 
    private Label datoPP;
    @FXML 
    private Label datoPTS;
    @FXML 
    private Label datoLiga;
    @FXML 
    private Label datoTitulo;
    
    
    
    public void volver() throws IOException{
        App.getStage().setResizable(false);
        App.getStage().setHeight(480);
        App.getStage().setWidth(720);
        App.setRoot(Login.getUsrA());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboAño.getItems().addAll(Años.cargarDatos());


        
    }
    public void borrarAño(){
        comboAño.getItems().clear();
        comboAño.getItems().addAll(Años.cargarDatos());
        datoPJ.setText("");
        datoPG.setText("");
        datoPE.setText("");
        datoPP.setText("");
        datoPTS.setText("");
        datoLiga.setText("");
        datoTitulo.setText("");
       
    }
    public void capturaDatos(){
        if (comboAño.getValue() == null) {
           btnConsultar.setDisable(true);
        }else{
            btnConsultar.setDisable(false);
        }
        
    }
        public void consultarDatos(){
            try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call temporada(?,?,?,?,?,?,?,?)}");
           String a = String.valueOf(comboAño.getValue());
            cst.setString(1, a);
                        
            
            cst.execute();  
            cst.registerOutParameter(2, Types.VARCHAR);
            String d1 = cst.getString(2);
            String d2 = cst.getString(3);
            String d3 = cst.getString(4);
            datoPJ.setText(d1);
            cst.registerOutParameter(3, Types.VARCHAR);
            datoPG.setText(d2);
            
            cst.registerOutParameter(4, Types.VARCHAR);
            datoPE.setText(d3);
            cst.registerOutParameter(5, Types.VARCHAR);
             datoPP.setText(cst.getString(5));
            cst.registerOutParameter(6, Types.VARCHAR);
                 datoPTS.setText(cst.getString(6));
            cst.registerOutParameter(7, Types.VARCHAR);
                  datoLiga.setText(cst.getString(7));
            cst.registerOutParameter(8, Types.VARCHAR);
         
            datoTitulo.setText(cst.getString(8));
            
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    
}
