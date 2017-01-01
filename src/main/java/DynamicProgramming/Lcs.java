package DynamicProgramming;
import java.io.*;
import java.util.*;

public class Lcs {

	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter s1");
		BufferedReader br= new BufferedReader(new InputStreamReader (System.in));
		String str1=br.readLine();
		System.out.println("Enter s2");
		String str2=br.readLine();
		int [][]A=new int [str1.length()+1][str2.length()+1];
		//Arrays.fill(A,0);
		
		for(int i=0;i<str1.length();i++)
		{
			for(int j=0;j<str2.length();j++)
			{
			    if(str1.charAt(i)==str2.charAt(j))
			    {
			    	A[i+1][j+1]=1+A[i][j];
			    }
			    else
			    {
			    	A[i+1][j+1]= Math.max(A[i+1][j], A[i][j+1]);
			    }
			}
		}
		
		System.out.println(A[str1.length()][str2.length()]);

	}

}
