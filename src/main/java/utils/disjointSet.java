package utils;

import java.util.HashMap;

/**
 * Created by svarshne on 3/28/2017.
 */
public class disjointSet {

    HashMap<Integer,Node> nodeMap = new HashMap<Integer,Node>();

    class Node {
        Node Parent;
        int rank;
        int id;

        public Node(int id)
        {
            this.Parent=this;
            this.rank=1;
            this.id=id;
        }
    }


    Node createSet(int vertex_id)
    {
        Node temp=new Node(vertex_id);
        nodeMap.put(vertex_id,temp);
        return temp;
    }

    Node findParentOfSet(Node N)
    {
        if(N==null)
        {
            System.out.println(" ERROR : Node is NUll creating new ");
            return null;
        }
        while(N.Parent!=N)
        {
            N=N.Parent;
        }
        return N;
    }

    void UnionOfSets(Node n1,Node n2)
    {
        if(n1==null||n2==null)
        {
            System.out.println("ERROR : Null node can'thave union ");
            return;
        }
        Node n1_parent=findParentOfSet(n1);
        Node n2_parent=findParentOfSet(n2);
        if(n1_parent.rank>=n2_parent.rank)
        {
            n2_parent.Parent=n1_parent;
            n1_parent.rank=Math.max(n2_parent.rank+1,n1_parent.rank);
        }
        else
        {
            n1_parent.Parent=n2_parent;
            n2_parent.rank=Math.max(n1_parent.rank+1,n2_parent.rank);
        }
    }


}
