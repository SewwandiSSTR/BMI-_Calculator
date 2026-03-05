// Member 1: Data Model
public class UserData {
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String hUnit;
    private String wUnit;

    //Set Values
    public UserData(int age, String gender, double height, String hUnit, double weight, String wUnit) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.hUnit = hUnit;
        this.weight = weight;
        this.wUnit = wUnit;
    }

    // Getters for the calculation engine
    public double getHeight() { return height; }
    public double getWeight() { return weight; }
    public String getHUnit() { return hUnit; }
    public String getWUnit() { return wUnit; }
}