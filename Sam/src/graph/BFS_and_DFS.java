package graph;

import java.util.*;

public class BFS_and_DFS {
	
	public void BFS(ArrayList <Vertex> adj,Vertex s)
	{
		Queue <Vertex> q=new LinkedList <Vertex> ();
		q.add(s);
		s.color="grey";
		while(!q.isEmpty())
		{
			Vertex V1=q.remove();
			V1.color="black";
			Neighbours N1=V1.next;
			System.out.print("Graph Node "+V1.name+"   Parent ");
			if(V1.parent!=null)
			System.out.println(V1.parent.name);
			else
				System.out.println("null");
			while(N1!=null)
			{
				if(adj.get(N1.vertex_num).color.equalsIgnoreCase("white"))
				{
					q.add(adj.get(N1.vertex_num));
					adj.get(N1.vertex_num).color="grey";
					adj.get(N1.vertex_num).parent=V1;
				}
				N1=N1.next;
			}
			
		}
	}
	
	public void DFS(ArrayList <Vertex> adj)
	{
		for(Vertex V : adj)
		{
			if(V.color=="white")
				this.DFS_coloring(V,adj);
		}
	}
	
	public void DFS_coloring(Vertex V,ArrayList <Vertex> adj)
	{
		V.color="grey";
		Neighbours N1=V.next;
		while(N1!=null)
		{
			if(adj.get(N1.vertex_num).color.equalsIgnoreCase("white"))
			{
				adj.get(N1.vertex_num).parent=V;
				DFS_coloring(adj.get(N1.vertex_num),adj);
			}
			N1=N1.next;
		}
		V.color="black";
		System.out.print("Graph Node "+V.name+"   Parent ");
		if(V.parent!=null)
		System.out.println(V.parent.name);
		else
			System.out.println("null");
		
	}

}
