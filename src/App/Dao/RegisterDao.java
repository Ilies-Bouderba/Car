package App.Dao;

import App.Models.RegisterModel;
import App.rss.database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
    public String registerUser(RegisterModel user) {
        String sql = "INSERT INTO Client (Name, Email, Phone, Password) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = Connect.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getPassword());
            pstmt.executeUpdate();
            return "Success";
        } catch (SQLException e) {
            System.err.println("Registration error: " + e.getMessage());
            return "Failed";
        }
    }

    public boolean isEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM Client WHERE Email = ?";
        try (PreparedStatement pstmt = Connect.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking email: " + e.getMessage());
            return true;
        }
    }

    public boolean isPhoneExists(String phone) {
        String sql = "SELECT COUNT(*) FROM Client WHERE Phone = ?";
        try (PreparedStatement pstmt = Connect.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, phone);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking phone: " + e.getMessage());
            return true;
        }
    }
}