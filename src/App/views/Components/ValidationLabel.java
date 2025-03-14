package Components;

import javafx.scene.control.Label;

public class ValidationLabel extends Label {
    public ValidationLabel() {
        setStyle("-fx-text-fill: #ff4444; " +
                "-fx-font-size: 13px; " +
                "-fx-padding: 5 0 5 0; " +
                "-fx-background-color: #4a4a4a; " +
                "-fx-background-radius: 4; " +
                "-fx-alignment: center-left;");
        
        setWrapText(true);
        setVisible(false);
    }

    public void showError(String message) {
        setText(message);
        setVisible(true);
    }

    public void clearError() {
        setText("");
        setVisible(false);
    }
}