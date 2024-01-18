import java.util.Scanner;
import java.util.*;
import java.io.*;
class Sorted{
	public static void main(String[] args){
		System.out.println("Enter number of Element");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		TreeSet a=new TreeSet();
		System.out.println("Enter all Elements ...");
		for(int i=0;i<n;i++){
			int mob=sc.nextInt();
			a.add(mob);
		}
		System.out.println("Sorted  elements are: "+a);

	}

}
