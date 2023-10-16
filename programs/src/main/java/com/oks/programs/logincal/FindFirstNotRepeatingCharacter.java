package com.oks.programs.logincal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFirstNotRepeatingCharacter {

	public static void main(String[] args) {
		char[] arr= {'A','C','H','E','F','C','D','D','A'};
		char ch=findFirstNotRepeatingCharByJava8(arr);
		
		System.out.println("findFirstNotRepeatingChar : "+ch);
		
		ch=findFirstNotRepeatingChar(arr);
		System.out.println("findFirstNotRepeatingChar : "+ch);
	}
	
	public static char findFirstNotRepeatingCharByJava8(char[] chArr) {
		Stream<Character> charStream=new String(chArr).chars().mapToObj(c->(char)c);// Converting char array to Character of Stream
		Map<Character, Long> chMap=charStream.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));//Counting the occurrence of character
		Character ch=chMap.entrySet().stream().filter(entry->entry.getValue()==1l).map(entry->entry.getKey()).findFirst().get();
		return ch;
	}
	
	public static char findFirstNotRepeatingChar(char[] arr) {
		int n=arr.length;
		
		for(int i=0;i<n;i++) {
			int j;
			for(j=0;j<n;j++) {
				if(i!=j && arr[i]==arr[j]) {
					break;
				}
			}
			if(j==n)
				return arr[i];
		}
		
		return ' ';
	}

}
