package com.example.demo.thread;

import java.util.Stack;

public class Insertion {
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) {
		int a[] = { 2, 3, 2, 45, 4, 23223 };
		System.out.println("Before sort");
		for (int i : a) {
			System.out.println(i);
		}
		//sort(a);
		
		int [] b = insertionSort(a);
		System.out.println("after soort");
		for (int i : b) {
			System.out.println(i);
		}
	}

	public static void sort(int arr[]) {
		int key;
		for (int i = 1; i < arr.length; i++) {

			key = arr[i];

			System.out.println("key " + key);
			int j = i - 1;
			System.out.println("j " + j);
			while (j > -1 && key < arr[j]) {
				System.out.println("arr[j+1] = arr[j]; " + arr[j + 1] + " " + arr[j]);
				System.out.println(" j in between " + j);
				arr[j + 1] = arr[j];
				j--;
			}
			System.out.println("j  after " + j);
			arr[j + 1] = key;
			System.out.println("arr[j+1]" + arr[j + 1]);
		}
		System.out.println("After sort");
		for (int i : arr) {
			System.out.println(i);

		}
	}

	//
	public static int[] insertionSort(int[] arr) {
		int count = 0;
		int key;
		for (int i = 1; i < arr.length; i++) {
			key = arr[i];
			int j = i - 1;
			while (j > -1 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
				
			}
			arr[j + 1] = key;
			count++;
		}
		System.out.println("count after :" + count);
		return arr;
	}
}
