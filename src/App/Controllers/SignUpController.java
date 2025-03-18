package App.Controllers;

import App.Dao.RegisterDao;
import App.Models.RegisterModel;
import App.Utils.Validation;

public class SignUpController {
    private final RegisterDao registerDao = new RegisterDao();
    private final Validation validation = new Validation();

    public String handleRegistration(String username, String email, String password, String phone) {

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            return "All fields are required!";
        }

        if (!validation.isValidEmail(email)) {
            return "Invalid email format!";
        }

        if (!validation.isValidPhone(phone)) {
            return "Phone must start with 0, followed by 5/6/7, and be 10 digits";
        }

        if (!validation.isValidPassword(password)) {
            return "Password must have: 8+ chars, 1 uppercase, 1 number, 1 special char";
        }

        if (validation.isEmailExists(email)) {
            return "Email already registered!";
        }

        if (validation.isPhoneExists(phone)) {
            return "Phone already registered!";
        }

        RegisterModel newUser = new RegisterModel(username, email, phone, password);
        return registerDao.registerUser(newUser);
    }
}