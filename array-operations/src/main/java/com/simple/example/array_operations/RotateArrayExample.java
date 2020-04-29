/**
 * 
 */
package com.simple.example.array_operations;

import java.util.Arrays;

/**
 * This program to rotate the array using given number input { 1, 4, 5, 9, 10, 12, 12 }
 * rotate by 2 output -> {5,9,10,12,12,1,4}
 * @author sameer.jadhav
 *
 */
public class RotateArrayExample {
 
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 9, 10, 12, 12 };
		rotateArray(arr, 3);
	}
	/**
	 * This method rotate given array with given rotations
	 * Algorithm:
	 * 
	 * divide the array in different sets where number of sets is equal to GCD of n and d and move the
	 * elements within sets. If GCD is 1 as is for the above example array (n = 7
	 * and d =2), then elements will be moved within one set only, we just start
	 * with temp = arr[0] and keep moving arr[i+d] to arr[i] and finally store temp
	 * at the right place. eg.
	 * 
	 * Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} rotation 3 
	 * length is 12 and rotations are 3 so GCD of both is 3 , so sets will be 3.
	 * 
	 * a) arr[] after this step --> {|4| 2 3 |7| 5 6 |10| 8 9 |1| 11 12}
	 * divided in set and first value shifted to left then first one to last.
	 * 
	 * b) Then in second set. arr[] after this step --> {4 |5| 3 7 |8| 6 10 |11| 9 1 |2| 12}
	 * 
	 * c) Finally in third set. arr[] after this step --> {4 5 |6| 7 8 |9| 10 11 |12| 1 2 |3|}
	 * 
	 * @param a
	 * @param rValue
	 */
	public static void rotateArray(int[] a, int rValue) {
		int b[] = Arrays.copyOf(a, a.length);
		int j;
		int k = 0;
		int gcd = getGcd(b.length, rValue);
		int temp;
		for (int i = 0; i < gcd; i++) {
			temp = b[i];
			j = i;
			while (true) {
				k = j + rValue;
				if (k >= b.length) {
					k -= b.length;
				}
				if (k == i) {
					break;
				}
				b[j] = b[k];
				j = k;
			}
			b[j] = temp;
		}

		for (int i : b) {
			System.out.print(i + " ");
		}
	}

	/**
	 * THis method returns the GCD of 2 numbers
	 * 
	 * @param length
	 * @param rValue
	 * @return
	 */
	public static int getGcd(int no1, int no2) {
		if (no2 == 0)
			return no1;
		return getGcd(no2, no1 % no2);
	}
}
