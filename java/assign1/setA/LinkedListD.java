
import java.util.*;
import java.io.*;
class LinkedListD{
	public static void main(String[] args){
		System.out.println("Enter number of friend");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		LinkedList a=new LinkedList();
		System.out.println("Enter name of friends");
		for(int i=0;i<n;i++){
			String s=sc.next();
			a.add(s);
		}
		//System.out.println("Linked List element are: "+a);

		Iterator<String>it=a.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
