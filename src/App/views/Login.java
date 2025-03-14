import Components.*;
import Layouts.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import App.Utils.StageUtil;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        PageLayout root = new PageLayout();

        Card loginCard = new Card("Car Rental");

        InputField emailField = new InputField("Email", "Enter your email");
        InputField passwordField = new InputField("Password", "Enter your password");

        HBox optionsRow = new HBox();
        optionsRow.setAlignment(Pos.CENTER_LEFT);
        optionsRow.getChildren().addAll(new BoxCheck(), new Spacer(), new AuthLink("Forgot password?"));

        PrimaryButton loginButton = new PrimaryButton("Log In");
        Section signupPrompt = new Section();
        signupPrompt.getChildren().add(new AuthLink("Don't have an account? Sign up"));

        loginCard.getChildren().addAll(emailField, passwordField, optionsRow, loginButton, signupPrompt);
        root.getChildren().add(loginCard);

        StageUtil.init(primaryStage, root, "Login");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
