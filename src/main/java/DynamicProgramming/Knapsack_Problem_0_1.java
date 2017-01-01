package DynamicProgramming;
import java.io.*;
import java.util.*;
public class Knapsack_Problem_0_1 {
	
	public void Knapsack(int []weight,int []value,int w,int n){
		int [][]A=new int[n][w+1];
		for(int i=0;i<n;i++)
		{
			for(int j=1;j<=w;j++)
			{
				if(weight[i]==j)
				{
					if(i==0)
					
						A[i][j]=value[i];
					else
						A[i][j]=Math.max(value[i], A[i-1][j]);
				}
				else if(i!=0)	
				{
					if(j<weight[i])
					{
						
							A[i][j]=A[i-1][j];
						
					}
					
					else
						A[i][j]=Math.max(value[i]+A[i-1][j-weight[i]], A[i-1][j]);
				}
					
			}
		}
		System.out.println(A[n-1][w]);
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of items adn total weight allowed:");
		String str=br.readLine();
		String s[]=str.split(" ");
		int n=Integer.parseInt(s[0]);
		int w=Integer.parseInt(s[1]);
		System.out.println("Enter the values of items");
		String val=br.readLine();
		String s1[]=val.split(" ");
		int [] value=new int [n];
		int weight[]=new int [n];
		System.out.println("Enter the weight of items");
		String weigh=br.readLine();
		String s2[]=weigh.split(" ");
		for(int i=0;i<n;i++)
		{
			value[i]= Integer.parseInt(s1[i]);
			weight[i]=Integer.parseInt(s2[i]);
		}
		Knapsack_Problem_0_1 ob1=new Knapsack_Problem_0_1();
		ob1.Knapsack(weight, value, w, n);
		
	}

}
