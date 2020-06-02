package com.kristurek.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.IntStream;

import com.kristurek.leetcode.common.ListNode;

public class Solution2 {

	public int[] _1_twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int search = target - nums[i];
			if (map.containsKey(search))
				return IntStream.of(i, map.get(search)).toArray();

			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No found solution, check input params");
	}

	public int _7_reverse(int x) {
		boolean minus = x < 0 ? true : false;
		x = Math.abs(x);
		int number = 0;

		while (x > 0) {
			number = number * 10 + x % 10;
			x = x / 10;
		}

		if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE)
			return 0;

		return minus ? number * -1 : number;
	}

	public boolean _9_isPalindrome(int x) {
		if (x < 0)
			return false;

		int reverse = 0;
		int number = x;

		while (x > 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}

		if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
			return false;

		return reverse == number ? true : false;
	}

	public int _13_romanToInt(String s) {
		if (s == null || s.isBlank())
			return 0;

		int number = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			int currentNumber = _13_romanToInt_convert(s.charAt(i));
			int nextNumber = _13_romanToInt_convert(s.charAt(i + 1));

			if (currentNumber < nextNumber)
				number -= currentNumber;
			else
				number += currentNumber;
		}

		return number + _13_romanToInt_convert(s.charAt(s.length() - 1));
	}

	private int _13_romanToInt_convert(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new IllegalArgumentException("Unsupported char");
		}
	}

	public String _14_longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return null;

		String longestPrefix = strs[0];

		for (String str : strs)
			while (str.indexOf(longestPrefix) != 0)
				longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);

		return longestPrefix;
	}

	public boolean _20_isValid(String s) {
		Deque<Character> stack = new LinkedList<>();

		for (char c : s.toCharArray())
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else if (c == ')' && stack.peek() == '(')
				stack.pop();
			else if (c == ']' && stack.peek() == '[')
				stack.pop();
			else if (c == '}' && stack.peek() == '{')
				stack.pop();

		return stack.isEmpty();
	}

	public ListNode _21_mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(-1);
		ListNode head = l3;

		while (l1 != null && l2 != null)
			if (l1.val < l2.val) {
				l3.next = l1;

				l3 = l3.next;
				l1 = l1.next;
			} else {
				l3.next = l2;

				l3 = l3.next;
				l2 = l2.next;
			}

		if (l1 != null)
			l3.next = l1;

		if (l2 != null)
			l3.next = l2;

		return head.next;
	}

	public int _26_removeDuplicates(int[] nums) {
		int slow = 0;

		for (int fast = 0; fast < nums.length; fast++)
			if (nums[slow] != nums[fast])
				nums[++slow] = nums[fast];

		return slow + 1;
	}

	public int _27_removeElement(int[] nums, int val) {
		int slow = 0;

		for (int fast = 0; fast < nums.length; fast++)
			if (nums[fast] != val)
				nums[slow++] = nums[fast];

		return slow;
	}

	public int _28_strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			throw new IllegalArgumentException("No null value allowed");
		if (needle.length() == 0)
			return 0;

		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				j++;

				if (j == needle.length())
					return i - needle.length() + 1;
			} else {
				i = j > 0 ? i - j : i;
				j = 0;
			}
		}

		return -1;
	}
}
