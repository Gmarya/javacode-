/**
 * 
 */
package com.example.demo.thread;

/**
 * @author sameer.jadhav
 *
 */
public class UniquePartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 String s  = "tesefd3";
	 //printPartition(s);
	 System.out.println("Worke");
	 printUniquePartition(s.length());
	}

	/**
	 * @param s
	 */
	private static void printPartition(String s) {
		int len = s.length();
	    int [] p = new int[len];
	    int pointer = 0;
	    p[pointer] = len;
	    
	    while (true) {
	    	for(int i = 0 ;i < pointer + 1; i++)
	    		System.out.print(p[i] + " ");
	    	
	    	System.out.println();
	    	

            // Generate next partition 
   
            // Find the rightmost non-one value in p[]. Also, update the 
            // rem_val so that we know how much value can be accommodated 
            int rem_val = 0; 
	    	 while (pointer >= 0 && p[pointer] == 1) 
	            { 
	                rem_val += p[pointer]; 
	                pointer--; 
	            } 
	   
	            // if k < 0, all the values are 1 so there are no more partitions 
	            if (pointer < 0)  return; 
	   
	            // Decrease the p[k] found above and adjust the rem_val 
	            p[pointer]--; 
	            rem_val++; 
	   
	            // If rem_val is more, then the sorted order is violated.  Divide 
	            // rem_val in different values of size p[k] and copy these values at 
	            // different positions after p[k] 
	            while (rem_val > p[pointer]) 
	            { 
	                p[pointer+1] = p[pointer]; 
	                rem_val = rem_val - p[pointer]; 
	                pointer++; 
	            } 
	   

	           
	            // Copy rem_val to next position and increment position 
	            p[pointer +1 ] = rem_val; 
	            pointer++; 
	    }
	}
	
	public static void printUniquePartition(int n) {
	 int index = 0;
	 int [] partition = new int[n];
	 partition[index]  = n;
	 
	 while(true)  {
		 System.out.println("*****************************************8");
		 System.out.println(" index boefore:" + index);
		 for ( int i = 0 ;i < index + 1;i++)
			 System.out.print(partition[i]+ " ");
		 
		
		 System.out.println();
		 int rem= 0;
		 System.out.println("partition[index]  before first while :" + partition[index]);
		  while (index >= 0 && partition[index] == 1) {
			  rem += partition[index];
			  index--;
		  }
		  System.out.println(" index after first while:" + index);
		  System.out.println("rem  before first while :" + rem);
		if ( index < 0)
			return;
		 partition[index]--;
		 System.out.println("partition[index]  after first while :" + partition[index]);
		 rem++;
		  System.out.println("rem  after first while :" + rem);
		 while (rem > partition[index]) {
			 partition[index +1] = partition[index];
			 rem = rem - partition[index];
			 index ++;
		 }
		 System.out.println("partition[index]  after second while :" + partition[index]);
		 System.out.println("rem  after after second  while :" + rem);
		  System.out.println(" index after secomd while:" + index);
		 partition[index + 1] = rem;
		 index++;
		 
	 } 
	}

}
