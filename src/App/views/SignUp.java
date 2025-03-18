import Components.*;
import Layouts.*;
import javafx.application.Application;
import javafx.stage.Stage;
import App.Controllers.SignUpController;
import App.Utils.StageUtil;

public class SignUp extends Application {

    @Override
    public void start(Stage primaryStage) {
        PageLayout root = new PageLayout();
        primaryStage.setMaximized(true);

        Card loginCard = new Card("Car Rental Sign Up");

        InputField userName = new InputField("Name", "Enter your userName");
        InputField emailField = new InputField("Email", "Enter your email");
        InputField PhoneField = new InputField("Phone Number", "Enter your Phone Number");
        InputField passwordField = new InputField("Password", "Enter your password");
        ValidationLabel errorLabel = new ValidationLabel();
        
        PrimaryButton signUpButton = new PrimaryButton("Sign Up");
        signUpButton.setOnAction(_ -> {
                    errorLabel.clearError();

                    SignUpController controller = new SignUpController();
                    String success = controller.handleRegistration(
                        userName.getText(),
                        emailField.getText(),
                        passwordField.getText(),
                        PhoneField.getText()
                    );

                    if (success == null) {
                        new Login().start(primaryStage);
                        primaryStage.setMaximized(true);
                    }else {
                        errorLabel.showError(success);
                    }
                });
        Section signupPrompt = new Section();
        signupPrompt.getChildren().add(new AuthLink("Already Have an account? Log In", _ -> {
            new Login().start(primaryStage);
            javafx.application.Platform.runLater(() -> primaryStage.setMaximized(true));
        }));

        loginCard.getChildren().addAll(userName, emailField, PhoneField, passwordField, errorLabel,signUpButton, signupPrompt);
        root.getChildren().add(loginCard);

        StageUtil.init(primaryStage, root, "SignUp");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
