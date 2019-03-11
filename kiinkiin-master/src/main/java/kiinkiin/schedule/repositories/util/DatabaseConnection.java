package kiinkiin.schedule.repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final static String USERNAME = "kiinkiin";
    private final static String PASSWORD = "Ip614x_F!qfV";
    private final static String CONNSTRING = "jdbc:mysql://den1.mysql3.gear.host/kiinkiin?useSSL=false";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
    }
}
