package com.example.demo.thread;

public class Selection {

	public static void main(String[] args) {
		int a[] = {2,3,2,45,4,23223 };
		System.out.println("Before sort");
		 for (int i : a) {
				System.out.println(i);
				
			}
		//sort(a);
		int [] b = selectionSort(a);
		 for (int i : b) {
				System.out.println(i);
				
			}
	}
	
	public static void sort(int arr[]) {
      int temp;
      int index;
      for(int i = 0;i <arr.length; i++)  {
    	  
    	  index = i;
    	  for(int j = i + 1; j< arr.length;j++) {
    		  if (arr[j] < arr[index]) {
    			index = j;
    		  }
    	  }
    	  
    	   temp =arr[index];
			arr[index]= arr[i];
			arr[i] =temp;
      }
     System.out.println("After sort");  
      for (int i : arr) {
		System.out.println(i);
		
	}
	}
	
	public static int[]  selectionSort(int [] arr) {
		int count = 0 ;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i +1 ; j < arr.length; j++) {
				if(arr[j] < arr[i]) {
					index = j;
				}
				count++;
			}
			int temp = arr[index];
			arr[index] =arr[i];
			arr[i] = temp;
		}
		System.out.println("time for select:" + count);
		return arr;
	}

}
