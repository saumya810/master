package FamousProblems;
import java.util.*;
import java.io.*;
public class longest_non_decreasing_array {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        line = br.readLine();
	        int []A=new int [N];
	        String []s=line.split(" ");
	        for(int i=0;i<N;i++)
	        {
	        	A[i]=Integer.parseInt(s[i]);
	        }
	        int start=0;
	        int length=1;
	        for(int i=1;i<N;i++)
	        {
	        	if(A[i]<A[i-1])
	        	{
	        		start=i;
	        	}
	        	length=Math.max(i-start+1, length);
	        }
	        System.out.println(length);
	}

}

