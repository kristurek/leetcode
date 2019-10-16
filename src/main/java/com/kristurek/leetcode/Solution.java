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

	public ListNode _23_mergeKLists(ListNode[] lists) {
		return _23_mergeKLists_divide(lists, 0, lists.length - 1);
	}

	private ListNode _23_mergeKLists_divide(ListNode[] ln, int l, int r) {
		if (l == r)
			return ln[l];
		if (l < r) {
			int m = l + (r - r) / 2;
			ListNode l1 = _23_mergeKLists_divide(ln, l, m);
			ListNode l2 = _23_mergeKLists_divide(ln, m + 1, r);
			return _23_mergeKLists_merge(l1, l2);
		} else
			return null;
	}

	private ListNode _23_mergeKLists_merge(ListNode ln1, ListNode ln2) {
		ListNode head = new ListNode(-1);
		ListNode current = head;

		while (ln1 != null && ln2 != null) {
			if (ln1.val < ln2.val) {
				current.next = ln1;

				current = current.next;
				ln1 = ln1.next;
			} else if (ln1.val > ln2.val) {
				current.next = ln2;

				current = current.next;
				ln2 = ln2.next;
			} else {
				current.next = ln1;

				current = current.next;
				ln1 = ln1.next;
			}
		}

		if (ln1 != null)
			current.next = ln1;
		if (ln2 != null)
			current.next = ln2;

		return head.next;
	}

	public ListNode _24_swapPairs(ListNode head) {
		ListNode newHead = new ListNode(-1);
		ListNode newCurrent = newHead;

		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode previous = head;
		ListNode current = head.next;

		while (previous != null && current != null) {
			ListNode tmp = current.next;

			newCurrent.next = current;
			newCurrent = newCurrent.next;
			newCurrent.next = previous;
			newCurrent = newCurrent.next;

			previous = tmp;
			current = (tmp != null) ? tmp.next : null;
		}

		return newHead.next;
	}

	public int _26_removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;

		int i = 1;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[j - 1])
				nums[i++] = nums[j];
		}

		return i;
	}

	public int _27_removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;

		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i++] = nums[j];
			}
		}

		return i;
	}

	public int _28_strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			throw new IllegalArgumentException("No null value allowed");
		if (needle.length() == 0)
			return 0;

		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(j))
				j++;
			else {
				if (j != 0)
					i = i - j;
				j = 0;
			}

			if (j == needle.length())
				return i - needle.length() + 1;
		}

		return -1;
	}

	public int _33_search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int l = 0;
		int r = nums.length - 1;

		while (l < r) {
			int m = l + (r - l) / 2;
			if (nums[m] > nums[r]) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		int s = l;
		l = 0;
		r = nums.length - 1;
		if (target >= nums[s] && target <= nums[r])
			l = s;
		else
			r = s;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if (nums[m] == target)
				return m;
			else if (nums[m] > target)
				r = m - 1;
			else
				l = m + 1;
		}

		return -1;
	}

	public int[] _34_searchRange(int[] nums, int target) {
		int l = _34_searchRange(nums, target, true);
		int r = _34_searchRange(nums, target, false);
		return new int[] { l, r };
	}

	private int _34_searchRange(int[] nums, int target, boolean left) {
		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if (target > nums[m])
				l = m + 1;
			else if (target < nums[m])
				r = m - 1;
			else {
				if (left) {
					if (m == 0 || nums[m - 1] != target)
						return m;
					else
						r = m - 1;
				} else {
					if (m >= nums.length - 1 || nums[m + 1] != target)
						return m;
					else
						l = m + 1;
				}
			}
		}

		return -1;
	}

	public int _35_searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if (target > nums[m])
				l = m + 1;
			else if (target < nums[m])
				r = m - 1;
			else
				return m;
		}
		return l;
	}

	public boolean _36_isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<>();

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				char val = board[row][col];
				if (val != '.') {
					int cube = (row / 3 * 3) + (col / 3);
					if (set.contains("r" + row + val) || set.contains("c" + col + val)
							|| set.contains("b" + cube + val))
						return false;
					else {
						set.add("r" + row + val);
						set.add("c" + col + val);
						set.add("b" + cube + val);
					}
				}
			}
		}

		return true;
	}

	public List<List<Integer>> _78_subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		_78_subsets_backtracking(results, new ArrayList<Integer>(), 0, nums);

		return results;
	}

	private void _78_subsets_backtracking(List<List<Integer>> results, List<Integer> tmpResult, int from, int[] nums) {
		results.add(new ArrayList<>(tmpResult));

		for (int i = from; i < nums.length; i++) {
			tmpResult.add(nums[i]);
			_78_subsets_backtracking(results, tmpResult, i + 1, nums);
			tmpResult.remove(tmpResult.size() - 1);
		}
	}

	public List<List<Integer>> _90_subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		Arrays.sort(nums);

		_90_subsetsWithDup_backtracking(results, new ArrayList<Integer>(), 0, nums);

		return results;
	}

	private void _90_subsetsWithDup_backtracking(List<List<Integer>> results, List<Integer> tmpResult, int from,
			int[] nums) {
		results.add(new ArrayList<>(tmpResult));

		for (int i = from; i < nums.length; i++) {
			if (i > from && nums[i] == nums[i - 1])
				continue;

			tmpResult.add(nums[i]);
			_90_subsetsWithDup_backtracking(results, tmpResult, i + 1, nums);
			tmpResult.remove(tmpResult.size() - 1);
		}
	}

	public List<List<Integer>> _46_permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		_46_permute_backtracking(results, new ArrayList<>(), nums);

		return results;
	}

	private void _46_permute_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums) {
		if (tmpList.size() == nums.length)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (tmpList.contains(nums[i]))
					continue;

				tmpList.add(nums[i]);
				_46_permute_backtracking(results, tmpList, nums);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public List<List<Integer>> _47_permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		_47_permuteUnique_backtracking(results, new ArrayList<>(), nums, new boolean[nums.length]);

		return results;
	}

	private void _47_permuteUnique_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums,
			boolean[] used) {
		if (tmpList.size() == nums.length)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
					continue;

				tmpList.add(nums[i]);
				used[i] = true;
				_47_permuteUnique_backtracking(results, tmpList, nums, used);
				tmpList.remove(tmpList.size() - 1);
				used[i] = false;
			}
		}
	}

	public List<List<Integer>> _39_combinationSum(int[] candidates, int target) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		_39_combinationSum_backtracking(results, new ArrayList<>(), candidates, target, 0);

		return results;
	}

	private void _39_combinationSum_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums,
			int remained, int from) {
		if (remained < 0)
			return;
		else if (remained == 0)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = from; i < nums.length; i++) {
				tmpList.add(nums[i]);
				_39_combinationSum_backtracking(results, tmpList, nums, remained - nums[i], i);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public List<List<Integer>> _40_combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		Arrays.sort(candidates);

		_40_combinationSum2_backtracking(results, new ArrayList<>(), candidates, target, 0);

		return results;
	}

	private void _40_combinationSum2_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums,
			int remained, int from) {
		if (remained < 0)
			return;
		else if (remained == 0)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = from; i < nums.length; i++) {
				if (i > from && nums[i] == nums[i - 1])
					continue;

				tmpList.add(nums[i]);
				_40_combinationSum2_backtracking(results, tmpList, nums, remained - nums[i], i + 1);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public List<List<String>> _131_partition(String s) {
		List<List<String>> list = new ArrayList<>();
		_131_partition_backtracking(list, new ArrayList<>(), s, 0);
		return list;
	}

	private void _131_partition_backtracking(List<List<String>> list, List<String> tempList, String s, int start) {
		if (start == s.length())
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < s.length(); i++) {
				if (_131_partition_isPalindrome(s, start, i)) {
					tempList.add(s.substring(start, i + 1));
					_131_partition_backtracking(list, tempList, s, i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

	private boolean _131_partition_isPalindrome(String s, int low, int high) {
		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}

	public int _41_firstMissingPositive(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int index = nums[start] - 1;
			if (index == start)
				start++;
			else if (index < 0 || index > end || nums[start] == nums[index])
				nums[start] = nums[end--];
			else {
				nums[start] = nums[index];
				nums[index] = index + 1;
			}
		}
		return start + 1;
	}

	public int _42_trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int count = 0;

		while (left < right) {

			if (height[left] < height[right]) {
				if (height[left] >= leftMax)
					leftMax = height[left];
				else
					count += (leftMax - height[left]);
				++left;
			} else {
				if (height[right] >= rightMax)
					rightMax = height[right];
				else
					count += (rightMax - height[right]);
				--right;
			}
		}
		return count;
	}

	public String _43_multiply(String num1, String num2) {

		int[] muls = new int[num1.length() + num2.length()];

		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int val1 = Integer.parseInt(Character.toString(num1.charAt(i)));
				int val2 = Integer.parseInt(Character.toString(num2.charAt(j)));

				int index = num1.length() + num2.length() - i - j - 2;
				muls[index] += val1 * val2;
				muls[index + 1] += muls[index] / 10;
				muls[index] %= 10;
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = muls.length - 1; i > 0; i--) {
			if (stringBuilder.length() == 0 && muls[i] == 0)
				continue;
			stringBuilder.append(muls[i]);
		}
		stringBuilder.append(muls[0]);
		return stringBuilder.toString();
	}

	public boolean _44_isMatch(String str, String pattern) {
		int s = 0, p = 0, starMatch = 0, starId = -1;
		while (s < str.length()) {
			if (p < pattern.length() && str.charAt(s) == pattern.charAt(p)) {
				s++;
				p++;
			} else if (p < pattern.length() && (pattern.charAt(p) == '?') || str.charAt(s) == pattern.charAt(p)) {
				s++;
				p++;
			} else if (p < pattern.length() && pattern.charAt(p) == '*') {
				starId = p;
				starMatch = s;
				p++;
			}
			// last pattern pointer was *, advancing string pointer
			else if (starId != -1) {
				p = starId + 1;
				starMatch++;
				s = starMatch;
			}
			// current pattern pointer is not star, last patter pointer was not *
			// characters do not match
			else
				return false;
		}

		// check for remaining characters in pattern
		while (p < pattern.length() && pattern.charAt(p) == '*')
			p++;

		return p == pattern.length();
	}

	public int _45_jump(int[] nums) { // Misunderstanding - modify question
		List<Integer> results = new ArrayList<>();

		_45_jump_backtracking(results, new ArrayList<Integer>(), 0, nums);

		return results.size();
	}

	private void _45_jump_backtracking(List<Integer> result, List<Integer> tmpResult, int from, int[] nums) {
		if (_45_jump_sum(tmpResult) == nums.length) {

			if (result.isEmpty())
				result.addAll(new ArrayList<>(tmpResult));
			else {
				if (tmpResult.size() > 0 && tmpResult.size() < result.size()) {
					result.clear();
					result.addAll(new ArrayList<>(tmpResult));
				}
			}
		}

		for (int i = from; i < nums.length; i++) {
			tmpResult.add(nums[i]);
			_45_jump_backtracking(result, tmpResult, i + 1, nums);
			tmpResult.remove(tmpResult.size() - 1);
		}
	}

	private int _45_jump_sum(List<Integer> results) {
		if (results.isEmpty())
			return -1;

		int sum = 0;
		for (Integer val : results)
			sum += val;
		return (sum + 1);
	}

	public void _48_rotate(int[][] matrix) {// ccw
		int n = matrix.length;

		// NOTE: i and j from 0 to n/2 is a quadrant
		for (int i = 0; i < n / 2; i++) {
			// NOTE : here + 1 is added to make it work when n is odd
			for (int j = 0; j < (n + 1) / 2; j++) {
				int r_i = (n - 1) - i;
				int r_j = (n - 1) - j;

				// corners a, b, c, d
				_48_rotate_rotate90(i, j, r_j, i, r_i, r_j, j, r_i, matrix);
			}
		}
	}

	private void _48_rotate_rotate90(int ai, int aj, int bi, int bj, int ci, int cj, int di, int dj, int[][] matrix) {
		_48_rotate_swap(ai, aj, bi, bj, matrix);
		_48_rotate_swap(bi, bj, ci, cj, matrix);
		_48_rotate_swap(ci, cj, di, dj, matrix);
	}

	private void _48_rotate_swap(int ai, int aj, int bi, int bj, int[][] matrix) {
		int tmp = matrix[ai][aj];
		matrix[ai][aj] = matrix[bi][bj];
		matrix[bi][bj] = tmp;
	}

	public double _50_myPow(double x, int n) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		int nSign = n < 0 ? -1 : 1;
		n = Math.abs(n);

		double result = _50_myPow(x, n / 2);

		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;

		result *= result;
		if (n % 2 != 0) {
			result *= x;
		}

		return nSign < 0 ? 1 / result : result;
	}

	public int _53_maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (sum < 0)
				sum = nums[i];
			else
				sum += nums[i];

			if (sum > max)
				max = sum;
		}

		return max;
	}

	public List<Integer> _54_spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();

		if (matrix.length == 0) {
			return res;
		}

		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for (int j = colBegin; j <= colEnd; j++) {
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;

			for (int j = rowBegin; j <= rowEnd; j++) {
				res.add(matrix[j][colEnd]);
			}
			colEnd--;

//			if (rowBegin <= rowEnd) {
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
	//		}
			rowEnd--;

		//	if (colBegin <= colEnd) {
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			//}
			colBegin++;
		}

		return res;
	}
}
