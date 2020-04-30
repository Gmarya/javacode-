package com.example.demo.thread;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringManipulations {

	public static void main(String[] args) {
		String s = "Welcome to adobe interview";
		reverseStatement(s);

		String s1 = "GEEKSFORGEEKS";

		System.out.println(countWithLongestNonRepeatingChar(s1));

		String s2 = "FORGEEKSGEEKS";
		System.out.println("Is rotated : " + isrotatedString(s1, s2));
		String s3 = "geeksforgeeks";
		System.out.println("is rotated:" + isrotatedString(s1, s3));
		String s4 = "gksrek";
		System.out.println(" is  subseq: "+ isSubsequence(s4, s3));
	}

	private static boolean isrotatedString(String s1, String s2) {
		return (s1.length() == s2.length() && (s1 + s1).contains(s2));
	}
	
	private static boolean isSubsequence(String s1, String s2) {
		int j = 0;
		
		
		for (int i = 0; i <s2.length() && j < s1.length() ; i++ ) {
		  if (s2.charAt(i) == s1.charAt(j)) 
			  j++;
		}
		return j == s1.length(); 
	}

	private static void reverseStatement(String s) {
		String[] strArr = s.split(" ");
		List<String> asList = Arrays.asList(strArr);
		java.util.Collections.reverse(asList);
		System.out.println(asList.stream().collect(Collectors.joining(" ")));
		StringBuilder newstr = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			newstr.append(strArr[i]);
			newstr.append(" ");
		}
		System.out.println(newstr);
	}

	public static int countWithLongestNonRepeatingChar(String s) {
		int max = 0;
		int i = 0;
		int j = 0;
		Set<Character> set = new HashSet<>();
		HashMap<String, Integer> all = new HashMap<>();
		while (j < s.length()) {
			if (set.contains(s.charAt(j))) {
				all.put(s.substring(i,j), j-i);
				set.remove(s.charAt(i));
				i++;
			} else {
				set.add(s.charAt(j));
				j++;
				max = Math.max(max, j - i);
			}
		}
		System.out.println(all.entrySet().stream().max((x,y) -> x.getValue().compareTo(y.getValue())).get().getKey());
		return max;
	}
}
