package clubfutbol.torerosclub.conexion;

import static clubfutbol.torerosclub.conexion.CiudadesComb.datos;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class mostrarFondos{
    private static ArrayList<String> fondos = new ArrayList<>();
    public static ArrayList<String> recuperarFondos(){
        try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call mostrarFondos(?, ?)}");
           
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.registerOutParameter(2, Types.VARCHAR);
            cst.execute();            
            String f1 = cst.getString(1);  
            String f2 = cst.getString(2);
            
            fondos.add(f1);
            fondos.add(f2);
            
            
         
        } catch (SQLException e) {
        }        
        return fondos;
        
    
        
    
    }
    
}
