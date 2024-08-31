
package clubfutbol.torerosclub.conexion;

import java.sql.CallableStatement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Años {
    public static String datos;
    public static ArrayList<String> cargaAños;
    public static String recuperarAños(){
     try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call años(?)}");
           
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.execute();            
            datos = cst.getString(1);  
            
         
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return datos;
    
    }
    public static ArrayList<String> cargarDatos(){
        cargaAños = new ArrayList();
        String x = Años.recuperarAños();
        for (String s : x.split(",") ){
            cargaAños.add(s);
        }
        return cargaAños;
        
}
    
}
