
package clubfutbol.torerosclub.conexion;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;

public class JugadoresComb {
    public static String datos;
    public static ArrayList<String> cargaJugadores;
    public static String recuperarJugadores(){
     try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call jugadoresBox(?)}");
           
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.execute();            
            datos = cst.getString(1);  
            
         
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return datos;
    
    }
    public static ArrayList<String> cargarDatos(){
        cargaJugadores = new ArrayList();
        String x = JugadoresComb.recuperarJugadores();
        for (String s : x.split(",") ){
            cargaJugadores.add(s);
        }
        return cargaJugadores;
        
}
    
}
