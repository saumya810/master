package swiggy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by svarshne on 3/26/2017.
 */
public class honeywell {

    public void func (int []A, int i, int j,int n,int []B)
    {
       // B[i]=(B[i]+1)%2;
        //B[j+1]=(B[j+1]-1)%2;
        B[i]=(B[i]+1);
        B[j+1]=(B[j+1]-1);
    }

    public void calArray(int []A, int []B, int n)
    {
        for(int i=0;i<n/2;i++)
        {
            if((B[i]==0&&B[n-i-1]==1)||(B[i]==1&&B[n-i-1]==0))
            {
                int temp=A[i];
                A[i]=A[n-i-1];
                A[n-i-1]=temp;
            }
        }
    }

    public void sum_array(int []B)
    {
        for(int i=1;i<B.length;i++)
        {
            B[i]=(B[i-1]+B[i])%2;
        }
    }
    public void print_Array(int []A)
    {
        for(int i=0;i<A.length;i++)
        {
            System.out.print(A[i]+" ");
        }
    }

    public static void main(String[] args) throws Exception {

        honeywell ob=new honeywell();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int n;
        n=Integer.parseInt(str);
        int []A=new int[n];
        int []B=new int[n+1];
        str=br.readLine();
        String str1[]=str.split(" ");
        for(int i=0;i<n;i++)
        {
            A[i]=Integer.parseInt(str1[i]);
        }
        int num=Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++)
        {
            String s=br.readLine();
            String []s1=s.split(" ");
            ob.func(A,(Integer.parseInt(s1[0]))-1,(Integer.parseInt(s1[1]))-1,n,B);
        }
       // ob.func(A,0,1,5,B);
        //ob.func(A,1,2,5,B);
        ob.sum_array(B);
        ob.calArray(A,B,n);
        ob.print_Array(A);


    }
}
