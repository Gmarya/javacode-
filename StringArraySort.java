package com.example.demo.thread;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringArraySort {

	public static void main(String[] args) {
		String strArr[] = { "geeksforgeeks", "is", "the", "best", "place", "for", "learning" };
		List<String> lstString = Arrays.asList(strArr);
		usingutilandcomparator(strArr);

		usingCollections(lstString);
	}

	private static void usingCollections(List<String> lstString) {
		Collections.sort(lstString, (String s1, String s2) -> {
			if (s1.length() == s2.length())
			 return s1.compareTo(s2);
		   return s1.length() - s2.length();} );
		System.err.println("*******************************************");
		System.err.println("*******************************************");
		lstString.forEach(p -> System.out.print(p + " "));
	}

	private static void usingutilandcomparator(String[] strArr) {
		Arrays.sort(strArr, (s1, s2) -> {
			if (s1.length() == s2.length())
				return s1.compareTo(s2);
			return s1.length() - s2.length();
		});
		for (String string : strArr) {
			System.out.print(string + " ");
		}
	}

}
