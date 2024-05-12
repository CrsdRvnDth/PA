package view;

import controller.ControladorRuta;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import service.GestionRuta;

public class VistaRuta extends javax.swing.JFrame {

    private final ControladorRuta controladorRuta;

    public VistaRuta() {
        initComponents();
        GestionRuta gestionRuta = new GestionRuta();
        controladorRuta = new ControladorRuta(gestionRuta, this);
    }

    public JButton getBtnAnadirParada() {
        return btnAnadirParada;
    }

    public JButton getBtnAnadirRuta() {
        return btnAnadirRuta;
    }

    public JButton getBtnCancelarParada() {
        return btnCancelarParada;
    }

    public JButton getBtnCancelarRuta() {
        return btnCancelarRuta;
    }

    public JButton getBtnEliminarParada() {
        return btnEliminarParada;
    }

    public JButton getBtnEliminarRuta() {
        return btnEliminarRuta;
    }

    public JButton getBtnModificarParada() {
        return btnModificarParada;
    }

    public JButton getBtnModificarRuta() {
        return btnModificarRuta;
    }

    public JSpinner getSpnHora() {
        return spnHora;
    }

    public JTable getTblParadas() {
        return tblParadas;
    }

    public JTable getTblRutas() {
        return tblRutas;
    }

    public JTextField getTxtIdRuta() {
        return txtIdRuta;
    }

    public JTextField getTxtIdRutaParada() {
        return txtIdRutaParada;
    }

    public JTextField getTxtNombreRuta() {
        return txtNombreRuta;
    }

    public JTextField getTxtNumeroParada() {
        return txtNumeroParada;
    }

    public JTextField getTxtUbicacion() {
        return txtUbicacion;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdRuta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreRuta = new javax.swing.JTextField();
        btnAnadirRuta = new javax.swing.JButton();
        btnModificarRuta = new javax.swing.JButton();
        btnEliminarRuta = new javax.swing.JButton();
        btnCancelarRuta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRutas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroParada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
        spinnerDateModel.setCalendarField (Calendar.MINUTE);
        spnHora = new javax.swing.JSpinner(spinnerDateModel);
        jLabel6 = new javax.swing.JLabel();
        txtIdRutaParada = new javax.swing.JTextField();
        btnAnadirParada = new javax.swing.JButton();
        btnModificarParada = new javax.swing.JButton();
        btnEliminarParada = new javax.swing.JButton();
        btnCancelarParada = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblParadas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnAutobuses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("ID Ruta");

        jLabel2.setText("Nombre de la ruta");

        btnAnadirRuta.setText("Añadir");
        btnAnadirRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirRutaActionPerformed(evt);
            }
        });

        btnModificarRuta.setText("Modificar");
        btnModificarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRutaActionPerformed(evt);
            }
        });

        btnEliminarRuta.setText("Eliminar");
        btnEliminarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRutaActionPerformed(evt);
            }
        });

        btnCancelarRuta.setText("Cancelar");
        btnCancelarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRutaActionPerformed(evt);
            }
        });

        tblRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ruta", "Nombre de la ruta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRutas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblRutas);

        jLabel3.setText("Número de la parada");

        jLabel4.setText("Ubicación");

        jLabel5.setText("Hora");

        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spnHora, "HH:mm");
        spnHora.setEditor (dateEditor);
        ((JSpinner.DefaultEditor) spnHora.getEditor()).getTextField().setEditable(false);

        jLabel6.setText("ID Ruta");

        btnAnadirParada.setText("Añadir");
        btnAnadirParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirParadaActionPerformed(evt);
            }
        });

        btnModificarParada.setText("Modificar");
        btnModificarParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarParadaActionPerformed(evt);
            }
        });

        btnEliminarParada.setText("Eliminar");
        btnEliminarParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarParadaActionPerformed(evt);
            }
        });

        btnCancelarParada.setText("Cancelar");
        btnCancelarParada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarParadaActionPerformed(evt);
            }
        });

        tblParadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Parada", "Número de la parada", "Ubicación", "Hora", "ID Ruta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblParadas);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAutobuses.setText("Autobuses");
        btnAutobuses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutobusesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAnadirRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificarRuta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAnadirParada, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnModificarParada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarParada, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarParada, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNumeroParada))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdRutaParada, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAutobuses)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnadirRuta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNumeroParada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(txtNombreRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdRutaParada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(spnHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnModificarRuta)
                                .addComponent(btnEliminarRuta)
                                .addComponent(btnCancelarRuta))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAnadirParada)
                                .addComponent(btnModificarParada)
                                .addComponent(btnEliminarParada)
                                .addComponent(btnCancelarParada)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnAutobuses))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnadirRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirRutaActionPerformed
        controladorRuta.ejecutarAnadirRuta();
    }//GEN-LAST:event_btnAnadirRutaActionPerformed

    private void btnModificarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRutaActionPerformed
        controladorRuta.ejecutarModificarRuta();
    }//GEN-LAST:event_btnModificarRutaActionPerformed

    private void btnEliminarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRutaActionPerformed
        controladorRuta.ejecutarEliminarRuta();
    }//GEN-LAST:event_btnEliminarRutaActionPerformed

    private void btnCancelarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRutaActionPerformed
        controladorRuta.cancelarRuta();
    }//GEN-LAST:event_btnCancelarRutaActionPerformed

    private void btnAnadirParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirParadaActionPerformed
        controladorRuta.ejectuarAnadirParada();
    }//GEN-LAST:event_btnAnadirParadaActionPerformed

    private void btnModificarParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarParadaActionPerformed
        controladorRuta.ejecutarModificarParada();
    }//GEN-LAST:event_btnModificarParadaActionPerformed

    private void btnEliminarParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarParadaActionPerformed
        controladorRuta.ejecutarEliminarParada();
    }//GEN-LAST:event_btnEliminarParadaActionPerformed

    private void btnCancelarParadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarParadaActionPerformed
        controladorRuta.cancelarParada();
    }//GEN-LAST:event_btnCancelarParadaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        controladorRuta.regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAutobusesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutobusesActionPerformed
        controladorRuta.vistaAutobus();
    }//GEN-LAST:event_btnAutobusesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadirParada;
    private javax.swing.JButton btnAnadirRuta;
    private javax.swing.JButton btnAutobuses;
    private javax.swing.JButton btnCancelarParada;
    private javax.swing.JButton btnCancelarRuta;
    private javax.swing.JButton btnEliminarParada;
    private javax.swing.JButton btnEliminarRuta;
    private javax.swing.JButton btnModificarParada;
    private javax.swing.JButton btnModificarRuta;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JTable tblParadas;
    private javax.swing.JTable tblRutas;
    private javax.swing.JTextField txtIdRuta;
    private javax.swing.JTextField txtIdRutaParada;
    private javax.swing.JTextField txtNombreRuta;
    private javax.swing.JTextField txtNumeroParada;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
