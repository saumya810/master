package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class microsoft_lis {
	
	
	public int create_segment_tree(int min,int max,int index,int[] A,int [] S)
	{
		if(min==max)
		{
			S[index]=A[min];
			return A[min];
		}
		int mid=(min+max)/2;
		S[index]=Math.max(create_segment_tree(min,mid,(2*index)+1,A,S),create_segment_tree(mid+1,max,(2*index)+2,A,S));
		return S[index];
			
		}
	
	
	
	public int query(int min,int max,int qmin,int qmax,int index,int[] S)
	{
		if(min>=qmin&&max<=qmax)
			return(S[index]);
		else if(min>qmax||max<qmin)
			return 0;
		int mid=(min+max)/2;
		return(Math.max(query(min,mid,qmin,qmax,(2*index)+1,S),query(mid+1,max,qmin,qmax,(2*index)+2,S)));
	}
	
	public int update(int min,int max,int index,int update_index,int value,int []S)
	{
		if(min==max&&min==update_index)
		{
			S[index]=value;
			return S[index];
		}
		
		int mid=(min+max)/2;
		if(update_index<=mid)
		{
			S[index]=Math.max(update(min,mid,(2*index)+1,update_index,value,S),S[(2*index)+2]);
		}
		else
		{
			S[index]=Math.max(update(mid+1,max,(2*index)+2,update_index,value,S),S[(2*index)+1]);
		}
		return S[index];
	}
	
	
	public static void main(String []arg)throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String line = br.readLine();
	     String []str=line.split(" ");
	     int []A=new int[str.length];
	     int []B=new int[str.length];
	     int []S=new int[2*str.length-1];
	     HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
	     
	     for(int i=0;i<str.length;i++)
	     {
	    	 A[i]=Integer.parseInt(str[i]);
	    	 B[i]=A[i];
	    	 h.put(A[i],i);
	     }
	     Arrays.fill(S,0);
	     Arrays.sort(B);
	     microsoft_lis obj1=new microsoft_lis();
	     int max1=Integer.MIN_VALUE;
	     for(int i=0;i<str.length;i++)
	     {
	    	 int temp=obj1.query(0,str.length-1,0,h.get(B[i]),0,S);
	    	 max1=Math.max(max1,temp+1);
	    	 obj1.update(0,str.length-1,0,h.get(B[i]),temp+1,S);
	     }
	     System.out.println(" Num ---->"+max1);
	    //obj1.create_segment_tree(0, str.length,0, A, S)
	}

}
