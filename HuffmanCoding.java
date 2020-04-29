/**
 * 
 */
package com.example.demo.thread;

import java.util.PriorityQueue;

/**
 * @author sameer.jadhav
 *
 */

class HuffNode {
	int data;
	char c;
	HuffNode left;
	HuffNode right;
	/**
	 * @param data
	 * @param c
	 * @param left
	 * @param right
	 */
	public HuffNode(int data, char c) {
		this.data = data;
		this.c = c;
		this.left = null;
		this.right = null;
	}
	
   public String toString() {
	   return "data : " + data + " ,c:" + c;
   }
}
class HuffMan {
	HuffNode root;
	PriorityQueue<HuffNode> queue;
	
	/**
	 * 
	 */
	public HuffMan() {
		queue = new PriorityQueue<>((x,y) -> x.data - y.data );
	}
	
	public void createHuffmanTree(char [] characters, int [] frequency) {
		
		for (int i = 0; i < frequency.length; i++) {
		   
			HuffNode h = new HuffNode(frequency[i], characters[i]);
			queue.add(h);
		}
		
		while(queue.size() > 1) {
			HuffNode h1 = queue.poll();
			HuffNode h2  =queue.poll();
			HuffNode newNode = new HuffNode(h1.data + h2.data, '-');
			newNode.left = h1;
			newNode.right = h2;
			root = newNode;
			queue.add(newNode);
		}
	  System.out.println(root);
	}
	
	public void printAllwithCodes(HuffNode root, String s) {
		
		if(root == null)
			return;
		if(root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + " : " + s);
			return;
		}
		printAllwithCodes(root.left, s+"0");
		printAllwithCodes(root.right, s + "1");
		
	}
	public void printSpecificCode(HuffNode root, String code, char c) {
		if(root == null)
			return;
		if(root.left == null && root.right == null && root.c == c) {
			System.out.println(root.c + " : " + code);
			return;
		}
		printSpecificCode(root.left, code+"0",c);
		printSpecificCode(root.right, code + "1",c);
	}
}
public class HuffmanCoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 
        HuffMan h = new HuffMan();
        
        h.createHuffmanTree(charArray, charfreq);
        h.printAllwithCodes(h.root, "");
        System.out.println("-----------------------------------");
        h.printSpecificCode(h.root, "",'e');
	}

}
