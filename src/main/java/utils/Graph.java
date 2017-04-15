package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by svarshne on 3/28/2017.
 */

class Adjancy_Node
{
    int vertex_id;
    int weight;
    Adjancy_Node next;


    public Adjancy_Node(int vertex_id)
    {
        this.vertex_id=vertex_id;
        this.next=null;
    }

    public Adjancy_Node(int vertex_id,int weight)
    {
        this.vertex_id=vertex_id;
        this.next=null;
        this.weight=weight;
    }

}

class Adjancy_list_header
{
    int vertex_id;
    Adjancy_Node next;

    public Adjancy_list_header(int vertex_id)
    {
        this.next=null;
        this.vertex_id=vertex_id;
    }

}

public class Graph
{
    Map<Integer,Adjancy_list_header> Adjancy_List=new HashMap<Integer,Adjancy_list_header>();

    void addVertex(int id)
    {
        Adjancy_List.putIfAbsent(id,new Adjancy_list_header(id));
    }

    void addEdge(int source,int destination)
    {
        Adjancy_List.putIfAbsent(source,new Adjancy_list_header(source));
        Adjancy_list_header source_header=Adjancy_List.get(source);
        Adjancy_Node temp= source_header.next;
        source_header.next=new Adjancy_Node(destination);
        source_header.next.next=temp;

    }

    void addEdge(int source,int destination,int weight)
    {
        Adjancy_List.putIfAbsent(source,new Adjancy_list_header(source));
        Adjancy_list_header source_header=Adjancy_List.get(source);
        Adjancy_Node temp= source_header.next;
        source_header.next=new Adjancy_Node(destination,weight);
        source_header.next.next=temp;

    }

    void removeEdge(int source, int destination)
    {
        Adjancy_list_header source_header=Adjancy_List.get(source);
        if(source_header==null)
        {
            System.out.println(" Source Vertex not present");
            return ;
        }
        else
        {
            if(source_header.next==null)
            {
                System.out.println(" No edges for source vertex ");
                return;
            }
            else
            {
                Adjancy_Node temp=source_header.next;
                if(temp.vertex_id ==destination)
                    source_header.next=temp.next;
                else
                {
                     while(temp.next!=null)
                     {
                         if(temp.next.vertex_id==destination)
                         {
                             temp.next=temp.next.next;
                             return;
                         }
                         temp=temp.next;
                     }
                }
            }
        }
    }

    void print_Adjancy_List()
    {
        Adjancy_list_header temp_header;
        for(int vertex_id : Adjancy_List.keySet())
        {
            temp_header=Adjancy_List.get(vertex_id);
            System.out.print(" Vertex "+ temp_header.vertex_id);
            Adjancy_Node temp_node=temp_header.next;
            while(temp_node!=null)
            {
                System.out.print(" --> "+temp_node.vertex_id);
                temp_node=temp_node.next;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Graph g1=new Graph();
        g1.addVertex(1);
        g1.addVertex(2);
        g1.addVertex(3);
        g1.addEdge(1,2,1);
        g1.addEdge(2,3,8);
        g1.addEdge(1,4,3);
        g1.addEdge(4,3,4);
        //g1.addEdge(4,3);
        //g1.addEdge(4,1);
        g1.print_Adjancy_List();
        Graph_traversal gt=new Graph_traversal();
        gt.DFS(g1);
        System.out.println();
        gt.BFS(g1);
        Graph_util gu=new Graph_util();
        System.out.println();
        System.out.println(gu.undirectedGraphcycleDisjointSet(g1));
        System.out.println(gu.directedGraphcycleDFS(g1));
        Shortest_Path sp=new Shortest_Path();
      //  System.out.println(sp.dijakastra(g1,1));
        sp.dijakastra(g1,1);

    }
}
