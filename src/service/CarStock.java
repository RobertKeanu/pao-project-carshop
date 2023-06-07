package service;

import audit.audit;
import carpackage.Car;
import carpackage.HyperCar;
import carpackage.SUV;
import carpackage.SuperCar;
import customer.Customer;
import dbservices.CarServiceDB;
import dbservices.HyperCarService;
import dbservices.PreviousOwnersService;
import dbservices.TopCarsService;
import exceptions.FirstException;

import java.sql.SQLException;
import java.util.*;


public class CarStock {
    List<Car> cars = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    private static audit auditinstance = audit.getInstance();
    private Map<String, Integer> prevowners = new HashMap<>();
    CarServiceDB carServiceDB;
    HyperCarService hyperCarService;
    PreviousOwnersService previousOwnersService;
    TopCarsService topCarsService;
    private Set<Car> carz = new HashSet<>();
    private CarStock(CarServiceDB carServiceDB, HyperCarService hp, TopCarsService topCarsService,PreviousOwnersService previousOwnersService){
        this.carServiceDB = carServiceDB;
        this.hyperCarService = hp;
        this.topCarsService = topCarsService;
        this.previousOwnersService = previousOwnersService;
    }
    private static class Singleton{
        public static CarStock createInstance(CarServiceDB carServiceDB,HyperCarService hp,TopCarsService topCarsService,PreviousOwnersService previousOwnersService)
        {
            return new CarStock(carServiceDB,hp,topCarsService,previousOwnersService);
        }
    }
    public static CarStock getInstance(CarServiceDB carServiceDB,HyperCarService hp,TopCarsService topCarsService,PreviousOwnersService previousOwnersService)
    {
        return Singleton.createInstance(carServiceDB, hp,topCarsService,previousOwnersService);
    }

//    private static class Singleton{
//        private static final Service.CarStock instance = new Service.CarStock();
//    }
//    public static Service.CarStock getInstance()
//    {
//        return Singleton.instance;
//    }
    public void showPrevs() throws SQLException{
        previousOwnersService.allPrevs();
    }
    public void addCar(Car c) throws SQLException {
        carServiceDB.addCar(c);
        auditinstance.makeAudit("added a new car");
    }
    public void showTop() throws FirstException {
        try {
             {
                 topCarsService.allTop();
                auditinstance.makeAudit("showed all top");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void inserthyper(HyperCar hyperCar) throws SQLException{
        hyperCarService.insertHyper(hyperCar);
    }
    public void showHypers() throws SQLException{
        hyperCarService.allHyperCars();
    }
    public void getallTest() throws SQLException {
        carServiceDB.allCars();
        auditinstance.makeAudit("list all cars");
    }

    public void getAllCars()
    {
        for(Car c : cars)
        {
            System.out.println("\n" + "Name: " + c.getName() + "\n" + "Description: " + c.getDescription() + "\n" +  "Base Horse Power: " + c.getBase_horsepower() +
                    "\n" +  "Production Date: "  +  c.getProduction_date() + "\n" +  "Available Stock: " + c.getAvailable_stock() + "\n");

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
        auditinstance.makeAudit("list all cars");
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
        auditinstance.makeAudit("add review");
    }
    public void addClient(Customer customer)
    {

        customers.add(customer);
    }

    public void listClients()
    {
        customers.stream()
                .sorted(Comparator.comparing(Customer::getName));
        for(Customer customer : customers)
        {
            customer.showStats();
        }
        auditinstance.makeAudit("added client!");
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
        auditinstance.makeAudit("modified price");
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
    public void removeCar(int price)
    {
        carServiceDB.removeCar(price);
        auditinstance.makeAudit("deleted a car");
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
    public void updateCar(String name, int price)
    {
        carServiceDB.updatePrice(name,price);
    }
    public void addNewCar(Car c)
    {
        cars.add(c);
        auditinstance.makeAudit("added new car");
    }

    public void updateOwners(String name, Integer nr)
    {
            prevowners.put(name, nr);
    }
    public void showPrevious()
    {
        for(String name : prevowners.keySet())
        {
            String key = name.toString();
            String value = prevowners.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
    public void modifyAge(String name, String age)
    {
        for(Customer customer : customers)
        {
            if(customer.getName().equalsIgnoreCase(name))
            {
                customer.setAge(age);
                break;
            }
        }
    }
    public void addCarintop(String name)
    {
        for(Car c : cars)
        {
            if(c.getName().equalsIgnoreCase(name))
            {
                c.addCarToTop(name);
                break;
            }
        }
    }
    public void showTopCars(String name)
    {
        for(Car c:cars){
            if(c.getName().equalsIgnoreCase(name))
            System.out.println(c.allTop());}
        auditinstance.makeAudit("showing top car");
    }


}
