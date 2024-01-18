 import java.util.Scanner;
import java.util.*;
import java.io.*;
class HashSort{
	public static void main(String[] args){
		System.out.println("Enter number of Student");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HashMap<String,Integer> a=new HashMap<String,Integer>();

		for(int i=0;i<n;i++){
		System.out.println("Enter"+ (i+1) +"name of Student and roll no");
			String s=sc.next();
			int mob=sc.nextInt();
			a.put(s,mob);
		}
		System.out.println("HashMap before sort..."+a);
		Iterator<String> it=a.keySet().iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			System.out.println("name is "+ s +" roll no is "+a.get(s));
		}
		TreeMap<String, Integer>at=new TreeMap(a);
		System.out.println("After Sort is...."+at);

	}

}
