package Tree;
import java.util.*;

/**
 * Created by svarshne on 1/9/2017.
 */
public class order_and_height {

    class N implements Comparable<N>{

        int height;
        int infront;
        public N(int height,int infront)
        {
            this.height=height;
            this.infront=infront;
        }


        @Override
        public int compareTo(N o) {
            return Integer.compare(this.height,o.height);
        }
    }

    class bit
    {
        int num;
        int [] b;

        public bit(int num)
        {
            this.num=num;
            b=new int[num];
        }

        int query(int index)
        {

        }

        int update ()

    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<N> N1=new ArrayList<N>();
        for(int i=0;i<heights.size();i++)
        {
            N1.add(new N(heights.get(i),infronts.get(i)));
        }

    }
}
