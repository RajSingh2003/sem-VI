import java.lang.*;
import java.util.*;
class myThread extends Thread
{
  int a[],sum=0,p;
  myThread(int p,int[] a)
  {
    this.a=a;
    this.p=p;
  }
  public void run()
  {
    int i;
    for(i=0;i<p+100;i++)
    sum=sum+a[i];
  }
  int getSum()
  {
    System.out.println("Sum is"+sum);
    return sum;
  }
}

class Thousandno
{
  public static void main(String args[])
  {  
    myThread[] t=new myThread[10];
    int sum=0,i;
    int myArray[]=new int[1000];
    Random r=new Random();
    for(i=0;i<1000;i++)
    {
	myArray[i]=r.nextInt(1000);
    }
    System.out.println("Random no. is:");
    for(i=0;i<1000;i++)
    System.out.println("\n"+myArray[i]);
    try
    { 
      for(i=0;i<10;i++)
      {
	t[i]=new myThread(i*100,myArray);
	t[i].start();
	t[i].join();
      } 
      for(i=0;i<10;i++)
      {
	sum+=t[i].getSum();
      }
      System.out.println("Sum :"+sum);
      System.out.println("Average :"+sum/1000);
    }
    catch(InterruptedException e) {}
  }
}

