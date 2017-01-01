package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class alphacode {

	static void  func(String str,int i,long []A)
	{
		
		if(i>=str.length()-1||i==str.length())
			return;
		if(str.charAt(i)=='0')
		{
			A[i]=0;
			return;
		}
		
		long num2=0;
		long num1=0;
			
		 if(str.charAt(i)>'2')
		{
			num2=0;
		}
		else if(str.charAt(i)<'2'||((str.charAt(i)=='2')&&(str.charAt(i+1)<'7')))
				{
			       if(A[i+2]==-1)
			       func(str,i+2,A);
			       num2=A[i+2];
				}
		 if(A[i+1]==-1)
		       func(str,i+1,A);
		 num1=A[i+1];
		A[i] = num1+num2;
		
	}
	
	 public static void main(String [] arg) throws Exception
	 {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      //  String line = br.readLine();
	        //int N = Integer.parseInt(line);
		 
	        String str=null;
	        while(true)
	        {
	        	str=br.readLine();
	        	//System.out.println(str);
	        	if(str.equals("0")){
	        		
	        		break;
	        	}
	        	
	        	long [] A=new long [str.length()+1];
	        	for(int i=0;i<str.length();i++)
	        	{
	        		A[i]=-1;
	        	}
	        	
	        	
	        	if(str.charAt(str.length()-1)!='0')
	    		{
	    			A[str.length()-1]=1;
	    			
	    		}
	        	else
	        		A[str.length()-1]=0;
	        		
	        	A[str.length()]=1;
	    		
	    		
	        	func(str,0,A);
	        	System.out.println(A[0]);
	        }
	        
	 }
}
