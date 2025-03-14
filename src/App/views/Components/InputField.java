package Components;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InputField extends VBox {
    private final TextField textField;
    
    public InputField(String labelText, String promptText) {
        setSpacing(8);
        
        Label label = new Label(labelText);
        label.setStyle("-fx-text-fill: #e0e0e0;");
        
        textField = new TextField();
        textField.setPromptText(promptText);
        textField.setPrefHeight(40);
        textField.setStyle("-fx-background-color: #333333; " +
                         "-fx-background-radius: 4; " +
                         "-fx-border-color: #555555; " +
                         "-fx-border-radius: 4; " +
                         "-fx-text-fill: white; " +
                         "-fx-focus-color: transparent; " +
                         "-fx-faint-focus-color: transparent;");
        
        getChildren().addAll(label, textField);
    }
    
    public String getText() {
        return textField.getText();
    }
}