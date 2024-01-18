import java.io.*;
import java.lang.*;

class threads extends Thread{

	String msg="";
	int n;
	threads(String msg, int n){
	   this.msg=msg;
	   this.n=n;
	}
	public void run(){
	try{
		for(int i=1;i<=n;i++)
			System.out.println(msg+"   "+i+" times");
			System.out.println("\n");
		
	   }
	catch(Exception e){}
	
	}
}

class covid{
	public static void main(String ar[])
	{
		int n= Integer.parseInt(ar[0]);
		threads t1=new threads("COVID19",n);
		t1.start();
		threads t2=new threads("LOCKDOWN2020",n+10);
		t2.start();
		threads t3=new threads("LOCKDOWN2021",n+20);
		t3.start();
	}


}
