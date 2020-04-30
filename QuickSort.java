/**
 * 
 */
package com.example.demo.thread;

/**
 * @author sameer.jadhav
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	
	 public static void quickSort(int [] arr,int start,int end) {
		 if (start < end) {
			 int partition = partition(arr,start,end);
			 quickSort(arr, start, partition-1);
			 quickSort(arr, partition+1, end);
		 }
	 }
	/**
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for(int j = start ; j < end ;j++) {
			if(arr[j]< pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;
		return i+1;
	}
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		quickSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
