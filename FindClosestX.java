package com.example.demo.thread;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;


class Prefix {
	int sum;
	int index;

	public Prefix(int s, int i) {
		sum = s;
		index = i;
	}

	
}

class SumCmp implements Comparator<Prefix> 
{ 
	@Override
	public int compare(Prefix o, Prefix o1) {
		if (o1.sum > o.sum)
			return -1;
		return 0;
	}
} 
  

public class FindClosestX {

	public static void main(String[] args) {
		 int arr[] = { -1,12,2, 3, -4, -1, 6 }; 
		findSubArray(arr, arr.length);
	}

	public static void findSubArray(int[] arr, int n) {
		int start,end; 
	    int min_diff =start =end = Integer.MAX_VALUE;
		Prefix[] pre_sum = new Prefix[n + 1];
		pre_sum[0] = new Prefix(0, -1);
		System.out.println(" sum : " +pre_sum[0].sum + " index : " + pre_sum[0].index );
		for (int i = 0; i < n; i++) {
			pre_sum[i+1] = new Prefix(0, -1); 
			
			System.out.println(" pre sum  i-1: " +pre_sum[i].sum + " arr[i - 1] : " + arr[i] );
			
			pre_sum[i+1].sum = pre_sum[i].sum + arr[i];
			pre_sum[i+1].index = i ;
			System.out.println(" sum : " +pre_sum[i+1].sum + " index : " + pre_sum[i+1].index );
		}
		System.out.println("+++++++++++++++++++++++++");
		Collections.sort(Arrays.asList(pre_sum), new SumCmp());
		for (Prefix prefix : pre_sum) {
			System.out.println(prefix.index + " " + prefix.sum);
		}
		System.out.println("+++++++++++++++++++++++++");
		 for (int i = 1; i <= n; i++) { 
		        int diff = pre_sum[i].sum - pre_sum[i-1].sum; 
		  System.out.println(diff + " diff for i and i -1 " + i );
		        // Update minimum difference 
		        // and starting and ending indexes 
		  System.out.println((start)  + " to " + end);
		  
		  
		        if (min_diff > diff) { 
		            min_diff = diff; 
		            start = pre_sum[i-1].index; 
		            end = pre_sum[i].index; 
		        } 
		    } 
		 
		 System.out.println("final " + (start +1)  + " to " + end);
		 for (int i = start +1 ; i < end; i++) {
			
		}
	}
}
