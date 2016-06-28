package geeksforgeeks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class longest_path_in_matrix {

	static int isNeighbour(int i,int j,int [][]B,int n)
	{
		if(i>0&&B[i-1][j]==B[i][j]+1)
		    return 1;
		if(j<n-1&&B[i][j+1]==B[i][j]+1)
			return 2;
		if(i<n-1&&B[i+1][j]==B[i][j]+1)
			return 3;
		if(j>0&&B[i][j-1]==B[i][j]+1)
			return 4;
		return -1;
		
		
	}
	public static void main(String arr[]) throws Exception
	{
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Enter the number of nodes ");
		String str=br.readLine();
		int n=Integer.parseInt(str);
		int max=0;
		int [][]A=new int[n][n];
		int [][]B=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				 str=br.readLine();
				 B[i][j]=Integer.parseInt(str);
				 A[i][j]=1;
			}
		}
		
		for(int i=0;i<n;i++)
		{
		  for(int j=0;j<n;j++)
		  {
		   if(A[i][j]==1)
		   {
		    int path=1;
		    int x=i,y=j;
		    int neighbour;
		    while(isNeighbour(x,y,B,n)!=-1)
		    {
		      A[x][y]=path;
		      neighbour=isNeighbour(x,y,B,n);
		      path++;
		    //  A[x][y]=path;
		      if(neighbour==1)
		      {
		       x=x-1;
		       }
		      if(neighbour==2)
		      {
		       y=y+1;
		       }
		       if(neighbour==3)
		      {
		       x=x+1;
		       }
		       if(neighbour==4)
		      {
		       y=y-1;
		       }


		    }
		    if(isNeighbour(x,y,B,n)==-1)
		    	A[x][y]=path;
		    
		    max=Math.max(max,path);
		   }
		  }
		}
		
		System.out.println(max);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				 
				 System.out.print(" "+A[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
