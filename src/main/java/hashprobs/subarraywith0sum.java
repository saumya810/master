package hashprobs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.*;

public class subarraywith0sum {

	
	int maxsubarray(int [] a)
	{
		Hashtable <Integer, Integer> h=new Hashtable<Integer,Integer>();
		int sum=0;
		int max=0;
		int k;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
			if(h.get(sum)!=null)
			{
				//System.out.println(" sum came before "+sum);
				
				k=h.get(sum);
				//System.out.println(" k "+k);
				if(max<=((i-k)))
					{
					max=i-k;
					//System.out.println(" sum came before "+max+"  "+i+k);
						}
			}
			else
			{
				h.put(sum,i);
			}
		}
		return max;
	}
	public static void main(String [] arr)
	{
		int a[]={4,6,3,7,-3,4,-4,-4,-3,6,1,-7,8,6,3};
		subarraywith0sum obj =new subarraywith0sum();
		
		System.out.println(obj.maxsubarray(a));
		
	}
}
