import java.util.*;

public class Proconsumer{
	public static void main(String []ar)throws InterruptedException
	{
		final PC pc=new PC();
		Thread t1 =new Thread(new Runnable(){
		  public void run(){
			try{
				pc.produce();
			}
			catch(InterruptedException e){
			  e.printStackTrace();
			}
		  }
		});
		Thread t2=new Thread(new Runnable(){
		   public void run(){
			try{
				pc.consume();
			}
			catch(InterruptedException e){
			  e.printStackTrace();
			}
		  }
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	public static class PC{
		LinkedList<Integer>list=new LinkedList<>();
		int capacity=2;
		
		public void produce() throws InterruptedException{
		  int value =0;
		 while(true){
			synchronized(this){
			  while(list.size()==capacity)
			    wait();
			  System.out.println("Producer produce-"+value);
			  list.add(value++);
			  notify();
			  Thread.sleep(1000);
			}
		 }
		}
		public void consume() throws InterruptedException{
		 while(true){
			synchronized(this){
			  while(list.size()==0)
			    wait();
			  int val=list.removeFirst();
			  System.out.println("Producer consume-"+val);
			  notify();
			  Thread.sleep(1000);
			}
		 }
		}
		
	}

}



/*[ty13@pc19 setA]$ java Proconsumer
Producer produce-0
Producer produce-1
Producer consume-0
Producer consume-1
Producer produce-2
Producer produce-3
Producer consume-2
Producer consume-3
Producer produce-4
Producer produce-5
Producer consume-4
Producer consume-5
Producer produce-6
Producer produce-7
Producer consume-6
Producer consume-7
Producer produce-8
Producer produce-9
Producer consume-8
Producer consume-9
Producer produce-10
Producer produce-11
Producer consume-10
Producer consume-11
Producer produce-12
Producer produce-13
Producer consume-12
Producer consume-13
Producer produce-14
Producer produce-15
Producer consume-14
Producer consume-15
Producer produce-16
Producer produce-17
Producer consume-16
Producer consume-17
Producer produce-18
Producer produce-19
Producer consume-18
Producer consume-19
Producer produce-20
Producer produce-21
Producer consume-20
Producer consume-21
Producer produce-22
Producer produce-23
Producer consume-22
Producer consume-23
Producer produce-24
Producer produce-25
Producer consume-24
Producer consume-25
Producer produce-26
Producer produce-27
Producer consume-26
Producer consume-27
Producer produce-28
Producer produce-29
Producer consume-28
Producer consume-29
Producer produce-30
Producer produce-31
Producer consume-30
Producer consume-31
Producer produce-32
Producer produce-33
Producer consume-32
Producer consume-33
Producer produce-34
Producer produce-35
Producer consume-34
Producer consume-35
Producer produce-36
Producer produce-37
Producer consume-36
Producer consume-37
Producer produce-38
Producer produce-39
Producer consume-38
Producer consume-39
Producer produce-40
Producer produce-41
Producer consume-40
Producer consume-41
Producer produce-42
Producer produce-43
Producer consume-42
Producer consume-43
Producer produce-44
Producer produce-45
Producer consume-44
Producer produce-46
Producer consume-45
Producer consume-46
Producer produce-47
Producer produce-48
Producer consume-47
Producer consume-48
Producer produce-49
Producer produce-50
Producer consume-49
Producer consume-50
Producer produce-51
Producer produce-52
Producer consume-51
Producer consume-52
*/
