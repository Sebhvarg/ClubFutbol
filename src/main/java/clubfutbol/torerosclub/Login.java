package clubfutbol.torerosclub;
import clubfutbol.torerosclub.modulo.seguridad.ComprobarUsr;
import javafx.scene.Node;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
            login.setDisable(false);
            error.setText("Datos incorrectos, el programa se bloqueará al tercer intento \n Usted ha intendado "+intentos+"/3 veces");
            
        }else{
            login.setDisable(true);
            email.setEditable(false);
            cedula.setEditable(false);
        String usr = ComprobarUsr.ComprobarUSR(email.getText().strip(), cedula.getText().strip());
        switch (usr) {
            case "Presidente":
                App.setRoot("presidente");
                break;

            case "DT":
                App.setRoot("DT");
                break;
            case "Jugador":

                App.setRoot("jugador");
                break;
            default:
                login.setDisable(false);
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
