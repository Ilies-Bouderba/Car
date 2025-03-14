package App.Controllers;

import App.Dao.RegisterDao;
import App.Models.RegisterModel;

public class SignUpController {
    private final RegisterDao registerDao = new RegisterDao();

    public String  handleRegistration(String username, String email, String password, String phone) {

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            return "All fields are required!";
        }

        if (!isValidEmail(email)) {
            return "Invalid email format!";
        }

        if (!isValidPhone(phone)) {
            return "Phone must start with 0, followed by 5/6/7, and be 10 digits";
        }

        if (!isValidPassword(password)) {
            return "Password must have: 8+ chars, 1 uppercase, 1 number, 1 special char";
        }

        if (registerDao.isEmailExists(email)) {
            return "Email already registered!";
        }

        if (registerDao.isPhoneExists(phone)) {
            return "Phone already registered!";
        }

        RegisterModel newUser = new RegisterModel(username, email, phone, password);
        return registerDao.registerUser(newUser);
    }

    private boolean isValidEmail(String email) {
        if (email.matches("^[a-zA-Z0-9._%+-]+@+\\.[a-zA-Z]{2,6}$")) {
            return true;
        }
        return false;
    }

    private boolean isValidPhone(String phone) {

        if (phone.length() != 10) return false;
        
        if (phone.charAt(0) != '0') return false;
        
        char secondChar = phone.charAt(1);
        if (secondChar != '5' && secondChar != '6' && secondChar != '7') return false;
        
        for (char c : phone.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        
        return true;
    }

    private boolean isValidPassword(String password) {

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
}