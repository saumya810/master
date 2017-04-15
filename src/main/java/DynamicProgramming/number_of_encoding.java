package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.Arrays;

/**
 * Created by svarshne on 3/3/2017.
 */
public class number_of_encoding {

    int encoding_numbers(int []A,String str,int i)
    {
        if(i>=A.length)
            return 1;
        if(A[i]!=-1)
            return A[i];
        if(str.charAt(i)=='0')
        {
          A[i]=0;
          return 0;
        }
        if(i==A.length-1||str.charAt(i)>='3'||(str.charAt(i)=='2'&&str.charAt(i+1)>'6'))
        {
            A[i]=encoding_numbers(A,str,i+1);
            //return(A[i]);
        }
        else
        {
            A[i]=encoding_numbers(A,str,i+1)+encoding_numbers(A,str,i+2);
        }
        return A[i];

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string ");
        String str = br.readLine();
        int []A=new int [str.length()];
        Arrays.fill(A,-1);
        number_of_encoding o=new number_of_encoding();
        System.out.println(o.encoding_numbers(A,str,0));


    }
}
