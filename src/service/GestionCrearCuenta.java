package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;
import sqlite.SQLite;

public class GestionCrearCuenta {

    private final SQLite sQLite = SQLite.getsQLite();

    public boolean crearCuenta(String nombre, String apellido, String correo, String nombreUsuario, String contrasena) {
        Usuario usuario = new Usuario(nombreUsuario, nombre, apellido, correo, contrasena);
        String sentenciaSQL = "INSERT INTO usuarios (nombre, apellido, correo, nombre_usuario, contrasena) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getCorreo());
            preparedStatement.setString(4, usuario.getNombreUsuario());
            preparedStatement.setString(5, usuario.getContrasena());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean validarDato(String sentenciaSQL, String dato, String tipoDato) {
        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, dato);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String datoSQL = resultSet.getString(tipoDato);
                if (dato.equals(datoSQL)) {
                    return true;
                }
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return false;
    }

}
