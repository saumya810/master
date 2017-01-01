package Tree;

public class Thread_tree_test {
	Thread_T_Node root;
	
	public Thread_tree_test()
	{
		this.root=new Thread_T_Node(999);
		this.root.lbit=0;
		this.root.rbit=1;
		this.root.left=root;
		this.root.right=root;
		this.root.value=999;
		
	}
	
	public void insert(int i)
	{
		Thread_T_Node node=new Thread_T_Node(i);
		if(this.root.left==root && this.root.right==root)
		{
			node.lbit=root.lbit;
			node.rbit=0;
			node.left=root;
			node.right=root;
			this.root.left=node;
			this.root.lbit=1;
		}
		else
		{
			Thread_T_Node current = this.root.left;
			while(true)
			{
				if(node.value<=current.value)
				{
					if(current.lbit==0)
					{
						node.lbit=current.lbit;
						current.lbit=1;
						node.left=current.left;
						node.right=current;
						current.left=node;
						node.rbit=0;
						return;
					}
					else if(current.lbit==1)
					{
						current=current.left;
					}
				}
				
				else
				{
					if(current.rbit==0)
					{
						node.left=current;
						node.right=current.right;
						current.right=node;
						node.lbit=0;
						node.rbit=current.rbit;
						current.rbit=1;
						return;
						
					}
					else if(current.rbit==1)
					{
						current=current.right;
					}
				}
			}
		}
	}
	
	
	public void inorder()
	{
		
		Thread_T_Node current = this.root.left;
		while(current.lbit==1)
		{
			current=current.left;
		}
		while(current!=root)
		{
			System.out.println(current.value);
			current= inorder_right(current);
		}
	}
	
	public Thread_T_Node inorder_right(Thread_T_Node current)
	{
		if(current.rbit==0)
		{
			return current.right;
		}
		else
		{
			current=current.right;
			while(current.lbit==1)
			{
				current=current.left;
			}
			return current;
		}
		
	}

}
