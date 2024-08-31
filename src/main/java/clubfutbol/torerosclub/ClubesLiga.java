/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubfutbol.torerosclub;

import clubfutbol.torerosclub.conexion.Años;
import clubfutbol.torerosclub.conexion.ConexionMysql;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;

public class ClubesLiga {
    public static String clubes;
    public static ArrayList<String> cargaClubes;
    public static String recuperarClubes(){
     try {
            ConexionMysql cm = new ConexionMysql();
            CallableStatement cst = cm.getConnection().prepareCall("{call clubesBox(?)}");
           
            cst.registerOutParameter(1, Types.VARCHAR);
            cst.execute();            
            clubes = cst.getString(1);  
            
         
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return clubes;
    
    }
    public static ArrayList<String> cargarDatos(){
        cargaClubes = new ArrayList();
        String x = ClubesLiga.recuperarClubes();
        for (String s : x.split(",") ){
            cargaClubes.add(s);
        }
        return cargaClubes;
        
}
    
}
