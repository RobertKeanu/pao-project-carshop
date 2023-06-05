package DBServices;

import DBConnection.DBConnection;
import CarPackage.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CarServiceDB {
    private static CarServiceDB instance;
    private static Connection con = DBConnection.getDbConnection();

    private CarServiceDB(){}

    public static CarServiceDB getInstance()
    {
        if(instance == null)
        {
            instance = new CarServiceDB();
        }
        return instance;
    }
    public Map<Integer, Car> getCars()
    {
        Map<Integer, Car> cars= new HashMap<>();
        try
        {
            String query1 = "select * from car";
            PreparedStatement pr = con.prepareStatement(query1);
            ResultSet resultSet = pr.executeQuery();
            while(resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
                cars.put(id,new Car(name,"tank",2002, 100,1000,100));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }
}
