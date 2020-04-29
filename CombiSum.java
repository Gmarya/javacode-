package com.example.demo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombiSum {

	public static void main(String[] args) {
     int [] candidates  = {10,1,2,7,6,1,5};
     int  target = 8;
     combiSum(candidates,target);
	}
   
	public static void combiSum(int a[], int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		operations(a, target, 0, 0, temp, result);
		result.forEach(System.out::println);
	}
	public static void operations(int [] a, int target, int start,int sum , List<Integer> temp, List<List<Integer>> result) {
		
		if (sum > target)
			return;
		
		if(sum == target) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		Scanner s = new Scanner(System.in);
		for(int i = start ;i <a.length ;i ++) {
			temp.add(a[i]);
			operations(a, target, i, sum + a[i], temp, result);
			temp.remove(temp.size() -1 );
		}
		
	}
}