package Components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

public class AuthLink extends Hyperlink {

    public AuthLink(String text, EventHandler<ActionEvent> handler) {
        super(text);
        setStyle("-fx-text-fill: #FF6C37; -fx-border-color: transparent;");
        setOnAction(handler);
    }
}