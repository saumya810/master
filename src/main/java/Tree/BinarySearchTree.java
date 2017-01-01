package Tree;
//import java.util.Queue;
//import java.util.LinkedList;
import java.util.*;

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
	  
	  public void Display_levelwise()
	  {
		  Queue <Node> queue = new LinkedList <Node> ();
		  queue.add(this.root);
		  while(!queue.isEmpty())
		  {
			  Node temp = queue.poll();
			  System.out.println(temp.value);
			  if(temp.left!=null)
				  queue.add(temp.left);
			  if(temp.right!=null)
				  queue.add(temp.right);
			  
		  }
	  }
	  
	  
	  public void Preorder()
	  {
		  Stack<Node> s1=new Stack<Node>();
		  s1.push(this.root);
		  while(!s1.isEmpty())
		  {
			  Node temp = s1.pop();
			  System.out.println(temp.value);
			  if(temp.right!=null)
				  s1.push(temp.right);
			  if(temp.left!=null)
				  s1.push(temp.left);
			  
		  }
		  
	  }
	  
	  public void Inorder()
	  {
		  Stack<Node> s1=new Stack<Node>();
		  Node temp = this.root;
		  while(!s1.isEmpty()||temp!=null)
		  {
			  while(temp!=null)
			  {
				  s1.push(temp);
				  temp=temp.left;
			  }
			  temp=s1.pop();
			  System.out.println(temp.value);
			  temp=temp.right;
			  
		  }
	  }
	  
	  public void Postorder()
	  {
		  Stack<Node> s1=new Stack<Node>();
		  Node temp=this.root;
		  Node prev=new Node(100);
		  s1.push(temp);
		  while(!s1.isEmpty())
		  {
			  temp=s1.peek();
			  if(!(prev==temp.left || prev==temp.right))
			  {
				  if(temp.right!=null)
					  s1.push(temp.right);
				  if(temp.left!=null)
					  s1.push(temp.left);
				  if(temp.right==null && temp.left==null)
				  {
					  temp=s1.pop();
					  System.out.println(temp.value);
					  prev=temp;
				  }
			  }
			  
			  else
			  {
				  temp=s1.pop();
				  System.out.println(temp.value);
				  prev=temp;
				  
			  }
			  
		  }
	  }
	  
	  
	  
	  
}
