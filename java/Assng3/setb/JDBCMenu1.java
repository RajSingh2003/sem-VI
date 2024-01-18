import java.sql.*;
import java.io.*;
import java.util.*;
class JDBCMenu1
{
public static void main(String args[]) throws Exception
{
Statement stmt=null;
ResultSet rs=null;
PreparedStatement ps1=null,ps2=null;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String model_name,model_color;
int model_number,choice;
Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection("jdbc:postgresql://192.168.1.254/ty52","ty52","");
stmt=con.createStatement();
if(con!=null)
System.out.println("Connection Successful.......");
do
{
System.out.println("1 : View Records");
System.out.println("2 : Insert Record");
System.out.println("3 : Delete Record");
System.out.println("4 : Modify Record");
System.out.println("5 : Search Record");
System.out.println("6 : Exit");
System.out.println("\n Enter your choice :");
choice=Integer.parseInt(br.readLine());
switch(choice)
{
case 1 : rs=stmt.executeQuery("select * from Mobile");
         while(rs.next())
         {
           System.out.print("model_number="+rs.getInt(1));
           System.out.println("model_name="+rs.getString(2));
         }
         break;

case 2 : System.out.println("Enter the model_number");
         model_number=Integer.parseInt(br.readLine());
         System.out.println("Enter model_name");
         model_name=br.readLine();
         System.out.println("Enter model_color");
         model_color=br.readLine();
         ps1=con.prepareStatement("Insert into Mobile values(?,?,?)");
         ps1.setInt(1,model_number);
         ps1.setString(2,model_name);
         ps1.setString(3,model_color);
         ps1.executeUpdate();
         System.out.println("Records inserted successfully");
         break;

case 3 : System.out.println("Enter model_number to be deleted ");
         model_number=Integer.parseInt(br.readLine());
         stmt.executeUpdate("Delete from Mobile where model_number="+model_number);
         System.out.println("Record deleted successfully");
         break;

case 4 : System.out.println("Enter the model_number to be modified");
         model_number=Integer.parseInt(br.readLine());
         System.out.println("Enter model_name");
         model_name=br.readLine();
         System.out.println("Enter model_color");
         model_color=br.readLine();
         ps1=con.prepareStatement("Update  Mobile set model_name=?,model_color=? where model_number=?");
         ps1.setInt(3,model_number);
	 ps1.setString(1,model_name);
         ps1.setString(2,model_color);
         ps1.executeUpdate();
         ps1.executeUpdate();
         System.out.println("Records inserted successfully");
         break;

case 5 : System.out.println("Enter model_number to be searched");
         model_number=Integer.parseInt(br.readLine());
         rs=stmt.executeQuery("select * from Mobile where model_number="+model_number);
         if(rs.next())
{
System.out.print("model_number="+rs.getInt(1));
System.out.println("model_name="+rs.getString(2));
System.out.println("model_color="+rs.getString(3));
}
else
System.out.println("Mobile not found");
break;
}
}while(choice!=6);
}
}

