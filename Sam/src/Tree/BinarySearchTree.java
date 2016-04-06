package Tree;
import java.io.*;

public class BinarySearchTree {

	public Node root;
	
	
	public void Insert(Node NewNode){
		if(this.root==null)
		{
			this.root=NewNode;
		}
		
		InsertNew(this.root,NewNode);

	}
	
	public void InsertNew(Node CurrentParent,Node NewNode)
	{
		if(NewNode.value <= CurrentParent.value)
		{
			if(CurrentParent.left==null){
				CurrentParent.left=NewNode;
				return;
			}
			else {
				InsertNew(CurrentParent.left,NewNode);
			}
				
		}
		else {
			if(CurrentParent.right==null){
				CurrentParent.right=NewNode;
				return;
		    }
			else
			{
				InsertNew(CurrentParent.right,NewNode);
			}
		}
	}
	
	public void Display(Node node)
	{
	  if(node!=null)
	  {
		  System.out.println(node.value);
		  if(node.left!=null)
			  Display(node.left);
		  if(node.right!=null)
			  Display(node.right);
	  }
	}
	
}
