package clubfutbol.torerosclub;
import clubfutbol.torerosclub.modulo.seguridad.ComprobarUsr;
import clubfutbol.torerosclub.modulos.ventanas.Ventana;
import javafx.scene.Node;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
public class Login{
    private static int intentos = 0;
    @FXML
    Label error;
    @FXML
    Button login;
    @FXML
    TextField email;
    @FXML
    PasswordField cedula;
    @FXML
    private void  cerrar(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    @FXML 
    private void  login() throws IOException{
        if (cedula.getText().strip().length() > 11){
            email.clear();
            cedula.clear();
            intentos += 1;
            error.setText("Datos incorrectos, el programa se bloqueará al tercer intento \n Usted ha intendado "+intentos+"/3 veces");
            
        }else{
            email.setEditable(false);
            cedula.setEditable(false);
        String usr = ComprobarUsr.ComprobarUSR(email.getText().strip(), cedula.getText().strip());
        switch (usr) {
            case "Presidente":
                App.getStage().setResizable(true);
                App.getStage().setMaximized(true);
                App.getStage().setMinHeight(App.getScene().getHeight());
                App.getStage().setMinWidth(App.getScene().getWidth());
                App.setRoot("presidente");
                break;

            case "DT":
                App.setRoot("secondary");
                break;
                
            default:
                email.setEditable(true);
                cedula.setEditable(true);
                email.clear();
                cedula.clear();
                
                intentos += 1;
                error.setText("Datos incorrectos, el programa se bloqueará al tercer intento \n Usted ha intendado "+intentos+"/3 veces");
                
            
            }
        }
        if (intentos == 3){
            error.setText("Informando a las autoridades del club el ingreso fallido");
            login.setDisable(true);
            email.setDisable(true);
            cedula.setDisable(true);
        }
    }

    public static int getIntentos() {
        return intentos;
    }

}
