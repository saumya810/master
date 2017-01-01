package FamousProblems;
import java.io.*;
import java.util.*;

public class gcd_string {

	
	public String gcd(int a,int b)
	{
		if(a%b==0)
		{
			String s="1";
			for(int i=0;i<a-1;i++)
			{
				s=s+"0";
			}
			//System.out.println(" s in 0 mod "+s);
			return s;
			}
		
		else
		{
		  	String s1=gcd(b,a%b);
		  	String s=s1;
		  	for(int i=2;i<=a/s1.length();i++)
		  	{
		  		s=s+s1;
		  	}
		  	//System.out.println(" s in some mod "+s +"    substring "+s1.substring(0, a-s.length()));
	
		  	int length =s.length();
		  	s=s+s1.substring(0, a-length);
		  	//System.out.println(" s in some mod final "+s);
		  	return s;
		}
	}
	
	
	public int binary_to_dec(String s)
	{ 
		int j=1;
        int sum=0;
		for(int i=s.length()-1;i>=0;i--,j=(j*2)%1000000007)
		{
			if(s.charAt(i)=='1')
			{
			  sum=(sum+j)%1000000007;
			}
		}
		return sum;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		int n=Integer.parseInt(s);
		for(int i=0;i<n;i++)
		{
			s=br.readLine();
			String str[]=s.split(" ");
			gcd_string ob1=new gcd_string();
			//System.out.println(ob1.gcd(Integer.parseInt(str[0]), Integer.parseInt(str[1])));
			System.out.println(ob1.binary_to_dec(ob1.gcd(Integer.parseInt(str[0]), Integer.parseInt(str[1]))));
		}
		
		
		
		
	}

}
