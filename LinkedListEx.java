package com.example.demo.thread;

public class LinkedListEx {
	LinkedListEx next;
	int data;
	LinkedListEx head;

	public LinkedListEx(int data) {
		this.data = data;
		next = null;
	}
	
	public void add(int data, LinkedListEx head) {
		LinkedListEx temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = new LinkedListEx(data);
		
	}
    public void display(LinkedListEx head) {
    	LinkedListEx temp = head;
		while(temp!= null) {
			System.out.print(temp.data + " ->");
			temp = temp.next;
		}
		
    }
    
    public LinkedListEx reverseList(LinkedListEx head) {
    	LinkedListEx next , current = head,prev = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev; 
		return head;
    }
    
   public LinkedListEx rearrange(LinkedListEx node) 
    { 
  
        LinkedListEx slow = node, fast = slow.next; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
  
        // 2) Split the linked list in two halves 
        // node1, head of first half    1 -> 2 -> 3 
        // node2, head of second half   4 -> 5 
        LinkedListEx node1 = node; 
        LinkedListEx node2 = slow.next; 
        slow.next = null; 
  
        // 3) Reverse the second half, i.e., 5 -> 4 
        node2 = reverseList(node2); 
  
        // 4) Merge alternate nodes 
        node = new LinkedListEx(0); // Assign dummy Node 
  
        // curr is the pointer to this dummy Node, which will 
        // be used to form the new list 
        LinkedListEx curr = node; 
        while (node1 != null || node2 != null) { 
  
            // First add the element from first list 
            if (node1 != null) { 
                curr.next = node1; 
                curr = curr.next; 
                node1 = node1.next; 
            } 
  
            // Then add the element from second list 
            if (node2 != null) { 
                curr.next = node2; 
                curr = curr.next; 
                node2 = node2.next; 
            } 
        } 
  
        // Assign the head of the new list to head pointer 
        node = node.next; 
        return node;
    } 
	public static void main(String[] args) {
		LinkedListEx head = new LinkedListEx(0);
		head.add(1, head);
		head.add(2, head);
		head.add(3, head);
		head.display(head);
		System.out.println("*****************************************");
	  //head.display(head.reverseList(head));
		
		head .display(head);
		System.out.println("*****************************************");
		System.out.println("*****************************************");
		
		System.out.println("*****************************************");
		head.display(head.rearrange(head));
	}
 
}
