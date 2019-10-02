package com.kristurek.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.kristurek.leetcode.common.ListNode;

public class Solution {

	public int[] _1_twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int search = target - nums[i];
			if (map.containsKey(search))
				return new int[] { map.get(search), i };
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No found");
	}

	public ListNode _2_addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;

		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;

			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;

			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	public int _3_lengthOfLongestSubstring(String s) {
		String max = "";
		String curr = "";

		for (int i = 0; i < s.length(); i++) {
			curr = Character.toString(s.charAt(i));

			for (int j = i + 1; j < s.length(); j++) {
				if (!curr.contains(Character.toString(s.charAt(j))))
					curr = curr + Character.toString(s.charAt(j));
				else
					break;
			}

			if (curr.length() > max.length())
				max = curr;
		}

		return max.length();
	}

	public double _4_findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];

		int i = 0, i1 = 0, i2 = 0;

		while (i1 < nums1.length && i2 < nums2.length) {
			if (nums1[i1] < nums2[i2])
				nums[i++] = nums1[i1++];
			else if (nums1[i1] > nums2[i2])
				nums[i++] = nums2[i2++];
			else
				nums[i++] = nums1[i1++];
		}

		if (i1 < nums1.length)
			while (i1 < nums1.length)
				nums[i++] = nums1[i1++];

		if (i2 < nums2.length)
			while (i2 < nums2.length)
				nums[i++] = nums2[i2++];

		if (nums.length % 2 != 0)
			return nums[nums.length / 2];
		else
			return ((double) (nums[(nums.length / 2) - 1] + nums[nums.length / 2])) / 2.0;
	}

	public int _7_reverse(int x) {
		boolean minus = false;
		if (x < 0) {
			minus = true;
			x = x * -1;
		}

		long reverseNumber = 0;
		long number = x;

		while (number > 0) {
			reverseNumber = reverseNumber * 10 + number % 10;
			number = number / 10;
		}

		if (reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE)
			return 0;

		if (minus)
			return (int) reverseNumber * -1;
		else
			return (int) reverseNumber;
	}

	public boolean _9_isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;

		long reverseNumber = 0;
		long number = x;

		while (number > 0) {
			reverseNumber = reverseNumber * 10 + number % 10;
			number = number / 10;
		}

		if (reverseNumber > Integer.MAX_VALUE || reverseNumber < Integer.MIN_VALUE)
			return false;

		return reverseNumber == x;
	}

	public int _11_maxArea(int[] height) {
		int max = 0;
		int l = 0, r = height.length - 1;

		while (l < r) {
			int area = (r - l) * Math.min(height[l], height[r]);
			if (area > max)
				max = area;

			if (height[l] <= height[r])
				l += 1;
			else
				r -= 1;
		}

		return max;
	}

	public String _12_intToRoman(int num) {
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

		StringBuilder roman = new StringBuilder();

		for (Entry<Integer, String> entry : map.entrySet()) {
			int mult = entry.getKey();
			String code = entry.getValue();

			for (int i = 0; i < num / mult; i++)
				roman.append(code);

			num = num % mult;
		}

		return roman.toString();
	}

	public int _13_romanToInt(String s) {
		if (s == null || s.isBlank())
			throw new IllegalArgumentException("Wrong input param");

		int sum = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int currentChar = _13_romanToInt_convert(s.charAt(i));
			int nextChar = _13_romanToInt_convert(s.charAt(i + 1));

			if (currentChar >= nextChar)
				sum += currentChar;
			else
				sum -= currentChar;
		}

		return sum + _13_romanToInt_convert(s.charAt(s.length() - 1));
	}

	private int _13_romanToInt_convert(Character c) {
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
}
