package clubfutbol.torerosclub.conexion;
import java.sql.*;
public class ConexionMysql {
    private Connection connection;
    private String usuario = "root";
    private String password = "root";
    private String servidor = "localhost";
    private String puerto = "3306";
    private String nombreBD = "club_de_futbol";
    private String url = "jdbc:mysql://"+servidor+":"+puerto+"/"+nombreBD+"?serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";
    
    public ConexionMysql() {
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, password);
            if (connection != null){
                System.out.println("Base de datos conectada!!");
            }
        } catch (Exception e) {
            System.err.println("Ocurrió un error en la conexión");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
     
        
    }

    public Connection getConnection() {
        return connection;
    }
    
    
    
}
