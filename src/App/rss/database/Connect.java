package App.rss.database;

import java.sql.*;

public class Connect {
    private static Connection connection = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:sqlite:src/App/rss/database/database.db";
                connection = DriverManager.getConnection(url);
                
                try (Statement stmt = connection.createStatement()) {
                    stmt.execute("CREATE TABLE IF NOT EXISTS Client (" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT NOT NULL, " +
                        "Email TEXT NOT NULL UNIQUE, " +
                        "Phone TEXT NOT NULL UNIQUE, " +
                        "Password TEXT NOT NULL)");
                }
            } catch (SQLException e) {
                System.err.println("Error connecting to database: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}