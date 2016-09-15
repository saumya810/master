package DynamicProgramming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class subset_sum_dynamic_programming {
	
	public static void main(String [] str) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s1=br.readLine();
		String [] sa1;
		sa1=s1.split(" ");
		int l=sa1.length;
		int []C=new int[l];
		for(int i=0;i<l;i++)
		{
			C[i]=Integer.parseInt(sa1[i]);
		}
		s1=br.readLine();
		int k=Integer.parseInt(s1);
		
		int A[][]=new int [l][k];
	    for(int i=0;i<l;i++)
	      Arrays.fill(A[i], 0);
	    if(C[0]<l)
	    A[0][C[0]]=1;
	    
	    for(int i=1;i<l;i++)
	    {
	    	for(int j=1;j<=k;j++)
	    	{
	    		if(C[i]==j)
	    			A[i][j-1]=1;
	    		else if(A[i-1][j-1]==1)
	    			A[i][j-1]=1;
	    		else if(C[i]<j&&A[i-1][j-C[i]-1]==1)
	    			A[i][j-1]=1;
	    			if(j==k&&A[i][j-1]==1)
	    			{
	    				System.out.println("true");
	    				return;
	    			}
	    	}
	    }

}
	
}
