package controller;

import javax.swing.JOptionPane;
import service.GestionInicio;
import view.VistaCrearCuenta;
import view.VistaInicio;
import view.VistaRuta;
import view.VistaUsuario;

public class ControladorInicio {

    private final GestionInicio gestionInicio;
    private final VistaInicio vistaInicio;

    public ControladorInicio(GestionInicio gestionInicio, VistaInicio vistaInicio) {
        this.gestionInicio = gestionInicio;
        this.vistaInicio = vistaInicio;
    }

    public void mostrarContrasenaUsuario() {
        if (vistaInicio.getChkMostrarContrasenaUsuario().isSelected()) {
            vistaInicio.getPwdContrasenaUsuario().setEchoChar('\0');
        } else {
            vistaInicio.getPwdContrasenaUsuario().setEchoChar('*');
        }
    }

    public void ejecutarIniciarSesionUsuario() {
        String nombreUsuario = vistaInicio.getTxtNombreUsuario().getText();
        String contrasena = vistaInicio.getPwdContrasenaUsuario().getText();

        if (validarCampos(nombreUsuario, contrasena)) {
            return;
        }

        String sentenciaSQL = "SELECT contrasena FROM usuarios WHERE nombre_usuario = ?";
        String mensaje = "Nombre de Usuario incorrecto.";

        boolean resultado = gestionInicio.iniciarSesion(sentenciaSQL, nombreUsuario, contrasena, mensaje);
        if (resultado) {
            new VistaUsuario().setVisible(true);
            vistaInicio.dispose();
        }
    }

    public void vistaCrearCueta() {
        new VistaCrearCuenta().setVisible(true);
        vistaInicio.dispose();
    }

    public void mostrarContrasenaAdministrador() {
        if (vistaInicio.getChkMostrarContrasenaAdministrador().isSelected()) {
            vistaInicio.getPwdContrasenaAdministrador().setEchoChar('\0');
        } else {
            vistaInicio.getPwdContrasenaAdministrador().setEchoChar('*');
        }
    }

    public void ejecutarIniciarSesionAdministrador() {
        String nombreAdministrador = vistaInicio.getTxtNombreAdministrador().getText();
        String contrasena = vistaInicio.getPwdContrasenaAdministrador().getText();

        if (validarCampos(nombreAdministrador, contrasena)) {
            return;
        }

        String sentenciaSQL = "SELECT contrasena FROM administradores WHERE nombre_administrador = ?";
        String mensaje = "Nombre de Administrador incorrecto.";

        boolean resultado = gestionInicio.iniciarSesion(sentenciaSQL, nombreAdministrador, contrasena, mensaje);
        if (resultado) {
            new VistaRuta().setVisible(true);
            vistaInicio.dispose();
        }
    }

    private boolean validarCampos(String nombre, String contrasena) {
        if (nombre.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        return false;
    }

}
