package Tree;

public class TestTree {
	
	public static void main(String[] args){
	
	/*	BinarySearchTree t1 = new BinarySearchTree();
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
		Thread_tree_test t11 = new Thread_tree_test();
		t11.insert(8);
		t11.insert(6);
		t11.insert(12);
		t11.insert(4);
		t11.insert(3);
		t11.insert(7);
		t11.insert(11);
		t11.insert(16);
		t11.insert(5);
		System.out.println("Inorder traversal for threaded tree");
		t11.inorder();
	*/
		AVL_tree at = new AVL_tree();
		at.root=at.insert(at.root,100);
		at.root=at.insert(at.root,8);
		at.root=at.insert(at.root,120);
		at.root=at.insert(at.root,5);
		at.root=at.insert(at.root,90);
		at.root=at.insert(at.root,110);
		at.root=at.insert(at.root,130);
		at.root=at.insert(at.root,85);
		at.root=at.insert(at.root,95);
		at.preorder(at.root);
		at.root=at.insert(at.root,84);
		at.preorder(at.root);
		
		
				
		
	}
	
	
	
	
	
	
	
	
	
	
}
