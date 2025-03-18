package App.Utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import App.rss.database.Connect;

public class Validation {
    public boolean isValidEmail(String email) {
        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            return true;
        }
        return false;
    }

    public boolean isValidPhone(String phone) {

        if (phone.length() != 10) return false;
        
        if (phone.charAt(0) != '0') return false;
        
        char secondChar = phone.charAt(1);
        if (secondChar != '5' && secondChar != '6' && secondChar != '7') return false;
        
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        
        return true;
    }

    public boolean isValidPassword(String password) {

        if (password.length() < 8) return false;
        
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:',.<>?";
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasDigit = true;
            if (specialChars.indexOf(c) != -1) hasSpecial = true;
        }
        
        return hasUpper && hasDigit && hasSpecial;
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
