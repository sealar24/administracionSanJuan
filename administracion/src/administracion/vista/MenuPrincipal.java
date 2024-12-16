package administracion.vista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    public MenuPrincipal() {
        setTitle("Administración - Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar fondo gris
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 10, 10)); // Espaciado entre botones
        mainPanel.setBackground(Color.LIGHT_GRAY); // Fondo gris
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes

        // Botón para gestionar socios
        JButton btnSocios = new JButton("Gestión de Socios");
        btnSocios.addActionListener(e -> {
            new SociosPantalla().setVisible(true);
            dispose(); // Cierra el menú actual
        });

        // Botón para gestionar empleados
        JButton btnEmpleados = new JButton("Gestión de Empleados");
        btnEmpleados.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Sección en desarrollo...");
        });

        // Botón para gestionar cuotas
        JButton btnCuotas = new JButton("Gestión de Cuotas");
        btnCuotas.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Sección en desarrollo...");
        });

        // Botón para salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
        	int opcion = JOptionPane.showOptionDialog(
        		    this, 
        		    "¿Estás seguro de que deseas salir?", // Mensaje principal
        		    "Confirmar salida",                  // Título del cuadro de diálogo
        		    JOptionPane.YES_NO_OPTION,           // Tipo de opciones
        		    JOptionPane.QUESTION_MESSAGE,        // Tipo de icono
        		    null,                                // Icono personalizado (null usa el por defecto)
        		    new Object[]{"Sí", "No"},           // Opciones de botones personalizadas
        		    "No"                                // Botón predeterminado
        			);

        	 if (opcion == JOptionPane.YES_OPTION) {
                 System.exit(0); // Finaliza la aplicación
        		}
        		});


        // Agregar botones al panel principal
        mainPanel.add(btnSocios);
        mainPanel.add(btnEmpleados);
        mainPanel.add(btnCuotas);
        mainPanel.add(btnSalir);

        // Agregar panel principal al marco
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}
