package com.example.demo.thread;


class  Node1 {
	int data;
	Node1 left;
	Node1 right;
	
	public Node1(int data) {
      this.data = data;
      left = null;
      right = null;
	}
}
public class BinaryTreeLevel {
	static int rightMax = 0;
	Node1 root;
	static int LeftMax =  0 ;
	public void leftview(int level,Node1 node) {
		if (node == null)
			return;
		if(LeftMax < level) {
			System.out.println(node.data +  " = ");
			LeftMax = level;
		}
		leftview(level+1, node.left);
		leftview(level+1, node.right);
	}
	
	public void rightview(int level,Node1 node) {
		if (node == null)
			return;
		if(rightMax < level) {
			System.out.println(node.data);
			rightMax = level;
		}
		rightview(level+1, node.right);
		rightview(level+1, node.left);
		
	}
	
	
	
	 
	public static void main(String[] args) {
		BinaryTreeLevel tree = new BinaryTreeLevel(); 
	        tree.root = new Node1(12); 
	        tree.root.left = new Node1(10); 
	        tree.root.right = new Node1(30); 
	        tree.root.right.left = new Node1(25); 
	        tree.root.right.right = new Node1(40); 
	 //   tree.leftview(1, tree.root);
	    System.err.println("**************************");
	    System.out.println();
	    tree.rightview(1, tree.root);
	    
	    
	    Boolean b1 = new Boolean(true);
	       Boolean b2 =new Boolean(true);
	       System.out.print((b1 == b2) + " ");
	       System.out.print(b1.equals(b2)); 
	}

}
