package com.kristurek.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

	public String _14_longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		String prefix = strs[0];
		for (String str : strs) {
			while (str.indexOf(prefix) != 0)
				prefix = prefix.substring(0, prefix.length() - 1);
		}

		return prefix;
	}

	public List<List<Integer>> _15_threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				if (nums[i] + nums[l] + nums[r] < 0)
					l++;
				else if (nums[i] + nums[l] + nums[r] > 0)
					r--;
				else {
					result.add(Arrays.asList(nums[i], nums[l], nums[r]));
					l++;
					r--;
				}
			}
		}

		return new ArrayList<>(result);
	}

	public int _16_threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];

				if (sum < target)
					l++;
				else if (sum > target)
					r--;
				else {
					return sum;
				}

				int diff = Math.abs(sum - target);
				if (diff < min) {
					min = diff;
					res = sum;
				}
			}
		}

		return res;
	}

	public List<String> _17_letterCombinations(String digits) {
		Map<Character, String> map = new HashMap<>();
		map.put('1', "");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		List<String> output = new LinkedList<String>();
		if (digits.length() > 0) {
			letterCombinations(output, digits, 0, "", map);
		}
		return output;
	}

	private void letterCombinations(List<String> output, String digits, int i, String current,
			Map<Character, String> map) {
		if (i == digits.length()) {
			output.add(current);
		} else {
			String chars = map.get(digits.charAt(i));
			for (char c : chars.toCharArray()) {
				letterCombinations(output, digits, i + 1, current + c, map);
			}
		}
	}

	public ListNode _19_removeNthFromEnd(ListNode head, int n) {
		ListNode current = head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		int length = 0;

		while (current != null) {
			length++;
			current = current.next;
		}

		length = length - n;
		current = dummy;

		while (length > 0) {
			length--;
			current = current.next;
		}

		current.next = current.next.next;

		return dummy.next;
	}

	public boolean _20_isValid(String s) {
		Deque<Character> queue = new LinkedList<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[')
				queue.addLast(c);
			else if (c == ')' && queue.peekLast() == '(') {
				queue.removeLast();
			} else if (c == '}' && queue.peekLast() == '{') {
				queue.removeLast();
			} else if (c == ']' && queue.peekLast() == '[') {
				queue.removeLast();
			} else
				return false;
		}

		return queue.isEmpty();
	}

	public ListNode _21_mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode current = new ListNode(-1);
		ListNode head = current;

		ListNode cl1 = l1;
		ListNode cl2 = l2;

		while (cl1 != null && cl2 != null) {
			if (cl1.val < cl2.val) {
				current.next = cl1;

				cl1 = cl1.next;
				current = current.next;
			} else if (cl1.val > cl2.val) {
				current.next = cl2;

				cl2 = cl2.next;
				current = current.next;
			} else {
				current.next = cl1;

				cl1 = cl1.next;
				current = current.next;

				current.next = cl2;

				cl2 = cl2.next;
				current = current.next;
			}
		}

		if (cl1 != null)
			current.next = cl1;

		if (cl2 != null)
			current.next = cl2;

		return head.next;
	}

	public List<String> _22_generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();

		generateParenthesis(result, "", 0, n, n);

		return result;
	}

	private void generateParenthesis(List<String> result, String tmp, int c, int l, int r) {
		if (l == 0 && r == 0) {
			result.add(tmp);
			return;
		}

		if (r > 0 && c > 0)
			generateParenthesis(result, tmp + ")", c - 1, l, r - 1);
		if (l > 0)
			generateParenthesis(result, tmp + "(", c + 1, l - 1, r);
	}
}
