package com.example.demo.thread;


import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;

public class LRUCache<K, V> {

	private Node<K, V> lru;
	private Node<K, V> mru;
	private Map<K, Node<K, V>> container;
	private int capacity;
	private int currentSize;
	private LRUCache<K, V>.Node<K, V> head;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.currentSize = 0;
		lru = new Node<K, V>(null, null, null, null);
		mru = lru;
		head = mru;
		container = new HashMap<K, Node<K, V>>();
	}

	public V get(K key) {
		Node<K, V> tempNode = container.get(key);
		if (tempNode == null) {
			return null;
		}
		// If MRU leave the list as it is
		else if (tempNode.key == mru.key) {
			return mru.value;
		}

		// Get the next and prev nodes
		Node<K, V> nextNode = tempNode.next;
		Node<K, V> prevNode = tempNode.prev;

		// If at the left-most, we update LRU
		if (tempNode.key == lru.key) {
			nextNode.prev = null;
			lru = nextNode;
		}

		// If we are in the middle, we need to update the items before and after our
		// item
		else if (tempNode.key != mru.key) {
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}

		// Finally move our item to the MRU
		tempNode.prev = mru;
		mru.next = tempNode;
		mru = tempNode;
		mru.next = null;

		return tempNode.value;

	}
     private void display() {
    	 Node<K,V> temp = head;
    	 while(temp.next != null) {
    		 System.out.println("LRUCache.display() " + temp.value);
    		 temp = temp.next;
    	 }
    		System.out.println(container.size());
    		System.out.println("MRU " + mru.value);
    		System.out.println("LRU " + lru.value);
	}
	public void add(K key, V value) {
		if (container.containsKey(key)) {
			return;
		}

		// Put the new node at the right-most end of the linked-list
		Node<K, V> myNode = new Node<K, V>(mru, null, key, value);
		mru.next = myNode;
		container.put(key, myNode);
		mru = myNode;

		// Delete the left-most entry and update the LRU pointer
		if (currentSize == capacity) {
			container.remove(lru.key);
			lru = lru.next;
			lru.prev = null;
		}

		// Update container size, for the first added entry update the LRU pointer
		else if (currentSize < capacity) {
			if (currentSize == 0) {
				lru = myNode;
			}
			currentSize++;
		}
	}

	// Node for doubly linked list
	class Node<T, U> {
		T key;
		U value;
		Node<T, U> prev;
		Node<T, U> next;

		public Node(Node<T, U> prev, Node<T, U> next, T key, U value) {
			this.prev = prev;
			this.next = next;
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LRUCache<Integer, Integer> ca = new LRUCache<>(4);
		ca.add(1,1); 
        ca.add(2,2); 
        ca.add(3,3); 
        ca.add(1,1); 
        ca.add(4,4); 
        ca.add(5,5); 
        ca.add(2,2); 
        ca.display();
	}
}

/*
public class LRUCache {
	Deque<Integer> queue;
	HashSet<Integer> set;
	int cacheSize;
	public LRUCache(int size) {
	 queue = new LinkedList<>();
	 set = new HashSet<>();
	 cacheSize = size;
	}
	
	public void add(int key) {
		System.err.println( " Key " + key);
		
		queue.forEach( p-> System.out.println(p));
		System.out.println("***********************************8");
		if (set.contains(key)) {
			int indexOfkey, count;
			indexOfkey = count = 0;
			Iterator<Integer> iterate = queue.iterator();
		    while (iterate.hasNext()) {
				Integer next = iterate.next();
				System.out.println("Index " + count + " Vlaue " + next + " key " + key);
				if(next == key) {
					indexOfkey = count + 1;
					break;
				}
				count ++;
			}
			System.out.println("removed index  " +  indexOfkey + " removed value " + queue.remove(key));
			System.err.println("queue afer remoal");
			queue.forEach( p-> System.out.println(p));
			System.err.println("****************************888");
			queue.addFirst(key);
		} else {
			if (queue.size() == cacheSize) {
				 set.remove(queue.removeLast());
			} 
				queue.addFirst(key);
				set.add(key);
		}
	}
	
	public static void main(String[] args) {
		LRUCache ca = new LRUCache(4); 
        ca.add(1); 
        ca.add(2); 
        ca.add(3); 
        ca.add(1); 
        ca.add(4); 
        ca.add(5); 
        ca.add(5); 
        ca.add(3); 
        ca.add(4); 
        System.err.println("startd");
        ca.display(); 
	}

	private void display() {
		queue.forEach( p-> System.out.println(p));
	}
}
*/

/*

public class LRUCache <K,V> {
	int cacheSize;
	int counter = 0;
	Map<K,Node<K,V>> keys;
	Node<K,V> lru;
	Node<K,V> mru;
	public LRUCache(int size,K k, V v) {
		keys = new HashMap<>();
		lru = new Node<>(null, null, null, null);
		mru = lru;
	   cacheSize = size;
	}
	public V get (K key) {
		Node <K,V> temp = keys.get(key);
		if(null == temp) 
			return null;
		
		return temp.v;
	}
	
	public void put(K key, V value) {
		Node<K, V> temp = new Node<>(null, null, null, null);
		if (keys.containsKey(key)) {
			//addTof
		}
		temp.next = mru;
		mru.prev = temp;
		mru = temp;
		keys.put(key, temp);
		
		if (cacheSize  == counter) {
			
		}
		if (cacheSize > counter) {
			counter ++;
		}

	}
	public class Node<K,V> {
		Node<K,V> next;
		Node<K,V> prev;
		K k;
		V v;
		
		public Node(Node<K, V> next, Node<K,V> prev, K key, V value) {
			this.prev = prev;
			this.next = next;
			k = key;
			v = value;
		}
	}
}

*/