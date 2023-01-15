package clubfutbol.torerosclub;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
public class App extends Application {

    private static Scene scene;
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        scene = new Scene(loadFXML("login"), 720, 480);
        stage.setScene(scene);
        stage.getIcons().add(new Image("clubfutbol/torerosclub/files/escudo.png") ); 
        stage.setResizable(false);
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
    public static Scene getScene(){
        return scene;
    }

    public static Stage getStage() {
        return stage;
    }
    
    public static void main(String[] args) {
        launch();
    
    }
    
}