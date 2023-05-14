import java.util.HashSet;
import java.util.Set;

public class TopCars {
    private Set<String> tops = new HashSet<>();
    public TopCars(){}

    public void addCarToTop(String name)
    {
        tops.add(name);
    }

    public Set<String> showTop()
    {
        return tops;
    }
}
