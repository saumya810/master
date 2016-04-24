package graph;

import java.util.*;

public class SpanningTree {
	
	
	public void Kruskal(Convertor_to_Edge_list c)
	{
		Disjoint dj=new Disjoint();
		Collections.sort(c.E,c);
		for(Node N : c.N)
		{
			dj.makeset(N);
		}
		
		for(Edge e:c.E)
		{
			if(dj.findset(e.source)!=dj.findset(e.destination))
			{
				dj.union(e.source, e.destination);
				System.out.println("Edge :     Source "+e.source.data+" ---------   Destination  "+e.destination.data+"  Weight "+e.weight);
			}
		}
	}
	
	
	public void Prim(Convertor_to_Edge_list c,Node b)
	{
		PriorityQueue pq = new PriorityQueue ();
		for(Node n1:c.N)
		{
			n1.parent=null;
			if(!n1.equals(b))
			{
				n1.key=100;
				pq.insert(pq.Q, n1);
			}
		}
		
		Node n=b;
		while(!pq.Q.isEmpty())
		{
			for(Edge e:c.E)
			{
				if(e.source==n)
				{
					Node node1=pq.get_node_by_data(pq.Q, e.destination.data);
					if(node1!=null)
					{
						if(e.weight<e.destination.key)
							{
							//System.out.println(" changing key  source "+e.source.data+ " Destination "+e.destination.data);
							e.destination.key=e.weight;
							e.destination.parent=n;
							pq.decrese_key(pq.Q, node1);
							}
					}
				}
			}
			
			//for(Node n11 : c.N)
			//{
				//System.out.println("Vertex ----- "+n11.data+ " key ----"+n11.key);
			//}
			n=pq.remove(pq.Q);
			//for(Node n111:pq.Q)
				//System.out.println(" Node in Queu" + n111.data);
			System.out.println(" Source  "+  n.parent.data + "--------   Destination "+ n.data+ " key "+n.key);
			
			
		}
		
	}

}
