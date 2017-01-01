/**
 * 
 */
/**
 * @author svarshne
 *
 */
package hashprobs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.*;


class pythagoras {
	
	boolean pythagoras_check(int [] a)
	{ 
		Hashtable<Integer,Integer>h = new Hashtable<Integer,Integer>();
		for(int i=0;i<a.length;i++)
		{
			h.put(a[i]*a[i], i);
		}
		for(int i=0;i<a.length-1;i++)
		{  // h.put(a[i]*a[i], i);
			for(int j=0;j<a.length&&j!=i;j++)
			{
				//System.out.println("checking  "+"  j n i===="+((a[i]*a[i])+(a[j]*a[j])));
				if(h.get(((a[i]*a[i])+(a[j]*a[j])))!=null)
				{
					return true;
				}
				else
				{
					//System.out.println("putting "+a[j]*a[j]);
					//h.put(a[j]*a[j], j);
				}
			}
		}
		return false;
	}
	public static void main(String [] arr)
	{
		int [] a={1,2,3,4,5,6,7,8,9};
		pythagoras obj=new pythagoras();
		
		System.out.println(obj.pythagoras_check(a));
		
	}
}