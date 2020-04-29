package com.example.demo.thread;

public class SecondLargest {

	public static void main(String[] args) {
		int[] arr = { 123, 3, 1, 324, 4545 };
		findsecondLargest(arr);
	}

	public static void findsecondLargest(int[] a) {
		int max2;
		int max1 = max2 = Integer.MIN_VALUE;
		for(int i =0 ;i < a.length ;i ++) {
			if (a[i] > max1) {
				max2 = max1;
				max1 = a[i];
			}
			
			if (a[i]> max2 && a[i]!= max1) {
				max2 = a[i];
			}
		}
		System.out.println("Max1 " + max1 + " Max2 "+ max2);
	}
}
