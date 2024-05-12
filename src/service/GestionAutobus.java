package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Autobus;
import sqlite.SQLite;

public class GestionAutobus {

    private final SQLite sQLite = SQLite.getsQLite();

    public boolean anadirAutobus(int idAutobus, String placa, int idRuta) {
        Autobus autobus = new Autobus(idAutobus, placa, idRuta);
        String sentenciaSQL = "INSERT INTO autobuses (id_autobus, placa, id_ruta) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, autobus.getIdAutobus());
            preparedStatement.setString(2, autobus.getPlaca());
            preparedStatement.setInt(3, autobus.getIdRuta());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean modificarAutobus(String placaNueva, int idRutaNuevo, String placaAntigua, int idRutaAntiguo) {
        String sentenciaSQL = "UPDATE autobuses SET placa = ?, id_ruta = ? WHERE placa = ? AND id_ruta = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, placaNueva);
            preparedStatement.setInt(2, idRutaNuevo);
            preparedStatement.setString(3, placaAntigua);
            preparedStatement.setInt(4, idRutaAntiguo);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean eliminarAutobus(int idAutobus) {
        String sentenciaSQL = "DELETE FROM autobuses WHERE id_autobus = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, idAutobus);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public void mostrarAutobuses(DefaultTableModel tblAutobusesModel) {
        tblAutobusesModel.setRowCount(0);
        String sentenciaSQL = "SELECT id_autobus, placa, id_ruta FROM autobuses";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] row = new Object[3];
                row[0] = resultSet.getObject("id_autobus");
                row[1] = resultSet.getObject("placa");
                row[2] = resultSet.getObject("id_ruta");

                tblAutobusesModel.addRow(row);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public boolean validarIdAutobus(int idAutobus) {
        String sentenciaSQL = "SELECT id_autobus FROM autobuses WHERE id_autobus = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, idAutobus);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idAutobusSQL = resultSet.getInt("id_autobus");
                if (idAutobus == idAutobusSQL) {
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

    public boolean validarPlaca(String placa) {
        String sentenciaSQL = "SELECT placa FROM autobuses WHERE placa = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, placa);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String placaSQL = resultSet.getString("placa");
                if (placa.equals(placaSQL)) {
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

    public boolean validarIdRuta(int idRuta) {
        String sentenciaSQL = "SELECT id_ruta FROM rutas WHERE id_ruta = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, idRuta);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idRutaSQL = resultSet.getInt("id_ruta");
                if (idRuta == idRutaSQL) {
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
