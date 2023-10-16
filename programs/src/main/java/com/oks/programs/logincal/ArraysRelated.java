package com.oks.programs.logincal;

public class ArraysRelated {
	
	public static void main(String[] args) {
		//int arr1= {1,2,3,4,5,3,5} ;
		//int arr2= {};
		
		
		int[] a = { 1, 2, 3, 4, 5, 6 };
		//roatedArray(a,6);
		evenOddSeperationInSingleArray(a);
	}
	public static void roatedArray(int[] a, int numberOfRoatation) {
		
		//int[] a = { 1, 2, 3, 4, 5, 6 };
		
		
		showArrayData(a);
		for (int j = 0; j < numberOfRoatation; j++) {
			for (int i = 0; i < a.length - 1; i++) {
				int t = a[i];
				a[i] = a[i + 1];
				a[i + 1] = t;
			}
		}
		System.out.println();
		showArrayData(a);
	}
	
	public static void evenOddSeperationInSingleArray(int[] arr) {
		
		int left=0;
		int right=arr.length-1;
		for(int i=0;i<arr.length;i++) {
			
			while(arr[left]%2==0) {
				left++;
			}
			
			while(arr[right]%2==1) {
				right--;
			}
			
			if(left<right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
			}
		}
		showArrayData(arr);
		
	}
	
	public static void showArrayData(int[] arr) {
		for(int n:arr) {
			System.out.println(n);
		}
	}

	//Fint the common elements in two arrays
	public static int[] commonElementInTwoArray(int[] arr1,int[] arr2) {
		
		
		
		return null;
	}
	
}