package App.Dao;

import App.Models.CarModel;
import App.rss.database.Connect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    public List<CarModel> getAllCars() {
        List<CarModel> cars = new ArrayList<>();
        String sql = """
            SELECT 
                c.Agent_Id, c.Maker_Id, c.Model_Id, c.Fuel_Id, c.Year, c.Price, c.Description,
                m.Name AS MakerName, mo.Name AS ModelName, f.Name AS FuelType, a.Name AS AgentName,
                (SELECT ci.Image 
                 FROM Car_Images ci 
                 WHERE ci.Car_Id = c.Id 
                 ORDER BY ci.Id ASC 
                 LIMIT 1) AS Image
            FROM Cars c
            JOIN Car_Makers m ON c.Maker_Id = m.Id
            JOIN Car_Models mo ON c.Model_Id = mo.Id
            JOIN Fuel_Type f ON c.Fuel_Id = f.Id
            JOIN Agent a ON c.Agent_Id = a.Id
        """;

        try (PreparedStatement pstmt = Connect.getConnection().prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                CarModel car = new CarModel(
                    rs.getInt("Agent_Id"),
                    rs.getInt("Maker_Id"),
                    rs.getInt("Model_Id"),
                    rs.getInt("Fuel_Id"),
                    rs.getInt("Year"),
                    rs.getFloat("Price"),
                    rs.getString("Description"),
                    rs.getString("MakerName"),
                    rs.getString("ModelName"),
                    rs.getString("FuelType"),
                    rs.getString("AgentName"),
                    rs.getString("Image")
                );
                cars.add(car);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching cars: " + e.getMessage());
        }

        return cars;
    }
}