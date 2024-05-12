package model;

public class Usuario extends Persona {

    private String nombreUsuario;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String nombre, String apellido, String correo, String contrasena) {
        super(nombre, apellido, correo, contrasena);
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("nombreUsuario=").append(nombreUsuario);
        sb.append('}');
        return sb.toString();
    }

}
