package com.oks.programs.logincal;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

//Getting the Mejority Element
public class FindHighFrequencyNumberFromIntArray {

	public static void main(String[] args) {
		/*  Find out the maximum occurrence of number from the array
		 *  here 3 comes 4 times
		 *  so answer is :3
		 */
		int[] ar= {1,2,2,3,3,3,4,4,4,3};
		
		Entry<Integer,Long> entry=getMegjorityElement(ar); 
		System.out.println(entry.getKey()+" : "+entry.getValue());
	}

	public static Entry<Integer,Long> getMegjorityElement(int[] arr){
		return Arrays.stream(arr).boxed()
			      .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			      .entrySet()
			      .stream()
			      .reduce((x,y)->x.getValue()>y.getValue()?x:y)
			      .get();
	}
}
