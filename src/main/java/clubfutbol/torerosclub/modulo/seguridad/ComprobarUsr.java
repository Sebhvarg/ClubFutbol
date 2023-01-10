
package clubfutbol.torerosclub.modulo.seguridad;

import clubfutbol.torerosclub.conexion.ConexionMysql;
import java.sql.CallableStatement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ComprobarUsr {
    public static String usr;

    public static String ComprobarUSR(String email, String cedula){
        
        email = email+"@torerosfc.ec";
        try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call login(?,?,?)}");
            cst.setString(1, email);
            cst.setString(2, cedula);
            cst.registerOutParameter(3, Types.VARCHAR);
            cst.execute();            
            usr = cst.getString(3);  
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            System.out.println("Ingresó: "+email+" el:"+ dtf.format(LocalDateTime.now()));
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return usr;
        
    }
    
}
