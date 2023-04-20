import java.util.HashMap;
import java.util.Map;

public class PreviousOwners {
    private Map<String, Integer> prevowners = new HashMap<>();
    public PreviousOwners(){}

    public void updateOwners(String name, Integer nr)
    {
        if(prevowners.get(name) == null)
        {
            prevowners.put(name, 0);
        }
        else
        {
            prevowners.put(name, nr);
        }

    }
    public Map<String,Integer> showPrevious()
    {
        return prevowners;
    }
}
