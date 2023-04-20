import java.util.*;


public class CarStock {
    List<Car> cars = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    private static class Singleton{
        private static final Singleton instance = new Singleton();
        private Singleton(){}
    }

    public static Singleton getInstance()
    {
        return Singleton.instance;
    }

    public void getAllCars()
    {
        for(Car c : cars)
        {
            System.out.println("\n" + "Name: " + c.getName() + "Description: " + c.getDescription() + "Base Horse Power: " + c.getBase_horsepower() +
                    "Production Date: " + c.getProduction_date() + "Available Stock: " + c.getAvailable_stock());

            System.out.println("Reviews for cars: " + c.getReviews() + "\n");

            if(c instanceof SUV suv)
            {
                System.out.println("Puterea maxima a masinii este: " + suv.combined_horsepower() + "\n");
                Collections.shuffle(suv.thefeats());
                Random rand = new Random();
                System.out.println("The added mods to the car are: ");
                List<String> newfeats = suv.thefeats().subList(0,2);
                for(var d : newfeats)
                {
                    System.out.println(d + " ");
                }
            }
            if(c instanceof HyperCar hc)
            {
                System.out.println("Puterea maxima a masinii este: " + hc.fullHorsepower() + "\n");
                System.out.println("Type ul masinii este: " + hc.getType() + "\n");
            }
            if(c instanceof SuperCar sc)
            {
                System.out.println("Puterea maxima a masinii este: " + sc.new_power() + "\n");
                System.out.println("Rim-urile au materialul: " + sc.getRim_material() + "\n");
            }
        }
    }
    public void addReview(String name, String review)
    {
        for(Car c : cars)
        {
            if(c.getName().equalsIgnoreCase(name))
            {
                c.addReview(review);
                break;
            }
        }
    }
    public void addCar(String name, Integer unitNumber, Integer horsePower)
    {
        for(Car c : cars)
        {
            if(c.getName().equalsIgnoreCase(name))
            {
                c.setAvailable_stock(unitNumber);
                c.setBase_horsepower(horsePower);
                break;
            }
        }
    }
    public void addClient(Customer customer)
    {
        customers.add(customer);
    }

    public void listClients()
    {
        for(Customer customer : customers)
        {
            customer.showStats();
        }
    }
    public void modifyPrice(String name,Integer newprice)
    {
        for(Car c : cars)
        {
            if(c.getName().equalsIgnoreCase(name))
            {
                c.setPrice(newprice);
                break;
            }
        }
    }
    public void filterCars(String name, Integer productionDate)
    {
        for(Car c : cars)
        {
            if(c.getName().equalsIgnoreCase(name) && c.getProduction_date() >= productionDate)
            {
                c.getCars();
            }
        }
    }
    public void modifyPhone(String name, String phone)
    {
        for(Customer customer : customers)
        {
            if(customer.getName().equalsIgnoreCase(name))
            {
                customer.setPhoneNumber(phone);
                break;
            }
        }
    }
    public void addNewCar(Car c)
    {
        cars.add(c);
    }
    public void showPreviousOwners()
    {
        for(Car c : cars)
        {
            System.out.println(c.showPrevs());
        }
    }
    public void modifyAge(String name, Integer age)
    {
        for(Customer customer : customers)
        {
            if(customer.getName().equalsIgnoreCase(name))
            {
                customer.setAge(String.valueOf(age));
                break;
            }
        }
    }

    public void showTopCars(String name)
    {
        for(Car c : cars)
        {
            if(c.getName().equalsIgnoreCase(name))
            {
                System.out.println(c.allTop());
            }
        }
    }


}
