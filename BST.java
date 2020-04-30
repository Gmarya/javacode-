package com.example.demo.thread;

import java.util.ArrayList;
import java.util.stream.IntStream;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		left = right = null;
	}
}

/**
 * @author sameer.jadhav
 *
 */
/**
 * @author sameer.jadhav
 *
 */
/**
 * @author sameer.jadhav
 *
 */
public class BST {

	public TreeNode recursiveInsert(int data, TreeNode root) {
		if (root == null) {
			return new TreeNode(data);
		}
		if (root.data < data) {
			root.right = recursiveInsert(data, root.right);
		} else {
			root.left = recursiveInsert(data, root.left);
		}
		return root;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.println(root.data + " ");
		inorder(root.right);

	}

	public void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.data + " ");
		inorder(root.left);
		inorder(root.right);

	}

	public void postorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		inorder(root.right);
		System.out.println(root.data + " ");

	}
 		
	public TreeNode iterativeInsert(int data, TreeNode root) {
		if (root == null) {
			return new TreeNode(data);
		}
		TreeNode temp = null;
		TreeNode cur = root;
		while (cur != null) {
			temp = cur;
			if (cur.data < data) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}
		}
		if (temp.data < data) {
			temp.right = new TreeNode(data);
		} else {
			temp.left = new TreeNode(data);
		}
		return root;
	}

	public int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int lHeight = heightOfTree(root.left);
		int rHeight = heightOfTree(root.right);
		if (lHeight > rHeight) {
			return lHeight + 1;
		} else {
			return rHeight + 1;
		}
	}
	
	public int diameterOfTree(TreeNode node) {
		
		if (node == null)
			return 0;
		
		int lHeight = heightOfTree(node.left);
		int rHeight = heightOfTree(node.right); 
		
		int lDiameter = diameterOfTree(node.left);
		int rDiameter = diameterOfTree(node.right);
		
		return Math.max(lHeight + rHeight, Math.max(lDiameter, rDiameter));
		
	}

	public boolean isbalanced(TreeNode root) {
		if (root == null)
			return false;
		int lHeight = heightOfTree(root.left);
		int rHeight = heightOfTree(root.right);
		int diff = lHeight - rHeight;
		return diff >= -1 && diff < 1;
	}

	public TreeNode buildBalancedTree(TreeNode root) {

		ArrayList<TreeNode> nodeList = new ArrayList<>();
		storeNodes(nodeList, root);
		root = buildtree(nodeList, 0, nodeList.size() - 1);
		return root;
	}

	private TreeNode buildtree(ArrayList<TreeNode> nodeList, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode midNode = nodeList.get(mid);
		midNode.left = buildtree(nodeList, start, mid - 1);
		midNode.right = buildtree(nodeList, mid + 1, end);

		return midNode;
	}
	
	private void storeNodes(ArrayList<TreeNode> nodeList, TreeNode root) {
		if (root == null)
			return;

		storeNodes(nodeList, root.left);
		nodeList.add(root);
		storeNodes(nodeList, root.right);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BST tree = new BST();
		TreeNode root = new TreeNode(14);
		int[] keys = { 15, 10, 20, 8, 12, 16, 25, 27 };
		System.out.println(IntStream.of(keys).map(no -> no * 3).count());
		for (int key : keys) {
			root = tree.iterativeInsert(key, root);
		} System.out.println("Height of tree:" + tree.heightOfTree(root));
		System.out.println("isbalanced: " + tree.isbalanced((root)));
		if (!tree.isbalanced(root)) {
			root = tree.buildBalancedTree(root);
		}
		System.out.println("After isbalanced: " + tree.isbalanced((root)));
		tree.preorder(root);
		System.out.println("___________________________");
		tree.inorder(root);
		System.out.println("___________________________");
		tree.postorder(root);
		
		
		System.out.println("Daimeter of tree :" + tree.diameterOfTree(root));

	}

}
					