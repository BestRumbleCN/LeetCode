package com.feixiang.loggestsubstring;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		char[] ch = s.toCharArray();
		int length = 1;
		for (int i = 0; i < ch.length; i++) {
			if(ch.length-i <= length){
				 break;
			 }
			int size = 1;
			for (int j = i + 1; j < ch.length; j++) {
				int flag = 0;
				for(int k = i; k < j;k++){
					if(ch[j] == ch[k]){
						flag = 1;
						i = k;
					}
				}
				if (flag == 0) {
					size++;
					length = size > length ? size : length;
				} else {
					break;
				}
			}
			 
		}
		return length;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabc"));
	}
}
