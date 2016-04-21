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
		if(que.get(index).key<=this.left(que, index).key)
		{
			min=index;
		}
		else
			min=2*index+1;
		if(this.right(que, index).key<que.get(min).key)
			min=2*(index+1);
		if(min!=index)
		{
			Node n=que.get(min);
			que.add(min, que.get(index));
			que.add(index, n);
			this.heapify(que, min);
		}
		
	}

}
