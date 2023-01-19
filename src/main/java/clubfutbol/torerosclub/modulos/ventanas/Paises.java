package clubfutbol.torerosclub.modulos.ventanas;

import static clubfutbol.torerosclub.modulos.ventanas.Paises.muestraContenido;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Paises {
     public static ArrayList<String> listapaises = new  ArrayList<>();

    
    public static void muestraContenido() throws FileNotFoundException, IOException { 
        File file = new File("C:\\Users\\sebas\\OneDrive\\Documentos\\NetBeansProjects\\ClubFutbol\\src\\main\\java\\clubfutbol\\torerosclub\\modulos\\archivostxt\\listaPaises.txt"); 
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    listapaises.add(line);
                    
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
	} 
    public static ArrayList<String> getListapaises() throws IOException {
        muestraContenido();
        return listapaises;
    }
    
}

