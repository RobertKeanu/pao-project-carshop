import java.util.HashSet;
import java.util.Set;

public class TopCars {
    private Set<Car> tops = new HashSet<>();

    public void addCarToTop(Car c)
    {
        if(c.getBase_horsepower() >= 350 && c.getPrice() <= 10000 && c.getProduction_date() >= 2007)
        {
            tops.add(c);
        }
    }

    public Set<Car> showTop()
    {
        return tops;
    }
}
