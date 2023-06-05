package CarPackage;

import CarPackage.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SUV extends Car {
    private Integer added_horsepower;
    private List<String> added_features = Arrays.asList("28' inch wheels", "Louder exhaust", "Ceramic break disc","Bigger calipers");

    private List<String> feats = new ArrayList<>();
    public SUV(String name, String description, Integer production_date, Integer base_horsepower, Integer available_stock,Integer price) {
        super(name, description, production_date, base_horsepower, available_stock,price);

        this.added_horsepower = added_horsepower;
    }

    public Integer getAdded_horsepower() {
        return added_horsepower;
    }

    public void setAdded_horsepower(Integer added_horsepower) {
        this.added_horsepower = added_horsepower;
    }

    public void add_feats(String feat)
    {
        this.feats.add(feat);
    }
    public List<String> thefeats()
    {
        return added_features;
    }
    public Integer combined_horsepower()
    {
        return getBase_horsepower() + this.added_horsepower;
    }
}
