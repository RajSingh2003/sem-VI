import java.io.*;
import java.sql.*;

class DB
{

	public static void main(String[] args) throws Exception
	{
		System.out.println("Welcome to JDBC!");
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://192.168.1.254/ty52","ty52","");
			if(con==null){
				System.out.println("Connection failed");			
			}else{
				Systemfile:///usr/share/doc/HTML/index.html.out.println("Connection Successful");
				st=con.createStatement();
				rs=st.executeQuery("Select * from student");
				while(rs.next()){
					System.out.println("Rno = "+rs.getInt(1)+ "\t\t" + "student name = " + rs.getString(2));
				}
				con.close();	
			}
		}
		catch(Exception e){
			System.out.println("Error"+e);
		}
		
	}
}
