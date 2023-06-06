package CarPackage;

import CarPackage.Car;

public class HyperCar extends Car {
    private Integer added_horsepower;
    private String type;
    //meaning if its electrical or combustion

    public HyperCar(String name, String description, Integer production_date, Integer base_horsepower, Integer available_stock,Integer price,Integer added_horsepower, String type) {
        super(name, description, production_date, base_horsepower, available_stock, price);

        this.added_horsepower = added_horsepower;
        this.type = type;
    }

    public Integer getAdded_horsepower() {
        return added_horsepower;
    }

    public String getType() {
        return type;
    }

    public void setAdded_horsepower(Integer added_horsepower) {
        this.added_horsepower = added_horsepower;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer fullHorsepower()
    {
        return this.added_horsepower + getBase_horsepower();
    }

    @Override
    public String toString() {
        return "CarPackage.HyperCar{" +
                "added_horsepower=" + added_horsepower +
                ", type='" + type + '\'' +
                '}';
    }
}
