package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class alphacodebottomup {

	 static long  func(String str,long []A)
		{
		 for(int i=str.length()-2;i>=0;i--)
		 {
			 if(str.charAt(i)=='0')
				{
					A[i]=0;
					continue;
				}
			 long num2=0;
			 long num1=0;
			 if(str.charAt(i)>'2')
				{
					num2=0;
				}
				else if(str.charAt(i)<'2'||((str.charAt(i)=='2')&&(str.charAt(i+1)<'7')))
						{
					       num2=A[i+2];
						}
			 num1=A[i+1];
			 A[i]=num1+num2;
		 }
			
			return A[0];
			
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
		    		
		    		
		        	
		        	System.out.println(func(str,A));
		        }
		        
		 }
}
