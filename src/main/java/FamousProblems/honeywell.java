package FamousProblems;

import java.io.IOException;
import java.io.*;
/**
 * Created by svarshne on 4/2/2017.
 */
public class honeywell {

    int getMaxColumn(int [][]A, int c,int n,int m)
    {
        int count =1;
        int max=count;
        for(int i =0;i<n-1;i++)
        {
            if(A[i][c]==A[i+1][c])
            {
             count++;
             max=Math.max(count,max);

            }
            else
                count=1;
        }
        //System.out.println(max);
        return max;
    }

    int getMaxrow(int [][]A, int c,int n,int m)
    {
        int count =1;
        int max=count;
        for(int i =0;i<m-1;i++)
        {
            if(A[c][i]==A[c][i+1])
            {
                count++;
                max=Math.max(count,max);

            }
            else
                count=1;
        }
       // System.out.println(max);
        return max;
    }


    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        honeywell ob1=new honeywell();

        for (int i1 = 0; i1 < N; i1++) {

            line=br.readLine();
            String str[]=line.split(" ");
            int n=Integer.parseInt(str[0]);
            int m=Integer.parseInt(str[1]);
            int [][]A=new int [n][m];
            for(int a=0;a<n;a++)
            {
                line= br.readLine();
                String [] str1= line.split(" ");
                for(int j=0;j<m;j++)
                {
                    A[a][j]=Integer.parseInt(str1[j]);
                   // System.out.println(A[a][j]);
                }
            }

            int [] row_Max=new int [n];
            int [] column_Max=new int [m];
            for(int i=0;i<n;i++)
            {
                row_Max[i]=ob1.getMaxrow(A,i,n,m);
            }

            for(int i=0;i<m;i++)
            {
                column_Max[i]=ob1.getMaxColumn(A,i,n,m);
            }
            int max=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    max=Math.max(max,row_Max[i]*column_Max[j]);
                }
            }
            System.out.println(max);
        }


    }


}
