package App.Dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import App.Models.LoginModel;
import App.rss.database.*;

public class LoginDao {
    public LoginModel UserLogin(LoginModel user) {
        String email = user.getEmail();
        String password = user.getPassword();

        String sql = "SELECT Password FROM Client WHERE Email = ?";
        try (PreparedStatement pstmt = Connect.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                try {
                    String storedPassword = rs.getString("Password");
                    MessageDigest digest = MessageDigest.getInstance("SHA-256");
                    byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

                    if (storedPassword.equals(new String(hash, StandardCharsets.UTF_8))) {
                        System.out.println("Login successful!");
                        return new LoginModel(email, storedPassword);
                    } else {
                        return null;
                    }
                }catch (Exception e) {
                    System.err.println("Error logging in: " + e.getMessage());
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error logging in: " + e.getMessage());
            return null;
        }
    }
}