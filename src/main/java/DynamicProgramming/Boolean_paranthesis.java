package DynamicProgramming;
import java.io.*;
import java.util.*;

//hey ttttest
public class Boolean_paranthesis {
	
	
	
	public void boolean_dynamic(String[] s1,String[] s2,int n,int i1,int j1,int [][][]A){
		
		
		
		if(i1==j1)
		{
			if(s1[i1].charAt(0)=='T')
			{
				A[i1][j1][0]=1;
				return;
			}
			else
			{
				A[i1][j1][1]=1;
				return;
			}
		}
		if(A[i1][j1][0]!=0||A[i1][j1][1]!=0)
			return;
		
		else if(i1>j1)
		return;
		
		else
		{
			for(int j=j1-1;j>=0;j--)
			{
				boolean_dynamic(s1,s2,n,i1,j,A);
				boolean_dynamic(s1,s2,n,j+1,j1,A);
				if(s2[j].charAt(0)=='&')
				{
					A[i1][j1][0]+=A[i1][j][0]*A[j+1][j1][0];
					A[i1][j1][1]+=((A[i1][j][0]+A[i1][j][1])*(A[j+1][j1][0]+A[j+1][j1][1])-(A[i1][j][0]*A[j+1][j1][0]));
					
				}
				else if(s2[j].charAt(0)=='|')
				{
					A[i1][j1][0]+=((A[i1][j][0]+A[i1][j][1])*(A[j+1][j1][0]+A[j+1][j1][1])-(A[i1][j][1]*A[j+1][j1][1]));
					A[i1][j1][1]+=A[i1][j][1]*A[j+1][j1][1];
					
				}
				else if(s2[j].charAt(0)=='^')
				{
					A[i1][j1][0]+=(A[i1][j][1]*A[j+1][j1][0]+A[i1][j][0]*A[j+1][j1][1]);
					A[i1][j1][1]+=((A[i1][j][0]+A[i1][j][1])*(A[j+1][j1][0]+A[j+1][j1][1])-(A[i1][j][1]*A[j+1][j1][0]+A[i1][j][0]*A[j+1][j1][1]));
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the T/F String");
		String str=br.readLine();
		String s1[]=str.split(" ");
		System.out.println("Enter the & | ^ String");
		str=br.readLine();
		String s2[]=str.split(" ");
		Boolean_paranthesis ob1=new Boolean_paranthesis();
		int n=s1.length;
		int [][][]A=new int [n][n][2];
		ob1.boolean_dynamic(s1, s2, n ,0,n-1,A);
		System.out.println(A[0][n-1][0]);
	}

}
