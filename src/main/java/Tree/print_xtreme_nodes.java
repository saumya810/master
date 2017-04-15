package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by svarshne on 1/3/2017.
 */
public class print_xtreme_nodes {
void print(Node N)
{
    Queue <Node> Q1=new LinkedList<>() ;
    Queue <Node> Q2=new LinkedList<>() ;
    Queue Q3;
    Q1.add(N);
    //System.out.println(N.value);
    Node first=N;
    int k=0;
    while(!Q1.isEmpty())
    {

        Node temp=Q1.poll();
        if(temp.left!=null)
            Q2.add(temp.left);
        if(temp.right!=null)
            Q2.add(temp.right);
        if(Q1.isEmpty())
        {


           if(k%2==0)
           {
               System.out.println(first.value);
           }
           else
        {
            System.out.println(temp.value);
        }
        k++;
        if(Q2.peek()!=null)
            first=Q2.peek();
            Q3=Q1;
            Q1=Q2;
            Q2=Q3;

        }

    }


}

    public static void main(String[] args) {

        Node root=new Node(5) ;
        Node N1=new Node(3) ;
        Node N2=new Node(2) ;
        Node N3=new Node(4) ;
        Node N4=new Node(6) ;
        Node N5=new Node(7) ;
        Node N6=new Node(8) ;
        root.left=N1;
        root.right=N5;
        N1.left=N2;
        N1.right=N3;
        N2.left=null;
        N2.right=null;
        N3.left=null;
        N3.right=null;
        N5.left=N4;
        N5.right=N6;
        N4.left=null;
        N4.right=null;
        N6.left=null;
        N6.right=null;
        print_xtreme_nodes ob1=new print_xtreme_nodes();
        ob1.print(root);
    }
}
