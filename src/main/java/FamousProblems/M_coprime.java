package FamousProblems;
import java.util.*;
public class M_coprime {
   public ArrayList <Integer> getAllPrime(int i)
   {
	   return new ArrayList<Integer>() ;
   }
   Boolean isprime(int i)
   {
	   for(int j=2;j<=i/2;j++)
	   {
		   if(i%j==0)
			   return false;
	   }
	   return true;
   }
	public static void main()
	{
		M_coprime ob=new M_coprime();
		int [] A ={3,4,5,6,7,8};
		int max[]=new int [249];
		int []min=new int [249];
		for(int i=2;i<251;i++)
		{
			if(ob.isprime(i))
			{
				for(int j=2;j<251;j++)
				{
					if(j%i==0)
					{
						min[i]=j;
						break;
					}
				}
				
				for(int j=250;j>=2;j--)
				{
					if(j%i==0)
					{
						max[i]=j;
						break;
					}
				}
			}
		}
		
		int m1,m2;
		
		for(int i=0;i<A.length;i++)
		{
			Boolean flag=true;
			ArrayList <Integer> A1=ob.getAllPrime(i);
			for(int j=250;j>=0;j++)
			{
				
				for(int k=0;k<A1.size();k++)
				{
				   if(max[A1.get(k)]==j)
				   {  
					   flag=false;
					   break;
				   }
					   
				   
				  
				}
				if(flag==false)
					   continue;
				else
				{
					m1=j;
					break;
				}
					
				
			}
			flag =true;
			for(int j=2;j<=250;j++)
			{
				for(int k=0;k<A1.size();k++)
				{
				   if(min[A1.get(k)]==j)
				   {  
					   flag=false;
					   break;
				   }
					   
				   
				  
				}
				if(flag==false)
					   continue;
				else
				{
					m2=j;
					break;
				}
			}
			
			
		}
	}
}
