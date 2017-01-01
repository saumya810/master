package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class vasya_codeforce {
	
	

	int path(int []Arr,int checkpoints,int start)
	{
		if(checkpoints==0||checkpoints==1)
		{
			return 0;
		}
		if(start <=Arr[0])
		{
			return (Arr[checkpoints-2]-start);
		}
		
		if(start >=Arr[checkpoints-1])
		{
			return (start-Arr[1]);
		}
		int case1,case2,case3,case4;
		//int low=0;
		//int high=checkpoints-1;
		//=getjustlow(Arr,start);
		if(Arr[checkpoints-2]>start)
		 case1=2*(Arr[checkpoints-2]-start)+start-Arr[0];
		else
			case1=start-Arr[0];
		if(Arr[checkpoints-2]>start)
		 case2=2*(start-Arr[0])+Arr[checkpoints-2]-start;
		else
			case2=start-Arr[0];
		if(Arr[1]<start)
		 case3=2*(start-Arr[1])+Arr[checkpoints-1]-start;
		else
			case3=Arr[checkpoints-1]-start;
		if(Arr[1]<start)
		 case4=2*(Arr[checkpoints-1]-start)+start-Arr[1];
		else
			case4=Arr[checkpoints-1]-start;
		
		
		
		
		return Math.min(Math.min(case1,case2), Math.min(case3, case4));
	}
	public static void main(String [] arr) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String line = br.readLine();
	     String []str;
	     str=line.split(" ");
	     int checkpoints=Integer.parseInt(str[0]);
	     int start=Integer.parseInt(str[1]);
	     line = br.readLine();
	     int []A=new int [checkpoints];
	     String str1[];
	     str1=line.split(" ");
	     for(int i=0;i<checkpoints;i++)
	     {
	    	 A[i]=Integer.parseInt(str1[i]);
	     }
	     vasya_codeforce o=new vasya_codeforce();
	     Arrays.sort(A);
	     System.out.print(o.path(A, checkpoints, start));
	     
	     
	}
}
