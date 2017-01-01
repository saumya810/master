package matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class matrix_rotation_inplace {

	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     String line = br.readLine();
	     int N = Integer.parseInt(line);
	     int [][] A=new int[N][N];
	     for(int i=0;i<N;i++)
	     {
	    	 line = br.readLine();
	    	 String str[];
	    	 str=line.split(" ");
	    	 for(int j=0;j<N;j++)
	    	 {
	    		 A[i][j]=Integer.parseInt(str[j]);
	    	 }
	     }
	     
	     for(int i=0;i<=(N-1)/2;i++)
	    
	     {
	    	 //top
	    	 for(int j=i;j<N-1-i;j++)
	    	  {
	    		 int temp=A[j][N-1-i];
	    		 A[j][N-1-i]=A[i][j];
	    		 int temp2=A[N-i-1][N-1-j];
	    		 A[N-i-1][N-1-j]=temp;
	    		 temp=A[N-j-1][i];
	    		 A[N-j-1][i]=temp2;
	    		 A[i][j]=temp;
	    		 
	    	 }
	     }
	     for(int ii=0;ii<N;ii++)
	     {
	    	 for(int j=0;j<N;j++)
	    	 {
	    		 System.out.print (" "+A[ii][j]);
	    	 }
	    	 System.out.println("");
	     }
	    	 
	     
	     

	}

}
