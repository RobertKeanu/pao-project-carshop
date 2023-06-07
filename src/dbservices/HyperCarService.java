package dbservices;

import carpackage.HyperCar;
import dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HyperCarService {
    private static HyperCarService instance;
    private int nrhypers;
    private static Connection con = DBConnection.getDbConnection();

    public HyperCarService(){}
    public static HyperCarService getInstance()
    {
        if(instance == null)
        {
            instance = new HyperCarService();
        }
        return instance;
    }

    public void allHyperCars() throws SQLException{
        String query = "select * from hypercar";
        PreparedStatement pr = con.prepareStatement(query);
        ResultSet rs = pr.executeQuery();
        while(rs.next())
        {
            nrhypers = Integer.parseInt(rs.getString(1));
            System.out.println(rs.getInt("id_hypercar") + " " + rs.getString("added_horsepower")
                    + " " + rs.getString("type"));
        }
    }
    public void insertHyper(HyperCar hp) throws SQLException{
        String query = "insert into hp (id, added_horsepower, type) values (?, ?, ?)";
        PreparedStatement pr = con.prepareStatement(query);
        pr.setInt(1, nrhypers+1);
        pr.setInt(2, hp.getAdded_horsepower());
        pr.setString(3,hp.getType());
        pr.execute();
    }

}
