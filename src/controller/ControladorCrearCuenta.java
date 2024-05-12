package controller;

import javax.swing.JOptionPane;
import service.GestionCrearCuenta;
import view.VistaCrearCuenta;
import view.VistaInicio;

public class ControladorCrearCuenta {

    private final GestionCrearCuenta gestionCrearCuenta;
    private final VistaCrearCuenta vistaCrearCuenta;

    public ControladorCrearCuenta(GestionCrearCuenta gestionCrearCuenta, VistaCrearCuenta vistaCrearCuenta) {
        this.gestionCrearCuenta = gestionCrearCuenta;
        this.vistaCrearCuenta = vistaCrearCuenta;
    }

    public void mostrarContrasena() {
        if (vistaCrearCuenta.getChkMostrarContrasena().isSelected()) {
            vistaCrearCuenta.getPwdContrasena().setEchoChar('\0');
        } else {
            vistaCrearCuenta.getPwdContrasena().setEchoChar('*');
        }
    }

    public void regresar() {
        new VistaInicio().setVisible(true);
        vistaCrearCuenta.dispose();
    }

    public void ejecutarCrearCuenta() {
        String nombre = vistaCrearCuenta.getTxtNombre().getText();
        String apellido = vistaCrearCuenta.getTxtApellido().getText();
        String correo = vistaCrearCuenta.getTxtCorreo().getText();
        String nombreUsuario = vistaCrearCuenta.getTxtNombreUsuario().getText();
        String contrasena = vistaCrearCuenta.getPwdContrasena().getText();

        if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sentenciaSQL1 = "SELECT correo FROM usuarios WHERE correo = ?";
        boolean resultado1 = gestionCrearCuenta.validarDato(sentenciaSQL1, correo, "correo");
        if (resultado1) {
            alerta("El correo ingresado ya se encuentra registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sentenciaSQL2 = "SELECT nombre_usuario FROM usuarios WHERE nombre_usuario = ?";
        boolean resultado2 = gestionCrearCuenta.validarDato(sentenciaSQL2, nombreUsuario, "nombre_usuario");
        if (resultado2) {
            alerta("El nombre de usuario ingresado ya se encuentra registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean resultado3 = gestionCrearCuenta.crearCuenta(nombre, apellido, correo, nombreUsuario, contrasena);
        if (resultado3) {
            alerta("Cuenta creada.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        new VistaInicio().setVisible(true);
        vistaCrearCuenta.dispose();
    }

    private void alerta(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

}
