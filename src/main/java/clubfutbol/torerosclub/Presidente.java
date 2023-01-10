package clubfutbol.torerosclub;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Presidente extends Application{

     private static Scene scene;
 

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("presidente"), 720, 480);
        stage.setScene(scene);
        stage.getIcons().add(new Image("clubfutbol/torerosclub/files/escudo.png") ); 
        stage.setResizable(true);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Toreros FC");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch();
    }
}
