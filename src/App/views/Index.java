import Layouts.CarGrid;
import Layouts.PageLayout;
import App.Utils.StageUtil;
import javafx.application.Application;
import javafx.stage.Stage;

public class Index extends Application {

    private static final Object[][] CAR_DATA = {
        {"2024", "Tesla Model S", "$80,000", "Sedan", "Electric", true},
        {"2023", "BMW M4", "$75,000", "Coupe", "Gasoline", false},
        {"2022", "Audi R8", "$150,000", "Coupe", "Gasoline", true},
        {"2021", "Porsche 911", "$130,000", "Coupe", "Gasoline", false},
        {"2024", "Mercedes AMG GT", "$140,000", "Coupe", "Gasoline", true},
        {"2023", "Ferrari 488", "$250,000", "Convertible", "Gasoline", false},
        {"2022", "Lamborghini Huracan", "$220,000", "Coupe", "Gasoline", true},
        {"2021", "McLaren P1", "$1,200,000", "Coupe", "Hybrid", false},
        {"2020", "Ford Mustang", "$55,000", "Coupe", "Gasoline", false},
        {"2019", "Chevrolet Camaro", "$50,000", "Coupe", "Gasoline", true},
        {"2021", "Aston Martin DB11", "$210,000", "Coupe", "Gasoline", false},
        {"2022", "Bugatti Chiron", "$3,000,000", "Hypercar", "Gasoline", true}
    };

    @Override
    public void start(Stage primaryStage) {
        PageLayout rootLayout = new PageLayout();
        CarGrid carGrid = new CarGrid(CAR_DATA);
        
        rootLayout.getChildren().add(carGrid);
        rootLayout.setPadding(new javafx.geometry.Insets(10));
        StageUtil.init(primaryStage, rootLayout, "Car Cards");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
