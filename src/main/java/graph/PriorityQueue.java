package graph;
import java.util.*;

public class PriorityQueue {

	ArrayList <Node> Q= new ArrayList <Node> ();
	
	public Node left(ArrayList<Node> que, int index)
	{
		if(que.size() > (2*index+1))
		{
			return que.get(2*index+1);
		}
		else 
			return null;
	}
	
	
	public Node right(ArrayList<Node> que, int index)
	{
		if(que.size()>(2*(index+1)))
			return que.get(2*(index+1));
		else
			return null;
	}
	
	public Node parent(ArrayList<Node> que, int index)
	{
		if(index != 0)
			return que.get((index-1)/2);
		else
			return null;
	}
	
	public void heapify( ArrayList<Node> que, int index)
	{
		int min;
	
			if(this.left(que, index)== null || que.get(index).key<=this.left(que, index).key)
		{
			min=index;
		}
		else
			min=2*index+1;
		
		if(this.right(que, index)!=null && this.right(que, index).key<que.get(min).key)
			min=2*(index+1);
		if(min!=index)
		{
			Node n=que.get(min);
			que.set(min, que.get(index));
			que.set(index, n);
			this.heapify(que, min);
		}
		
	}
	
	
	public Node getMin(ArrayList<Node> que)
	{
		Node n = que.get(0);
		que.set(0, que.get(que.size()-1));
		que.remove(que.size()-1);
		this.heapify(que,0);
		return n;
	}
	
	public void insert(ArrayList<Node> que , Node n)
	{
		int size =que.size();
		que.add(n);
		while(this.parent(que, size)!=null)
		{
			if(que.get(size).key<this.parent(que, size).key)
			{
				Node n1=que.get(size);
				que.set(size, this.parent(que, size));
				que.set((size-1)/2,n1);
				size=(size-1)/2;
				
			}
			else
				break;
		}
		
	}

	public Node get_node_by_data(ArrayList<Node> que, int data)
	{
		for(Node n : que)
		{
			if(n.data==data)
				return n;
		}
		return null;
		
	}
	
	public Node remove(ArrayList<Node> que)
	{
		int size= que.size();
		Node n1=que.get(0);
		que.set(0, que.get(size-1));
		//System.out.println("before remove size "+que.size());
		que.remove(size-1);
		//System.out.println("After remove size "+que.size());
		this.heapify(que, 0);
		return n1;
	}
	
	public void decrese_key(ArrayList<Node> que, Node n)
	{
		int i;
		for(i=0;i<que.size();i++)
		{
			if(que.get(i).equals(n))
				break;
		}
		
		while(this.parent(que, i)!=null)
		{
			if(que.get(i).key<this.parent(que, i).key)
			{
				Node n1=que.get(i);
				que.set(i, this.parent(que, i));
				que.set((i-1)/2,n1);
				i=(i-1)/2;
				
			}
			else
				break;
		
	}
	
	
	}	
	
	

}

