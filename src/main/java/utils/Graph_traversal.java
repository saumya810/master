package utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by svarshne on 3/28/2017.
 */
public class Graph_traversal
{
    void DFS(Graph g)
    {
        Set<Integer> visited = new HashSet<Integer>();
        for(int vertex_id : g.Adjancy_List.keySet())
        {
            if(!visited.contains(vertex_id))
            {
                DFS_source(vertex_id,g,visited);
            }
        }
    }

    void DFS_source(int source, Graph g, Set<Integer> visited)
    {
        System.out.print (" "+source);
        Adjancy_list_header source_header = g.Adjancy_List.get(source);
        Adjancy_Node temp=source_header.next;
        visited.add(source);
        while(temp!=null&&!visited.contains(temp.vertex_id))
        {
            DFS_source(temp.vertex_id,g,visited);
        }

    }

    void BFS(Graph g)
    {
        Set <Integer> visited = new HashSet<Integer>();
        Queue <Integer> vertex_queue = new LinkedList<Integer>();
        for( int vertex : g.Adjancy_List.keySet())
        {
            if(!visited.contains(vertex))
            {
                vertex_queue.add(vertex);
                BFS_source(g,vertex_queue,visited);
            }

        }
    }

    void BFS_source(Graph g, Queue<Integer> queue,Set<Integer> visited)
    {
        while(!queue.isEmpty())
        {
            int vertex_visited=queue.remove();
            System.out.print(" "+vertex_visited);
            visited.add(vertex_visited);
            Adjancy_Node temp = g.Adjancy_List.get(vertex_visited).next;
            while(temp!=null && !visited.contains(temp.vertex_id))
            {
                visited.add(temp.vertex_id);
                queue.add(temp.vertex_id);
                temp=temp.next;
            }
        }
    }
}
