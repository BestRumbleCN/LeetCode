package com.feixiang.addtwonums;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list. Input: (2 -> 4 ->
 * 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode index1 = l1;
		ListNode index2 = l2;
		ListNode result = new ListNode(0);
		ListNode resultIndex = result;
		int carry = 0;
		while (index1 != null || index2 != null || carry == 1) {
			int val1 = 0, val2 = 0;
			if (index1 != null) {
				val1 = index1.val;
				index1 = index1.next;
			}
			if (index2 != null) {
				val2 = index2.val;
				index2 = index2.next;
			}
			int count = val1 + val2 + carry;
			if (count >= 10) {
				resultIndex.val = count - 10;
				carry = 1;
			} else {
				resultIndex.val = count;
				carry = 0;
			}
			if (index1 != null || index2 != null || carry == 1) {
				resultIndex.next = new ListNode(0);
				resultIndex = resultIndex.next;
			}
		}

		return result;
	}
	
	public static ListNode numToListNode(int num){
		ListNode result = new ListNode(num%10);
		ListNode index = result;
		int div = 10;
		int left = num/10;
		while(left > 0){
			index.next = new ListNode(left%10);
			index = index.next;
			left= left/10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode n1 = numToListNode(5);
		ListNode n2 = numToListNode(5);
		ListNode result = addTwoNumbers(n1,n2);
		System.out.println(result);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
