package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                // Load the H2 JDBC driver
                Class.forName("org.h2.Driver");
                con = DriverManager.getConnection(
                        "jdbc:h2:mem:hospitaldb;DB_CLOSE_DELAY=-1",
                        "sa",
                        ""
                );
                // Create the appointments table if it doesn't exist
                con.createStatement().execute("CREATE TABLE IF NOT EXISTS appointments (patient VARCHAR(255), doctor VARCHAR(255), specialization VARCHAR(255), date VARCHAR(255))");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }
}
