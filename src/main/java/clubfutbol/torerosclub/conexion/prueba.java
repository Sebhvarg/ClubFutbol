/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubfutbol.torerosclub.conexion;

import clubfutbol.torerosclub.modulos.seguridad.ComprobarUsr;
import clubfutbol.torerosclub.modulos.ventanas.Paises;
import java.io.IOException;

/**
 *
 * @author sebas
 */
public class prueba {
    public static void main(String[] args) throws IOException {
        
        for (String s : Paises.getListapaises()){
            System.out.println(s);
        }
    }
    
}
