package view;

import controller.ControladorInicio;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import service.GestionInicio;

public class VistaInicio extends javax.swing.JFrame {

    private final ControladorInicio controladorInicio;

    public VistaInicio() {
        initComponents();
        GestionInicio gestionInicio = new GestionInicio();
        controladorInicio = new ControladorInicio(gestionInicio, this);
    }

    public JCheckBox getChkMostrarContrasenaAdministrador() {
        return chkMostrarContrasenaAdministrador;
    }

    public JCheckBox getChkMostrarContrasenaUsuario() {
        return chkMostrarContrasenaUsuario;
    }

    public JPasswordField getPwdContrasenaAdministrador() {
        return pwdContrasenaAdministrador;
    }

    public JPasswordField getPwdContrasenaUsuario() {
        return pwdContrasenaUsuario;
    }

    public JTextField getTxtNombreAdministrador() {
        return txtNombreAdministrador;
    }

    public JTextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pwdContrasenaUsuario = new javax.swing.JPasswordField();
        chkMostrarContrasenaUsuario = new javax.swing.JCheckBox();
        btnIniciarSesionUsuario = new javax.swing.JButton();
        btnCrearCuenta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreAdministrador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pwdContrasenaAdministrador = new javax.swing.JPasswordField();
        chkMostrarContrasenaAdministrador = new javax.swing.JCheckBox();
        btnIniciarSesionAdministrador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre de Usuario");

        jLabel2.setText("Contraseña ");

        chkMostrarContrasenaUsuario.setText(" ");
        chkMostrarContrasenaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarContrasenaUsuarioActionPerformed(evt);
            }
        });

        btnIniciarSesionUsuario.setText("Iniciar sesión");
        btnIniciarSesionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionUsuarioActionPerformed(evt);
            }
        });

        btnCrearCuenta.setText("Crear una cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciarSesionUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(pwdContrasenaUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMostrarContrasenaUsuario)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCrearCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdContrasenaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMostrarContrasenaUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(btnIniciarSesionUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearCuenta)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Usuario", jPanel1);

        jLabel3.setText("Nombre de Administrador");

        jLabel4.setText("Contraseña ");

        chkMostrarContrasenaAdministrador.setText(" ");
        chkMostrarContrasenaAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarContrasenaAdministradorActionPerformed(evt);
            }
        });

        btnIniciarSesionAdministrador.setText("Iniciar sesión");
        btnIniciarSesionAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionAdministradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciarSesionAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(pwdContrasenaAdministrador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkMostrarContrasenaAdministrador)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdContrasenaAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMostrarContrasenaAdministrador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(btnIniciarSesionAdministrador)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Administrador", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkMostrarContrasenaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarContrasenaUsuarioActionPerformed
        controladorInicio.mostrarContrasenaUsuario();
    }//GEN-LAST:event_chkMostrarContrasenaUsuarioActionPerformed

    private void btnIniciarSesionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionUsuarioActionPerformed
        controladorInicio.ejecutarIniciarSesionUsuario();
    }//GEN-LAST:event_btnIniciarSesionUsuarioActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        controladorInicio.vistaCrearCueta();
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void chkMostrarContrasenaAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarContrasenaAdministradorActionPerformed
        controladorInicio.mostrarContrasenaAdministrador();
    }//GEN-LAST:event_chkMostrarContrasenaAdministradorActionPerformed

    private void btnIniciarSesionAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionAdministradorActionPerformed
        controladorInicio.ejecutarIniciarSesionAdministrador();
    }//GEN-LAST:event_btnIniciarSesionAdministradorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnIniciarSesionAdministrador;
    private javax.swing.JButton btnIniciarSesionUsuario;
    private javax.swing.JCheckBox chkMostrarContrasenaAdministrador;
    private javax.swing.JCheckBox chkMostrarContrasenaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField pwdContrasenaAdministrador;
    private javax.swing.JPasswordField pwdContrasenaUsuario;
    private javax.swing.JTextField txtNombreAdministrador;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
