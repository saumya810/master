package DynamicProgramming;
import java.io.*;
import java.util.*;

public class Optimal_strategy_game_geeks4geeks {
int sum=0;
	public int dynamic_strategy(int []A,int [][][]B,int i,int j,Boolean player)
	{
		
		if(i<0||j>=A.length)
			return 0;
		if(i>j)
			return 0;
		if(player ==true && B[i][j][0]!=0)
		{
		 return B[i][j][0];	
		}
		else if (player == false && B[i][j][1]!=0)
			return B[i][j][1];
		if(i==j)
		{
			if(player==true)
		     	{
				B[i][j][0]=A[i];
				return B[i][j][0];
		     	}
			else {
				B[i][j][1]=A[i];
				return B[i][j][1];
			}
				
			
			
		}
		
		if(player==true){
			dynamic_strategy(A,B,i+1,j,(!player));
			dynamic_strategy(A,B,i,j-1,(!player));
		 if((A[i]+B[i+1][j][0])>(A[j]+B[i][j-1][0]))
		{
			B[i][j][0]= A[i]+B[i+1][j][0];
			B[i][j][1]=B[i+1][j][1];
			
		}
		else
		{
			B[i][j][0]=A[j]+B[i][j-1][0];
		    B[i][j][1]= B[i][j-1][1];
		}
		}
		else
			
		{
			dynamic_strategy(A,B,i+1,j,(!player));
			dynamic_strategy(A,B,i,j-1,(!player));
			
			 if((A[i]+B[i+1][j][1])>(A[j]+B[i][j-1][1]))
				{
					B[i][j][1]=A[i]+B[i+1][j][1];
					B[i][j][0]=B[i+1][j][0];
				}
				else
				{
					B[i][j][1]=A[j]+B[i][j-1][1];
					B[i][j][0]=B[i][j-1][0];
					
				}
		}
		
	
		if(player==true)
		return B[i][j][0];
		else
			return B[i][j][1];
		
	}
	int Max_value(int i ,int j,int []B, int [][]A)
	{
		if(i==j)
		{
			A[i][j]= B[i];
			return  B[i];
		}
		if(i>j)
			return 0;
		if(i<0||j>=A.length)
			return 0;
		if(i>=A.length||j<0)
			return 0;

		if(A[i][j]!=0)
			return A[i][j];
		int max1= Math.max(B[i]+Max_value(i+1,j-1,B,A),B[i]+Max_value(i+2,j,B,A));
		int max2= Math.max(B[j]+Max_value(i,j-2,B,A),B[j]+Max_value(i+1,j-1,B,A));
		A[i][j] = Math.max(max1,max2);
		System.out.println(" A B " + i + " "+j + " "+ A[i][j]);
		return A[i][j];
	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the array");
		String str= br.readLine();
		String s[]=str.split(" ");
		int []A=new int[s.length];
		for(int i=0;i<A.length;i++)
			A[i]=Integer.parseInt(s[i]);
		Optimal_strategy_game_geeks4geeks ob1=new Optimal_strategy_game_geeks4geeks();
		int [][][]B=new int [A.length][A.length][2];
		int [][]B1=new int [A.length][A.length];
		System.out.println(ob1.dynamic_strategy(A, B, 0, A.length-1,true));
		System.out.println(ob1.Max_value(0,A.length-1,A,B1));
		//ob1.dynamic_strategy(A, B, 0, A.length-1,true);
		
	}

}
