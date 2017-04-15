package Tree;

/**
 * Created by svarshne on 1/5/2017.
 */
 class TreeLinkNode {
      int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
}
public class Level_wise_without_mem {

     public void print (TreeLinkNode N)
     {
         if(N==null)
             return;
         print (N.left);
         if(N.next==null)
             System.out.print("NULL ");
         else
         System.out.print(N.next.val+" ");
         print(N.right);
     }
    public void connect(TreeLinkNode root) {

        TreeLinkNode N1=root;
        TreeLinkNode N=null;
        N1.next=null;
        TreeLinkNode temp=null;
        while(N1!=null)
        {
            if(N1.left==null&&N1.right==null)
            {
                N1=N1.next;
            }
            else {
            if (N1.left == null) {
                    if (temp == null) {
                        temp = N1.right;
                        N = temp;
                    } else {
                        N.next = N1.right;
                        N = N.next;
                    }


                } else if (N1.right == null) {
                    if (temp == null) {
                        temp = N1.left;
                        N = temp;
                    } else {
                        N.next = N1.left;
                        N = N.next;
                    }
                } else {
                    if (temp == null) {
                        temp = N1.left;
                        N1.left.next = N1.right;
                        N = N1.right;

                    } else {
                        N.next = N1.left;
                        N1.left.next = N1.right;
                        N = N1.right;
                    }
                }
           N1=N1.next;

            }
            if(N1==null&&temp!=null)
            {
                N1=temp;
                temp=null;
                N.next=null;
            }

        }
      this.print(root);
    }


    public static void main(String[] args) {
        TreeLinkNode root=new TreeLinkNode(5) ;
        TreeLinkNode N1=new TreeLinkNode(3) ;
        TreeLinkNode N2=new TreeLinkNode(2) ;
        TreeLinkNode N3=new TreeLinkNode(4) ;
        TreeLinkNode N4=new TreeLinkNode(6) ;
        TreeLinkNode N5=new TreeLinkNode(7) ;
        TreeLinkNode N6=new TreeLinkNode(8) ;
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
        Level_wise_without_mem ob1=new Level_wise_without_mem();
        TreeLinkNode root1=new TreeLinkNode(5) ;
        root.left=null;
        root.right=null;
        ob1.connect(root1);
      //  ob1.print(root);

    }
}
