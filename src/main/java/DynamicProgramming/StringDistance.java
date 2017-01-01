package DynamicProgramming;
import java.io.*;
import java.util.*;

public class StringDistance {

	
	public int StringDistancedp(int i,int j,String s1,String s2,int [][]A)
	{
		if(i>=s1.length()||j>=s2.length())
			return 0;
		if(A[i][j]!=-1)
			return A[i][j];
		else
			if(s1.charAt(i)==s2.charAt(j))
				A[i][j]=StringDistancedp(i+1,j+1,s1,s2,A);
			else
			{
				A[i][j]=1 + Math.min(StringDistancedp(i+1,j+1,s1,s2,A),Math.min(StringDistancedp(i,j+1,s1,s2,A), StringDistancedp(i+1,j,s1,s2,A)));
			}
		return A[i][j];
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter String 1");
		String str1=br.readLine();
		System.out.println("Enter String 2");
		String str2=br.readLine();
		int [][]A=new int[str1.length()][str2.length()];
		for(int i=0;i<str1.length();i++)
			Arrays.fill(A[i], -1);
		StringDistance ob1=new StringDistance();
		System.out.println(ob1.StringDistancedp(0, 0, str1, str2, A));
		
		
	}

}
