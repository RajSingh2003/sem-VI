import java.util.ArrayList;
import java.util.*;
import java.io.*;
class ArrayListC{
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
