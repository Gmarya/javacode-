package com.simple.example.array_operations;

import java.util.Arrays;

/**
 * This program  to sort the given array in sequential order of less than
 * and greater than. Eg. Input = [1,5,4,99] output = [1,5,4,99] 1[4,99,5]
 * 4[5,99] 5[99] 99[]
 * 
 * @author sameer.jadhav
 *
 */

public class ArraySortInMannerExample {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 9, 10, 12, 12 };

	    sortArrayInLessGreatermanner(arr);
	}

	/**
	 * this method will sort the array in given order
	 * Algorithm:
	 * 
	 * Sort the array then start from 3 element and swap the previous and current value 
	 * increment by 3 
	 * 
	 * if array length is not divisible by 3 and  mod is 2 then swap last and second last value.
	 * 
	 * @param a
	 */
	public static void sortArrayInLessGreatermanner(int[] a) {
		int b[] = Arrays.copyOf(a, a.length);
		Arrays.sort(b);
		int length = b.length;
		for (int i = 2; i < length; i += 3) {
			int temp = b[i];
			b[i] = b[i - 1];
			b[i - 1] = temp;
		}
		// if some array length can not be divided by 3 in this case
		if (length % 3 == 2) {
			int temp = b[length - 1];
			b[length - 1] = b[length - 2];
			b[length - 2] = temp;
		}
		for (int i : b) {
			System.out.print(i + " ");
		}
	}

}
