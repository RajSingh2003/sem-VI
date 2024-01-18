import java.sql.*;
import java.io.*;
public class Donar
{
public static void main(String args[]) throws Exception
{
Statement stmt;
Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.1.254/ty52","ty52","");
stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select * from Donar");
java.sql.ResultSetMetaData rsmd=rs.getMetaData();
int noOfColumns = rsmd.getColumnCount();
System.out.println("Number of columns="+noOfColumns);
for(int i=1;i<=noOfColumns;i++)
{
System.out.println("Column No :"+i);
System.out.println("Column Name :"+rsmd.getColumnName(i));
System.out.println("Column Type :"+rsmd.getColumnTypeName(i));
System.out.println("Column display size :"+rsmd.getColumnDisplaySize(i));
}
con.close();
}
}
