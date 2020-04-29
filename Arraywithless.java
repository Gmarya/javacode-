package com.example.demo.thread;

import java.util.Arrays;

//Write a code to sort the given array in sequential order of less than and greater than. 
public class Arraywithless {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 9, 10, 12, 12 };
		//arraywith(arr);
		rotateArray(arr, 3);
	}

	public static void arraywith(int[] a) {
		Arrays.sort(a);
		for (int i = 2; i < a.length; i = i + 3) {

			int temp = a[i];
			a[i] = a[i - 1];
			a[i - 1] = temp;

		}
		if (a.length % 3 == 2) {
			int temp = a[a.length - 1];
			a[a.length - 1] = a[a.length - 2];
			a[a.length - 2] = temp;
		}

		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private static void rotateArray(int[] a, int d) {
		int n = a.length;
		int k, j;
		int temp;
		int gcd = gcd(n, d);
		for (int i = 0; i < gcd; i++) {
			System.out.println(" i " + i);
			temp = a[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k -= n;
				if (k == i)
					break;
				System.out.println("a[k] "+ a[k] + "j " + j);
				a[j] = a[k];
				j = k;
			}
			System.err.println("j " + j);
			a[j] = temp;
		}
		for (int i : a) {
			System.out.println(i);
		}
	}

	/**
	 * @param n
	 * @param d
	 * @return
	 */
	private static int gcd(int n, int d) {
		if (d == 0)
			return n;
		return gcd(d, n % d);
	}
}
