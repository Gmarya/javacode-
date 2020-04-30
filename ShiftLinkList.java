package com.example.demo.thread;

class LinkedNode {
	int data;
	LinkedNode next;
	int count = 0;
	public  LinkedNode(int key) 
	{  
	    data = key; 
	    next = null; 
	} 
	
	public void display(LinkedNode node) {
		while(node != null) {
			System.out.print( node.data +" --> ");
			node = node.next;
		}
	}
	
	public int size(LinkedNode node) {
		while(node != null) {
			count ++;
			node = node.next;
		}
		return count;
	}
	
   public void rearrange(LinkedNode head, LinkedNode last) {
	   if (last == null)
		   return;
	   rearrange( head,  last.next);
	   if(head.next == null)
		   return;
	   if (head != last && head.next != last) {
		   LinkedNode tmp = head.next; 
		   head.next = last;
		   last.next = tmp;
	   } else {
		   if (head != last) 
			   head =head.next;
		   head.next = null;
	   }
	   
	   display(head);
	   //System.out.println();
   }
}
public class ShiftLinkList {

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(1); 
	    head.next = new LinkedNode(2); 
	    head.next.next = new LinkedNode(3); 
	    head.next.next.next = new  LinkedNode(4); 
	    head.next.next.next.next = new LinkedNode(5); 
	    head.display(head);
	    System.out.println( "Size " + head.size(head));
	    head.rearrange(head, head);
	    head.display(head);
	}

}
