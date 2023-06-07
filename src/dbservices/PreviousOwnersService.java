package dbservices;

import dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreviousOwnersService {
    private static PreviousOwnersService  instance;
    private static Connection con = DBConnection.getDbConnection();

    public PreviousOwnersService (){}
    public static PreviousOwnersService  getInstance()
    {
        if(instance == null)
        {
            instance = new PreviousOwnersService ();
        }
        return instance;
    }

    public void allPrevs() throws SQLException {
        String query = "select * from previousowners";
        PreparedStatement pr = con.prepareStatement(query);
        ResultSet rs = pr.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getInt("id") + " " + rs.getString("name"));
        }
    }
}
