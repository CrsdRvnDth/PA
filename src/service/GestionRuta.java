package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Parada;
import model.Ruta;
import sqlite.SQLite;

public class GestionRuta {

    private final SQLite sQLite = SQLite.getsQLite();

    public boolean anadirRuta(int idRuta, String nombreRuta) {
        Ruta ruta = new Ruta(idRuta, nombreRuta);
        String sentenciaSQL = "INSERT INTO rutas (id_ruta, nombre_ruta) VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, ruta.getIdRuta());
            preparedStatement.setString(2, ruta.getNombreRuta());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean modificarRuta(String nombreRutaNuevo, String nombreRutaAntiguo) {
        String sentenciaSQL = "UPDATE rutas SET nombre_ruta = ? WHERE nombre_ruta = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, nombreRutaNuevo);
            preparedStatement.setString(2, nombreRutaAntiguo);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean eliminarRuta(int idRuta) {
        String sentenciaSQL1 = "DELETE FROM rutas WHERE id_ruta = ?";
        String sentenciaSQL2 = "DELETE FROM paradas WHERE id_ruta = ?";

        try {
            PreparedStatement preparedStatement1 = sQLite.getConnection().prepareStatement(sentenciaSQL1);
            preparedStatement1.setInt(1, idRuta);

            PreparedStatement preparedStatement2 = sQLite.getConnection().prepareStatement(sentenciaSQL2);
            preparedStatement2.setInt(1, idRuta);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement1.close();
            preparedStatement2.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public void mostrarRutas(DefaultTableModel tblRutasModel) {
        tblRutasModel.setRowCount(0);
        String sentenciaSQL = "SELECT id_ruta, nombre_ruta FROM rutas";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] row = new Object[2];
                row[0] = resultSet.getObject("id_ruta");
                row[1] = resultSet.getObject("nombre_ruta");

                tblRutasModel.addRow(row);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public boolean anadirParada(int numeroParada, String ubicacion, String hora, int idRuta) {
        Parada parada = new Parada(numeroParada, ubicacion, hora, idRuta);
        String sentenciaSQL = "INSERT INTO paradas (numero_parada, ubicacion, hora, id_ruta) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, parada.getNumeroParada());
            preparedStatement.setString(2, parada.getUbicacion());
            preparedStatement.setString(3, parada.getHora());
            preparedStatement.setInt(4, parada.getIdRuta());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean modificarParada(int numeroParadaNuevo, String ubicacionNueva, String horaNueva, int numeroParadaAntiguo, String ubicacionAntigua, String horaAntigua, int idRuta, int idParada) {
        String sentenciaSQL = "UPDATE paradas SET numero_parada = ?, ubicacion = ?, hora = ? WHERE numero_parada = ? AND ubicacion = ? AND hora = ? AND id_ruta = ? AND id_parada = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, numeroParadaNuevo);
            preparedStatement.setString(2, ubicacionNueva);
            preparedStatement.setString(3, horaNueva);
            preparedStatement.setInt(4, numeroParadaAntiguo);
            preparedStatement.setString(5, ubicacionAntigua);
            preparedStatement.setString(6, horaAntigua);
            preparedStatement.setInt(7, idRuta);
            preparedStatement.setInt(8, idParada);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public boolean eliminarParada(int idParada) {
        String sentenciaSQL = "DELETE FROM paradas WHERE id_parada = ?";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, idParada);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public void mostrarParadas(DefaultTableModel tblParadasModel, int idRuta) {
        tblParadasModel.setRowCount(0);
        String sentenciaSQL = "SELECT id_parada, numero_parada, ubicacion, hora, id_ruta "
                + "FROM paradas WHERE id_ruta = ? "
                + "ORDER BY numero_parada ASC";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, idRuta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] row = new Object[5];
                row[0] = resultSet.getObject("id_parada");
                row[1] = resultSet.getObject("numero_parada");
                row[2] = resultSet.getObject("ubicacion");
                row[3] = resultSet.getObject("hora");
                row[4] = resultSet.getObject("id_ruta");

                tblParadasModel.addRow(row);
            }

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
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

    public boolean validarNumeroParada(int numeroParada, int idRuta) {
        String sentenciaSQL = "SELECT numero_parada, id_ruta FROM paradas WHERE numero_parada = ? AND id_ruta = ? ";

        try {
            PreparedStatement preparedStatement = sQLite.getConnection().prepareStatement(sentenciaSQL);
            preparedStatement.setInt(1, numeroParada);
            preparedStatement.setInt(2, idRuta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int numeroParadaSQL = resultSet.getInt("numero_parada");
                int idRutaSQL = resultSet.getInt("id_ruta");
                if (numeroParada == numeroParadaSQL && idRuta == idRutaSQL) {
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
