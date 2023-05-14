public class SuperCar extends Car{
    private Integer added_horsepower;
    private String rim_material;
    public SuperCar(String name, String description, Integer production_date, Integer base_horsepower, Integer available_stock, Integer price) {
        super(name, description, production_date, base_horsepower, available_stock, price);

        this.added_horsepower = added_horsepower;
        this.rim_material = rim_material;
    }

    public Integer getAdded_horsepower() {
        return added_horsepower;
    }

    public String getRim_material() {
        return rim_material;
    }

    public void setAdded_horsepower(Integer added_horsepower) {
        this.added_horsepower = added_horsepower;
    }

    public void setRim_material(String rim_material) {
        this.rim_material = rim_material;
    }

    @Override
    public String toString() {
        return "SuperCar{" +
                "added_horsepower=" + added_horsepower +
                ", rim_material='" + rim_material + '\'' +
                '}';
    }

    public Integer new_power()
    {
        return this.added_horsepower + getBase_horsepower();
    }
}
