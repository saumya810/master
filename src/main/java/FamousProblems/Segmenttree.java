package FamousProblems;
import java.util.Arrays;
import java.util.*;

public class Segmenttree {

	int arr[]={0,0,0,0,0,0,0,0};
	int n=arr.length;
	int S[] = new int [2*n-1];
	 public void create(int smin,int smax,int index,int []arr)
	 {
		
	   if(smin==smax){
		   S[index]=arr[smin];
		   return;
	   }
		   
	   int mid=(smax+smin)/2;
	   this.create(smin, mid, 2*index+1, arr);
	   this.create(mid+1,smax, 2*index+2, arr);
	   S[index]=S[2*index+1]+S[2*index+2];
	   
	 }
	
	 public int query (int smin,int smax,int min,int max,int index)
	 {
		 int mid=(smax+smin)/2;
		 if(smax<min||smin>max)
		 {
			 return 0;
			// return (query(smin,mid,min,max)+query())
		 }
		 
		 if(smin>=min&&smax<=max)
			 return this.S[index];
		 
		
			 
		 return(query(smin,mid,min,max,2*index+1)+query(mid+1,smax,min,max,2*index+2));
	
		 
		 //return 0;
	 }
	 
	 public void update(int index,int value,int cindex,int min,int max)
	 {
		 if(min==max&&min==index){
			 this.S[cindex]=value;
			 return;
		 }
		 
		
		 int mid=(max+min)/2;
		 int num=0;
		 if(index<=mid){
			 update(index,value,2*cindex+1,min,mid);
		 }
		 else{
			update(index,value,2*cindex+2,mid+1,max);
			 }
		 this.S[cindex]=this.S[2*cindex+1]+this.S[2*cindex+2];
		 
	 }
	 
	 
	 public static void main(String []arg)
	 {
		 int arr1[]={1,3,2,4,9,6,7,5};
		 HashMap <Integer,Integer> h=new HashMap<Integer,Integer>();
		 
		 for(int i=0;i<arr1.length;i++)
		 {
			 h.put(arr1[i], i);
		 }
		 Segmenttree s1=new Segmenttree();
		 s1.create(0, s1.n-1, 0, s1.arr);
		 for(int i=0;i<(2*s1.n-1);i++)
		 {
			 System.out.println(s1.S[i]);
		 }
		 System.out.println("sum   "+s1.query(0,s1.n-1,1, 3, 0));
		 s1.update(7, 18, 0, 0, 7);
		 for(int i=0;i<(2*s1.n-1);i++)
		 {
			 System.out.println(s1.S[i]);
		 }
		 Arrays.sort(arr1);
	 }
	 
	 
}
