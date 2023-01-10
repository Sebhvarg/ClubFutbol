/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubfutbol.torerosclub.modulos.ventanas;

import clubfutbol.torerosclub.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author sebas
 */
public class Ventana 
{
    public String tipo;
    public Ventana(String tipo){
        this.tipo = tipo;
    }
    private static Scene scene;
    public static Stage stage ;
    public void run() {
                       Parent  root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource(this.tipo+".fxml"));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                       Scene scene = new Scene(root);
                       stage = new Stage();
                       stage.setTitle("Toreros FC | - Menú de "+this.tipo);
                       stage.getIcons().add(new Image("clubfutbol/torerosclub/files/escudo.png") ); 
                       stage.setMaximized(true);
                       stage.setResizable(false);
                       stage.setScene(scene);
                       stage.show();
                    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public Stage getStage(){
        return stage;
    }

    public static Scene getScene() {
        return scene;
    }
    
    
}
