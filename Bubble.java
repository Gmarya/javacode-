package com.example.demo.thread;


public class Bubble {

	public static void main(String[] args) {
		int a[] = {2,3,2,45,4,23223 };
		System.out.println("Before sort");
		 for (int i : a) {
				System.out.println(i);
				
			}
		//sort(a);
		int b [] = newSort(a);
		System.out.println("New sort");
		for (int i : b) {
			System.out.println(i);
			
		}
	}
	
	public static void sort(int arr[]) {
      int temp;
      for(int i = 0;i <arr.length; i++)  {
    	  for(int j = i + 1; j< arr.length;j++) {
    		  if (arr[i] > arr[j]) {
    			temp =arr[i];
    			arr[i]= arr[j];
    			arr[j] =temp;
    		  }
    	  }
      }
     System.out.println("After sort");  
      for (int i : arr) {
		System.out.println(i);
		
	}
	}
	 // trybubble now
    
    public static int[] newSort(int [] arr) {
    	int count  = 0;
  	  for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				count ++;
			}
		} 
  	  System.out.println("time for sorting : " + count);
  	   return arr;
    }

}
