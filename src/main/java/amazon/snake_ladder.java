package amazon;

import javafx.scene.chart.BubbleChart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by svarshne on 4/15/2017.
 */
public class snake_ladder {

    class ladder
    {
        int source;
        int destination;
        public ladder(int source,int destination)
        {
            this.destination=destination;
            this.source=source;
        }
    }

    class Qitem
    {
        int loc;
        int step;

        public Qitem(int loc,int step)
        {
            this.loc=loc;
            this.step=step;
        }
    }

    int minStep(Queue<Qitem> q, List<ladder> ladders, List<ladder> snakes,Set<Integer> visited)
    {
        int num=0;
        int i=0;
        Qitem qitem=new Qitem(0,0);
        q.add(qitem);
        boolean lad_flag=false;
        while(!q.isEmpty())
        {
            Qitem q1=q.poll();
            for(i=1;i<=6;i++)
            {
                if(q1.loc+i==100)
                    return q1.step+1;

                if(visited.contains(q1.loc+i))
                {
                    continue;
                }
                else
                    visited.add(q1.loc+i);
                for(ladder lad : ladders)
                {
                    if(lad.source==q1.loc+i)
                    {
                        q.add(new Qitem(lad.destination,q1.step+1));
                        lad_flag=true;
                        break;
                    }

                }

                for(ladder lad : snakes)
                {
                    if(lad.source==q1.loc+i)
                    {
                        q.add(new Qitem(lad.destination,q1.step+1));
                        lad_flag=true;
                        break;
                    }

                }

                if(lad_flag==false)
                {
                  q.add(new Qitem(q1.loc+i, q1.step+1));
                }
                lad_flag=false;
                //System.out.println(i+"  "+q1.loc+"  "+q1.step+1);

            }
        }
        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        List<ladder> ladders=new ArrayList<ladder>();
        List<ladder> snakes=new ArrayList<ladder>();
        snake_ladder ob1=new snake_ladder();

        for(int i=0;i<Integer.parseInt(str);i++)
        {
            String l=br.readLine();
            String []s=l.split(" ");
            ladder lad = ob1.new ladder(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            ladders.add(lad);

        }
        str=br.readLine();
        for(int i=0;i<Integer.parseInt(str);i++)
        {
            String l=br.readLine();
            String []s=l.split(" ");
            ladder lad = ob1.new ladder(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
            snakes.add(lad);

        }

        Queue<Qitem> q=new LinkedList<Qitem>();
        Set <Integer> visited=new HashSet<Integer>();
        System.out.println(ob1.minStep(q,ladders,snakes,visited));




    }
}
