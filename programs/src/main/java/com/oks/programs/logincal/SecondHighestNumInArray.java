package com.oks.programs.logincal;

public class SecondHighestNumInArray {	
	public static void main(String[] args) {
		
		int[] ar= {1,9,5,55,8,-1,3,55};
		int secondHighestNum=getSecondHighestNum(ar);
		System.out.println("Second Highest Num : "+secondHighestNum);
	}
	
	public static int getSecondHighestNum(int[] arr) {
		
		int f=0;//f=>first
		int s=0;//s=>Second
		for(int i=0;i<arr.length;i++) {
			if(f<arr[i]) {
				s=f;
				f=arr[i];
			}else			
			if(arr[i]>s && arr[i]!=f) {
				s=arr[i];
			}
		}		
		return s;
	}
}
