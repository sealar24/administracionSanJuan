package administracion.controlador;

import administracion.modelo.Socio;
import administracion.conexion.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SociosManager {

    // Método para agregar un socio a la base de datos
    public boolean agregarSocio(String apellido, String nombre, String dni, String telefono, String watsapp, String email, String direccion) {
        String sql = "INSERT INTO administracion_socios (apellido_socio, nombre_socio, dni_socio, telefono_socio, watsapp_socio, email_socio, direccion_socio) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Asignar los valores a la consulta preparada
            pstmt.setString(1, apellido);
            pstmt.setString(2, nombre);
            pstmt.setString(3, dni);
            pstmt.setString(4, telefono);
            pstmt.setString(5, watsapp);
            pstmt.setString(6, email);
            pstmt.setString(7, direccion);

            // Ejecutar la consulta
            pstmt.executeUpdate();
            return true; // Socio agregado exitosamente
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Ocurrió un error
        }
    }

    // Método para obtener todos los socios de la base de datos
    public List<Socio> obtenerTodos() {
        List<Socio> listaSocios = new ArrayList<>();
        String sql = "SELECT * FROM administracion_socios";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Socio socio = new Socio(
                    rs.getInt("id_socio"),
                    rs.getString("apellido_socio"),
                    rs.getString("nombre_socio"),
                    rs.getString("dni_socio"),
                    rs.getString("telefono_socio"),
                    rs.getString("watsapp_socio"),
                    rs.getString("email_socio"),
                    rs.getString("direccion_socio")
                );
                listaSocios.add(socio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaSocios;
    }
    public boolean modificarSocio(int id, String telefono, String whatsapp, String email, String direccion) {
        String sql = "UPDATE administracion_socios SET telefono_socio = ?, watsapp_socio = ?, email_socio = ?, direccion_socio = ? WHERE id_socio = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, telefono);
            pstmt.setString(2, whatsapp);
            pstmt.setString(3, email);
            pstmt.setString(4, direccion);
            pstmt.setInt(5, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
