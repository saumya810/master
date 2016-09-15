package FamousProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;


class Node {
	int data;
	Node left;
	Node right;
	public Node(int n)
	{
		this.data=n;
		this.left=null;
		this.right=null;
	}
}
public class printNodesWithKdistance {

	Node root=null;
	int k=0;
	
	
	
	Node search(int data)
	{
		Node n;
		for(n=this.root;n!=null&&n.data!=data;)
		{
			if(n.data>=data)
				n=n.left;
			else
				n=n.right;
		}
		if(n.data==data)
		  return n;
		else
			return null;
	}
	
	void Insert_other(Node N,int data)
	{
		if(data<=N.data)
		{
			if(N.left==null)
			{
				Node n=new Node(data);
				N.left=n;
			}
			else
			{
				Insert_other(N.left,data);
			}
		}
		else
		{
			if(N.right==null)
			{
				Node n=new Node(data);
				N.right=n;
			}
			else
			{
				Insert_other(N.right,data);
			}
		}
	}
	void Insert(Node root,int data)
	{
		if(root==null)
		{
			Node n=new Node(data);
			this.root=n;
			return;
			}
		else
		{
			this.Insert_other(root,data);
		}
	}
	
	
	void print(Node N)
	{
		if(N==null)
			return;
		else
		{
			System.out.println(" "+N.data);
			this.print(N.left);
			this.print(N.right);
		}
	}
	
	int printOtherdanChildrenWithDistance(Node N,int q,int data)
	{
		if(N==null)
			return -1;
		
		
		if(N.data==data)
			return 1;
		int x= printOtherdanChildrenWithDistance(N.left,q,data);
		if(x==0)
			return 0;
		if(x==k)
		{
			System.out.println("   Other Node  found "+ N.data);
			return 0;
		}
		if(x!=-1 && x!=0)
		{
			this.printChildrenWithDistance(N.right, x+1);
			return x+1;
			
		}
		
		
		int y= printOtherdanChildrenWithDistance(N.right,q,data);
		if(y==-1)
			return -1;
		if(y==0)
			return 0;
		if(y==k)
		{
			System.out.println("   Other Node  found "+ N.data);
			return 0;
		}
		this.printChildrenWithDistance(N.left, y+1);
		return y+1;
		
	}
	
	void printChildrenWithDistance(Node N,int q){
		if(N==null)
			return;
		if(q>this.k)
			return;
		if(q==this.k)
		{
			System.out.println("   Node found  "+N.data);
			return;
		}
		
		printChildrenWithDistance(N.left,q+1);
		printChildrenWithDistance(N.right,q+1);
		
	}
	
	public static void main(String [] args) throws Exception
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
        //ob1.print(ob1.root);
        
        ob1.printChildrenWithDistance(ob1.search(node1), 0);
        ob1.printOtherdanChildrenWithDistance(ob1.root,-1,node1);
        
        
        
	}
}
