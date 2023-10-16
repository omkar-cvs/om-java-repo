package com.oks.programs.logincal;

public class PrimeNumberSeries {

	public static void main(String[] args) {	
		//printPrimeNumSeries(-5,100);
		//fibonacciSeries(21);
		//System.out.println(palindrom(121));
	
	}
	public static boolean isPrime(int num) {
		if (num < 2)
			return false;
		if (num == 2)
			return true;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void printPrimeNumSeries(int minLimit, int maxLimit) {
		for (int i = minLimit; i <= maxLimit; i++) {
				if (isPrime(i)) {
					System.out.println("Prime : " + i);
				} else {
					// System.out.println("Not Prime");
				}
		}
	}
	
	public static void fibonacciSeries(int upperLimit) {
		int f0=0;
		int f1=1;
		int fib=0;		
		while(fib<=upperLimit) {			
			System.out.println(fib);			
			f0=f1;
			f1=fib;
			fib=f0+f1;			
		}		
	}
	
	public static boolean palindrom(int num) {
		int temp=num;
		int sum=0;
		//int r;
		
		while(temp>0) {
			sum=sum*10+temp%10;
			temp=temp/10;
		}
		
		if(num==sum) {
			return true;
		}else {
			return false;
		}
	}
	


}
