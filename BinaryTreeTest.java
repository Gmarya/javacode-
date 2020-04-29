package com.example.demo.thread;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.Queue;

class Node  {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = right = null;
	}
	
}

class BinaryTree {
	Node root;
	
	public BinaryTree(Node node) {
	  root = node;
	}
	
	public void insert(Node temp,int data) {
	   Queue<Node> q = new LinkedList<Node>();	
	   q.add(temp);
	   while (!q.isEmpty()) {
		   temp = q.peek();
		   q.remove();
		   if( temp.left == null) {
			   temp.left = new Node(data);
			   break;
		   } else {
			   q.add(temp.left);
		   }
		   
		   if( temp.right == null) {
			   temp.right = new Node(data);
			   break;
		   } else {
			   q.add(temp.right);
		   }
	   }
	}
	
	
	public void inorder(Node root) {
		if(root == null) {
		   return;
		}
		inorder(root.left);
		System.out.println(root.data + " ");
		inorder(root.right);
	}
	public 	void display(Node root) {
		if(root == null) {
			   return;
		}  
	     System.out.print(root.data + " root.data ");
	     if (root.left !=null)
	    	 System.out.print(root.left.data+ " root.left.data ");
	     if (root.right !=null)
	    	 System.out.print(root.left.data + " root.right.data");
         System.out.println();
			display(root.left);
			display(root.right);
	}
	
	public 	void displayleaf(Node root, int [] path, int count) {
		if(root == null) {
			   return;
		}  
		path[count] = root.data; 
		count++; 
	     if (root.left ==null && root.right ==null) {
	    	 printpath(path,count);
	     } 
	     displayleaf(root.left, path, count);
	     displayleaf(root.right, path, count);
	}

	private void printpath(int[] path, int count) {
	for(int i =0 ;i < count ;i ++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
}
public class BinaryTreeTest {

	public static void main(String[] args) {
    Node root = new Node(0); 
	BinaryTree b = new BinaryTree(root);
	b.insert(root, 12);
	b.insert(root, 2323);
	b.insert(root, 3453);
	b.insert(root, 32432432);
	Constructor[] c = BinaryTree.class.getConstructors();
	for (Constructor constructor : c) {
		constructor.setAccessible(true);
	}
     b.inorder(root);
     
     System.out.println("___________________________");
     
     int arr[] = new int[100];
     b.displayleaf(root,arr,0);
	}

}
