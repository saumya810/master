package pck1;
import java.io.*;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] arr = new int[7];
		int [] arr = new int[] {6,2,3,8,2,1,6};
		int [] count =new int [] {0,0,0,0,0,0,0,0,0};
		for(int i=0; i<arr.length;i++)
		{
			count[arr[i]]++;
				
		}
		 int sum=0;
		for(int i = 0 ; i<count.length; i++)
		{
			count[i]=sum+count[i];
			sum=count[i];
		}
//		
		int [] out = new int [7];
		for(int i=0;i<arr.length;i++)
		{
			out[count[arr[i]]-1]=arr[i];
			count[arr[i]]--;
			
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(out[i]);
			
		}
		System.out.println("Heya");
		
		
		

	}

}
