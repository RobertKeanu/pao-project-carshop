import java.util.*;

public abstract class Car {
    private String name;
    private String description;
    private Integer production_date;
    private Integer base_horsepower;
    private Integer available_stock;

    private Integer price;
    private List<String> reviews = new ArrayList<>();

    private PreviousOwners prevs;
    private TopCars top;

    public Car(String name, String description, Integer production_date, Integer base_horsepower, Integer available_stock, Integer price)
    {
        this.name = name;
        this.description = description;
        this.production_date = production_date;
        this.base_horsepower = base_horsepower;
        this.available_stock = available_stock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getProduction_date() {
        return production_date;
    }

    public Integer getBase_horsepower() {
        return base_horsepower;
    }

    public Integer getAvailable_stock() {
        return available_stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<String> getReviews() {
        return Collections.singletonList(reviews.toString());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProduction_date(Integer production_date) {
        this.production_date = production_date;
    }

    public void setBase_horsepower(Integer base_horsepower) {
        this.base_horsepower = base_horsepower;
    }

    public void setAvailable_stock(Integer available_stock) {
        this.available_stock = available_stock;
    }

    public void getCars(){
        System.out.println("Car Name: " + this.getName() + "Base Horsepower: " + this.getBase_horsepower() + "Description: " + this.getDescription()
        + "Fabrication Year: " + this.getProduction_date() + "Available Stock: " + this.getAvailable_stock());
    }

    public void addReview(String review)
    {
        this.reviews.add(review);
    }

    public Set<Car> allTop()
    {
        return top.showTop();
    }

    public Map<String,Integer> showPrevs()
    {
        return prevs.showPrevious();
    }
}

