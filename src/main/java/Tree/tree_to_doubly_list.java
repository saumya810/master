package Tree;

/**
 * Created by svarshne on 1/2/2017.
 */



public class tree_to_doubly_list {

    Node temp=null;
    public Node tree_to_list(Node N)
    {
        if(N==null)
        {
            return null;
        }
        if(N.left==null)
        {
            N.left=temp;
            System.out.println("hi");
            if(temp!=null)
             temp.right=N;
        }
        else
        {
            Node N1=tree_to_list(N.left);
            N.left=N1;
            N1.right=N;
        }

        this.temp=N;

        if(N.right==null)
        {
            return N;
        }
        else
        {
            Node N2=tree_to_list(N.right);
            return N2;

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
        tree_to_doubly_list ob1=new tree_to_doubly_list();
        Node Ntemp;
        Ntemp=ob1.tree_to_list(root);
        System.out.println(Ntemp.value);
        while(Ntemp!=null)
        {
            System.out.println(Ntemp.value);
            Ntemp=Ntemp.left;

        }




    }

}
