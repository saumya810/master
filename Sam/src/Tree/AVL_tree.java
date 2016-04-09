package Tree;

public class AVL_tree {

	public AVL_Node root;

	public AVL_tree() {
		this.root = null;
	}

	public void preorder(AVL_Node node) {
		if (node == null)
			return;
		System.out.println(node.value);
		this.preorder(node.left);
		this.preorder(node.right);

	}

	public int balance(AVL_Node node) {
		return (Height(node.left) - Height(node.right));
	}

	public int Height(AVL_Node node) {
		if (node == null)
			return 0;
		else
			return node.height;
	}

	public int max(int x, int y) {
		if (x >= y)
			return x;
		else {
			return y;
		}
	}

	public AVL_Node right_rotate(AVL_Node node) {
		AVL_Node X;
		X = node.left;
		node.left = X.right;
		X.right = node;
		node.height = max(Height(node.left), Height(node.right)) + 1;
		return X;
	}

	public AVL_Node left_rotate(AVL_Node node) {
		AVL_Node X;
		X = node.right;
		node.right = X.left;
		X.left = node;
		node.height = max(Height(node.left), Height(node.right)) + 1;
		return X;
	}

	public AVL_Node insert(AVL_Node node, int value) {
		if (node == null) {
			AVL_Node node1 = new AVL_Node(value);
			return node1;
		}
		if (node.value >= value) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}
		node.height = max(Height(node.left), Height(node.right)) + 1;
		int Balance = balance(node);
		if (Balance > 1) {
			System.out.println("not balance " + node.value);
			if (balance(node.left) > 0) {
				AVL_Node node1 = this.right_rotate(node);
				return node1;

			} else {
				AVL_Node node1 = this.left_rotate(node.left);
				node.left = node1;
				node1 = this.right_rotate(node);
				return node1;

			}
		}

		else if (Balance < -1) {
			if (balance(node.right) < 0) {
				AVL_Node node1 = this.left_rotate(node);
				return node1;
			}

			else {
				AVL_Node node1 = this.right_rotate(node.right);
				node.right = node1;
				node1 = this.left_rotate(node);
				return node1;
			}
		} else {
			// System.out.println("balanced "+node.value);
		}

		return node;

	}

}
