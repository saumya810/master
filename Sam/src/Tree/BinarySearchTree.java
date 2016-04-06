package Tree;
import java.io.*;

public class BinarySearchTree {

	public Node root;
	
	
	public void Insert(int value){
		Node NewNode = new Node(value);
		if(this.root==null)
		{
			this.root=NewNode;
			return;
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
	
	public void Display_preorder(Node node)
	{
	  if(node!=null)
	  {
		  System.out.println(node.value);
		  if(node.left!=null)
			  Display_preorder(node.left);
		  if(node.right!=null)
			  Display_preorder(node.right);
	  }
	}
	
	public void Display_inorder(Node node)
	{
	  if(node!=null)
	  {
		  if(node.left!=null)
			  Display_inorder(node.left);
		  System.out.println(node.value);
		  if(node.right!=null)
			  Display_inorder(node.right);
	  }
	}
	  
	  public void Display_postorder(Node node)
		{
		  if(node!=null)
		  {
			  if(node.left!=null)
				  Display_postorder(node.left);
			 
			  if(node.right!=null)
				  Display_postorder(node.right);
			  System.out.println(node.value);
		  }
	}
	  
	  
	  
	  
}
