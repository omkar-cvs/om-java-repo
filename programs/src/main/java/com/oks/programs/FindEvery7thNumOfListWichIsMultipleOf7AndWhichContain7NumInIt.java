package com.oks.programs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvery7thNumOfListWichIsMultipleOf7AndWhichContain7NumInIt {
	
	public static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,
										 8,9,10,11,12,13,77,
										 15,16,17,18,19,20,70,
										 22,23,24,25,26,27,28,
										 29);
		int n=7;
		
		List<Integer> resultList=getListData(list,n);
		resultList.forEach(System.out::println);
		

	}
	
	public static List<Integer> getListData(List<Integer> list,int n){
		
		Predicate<Integer> p2=(num)->num%n==0;
		Predicate<Integer> p3=(num)->{
							boolean flag=false;
							while(num>0) {
								if(num%10==n) {
									flag=true;
									break;					
								}
								num/=10;
							}							
							return flag;
						};
						
						
		
		return IntStream.range(0, list.size()).filter(i->i%n ==(n-1))
											  .mapToObj(list::get)
				                              .filter(p2)
				                              .filter(p3)
				                              .collect(Collectors.toList());
		
	}

}
