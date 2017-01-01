/**
 * 
 */
/**
 * @author svarshne
 *
 */
package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class paranthesischeck {
	int p=0,counter=0;
	
	private int paranthesis_check(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(')
			{
				p=p+1;
				
			}
			
			if(str.charAt(i)==')')
			{
				if(this.p==0)
					continue;
				this.p=this.p-1;
				this.counter=this.counter+1;
			}
		}
		
		return counter;
	}
	//main removed 
	
	public static void main(String arg[])throws Exception
	{
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Enter the String ");
		String str=br.readLine();
		paranthesischeck ob1=new paranthesischeck();
		System.out.println("Count =" +ob1.paranthesis_check(str));
		
		
	}
}