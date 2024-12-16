package administracion.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que crea un formulario modal para capturar los datos de un nuevo socio.
 */
public class AgregarSocioForm {

    /**
     * Muestra un formulario modal para que el usuario ingrese los datos del nuevo socio.
     * @param parent El JFrame padre (SociosPantalla) que invoca este formulario.
     * @return Un arreglo de Strings con los datos capturados [nombre, apellido, DNI, teléfono, email],
     *         o null si el usuario cancela la operación.
     */
    public static String[] mostrarFormulario(JFrame parent) {
        // Crear campos de texto para cada dato del socio
        JTextField txtNombre = new JTextField(15);
        JTextField txtApellido = new JTextField(15);
        JTextField txtDni = new JTextField(15);
        JTextField txtTelefono = new JTextField(15);
        JTextField txtEmail = new JTextField(15);

        // Crear un panel para organizar los campos y etiquetas
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));
        panel.add(txtApellido);
        panel.add(new JLabel("DNI:"));
        panel.add(txtDni);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);

        // Mostrar el formulario en un cuadro de diálogo modal
        int result = JOptionPane.showConfirmDialog(parent, panel, "Agregar Nuevo Socio",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Si el usuario presiona "OK", capturamos los datos ingresados
        if (result == JOptionPane.OK_OPTION) {
            return new String[]{
                txtNombre.getText(),
                txtApellido.getText(),
                txtDni.getText(),
                txtTelefono.getText(),
                txtEmail.getText()
            };
        }
        return null; // Retornar null si el usuario cancela
    }
}

