package FamousProblems;
import java.util.Arrays;
import java.util.*;
import java.io.*;
public class test3 {
	//bank bazaar again first rpb different approach
	 public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running
	*/
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int j = 0; j < N; j++) {
	           
	           int num=Integer.parseInt(br.readLine());
	           long []c=new long[num];
	           line=br.readLine();
	           String [] str=line.split(" ");
	           long min=Long.MAX_VALUE;
	           long max=Long.MIN_VALUE;
	           long mincount=0L;
	           long maxcount=0L;
	           HashMap <Long,Long> h=new HashMap <Long,Long>();
	           for(int i=0;i<num;i++)
	           {
	           	c[i]=Long.parseLong(str[i]);
	           	if(c[i]<min)
	           	{
	           		min=c[i];
	           		mincount=1L;
	           	}
	           	else if(c[i]==min)
	           		mincount++;
	           	else if(c[i]>max)
	           	{
	           		max=c[i];
	           		maxcount=1;
	           	}
	           	else if(c[i]==max)
	           		maxcount++;
	           
	            
	           }
	           	
	           
	           
	           System.out.println((h.get(min)*h.get(max)));
	           
	           
	           
	           
	        }
	       

	        
	    }

}
