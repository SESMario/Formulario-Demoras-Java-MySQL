package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conectar {

    private static Connection conn;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/lanerabd";

    public conectar() {
        conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                //System.out.println("Conexion establecida...");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar " + e);
        }
    }

    //Con este metodo nos retorna la conexion
    public Connection getConnection() {
        return conn;
    }
    //Con este metodo nos desconectamos de la bd
    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("Conexion terminada...");
        }

    }

}
