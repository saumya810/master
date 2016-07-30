package FamousProblems;
import java.util.Arrays;
import java.util.*;
///bank bazaar second question
public class test2 {

	
	 public void create(int smin,int smax,int index,int []arr,int[]S)
	 {
		
	   if(smin==smax){
		   S[index]=arr[smin];
		   return;
	   }
		   
	   int mid=(smax+smin)/2; 
	   this.create(smin, mid, 2*index+1, arr,S);
	   this.create(mid+1,smax, 2*index+2, arr,S);
	   S[index]=Math.min(S[2*index+1],S[2*index+2]);
	   
	 }
	 
	 
	 public int query (int smin,int smax,int min,int max,int index,int []S)
	 {
		 int mid=(smax+smin)/2;
		 if(smax<min||smin>max)
		 {
			 return Integer.MAX_VALUE;
			// return (query(smin,mid,min,max)+query())
		 }
		 
		 if(smin>=min&&smax<=max)
			 return S[index];
		 
		
			 
		 return(Math.min(query(smin,mid,min,max,2*index+1,S),query(mid+1,smax,min,max,2*index+2,S)));
		 
	 }
	 
	 
	public int binarysearch(int num,int []A,int min,int max)
	{
		int num1;
		if(min>max)
			return -1;
		if(min==max&&A[min]<num)
			return -1;
		int mid=(min+max)/2;
		if(A[mid]>=num&&A[mid-1]<num)
			return mid;
		else if(A[mid]<num)
		  num1=binarysearch(num,A,mid+1,max);
		else
			num1 =binarysearch(num,A,min,mid);
		return num1;
			
	}
	
	
	
	public void func(int []r,int []c,int d)
	{
		
		int A[]=new int[r.length];
		int B[]=new int[r.length];
		HashMap <Integer,Integer>h=new HashMap<Integer,Integer>();
		HashMap <Integer,Integer>h1=new HashMap<Integer,Integer>();

		for(int i=0;i<r.length;i++)
		{
			h.put(r[i], i);
			h1.put(c[i], i);
		}
		for(int i=0;i<r.length;i++){
			A[i]=r[i];
		}
		Arrays.sort(A);
		for(int i=0;i<r.length;i++)
		{
			B[i]=c[h.get(A[i])];
		}
		
		int S[] = new int [2*r.length-1];
		this.create(0,r.length-1,0,B,S);
		for(int i=0;i<r.length;i++)
		{
			int radius_index=this.binarysearch(d-r[i],A,0,r.length-1);
			if(radius_index!=-1)
			System.out.println(h1.get(this.query(0,r.length-1, radius_index, r.length-1,0,S))+1);
			else
				System.out.println("0");
			 
		}
		
		
		
	}
	
	
	
	
	public static void main(String str[])
	{
		
		
		
		
		test2 q=new test2();
		int[] A1={1,3,6,2,5};
		int[]A2={5,6,8,3,4};
		q.func(A1, A2, 8);
	}
}
