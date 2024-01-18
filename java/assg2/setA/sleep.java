import java.util.*;
import java.lang.*;

class sleep1 extends Thread
{
String msg;
sleep1(String msg)
{
  this.msg=msg;
}
public void run()
{
try 
{
 for(int i=100;i>=0;i--)
{
System.out.println(msg+"-"+i);
Thread.sleep(6000);
}
}
catch(InterruptedException e){}
}
}
class sleepT
{
public static void main(String[] args)
{
sleep1 t1=new sleep1("CountDown in:");
System.out.println(t1);
t1.start();
}
}

