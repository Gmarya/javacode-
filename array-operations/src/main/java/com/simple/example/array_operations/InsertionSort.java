/**
 * 
 */
package com.simple.example.array_operations;

/**
 * @author sameer.jadhav
 *
 */
public class InsertionSort {

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
	 * This sort using insertion sort method.
	 * 
	 * Algorithm
	 * 
	 * If it is the first element, it is already sorted. return 1; 
	 * Pick next element
	 * Step Compare with all elements in the sorted sub-list 
	 * Shift all the elements in the sorted sub-list that is greater than the value to be sorted 
	 * Insert the value Repeat until list is sorted
	 * 
	 * @param a
	 * @return
	 */
	private static int[] sort(int[] a) {
		int j;
		int key;
		for (int i = 1; i < a.length; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = key;
		}
		return a;
	}

}
