import Layouts.CarGrid;
import Layouts.PageLayout;
import App.Utils.StageUtil;
import App.Dao.CarDao;
import App.Models.CarModel;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class Index extends Application {

    @Override
    public void start(Stage primaryStage) {
        PageLayout rootLayout = new PageLayout();
        List<CarModel> cars = new CarDao().getAllCars();
        Object[][] carData = new Object[cars.size()][6];
        for (int i = 0; i < cars.size(); i++) {
            CarModel car = cars.get(i);
            carData[i][0] = String.valueOf(car.getYear());
            carData[i][1] = car.getMakerName() + " " + car.getModelName();
            carData[i][2] = String.valueOf((int) car.getPrice());
            carData[i][3] = car.getFuelType();
            carData[i][4] = car.getImage();
            carData[i][5] = car.getDescription();
        }

        CarGrid carGrid = new CarGrid(carData);
        rootLayout.getChildren().add(carGrid);
        rootLayout.setPadding(new javafx.geometry.Insets(10));
        StageUtil.init(primaryStage, rootLayout, "Car Cards");
    }

    public static void main(String[] args) {
        launch(args);
    }
}