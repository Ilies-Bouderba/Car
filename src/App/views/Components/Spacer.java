package Components;

import javafx.scene.layout.Region;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Spacer extends Region {
    public Spacer() {
        HBox.setHgrow(this, Priority.ALWAYS);
    }
}
