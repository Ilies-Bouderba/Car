package Components;

import javafx.scene.control.Hyperlink;

public class AuthLink extends Hyperlink {
    public AuthLink(String text) {
        super(text);
        setStyle("-fx-text-fill: #FF6C37; -fx-border-color: transparent;");
    }
}