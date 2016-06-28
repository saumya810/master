package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
	
	
	  void steps(int i,int j,int n,int [][]path)
	 {
		 //System.out.println("M in "+i+"  "+j);
		 int top=Integer.MAX_VALUE-5,left=Integer.MAX_VALUE-5,right=Integer.MAX_VALUE-5,bottom=Integer.MAX_VALUE-5;
		 if(path[i][j]==-1)
			 return;
		 if(path[i][j]!=Integer.MAX_VALUE-5)
			 return;
		 path[i][j]=0;
		 if(j>0&&path[i][j-1]!=0)
		 {
			 
			 steps(i,j-1,n,path);
			 top=path[i][j-1];
		 }
		 if(j<n-1&&path[i][j+1]!=0)
		 {
			steps(i,j+1,n,path);
			bottom=path[i][j+1];
		 }
		 
		 if(i>0&&path[i-1][j]!=0)
		 {
			 steps(i-1,j,n,path);
			 left=path[i-1][j];
		 }
		 
		 if(i<n-1&&path[i+1][j]!=0)
		 {
			 steps(i+1,j,n,path);
			 right=path[i+1][j];
		 }
		 
		 if(top==-1&&bottom==-1&&left==-1&&right==-1){
			 path[i][j]=-1;
			 return;
		 }
		 if(top==-1)
			 top=Integer.MAX_VALUE;
		 if(left==-1)
			 left=Integer.MAX_VALUE;
		 if(right==-1)
			 right=Integer.MAX_VALUE;
		 if(bottom==-1)
			 bottom=Integer.MAX_VALUE;
		 
		 
		int k=Math.min(top, bottom);
		int l=Math.min(left,right);
	    int q=Math.min(k,l);
	    //System.out.println("setting "+i+"  "+j+"     =   "+q);
	    if(q==Integer.MAX_VALUE-5)
	       path[i][j]=Integer.MAX_VALUE-5;
	    else
	    	path[i][j]=q+1;
		 
	 }
	 public static void main(String args[] ) throws Exception {
	        
		 //System.out.println("hiii");
	        // * Read input from stdin and provide input before running
	    	TestClass a=new TestClass();
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	       // String [] str1=new String[2];
	       // str1=line.split(" ");
	        //String str;
	        int N = Integer.parseInt(line);
	        int [][] Path=new int[N][N];
	        String [] Board=new String[N];
	        for(int i=0;i<N;i++)
	        {
	        	
	        		Board[i]=br.readLine();
	        	
	        }
	        
	        
	        for(int i=0;i<N;i++)
	        {
	        	for(int j=0;j<N;j++)
	        	{
	        		
	        			Path[i][j]=Integer.MAX_VALUE-5;
	        	}
	        }
	        
	        for(int i=0;i<N;i++)
	        {
	        	for(int j=0;j<N;j++)
	        	{
	        		if(Board[i].charAt(j)=='V')
	        			Path[i][j]=-1;
	        	}
	        }
	        
	        Path[0][0]=1;
	        
	        a.steps(N-1, N-1, N, Path);
	        for(int i=0;i<N;i++)
	        {
	        	for(int j=0;j<N;j++)
	        	{
	        		//System.out.print(Path[i][j]+"     ");
	        	}
	        	//System.out.println("");
	        }
	        
	        System.out.println(Path[N-1][N-1]-1);
	        
	        
	        
	 }
}
