package com.oks.programs.logincal;

import java.util.Arrays;

//Q Find the String which has max number with it.
public class MaxNumStrFromAlphaNumericString {

	public static void main(String[] args) {
		String[] strAr={"a91","be2","pqr83","p137","s47t"};
		
		String strWithMaxNum=getMaxNumStr(strAr);
		
		System.out.println("String with Max Number is : "+strWithMaxNum);
		
	}
	
	public static String getMaxNumStr(String[] strArr) {		
		return Arrays.stream(strArr).max((x,y)->getStrValue(x).compareTo(getStrValue(y))).get();
	}	
	
	
	public static Integer getValue(String str) {
		char[] chr=str.toCharArray();
		int num=0;
		for(char ch:chr) {
			if(Character.isDigit(str.charAt(ch))) {
				num=num*10+ Integer.parseInt(ch+"");
			}
		}		
		return num;
	}
	
	public static Integer getStrValue(String str) {
		String s="";
		for(int i=0;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))) {
				s=s+str.charAt(i);
			}
		}
		return Integer.parseInt(s);
	}	
}
