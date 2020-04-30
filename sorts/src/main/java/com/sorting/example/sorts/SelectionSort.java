/**
 * 
 */
package com.sorting.example.sorts;

/**
 * @author sameer.jadhav
 *
 */
public class SelectionSort {

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
	 * This method sort the array using selection sort method 
	 * 
	 * Algorithm: Set MIN t location 0 
	 * Search the minimum element in the list
	 * Swap with value at location
	 * MIN Increment MIN to point to next element 
	 * Repeat until list is sorted E.g
	 * 
	 * arr[] = 64 25 12 22 11
	 * 
	 * // Find the minimum element in arr[0...4] // and place it at beginning 11 25
	 * 12 22 64
	 * 
	 * // Find the minimum element in arr[1...4] // and place it at beginning of
	 * arr[1...4] 11 12 25 22 64
	 * 
	 * // Find the minimum element in arr[2...4] // and place it at beginning of
	 * arr[2...4] 11 12 22 25 64
	 * 
	 * // Find the minimum element in arr[3...4] // and place it at beginning of
	 * arr[3...4] 11 12 22 25 64
	 * 
	 * @param a
	 * @return
	 */
	public static int[] sort(int[] a) {
		int min;
		for (int i = 0; i < a.length; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
		return a;
	}
}
