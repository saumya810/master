package amazon;

import jdk.nashorn.internal.runtime.ECMAException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by svarshne on 4/13/2017.
 */
public class amazon_twoplayer {

    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int k= Integer.parseInt(str[0]);
        int l=Integer.parseInt(str[1]);
        int n=Integer.parseInt(str[2]);
        int []A=new int [n];
        A[0]=1;
        A[k-1]=1;
        A[l-1]=1;
        for(int i=1;i<n;i++)
        {
            if(i<=k-1)
            {
                A[i]=~A[i-1];
            }
            else if(i<=l-1)
            {
                A[i]=~(A[i-1]|A[i-k]);
            }
            else
            {
                A[i]=~((A[i-1]|A[i-k])|A[i-l]);
            }
        }
        System.out.println(A[n-1]);

    }
}
