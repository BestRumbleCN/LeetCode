package com.feixiang.loggestsubstring;

import java.util.HashSet;

/**
 * set 去重功能
 * @author Administrator
 *
 */
public class Solution {
	public static int lengthOfLongestSubstring(String s) {
//		char[] ch = s.toCharArray();
//		int length = 1;
//		for (int i = 0; i < ch.length; i++) {
//			if(ch.length-i <= length){
//				 break;
//			 }
//			int size = 1;
//			for (int j = i + 1; j < ch.length; j++) {
//				int flag = 0;
//				for(int k = i; k < j;k++){
//					if(ch[j] == ch[k]){
//						flag = 1;
//						i = k;
//					}
//				}
//				if (flag == 0) {
//					size++;
//					length = size > length ? size : length;
//				} else {
//					break;
//				}
//			}
//			 
//		}
//		return length;
		int strLength = s.length();
		int maxLength = 0;
		int walker = 0;
		int runner = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0 ;i < strLength ; i++){
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
			}else{
				maxLength = maxLength < runner - walker ? runner - walker : maxLength;
				while(s.charAt(walker) != s.charAt(runner)){
					set.remove(s.charAt(walker));
					walker ++;
				}
				walker ++;
			}
			runner ++;
		}
		maxLength = maxLength > runner - walker ? maxLength:runner - walker;
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("tmmzuxt"));
	}
}
