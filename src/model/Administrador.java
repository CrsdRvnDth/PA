package model;

public class Administrador extends Persona {

    private String nombreAdministrador;

    public Administrador() {
    }

    public Administrador(String nombreAdministrador, String nombre, String apellido, String correo, String contrasena) {
        super(nombre, apellido, correo, contrasena);
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Administrador{");
        sb.append("nombreAdministrador=").append(nombreAdministrador);
        sb.append('}');
        return sb.toString();
    }

}
