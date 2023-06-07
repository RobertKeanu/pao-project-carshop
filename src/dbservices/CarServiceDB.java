package dbservices;

import dbconnection.DBConnection;
import carpackage.Car;

import java.sql.*;

public class CarServiceDB {
    private static CarServiceDB instance;
    private int carsize;
    private static Connection con = DBConnection.getDbConnection();

    public CarServiceDB(){}

    public static CarServiceDB getInstance()
    {
        if(instance == null)
        {
            instance = new CarServiceDB();
        }
        return instance;
    }
    public void allCars() throws SQLException {
        String query = "select * from car";
        PreparedStatement pr = con.prepareStatement(query);
        ResultSet resultSet = pr.executeQuery();
        while(resultSet.next())
        {
            carsize = Integer.parseInt(resultSet.getString(1));
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name")
            + " " + resultSet.getString("description") +" " + resultSet.getInt("price"));
        }
    }
    public void addCar(Car car) throws SQLException {
        String query = "insert into car (id, name, description, production_year, base_horsepower, available_stock, price) values " +
                "(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pr = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pr.setInt(1,carsize+1);
        pr.setString(2, car.getName() );
        pr.setString(3, car.getDescription() );
        pr.setString(4, String.valueOf(car.getProduction_date()));
        pr.setString(5, String.valueOf(car.getBase_horsepower()) );
        pr.setString(6, String.valueOf(car.getAvailable_stock()));
        pr.setString(7, String.valueOf(car.getPrice()) );
        pr.execute();
        int id = -1;
        ResultSet rs = pr.getGeneratedKeys();
        if(rs.next())
            id = rs.getInt(1);
    }
    public void removeCar(int price)
    {
        String deletebyPrice = "delete from car where price = ?";
        try{
            PreparedStatement st = con.prepareStatement(deletebyPrice);
            st.setInt(1, price);
            st.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void updatePrice(String name,int price)
    {
        String updatePr = "update car set name = ? where price = ?";
        try{
            PreparedStatement pr = con.prepareStatement(updatePr);
            pr.setString(1,name);
            pr.setInt(2,price);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
