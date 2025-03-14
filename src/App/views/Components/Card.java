package Components;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Card extends VBox {
    public Card(String titleText) {
        this(titleText, true);
    }

    public Card(String titleText, boolean withPadding) {
        if (withPadding) {
            setPadding(new Insets(30));
        }
        setSpacing(18);
        setMaxWidth(400);
        setStyle("-fx-background-color: #3a3a3a; " +
                "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 10, 0, 0, 2); " +
                "-fx-background-radius: 8;");

        if (titleText != null) {
            Text title = new Text(titleText);
            title.setStyle("-fx-font-size: 29px; -fx-font-weight: bold; -fx-fill: #FF6C37;");
            title.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            title.setWrappingWidth(getMaxWidth());
            getChildren().add(title);            
        }
    }
}