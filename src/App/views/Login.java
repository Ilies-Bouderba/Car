import Components.*;
import Layouts.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import App.Controllers.LoginController;
import App.Utils.StageUtil;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        PageLayout root = new PageLayout();
        primaryStage.setMaximized(true);

        Card loginCard = new Card("Car Rental");

        InputField emailField = new InputField("Email", "Enter your email");
        InputField passwordField = new InputField("Password", "Enter your password");
        ValidationLabel errorLabel = new ValidationLabel();

        HBox optionsRow = new HBox();
        optionsRow.setAlignment(Pos.CENTER_LEFT);
        optionsRow.getChildren().addAll(new BoxCheck(), new Spacer(), new AuthLink("Forgot password?", _ -> {
            System.out.println("forget password");
        }));

        PrimaryButton loginButton = new PrimaryButton("Log In");
        loginButton.setOnAction(_ -> {
            errorLabel.clearError();

            LoginController controller = new LoginController();
            String error = controller.handelLogin(
                emailField.getText(),
                passwordField.getText()
            );

            if (error == null) {
                // Here you would navigate to the main application screen
                // For example: StageUtil.changeScene(primaryStage, new Dashboard(), "Dashboard");
            } else {
                errorLabel.showError(error);
            }
        });

        Section signupPrompt = new Section();
        signupPrompt.getChildren().add(new AuthLink("Don't have an account? Sign up", _ -> {
            new SignUp().start(primaryStage);
        }));

        loginCard.getChildren().addAll(emailField, passwordField, optionsRow, errorLabel, loginButton, signupPrompt);
        root.getChildren().add(loginCard);

        StageUtil.init(primaryStage, root, "Login");
    }

    public static void main(String[] args) {
        launch(args);
    }
}