import java.sql.*;
import java.io.*;
public class DaTaBase
{
  public static void main(String args[]) throws Exception
  {
    ResultSet rs=null;
    Class.forName("org.postgresql.Driver");
    Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.1.254/ty52","ty52","");
    DatabaseMetaData dbmd=con.getMetaData();
    System.out.println("Database product name :"+dbmd.getDatabaseProductName());
    System.out.println("User name :"+dbmd.getUserName());
    System.out.println("Database driver name :"+dbmd.getDriverName());
    System.out.println("Database driver version :"+dbmd.getDriverVersion());
    System.out.println("Database product name :"+dbmd.getDatabaseProductName());
    System.out.println("Database Version :"+dbmd.getDriverMajorVersion());
    rs=dbmd.getTables(null,null,null,new String[]{"TABLE"});
    System.out.println("List of Tables.....");
    while(rs.next())
    {
      String tblname=rs.getString("TABLE_NAME");
      System.out.println("Table :"+tblname);
    }
    con.close();
  }
}

