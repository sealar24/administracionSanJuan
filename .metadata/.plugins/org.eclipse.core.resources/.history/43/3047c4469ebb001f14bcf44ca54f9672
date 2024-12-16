package administracion.vista;

import administracion.controlador.SociosManager;
import administracion.modelo.Socio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

public class SociosPantalla extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable tablaSocios;
    private DefaultTableModel modeloTabla;

    public SociosPantalla() {
        setTitle("Listado de Socios");
        setSize(1100, 500); // Ajustamos el tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear tabla para mostrar los datos
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Apellido", "Nombre", "DNI", "Teléfono", "WhatsApp", "Email", "Dirección"}, 0);
        tablaSocios = new JTable(modeloTabla);
        
        // Ajustar anchos de columnas
        ajustarAnchoColumnas();

        JScrollPane scrollPane = new JScrollPane(tablaSocios);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelInferior = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnSalir = new JButton("Salir");

        panelInferior.add(btnAgregar);
        panelInferior.add(btnActualizar);
        panelInferior.add(btnSalir);
        add(panelInferior, BorderLayout.SOUTH);

        // Llenar tabla con datos desde la base de datos
        cargarDatos();

        // Acción del botón "Agregar"
        btnAgregar.addActionListener(e -> {
            String[] datos = mostrarFormularioAgregarSocio();

            if (datos != null) {
                String apellido = datos[0];
                String nombre = datos[1];
                String dni = datos[2];
                String telefono = datos[3];
                String watsapp = datos[4];
                String email = datos[5];
                String direccion = datos[6];

                if (apellido.isEmpty() || nombre.isEmpty() || dni.isEmpty() || telefono.isEmpty() ||
                        watsapp.isEmpty() || email.isEmpty() || direccion.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                SociosManager manager = new SociosManager();
                boolean exito = manager.agregarSocio(apellido, nombre, dni, telefono, watsapp, email, direccion);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Socio agregado exitosamente.");
                    cargarDatos(); // Refrescar la tabla para mostrar el nuevo socio
                } else {
                    JOptionPane.showMessageDialog(this, "Error al agregar el socio. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Acción del botón "Actualizar" (en desarrollo)
        btnActualizar.addActionListener(e -> { 
            int filaSeleccionada = tablaSocios.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione un socio para modificar.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Obtener ID y los campos modificables del socio seleccionado
            int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
            String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
            String apellido = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
            String dni = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
            String telefono = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
            String whatsapp = (String) modeloTabla.getValueAt(filaSeleccionada, 5);
            String email = (String) modeloTabla.getValueAt(filaSeleccionada, 6);
            String direccion = (String) modeloTabla.getValueAt(filaSeleccionada, 7);

            // Mostrar formulario pre-rellenado para edición
            String[] nuevosDatos = ModificarSocioForm.mostrarFormulario(
                this, // La ventana actual (JFrame)
                id, // ID
                nombre, // Nombre
                apellido, // Apellido
                dni, // DNI
                telefono, // Teléfono
                whatsapp, // WhatsApp
                email, // Email
                direccion // Dirección
            );

            // Si el usuario no canceló y hay cambios
            if (nuevosDatos != null) {
                SociosManager manager = new SociosManager();
                boolean exito = manager.modificarSocio(id, nuevosDatos[0], nuevosDatos[1], nuevosDatos[2], nuevosDatos[3]);

                if (exito) {
                    JOptionPane.showMessageDialog(this, "Socio modificado exitosamente.");
                    cargarDatos(); // Refrescar la tabla
                } else {
                    JOptionPane.showMessageDialog(this, "Error al modificar el socio.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Acción del botón "Salir"
        btnSalir.addActionListener(e -> {
            dispose();
            new MenuPrincipal().setVisible(true);
        });
    }

    // Método para cargar los datos de la base de datos en la tabla
    private void cargarDatos() {
        SociosManager manager = new SociosManager();
        List<Socio> listaSocios = manager.obtenerTodos();
        modeloTabla.setRowCount(0);
        for (Socio socio : listaSocios) {
            modeloTabla.addRow(new Object[]{
                socio.getId(),
                socio.getApellido(),
                socio.getNombre(),
                socio.getDni(),
                socio.getTelefono(),
                socio.getWatsapp(),
                socio.getEmail(),
                socio.getDireccion()
            });
        }
    }

    // Método para ajustar el ancho de columnas de la tabla
    private void ajustarAnchoColumnas() {
        // Configuramos cada columna con anchos específicos
        TableColumn columnaId = tablaSocios.getColumnModel().getColumn(0);
        columnaId.setPreferredWidth(50);  // Ancho preferido para ID
        columnaId.setMaxWidth(60);        // Ancho máximo para ID
        columnaId.setMinWidth(40);        // Ancho mínimo para ID

        TableColumn columnaApellido = tablaSocios.getColumnModel().getColumn(1);
        columnaApellido.setPreferredWidth(120);

        TableColumn columnaNombre = tablaSocios.getColumnModel().getColumn(2);
        columnaNombre.setPreferredWidth(120);

        TableColumn columnaDNI = tablaSocios.getColumnModel().getColumn(3);
        columnaDNI.setPreferredWidth(100);

        TableColumn columnaTelefono = tablaSocios.getColumnModel().getColumn(4);
        columnaTelefono.setPreferredWidth(100);

        TableColumn columnaWhatsApp = tablaSocios.getColumnModel().getColumn(5);
        columnaWhatsApp.setPreferredWidth(100);

        TableColumn columnaEmail = tablaSocios.getColumnModel().getColumn(6);
        columnaEmail.setPreferredWidth(200);

        TableColumn columnaDireccion = tablaSocios.getColumnModel().getColumn(7);
        columnaDireccion.setPreferredWidth(250); // Más espacio para la dirección
    }

    private String[] mostrarFormularioAgregarSocio() {
        JTextField apellidoField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField dniField = new JTextField();
        JTextField telefonoField = new JTextField();
        JTextField watsappField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField direccionField = new JTextField();

        Object[] message = {
            "Apellido:", apellidoField,
            "Nombre:", nombreField,
            "DNI:", dniField,
            "Teléfono:", telefonoField,
            "WhatsApp:", watsappField,
            "Email:", emailField,
            "Dirección:", direccionField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Agregar Socio", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            return new String[]{
                apellidoField.getText(),
                nombreField.getText(),
                dniField.getText(),
                telefonoField.getText(),
                watsappField.getText(),
                emailField.getText(),
                direccionField.getText()
            };
        }
        return null;
    }
}

