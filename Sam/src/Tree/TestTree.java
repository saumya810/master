package Tree;

public class TestTree {
	
	public static void main(String[] args){
	
		BinarySearchTree t1 = new BinarySearchTree();
		t1.Insert(8);
		t1.Insert(6);
		t1.Insert(12);
		t1.Insert(4);
		t1.Insert(3);
		t1.Insert(7);
		t1.Insert(11);
		t1.Insert(16);
		t1.Insert(5);
		System.out.println("Preorder traversal");
		t1.Display_preorder(t1.root);
		System.out.println("Inorder traversal");
		t1.Display_inorder(t1.root);
		System.out.println("Postorder traversal");
		t1.Display_postorder(t1.root);
		System.out.println("Level wise traversal");
		t1.Display_levelwise();
		System.out.println("Preorder traversal without recursion");
		t1.Preorder();
		System.out.println("Ineorder traversal without recursion");
		t1.Inorder();
		System.out.println("postorder traversal without recursion");
		t1.Postorder();
		
	}
	
	
	
	
	
	
	
	
	
	
}
