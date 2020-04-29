/**
 * 
 */
package com.simple.example.array_operations;

/**
 * 
 * @author sameer.jadhav
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 2, 3, 2, 45, 4, 23223 };
		System.out.println("Before sort");
		for (int i : a) {
			System.out.println(i);

		}
		System.out.println("After sort");
		a = sort(a);
		for (int i : a) {
			System.out.println(i);

		}
	}

	/**
	 * This method sort the array using bubble sort method 
	 * 
	 * Algorithm:
	 * 
	 * Take an array of numbers " 5 1 4 2 8", and sort the array from lowest number
	 * to greatest number using bubble sort. In each step, elements written in bold
	 * are being compared. Three passes will be required;
	 * 
	 * First Pass ( 5 1 4 2 8 ) → ( 1 5 4 2 8 ), Here, algorithm compares the first
	 * two elements, and swaps since 5 > 1. ( 1 5 4 2 8 ) → ( 1 4 5 2 8 ), Swap
	 * since 5 > 4 ( 1 4 5 2 8 ) → ( 1 4 2 5 8 ), Swap since 5 > 2 ( 1 4 2 5 8 ) →
	 * (1 4 2 5 8 ), Now, since these elements are already in order (8 > 5),
	 * algorithm does not swap them.
	 * 
	 * Second Pass ( 1 4 2 5 8 ) → ( 1 4 2 5 8 ) ( 1 4 2 5 8 ) → ( 1 2 4 5 8 ), Swap
	 * since 4 > 2 ( 1 2 4 5 8 ) → ( 1 2 4 5 8 ) ( 1 2 4 5 8 ) → ( 1 2 4 5 8 ) Now,
	 * the array is already sorted, but the algorithm does not know if it is
	 * completed. The algorithm needs one whole pass without any swap to know it is
	 * sorted.
	 * 
	 * Third Pass ( 1 2 4 5 8 ) → ( 1 2 4 5 8 ) ( 1 2 4 5 8 ) → ( 1 2 4 5 8 ) ( 1 2
	 * 4 5 8 ) → ( 1 2 4 5 8 ) ( 1 2 4 5 8 ) → ( 1 2 4 5 8 )
	 * 
	 * @param a
	 */
	public static int[] sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}
  
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int[] anotherSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}	
}
