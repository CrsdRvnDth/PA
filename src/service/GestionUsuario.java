package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sqlite.SQLite;

public class GestionUsuario {

    private final SQLite sQLite = SQLite.getsQLite();

    public void buscarRuta(String ubicacion, String destino, DefaultTableModel tblAutobusesModel) {
        String sentenciaSQL = "SELECT autobuses.placa FROM autobuses "
                + "JOIN paradas AS p1 ON autobuses.id_ruta = p1.id_ruta "
                + "JOIN paradas AS p2 ON autobuses.id_ruta = p2.id_ruta "
                + "JOIN rutas ON p1.id_ruta = rutas.id_ruta "
                + "WHERE p1.ubicacion LIKE ? AND p2.ubicacion LIKE ? "
                + "AND p1.numero_parada < p2.numero_parada "
                + "AND p1.hora > ?";

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String hora = localTime.format(dateTimeFormatter);

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, ubicacion);
            preparedStatement.setString(2, destino);
            preparedStatement.setString(3, hora);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                alerta("No hay rutas disponibles a tu destino.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            mostrarAutobuses(tblAutobusesModel, resultSet);

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private void mostrarAutobuses(DefaultTableModel tblAutobusesModel, ResultSet resultSet) {
        tblAutobusesModel.setRowCount(0);

        try {
            while (resultSet.next()) {
                Object[] row = new Object[1];
                row[0] = resultSet.getObject("placa");

                tblAutobusesModel.addRow(row);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void buscarParadas(String placa, DefaultTableModel tblParadasModel) {
        String sentenciaSQL = "SELECT paradas.numero_parada, paradas.ubicacion, paradas.hora FROM autobuses "
                + "JOIN paradas ON autobuses.id_ruta = paradas.id_ruta "
                + "WHERE autobuses.placa = ? AND paradas.hora > ?"
                + "ORDER BY numero_parada ASC";

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String hora = localTime.format(dateTimeFormatter);

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, placa);
            preparedStatement.setString(2, hora);

            ResultSet resultSet = preparedStatement.executeQuery();

            mostrarParadas(tblParadasModel, resultSet);

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private void mostrarParadas(DefaultTableModel tblParadasModel, ResultSet resultSet) {
        tblParadasModel.setRowCount(0);

        try {
            while (resultSet.next()) {
                Object[] row = new Object[3];
                row[0] = resultSet.getObject("numero_parada");
                row[1] = resultSet.getObject("ubicacion");
                row[2] = resultSet.getObject("hora");

                tblParadasModel.addRow(row);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private void alerta(String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipoMensaje);
    }

}
