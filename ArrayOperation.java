import java.util.Arrays;

/**
 * This program 1 -> to sort the given array in sequential order of less than
 * and greater than. Eg. Input = [1,5,4,99] output = [1,5,4,99] 1[4,99,5]
 * 4[5,99] 5[99] 99[]
 * 
 * 
 * 
 * 2 -> to rotate the array using given number input { 1, 4, 5, 9, 10, 12, 12 }
 * rotate by 2 output -> {5,9,10,12,12,1,4}
 * 
 * @author sameer.jadhav
 *
 */

public class ArrayOperation {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 9, 10, 12, 12 };

	    sortArrayInLessGreatermanner(arr);

		System.out.println("****************************");

		rotateArray(arr, 3);
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
