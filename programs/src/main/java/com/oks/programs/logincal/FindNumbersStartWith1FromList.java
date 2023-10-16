package com.oks.programs.logincal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindNumbersStartWith1FromList {

	public static void main(String[] args) {
		int[] ar= {25,11,13,21,15,212,18,321,19};
		List<Integer> listStartWith1=getListStartWith1(ar);
		
		System.out.println("List of number starts with 1 are : "+listStartWith1);
	}
	public static List<Integer> getListStartWith1(int[] arr){		
		return Arrays.stream(arr).boxed().filter((n)->n.toString().startsWith("1")).collect(Collectors.toList());
	}
}
