/*import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortHashMap
{
       public static void main(String[] args)
       {
              Map<String,Integer>details = new HashMap<>();
              
              details.put("Harsh",21);
              details.put("Shivam",19);
              details.put("Vinay",20);
              details.put("Uddhav",60);
              details.put("Aman",23);
              
              System.out.println("The details before sorting are : ");
              
              for (Map.Entry<String,Integer> entry : details.entrySet())
              {
                   System.out.println(entry.getKey()+" - "+entry.getValue());
              }
              
              Map<String,Integer> sortedDetails = new TreeMap<>(details);
              
              System.out.println("\nThe details after sorting are : ");
              
              for (Map.Entry<String,Integer> entry : sortedDetails.entrySet())
              {
                   System.out.println(entry.getKey()+" - "+entry.getValue());
              }
              
       }
}
*/

  import java.util.Scanner;
import java.util.*;
import java.io.*;
class SortHashMap{
	public static void main(String[] args){
		System.out.println("Enter number of Student");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HashMap<String,Integer> a=new HashMap<String,Integer>();

		for(int i=0;i<n;i++){
		System.out.println("Enter"+ (i+1) +"name of Student and mobile no");
			String s=sc.next();
			int mob=sc.nextInt();
			a.put(s,mob);
		}
		System.out.println("HashMap before sort...");
		Iterator<String> it=a.keySet().iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			System.out.println("name is "+ s +"roll no is "+a.get(s));
		}
		TreeMap<String, Integer>b=new TreeMap(a);
		System.out.println("After Sort is...."+b);

	}

}
