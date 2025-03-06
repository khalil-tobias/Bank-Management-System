import java.sql.*;
public class Connect {
  Connection con;
  Statement st;

  public Connect() {
      try
      {
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root","kings0321!");
          st = con.createStatement();
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
  }
}