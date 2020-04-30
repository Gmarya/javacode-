package com.example.demo.thread;

public class Prime {

	public static void main(String[] args) {
		primewithhalf(29);
		primewithsqrt(29);
	}

	public static void primewithhalf(int n) {
		System.out.println("Half of n :" + (n / 2));
		boolean isPrime = true;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.println(i);
				isPrime = false;
				break;
			}
		}
		if (isPrime)
			System.out.println("PRIME with n/2");
		else
			System.out.println("not PRIME with n/2");
	}

	public static void primewithsqrt(int n) {
		System.out.println("sqrt of n :" + Math.sqrt(n));
		boolean isPrime = true;
		for (int i = 2; i <Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println(i);
				isPrime = false;
				break;
			}
		}
		if (isPrime)
			System.out.println("PRIME with n/2");
		else
			System.out.println("not PRIME with n/2");
	}
}
