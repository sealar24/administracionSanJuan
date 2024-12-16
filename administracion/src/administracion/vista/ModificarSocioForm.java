package administracion.vista;

import javax.swing.*;
import java.awt.*;

public class ModificarSocioForm {

    public static String[] mostrarFormulario(JFrame parent, int id, String apellido, String nombre, String dni, 
                                              String telefono, String whatsapp, String email, String direccion) {
        // Crear panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 filas, 2 columnas (con espaciado entre elementos)

        // Campos no modificables (en una sola línea)
        panel.add(new JLabel("ID:"));
        panel.add(new JLabel(String.valueOf(id))); // Mostrar ID
        panel.add(new JLabel("Apellido:"));
        panel.add(new JLabel(apellido)); // Mostrar Apellido
        panel.add(new JLabel("Nombre:"));
        panel.add(new JLabel(nombre)); // Mostrar Nombre
        panel.add(new JLabel("DNI:"));
        panel.add(new JLabel(dni)); // Mostrar DNI

        // Campos modificables (uno debajo del otro)
        panel.add(new JLabel("Teléfono:"));
        JTextField tfTelefono = new JTextField(telefono);
        panel.add(tfTelefono);

        panel.add(new JLabel("WhatsApp:"));
        JTextField tfWhatsapp = new JTextField(whatsapp);
        panel.add(tfWhatsapp);

        panel.add(new JLabel("Email:"));
        JTextField tfEmail = new JTextField(email);
        panel.add(tfEmail);

        panel.add(new JLabel("Dirección:"));
        JTextField tfDireccion = new JTextField(direccion);
        panel.add(tfDireccion);

        // Crear los botones
        int option = JOptionPane.showConfirmDialog(parent, panel, "Modificar Socio", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // Recoger los datos modificados
            return new String[]{
                tfTelefono.getText(),
                tfWhatsapp.getText(),
                tfEmail.getText(),
                tfDireccion.getText()
            };
        }

        return null; // Si el usuario canceló, no devuelve ningún dato
    }
}



