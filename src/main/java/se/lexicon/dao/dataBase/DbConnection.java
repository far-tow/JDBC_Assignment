package se.lexicon.dao.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    //Write the url & credentials to Database
    private static final String URL = "jdbc:mysql://localhost:3306/world";
    private static final String uName = "root";
    private static final String pWorld = "12345678";

    //Establish Connection object
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, uName, pWorld);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
