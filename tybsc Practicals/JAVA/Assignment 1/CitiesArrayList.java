/* java.util.ArrayList;
import java.util.Scanner;

public class CitiesArrayList
{
       public static void main(String[] args)
       {
           Scanner scanner = new Scanner(System.in);
           ArrayList<String> cities = new ArrayList<>();
       
           System.out.print("Enter the number of cities : ");
           int n = scanner.nextInt();
       
           for (int i=0;i<n;i++)
           {
               System.out.println("Enter the name of city "+(i+1)+" : ");
               String city = scanner.next();
               cities.add(city);
           }
           
           System.out.println();
           System.out.println("The cities in the list are : ");
           for (String city : cities)
           {
               System.out.println(city);
           }
           cities.clear();
           
           System.out.println();
           System.out.println("The cities in the list after removal are : ");
           System.out.println();
       
           for (String city : cities)
           {
               System.out.println(city);
           }
      }
       
}
*/
import java.util.ArrayList;
import java.util.*;
import java.io.*;
class CitiesArrayList{
	public static void main(String[] args){
		System.out.println("Enter number of cities");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList a=new ArrayList();
		System.out.println("Enter name of cities");
		for(int i=0;i<n;i++){
			String s=sc.next();
			a.add(s);
		}
		System.out.println("Name of the city is:"+a);
		a.clear();
		System.out.println("After remove :"+a);
	}

}
