package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import service.GestionAutobus;
import view.VistaAutobus;
import view.VistaInicio;
import view.VistaRuta;

public class ControladorAutobus {

    private final GestionAutobus gestionAutobus;
    private final VistaAutobus vistaAutobus;

    public ControladorAutobus(GestionAutobus gestionAutobus, VistaAutobus vistaAutobus) {
        this.gestionAutobus = gestionAutobus;
        this.vistaAutobus = vistaAutobus;
        this.validarIngresoNumero();
        this.escuchador();
    }

    public void ejecutarAnadirAutobus() {
        String idAutobusString = vistaAutobus.getTxtIdAutobus().getText();
        String placa = vistaAutobus.getTxtPlaca().getText();
        String idRutaString = vistaAutobus.getTxtIdRuta().getText();

        if (idAutobusString.isEmpty() || placa.isEmpty() || idRutaString.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idAutobus = Integer.parseInt(idAutobusString);

        boolean resultado1 = gestionAutobus.validarIdAutobus(idAutobus);
        if (resultado1) {
            alerta("El ID Autobús ingresado ya se encuentra registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean resultado2 = gestionAutobus.validarPlaca(placa);
        if (resultado2) {
            alerta("La placa ingresada ya se encuentra registrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idRuta = Integer.parseInt(idRutaString);

        boolean resultado3 = gestionAutobus.validarIdRuta(idRuta);
        if (!resultado3) {
            alerta("No existe una ruta con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean resultado4 = gestionAutobus.anadirAutobus(idAutobus, placa, idRuta);
        if (resultado4) {
            alerta("Autobus creado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            vistaAutobus.getTxtIdAutobus().setText("");
            vistaAutobus.getTxtPlaca().setText("");
            vistaAutobus.getTxtIdRuta().setText("");
        }

        ejecutarMostrarAutobuses();
        estadoCampo(true, true, true);
        estadoBotones(true, false, false, false);
    }

    public void ejecutarModificarAutobus() {
        String placaNueva = vistaAutobus.getTxtPlaca().getText();
        String idRutaString = vistaAutobus.getTxtIdRuta().getText();

        if (placaNueva.isEmpty() || idRutaString.isEmpty()) {
            alerta("Debes llenar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean resultado1 = gestionAutobus.validarPlaca(placaNueva);
        if (resultado1) {
            alerta("La placa ingresada ya se encuentra registrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idRutaNuevo = Integer.parseInt(idRutaString);

        boolean resultado2 = gestionAutobus.validarIdRuta(idRutaNuevo);
        if (!resultado2) {
            alerta("No existe una ruta con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resultado3 = confirmacion("¿Estás seguro de querer modificar este autobús?");

        if (resultado3 == JOptionPane.YES_OPTION) {
            int autobusSeleccionado = vistaAutobus.getTblAutobuses().getSelectedRow();

            if (autobusSeleccionado != -1) {
                String placaAntigua = (String) vistaAutobus.getTblAutobuses().getValueAt(autobusSeleccionado, 1);
                int idRutaAntiguo = (int) vistaAutobus.getTblAutobuses().getValueAt(autobusSeleccionado, 2);

                boolean resultado4 = gestionAutobus.modificarAutobus(placaNueva, idRutaNuevo, placaAntigua, idRutaAntiguo);
                if (resultado4) {
                    alerta("Autobús modificado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    vistaAutobus.getTxtPlaca().setText("");
                    vistaAutobus.getTxtIdRuta().setText("");
                }

                ejecutarMostrarAutobuses();
                estadoCampo(true, true, true);
                estadoBotones(true, false, false, false);
            }
        }
    }

    public void ejecutarEliminarAutobus() {
        int resultado = confirmacion("¿Estás seguro de querer eliminar este autobús?");

        if (resultado == JOptionPane.YES_OPTION) {
            int autobusSeleccionado = vistaAutobus.getTblAutobuses().getSelectedRow();

            if (autobusSeleccionado != -1) {
                int idAutobus = (int) vistaAutobus.getTblAutobuses().getValueAt(autobusSeleccionado, 0);

                boolean validador = gestionAutobus.eliminarAutobus(idAutobus);
                if (validador) {
                    alerta("Autobús eliminado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

                ejecutarMostrarAutobuses();
                estadoCampo(true, true, true);
                estadoBotones(true, false, false, false);
            }
        }
    }

    public void cancelar() {
        ejecutarMostrarAutobuses();
        estadoCampo(true, true, true);
        estadoBotones(true, false, false, false);
    }

    private void ejecutarMostrarAutobuses() {
        DefaultTableModel tblAutobusesModel = (DefaultTableModel) vistaAutobus.getTblAutobuses().getModel();
        gestionAutobus.mostrarAutobuses(tblAutobusesModel);
    }

    public void regresar() {
        new VistaInicio().setVisible(true);
        vistaAutobus.dispose();
    }

    public void vistaRutas() {
        new VistaRuta().setVisible(true);
        vistaAutobus.dispose();
    }

    private void validarIngresoNumero() {
        vistaAutobus.getTxtIdAutobus().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        vistaAutobus.getTxtIdRuta().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    private void escuchador() {
        ejecutarMostrarAutobuses();
        estadoCampo(true, true, true);
        estadoBotones(true, false, false, false);

        vistaAutobus.getTblAutobuses().getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            int autobusSeleccionado = vistaAutobus.getTblAutobuses().getSelectedRow();

            if (autobusSeleccionado != -1) {
                int idAutobus = (int) vistaAutobus.getTblAutobuses().getValueAt(autobusSeleccionado, 0);
                vistaAutobus.getTxtIdAutobus().setText("" + idAutobus);
            } else {
                vistaAutobus.getTxtIdAutobus().setText("");
            }

            estadoCampo(false, true, true);
            estadoBotones(false, true, true, true);
        });
    }

    private void estadoCampo(boolean txtIdAutobus, boolean txtPlaca, boolean txtIdRuta) {
        vistaAutobus.getTxtIdAutobus().setEnabled(txtIdAutobus);
        vistaAutobus.getTxtPlaca().setEnabled(txtPlaca);
        vistaAutobus.getTxtIdRuta().setEnabled(txtIdRuta);
    }

    private void estadoBotones(boolean btnAnadir, boolean btnModificar, boolean btnEliminar, boolean btnCancelar) {
        vistaAutobus.getBtnAnadir().setEnabled(btnAnadir);
        vistaAutobus.getBtnModificar().setEnabled(btnModificar);
        vistaAutobus.getBtnEliminar().setEnabled(btnEliminar);
        vistaAutobus.getBtnCancelar().setEnabled(btnCancelar);
    }

    private void alerta(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

    private int confirmacion(String mensaje) {
        return JOptionPane.showConfirmDialog(null, mensaje, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }

}
