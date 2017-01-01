package DynamicProgramming;

public class num_Decoding {

	
	 
    public int decode(String a,int []A,int i,int n)
	{
	    if(i==n-1&&a.charAt(i)!='0')
	    return 1;
	    if(i==n)
	    {
	       return 1;
	    }
			
	
		if(i>n)
			return 0;
		if(A[i]!=0)
			return A[i];
	
		
		if(a.charAt(i)=='0')
		return -1;
		if(a.charAt(i)=='1'||(a.charAt(i)=='2'&&a.charAt(i+1)<='6'))
		{
		    if(a.charAt(i+1)=='0')
		    {
		        	A[i]=decode(a,A,i+2,n);
		        	return A[i];
		    }
		     
		    if(decode(a,A,i+2,n)==-1)
		    	A[i]=decode(a,A,i+1,n);
		    else if(decode(a,A,i+1,n)==-1)
		        A[i]=decode(a,A,i+2,n);
		    else
			A[i]=decode(a,A,i+2,n)+decode(a,A,i+1,n);
			return A[i];
		}
		else
		{
		    if(decode(a,A,i+1,n)==-1)
		    return -1;
			A[i]=decode(a,A,i+1,n);
			return A[i];
		}
	}
    
	public int numDecodings(String a)   {
	    
			
	
		int n=a.length();
		int []A=new int [n];
		if(this.decode(a, A, 0, n)==-1)
		return 0;
		else
		return this.decode(a, A, 0, n);
		

	
	    
	}
}

	 
	

