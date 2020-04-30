package com.example.demo.thread;

/* Java program for Merge Sort */
public class MergeSort {
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int left, int mid, int right) {
		// Find sizes of two subarrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = left;
		while (i < n1 || j < n2) {
			if (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					arr[k] = L[i];
					i++;
				} else {
					arr[k] = R[j];
					j++;
				}
				k++;
			} else if (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
			} else if (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
			}
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Given Array");
		printArray(arr);

		/*MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);*/
		mergeSort(arr, 0, arr.length-1);
		System.out.println("\nSorted array");
		printArray(arr);
	}

	public static void mergeSort(int[] arr, int start, int end) {

		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			mergeItems(arr, start, mid, end);
		}

	}

	/**
	 * @param arr
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void mergeItems(int[] arr, int start, int mid, int end) {
		int left = mid - start + 1;
		int right = end - mid;

		int[] larr = new int[left];
		int[] rarr = new int[right];
		for (int i = 0; i < left; i++) {
			larr[i] = arr[start + i];
		}
		for (int i = 0; i < right; i++) {
			rarr[i] = arr[mid + 1 + i];
		}
		int i = 0;
		int j = 0;
		int k = start;
		while (i < left || j < right) {
			if (i < left && j < right) {
				if (larr[i] < rarr[j]) {
					arr[k] = larr[i];
					i++;
				} else {
					arr[k] = rarr[j];
					j++;
				}
			} else if (i < left) {
				arr[k] = larr[i];
				i++;
			} else if (j < right) {
				arr[k] = rarr[j];
				j++;
			}
			k++;
		}

	}
}