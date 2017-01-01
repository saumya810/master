package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.*;


public class codeforce_bakery {
	
	class Node
	{
		Node next;
		int num;
	}
	
	public static void main(String []arg) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String [] str;
		str=s.split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		int k=Integer.parseInt(str[2]);
		Node [] arr=new Node[n];
		int [][]g=new int [n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				g[i][j]=0;
			}
		}
		for(int i=0;i<m;i++)
		{
			s=br.readLine();
			str=s.split(" ");
			int num =Integer.parseInt(str[2]);
			if(g[Integer.parseInt(str[0])-1][Integer.parseInt(str[1])-1]!=0)
			{
				num=Math.min(g[Integer.parseInt(str[0])-1][Integer.parseInt(str[1])-1],num);
			}
			
			g[Integer.parseInt(str[0])-1][Integer.parseInt(str[1])-1]=num;
			g[Integer.parseInt(str[1])-1][Integer.parseInt(str[0])-1]=num;
			
			
		}
		int min = Integer.MAX_VALUE;
		if(k!=0){
		s=br.readLine();
		String [] ss;
		ss=s.split(" ");
		Hashtable <Integer,Integer> h=new Hashtable <Integer,Integer>();
		for(int i=0;i<k;i++)
		{
		  h.put(Integer.parseInt(ss[i])-1,0);  
		}
		
	//	if(!h.isEmpty()){
		 Set<Integer> keys = h.keySet();
		 for(int j: keys)
		 {
			 for(int i=0;i<n;i++)
			 {
				 if(g[j][i]!=0&&(h.get(i))==null)
				 {
					 min=Math.min(min, g[j][i]);
				 }
			 }
		 }
		 }
		
		 if(min==Integer.MAX_VALUE)
		 System.out.println("-1");
		 else
			 System.out.println(min);
		 
		
		
		
	}
	

}
