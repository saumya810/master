package graph;

import java.util.* ;
import java.io.* ;

class Node{
	int data;
	Node parent;
	int rank;
	
	public Node(int data)
	{
		this.data=data;
		this.parent=null;
	}
}
 class Edge{

	 Node source;
	 Node destination;
	 int weight;
	 
}
public class Convertor_to_Edge_list {
	ArrayList <Vertex> graph1 = new ArrayList <Vertex> ();
	ArrayList <Node> N=new ArrayList <Node>();
	ArrayList <Edge> E= new ArrayList <Edge>();
	
	
	public void print_edge()
	{
		for(Edge e1 :this.E)
		{
			System.out.println("Source  :   "+e1.source.data+ "  Destination  :  "+e1.destination.data+"  Weight  :  "+e1.weight);
		}
	}
	
	public boolean duplicate_edge(Edge e)
	{
		for(Edge ed:this.E)
		{
			if(e.destination.data==ed.source.data&&e.source.data==ed.destination.data)
			{
				return false;
			}
				
		}
		return true;
	}
	public void CreateNodeAndEdge (Graph_Adjacency_List graph) throws Exception
	{

		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
        Node n1;
		for(Vertex V:graph.graph1)
		{
			n1=new Node(Integer.parseInt(V.name));
			this.N.add(n1);
		}
		
		for(Vertex V:graph.graph1)
		{
			
			Neighbours ne=V.next;
			while(ne!=null)
			{
				Edge e1=new Edge();
				e1.destination=this.N.get(Integer.parseInt((graph.graph1.get(ne.vertex_num)).name));
				e1.source= this.N.get(Integer.parseInt(V.name));
				if(this.duplicate_edge(e1))
				{
					System.out.println("Enter the weight for Edge "+ e1.source.data+"  ------------ "+e1.destination.data);
					String str=br.readLine();
					e1.weight = Integer.parseInt(str);
					this.E.add(e1);
					
				}
				
				ne=ne.next;
				
			}
		}
	}
	
	public static void main(String[] args)throws Exception
	{
		Graph_Adjacency_List g1=new Graph_Adjacency_List();
		g1.inputValues();
		g1.print();
		//BFS_and_DFS bfs =new BFS_and_DFS();
		//bfs.BFS(g1.graph1, g1.graph1.get(0));
		//bfs.DFS(g1.graph1);
		Convertor_to_Edge_list c=new Convertor_to_Edge_list();
		c.CreateNodeAndEdge(g1);
		c.print_edge();
		
		
	}

}
