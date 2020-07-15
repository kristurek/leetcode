package com.kristurek.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.kristurek.leetcode.common.Employee;
import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.Node;
import com.kristurek.leetcode.common.Node2;
import com.kristurek.leetcode.common.TreeNode;

public class Solution {

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

    public ListNode _2_addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode l3 = new ListNode(-1);
	ListNode head = l3;
	int carry = 0;

	while (l1 != null || l2 != null) {
	    int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;

	    l3.next = new ListNode(sum % 10);
	    carry = sum / 10;

	    if (l1 != null)
		l1 = l1.next;
	    if (l2 != null)
		l2 = l2.next;
	    l3 = l3.next;
	}

	if (carry != 0)
	    l3.next = new ListNode(carry);

	return head.next;
    }

    public int _3_lengthOfLongestSubstring(String s) {
	String maxSub = "";
	String currentSub = "";

	for (int slow = 0; slow < s.length(); slow++) {
	    currentSub = String.valueOf(s.charAt(slow));

	    for (int fast = slow + 1; fast < s.length(); fast++)
		if (!currentSub.contains(String.valueOf(s.charAt(fast))))
		    currentSub += String.valueOf(s.charAt(fast));
		else
		    break;

	    if (currentSub.length() > maxSub.length())
		maxSub = currentSub;
	}

	return maxSub.length();
    }

    public int _3_lengthOfLongestSubstring_v2(String s) {
	if (s.length() == 1)
	    return 1;

	Queue<Character> chars = new LinkedList<>();
	int max = 0;

	for (int i = 0; i < s.length(); i++) {
	    if (!chars.contains(s.charAt(i))) {
		chars.add(s.charAt(i));
		max = Math.max(max, chars.size());
	    } else {
		while (chars.contains(s.charAt(i)))
		    chars.poll();
		chars.add(s.charAt(i));
	    }
	}

	return max;
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

    public String _5_longestPalindrome(String s) {
	if (s == null || s.isEmpty())
	    return s;

	String max = s.substring(0, 1);

	for (int i = 0; i < s.length(); i++) {

	    // get longest palindrome with center of i
	    String tmp = _5_longestPalindrome_findPalindromeByExtend(s, i, i);// odd
	    if (tmp.length() > max.length())
		max = tmp;

	    // get longest palindrome with center of i, i+1
	    tmp = _5_longestPalindrome_findPalindromeByExtend(s, i, i + 1);// even
	    if (tmp.length() > max.length())
		max = tmp;
	}
	return max;
    }

    private String _5_longestPalindrome_findPalindromeByExtend(String s, int begin, int end) {
	while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
	    begin--;
	    end++;
	}

	return s.substring(begin + 1, end);
    }

    public int _7_reverse(int x) {
	boolean minus = x < 0 ? true : false;
	x = Math.abs(x);
	long number = 0;

	while (x > 0) {
	    number = number * 10 + x % 10;
	    x = x / 10;
	}

	if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE)
	    return 0;

	return minus ? (int) number * -1 : (int) number;
    }

    public boolean _9_isPalindrome(int x) {
	if (x < 0)
	    return false;

	long reverse = 0;
	long number = x;

	while (x > 0) {
	    reverse = reverse * 10 + x % 10;
	    x = x / 10;
	}

	if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
	    return false;

	return reverse == number ? true : false;
    }

    public int _11_maxArea(int[] height) {
	int l = 0;
	int h = height.length - 1;
	int max = Integer.MIN_VALUE;

	while (l < h) {
	    int area = Math.min(height[l], height[h]) * (h - l);
	    max = Math.max(max, area);

	    if (height[l] <= height[h])
		l++;
	    else
		h--;
	}

	return max;
    }

    public String _12_intToRoman(int num) {
	Map<Integer, String> map = new LinkedHashMap<>(); // remember order
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

	for (Map.Entry<Integer, String> entry : map.entrySet()) {
	    while (num >= entry.getKey()) { // multiple append the same char, 3 will be I I I
		roman.append(entry.getValue());
		num = num - entry.getKey();
	    }
	}

	return roman.toString();
    }

    public String _12_intToRoman_v2(int num) {
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
	if (strs == null)
	    return null;
	if (strs.length == 0)
	    return "";

	String longestPrefix = strs[0];

	for (String str : strs)
	    while (str.indexOf(longestPrefix) != 0)
		longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);

	return longestPrefix;
    }

    public List<List<Integer>> _15_threeSum(int[] nums) {
	Set<List<Integer>> groups = new HashSet<>();

	Arrays.sort(nums);

	for (int i = 0; i < nums.length; i++) {
	    int l = i + 1;
	    int h = nums.length - 1;

	    while (l < h)
		if (nums[i] + nums[l] + nums[h] < 0)
		    l++;
		else if (nums[i] + nums[l] + nums[h] > 0)
		    h--;
		else
		    groups.add(Stream.of(nums[i], nums[l++], nums[h--]).collect(Collectors.toList()));
	}

	return new ArrayList<>(groups);
    }

    public List<List<Integer>> _15_threeSum_v2(int[] nums) {
	Set<List<Integer>> groups = new HashSet<>();

	Arrays.sort(nums);

	_15_threeSum_v2_backtracking(groups, new ArrayList<>(), nums, 0);

	return new ArrayList<>(groups);
    }

    private void _15_threeSum_v2_backtracking(Set<List<Integer>> output, List<Integer> tmp, int[] nums, int from) {
	if (tmp.size() == 3) {
	    if (tmp.stream().mapToInt(i -> i).sum() == 0)
		output.add(new ArrayList<>(tmp));
	} else {
	    for (int i = from; i < nums.length; i++) {
		tmp.add(nums[i]);
		_15_threeSum_v2_backtracking(output, tmp, nums, i + 1);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public int _16_threeSumClosest(int[] nums, int target) {
	int closetSum = Integer.MAX_VALUE;
	int minDiff = Integer.MAX_VALUE;

	Arrays.sort(nums);

	for (int i = 0; i < nums.length; i++) {
	    int l = i + 1;
	    int h = nums.length - 1;

	    while (l < h) {
		int sum = nums[i] + nums[l] + nums[h];

		if (Math.abs(target - sum) < minDiff) {
		    closetSum = sum;
		    minDiff = Math.abs(target - sum);
		}

		if (sum > target)
		    h--;
		else if (sum < target)
		    l++;
		else
		    return sum;
	    }
	}

	return closetSum;
    }

    public List<String> _17_letterCombinations(String digits) {
	Map<Character, List<Character>> map = new HashMap<>();
	map.put('1', Arrays.asList());
	map.put('2', Arrays.asList('a', 'b', 'c'));
	map.put('3', Arrays.asList('d', 'e', 'f'));
	map.put('4', Arrays.asList('g', 'h', 'i'));
	map.put('5', Arrays.asList('j', 'k', 'l'));
	map.put('6', Arrays.asList('m', 'n', 'o'));
	map.put('7', Arrays.asList('p', 'q', 'r', 's'));
	map.put('8', Arrays.asList('t', 'u', 'v'));
	map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
	map.put('0', Arrays.asList());

	List<String> output = new ArrayList<>();
	if (digits.length() > 0)
	    _17_letterCombinations_backtracking(output, new ArrayList<>(), digits.toCharArray(), 0, map);

	return output;
    }

    private void _17_letterCombinations_backtracking(List<String> output, List<Character> tmp, char[] digits,
	    int digitsIndex, Map<Character, List<Character>> map) {
	if (tmp.size() == digits.length)
	    output.add(tmp.stream().map(String::valueOf).collect(Collectors.joining()));
	else {
	    for (char cChar : map.get(digits[digitsIndex])) {
		tmp.add(cChar);
		_17_letterCombinations_backtracking(output, tmp, digits, digitsIndex + 1, map);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public List<String> _17_letterCombinations_v2(String digits) {
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

    public List<List<Integer>> _18_fourSum(int[] nums, int target) {// FIXME Time Limit Exceeded
	Set<List<Integer>> groups = new HashSet<>();

	Arrays.sort(nums);

	_18_fourSum_backtracking(groups, new ArrayList<>(), nums, 0, target);

	return new ArrayList<>(groups);
    }

    private void _18_fourSum_backtracking(Set<List<Integer>> output, List<Integer> tmp, int[] nums, int from,
	    int target) {
	if (tmp.size() == 4) {
	    if (tmp.stream().mapToInt(i -> i).sum() == target)
		output.add(new ArrayList<>(tmp));
	} else {
	    for (int i = from; i < nums.length; i++) {
		tmp.add(nums[i]);
		_18_fourSum_backtracking(output, tmp, nums, i + 1, target);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public ListNode _19_removeNthFromEnd(ListNode head, int n) {
	ListNode current = head;
	List<ListNode> list = new ArrayList<>();

	while (current != null) {
	    list.add(current);
	    current = current.next;
	}

	if (list.size() == n)
	    return head.next;
	else {
	    ListNode ln = list.get(list.size() - n - 1);

	    ln.next = ln.next.next;

	    return head;
	}
    }

    public ListNode _19_removeNthFromEnd_v2(ListNode head, int n) {
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
	Deque<Character> stack = new LinkedList<>();

	for (char c : s.toCharArray())
	    if (c == '(' || c == '[' || c == '{')
		stack.push(c);
	    else if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
		stack.pop();
	    else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
		stack.pop();
	    else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
		stack.pop();
	    else
		return false;

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

    public List<String> _22_generateParenthesis(int n) {
	List<String> output = new ArrayList<>();

	_22_generateParenthesis_backtracking(output, "", 0, 0, n);

	return output;
    }

    private void _22_generateParenthesis_backtracking(List<String> output, String tmp, int open, int close, int n) {
	if (tmp.length() == n * 2)
	    output.add(tmp);
	else {
	    if (open >= close) {
		if (open < n)
		    _22_generateParenthesis_backtracking(output, tmp + "(", open + 1, close, n);
		if (close < n)
		    _22_generateParenthesis_backtracking(output, tmp + ")", open, close + 1, n);
	    }
	}
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
	if (head == null)
	    return null;
	else {
	    if (head.next == null)
		return head;
	    else {
		// Remember pointer to third node
		ListNode next = head.next.next;

		// Swap two pointer
		ListNode tmp = head;
		head = head.next;
		head.next = tmp;

		head.next.next = _24_swapPairs(next);

		return head;
	    }
	}
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

    public int _33_search(int[] nums, int target) {
	if (nums == null || nums.length == 0)
	    return -1;

	int l = 0;
	int h = nums.length - 1;

	while (l < h) {
	    int m = l + (h - l) / 2;

	    if (nums[m] > nums[h])
		l = m + 1;
	    else
		h = m;
	}

	int p = l;// pivot - lowest elemnt
	l = 0;
	h = nums.length - 1;

	if (target >= nums[p] && target <= nums[h])
	    l = p;
	else
	    h = p - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;

	    if (nums[m] > target)
		h = m - 1;
	    else if (nums[m] < target)
		l = m + 1;
	    else
		return m;

	}

	return -1;
    }

    public int[] _34_searchRange(int[] nums, int target) {
	int l = _34_searchRange_search(nums, target, true);
	int r = _34_searchRange_search(nums, target, false);

	return new int[] { l, r };
    }

    private int _34_searchRange_search(int[] nums, int target, boolean left) {
	int l = 0;
	int h = nums.length - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;
	    if (nums[m] < target)
		l = m + 1;
	    else if (nums[m] > target)
		h = m - 1;
	    else {
		if (left) {
		    if (m > 0 && nums[m - 1] == target)
			h = m - 1;
		    else
			return m;
		} else {

		    if (m < nums.length - 1 && nums[m + 1] == target)
			l = m + 1;
		    else
			return m;
		}
	    }
	}

	return -1;
    }

    public int _35_searchInsert(int[] nums, int target) {
	int l = 0;
	int h = nums.length - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;

	    if (nums[m] < target) {
		l = m + 1;
	    } else if (nums[m] > target) {
		h = m - 1;
	    } else
		return m;
	}

	return l;
    }

    public boolean _36_isValidSudoku(char[][] board) {
	Set<String> set = new HashSet<>();

	for (int row = 0; row < board.length; row++)
	    for (int col = 0; col < board[row].length; col++) {
		char val = board[row][col];

		if (val != '.') {
		    if (set.contains("r" + row + val) || set.contains("c" + col + val)
			    || set.contains("b" + row / 3 + "-" + col / 3 + val))
			return false;
		    else {
			set.add("r" + row + val);
			set.add("c" + col + val);
			set.add("b" + row / 3 + "-" + col / 3 + val);
		    }
		}
	    }

	return true;
    }

    public boolean _36_isValidSudoku_v2(char[][] board) {
	Set<String> set = new HashSet<>();

	for (int row = 0; row < board.length; row++)
	    for (int col = 0; col < board[row].length; col++) {
		char val = board[row][col];

		if (val != '.') {
		    int box = (row / 3 * 3) + (col / 3);
		    if (set.contains("r" + row + val) || set.contains("c" + col + val) || set.contains("b" + box + val))
			return false;
		    else {
			set.add("r" + row + val);
			set.add("c" + col + val);
			set.add("b" + box + val);
		    }
		}
	    }

	return true;
    }

    public List<List<Integer>> _39_combinationSum(int[] nums, int target) {
	List<List<Integer>> output = new ArrayList<>();

	_39_combinationSum_backtracking(output, new ArrayList<>(), nums, target, target, 0);

	return output;
    }

    private void _39_combinationSum_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int target,
	    int remained, int from) {
	if (remained == 0) {
	    output.add(new ArrayList<>(tmp));
	} else if (remained < 0)
	    return;
	else {
	    for (int i = from; i < nums.length; i++) {
		tmp.add(nums[i]);
		_39_combinationSum_backtracking(output, tmp, nums, target, remained - nums[i], i);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public List<List<Integer>> _40_combinationSum2(int[] candidates, int target) {
	List<List<Integer>> output = new ArrayList<>();

	Arrays.sort(candidates);

	_40_combinationSum2(output, new ArrayList<>(), candidates, target, 0);

	return new ArrayList<>(output);
    }

    private void _40_combinationSum2(List<List<Integer>> output, List<Integer> tmp, int[] nums, int remained,
	    int from) {
	if (remained == 0) {
	    output.add(new ArrayList<>(tmp));
	} else if (remained < 0)
	    return;
	else {
	    for (int i = from; i < nums.length; i++) {
		if (i > from && nums[i] == nums[i - 1])
		    continue;

		tmp.add(nums[i]);
		_40_combinationSum2(output, tmp, nums, remained - nums[i], i + 1);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public List<List<Integer>> _40_combinationSum2_v2(int[] candidates, int target) { // Time Limit Exceeded
	Set<List<Integer>> output = new HashSet<>();

	_40_combinationSum2_v2(output, new ArrayList<>(), candidates, target, 0);

	return new ArrayList<>(output);
    }

    private void _40_combinationSum2_v2(Set<List<Integer>> output, List<Integer> tmp, int[] nums, int target,
	    int from) {
	int sum = tmp.stream().mapToInt(Integer::intValue).sum();
	if (sum == target) {
	    List<Integer> list = new ArrayList<>(tmp);
	    Collections.sort(list);
	    output.add(list);
	} else if (tmp.size() >= nums.length)
	    return;
	else {
	    for (int i = from; i < nums.length; i++) {
		tmp.add(nums[i]);
		_40_combinationSum2_v2(output, tmp, nums, target, i + 1);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public int _41_firstMissingPositive(int[] nums) {
	Arrays.sort(nums);

	int res = 1;

	for (int num : nums)
	    if (num == res)
		res += 1;

	return res;
    }

    public int _41_firstMissingPositive_v2(int[] nums) {
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

	StringBuilder sb = new StringBuilder();
	for (int i = muls.length - 1; i > 0; i--) {
	    if (sb.length() == 0 && muls[i] == 0)
		continue;
	    sb.append(muls[i]);
	}
	sb.append(muls[0]);

	return sb.toString();
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

    public List<List<Integer>> _46_permute(int[] nums) {
	List<List<Integer>> output = new ArrayList<>();

	_46_permute_backtracking(output, new ArrayList<>(), nums);

	return output;
    }

    private void _46_permute_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums) {
	if (tmp.size() == nums.length)
	    output.add(new ArrayList<>(tmp));
	else {
	    for (int i = 0; i < nums.length; i++) {
		if (tmp.contains(nums[i]))
		    continue;

		tmp.add(nums[i]);
		_46_permute_backtracking(output, tmp, nums);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public List<List<Integer>> _47_permuteUnique(int[] nums) {
	List<List<Integer>> output = new ArrayList<>();
	boolean[] used = new boolean[nums.length];

	Arrays.sort(nums);

	_47_permuteUnique_backtracking(output, new ArrayList<>(), nums, used);

	return output;
    }

    private void _47_permuteUnique_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums,
	    boolean[] used) {
	if (tmp.size() == nums.length)
	    output.add(new ArrayList<>(tmp));
	else {
	    for (int i = 0; i < nums.length; i++) {
		if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
		    continue;

		used[i] = true;
		tmp.add(nums[i]);
		_47_permuteUnique_backtracking(output, tmp, nums, used);
		tmp.remove(tmp.size() - 1);
		used[i] = false;
	    }
	}
    }

    public List<List<String>> _49_groupAnagrams(String[] strs) {
	Map<String, List<String>> map = new HashMap<>();

	for (String str : strs) {
	    String sortedStr = str.chars().sorted().mapToObj(String::valueOf).collect(Collectors.joining());

	    List<String> lStrs = map.getOrDefault(sortedStr, new ArrayList<>());
	    lStrs.add(str);

	    map.put(sortedStr, lStrs);
	}

	return new ArrayList<>(map.values());
    }

    public double _50_myPow(double x, int n) {
	if (n == 0)
	    return 1;

	double temp = _50_myPow(x, n / 2);

	if (n % 2 == 0)
	    return temp * temp;
	else {
	    if (n > 0)
		return (temp * temp) * x;
	    else
		return (temp * temp) / x;
	}
    }

    public int _53_maxSubArray(int[] nums) {
	int sum = 0;
	int max = Integer.MIN_VALUE;

	for (int num : nums) {
	    if (sum < 0)
		sum = num;
	    else
		sum += num;

	    if (sum > max)
		max = sum;
	}

	return max;
    }

    public List<Integer> _54_spiralOrder(int[][] matrix) {
	if (matrix == null || matrix.length == 0)
	    return new ArrayList<>();

	List<Integer> values = new ArrayList<>();

	int colBegin = 0;
	int rowBegin = 0;
	int colEnd = matrix[0].length - 1;
	int rowEnd = matrix.length - 1;

	while (colBegin <= colEnd && rowBegin <= rowEnd) {

	    for (int col = colBegin; col <= colEnd; col++)
		values.add(matrix[rowBegin][col]);
	    rowBegin++;

	    for (int row = rowBegin; row <= rowEnd; row++)
		values.add(matrix[row][colEnd]);
	    colEnd--;

	    if (rowBegin <= rowEnd)
		for (int col = colEnd; col >= colBegin; col--)
		    values.add(matrix[rowEnd][col]);
	    rowEnd--;

	    if (colBegin <= colEnd)
		for (int row = rowEnd; row >= rowBegin; row--)
		    values.add(matrix[row][colBegin]);
	    colBegin++;
	}

	return values;
    }

    public int _58_lengthOfLastWord(String s) {
	if (s == null || s.isBlank())
	    return 0;

	String[] ss = s.split(" ");
	return ss[ss.length - 1].length();
    }

    public String _60_getPermutation(int n, int k) {
	int[] nums = IntStream.range(1, n + 1).toArray();
	List<List<Integer>> output = new ArrayList<>();

	_60_getPermutation_backtracking(output, new ArrayList<>(), nums);

	return output.get(k - 1).stream().map(i -> String.valueOf(i)).collect(Collectors.joining());
    }

    private void _60_getPermutation_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums) {
	if (tmp.size() == nums.length)
	    output.add(new ArrayList<>(tmp));
	else {
	    for (int i = 0; i < nums.length; i++) {
		if (tmp.contains(nums[i]))
		    continue;

		tmp.add(nums[i]);
		_60_getPermutation_backtracking(output, tmp, nums);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public ListNode _61_rotateRight(ListNode head, int k) {
	if (head == null || k == 0)
	    return head;

	ListNode current = head;
	int length = 1;

	while (current.next != null) {
	    length++;
	    current = current.next;
	}

	current.next = head; // loop

	k = k % length;
	for (int i = 0; i < length - k; i++)
	    current = current.next;

	head = current.next;
	current.next = null; // cut loop

	return head;
    }

    public int _64_minPathSum(int[][] grid) {
	int width = grid[0].length;
	int[] dist = new int[width];

	for (int i = 1; i < width; i++)
	    dist[i] = Integer.MAX_VALUE;

	for (int[] row : grid) {
	    for (int i = 0; i < width; i++) {
		if (i == 0)
		    dist[i] = dist[i] + row[i];
		else
		    dist[i] = row[i] + Math.min(dist[i], dist[i - 1]);
	    }
	}
	return dist[width - 1];
    }

    public int[] _66_plusOne(int[] digits) {
	for (int i = digits.length - 1; i >= 0; i--) {
	    if (digits[i] == 9)
		digits[i] = 0;
	    else {
		digits[i] += 1;
		return digits;
	    }
	}

	digits = new int[digits.length + 1];
	digits[0] = 1;

	return digits;
    }

    public String _67_addBinary(String a, String b) {
	StringBuilder sb = new StringBuilder();
	int i = a.length() - 1;
	int j = b.length() - 1;
	int carry = 0;

	while (i >= 0 || j >= 0) {
	    int sum = carry;
	    if (i >= 0)
		sum += Integer.parseInt(String.valueOf(a.charAt(i--)));

	    if (j >= 0)
		sum += Integer.parseInt(String.valueOf(b.charAt(j--)));

	    sb.append(sum % 2);
	    carry = sum / 2;
	}

	if (carry != 0)
	    sb.append('1');

	return sb.reverse().toString();
    }

    public int _69_mySqrt(int x) {
	if (x == 0)
	    return 0;

	long l = 0;
	long h = x;
	long answer = -1;

	while (l <= h) {
	    long m = l + (h - l) / 2;

	    if (m * m < x) {
		l = m + 1;
		answer = m;
	    } else if (m * m > x)
		h = m - 1;
	    else
		return (int) m;
	}

	return (int) answer;
    }

    public int _70_climbStairs(int n) {
	if (n == 0)
	    return 0;
	if (n == 1)
	    return 1;
	if (n == 2)
	    return 2;

	int firstStep = 1;
	int secondStep = 2;

	for (int i = 3; i <= n; i++) {
	    int thirdStep = firstStep + secondStep;
	    firstStep = secondStep;
	    secondStep = thirdStep;
	}

	return secondStep;
    }

    public String _71_simplifyPath(String path) {
	Deque<String> stack = new LinkedList<>();

	for (String s : path.split("/")) {
	    if (s.equals(".."))
		stack.poll();
	    else if (!s.equals("") && !s.equals("."))
		stack.push(s);
	}

	StringBuilder sb = new StringBuilder();
	if (stack.size() == 0)
	    return "/";
	while (stack.size() != 0)
	    sb.append("/").append(stack.pollLast());

	return sb.toString();
    }

    public boolean _74_searchMatrix(int[][] matrix, int target) {
	if (matrix == null || matrix.length == 0)
	    return false;

	int colLength = matrix[0].length;
	int rowLength = matrix.length;

	int l = 0;
	int h = colLength * rowLength - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;

	    if (target > matrix[m / colLength][m % colLength])
		l = m + 1;
	    else if (target < matrix[m / colLength][m % colLength])
		h = m - 1;
	    else
		return true;
	}

	return false;
    }

    public void _75_sortColors(int[] nums) {
	_75_sortColors_quicksort(nums, 0, nums.length - 1);
    }

    private void _75_sortColors_quicksort(int[] nums, int l, int h) {
	if (l < h) {
	    int splitPoint = _75_sortColors_partition(nums, l, h);

	    _75_sortColors_quicksort(nums, l, splitPoint - 1);
	    _75_sortColors_quicksort(nums, splitPoint + 1, h);
	}
    }

    private int _75_sortColors_partition(int[] nums, int left, int right) {
	int pivot = nums[right];
	int lowerIndex = left - 1;// index of values lower than pivot

	for (int currentIndex = left; currentIndex < right; currentIndex++) { // currentIndex < right --> right is pivot
	    if (nums[currentIndex] < pivot) {
		lowerIndex++;

		int tmp = nums[currentIndex];
		nums[currentIndex] = nums[lowerIndex];
		nums[lowerIndex] = tmp;
	    }
	}
	// move pivot value to correct position
	lowerIndex++;

	int tmp = nums[lowerIndex];
	nums[lowerIndex] = nums[right];
	nums[right] = tmp;

	return lowerIndex;
    }

    public List<List<Integer>> _77_combine(int n, int k) {
	List<List<Integer>> output = new ArrayList<>();

	_77_combine_backtracking(output, new ArrayList<>(), IntStream.range(1, n + 1).toArray(), k, 0);

	return output;
    }

    private void _77_combine_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int k, int from) {
	if (tmp.size() == k)
	    output.add(new ArrayList<>(tmp));
	else {
	    for (int i = from; i < nums.length; i++) {
		tmp.add(nums[i]);
		_77_combine_backtracking(output, tmp, nums, k, i + 1);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public List<List<Integer>> _78_subsets(int[] nums) {
	List<List<Integer>> output = new ArrayList<>();

	_78_subsets_backtracking(output, new ArrayList<>(), nums, 0);

	return output;
    }

    private void _78_subsets_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int from) {
	output.add(new ArrayList<>(tmp));

	for (int i = from; i < nums.length; i++) {
	    tmp.add(nums[i]);
	    _78_subsets_backtracking(output, tmp, nums, i + 1);
	    tmp.remove(tmp.size() - 1);
	}
    }

    public int _80_removeDuplicates(int[] nums) {
	int slow = 1;
	int count = 1;

	for (int fast = 1; fast < nums.length; fast++) {
	    if (nums[fast - 1] == nums[fast])
		count++;
	    else
		count = 1;

	    if (count <= 2)
		nums[slow++] = nums[fast];
	}

	return slow;
    }

    public boolean _81_search(int[] nums, int target) {
	if (nums == null || nums.length == 0)
	    return false;

	int l = 0;
	int h = nums.length - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;

	    if (nums[m] == target)
		return true;
	    else if (nums[m] < nums[h]) { // range m,h is sorted
		if (target > nums[m] && target <= nums[h]) // check sorted right side
		    l = m + 1;
		else
		    h = m - 1;
	    } else if (nums[m] > nums[h]) { // range m,h unsorted so range l,m is sorted
		if (target >= nums[l] && target < nums[m]) // check sorted left side
		    h = m - 1;
		else
		    l = m + 1;
	    } else if (nums[m] == nums[h]) // skip duplicates
		h--;
	    else if (nums[m] == nums[l]) // skip duplicates
		l++;
	}

	return false;
    }

    public ListNode _82_deleteDuplicates(ListNode head) {
	ListNode dummy = new ListNode(0);
	dummy.next = head;

	ListNode fast = dummy.next;
	ListNode slow = dummy;

	while (fast != null) {
	    while (fast.next != null && fast.val == fast.next.val)
		fast = fast.next; // while loop to find the last node of the dups.

	    if (slow.next != fast) { // duplicates detected. by reference
		slow.next = fast.next; // remove the dups.
		fast = slow.next; // reposition the fast pointer.
	    } else { // no dup, move down both pointer.
		slow = slow.next;
		fast = fast.next;
	    }
	}

	return dummy.next;
    }

    public ListNode _83_deleteDuplicates(ListNode ln) {
	if (ln == null)
	    return null;

	ListNode current = ln;
	ListNode head = current;

	while (ln != null) {
	    if (ln.val == current.val)
		ln = ln.next;
	    else {
		current.next = ln;

		current = current.next;
		ln = ln.next;
	    }
	}

	current.next = null;

	return head;
    }

    public ListNode _86_partition(ListNode head, int x) {
	ListNode cNodeBeforeX = new ListNode(-1);
	ListNode headBeforeX = cNodeBeforeX;
	ListNode cNodeAfterX = new ListNode(-1);
	ListNode headAfterX = cNodeAfterX;

	while (head != null) {
	    if (head.val < x) {
		cNodeBeforeX.next = head;
		cNodeBeforeX = cNodeBeforeX.next;
	    } else {
		cNodeAfterX.next = head;
		cNodeAfterX = cNodeAfterX.next;
	    }

	    head = head.next;
	}

	cNodeAfterX.next = null;
	cNodeBeforeX.next = headAfterX.next;

	return headBeforeX.next;
    }

    public void _88_merge(int[] nums1, int m, int[] nums2, int n) {
	int k = m + n - 1;
	int i = m - 1;
	int j = n - 1;

	while (i >= 0 || j >= 0) {
	    if (i >= 0 && j >= 0)
		if (nums1[i] >= nums2[j])
		    nums1[k--] = nums1[i--];
		else
		    nums1[k--] = nums2[j--];
	    else if (i >= 0)
		nums1[k--] = nums1[i--];
	    else if (j >= 0)
		nums1[k--] = nums2[j--];
	}
    }

    public List<List<Integer>> _90_subsetsWithDup(int[] nums) {
	List<List<Integer>> output = new ArrayList<>();

	Arrays.sort(nums);

	_90_subsetsWithDup_backtracking(output, new ArrayList<>(), nums, 0);

	return output;
    }

    private void _90_subsetsWithDup_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int from) {
	output.add(new ArrayList<>(tmp));

	for (int i = from; i < nums.length; i++) {
	    if (i > from && nums[i - 1] == nums[i])
		continue;

	    tmp.add(nums[i]);
	    _90_subsetsWithDup_backtracking(output, tmp, nums, i + 1);
	    tmp.remove(tmp.size() - 1);
	}
    }

    public ListNode _92_reverseBetween(ListNode head, int m, int n) {
	ListNode dNode = new ListNode(-1);
	dNode.next = head;

	ListNode cNode = dNode;

	for (int i = 1; i < m; i++)
	    cNode = cNode.next;

	ListNode prev = null;
	ListNode curr = cNode.next;
	ListNode next = null;
	ListNode last = cNode.next;
	for (int i = m; i <= n; i++) {
	    next = curr.next; // save next node

	    curr.next = prev; // rotate

	    prev = curr; // move pointer
	    curr = next; // move pointer
	}

	cNode.next = prev;
	last.next = next;

	return dNode.next;
    }

    public List<Integer> _94_inorderTraversal(TreeNode root) {
	if (root == null)
	    return new ArrayList<>();

	List<Integer> traversal = new ArrayList<>();
	Deque<TreeNode> stack = new LinkedList<>();
	TreeNode current = root;

	while (!stack.isEmpty() || current != null) {
	    if (current != null) {
		stack.addLast(current);
		current = current.left;
	    } else {
		current = stack.removeLast();
		traversal.add(current.val);
		current = current.right;
	    }
	}

	return traversal;
    }

    public boolean _98_isValidBST(TreeNode root) {
	if (root == null)
	    return true;

	Deque<TreeNode> stack = new LinkedList<>();
	TreeNode current = root;
	TreeNode previous = null;

	while (!stack.isEmpty() || current != null) {
	    if (current != null) {
		stack.addLast(current);

		current = current.left;
	    } else {
		current = stack.removeLast();

		if (previous != null && current.val < previous.val)
		    return false;
		previous = current;

		current = current.right;
	    }
	}

	return true;
    }

    public boolean _100_isSameTree(TreeNode p, TreeNode q) {
	if (p == null && q == null)
	    return true;
	if (p == null || q == null)
	    return false;

	Deque<TreeNode> queue1 = new ArrayDeque<>();
	Deque<TreeNode> queue2 = new ArrayDeque<>();

	queue1.addLast(p);
	queue2.addLast(q);

	while (!queue1.isEmpty() && !queue2.isEmpty()) {
	    TreeNode tn1 = queue1.removeFirst();
	    TreeNode tn2 = queue2.removeFirst();

	    if (tn1.left != null && tn2.left == null)
		return false;
	    if (tn1.left == null && tn2.left != null)
		return false;
	    if (tn1.right != null && tn2.right == null)
		return false;
	    if (tn1.right == null && tn2.right != null)
		return false;
	    if (tn1.val != tn2.val)
		return false;

	    if (tn1.left != null)
		queue1.addLast(tn1.left);
	    if (tn1.right != null)
		queue1.addLast(tn1.right);
	    if (tn2.left != null)
		queue2.addLast(tn2.left);
	    if (tn2.right != null)
		queue2.addLast(tn2.right);
	}

	return queue1.isEmpty() && queue2.isEmpty();
    }

    public boolean _101_isSymmetric(TreeNode root) {
	Deque<TreeNode> queue = new LinkedList<>();// LinkedList allow add null values, ArrayDeque doesn't

	queue.addLast(root);
	queue.addLast(root);

	while (!queue.isEmpty()) {
	    TreeNode tn1 = queue.removeFirst();
	    TreeNode tn2 = queue.removeFirst();

	    if (tn1 == null && tn2 == null)
		continue;
	    if (tn1 == null || tn2 == null)
		return false;
	    if (tn1.val != tn2.val)
		return false;

	    queue.addLast(tn1.left);
	    queue.addLast(tn2.right);
	    queue.addLast(tn1.right);
	    queue.addLast(tn2.left);
	}

	return true;
    }

    public List<List<Integer>> _102_levelOrder(TreeNode root) {
	List<List<Integer>> valuesByLevels = new ArrayList<>();

	if (root == null)
	    return valuesByLevels;

	Deque<TreeNode> queue = new ArrayDeque<>();

	queue.addLast(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();
	    List<Integer> values = new ArrayList<>();

	    while (size-- > 0) {
		TreeNode tn = queue.removeFirst();

		values.add(tn.val);

		if (tn.left != null)
		    queue.addLast(tn.left);
		if (tn.right != null)
		    queue.addLast(tn.right);
	    }

	    valuesByLevels.add(values);
	}

	return valuesByLevels;
    }

    public List<List<Integer>> _103_zigzagLevelOrder(TreeNode root) {
	List<List<Integer>> valuesByLevels = new ArrayList<>();

	if (root == null)
	    return valuesByLevels;

	Deque<TreeNode> queue = new LinkedList<>();
	queue.addLast(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();
	    Deque<Integer> values = new LinkedList<>();
	    int level = valuesByLevels.size();

	    while (size-- > 0) {
		TreeNode tn = queue.removeFirst();

		if (level % 2 != 0)
		    values.addFirst(tn.val);
		else
		    values.addLast(tn.val);

		if (tn.left != null)
		    queue.addLast(tn.left);
		if (tn.right != null)
		    queue.addLast(tn.right);
	    }

	    valuesByLevels.add(new ArrayList<>(values));
	}

	return valuesByLevels;
    }

    public int _104_maxDepth(TreeNode root) {
	if (root == null)
	    return 0;

	Deque<TreeNode> queue = new ArrayDeque<>();
	int level = 0;
	queue.add(root);

	while (!queue.isEmpty()) {
	    level++;
	    int size = queue.size();

	    while (size-- > 0) {
		TreeNode tn = queue.removeFirst();

		if (tn.left != null)
		    queue.addLast(tn.left);
		if (tn.right != null)
		    queue.addLast(tn.right);
	    }
	}

	return level;
    }

    public TreeNode _105_buildTree(int[] preorder, int[] inorder) {
	return _105_buildTree_helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode _105_buildTree_helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	if (preStart > preorder.length - 1 || inStart > inEnd)
	    return null;

	TreeNode tn = new TreeNode(preorder[preStart]);
	int inDivider = 0;

	for (int i = inStart; i <= inEnd; i++)
	    if (inorder[i] == tn.val)
		inDivider = i;

	tn.left = _105_buildTree_helper(preStart + 1, inStart, inDivider - 1, preorder, inorder);
	// (inDivider - inStart) move by lenght of left subtree
	tn.right = _105_buildTree_helper(preStart + 1 + (inDivider - inStart), inDivider + 1, inEnd, preorder, inorder);

	return tn;
    }

    public List<List<Integer>> _107_levelOrderBottom(TreeNode root) {
	Deque<List<Integer>> values = new LinkedList<>();
	Deque<TreeNode> queue = new ArrayDeque<>();

	if (root == null)
	    return new ArrayList<>();

	queue.addLast(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();
	    List<Integer> levelValues = new ArrayList<>();

	    while (size-- > 0) {
		TreeNode tn = queue.removeFirst();

		levelValues.add(tn.val);

		if (tn.left != null)
		    queue.addLast(tn.left);
		if (tn.right != null)
		    queue.addLast(tn.right);
	    }

	    values.addFirst(levelValues);
	}

	return values.stream().collect(Collectors.toList());
    }

    public TreeNode _108_sortedArrayToBST(int[] nums) {
	if (nums == null || nums.length == 0)
	    return null;

	return _108_sortedArrayToBST_recursive(nums, 0, nums.length - 1);
    }

    private TreeNode _108_sortedArrayToBST_recursive(int[] nums, int l, int h) {
	if (l <= h) {
	    int m = l + (h - l) / 2;
	    TreeNode tn = new TreeNode(nums[m]);

	    tn.left = _108_sortedArrayToBST_recursive(nums, l, m - 1);
	    tn.right = _108_sortedArrayToBST_recursive(nums, m + 1, h);

	    return tn;
	} else
	    return null;
    }

    public TreeNode _109_sortedListToBST(ListNode head) {
	if (head == null)
	    return null;

	List<Integer> nums = new ArrayList<>();
	while (head != null) {
	    nums.add(head.val);
	    head = head.next;
	}

	return _109_sortedListToBST(nums, 0, nums.size() - 1);
    }

    public TreeNode _109_sortedListToBST(List<Integer> nums, int l, int h) {
	if (l <= h) {
	    int m = l + (h - l) / 2;
	    int val = nums.get(m);

	    TreeNode tn = new TreeNode(val);

	    tn.left = _109_sortedListToBST(nums, l, m - 1);
	    tn.right = _109_sortedListToBST(nums, m + 1, h);

	    return tn;
	}

	return null;
    }

    public boolean _110_isBalanced(TreeNode root) {
	if (root == null)
	    return true;

	int left = _110_isBalanced_max_height(root.left);
	int right = _110_isBalanced_max_height(root.right);

	return Math.abs(left - right) <= 1 && _110_isBalanced(root.left) && _110_isBalanced(root.right);
    }

    private int _110_isBalanced_max_height(TreeNode root) {
	if (root == null)
	    return 0;
	return 1 + Math.max(_110_isBalanced_max_height(root.left), _110_isBalanced_max_height(root.right));
    }

    public int _111_minDepth(TreeNode root) {
	if (root == null)
	    return 0;

	Deque<TreeNode> queue = new ArrayDeque<>();
	queue.addLast(root);
	int level = 1;

	while (!queue.isEmpty()) {
	    int size = queue.size();

	    while (size-- > 0) {
		TreeNode tn = queue.removeFirst();

		if (tn.left == null && tn.right == null)
		    return level;

		if (tn.left != null)
		    queue.addLast(tn.left);
		if (tn.right != null)
		    queue.addLast(tn.right);
	    }
	    level++;
	}

	return level;
    }

    public boolean _112_hasPathSum(TreeNode root, int sum) {
	if (root == null)
	    return false;

	Deque<TreeNode> stack = new ArrayDeque<>();
	Deque<Integer> sums = new ArrayDeque<>();

	stack.addLast(root);
	sums.addLast(root.val);

	while (!stack.isEmpty()) {
	    TreeNode tn = stack.removeLast();
	    Integer path = sums.removeLast();

	    if (tn.left == null && tn.right == null && path == sum)
		return true;

	    if (tn.right != null) {
		stack.addLast(tn.right);
		sums.addLast(path + tn.right.val);
	    }
	    if (tn.left != null) {
		stack.addLast(tn.left);
		sums.addLast(path + tn.left.val);
	    }
	}

	return false;
    }

    public List<List<Integer>> _118_generate(int numRows) {
	if (numRows == 0)
	    return new ArrayList<>();

	List<List<Integer>> rows = new ArrayList<>();

	rows.add(IntStream.of(1).boxed().collect(Collectors.toList()));
	if (numRows == 1)
	    return rows;

	rows.add(IntStream.of(1, 1).boxed().collect(Collectors.toList()));

	for (int i = 2; i < numRows; i++) {
	    List<Integer> row = new ArrayList<>();

	    for (int j = 0; j <= i; j++)
		if (j == 0)
		    row.add(1);
		else if (j == i)
		    row.add(1);
		else
		    row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));

	    rows.add(row);
	}

	return rows;
    }

    public List<Integer> _119_getRow(int rowIndex) {
	List<List<Integer>> rows = new ArrayList<>();

	rows.add(IntStream.of(1).boxed().collect(Collectors.toList()));
	if (rowIndex == 0)
	    return rows.get(0);

	rows.add(IntStream.of(1, 1).boxed().collect(Collectors.toList()));

	for (int i = 2; i < rowIndex + 1; i++) {
	    List<Integer> row = new ArrayList<>();

	    for (int j = 0; j <= i; j++)
		if (j == 0)
		    row.add(1);
		else if (j == i)
		    row.add(1);
		else
		    row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));

	    rows.add(row);
	}

	return rows.get(rowIndex);
    }

    public List<Integer> _119_getRow_v2(int rowIndex) {
	if (rowIndex == 0)
	    return Arrays.asList(1);
	if (rowIndex == 1)
	    return Arrays.asList(1, 1);

	List<Integer> secondRow = Arrays.asList(1, 1);

	return _119_getRow_v2(rowIndex - 2, secondRow);
    }

    private List<Integer> _119_getRow_v2(int k, List<Integer> prevRow) {
	if (k >= 0) {
	    List<Integer> currRow = new ArrayList<>();
	    for (int i = 0; i < prevRow.size() + 1; i++) {
		if (i == 0)
		    currRow.add(1);
		else if (i == prevRow.size())
		    currRow.add(1);
		else
		    currRow.add(prevRow.get(i - 1) + prevRow.get(i));
	    }

	    return _119_getRow_v2(k - 1, currRow);

	} else
	    return prevRow;
    }

    public int _121_maxProfit(int[] prices) {
	if (prices == null || prices.length == 0)
	    return 0;

	int min = prices[0];// buy stock by min value
	int max = 0;// max profit -> buy min value sell max value ide

	for (int i = 1; i < prices.length; i++) {
	    if (prices[i] < min)
		min = prices[i];
	    else {
		if (prices[i] - min > max)
		    max = prices[i] - min;
	    }
	}

	return max;
    }

    public int _122_maxProfit(int[] prices) { // buy stock in day 1, sell stock in day 2, buy stock in day 2 ..
	if (prices == null || prices.length == 0)
	    return 0;

	int max = 0;
	for (int i = 1; i < prices.length; i++)
	    if (prices[i] - prices[i - 1] > 0)
		max += (prices[i] - prices[i - 1]);

	return max;
    }

    public boolean _125_isPalindrome(String s) {
	if (s == null)
	    return false;

	s = s.toLowerCase().trim();

	int l = 0;
	int h = s.length() - 1;

	while (l <= h) {
	    if (!Character.isAlphabetic(s.charAt(l)) && !Character.isDigit(s.charAt(l))) {
		l++;
		continue;
	    }
	    if (!Character.isAlphabetic(s.charAt(h)) && !Character.isDigit(s.charAt(h))) {
		h--;
		continue;
	    }

	    if (s.charAt(l) != s.charAt(h))
		return false;

	    l++;
	    h--;
	}

	return true;
    }

    public List<List<String>> _131_partition(String s) {
	List<List<String>> output = new ArrayList<>();

	_131_partition_backtracking(output, new ArrayList<>(), s, 0);

	return output;
    }

    private void _131_partition_backtracking(List<List<String>> output, List<String> tmp, String s, int begin) {
	if (begin == s.length())
	    output.add(new ArrayList<>(tmp));
	else {
	    for (int i = begin; i < s.length(); i++) {
		String pString = s.substring(begin, i + 1);

		if (_131_partition_isPalindrome(pString)) {
		    tmp.add(pString);
		    _131_partition_backtracking(output, tmp, s, i + 1);
		    tmp.remove(tmp.size() - 1);
		}
	    }
	}
    }

    private boolean _131_partition_isPalindrome(String pString) {
	int l = 0;
	int h = pString.length() - 1;

	while (l < h)
	    if (pString.charAt(l++) != pString.charAt(h--))
		return false;

	return true;
    }

    public int _136_singleNumber(int[] nums) {
	Set<Integer> set = new HashSet<>();

	for (int num : nums)
	    if (set.contains(num))
		set.remove(num);
	    else
		set.add(num);

	return set.stream().findFirst().get();
    }

    public int _137_singleNumber(int[] nums) {
	Arrays.sort(nums);

	int i = 2; // start from third position
	while (i < nums.length) {
	    if (nums[i - 2] != nums[i])
		return nums[i - 2]; // found in middle

	    i = i + 3;// move to next
	}

	if (nums.length == 1)// found in begin
	    return nums[0];
	else
	    return nums[nums.length - 1]; // found in tail
    }

    public Node2 _138_copyRandomList(Node2 head) {
	Map<Node2, Node2> map = new HashMap<>();

	Node2 dummy = new Node2(-1);
	Node2 currDummy = dummy;

	Node2 current = head;

	while (current != null) {
	    map.put(current, new Node2(current.val));
	    current = current.next;
	}

	current = head;
	while (current != null) {
	    currDummy.next = map.get(current);
	    currDummy.next.random = map.getOrDefault(current.random, null);

	    currDummy = currDummy.next;
	    current = current.next;
	}

	return dummy.next;
    }

    public boolean _141_hasCycle(ListNode head) {
	Set<ListNode> set = new HashSet<>();

	while (head != null) {
	    if (set.contains(head))
		return true;
	    else
		set.add(head);
	    head = head.next;
	}

	return false;
    }

    public ListNode _142_detectCycle(ListNode head) {
	Set<ListNode> nodes = new HashSet<>();

	while (head != null) {
	    if (nodes.contains(head))
		return head;
	    else
		nodes.add(head);

	    head = head.next;
	}

	return null;
    }

    public int _153_findMin(int[] nums) {
	int l = 0;
	int h = nums.length - 1;

	while (l < h) {
	    int m = l + (h - l) / 2;

	    if (nums[m] > nums[h])// nums[m] is higher than nums[h] so range from m to h has incorrect order
		// so result must be in this range
		l = m + 1;
	    else // nums[m] is lower than nums[h] so range from m to h has correct order
		h = m;
	}

	return nums[l];
    }

    public MinStack _155_minStack() {
	return new MinStack();
    }

    class MinStack {

	private Stack<Integer> stack = new Stack<>();
	private int min = Integer.MAX_VALUE;

	public void push(int x) {
	    if (x <= min) { // new min (x<=old_min), so remember old
		stack.push(min);
		min = x;
	    }
	    stack.push(x);
	}

	public void pop() {
	    int x = stack.pop();

	    if (x == min)
		min = stack.pop();
	}

	public int top() {
	    return stack.peek();
	}

	public int getMin() {
	    return min;
	}
    }

    public ListNode _160_getIntersectionNode(ListNode headA, ListNode headB) {
	Set<ListNode> set = new HashSet<>();

	while (headA != null) {
	    set.add(headA);
	    headA = headA.next;
	}

	while (headB != null) {
	    if (set.contains(headB))
		return headB;
	    headB = headB.next;
	}

	return null;
    }

    public int[] _167_twoSum(int[] numbers, int target) {
	Map<Integer, Integer> map = new HashMap<>();// Map.Entry<Value, Index>

	for (int i = 0; i < numbers.length; i++) {
	    if (map.containsKey(target - numbers[i]))
		return new int[] { map.get(target - numbers[i]) + 1, i + 1 };

	    if (!map.containsKey(numbers[i]))
		map.put(numbers[i], i);
	}

	throw new IllegalArgumentException("Solution not found");
    }

    public String _168_convertToTitle(int n) {
	StringBuilder sb = new StringBuilder();

	while (n-- > 0) { // n-- ---> if n=1 then n-- 'A'(65) + 0%26(0)=='A'(65) for every char n--
	    sb.append((char) (n % 26 + 'A'));
	    n /= 26;
	}

	return sb.reverse().toString();
    }

    public int _169_majorityElement(int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();

	for (int num : nums)
	    map.put(num, map.getOrDefault(num, 0) + 1);

	return map.entrySet().stream().max((e1, e2) -> e1.getValue() - e2.getValue()).get().getKey();
    }

    public int _171_titleToNumber(String s) {
	int num = 0;

	for (char sChar : s.toCharArray())
	    num = num * 26 + sChar - 64; // 64 below 'A' 65

	return num;
    }

    public int _172_trailingZeroes(int n) {
	int count = 0;

	while (n > 0) {
	    n /= 5;
	    count += n;
	}

	return count;
    }

    class BSTIterator {
	private int index = -1;
	private List<Integer> values = new ArrayList<>();

	public BSTIterator(TreeNode root) {
	    if (root != null) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode current = root;

		while (!stack.isEmpty() || current != null) {
		    if (current != null) {
			stack.addLast(current);

			current = current.left;
		    } else {
			current = stack.removeLast();

			values.add(current.val);

			current = current.right;
		    }
		}
	    }
	}

	/** @return the next smallest number */
	public int next() {
	    return values.get(++index);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
	    return index + 1 < values.size();
	}
    }

    public BSTIterator _173_BSTIterator(TreeNode root) {
	return new BSTIterator(root);
    }

    public void _189_rotate(int[] nums, int k) {
	k = k % nums.length; // example - k=7 and nums.length=3 then k=1, remove empty loops

	while (k-- > 0) {
	    int lNum = nums[nums.length - 1];
	    for (int i = nums.length - 1; i > 0; i--)
		nums[i] = nums[i - 1];
	    nums[0] = lNum;
	}
    }

    public void _189_rotate_v2(int[] nums, int k) {
	if (nums == null || nums.length < 2)
	    return;

	k = k % nums.length; // example - k=7 and nums.length=3 then k=1

	_189_rotate_reverse(nums, 0, nums.length - 1);
	_189_rotate_reverse(nums, 0, k - 1);
	_189_rotate_reverse(nums, k, nums.length - 1);
    }

    private void _189_rotate_reverse(int[] nums, int begin, int end) {
	while (begin < end) {
	    int tmp = nums[begin];
	    nums[begin] = nums[end];
	    nums[end] = tmp;

	    begin++;
	    end--;
	}
    }

    public int _198_rob(int[] nums) {
	if (nums.length == 0)
	    return 0;

	int oneHouseBefore = 0; // in first iteration dummy value
	int twoHouseBefore = 0; // in first iteration dummy value

	// nums=[1,2,3,4] so first iteration with dummy element ->
	// 0,0,1 -> twoHouseBefore,oneHouseBefore,currentHouse

	for (int num : nums) {
	    int tmp = oneHouseBefore;
	    oneHouseBefore = Math.max(twoHouseBefore + num, oneHouseBefore);
	    twoHouseBefore = tmp;
	}

	return oneHouseBefore;
    }

    public int _200_numIslands(char[][] grid) {
	int counter = 0;
	for (int row = 0; row < grid.length; row++)
	    for (int col = 0; col < grid[row].length; col++) {
		if (grid[row][col] == '1') {
		    counter++;
		    _200_numIslands_expandLand(grid, row, col);
		}
	    }

	return counter;
    }

    private void _200_numIslands_expandLand(char[][] grid, int row, int col) {
	if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
	    grid[row][col] = '0';

	    _200_numIslands_expandLand(grid, row + 1, col);
	    _200_numIslands_expandLand(grid, row - 1, col);
	    _200_numIslands_expandLand(grid, row, col + 1);
	    _200_numIslands_expandLand(grid, row, col - 1);
	}
    }

    public int _201_rangeBitwiseAnd(int m, int n) {
	if (m == 0)
	    return 0;

	int moveFactor = 1;

	while (m != n) {
	    m >>= 1;
	    n >>= 1;
	    moveFactor <<= 1;
	}

	return m * moveFactor;
    }

    public boolean _202_isHappy(int n) {
	Set<Integer> set = new HashSet<>();

	while (!set.contains(n)) {
	    set.add(n);
	    int sumOfSquare = 0;
	    while (n > 0) {
		sumOfSquare += (n % 10) * (n % 10);
		n /= 10;
	    }
	    if (sumOfSquare == 1)
		return true;

	    n = sumOfSquare;
	}

	return false;
    }

    public ListNode _203_removeElements(ListNode head, int val) {
	ListNode current = new ListNode(-1);
	ListNode dummyHead = current;

	while (head != null) {
	    if (head.val == val)
		head = head.next;
	    else {
		current.next = head;
		current = current.next;

		head = head.next;
	    }
	}

	current.next = null;

	return dummyHead.next;
    }

    public boolean _205_isIsomorphic(String s, String t) {
	Map<Character, Character> map = new HashMap<>();

	for (int i = 0; i < s.length(); i++) {
	    if (!map.containsKey(s.charAt(i))) {
		if (map.containsValue(t.charAt(i)))
		    return false;
		map.put(s.charAt(i), t.charAt(i));
	    }

	    if (t.charAt(i) != map.get(s.charAt(i)))
		return false;
	}

	return true;
    }

    public ListNode _206_reverseList(ListNode head) {
	ListNode prev = null;
	ListNode curr = head;
	ListNode next = null;

	while (curr != null) {
	    next = curr.next;

	    curr.next = prev;

	    prev = curr;
	    curr = next;
	}

	return prev;
    }

    public boolean _217_containsDuplicate(int[] nums) {
	if (nums == null)
	    return false;

	Set<Integer> set = new HashSet<>();

	for (int num : nums) {
	    if (set.contains(num))
		return true;
	    else
		set.add(num);
	}

	return false;
    }

    public boolean _219_containsNearbyDuplicate(int[] nums, int k) {
	if (nums == null)
	    return false;

	Map<Integer, Integer> map = new HashMap<>();

	for (int i = 0; i < nums.length; i++) {
	    if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k)
		return true;
	    else
		map.put(nums[i], i);
	}

	return false;
    }

    class MyStack {

	private Queue<Integer> queue;

	public MyStack() {
	    queue = new LinkedList<>();
	}

	public void push(int x) {
	    queue.add(x);

	    int size = queue.size();

	    while (size-- > 1)
		queue.add(queue.remove());
	}

	public int pop() {
	    return queue.remove();
	}

	public int top() {
	    return queue.peek();
	}

	public boolean empty() {
	    return queue.isEmpty();
	}
    }

    public MyStack _225_MyStack() {
	return new MyStack();
    }

    public TreeNode _226_invertTree(TreeNode root) {
	if (root == null)
	    return null;

	Deque<TreeNode> queue = new LinkedList<>();
	queue.addLast(root);

	while (!queue.isEmpty()) {
	    TreeNode tn = queue.removeFirst();

	    TreeNode tmp = tn.left;
	    tn.left = tn.right;
	    tn.right = tmp;

	    if (tn.left != null)
		queue.addLast(tn.left);
	    if (tn.right != null)
		queue.addLast(tn.right);
	}

	return root;
    }

    public boolean _231_isPowerOfTwo(int n) {
	if (n <= 0)
	    return false;

	while (n % 2 == 0)
	    n /= 2;

	return n == 1;
    }

    class MyQueue {

	Stack<Integer> stack;

	public MyQueue() {
	    stack = new Stack<>();
	}

	public void push(int x) {

	    Stack<Integer> tmp = new Stack<>();

	    while (!stack.isEmpty())
		tmp.add(stack.pop());

	    stack.push(x);

	    while (!tmp.isEmpty())
		stack.add(tmp.pop());
	}

	public int pop() {
	    return stack.pop();
	}

	public int peek() {
	    return stack.peek();
	}

	public boolean empty() {
	    return stack.isEmpty();
	}
    }

    public MyQueue _232_MyQueue() {
	return new MyQueue();
    }

    public boolean _234_isPalindrome(ListNode head) {
	ListNode slow = head;
	ListNode fast = head;

	while (fast != null && fast.next != null) {
	    fast = fast.next.next;
	    slow = slow.next;
	}

	if (fast != null) // odd nodes
	    slow = slow.next;

	fast = head;
	slow = _234_isPalindrome_reverse(slow);

	while (slow != null && fast != null) {
	    if (slow.val != fast.val)
		return false;
	    slow = slow.next;
	    fast = fast.next;
	}
	return true;

    }

    private ListNode _234_isPalindrome_reverse(ListNode head) {
	ListNode prev = null;
	ListNode current = head;
	ListNode next = null;

	while (current != null) {
	    next = current.next;
	    current.next = prev;
	    prev = current;
	    current = next;
	}

	head = prev;
	return head;
    }

    // "erase value of" current node not delete node,
    public void _237_deleteNode(ListNode node) {
	while (node.next != null) {
	    node.val = node.next.val;
	    if (node.next.next == null)
		node.next = null;
	    else
		node = node.next;
	}
    }

    public int[] _238_productExceptSelf(int[] nums) {
	int length = nums.length;
	int[] left = new int[length];
	int[] right = new int[length];

	left[0] = 1;
	for (int i = 1; i < length; i++)
	    left[i] = left[i - 1] * nums[i - 1];

	right[length - 1] = 1;
	for (int i = length - 2; i >= 0; i--)
	    right[i] = right[i + 1] * nums[i + 1];

	int[] product = new int[length];
	for (int i = 0; i < length; i++)
	    product[i] = left[i] * right[i];

	return product;
    }

    public List<String> _257_binaryTreePaths(TreeNode root) {
	if (root == null)
	    return new ArrayList<>();

	List<String> paths = new ArrayList<>();

	Deque<TreeNode> stack = new LinkedList<>();
	Deque<String> strStack = new LinkedList<>();

	stack.addLast(root);
	strStack.addLast("");

	while (!stack.isEmpty()) {
	    TreeNode cTn = stack.pop();
	    String cStr = strStack.pop();

	    if (cTn.left == null && cTn.right == null)
		paths.add(cStr + cTn.val);

	    if (cTn.right != null) {
		stack.push(cTn.right);
		strStack.push(cStr + cTn.val + "->");
	    }
	    if (cTn.left != null) {
		stack.push(cTn.left);
		strStack.push(cStr + cTn.val + "->");
	    }
	}

	return paths;
    }

    public List<String> _257_binaryTreePaths_v2(TreeNode root) {
	if (root == null)
	    return new ArrayList<>();

	List<String> paths = new ArrayList<>();

	Queue<TreeNode> queue = new LinkedList<>();
	Queue<String> strQueue = new LinkedList<>();

	queue.add(root);
	strQueue.add("");

	while (!queue.isEmpty()) {
	    TreeNode cTn = queue.remove();
	    String cStr = strQueue.remove();

	    if (cTn.left == null && cTn.right == null)
		paths.add(cStr + cTn.val);

	    if (cTn.left != null) {
		queue.add(cTn.left);
		strQueue.add(cStr + cTn.val + "->");
	    }
	    if (cTn.right != null) {
		queue.add(cTn.right);
		strQueue.add(cStr + cTn.val + "->");
	    }
	}

	return paths;
    }

    public int _268_missingNumber(int[] nums) {
	Arrays.sort(nums);

	for (int i = 0; i < nums.length; i++)
	    if (i != nums[i])
		return i;

	return nums.length;
    }

    public void _283_moveZeroes(int[] nums) {
	if (nums == null || nums.length == 0)
	    return;

	int slow = 0;
	for (int fast = 0; fast < nums.length; fast++) {
	    if (nums[fast] == 0)
		continue;
	    else
		nums[slow++] = nums[fast];
	}

	while (slow < nums.length)
	    nums[slow++] = 0;
    }

    public void _344_reverseString(char[] s) {
	for (int i = 0, j = s.length - 1; i < j; i++, j--) {
	    char tmp = s[i];
	    s[i] = s[j];
	    s[j] = tmp;
	}
    }

    public void _344_reverseString_v2(char[] s) {
	_344_reverseString(s, 0, s.length - 1);
    }

    public void _344_reverseString(char[] s, int left, int right) {
	if (left < right) {
	    char tmp = s[left];
	    s[left] = s[right];
	    s[right] = tmp;

	    _344_reverseString(s, left + 1, right - 1);
	}
    }

    public String _345_reverseVowels(String s) {
	if (s == null || s.isEmpty())
	    return s;

	Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
	char[] chars = s.toCharArray();
	int i = 0, j = s.length() - 1;

	while (i < j) {
	    if (!vowels.contains(chars[i])) {
		i++;
		continue;
	    }

	    if (!vowels.contains(chars[j])) {
		j--;
		continue;
	    }

	    char tmp = chars[i];
	    chars[i] = chars[j];
	    chars[j] = tmp;

	    i++;
	    j--;
	}

	return String.valueOf(chars);
    }

    public int[] _349_intersection(int[] nums1, int[] nums2) {
	Set<Integer> set1 = IntStream.of(nums1).boxed().collect(Collectors.toSet());
	Set<Integer> set2 = IntStream.of(nums2).boxed().collect(Collectors.toSet());

	set1.retainAll(set2);

	return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] _350_intersect(int[] nums1, int[] nums2) {
	Map<Integer, Integer> map = new HashMap<>();
	List<Integer> results = new ArrayList<>();

	for (int num : nums1)
	    map.put(num, map.getOrDefault(num, 0) + 1);

	for (int num : nums2) {
	    if (map.containsKey(num)) {
		results.add(num);

		if (map.get(num) <= 1)
		    map.remove(num);
		else
		    map.put(num, map.get(num) - 1);
	    }
	}

	return results.stream().mapToInt(i -> i).toArray();
    }

    public List<List<Integer>> _429_levelOrder(Node root) {
	List<List<Integer>> levels = new ArrayList<>();

	if (root == null)
	    return levels;

	Deque<Node> queue = new LinkedList<>();
	queue.add(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();
	    List<Integer> values = new ArrayList<>();

	    while (size-- > 0) {
		Node tn = queue.removeFirst();

		values.add(tn.val);

		if (tn.children != null)
		    for (Node node : tn.children)
			queue.addLast(node);
	    }

	    levels.add(values);
	}

	return levels;
    }

    public int _509_fib(int N) {
	if (N <= 1)
	    return N;

	int f0 = 0;
	int f1 = 1;
	int f2 = 0;

	for (int i = 2; i <= N; i++) {
	    f2 = f0 + f1;

	    f0 = f1;
	    f1 = f2;
	}

	return f2;
    }

    public int _525_findMaxLength(int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();
	int maxlen = 0;
	int count = 0;

	for (int i = 0; i < nums.length; i++) {
	    count = count + (nums[i] == 1 ? 1 : -1);

	    if (count == 0)
		maxlen = Math.max(maxlen, i + 1);

	    if (map.containsKey(count))
		maxlen = Math.max(maxlen, i - map.get(count));
	    else
		map.put(count, i);
	}

	return maxlen;
    }

    public int _543_diameterOfBinaryTree(TreeNode root) { // TODO look at python version
	if (root == null) {
	    return 0;
	}

	int dia = _543_diameterOfBinaryTree_depth(root.left) + _543_diameterOfBinaryTree_depth(root.right);

	int ldia = _543_diameterOfBinaryTree(root.left);
	int rdia = _543_diameterOfBinaryTree(root.right);

	return Math.max(dia, Math.max(ldia, rdia));

    }

    public int _543_diameterOfBinaryTree_depth(TreeNode root) {
	if (root == null) {
	    return 0;
	}

	int lDepth = _543_diameterOfBinaryTree_depth(root.left);
	int rDepth = _543_diameterOfBinaryTree_depth(root.right);

	return 1 + Math.max(lDepth, rDepth);
    }

    public String _557_reverseWords(String s) {
	StringBuilder sb = new StringBuilder();

	String[] splitS = s.split(" ");

	for (String word : splitS) {
	    for (int i = word.length() - 1; i >= 0; i--)
		sb.append(word.charAt(i));
	    sb.append(' ');
	}

	sb.deleteCharAt(sb.length() - 1);

	return sb.toString();
    }

    public int _560_subarraySum(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<>();
	int sum = 0;
	int result = 0;

	map.put(0, 1); // single number is equals to k, so sum-k==0

	for (int num : nums) {
	    sum += num;

	    if (map.containsKey(sum - k))
		result += map.get(sum - k);

	    map.put(sum, map.getOrDefault(sum, 0) + 1);
	}

	return result;
    }

    public int _561_arrayPairSum(int[] nums) {
	Arrays.sort(nums);

	int sum = 0;
	for (int i = 0; i < nums.length; i = i + 2)
	    sum += nums[i];

	return sum;
    }

    public List<Integer> _589_preorder(Node root) {
	if (root == null)
	    return new ArrayList<>();

	List<Integer> traverseValues = new ArrayList<>();
	Deque<Node> stack = new LinkedList<Node>();
	stack.add(root);

	while (!stack.isEmpty()) {
	    Node n = stack.pop();

	    traverseValues.add(n.val);

	    if (n.children != null)
		for (int i = n.children.size() - 1; i >= 0; i--)
		    stack.push(n.children.get(i));
	}

	return traverseValues;
    }

    public List<Integer> _590_postorder(Node root) {
	if (root == null)
	    return new ArrayList<>();

	List<Integer> values = new ArrayList<>();
	Deque<Node> stack1 = new ArrayDeque<>();
	Deque<Node> stack2 = new ArrayDeque<>();

	stack1.push(root);

	while (!stack1.isEmpty()) {
	    Node n = stack1.pop();

	    stack2.push(n);

	    if (n.children != null)
		for (Node child : n.children)
		    stack1.push(child);
	}

	while (!stack2.isEmpty())
	    values.add(stack2.pop().val);

	return values;
    }

    public TreeNode _617_mergeTrees(TreeNode t1, TreeNode t2) {
	if (t1 == null && t2 == null)
	    return null;

	int sum = (t1 != null ? t1.val : 0) + (t2 != null ? t2.val : 0);
	TreeNode tn = new TreeNode(sum);

	tn.left = _617_mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
	tn.right = _617_mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);

	return tn;
    }

    public boolean _657_judgeCircle(String moves) {
	int[] position = new int[] { 0, 0 }; // x,y

	for (char move : moves.toCharArray()) {
	    switch (move) {
	    case 'L':
		position[0] -= 1;
		break;
	    case 'R':
		position[0] += 1;
		break;
	    case 'U':
		position[1] += 1;
		break;
	    case 'D':
		position[1] -= 1;
		break;
	    default:
		throw new IllegalArgumentException("Unsuported move");
	    }
	}

	return position[0] == 0 && position[1] == 0;
    }

    public boolean _665_checkPossibility(int[] nums) {
	int modyfications = 0;
	for (int i = 1; i < nums.length; i++)
	    if (nums[i - 1] > nums[i]) {
		modyfications++;
		if (i - 2 >= 0 && nums[i] < nums[i - 2])
		    nums[i] = nums[i - 1];
	    }

	return modyfications <= 1;
    }

    public boolean _678_checkValidString(String s) {
	int length = s.length() - 1;
	int open = 0;
	int close = 0;

	for (int i = 0; i <= length; i++) {
	    if (s.charAt(i) == '(' || s.charAt(i) == '*')
		open++;
	    else
		open--;

	    if (s.charAt(length - i) == ')' || s.charAt(length - i) == '*')
		close++;
	    else
		close--;

	    if (open < 0 || close < 0)
		return false;
	}

	return true;
    }

    public int _690_getImportance(List<Employee> employees, int id) {
	HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();

	for (Employee emp : employees)
	    map.put(emp.id, emp);

	return _690_getImportance_dfs(map, id);
    }

    private int _690_getImportance_dfs(HashMap<Integer, Employee> map, int id) {
	Employee employee = map.get(id);

	int importance = employee.importance;
	for (int subordinate : employee.subordinates)
	    importance += _690_getImportance_dfs(map, subordinate);

	return importance;
    }

    public TreeNode _700_searchBST(TreeNode root, int val) {
	while (root != null) {
	    if (val < root.val)
		root = root.left;
	    else if (val > root.val)
		root = root.right;
	    else
		return root;
	}

	return root;
    }

    public TreeNode _700_searchBST_v2(TreeNode root, int val) {
	if (root == null)
	    return null;

	if (val < root.val)
	    return _700_searchBST(root.left, val);
	else if (val > root.val)
	    return _700_searchBST(root.right, val);
	else
	    return root;
    }

    public MyHashSet _705_myHashSet() {
	return new MyHashSet();
    }

    class MyHashSet {

	private final static int SIZE = 128 * 1024; // FIXME Time Limit Exceeded on small SIZE 128

	public class HashEntry {
	    private int value;
	    HashEntry next;

	    HashEntry(int value) {

		this.value = value;
	    }

	    public int getValue() {
		return value;
	    }
	}

	private HashEntry[] buckets;

	public MyHashSet() {
	    this.buckets = new HashEntry[SIZE];
	}

	public void add(int value) {
	    int hash = getHash(value);

	    HashEntry hashEntry = buckets[hash];
	    if (hashEntry == null)
		buckets[hash] = new HashEntry(value);
	    else {
		while (hashEntry != null) {
		    if (hashEntry.value == value) {
			hashEntry.value = value;
			break;
		    } else {
			if (hashEntry.next != null)
			    hashEntry = hashEntry.next;
			else
			    hashEntry.next = new HashEntry(value);
		    }
		}
	    }
	}

	public void remove(int value) {
	    int hash = getHash(value);
	    HashEntry cHe = buckets[hash];
	    HashEntry pHe = null;

	    while (cHe != null) {
		if (cHe.value != value) {
		    pHe = cHe;
		    cHe = cHe.next;
		} else {
		    if (pHe == null)// Remove first
			buckets[hash] = cHe.next;
		    else if (cHe.next == null)// Remove last
			pHe.next = null;
		    else // Remove middle
			pHe.next = cHe.next;

		    break;
		}
	    }
	}

	public boolean contains(int value) {
	    HashEntry he = buckets[getHash(value)];

	    if (he != null)
		while (he != null)
		    if (he.getValue() == value)
			return true;

	    return false;
	}

	private int getHash(int value) {
	    return value * 31 % SIZE;
	}
    }

    public String _709_toLowerCase(String str) {
	if (str == null || str.isBlank())
	    return str;

	StringBuilder sb = new StringBuilder();

	for (Character sChar : str.toCharArray()) {
	    if (sChar >= 65 && sChar <= 90)
		sb.append((char) (sChar + 32));
	    else
		sb.append(sChar);
	}

	return sb.toString();
    }

    public List<Integer> _728_selfDividingNumbers(int left, int right) {
	List<Integer> values = new ArrayList<>();

	for (; left <= right; left++) {
	    int number = left;
	    int noSelfDividing = 0;

	    while (number > 0) {
		int digit = number % 10;
		number = number / 10;

		if (digit == 0 || left % digit != 0) {
		    noSelfDividing++;
		    break;
		}
	    }

	    if (noSelfDividing == 0)
		values.add(left);
	}
	return values;
    }

    public int _771_numJewelsInStones(String J, String S) {
	Map<Character, Integer> map = new HashMap<>();

	for (char charS : S.toCharArray())
	    map.put(charS, map.getOrDefault(charS, 0) + 1);

	int count = 0;

	for (char charJ : J.toCharArray())
	    count += map.getOrDefault(charJ, 0);

	return count;
    }

    public boolean _796_rotateString(String A, String B) {
	if (A.length() != B.length())
	    return false;

	return (A + A).contains(B);
    }

    public int _804_uniqueMorseRepresentations(String[] words) {
	String[] MORS = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
		".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
		"--.." };
	Set<String> set = new HashSet<>();

	for (String word : words) {
	    StringBuilder sb = new StringBuilder();
	    for (char cWord : word.toCharArray())
		sb.append(MORS[cWord - 97]);
	    set.add(sb.toString());
	}

	return set.size();
    }

    public List<String> _811_subdomainVisits(String[] cpdomains) {
	Map<String, Integer> map = new HashMap<>();

	for (String cpdomain : cpdomains) {
	    String[] counterAndDomain = cpdomain.split(" ");
	    int counter = Integer.parseInt(counterAndDomain[0]);
	    String domain = counterAndDomain[1];

	    map.put(domain, counter + map.getOrDefault(domain, 0));
	    while (domain.contains(".")) {
		domain = domain.substring(domain.indexOf('.') + 1, domain.length());
		map.put(domain, counter + map.getOrDefault(domain, 0));
	    }
	}

	return map.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey())
		.collect(Collectors.toList());
    }

    public int[] _821_shortestToChar(String S, char C) {
	Set<Integer> cSet = new HashSet<>();
	int[] values = new int[S.length()];

	for (int i = 0; i < S.length(); i++)
	    if (S.charAt(i) == C)
		cSet.add(i);

	for (int i = 0; i < values.length; i++) {
	    int index = i;
	    int nearestIndex = cSet.stream().min((f1, f2) -> Math.abs(f1 - index) - Math.abs(f2 - index)).get();
	    values[i] = Math.abs(i - nearestIndex);
	}

	return values;
    }

    public int[][] _832_flipAndInvertImage(int[][] A) {
	int rLength = A.length;
	int cLength = A[0].length;
	int[][] B = new int[rLength][cLength];

	for (int row = 0; row < rLength; row++)
	    for (int aCol = 0, bCol = cLength - 1; aCol < cLength; aCol++, bCol--)
		B[row][bCol] = 1 - A[row][aCol];

	return B;
    }

    public boolean _844_backspaceCompare(String S, String T) {
	Deque<Character> stack = new LinkedList<>();

	for (Character cChar : S.toCharArray())
	    if (cChar != '#')
		stack.push(cChar);
	    else if (!stack.isEmpty())
		stack.pop();

	S = stack.stream().map(o -> String.valueOf(o)).collect(Collectors.joining());
	stack = new LinkedList<>();

	for (Character cChar : T.toCharArray())
	    if (cChar != '#')
		stack.push(cChar);
	    else if (!stack.isEmpty())
		stack.pop();

	T = stack.stream().map(o -> String.valueOf(o)).collect(Collectors.joining());

	return S.equals(T);
    }

    public int _852_peakIndexInMountainArray(int[] A) {
	int l = 0;
	int h = A.length - 1;

	while (l < h) {
	    int m = l + (h - l) / 2;
	    if (A[m] < A[m + 1])
		l = m + 1;
	    else
		h = m;
	}

	return l;
    }

    public ListNode _876_middleNode(ListNode head) {
	ListNode slow = head;
	ListNode fast = head;

	while (fast != null && fast.next != null) {
	    fast = fast.next.next;
	    slow = slow.next;
	}

	return slow;
    }

    public int[] _905_sortArrayByParity(int[] A) {
	int[] B = new int[A.length];

	for (int i = 0, j = A.length - 1, k = 0; k < A.length; k++)
	    if (A[k] % 2 == 0)
		B[i++] = A[k];
	    else
		B[j--] = A[k];

	return B;
    }

    public int[] _922_sortArrayByParityII(int[] A) {
	int[] B = new int[A.length];

	for (int i = 0, j = 1, k = 0; k < A.length; k++)
	    if (A[k] % 2 == 0) {
		B[i] = A[k];
		i = i + 2;
	    } else {
		B[j] = A[k];
		j = j + 2;
	    }

	return B;
    }

    public int _929_numUniqueEmails(String[] emails) {
	Set<String> uniqueEmails = new HashSet<>();

	for (String email : emails) {
	    String[] sEmail = email.split("@");

	    sEmail[0] = sEmail[0].replace(".", "");

	    if (sEmail[0].contains("+"))
		sEmail[0] = sEmail[0].substring(0, sEmail[0].indexOf('+'));

	    uniqueEmails.add(sEmail[0] + "@" + sEmail[1]);
	}

	return uniqueEmails.size();
    }

    public String[] _937_reorderLogFiles(String[] logs) {
	Arrays.sort(logs, (log1, log2) -> {
	    String[] split1 = log1.split(" ", 2);
	    String[] split2 = log2.split(" ", 2);

	    if (Character.isAlphabetic(split1[1].charAt(0)) && Character.isAlphabetic(split2[1].charAt(0))) {
		int cmp = split1[1].compareTo(split2[1]);
		if (cmp != 0)
		    return cmp;
		else
		    return split1[0].compareTo(split2[0]);
	    } else if (Character.isDigit(split1[1].charAt(0)) && Character.isDigit(split2[1].charAt(0)))
		return 0;
	    else {
		if (Character.isAlphabetic(split1[1].charAt(0)))
		    return -1;
		else
		    return 1;
	    }
	});

	return logs;
    }

    public int _938_rangeSumBST(TreeNode root, int L, int R) {
	if (root == null)
	    return 0;

	int sum = 0;
	Deque<TreeNode> stack = new LinkedList<>();
	stack.addLast(root);

	while (!stack.isEmpty()) {
	    TreeNode tn = stack.removeLast();

	    if (tn.val >= L && tn.val <= R)
		sum += tn.val;

	    if (tn.left != null)
		stack.addLast(tn.left);
	    if (tn.right != null)
		stack.addLast(tn.right);
	}

	return sum;
    }

    public int[] _942_diStringMatch(String S) {
	int n = S.length();
	int left = 0;
	int right = S.length();

	int[] values = new int[n + 1];

	for (int i = 0; i < n; i++)
	    values[i] = S.charAt(i) == 'I' ? left++ : right--;

	values[n] = left;// or right, doesn't matter, the same

	return values;
    }

    public int _944_minDeletionSize(String[] A) {
	int count = 0;

	for (int col = 0; col < A[0].length(); col++)
	    for (int row = 1; row < A.length; row++)
		if (A[row - 1].charAt(col) > A[row].charAt(col)) {
		    count++;
		    break;
		}

	return count;
    }

    public int _961_repeatedNTimes(int[] A) {
	int n = A.length / 2;

	Map<Integer, Integer> map = new HashMap<>();

	for (int a : A)
	    map.put(a, map.getOrDefault(a, 0) + 1);

	return map.entrySet().stream().filter(entry -> entry.getValue() == n).findFirst().get().getKey();
    }

    public int[] _977_sortedSquares(int[] A) {
	int[] B = new int[A.length];
	int left = 0;
	int right = A.length - 1;
	int index = A.length - 1;

	while (left <= right) {
	    if (A[left] * A[left] >= A[right] * A[right]) {
		B[index--] = A[left] * A[left];
		left++;
	    } else {
		B[index--] = A[right] * A[right];
		right--;
	    }
	}

	return B;
    }

    public List<String> _1002_commonChars(String[] A) {
	List<String> commonChars = new ArrayList<>();

	for (char commonChar = 'a'; commonChar <= 'z'; commonChar++) {
	    int min = Integer.MAX_VALUE;

	    for (String a : A) {
		int count = 0;

		for (char cChar : a.toCharArray())
		    if (cChar == commonChar)
			count++;

		min = Math.min(min, count);
	    }

	    while (min-- > 0)
		commonChars.add(String.valueOf(commonChar));
	}

	return commonChars;
    }

    public TreeNode _1008_bstFromPreorder(int[] nums) {
	TreeNode root = new TreeNode(nums[0]);

	Deque<TreeNode> s = new LinkedList<>();

	s.push(root);

	for (int i = 1; i < nums.length; ++i) {
	    TreeNode temp = null;

	    while (!s.isEmpty() && nums[i] > s.peek().val)
		temp = s.pop();

	    if (temp != null) {
		temp.right = new TreeNode(nums[i]);
		s.push(temp.right);
	    } else {
		temp = s.peek();
		temp.left = new TreeNode(nums[i]);
		s.push(temp.left);
	    }
	}

	return root;
    }

    public String _1021_removeOuterParentheses(String S) {
	StringBuilder sb = new StringBuilder();

	int opened = 0;
	for (char c : S.toCharArray()) {
	    if (c == '(') {
		if (opened > 0)
		    sb.append(c);
		opened++;
	    }
	    if (c == ')') {
		if (opened > 1)
		    sb.append(c);
		opened--;
	    }
	}

	return sb.toString();
    }

    public int _1046_lastStoneWeight(int[] stones) {
	PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

	for (int stone : stones)
	    queue.add(stone);

	while (queue.size() >= 2) {
	    int stone1 = queue.poll();
	    int stone2 = queue.poll();
	    int stone3 = Math.abs(stone1 - stone2);

	    if (stone3 != 0)
		queue.add(stone3);
	}

	return queue.isEmpty() ? 0 : queue.peek();
    }

    public String _1047_removeDuplicates(String S) {
	if (S == null)
	    return null;

	Stack<Character> stack = new Stack<>(); // FIXME change to Deque and stream() iterate like stack, not like queue

	for (char cChar : S.toCharArray())
	    if (!stack.isEmpty() && stack.peek() == cChar)
		stack.pop();
	    else
		stack.push(cChar);

	return stack.stream().map(v -> String.valueOf(v)).collect(Collectors.joining());
    }

    public int _1051_heightChecker(int[] heights) {
	int[] sHeights = heights.clone();
	Arrays.sort(sHeights);

	int count = 0;

	for (int i = 0; i < heights.length; i++)
	    if (heights[i] != sHeights[i])
		count++;

	return count;
    }

    public String[] _1078_findOcurrences(String text, String first, String second) {
	String[] sText = text.split(" ");
	List<String> thirds = new ArrayList<>();

	for (int i = 2; i < sText.length; i++)
	    if (sText[i - 2].equals(first) && sText[i - 1].equals(second))
		thirds.add(sText[i]);

	return thirds.toArray(new String[thirds.size()]);
    }

    public void _1089_duplicateZeros(int[] arr) {
	for (int i = 0; i < arr.length; i++)
	    if (arr[i] == 0) {
		for (int j = arr.length - 1; j >= i + 1; j--)
		    arr[j] = arr[j - 1];

		i++;
		if (i < arr.length)
		    arr[i] = 0;
	    }
    }

    public String _1108_defangIPaddr(String address) {
	if (address == null)
	    return null;

	return address.replace(".", "[.]");
    }

    public int[] _1122_relativeSortArray(int[] arr1, int[] arr2) {
	List<Integer> sArr = new ArrayList<>();

	Map<Integer, Long> mapArr1 = Arrays.stream(arr1).boxed()
		.collect(Collectors.groupingBy(val -> val, Collectors.counting()));
	List<Integer> lArr2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
	List<Integer> subArr1 = Arrays.stream(arr1).boxed().filter(v -> !lArr2.contains(v)).sorted()
		.collect(Collectors.toList());

	for (int num : arr2)
	    if (mapArr1.containsKey(num))
		for (int i = 0; i < mapArr1.get(num); i++)
		    sArr.add(num);

	for (int num : subArr1)
	    sArr.add(num);

	return sArr.stream().mapToInt(i -> i).toArray();
    }

    public int _1154_dayOfYear(String date) {
	String[] sDate = date.split("-");

	int year = Integer.parseInt(sDate[0]);
	int month = Integer.parseInt(sDate[1]);
	int day = Integer.parseInt(sDate[2]);
	int leapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ? 1 : 0;

	int[] days = { 31, 28 + leapYear, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	int dayOfYear = 0;

	for (int i = 0; i < month - 1; i++)
	    dayOfYear += days[i];

	return dayOfYear + day;
    }

    public int _1160_countCharacters(String[] words, String chars) {
	int counter = 0;

	for (String word : words) {
	    String tmpWord = "";
	    String tmpChars = chars;
	    for (Character wordChar : word.toCharArray()) {
		if (tmpChars.contains(wordChar.toString())) {
		    tmpWord += wordChar;
		    tmpChars = tmpChars.replaceFirst(wordChar.toString(), "");
		}
	    }

	    if (word.equals(tmpWord))
		counter += word.length();
	}
	return counter;
    }

    public int _1360_daysBetweenDates(String sDate1, String sDate2) {
	int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	int[] date1 = _1360_daysBetweenDates_parse(sDate1);
	int[] date2 = _1360_daysBetweenDates_parse(sDate2);

	int daysDate1 = date1[0] * 365 + date1[2];
	int daysDate2 = date2[0] * 365 + date2[2];

	for (int i = 0; i < date1[1] - 1; i++)
	    daysDate1 += monthDays[i];

	for (int i = 0; i < date2[1] - 1; i++)
	    daysDate2 += monthDays[i];

	daysDate1 += _1360_daysBetweenDates_countLeapYear(date1[0], date1[1]);
	daysDate2 += _1360_daysBetweenDates_countLeapYear(date2[0], date2[1]);

	return Math.abs(daysDate2 - daysDate1);
    }

    public int _1360_daysBetweenDates_countLeapYear(int year, int month) {
	if (month <= 2)
	    year--;

	return year / 4 - year / 100 + year / 400;
    }

    private int[] _1360_daysBetweenDates_parse(String date) {
	String[] sDate = date.split("-");
	return new int[] { Integer.valueOf(sDate[0]), Integer.valueOf(sDate[1]), Integer.valueOf(sDate[2]) };
    }

    public int[] _1365_smallerNumbersThanCurrent(int[] nums) {
	Map<Integer, Integer> map = new HashMap<>();
	int[] values = new int[nums.length];
	int[] sNums = nums.clone();

	Arrays.sort(sNums);

	for (int i = 0; i < nums.length; i++)
	    map.putIfAbsent(sNums[i], i); // skip duplicates, remember only first/lower index duplicates

	for (int i = 0; i < nums.length; i++)
	    values[i] = map.get(nums[i]);

	return values;
    }

    public String _1374_generateTheString(int n) {
	return n % 2 == 1 ? "a".repeat(n) : "a".repeat(n - 1) + "b";
    }

    public List<Integer> _1380_luckyNumbers(int[][] matrix) {
	Set<Integer> minRow = new HashSet<>();
	Set<Integer> maxCol = new HashSet<>();

	for (int row = 0; row < matrix.length; row++) {
	    int min = Integer.MAX_VALUE;
	    for (int col = 0; col < matrix[0].length; col++)
		min = Math.min(min, matrix[row][col]);
	    minRow.add(min);
	}

	for (int col = 0; col < matrix[0].length; col++) {
	    int max = Integer.MIN_VALUE;
	    for (int row = 0; row < matrix.length; row++)
		max = Math.max(max, matrix[row][col]);

	    maxCol.add(max);
	}

	return minRow.stream().filter(o -> maxCol.contains(o)).collect(Collectors.toList());
    }

    public int[] _1389_createTargetArray(int[] nums, int[] index) {
	List<Integer> values = new ArrayList<>();

	for (int i = 0; i < nums.length; i++)
	    values.add(index[i], nums[i]); // if exists val on specific index, shift to right

	return values.stream().mapToInt(o -> o).toArray();
    }

    public int _1394_findLucky(int[] arr) {
	Map<Integer, Long> map = Arrays.stream(arr).boxed()
		.collect(Collectors.groupingBy(o -> o, Collectors.counting()));

	return map.entrySet().stream().filter((e) -> (long) e.getKey() == e.getValue()).map(e -> e.getKey())
		.max(Integer::compareTo).orElse(-1);
    }

    public int _1399_countLargestGroup(int n) {
	Map<Integer, Integer> map = new HashMap<>();

	for (int i = 1; i <= n; i++) {
	    int sumOfDigits = _1399_countLargestGroup_sumOfDigits(i);

	    map.put(sumOfDigits, map.getOrDefault(sumOfDigits, 0) + 1);
	}

	int maxSize = map.values().stream().max(Integer::compare).get();
	int countMaxSize = (int) map.values().stream().filter(v -> v == maxSize).count();

//	int countMaxSize = map.values().stream().collect(Collectors.groupingBy(o -> o, Collectors.counting())).values()
//		.stream().max(Long::compareTo).get().intValue();

//	int maxSize = 0;
//	for (int size : map.values())
//		maxSize = size > maxSize ? size : maxSize;
//
//	int countMaxSize = 0;
//	for (int size : map.values())
//		countMaxSize = size == maxSize ? countMaxSize + 1 : countMaxSize;

	return countMaxSize;
    }

    private int _1399_countLargestGroup_sumOfDigits(int number) {
	int sum = 0;
	while (number > 0) {
	    sum += number % 10;
	    number /= 10;
	}

	return sum;
    }

    public List<Integer> _1403_minSubsequence(int[] nums) {
	if (nums == null)
	    return new ArrayList<>();

	Arrays.sort(nums);

	int sum = 0;
	for (int num : nums)
	    sum += num;

	List<Integer> results = new ArrayList<>();
	int subSum = 0;
	for (int i = nums.length - 1; i >= 0; i--) {
	    subSum += nums[i];
	    results.add(nums[i]);

	    if (subSum > sum - subSum)
		return results;

	}

	return results;
    }
}
