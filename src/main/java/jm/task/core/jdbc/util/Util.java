package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String userName = "root";
    private static String password = "1988";
    private static String connectionURL = "jdbc:mysql://localhost:3306/mytestdb";

    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionURL, userName, password);
    }
}
