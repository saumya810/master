package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class oyo3 {

	static Boolean allsame(String [] a1)
	{
		int j;
		for( j=0;j<a1.length;j++)
		{
			if(a1[j].equals("0"))
				break;
		}
		if(j==a1.length)
			return true;
		for( j=0;j<a1.length;j++)
		{
			if(a1[j].equals("1"))
				break;
		}
		if(j==a1.length)
			return true;
		return false;
	}
	static String check(String [] a1,int lan,int n)
	{
		if(n==1)
			return a1[lan];
		if(lan==0){
			if(a1[lan+1].equals("1"))
			return "1";
			else
				return "0";
		}
		if(lan==n-1)
		{
			if(a1[lan-1].equals("1"))
				return "1";
			else
				return "0";
		}
		
		if(a1[lan-1].equals("1")&&a1[lan+1].equals("1"))
			return "1";
		else
			return "0";
			
	}
	public static void main(String arg [])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for(int j=0;j<N;j++)
        {
        	line = br.readLine();
        	String [] str=new String[2];
        	str=line.split(" ");
        	int n=Integer.parseInt(str[0]);
        	int m=Integer.parseInt(str[1]);
        	line = br.readLine();
        	String str1[]=new String[n];
        	str1=line.split(" ");
        	String str2[]=new String [n];
        	String a1[];
        	String a2[];
        	String temp[];
        	a1=str1;
        	a2=str2;
        	
        	for(int i=0;i<=m;i++)
        	{
        		if(allsame(a1)){
        		a2=a1;
        			break;
        		}
        		for(int lan=0;lan<n;lan++)
        		{
        			a2[lan]=check(a1,lan,n);
        		}
        		temp=a2;
        		a2=a1;
        		a1=temp;
        	}
        	
        	for(int i=0;i<n;i++)
        	{
        		System.out.print(a2[i]+" ");
        		
        	}
        	System.out.println("");
        }
       
	}
}
