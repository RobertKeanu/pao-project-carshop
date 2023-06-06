package DBServices;

import CarPackage.HyperCar;
import DBConnection.DBConnection;
import Top.TopCars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopCarsService {
    private static TopCarsService instance;
    private static Connection con = DBConnection.getDbConnection();

    public TopCarsService(){}
    public static TopCarsService getInstance()
    {
        if(instance == null)
        {
            instance = new TopCarsService();
        }
        return instance;
    }

    public void allTop() throws SQLException {
        String query = "select * from topcars";
        PreparedStatement pr = con.prepareStatement(query);
        ResultSet rs = pr.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getInt("id_top") + " " + rs.getString("top_name"));
        }
    }
}
