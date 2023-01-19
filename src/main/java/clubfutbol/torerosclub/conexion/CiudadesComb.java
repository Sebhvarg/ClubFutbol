
package clubfutbol.torerosclub.conexion;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class CiudadesComb {
    public static String datos;
    public static ArrayList<String> cargaCiudades;
    public static String recuperarCiudades(){
     try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call ciudadesBox(?)}");
           
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.execute();            
            datos = cst.getString(1);  
            
         
        } catch (SQLException e) {
        }        
        return datos;
    
    }
    public static ArrayList<String> cargarDatos(){
        cargaCiudades = new ArrayList();
        String x = CiudadesComb.recuperarCiudades();
        for (String s : x.split(",") ){
            cargaCiudades.add(s);
        }
        return cargaCiudades;
        
}
    
}
