package utils;

import com.sun.javafx.geom.Edge;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by svarshne on 3/28/2017.
 */

public class Graph_util
{
    HashSet<Edge> edges = new HashSet<Edge>();

    class Edge
    {
        int source;
        int destination;

        public  Edge(int source,int destination)
        {
            this.source=source;
            this.destination=destination;
        }

        @Override
        public  boolean equals (Object o)
        {
            Edge e1= (Edge) o;
            if((this.source==e1.source&&this.destination==e1.destination)||(this.source==e1.destination&&this.destination==e1.source))
                return true;
            else
                return false;
        }

        @Override
        public  int hashCode()
        {
            return source+destination;
        }
    }

    void createEdgeSet(Graph g)
    {
        for(int vertex_id : g.Adjancy_List.keySet())
        {
            Adjancy_list_header vertex_header = g.Adjancy_List.get(vertex_id);
            Adjancy_Node temp = vertex_header.next;
            while(temp!=null)
            {
                Edge e=new Edge(vertex_id,temp.vertex_id);
                if(!edges.contains(e))
                {
                    edges.add(e);
                }
                temp=temp.next;
            }
        }
    }

    void printedges()
    {
        for(Edge e : edges)
        {
            System.out.println(e.source+" "+e.destination);
        }
    }

    boolean directedGraphcycleDFS(Graph G)
    {
        Set<Integer> visited  = new HashSet<Integer>();
        Set <Integer> processed = new HashSet<Integer>();
        for(int vertex_id : G.Adjancy_List.keySet())
        {
            if(!visited.contains(vertex_id))
            {
                if(sourceDFS(vertex_id,G,visited,processed))
                    return true;
            }
        }
        return false;
    }

    boolean sourceDFS(int source, Graph G, Set <Integer> visited, Set<Integer> processed)
    {
        boolean cyclePresent=false;
        visited.add(source);
        Adjancy_list_header tempheader = G.Adjancy_List.get(source);
        Adjancy_Node temp = tempheader.next;
        while(temp!=null&&!processed.contains(temp.vertex_id))
        {
            if(visited.contains(temp.vertex_id))
            {
                return true;
            }
            else
            {

                if(sourceDFS(temp.vertex_id,G,visited,processed))
                    return true;
                else
                {
                    processed.add(temp.vertex_id);
                    temp=temp.next;
                }

            }
        }
        return false;
    }

    Boolean undirectedGraphcycleDisjointSet(Graph G)
    {
        disjointSet djs = new disjointSet();
        createEdgeSet(G);
        for(Edge e : edges)
        {
            if(djs.nodeMap.get(e.source)==null)
            {
              djs.createSet(e.source);
            }
            if(djs.nodeMap.get(e.destination)==null)
            {
                djs.createSet(e.destination);
            }

            if(djs.findParentOfSet(djs.nodeMap.get(e.source))==djs.findParentOfSet(djs.nodeMap.get(e.destination)))
                return true;
            else
            {
                djs.UnionOfSets(djs.nodeMap.get(e.source),djs.nodeMap.get(e.destination));
            }

        }
        printedges();
       return false;
    }
}
