package administracion.modelo;

/**
 * Clase que representa un socio en el sistema.
 * Corresponde a la tabla 'administracion_socios' en la base de datos.
 */
public class Socio {
    // Atributos privados que representan las columnas de la tabla
    private int id; // ID único del socio (clave primaria)
    private String apellido; // Apellido del socio
    private String nombre; // Nombre del socio
    private String dni; // DNI del socio
    private String telefono; // Teléfono de contacto del socio
    private String watsapp; // Número de WhatsApp del socio
    private String email; // Dirección de correo electrónico del socio
    private String direccion; // Dirección física del socio

    /**
     * Constructor vacío (sin parámetros).
     * Útil cuando se necesita crear un objeto sin asignar valores de inmediato.
     */
    public Socio() {
    }

    /**
     * Constructor completo para inicializar un socio con todos sus datos.
     *
     * @param id        ID único del socio.
     * @param apellido  Apellido del socio.
     * @param nombre    Nombre del socio.
     * @param dni       DNI del socio.
     * @param telefono  Teléfono del socio.
     * @param watsapp   Número de WhatsApp del socio.
     * @param email     Dirección de correo electrónico del socio.
     * @param direccion Dirección física del socio.
     */
    public Socio(int id, String apellido, String nombre, String dni, String telefono, String watsapp, String email, String direccion) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.watsapp = watsapp;
        this.email = email;
        this.direccion = direccion;
    }

    // Métodos Getters y Setters para acceder y modificar los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWatsapp() {
        return watsapp;
    }

    public void setWatsapp(String watsapp) {
        this.watsapp = watsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Representación en cadena del objeto.
     * Útil para depuración o registros en consola.
     *
     * @return Cadena con los datos del socio.
     */
    @Override
    public String toString() {
        return "Socio{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", watsapp='" + watsapp + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
