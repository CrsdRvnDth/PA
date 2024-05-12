package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sqlite.SQLite;

public class GestionInicio {

    private final SQLite sQLite = SQLite.getsQLite();

    public boolean iniciarSesion(String sentenciaSQL, String nombre, String contrasena, String mensaje) {
        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, nombre);

            ResultSet resultSet = preparedStatement.executeQuery();

            boolean resultado = validarDatos(resultSet, contrasena, mensaje);

            preparedStatement.close();
            resultSet.close();

            return resultado;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    private boolean validarDatos(ResultSet resultSet, String contrasena, String mensaje) {
        try {
            if (resultSet.next()) {
                String contrasenaSQL = resultSet.getString("contrasena");
                if (contrasena.equals(contrasenaSQL)) {
                    return true;
                } else {
                    alerta("Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                alerta(mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

    private void alerta(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

}
