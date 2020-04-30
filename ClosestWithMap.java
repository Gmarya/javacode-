package com.example.demo.thread;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class myComp implements Comparator<Map.Entry<Integer, Integer>> {

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

	
}
public class ClosestWithMap {

	static LinkedHashMap<Integer, Integer> sum = new LinkedHashMap<>();
	public static void closest(int [] a) {
	 sum.put(-1, 0);
	 for(int i = 0; i< a.length ;i ++) {
		 sum.put(i, (sum.get(i-1) + a[i]));
	 }
	 sum.forEach((k,v) -> System.out.println(k + " : " + v ));
	 sum = sum.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, 
			 Entry::getValue,(e1,e)->e1,LinkedHashMap::new));
	 System.err.println("-----------------------------------------");
	 sum.forEach((k,v) -> System.out.println(k + " : " + v ));
	 
	 int start;
	 int end ;
	 int minDiff = Integer.MAX_VALUE;
	 for(int i =0 ;i < a.length ;i++) {
		 int diff = sum.get(i+1);
	 }
	}
	public static void main(String[] args) {
		 int arr[] = { -1,12,2, 3, -4, -1, 6 }; 
		 closest(arr);
	}

}
