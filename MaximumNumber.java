/**
 * 
 */
package com.example.demo.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sameer.jadhav
 *
 */
public class MaximumNumber {
	public static void main(String[] args) {
		List<Integer> arrList = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 6, 7));
		arrList.stream().filter(p -> p % 2 == 0).collect(Collectors.toList());
		getMaxNum();

	}
	
	public static void getMaxNum() {
		List<Integer> arrList = new ArrayList<>(Arrays.asList(1,4,8,2,84,36));
		// 7 6 4 27 26 2 1
		//764272343421
		//764272343421
		//764234342271
		Collections.sort(arrList, (o1, o2) -> {
			 String no1=String.valueOf(o1) + String.valueOf(o2); 
	          
		        // then append X at the end of Y 
		        String no2=String.valueOf(o2) + String.valueOf(o1); 
		          
		        // Now see which of the two formed numbers  
		        // is greater 
		        return no1.compareTo(no2); 
			/*int result;
			System.out.println(o1 +" comparing " + o2);
			// if length is one digit og both
			 int o1length = String.valueOf(o1).length();
			int o2length = String.valueOf(o2).length();
			if (o1length ==  o2length) {
				 result = o1.compareTo(o2);
			 } else if (o1length >  o2length) {
				result = (o1 / (int) (Math.pow(10,(o1length - o2length))))  - o2;
			 } else {
				 result = o1 - (o2 / (int)(Math.pow(10,(o2length - o1length))));
			 }*/
			/*if (result == 0) {
				// this  is since we've same number with first digit then we will sort them on equality
				result = o1 > o2 ? 1 : -1; 
			}*/
			/*
			if (String.valueOf(o1).length() == 1 && String.valueOf(o2).length() == 1)
				result = o1.compareTo(o2);
			else {
				// if length is more digit in both
				if (String.valueOf(o1).length() > 1 && String.valueOf(o2).length() > 1) {
					if (String.valueOf(o1).length()  == String.valueOf(o2).length())
						result = o1.compareTo(o2);
					else if (String.valueOf(o1).length() >  String.valueOf(o2).length()) {
						result = (o1 / (int) (Math.pow(10,(String.valueOf(o1).length() - String.valueOf(o2).length() + 1))))  - o2;
					} else  {
						result = o1 - (o2 / (int)(Math.pow(10,(String.valueOf(o1).length() - String.valueOf(o2).length() + 1))));
					}
				
				} else if (String.valueOf(o1).length() > 1) { // if length is more digit in one of 
					result =  (o1 / (int)(Math.pow(10,(String.valueOf(o1).length() - 1)))) - o2;
					
				} else {
					result = o1 - (o2 / (int)(Math.pow(10,(String.valueOf(o2).length() - 1)))); // if length is more digit in one of 
				}
				if (result == 0) {
					// this  is since we've same number with first digit then we will sort them on equality
					result = o1 > o2 ? 1 : -1; 
				}
			} */
			//return  result;
		});
		
		// complexity  for sort will O(nLogn) as it internaly uses Merge sort and comparator complexity will not 
		// be considered untill unless we will not add looping in it.
		Collections.reverse(arrList);
		//this will have O(n) complexity since need to traverse all;
		arrList.forEach(p -> System.out.print(p));
		
		// Overall complexity will be O(nLogn) with O(1) space complexity;
	}

}
