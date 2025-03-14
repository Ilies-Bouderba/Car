package App.Models;

public class RegisterModel {
    private String username;
    private String email;
    private String phone; 
    private String password;

    public RegisterModel(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone; 
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; } 
    public String getPassword() { return password; }
}