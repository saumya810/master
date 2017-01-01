package FamousProblems;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;









public class taxi {
    public static void main(String args[] ) throws Exception {
        
        // * Read input from stdin and provide input before running
    	 System.out.println("hiiiii");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        long [][] shop=new long[N][2];
        long [] A=new long [N];
        String []str=new String[2];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            str=line.split(" ");
            shop[i][0]=Long.parseLong(str[0]);
            shop[i][1]=Long.parseLong(str[1]);
        }
        A[0]=shop[0][0];
        long max;
        long maximum=-10000;
        for(int i=1;i<N;i++)
        {
        	max=shop[i][0];
        	for(int j=0;j<i;j++)
        	{
        		if(shop[j][1]<=shop[i][1])
        		{
        			max=Math.max(max,shop[i][0]+A[j]);
        		}
        	}
        	A[i]=max;
        	maximum=Math.max(maximum,A[i]);
        }
        
        
      System.out.println(maximum);
        
    }
}
