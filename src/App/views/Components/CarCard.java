package Components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class CarCard extends VBox {
    public CarCard(String year, String title, int price, String fuelType, String imageUrl, String Description) {
        super(5);
        setPadding(new Insets(10));
        setStyle("-fx-background-color: #444444; -fx-border-radius: 5; -fx-background-radius: 5; " +
                 "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.5), 10, 0, 0, 5);");

        StackPane imagePane = new StackPane();
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitWidth(250);
        imageView.setFitHeight(180);
        imagePane.getChildren().addAll(imageView);

        Label yearLabel = new Label(year);
        yearLabel.setStyle("-fx-text-fill: white;");
        HBox yearBox = new HBox(10, yearLabel);
        yearBox.setAlignment(Pos.CENTER_LEFT);

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        Label priceLabel = new Label(Description);
        priceLabel.setStyle("-fx-text-fill: white;");

        HBox badges = new HBox(5);
        badges.getChildren().addAll(
            createBadge(fuelType),
            createBadge("$" + String.valueOf(price))
        );

        getChildren().addAll(imagePane, yearBox, titleLabel, priceLabel, badges);
    }

    private Label createBadge(String text) {
        Label badge = new Label(text);
        badge.setStyle("-fx-background-color: #2b2b2b; -fx-text-fill: white; -fx-padding: 2 5; " +
                       "-fx-border-radius: 5; -fx-background-radius: 5;");
        return badge;
    }
}