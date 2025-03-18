package App.Models;

public class CarModel {
    private int agentId;
    private int makerId;
    private int modelId;
    private int fuelId;
    private int year;
    private float price;
    private String description;
    private String makerName;
    private String modelName;
    private String fuelType;
    private String agentName;
    private String image;

    public CarModel(int agentId, int makerId, int modelId, int fuelId, int year, float price, String description,
                    String makerName, String modelName, String fuelType, String agentName, String image) {
        this.agentId = agentId;
        this.makerId = makerId;
        this.modelId = modelId;
        this.fuelId = fuelId;
        this.year = year;
        this.price = price;
        this.description = description;
        this.makerName = makerName;
        this.modelName = modelName;
        this.fuelType = fuelType;
        this.agentName = agentName;
        this.image = image;
    }

    public int getAgentId() { return agentId; }
    public int getMakerId() { return makerId; }
    public int getModelId() { return modelId; }
    public int getFuelId() { return fuelId; }
    public int getYear() { return year; }
    public float getPrice() { return price; }
    public String getDescription() { return description; }
    public String getMakerName() { return makerName; }
    public String getModelName() { return modelName; }
    public String getFuelType() { return fuelType; }
    public String getAgentName() { return agentName; }
    public String getImage() { return image; }
}