package graph;

import java.util.* ;
import java.io.* ;


public class Graph_Adjacency_List {

	ArrayList <Vertex> graph1 = new ArrayList <Vertex> ();
	
	public void inputValues () throws Exception
	{
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Enter the number of nodes ");
		String str=br.readLine();
		System.out.println("value is "+str);
		int num=Integer.parseInt(str);
		for(int i=0;i<num;i++)
		{
			String strng= Integer.toString(i);
			Vertex V=new Vertex(strng,null);
			Neighbours n=null;
			V.next=n;
			this.graph1.add(V);
			System.out.println("Enter the neighbour for vertex "+ i +" : [enter 100 to exit for this vertex] ");
			str=br.readLine();
			int ver = Integer.parseInt(str);
			if(ver==100)
			{
				continue;
			}
			else
			{
				V.next=new Neighbours(ver,null);
				n=V.next;
			while(true)
			{
			System.out.println("Enter the neighbour for vertex "+ i +" : [enter 100 to exit for this vertex] ");
			str=br.readLine();
		    ver = Integer.parseInt(str);
			if(ver==100)
				break;
			 Neighbours n1=new Neighbours(ver,null);
			 n.next=n1;
			 n=n.next;
			
			}
			}
			
		}
		
	
	}
	
	public void print()
	{
		for(Vertex V1 : this.graph1)
		{
			System.out.print(" Vertex "+V1.name+" ---->  ");
			Neighbours N1;
			N1=V1.next;
			while(N1!=null)
			{
				System.out.print( "  "+N1.vertex_num+"  ");
				N1=N1.next;
			}
			System.out.println("");
		}
	}
	
	/*public static void main(String[] args)throws Exception
	{
		Graph_Adjacency_List g1=new Graph_Adjacency_List();
		g1.inputValues();
		g1.print();
		BFS_and_DFS bfs =new BFS_and_DFS();
		//bfs.BFS(g1.graph1, g1.graph1.get(0));
		bfs.DFS(g1.graph1);
		
		
	}
	*/
	
}
