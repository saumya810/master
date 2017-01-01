package spoj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Dynamicapple {
	public static void main (String [] arg) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for(int t=0;t<N;t++)
        {
        	line = br.readLine();
        	String str[]=new String [2];
        	str=line.split(" ");
        	int person =Integer.parseInt(str[0]);
        	int weight=Integer.parseInt(str[1]);
        	int[] A=new int [weight];
        	line = br.readLine();
        	String str1[]=new String [weight];
        	str1=line.split(" ");
        	for(int h=0;h<weight;h++)
        	{
        		A[h]=Integer.parseInt(str1[h]);
        	}
        	int [][]A1=new int [person][weight];

        	for(int h=0;h<person;h++)
        	{
        		for(int w=0;w<weight;w++)
        		{
        			A1[h][w]=-1;
        			
        		}
        		
        		}
        	for(int h=0;h<weight;h++)
        	{
        		A1[0][h]=A[h];
        	//	System.out.println(A1[0][h]);
        	}
        	
        	
        	
        	for(int h=1;h<person;h++)
        	{
        		for(int w=h;w<weight;w++)
        		{
        			int Min=Integer.MAX_VALUE;
        			for(int temp=0;temp<w;temp++)
        			{
        				if(A[temp]==-1||A1[h-1][w-temp-1]==-1||A1[h-1][w-temp-1]==Integer.MAX_VALUE)
        					continue;
        				Min=Math.min(Min,A[temp]+A1[h-1][w-temp-1]);
        			}
        			if(Min>=Integer.MAX_VALUE-10)
        				A1[h][w]=-1;
        			else	
        			A1[h][w]=Min;
        			
        		}
        	}
        	
        	
        	for(int h=0;h<person;h++)
        	{
        		for(int w=0;w<weight;w++)
        		{
       
        					//System.out.print(A1[h][w]);
        		}
        		
        		//System.out.println("");
        		}
        int Min=Integer.MAX_VALUE;
        	for(int n=0;n<person;n++)
        	{
        		if(A1[n][weight-1]==-1)
        			continue;
        		Min=Math.min(Min,A1[n][weight-1]);
        	}
        	if(Min==Integer.MAX_VALUE)
        		Min=-1;
        	System.out.println(Min);
        	
        }
	}

}
