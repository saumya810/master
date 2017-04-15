package swiggy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Created by svarshne on 3/25/2017.
 */
public class sliding_window_max {

    void insertElement(int [] A,int i,deque_winow w,int k)
            {
                if(w.start==null)
                {
                    w.insertStart(i);
                }
                else
                {
                    if(i-w.getStart()>=k)
                    {
                        w.removestart();
                    }
                    deque_winow.Node temp;
                    temp=w.end;
            while(temp!=null && A[temp.data]<A[i])
            {
                temp=temp.pre;
                w.removeEnd();
            }
            w.insertEnd(i);


        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String[] str1=str.split(" ");
        int size=str1.length;
        int []A=new int[size];
        for(int i=0;i<size;i++)
        {
            A[i]=Integer.parseInt(str1[i]);
        }
        str=br.readLine();
        int k=Integer.parseInt(str);
        deque_winow dq=new deque_winow();
        sliding_window_max ob1=new sliding_window_max();
        for (int i = 0; i < size ; i++) {
            ob1.insertElement(A,i,dq,k);
            System.out.println(A[dq.start.data]);
        }
    }
}
