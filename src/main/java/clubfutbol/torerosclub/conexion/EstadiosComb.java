
package clubfutbol.torerosclub.conexion;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class EstadiosComb {
    public static String datos;
    public static ArrayList<String> cargaEstadios;
    public static String recuperarEstadios(){
     try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call estadiosBox(?)}");
           
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.execute();            
            datos = cst.getString(1);  
            
         
        } catch (SQLException e) {
        }        
        return datos;
    
    }
    public static ArrayList<String> cargarDatos(){
        cargaEstadios = new ArrayList();
        String x = EstadiosComb.recuperarEstadios();
        for (String s : x.split(",") ){
            cargaEstadios.add(s);
        }
        return cargaEstadios;
        
}
    
}
