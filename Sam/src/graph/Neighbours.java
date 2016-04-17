package graph;

public class Neighbours {
	int vertex_num;
	Neighbours next;

	public Neighbours(int vertex_num, Neighbours next)
	{
		this.vertex_num=vertex_num;
		this.next=next;
	}
}

class Vertex
{
	String name;
	String color;
	Vertex parent;
	Neighbours next;
	
	Vertex(String name, Neighbours next)
	{
		this.name=name;
		this.next=next;
		this.color="white";
		this.parent=null;
	}
}

