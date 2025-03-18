package App.Dao;

import App.Models.RegisterModel;
import App.rss.database.Connect;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
    public String registerUser(RegisterModel user) {
        String sql = "INSERT INTO Client (Name, Email, Phone, Password) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = Connect.getConnection().prepareStatement(sql)) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));
                pstmt.setString(1, user.getUsername());
                pstmt.setString(2, user.getEmail());
                pstmt.setString(3, user.getPhone());
                pstmt.setString(4, new String(hash, StandardCharsets.UTF_8));
                pstmt.executeUpdate();
                return "Success";
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
                return "Failed";
            }
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
            return "Failed";
        }
    }
}