package App.Utils;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageUtil {

    public static void init(Stage stage, Parent root, String title) {
        Scene scene = new Scene(root, 800, 600); 
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}
