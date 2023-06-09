import carpackage.Car;
import customer.Customer;
import dbservices.CarServiceDB;
import dbservices.HyperCarService;
import dbservices.PreviousOwnersService;
import dbservices.TopCarsService;
import service.CarStock;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        CarServiceDB car = new CarServiceDB();
        HyperCarService hp = new HyperCarService();
        TopCarsService topCarsService = new TopCarsService();
        PreviousOwnersService previousOwnersService = new PreviousOwnersService();
        var instance = CarStock.getInstance(car,hp,topCarsService,previousOwnersService);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1.List all cars ");
            System.out.println("2.Add car in top ");
            System.out.println("3.Add a new car ");
            System.out.println("4.Modify phone number ");
            System.out.println("5.Filter cars by production year ");
            System.out.println("6.Modify the price of a car ");
            System.out.println("7.List all clients ");
            System.out.println("8.Add a client ");
            System.out.println("9.Add a review ");
            System.out.println("10.Update nr. of prev owners for a car ");
            System.out.println("11.Modify age of a customer ");
            System.out.println("12.Stop the program!!!!");
            System.out.println("13.Show the number of owners for all cars: ");
            System.out.println("14.Show the cars in top ");
            System.out.println("15.Remove a car from the list ");
            System.out.println("16.Update the price on a car with a given name ");
            System.out.println("17.Show all the hypercars in stock ");
            System.out.println("18.Show all previous owners ");
            Car s = new Car("Mercedes E60 ", "bomba rau ", 1992, 250, 12, 25000);
            Car q = new Car("Bmw E60 ", "tank ce sa zic ", 2002, 300, 2, 5000);
//        instance.getAllCars();
            var choice = scanner.next();
            switch (choice) {
                case "1" -> {
                    try {
                        instance.getallTest();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "2" -> {
                    System.out.println("Enter name of car to add in top: ");
                        var name = scanner.next();
                        instance.addCarintop(name);
                }
                case "3" -> {
                    System.out.println("Enter car name: ");
                    var name = scanner.next();
                    System.out.println("Enter description for the car: ");
                    var desc = scanner.next();
                    System.out.println("Enter production date: ");
                    var prod_date = scanner.nextInt();
                    System.out.println("Enter base horsepower: ");
                    var hsp = scanner.nextInt();
                    System.out.println("Enter available stock: ");
                    var stock = scanner.nextInt();
                    System.out.println("Enter price: ");
                    var price = scanner.nextInt();
//                    System.out.println("Este hypercar?");
//                    var ans = scanner.next();
//                    if(ans.equalsIgnoreCase("nu"))
                    instance.addCar(new Car(name, desc, prod_date, hsp, stock, price));
//                    else {
//                        System.out.println("Added horsepower");
//                        int ads = scanner.nextInt();
//                        System.out.println("Type of car");
//                        var typs = scanner.next();
//                        instance.inserthyper(new HyperCar(name, desc, prod_date, hsp, stock, price,ads,typs));
//                    }
                }
                case "4" -> {
                    System.out.println("Enter name: ");
                    var name = scanner.next();
                    System.out.println("New phone number: ");
                    var phone = scanner.next();
                    instance.modifyPhone(name,phone);
                }
                case "5" -> {
                    System.out.println("Enter car name: ");
                    var carname = scanner.next();
                    System.out.println("Enter production year: ");
                    var year = scanner.nextInt();
                    instance.filterCars(carname,year);
                }
                case "6" -> {
                    System.out.println("Enter name of the car: ");
                    var name = scanner.next();
                    System.out.println("Enter price: ");
                    var price = scanner.nextInt();
                    instance.modifyPrice(name,price);
                }
                case "7" -> instance.listClients();
                case "8" -> {
                    System.out.println("Enter name: ");
                    var name = scanner.next();
                    System.out.println("Enter age: ");
                    var age = scanner.next();
                    System.out.println("Enter phone number: ");
                    var phnumber = scanner.next();
                    System.out.println("Enter bank rating: ");
                    var bankRating = scanner.next();
                    System.out.println("Enter password ?? : ");
                    var pass = scanner.next();
                    try {
                        instance.addClient(new Customer(name, age, phnumber, bankRating, pass));
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "9" -> {
                    System.out.println("Enter the name of the car");
                    var name = scanner.next();
                    System.out.println("Enter your review: ");
                    var review = scanner.next();
                    instance.addReview(name,review);
                }
                case "10" -> {
                    System.out.println("Name of the car: ");
                    var name = scanner.next();
                    System.out.println("Add the nr of persons that had the car: ");
                    var per = scanner.nextInt();
                    instance.updateOwners(name,per);
                }
                case "11" ->{
                    System.out.println("Name of customer: ");
                    var nname = scanner.next();
                    System.out.println("New age: ");
                    var agee = scanner.next();
                    instance.modifyAge(nname, agee);
                }
                case "12" -> System.exit(0);
                case "13" -> instance.showPrevious();
                case "14" -> {
                    System.out.println("Enter the name of the car to show its features: ");
                    var name = scanner.next();
                    instance.showTopCars(name);
                }
                case "15" -> {
                    System.out.println("Enter the price of the car that you want to delete from the DB");
                    int price = scanner.nextInt();
                    instance.removeCar(price);
                }
                case "16" ->{
                    System.out.println("Introduceti numele: ");
                    var name = scanner.next();
                    System.out.println("Introduceti pretul: ");
                    int price = scanner.nextInt();
                    instance.updateCar(name,price);

                }
                case "17"->{
                    System.out.println("Hypercars in stock:");
                    instance.showHypers();
                }
                case "18" ->{
                    System.out.println("Urmatorii oameni sunt fostii detinatori ai unei masini:");
                    instance.showPrevs();
                }
            }
            System.out.println("To end the program press 12");
        }
    }
}