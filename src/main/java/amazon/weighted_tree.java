package amazon;

import java.util.*;

/**
 * Created by svarshne on 4/15/2017.
 */
public class weighted_tree {

    class Node {
        int val;
        Node left;
        Node right;

        public Node(int i)
        {
            this.val=i;
            this.left=null;
            this.right=null;
        }
    }


    int count_odd(Node N,int level)
    {
        if(N==null)
            return 0;
        else
        {
            if(level%2==1)
                return (1+count_odd(N.left,level+1)+count_odd(N.right,level+1));
            else
                return (count_odd(N.left,level+1)+count_odd(N.right,level+1));
        }
    }

    void tree_to_array_list(Node N,ArrayList<Integer> list)
    {
        if(N==null)
            return;
        else
        {
            list.add(N.val);
            tree_to_array_list(N.left,list);
            tree_to_array_list(N.right,list);
        }
    }

    Node Max_weight(Node root)
    {
        ArrayList<Integer> al=new ArrayList<Integer>();
        tree_to_array_list(root,al);
        Collections.sort(al);
        int odd=count_odd(root,1);
        int []a=new int[al.size()];
        int i=0;
      /*  for(int a1:al)
        {
            a[i]=a1;
            i++;
        }
        */
        Queue<Node> oddq=new LinkedList<Node>();
        Queue<Node> evenq=new LinkedList<Node>();
        oddq.add(root);
        int oddmarker=odd-1;
        int evenmarker=odd;
        int weight=0;
        int level=0;
        while(!oddq.isEmpty()||!evenq.isEmpty())
        {
            level++;
            while(!oddq.isEmpty())
            {
                Node N=oddq.poll();
                N.val=al.get(oddmarker);
                oddmarker--;
                if(N.left!=null)
                    evenq.add(N.left);
                if(N.right!=null)
                    evenq.add(N.right);
                weight=weight-level*N.val;
                System.out.println(" odd "+N.val+" "+oddmarker+"  ");
            }
            level++;
            while(!evenq.isEmpty())
            {
                Node N=evenq.poll();
                N.val=al.get(evenmarker);
                evenmarker++;
                if(N.left!=null)
                    oddq.add(N.left);
                if(N.right!=null)
                    oddq.add(N.right);
                weight=weight+level*N.val;
            }
        }
        System.out.println(weight);
        return root;

    }

    void print(Node N)
    {
        if(N==null)
            return;
        System.out.println(N.val);
        print(N.left);
        print(N.right);
    }
    public static void main(String[] args) {

        weighted_tree ob1=new weighted_tree();
        Node N7=ob1.new Node(7);
        Node N6=ob1.new Node(6);
        Node N5=ob1.new Node(5);
        Node N4=ob1.new Node(4);
        Node N3=ob1.new Node(3);
        Node N2=ob1.new Node(2);
        Node N1=ob1.new Node(1);
        N7.left=N6;
        N7.right=N5;
        N6.left=N4;
        N6.right=N3;
        N5.left=N2;
        N5.right=N1;
        ob1.print(ob1.Max_weight(N7));
    }
}
