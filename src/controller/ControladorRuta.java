package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import service.GestionRuta;
import view.VistaAutobus;
import view.VistaInicio;
import view.VistaRuta;

public class ControladorRuta {

    private final GestionRuta gestionRuta;
    private final VistaRuta vistaRuta;

    public ControladorRuta(GestionRuta gestionRuta, VistaRuta vistaRuta) {
        this.gestionRuta = gestionRuta;
        this.vistaRuta = vistaRuta;
        this.validarIngresoNumeros();
        this.escuchadorRuta();
        this.escuchadorParada();
    }

    public void ejecutarAnadirRuta() {
        String idRutaString = vistaRuta.getTxtIdRuta().getText();
        String nombreRuta = vistaRuta.getTxtNombreRuta().getText();

        if (idRutaString.isEmpty() || nombreRuta.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idRuta = Integer.parseInt(idRutaString);

        boolean validador1 = gestionRuta.validarIdRuta(idRuta);
        if (validador1) {
            alerta("El ID Ruta ingresado ya se encuentra registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean validador2 = gestionRuta.anadirRuta(idRuta, nombreRuta);
        if (validador2) {
            alerta("Ruta creada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            vistaRuta.getTxtIdRuta().setText("");
            vistaRuta.getTxtNombreRuta().setText("");
        }

        ejecutarMostrarRutas();
        estadoCampoRuta(true, true);
        estadoBotonesRuta(true, false, false, false);
        estadoCamposParada(false, false, false, false);
        estadoBotonesParada(false, false, false, false);
        estadoTablas(true, false);
    }

    public void ejecutarModificarRuta() {
        String nombreRutaNuevo = vistaRuta.getTxtNombreRuta().getText();

        if (nombreRutaNuevo.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resultado = confirmacion("¿Estás seguro de querer modificar esta ruta?");

        if (resultado == JOptionPane.YES_OPTION) {
            int rutaSeleccionada = vistaRuta.getTblRutas().getSelectedRow();

            if (rutaSeleccionada != -1) {
                String nombreRutaAntiguo = (String) vistaRuta.getTblRutas().getValueAt(rutaSeleccionada, 1);

                boolean validador = gestionRuta.modificarRuta(nombreRutaNuevo, nombreRutaAntiguo);
                if (validador) {
                    alerta("Ruta modificada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    vistaRuta.getTxtNombreRuta().setText("");
                }

                limpiarTablaParadas();
                ejecutarMostrarRutas();
                estadoCampoRuta(true, true);
                estadoBotonesRuta(true, false, false, false);
                estadoCamposParada(false, false, false, false);
                estadoBotonesParada(false, false, false, false);
                estadoTablas(true, false);
            }
        }
    }

    public void ejecutarEliminarRuta() {
        int resultado = confirmacion("¿Estás seguro de querer eliminar esta ruta?");

        if (resultado == JOptionPane.YES_OPTION) {
            int rutaSeleccionada = vistaRuta.getTblRutas().getSelectedRow();

            if (rutaSeleccionada != -1) {
                int idRuta = (int) vistaRuta.getTblRutas().getValueAt(rutaSeleccionada, 0);

                boolean validador = gestionRuta.eliminarRuta(idRuta);
                if (validador) {
                    alerta("Ruta eliminada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

                limpiarTablaParadas();
                ejecutarMostrarRutas();
                estadoCampoRuta(true, true);
                estadoBotonesRuta(true, false, false, false);
                estadoCamposParada(false, false, false, false);
                estadoBotonesParada(false, false, false, false);
                estadoTablas(true, false);
            }
        }
    }

    public void cancelarRuta() {
        limpiarTablaParadas();
        ejecutarMostrarRutas();
        estadoCampoRuta(true, true);
        estadoBotonesRuta(true, false, false, false);
        estadoCamposParada(false, false, false, false);
        estadoBotonesParada(false, false, false, false);
        estadoTablas(true, false);
    }

    private void ejecutarMostrarRutas() {
        DefaultTableModel tblRutasModel = (DefaultTableModel) vistaRuta.getTblRutas().getModel();
        gestionRuta.mostrarRutas(tblRutasModel);
    }

    public void ejectuarAnadirParada() {
        String numeroParadaString = vistaRuta.getTxtNumeroParada().getText();
        String ubicacion = vistaRuta.getTxtUbicacion().getText();

        if (numeroParadaString.isEmpty() || ubicacion.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numeroParada = Integer.parseInt(numeroParadaString);
        int idRuta = Integer.parseInt(vistaRuta.getTxtIdRutaParada().getText());

        boolean resultado = gestionRuta.validarNumeroParada(numeroParada, idRuta);
        if (resultado) {
            alerta("El número de parada ingresado ya se encuntra en uso.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date horaDate = (Date) vistaRuta.getSpnHora().getModel().getValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        String hora = simpleDateFormat.format(horaDate);

        boolean validador = gestionRuta.anadirParada(numeroParada, ubicacion, hora, idRuta);
        if (validador) {
            alerta("Parada creada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            vistaRuta.getTxtNumeroParada().setText("");
            vistaRuta.getTxtUbicacion().setText("");
        }

        ejecutarMostrarParadas();
        estadoCampoRuta(false, true);
        estadoBotonesRuta(false, true, true, true);
        estadoCamposParada(true, true, true, false);
        estadoBotonesParada(true, false, false, false);
        estadoTablas(true, true);
    }

    public void ejecutarModificarParada() {
        String numeroParadaString = vistaRuta.getTxtNumeroParada().getText();
        String ubicacionNueva = vistaRuta.getTxtUbicacion().getText();

        if (numeroParadaString.isEmpty() || ubicacionNueva.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numeroParada = Integer.parseInt(numeroParadaString);
        int idRuta = Integer.parseInt(vistaRuta.getTxtIdRutaParada().getText());

        boolean resultado1 = gestionRuta.validarNumeroParada(numeroParada, idRuta);
        if (resultado1) {
            alerta("El número de parada ingresado ya se encuntra en uso.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resultado2 = confirmacion("¿Estás seguro de querer modificar esta parada?");

        if (resultado2 == JOptionPane.YES_OPTION) {
            int numeroParadaNueva = Integer.parseInt(numeroParadaString);

            Date horaDate = (Date) vistaRuta.getSpnHora().getValue();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            String horaNueva = simpleDateFormat.format(horaDate);

            int paradaSeleccionada = vistaRuta.getTblParadas().getSelectedRow();

            if (paradaSeleccionada != -1) {
                int idParada = (int) vistaRuta.getTblParadas().getValueAt(paradaSeleccionada, 0);
                int numeroParadaAntigua = (int) vistaRuta.getTblParadas().getValueAt(paradaSeleccionada, 1);
                String ubicacionAntigua = (String) vistaRuta.getTblParadas().getValueAt(paradaSeleccionada, 2);
                String horaAntigua = (String) vistaRuta.getTblParadas().getValueAt(paradaSeleccionada, 3);

                boolean resultado3 = gestionRuta.modificarParada(numeroParadaNueva, ubicacionNueva, horaNueva, numeroParadaAntigua, ubicacionAntigua, horaAntigua, idRuta, idParada);
                if (resultado3) {
                    alerta("Parada modificada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    vistaRuta.getTxtNumeroParada().setText("");
                    vistaRuta.getTxtUbicacion().setText("");
                }

                ejecutarMostrarParadas();
                estadoCampoRuta(false, true);
                estadoBotonesRuta(false, true, true, true);
                estadoCamposParada(true, true, true, false);
                estadoBotonesParada(true, false, false, false);
                estadoTablas(true, true);
            }
        }
    }

    public void ejecutarEliminarParada() {
        int resultado = confirmacion("¿Estás seguro de querer eliminar esta parada?");

        if (resultado == JOptionPane.YES_OPTION) {
            int paradaSeleccionado = vistaRuta.getTblParadas().getSelectedRow();

            if (paradaSeleccionado != -1) {
                int idParada = (int) vistaRuta.getTblParadas().getValueAt(paradaSeleccionado, 0);

                boolean validador = gestionRuta.eliminarParada(idParada);
                if (validador) {
                    alerta("Parada eliminada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

                ejecutarMostrarParadas();
                estadoCampoRuta(false, true);
                estadoBotonesRuta(false, true, true, true);
                estadoCamposParada(true, true, true, false);
                estadoBotonesParada(true, false, false, false);
                estadoTablas(true, true);
            }
        }
    }

    public void cancelarParada() {
        ejecutarMostrarParadas();
        estadoCampoRuta(false, true);
        estadoBotonesRuta(false, true, true, true);
        estadoCamposParada(true, true, true, false);
        estadoBotonesParada(true, false, false, false);
        estadoTablas(true, true);
    }

    private void ejecutarMostrarParadas() {
        DefaultTableModel tblParadasModel = (DefaultTableModel) vistaRuta.getTblParadas().getModel();
        int rutaSeleccionado = vistaRuta.getTblRutas().getSelectedRow();

        if (rutaSeleccionado != -1) {
            int idRuta = (int) vistaRuta.getTblRutas().getValueAt(rutaSeleccionado, 0);
            vistaRuta.getTxtIdRutaParada().setText("" + idRuta);
            gestionRuta.mostrarParadas(tblParadasModel, idRuta);
        }
    }

    public void regresar() {
        new VistaInicio().setVisible(true);
        vistaRuta.dispose();
    }

    public void vistaAutobus() {
        new VistaAutobus().setVisible(true);
        vistaRuta.dispose();
    }

    private void validarIngresoNumeros() {
        vistaRuta.getTxtIdRuta().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        vistaRuta.getTxtNumeroParada().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    private void escuchadorRuta() {
        ejecutarMostrarRutas();
        estadoCampoRuta(true, true);
        estadoBotonesRuta(true, false, false, false);
        estadoCamposParada(false, false, false, false);
        estadoBotonesParada(false, false, false, false);
        estadoTablas(true, false);

        vistaRuta.getTblRutas().getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            ejecutarMostrarParadas();
            estadoCampoRuta(false, true);
            estadoBotonesRuta(false, true, true, true);
            estadoCamposParada(true, true, true, false);
            estadoBotonesParada(true, false, false, false);
            estadoTablas(true, true);
        });
    }

    private void escuchadorParada() {
        vistaRuta.getTblParadas().getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            estadoCampoRuta(false, false);
            estadoBotonesRuta(false, false, false, false);
            estadoCamposParada(true, true, true, false);
            estadoBotonesParada(false, true, true, true);
            estadoTablas(false, true);
        });
    }

    private void estadoCampoRuta(boolean txtIdRuta, boolean txtNombreRuta) {
        vistaRuta.getTxtIdRuta().setEnabled(txtIdRuta);
        vistaRuta.getTxtNombreRuta().setEnabled(txtNombreRuta);
    }

    private void estadoCamposParada(boolean txtNumeroParada, boolean txtUbicacion, boolean spnHora, boolean txtIdRutaParada) {
        vistaRuta.getTxtNumeroParada().setEnabled(txtNumeroParada);
        vistaRuta.getTxtUbicacion().setEnabled(txtUbicacion);
        vistaRuta.getSpnHora().setEnabled(spnHora);
        vistaRuta.getTxtIdRutaParada().setEnabled(txtIdRutaParada);
    }

    private void estadoBotonesRuta(boolean btnAnadirRuta, boolean btnModificarRuta, boolean btnEliminarRuta, boolean btnCancelarRuta) {
        vistaRuta.getBtnAnadirRuta().setEnabled(btnAnadirRuta);
        vistaRuta.getBtnModificarRuta().setEnabled(btnModificarRuta);
        vistaRuta.getBtnEliminarRuta().setEnabled(btnEliminarRuta);
        vistaRuta.getBtnCancelarRuta().setEnabled(btnCancelarRuta);
    }

    private void estadoBotonesParada(boolean btnAnadirParada, boolean btnModificarParada, boolean btnEliminarParada, boolean btnCancelarParada) {
        vistaRuta.getBtnAnadirParada().setEnabled(btnAnadirParada);
        vistaRuta.getBtnModificarParada().setEnabled(btnModificarParada);
        vistaRuta.getBtnEliminarParada().setEnabled(btnEliminarParada);
        vistaRuta.getBtnCancelarParada().setEnabled(btnCancelarParada);
    }

    private void estadoTablas(boolean tblRutas, boolean tblParadas) {
        vistaRuta.getTblRutas().setEnabled(tblRutas);
        vistaRuta.getTblParadas().setEnabled(tblParadas);
    }

    private void limpiarTablaParadas() {
        DefaultTableModel tblParadasModel = (DefaultTableModel) vistaRuta.getTblParadas().getModel();
        tblParadasModel.setRowCount(0);
    }

    private void alerta(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

    private int confirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }

}
