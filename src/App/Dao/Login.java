package App.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import App.rss.database.*;

public class Login {
    public void UserLogin(String brand) {
        String sql = "INSERT INTO Car (brand) VALUES (?)";
        
        try (PreparedStatement pstmt = Connect.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, brand);
            pstmt.executeUpdate();
            System.out.println("Car added successfully");
        } catch (SQLException e) {
            System.err.println("Error adding car: " + e.getMessage());
        }
    }
}
