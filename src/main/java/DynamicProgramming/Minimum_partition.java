package DynamicProgramming;
import java.io.*;
import java.util.*;

public class Minimum_partition {

	
	public int minimum_sum_diff(int []A)
	{
		int sum=0;
		for(int i=0;i<A.length;i++)
		{
			sum=sum+A[i];
		}
		int [][]B=new int [A.length][sum/2+1];
	//	for(int i=0;i<A.length;i++)
		{
		//	Arrays.fill(B[i],0);
		}
		int max=0;
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<=sum/2;j++)
			{
				if(A[i]==j)
				{
					B[i][j]=1;
					max=Math.max(max,j);
				}
				else if(i>0&&B[i-1][j]==1)
					B[i][j]=1;
				
				else if(A[i]<j&&i>0&&B[i-1][j-A[i]]==1)
				{
					B[i][j]=1;
					max=Math.max(max,j);
				}
					
				
			}
		}
		
		
			return sum-2*max;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
	    String s[];
		s=str.split(" ");
		int []A=new int [s.length];
		for(int i=0;i<s.length;i++)
		{
			A[i]=Integer.parseInt(s[i]);
		}
		Minimum_partition ob1=new Minimum_partition();
		System.out.println(ob1.minimum_sum_diff(A));

	}

}
