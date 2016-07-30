package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;
//oyo interview student prob
public class oyo1 {

	static void findpair(int [] arr, int [] num,int n)
	{
		for(int j=0;j<n;j++)
		{
			if(arr[arr[j]]==j)
			{
				num[j]--;
				num[arr[j]]--;
			}
		}
	}
	
	public static void main(String [] arr) throws Exception
	{
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        int[][]output=new int [N][2];
	        for (int i = 0; i < N; i++) {
	        	
	            line = br.readLine();
	            int n=Integer.parseInt(line);
	            int [] students=new int[2*n];
		        int [] num =new int[2*n];
		        line = br.readLine();
		        String [] str1=new String[n];
		        str1=line.split(" ");
		        for(int j=0;j<2*n;j++)
		        {
		        	num[j]=0;
		        }
		        for(int j=0;j<n;j++)
		        {
		        	students[j]=n-1+Integer.parseInt(str1[j]);
		        	//num[students[j]]++;
		        }
		        line = br.readLine();
		        str1=line.split(" ");
		        for(int j=0;j<n;j++)
		        {
		        	students[n-1+j+1]=Integer.parseInt(str1[j])-1;
		        	//num[students[n-1+j+1]]++;
		        }
		        
		        for(int j=0;j<2*n;j++)
		        {
		        	if(students[students[j]]!=j)
		        	num[students[students[j]]]++;
		        	//num[students[n-1+j+1]]++;
		        }
		        //findpair(students,num,n);
		        int count=0;
		        
		        
		        int max=0;
		        for(int j=0;j<2*n;j++)
		        {
		        	System.out.println(j+" "+num[j]);
		        	max=Math.max(max, num[j]);
		        	
		        }
		        
		        output[i][0]=max;
		        for(int j=0;j<n;j++)
		        {
		        	
		        	if(students[students[j]]!=j&&(students[students[students[students[j]]]]==j)){
		        		count++;}
		        }
		        
		        output[i][1]=count;
		        
	        }
	        
	        for(int j=0;j<N;j++)
	        {
	        	System.out.println(output[j][0]+" "+output[j][1]);
	        }
	       
	}
}
