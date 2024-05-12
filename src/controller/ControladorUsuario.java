package controller;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import service.GestionUsuario;
import view.VistaInicio;
import view.VistaUsuario;

public class ControladorUsuario {

    private final GestionUsuario gestionUsuario;
    private final VistaUsuario vistaUsuario;

    public ControladorUsuario(GestionUsuario gestionUsuario, VistaUsuario vistaUsuario) {
        this.gestionUsuario = gestionUsuario;
        this.vistaUsuario = vistaUsuario;
        this.escuchador();
    }

    public void ejecutarBuscarRuta() {
        String ubicacion = vistaUsuario.getTxtUbicacion().getText();
        String destino = vistaUsuario.getTxtDestino().getText();

        if (ubicacion.isEmpty() || destino.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel tblAutobusesModel = (DefaultTableModel) vistaUsuario.getTblAutobuses().getModel();

        gestionUsuario.buscarRuta(ubicacion, destino, tblAutobusesModel);
    }

    private void ejecutarBuscarParada() {
        int autobusSeleccionado = vistaUsuario.getTblAutobuses().getSelectedRow();

        if (autobusSeleccionado != -1) {
            String placa = (String) vistaUsuario.getTblAutobuses().getValueAt(autobusSeleccionado, 0);
            DefaultTableModel tblParadasModel = (DefaultTableModel) vistaUsuario.getTblParadas().getModel();

            gestionUsuario.buscarParadas(placa, tblParadasModel);
        }
    }

    public void limpiar() {
        limpiarTablaAutobuses();
        vistaUsuario.getTxtUbicacion().setText("");
        vistaUsuario.getTxtDestino().setText("");
        estadoCampos(true, true);
        estadoBotones(true, true, false);
        estadoTablas(true, false);
    }

    public void cancelar() {
        limpiarTablaParadas();
        ejecutarBuscarRuta();
        estadoCampos(true, true);
        estadoBotones(true, true, false);
        estadoTablas(true, false);
    }

    public void regresar() {
        new VistaInicio().setVisible(true);
        vistaUsuario.dispose();
    }

    private void escuchador() {
        estadoCampos(true, true);
        estadoBotones(true, true, false);
        estadoTablas(true, false);

        vistaUsuario.getTblAutobuses().getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            estadoCampos(false, false);
            estadoBotones(false, false, true);
            estadoTablas(true, false);
            ejecutarBuscarParada();
        });
    }

    private void estadoCampos(boolean txtUbicacion, boolean txtDestino) {
        vistaUsuario.getTxtUbicacion().setEnabled(txtUbicacion);
        vistaUsuario.getTxtDestino().setEnabled(txtDestino);
    }

    private void estadoBotones(boolean btnBuscar, boolean btnLimpiar, boolean btnCancelar) {
        vistaUsuario.getBtnBuscar().setEnabled(btnBuscar);
        vistaUsuario.getBtnLimpiar().setEnabled(btnLimpiar);
        vistaUsuario.getBtnCancelar().setEnabled(btnCancelar);
    }

    private void estadoTablas(boolean tblAutobuses, boolean tblParadas) {
        vistaUsuario.getTblAutobuses().setEnabled(tblAutobuses);
        vistaUsuario.getTblParadas().setEnabled(tblParadas);
    }

    private void limpiarTablaAutobuses() {
        DefaultTableModel tblAutobusesModel = (DefaultTableModel) vistaUsuario.getTblAutobuses().getModel();
        tblAutobusesModel.setRowCount(0);
    }

    private void limpiarTablaParadas() {
        DefaultTableModel tblParadasModel = (DefaultTableModel) vistaUsuario.getTblParadas().getModel();
        tblParadasModel.setRowCount(0);
    }

    private void alerta(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

}
