/*import java.util.TreeSet;

public class ColorTreeSet
{
       public static void main(String[] args)
       {
              TreeSet<String> colors = new TreeSet<>();
              
              colors.add("red");
              colors.add("green");
              colors.add("blue");
              colors.add("yellow");
              colors.add("orange");
              
              System.out.println("The colors in the TreeSet are : ");
              //for each
              for (String color : colors)
              {
                  System.out.println(color);
              }
       }
}
*/

import java.util.Set;
import java.util.TreeSet;
import java.util.*;
import java.io.*;
class ColorTreeSet{
	public static void main(String[] args){
		System.out.println("Enter number of Color");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Set a=new TreeSet();
		System.out.println("Enter name of Color");
		for(int i=0;i<n;i++){
			String s=sc.next();
			a.add(s);
		}
		System.out.println("TreeSet elements are: "+a);

	}

}
