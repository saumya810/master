package Thread;

import java.io.*;
import java.util.*;
/**
 * Created by svarshne on 2/19/2017.
 */
public class Mythread {

    int sum=0;
    int sum1=0;
    StringBuilder builder = new StringBuilder();

    public static class thread1 implements Runnable{
        Mythread ob;
        public thread1(Mythread ob)
        {
            this.ob=ob;
        }
        @Override
        public void run()
        {

            System.out.println(Thread.currentThread().getName()+"  is running");
            ob.add("ABCD");
        }
    }

    public void add(String i)
    {
        // synchronized (this)
        {
            this.builder.append(i);
            this.builder.append(i);
            this.builder.append(i);
        }
        System.out.println(this.builder);
    }
    public static void main(String[] args) {

        Mythread ob=new Mythread();
        for (int i=0;i<100;i++)
        {

            new Thread(new thread1(ob),"thread_"+Integer.toString(i)).start();

        }
    }
}
