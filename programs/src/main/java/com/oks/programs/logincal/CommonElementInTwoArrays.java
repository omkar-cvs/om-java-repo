package com.oks.programs.logincal;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonElementInTwoArrays {
	public static void main(String[] args) {
		Integer[] ar1=new Integer[] {1,2,3,4,5};
		Integer[] ar2=new Integer[] {3,4,5,6,7};
		
		Set<Integer> commonElements=commonNumOfTwoArray(ar1,ar2);
		System.out.println("Common Elements : "+commonElements);
	}
	
	public static Set<Integer> commonNumOfTwoArray(Integer[] arr1,Integer[] arr2)
	{
		Set<Integer> s1=Arrays.asList(arr1).stream().collect(Collectors.toSet());
		Set<Integer> s2=Arrays.asList(arr2).stream().collect(Collectors.toSet());
	    s1.retainAll(s2);
		return s1;
	}
}
