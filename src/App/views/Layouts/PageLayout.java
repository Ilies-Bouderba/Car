package Layouts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class PageLayout extends VBox {
    public PageLayout() {
        setSpacing(20);
        setPadding(new Insets(30));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #2b2b2b;");
    }
}
