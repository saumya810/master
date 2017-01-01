package DynamicProgramming;
import java.io.*;
import java.util.*;
public class Maximum_Sum_Increasing_Subsequence {

	public int getsum(int []Segmenttree, int start,int end, int []A,int index,int ci)
	{
		if(start==end&&start==index)
			return Segmenttree[ci];
		if(start>end)
			return 0;
		int mid=(end+start)/2;
		if(index<=mid&&index>=start)
		{
			return (getsum(Segmenttree,start,mid,A,index,ci*2+1));
		}
		else if(index<mid && index<start)
			return 0;
		else if(index>mid&&index<=end)
		{
			return(Segmenttree[2*ci+1]+getsum(Segmenttree,mid+1,end,A,index,2*ci+2));
		}
		else if(index>mid&&index<=end)
			return 0;
		return 0;
	}
	
	
	
	public void update(int []Segmenttree, int start,int end, int []A,int index,int val,int ci)
	{
		if(start==end&&start==index)
		{
			Segmenttree[ci]=val;
			return;
		}
		if(start>end)
			return ;
		int mid=(end+start)/2;
		if(index<=mid&&index>=start)
		{
		update(Segmenttree,start,mid,A,index,val,ci*2+1);
		Segmenttree[ci]=Segmenttree[ci*2+1]+Segmenttree[2*ci+2];
		return;
		}
		else if(index<mid && index<start)
			return ;
		else if(index>mid&&index<=end)
		{
		update(Segmenttree,mid+1,end,A,index,val,2*ci+2);
		Segmenttree[ci]=Segmenttree[ci*2+1]+Segmenttree[2*ci+2];
		return;
		}
		else if(index>mid&&index<=end)
			return ;
		
		
	}
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated     method stub
		System.out.println("Enter the array");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String str[]=s.split(" ");
		int A[]=new int[str.length];
		int A1[]=new int[str.length];
		for(int i=0;i<A.length;i++)
		{
			A[i]=Integer.parseInt(str[i]);
			A1[i]=Integer.parseInt(str[i]);
		}
		int n=A.length;
		int []Segmenttree=new int[2*n-1];
		Arrays.sort(A1);
		HashMap <Integer,Integer> h=new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;i++)
		{
			h.put(A1[i],i);
		}
		int sum=0;
		Maximum_Sum_Increasing_Subsequence ob1=new Maximum_Sum_Increasing_Subsequence();
		for(int i=0;i<n;i++)
		{
			int loc=h.get(A[i]);
			sum=Math.max(sum,ob1.getsum(Segmenttree,0,n-1,A1,loc,0)+A[i]);
			ob1.update(Segmenttree,0,n-1, A1,loc,A[i],0);
		}
		System.out.println(sum);

	}

}
