package administracion.conexion;

// Importar las clases necesarias para la conexión
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Configuración de la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/nosotros"; // Cambiar localhost si la base está en otra máquina
    private static final String USER = "root"; // Usuario de la base de datos
    private static final String PASSWORD = ""; // Contraseña de la base de datos

    /**
     * Método para establecer una conexión con la base de datos.
     * @return Objeto Connection si la conexión es exitosa.
     * @throws SQLException en caso de error de conexión.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el controlador de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el controlador de MySQL.");
            e.printStackTrace();
        }
        // Establecer y devolver la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
