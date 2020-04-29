/**
 * 
 */
package com.example.demo.thread;

/**
 * @author sameer.jadhav
 *
 */
public class ProductArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 4, 9 };
		productArray(arr);
	}

	/**
	 * @param a
	 */
	private static void productArray(int[] a) {
		if (a.length == 1) {
			System.out.println(a[0]);
		}
		
		int [] product  = new int[a.length];
		int temp = 1; 
		for (int i = 0; i < product.length; i++) {
			product[i] = temp;
			temp *= a[i];
			System.out.println("temp" + temp);
		}
		temp =1;
		for (int i = product.length -1 ; i >= 0; i--) {
			System.out.println(product[i]);
			product[i]*= temp;
			temp *= a[i];System.out.println("after " + product[i]);
		}
		for (int i = 0; i < product.length; i++) 
            System.out.print(product[i] + " "); 
	}
}
