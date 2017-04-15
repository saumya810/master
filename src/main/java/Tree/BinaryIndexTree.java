package Tree;
import java.io.*;
import java.util.*;
/**
 * Created by svarshne on 1/10/2017.
 */
public class BinaryIndexTree {

    class N implements Comparable<N>{
        int num;
        int ind;

        public N(int nu,int ind)
        {
            this.num=nu;
            this.ind=ind;
        }

        @Override
        public int compareTo(N o) {
            return Integer.compare(num,o.num);
        }




    }
    int query(int index,int []B)
    {
        int num=0;
        for(;index>=0;index-=index&(-index))
        {
            num=Math.max(num,B[index]);
        }
        return num;
    }

    void update(int index,int []B,int val)
    {
        int num=B[index];
        //index+=index&(-index);
        B[index]+=val;
        for(;index<B.length;index+=index&(-index))
    {
        B[index]=Math.max(num,B[index]);
        num=B[index];
    }
    }

    int lis(int []A)
    {
        ArrayList<N> N1=new ArrayList<N>();
        for (int i=0;i<A.length;i++)
        {
            N1.add(new N(A[i],i));
        }
       Collections.sort(N1);
        for(int i=0;i<A.length;i++)
        {
            N n1=N1.get(i);

        }
        return 0;
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        String []s=str.split(" ");
        int []A=new int[s.length];
        int []B=new int[s.length];
        for(int i=0;i<s.length;i++)
        {
            A[i]=Integer.parseInt(s[i]);
            //N1.add(new N())
        }



    }
}
