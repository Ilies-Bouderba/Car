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

                    stmt.execute("CREATE TABLE IF NOT EXISTS Agent (" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT NOT NULL, " +
                        "Email TEXT NOT NULL UNIQUE, " +
                        "Phone TEXT NOT NULL UNIQUE, " +
                        "Password TEXT NOT NULL)");

                    stmt.execute("CREATE TABLE IF NOT EXISTS Car_Makers (" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT NOT NULL UNIQUE)");

                    stmt.execute("CREATE TABLE IF NOT EXISTS Car_Models (" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Name TEXT NOT NULL UNIQUE, " +
                        "Car_Maker_Id INTEGER NOT NULL, " +
                        "FOREIGN KEY (Car_Maker_Id) REFERENCES Car_Makers(Id))");

                    stmt.execute("CREATE TABLE IF NOT EXISTS Cars (" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Agent_Id INTEGER NOT NULL, " +
                        "Maker_id INTEGER NOT NULL, " +
                        "Model_Id INTEGER NOT NULL, " +
                        "FOREIGN KEY (Maker_Id) REFERENCES Car_Makers(Id), " +
                        "FOREIGN KEY (Model_Id) REFERENCES Car_Models(Id)" +
                        "Year INTEGER NOT NULL, " +
                        "Price REAL NOT NULL," +
                        "Phone TEXT NOT NULL UNIQUE, " +
                        "Description TEXT NOT NULL, " +
                        "Address TEXT NOT NULL, " +
                        "FOREIGN KEY (Agent_Id) REFERENCES Agent(Id), " +
                        "FOREIGN KEY (Address) REFERENCES Agent(Address), " +
                        "FOREIGN KEY (Phone) REFERENCES Agent(Phone))");

                    stmt.execute("CREATE TABLE IF NOT EXISTS Car_Images (" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Car_Id INTEGER NOT NULL, " +
                        "Image TEXT NOT NULL, " +
                        "FOREIGN KEY (Car_Id) REFERENCES Cars(Id))");

                    stmt.execute("CREATE TABLE IF NOT EXISTS Car_Features (" +
                        "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Car_Id INTEGER NOT NULL, " +
                        "ABS BOOLEAN NOT NULL, " +
                        "Power_Conditioning BOOLEAN NOT NULL, " +
                        "Power_Windows BOOLEAN NOT NULL, " +
                        "Power_Door_Locks BOOLEAN NOT NULL, " +
                        "Cruise_Control BOOLEAN NOT NULL, " +
                        "Bluetooth_Connectivity BOOLEAN NOT NULL, " +
                        "Remote_Start BOOLEAN NOT NULL, " +
                        "GPS_Navigation BOOLEAN NOT NULL, " +
                        "Heater_Seats BOOLEAN NOT NULL, " +
                        "Climate_Control BOOLEAN NOT NULL, " +
                        "Rear_Parking_Sensors BOOLEAN NOT NULL, " +
                        "Leather_Seats BOOLEAN NOT NULL, " +
                        "FOREIGN KEY (Car_Id) REFERENCES Cars(Id))");
                }
            } catch (SQLException e) {
                System.err.println("Error connecting to database: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}