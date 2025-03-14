package Components;

import javafx.scene.control.Button;

public class PrimaryButton extends Button {
    public PrimaryButton(String text) {
        super(text);
        setPrefHeight(40);
        setPrefWidth(Double.MAX_VALUE);
        setStyle("-fx-background-color: #FF6C37; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 4; " +
                "-fx-cursor: hand;");
    }
}