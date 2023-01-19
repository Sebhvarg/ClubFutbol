
package clubfutbol.torerosclub.conexion;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;

public class RivalesComb {
    public static String datos;
    public static ArrayList<String> cargaRivales;
    public static String recuperarRivales(){
     try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call clubesBox(?)}");
           
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.execute();            
            datos = cst.getString(1);  
            
         
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return datos;
    
    }
    public static ArrayList<String> cargarDatos(){
        cargaRivales = new ArrayList();
        String x = RivalesComb.recuperarRivales();
        for (String s : x.split(",") ){
            cargaRivales.add(s);
        }
        return cargaRivales;
        
}
    
}
