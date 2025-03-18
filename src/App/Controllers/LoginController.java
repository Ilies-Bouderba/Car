package App.Controllers;

import App.Dao.LoginDao;
import App.Models.LoginModel;
import App.Utils.Validation;

public class LoginController {
    private final LoginDao loginDao = new LoginDao();
    private final Validation validation = new Validation();

    public String handelLogin(String email, String password) {

        if (email.isEmpty() || password.isEmpty()) {
            return "All fields are required!";
        }

        if (!validation.isValidEmail(email)) {
            return "Invalid email format!";
        }

        if (!validation.isValidPassword(password)) {
            return "Password must have: 8+ chars, 1 uppercase, 1 number, 1 special char";
        }

        if (!validation.isEmailExists(email)) {
            return "Email doesn't exist";
        }

        LoginModel user = new LoginModel(email, password);
        LoginModel authenticatedUser = loginDao.UserLogin(user);
        
        if (authenticatedUser == null) {
            return "Incorrect password";
        }
        
        return null;
    }
}