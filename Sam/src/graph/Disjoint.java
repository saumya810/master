package graph;

public class Disjoint {
	
	public void makeset(Node N)
	{
		N.rank=0;
		N.parent=N;
	}
	
	public void union(Node n1,Node n2)
	{
		Node N1=this.findset(n1);
		Node N2=this.findset(n2);
		if(N1.data==N2.data)
		{
			return;
		}
		else
		{
			if(N1.rank>=N2.rank)
			{
				N2.parent=N1;
				N1.rank++;
			}
			else
			{
				N1.parent=N2;
				N2.rank++;
			}
		}
	}
	
	public Node findset(Node N)
	{
		if(N.parent!=N){
			N.parent=findset(N.parent);
		}
		return N.parent;
	}

}
