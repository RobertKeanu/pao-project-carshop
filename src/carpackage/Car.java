package carpackage;

import java.util.*;
import top.TopCars;
import previousowners.PreviousOwners;

public class Car {
    private String name;
    private String description;
    private int production_date;
    private int base_horsepower;
    private int available_stock;

    private int price;
    private List<String> reviews = new ArrayList<>();

    private Set<Car> carsss = new HashSet<>();

    private PreviousOwners prevs;
    private TopCars top;

    public Car(String name, String description, int production_date, int base_horsepower, int available_stock, int price)
    {
        this.name = name;
        this.description = description;
        this.production_date = production_date;
        this.base_horsepower = base_horsepower;
        this.available_stock = available_stock;
        this.price = price;
        top = new TopCars();
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
        System.out.println("CarPackage.Car Name: " + this.getName() + "Base Horsepower: " + this.getBase_horsepower() + "Description: " + this.getDescription()
        + "Fabrication Year: " + this.getProduction_date() + "Available Stock: " + this.getAvailable_stock());
    }

    public void addReview(String review)
    {
        this.reviews.add(review);
    }

    public Set<String> allTop()
    {
        return top.showTop(); //features of a car
    }

    public void addPrevs(String name, Integer nr) { prevs.updateOwners(name,nr);}

    public void addCarToTop(String name) { top.addCarToTop(name); }
    public Map<String,Integer> showPrevs()
    {
        return prevs.showPrevious();
    }
}

