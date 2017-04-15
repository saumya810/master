package utils;

import java.util.*;

/**
 * Created by svarshne on 3/29/2017.
 */
public class Shortest_Path
{
    class Node
    {
        int id;
        int distance;

        public Node(int id,int distance)
        {
            this.id=id;
            this.distance=distance;
        }
        @Override
        public boolean equals(Object o)
        {
            Node n=(Node)o;
            if(n.id==this.id)
                return true;
            else return false;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(id);
        }


    }

    void dijakastra(Graph G, int source)
    {
        Map<Integer,Integer> distanceMap = new HashMap<Integer,Integer>();
        Map<Integer, Integer> processed = new HashMap<Integer,Integer>();
        //HashSet< Node> processed = new HashSet<Node>();
        //PriorityQueue<Integer> Min_pq= new PriorityQueue<Integer>();
        PriorityQueue<Node> pq= new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.distance>o2.distance)
                    return +1;
                else if(o1.distance==o2.distance)
                        return 0;
                else
                    return -1;
            }
        });
        Node temp = new Node(source,0);
        pq.add(temp);
        distanceMap.put(source,0);
        while(!pq.isEmpty())
        {
            temp=pq.poll();
            processed.put(temp.id,temp.distance);
            distanceMap.remove(temp.id);
            Adjancy_list_header temp_header=G.Adjancy_List.get(temp.id);
            Adjancy_Node temp_Node=temp_header.next;
            while (temp_Node!=null)
            {
                if(!distanceMap.containsKey(temp_Node.vertex_id))
                {
                    distanceMap.put(temp_Node.vertex_id,temp.distance+temp_Node.weight);
                    pq.add(new Node(temp_Node.vertex_id,temp_Node.weight));
                }
                else
                {
                    if((temp.distance+temp_Node.weight)<distanceMap.get(temp_Node.vertex_id))
                    {
                        distanceMap.put(temp_Node.vertex_id,temp.distance+temp_Node.weight);
                        pq.remove(new Node(temp_Node.vertex_id,0));
                        pq.add(new Node(temp_Node.vertex_id,temp.distance+temp_Node.weight));
                    }
                }
                temp_Node=temp_Node.next;
            }

        }

        for(int vertex_id : processed.keySet())
        {
            System.out.println(" Node id : " +vertex_id+"  distance  : "+processed.get(vertex_id));
        }
        //:( its ok let it go :( in the end its ur choice chillll





    }
}
