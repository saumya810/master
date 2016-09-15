package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class microsoft_k_distance_tree_new {

	
	//-1 ---- not found yet
	//-2 ----- more than k distance dont calculate
	public int print(Node N,int k, int data)
	{
	int num1=-3;
	int num2=-3;
	  if(N.data==data)
	  {
	    child(N,k);
	    return k-1;
	  }

	 if(N.left!=null)
	  num1=print(N.left,k,data);
	  if(num1 ==0)
	    {
	      System.out.println(N.data);
	      return -2;
	    }
	  else if(num1 ==-2)
	     return -2;
	   
	  else if(num1 == -1)
	  {
	    if(N.right!=null)
	    {
	      num2=print(N.right,k,data);
	      if(num2==-1)
	       return -1;

	      else if(num2==0)
	        {
	         System.out.println(N.data);
	         return -2;
	        }
	      else if(num2 ==-2)
	       return -2;

	       else
	       {
	          if(num2 ==1)
	     {
	       System.out.println(N.left.data);
	       return 0;
	     }

	     else if(num2>1)
	     {
	       child(N.left,num1-1);
	       return num2-1;
	     }
	       }


	     
	    }

	    
	  }
	   
	   else
	   {
	     if(num1 ==1)
	     {
	       System.out.println(N.right.data);
	       return 0;
	     }

	     else if(num1>1)
	     {
	       child(N.right,num1-1);
	       return num1-1;
	     }
	   }

     return -2;
	}

	public void child(Node N,int k)
	{
	  if(k==0)
	   System.out.println(N.data);
	   else
	   {

	     if(N.left!=null)
	      child(N.left,k-1);
	      if(N.right!=null)
	       child(N.right,k-1);


	   }
	}
	
	public static void main(String s[])throws Exception
	{
		printNodesWithKdistance ob1=new printNodesWithKdistance();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[]=new String[3];
        str=line.split(" ");
        int N = Integer.parseInt(str[0]);
        ob1.k=Integer.parseInt(str[1]);
        int node1=Integer.parseInt(str[2]);
        line = br.readLine();
        String str1[]=new String[N];
        str1=line.split(" ");
        for(int i=0;i<N;i++)
        {
        	ob1.Insert(ob1.root,Integer.parseInt(str1[i]));
        }
        
        microsoft_k_distance_tree_new obj=new microsoft_k_distance_tree_new();
        obj.print(ob1.root,  ob1.k, node1);
	}
}
