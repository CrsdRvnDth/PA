package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {

    private static SQLite sQLite;
    private Connection connection;

    private SQLite() {
        conexion();
    }

    public static SQLite getsQLite() {
        if (sQLite == null) {
            sQLite = new SQLite();
        }
        return sQLite;
    }

    public Connection getConnection() {
        return connection;
    }

    private void conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database/PA");
            System.out.println("Conexion establecida.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

}
