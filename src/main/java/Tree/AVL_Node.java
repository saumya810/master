package Tree;

public class AVL_Node {
	int value;
	int height;
	AVL_Node left;
	AVL_Node right;
	
	public AVL_Node(int value)
	{
		this.value=value;
		this.height=0;
	}

}
