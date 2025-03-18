package Layouts;

import javafx.scene.layout.GridPane;
import Components.CarCard;
import javafx.scene.control.ScrollPane;

public class CarGrid extends ScrollPane {
    private GridPane gridPane;

    public CarGrid(Object[][] carData) {
        gridPane = new GridPane();
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setStyle("-fx-padding: 20; -fx-alignment: center;");
        gridPane.setFocusTraversable(false);

        for (int i = 0; i < carData.length; i++) {
            CarCard card = new CarCard(
                (String) carData[i][0], 
                (String) carData[i][1], 
                (String) carData[i][2], 
                (String) carData[i][3], 
                (String) carData[i][4], 
                false
            );
            gridPane.add(card, i % 4, i / 4);
        }

        this.setContent(gridPane);
        this.setFitToWidth(true);
        this.setFitToHeight(true);
        this.setStyle("-fx-background: #2b2b2b; -fx-padding: 0;");
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
    }
}
