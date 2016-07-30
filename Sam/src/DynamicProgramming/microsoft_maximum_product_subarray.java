package DynamicProgramming;
import java.io.*;
public class microsoft_maximum_product_subarray {
	
public	int maximumproduct(int []A)
	{
		int Max_product=Integer.MIN_VALUE;
		int current_product=1;
		for(int i=0;i<A.length;i++)
		{
			if(A[i]==0)
			{
				if(Max_product<0)
				{
					Max_product=0;
				}
				current_product=1;
			}
			else
			{
				current_product=current_product*A[i];
				if(current_product>Max_product)
					Max_product=current_product;
			}
		}
		
		return Max_product;
	}
	
	public static void main(String []arg) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String line = br.readLine();
	     String []str=line.split(" ");
	     int []A=new int[str.length];
	     for(int i=0;i<str.length;i++)
	     {
	    	 A[i]=Integer.parseInt(str[i]);
	     }
	     microsoft_maximum_product_subarray obj1=new microsoft_maximum_product_subarray();
	     System.out.println(" Nums  -> "+obj1.maximumproduct(A));
	}

}
