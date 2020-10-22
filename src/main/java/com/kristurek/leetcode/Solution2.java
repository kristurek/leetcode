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
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.Node;
import com.kristurek.leetcode.common.Node2;
import com.kristurek.leetcode.common.Node3;
import com.kristurek.leetcode.common.TreeNode;

public class Solution2 {

    public int[] _1_twoSum(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();

	for (int i = 0; i < nums.length; i++) {
	    int num = target - nums[i];
	    if (map.containsKey(num))
		return new int[] { i, map.get(num) };
	    else
		map.put(nums[i], i);
	}

	throw new IllegalArgumentException("No exists solution");
    }

    public ListNode _2_addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode head = new ListNode(-1);
	ListNode current = head;

	int carry = 0;

	while (l1 != null || l2 != null) {
	    int num1 = l1 != null ? l1.val : 0;
	    int num2 = l2 != null ? l2.val : 0;

	    int sum = num1 + num2 + carry;

	    carry = sum / 10;
	    current.next = new ListNode(sum % 10);

	    current = current.next;
	    if (l1 != null)
		l1 = l1.next;
	    if (l2 != null)
		l2 = l2.next;
	}

	if (carry != 0)
	    current.next = new ListNode(carry);

	return head.next;
    }

    public int _3_lengthOfLongestSubstring(String s) {
	String currentSubS = "";
	String maxSubS = "";

	for (int slow = 0; slow < s.length(); slow++) {
	    currentSubS = String.valueOf(s.charAt(slow));

	    for (int fast = slow + 1; fast < s.length(); fast++) {
		if (!currentSubS.contains(String.valueOf(s.charAt(fast))))
		    currentSubS += String.valueOf(s.charAt(fast));
		else
		    break;
	    }

	    if (currentSubS.length() > maxSubS.length())
		maxSubS = currentSubS;
	}

	return maxSubS.length();
    }

    public double _4_findMedianSortedArrays(int[] nums1, int[] nums2) {
	int[] nums = new int[nums1.length + nums2.length];

	for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
	    if (j < nums1.length && k < nums2.length)
		if (nums1[j] < nums2[k])
		    nums[i] = nums1[j++];
		else
		    nums[i] = nums2[k++];
	    else if (j < nums1.length)
		nums[i] = nums1[j++];
	    else
		nums[i] = nums2[k++];
	}

	if (nums.length % 2 == 0)
	    return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
	else
	    return nums[nums.length / 2];
    }

    public String _5_longestPalindrome(String s) {
	if (s == null || s.isEmpty())
	    return s;

	String max = s.substring(0, 1);

	for (int i = 0; i < s.length(); i++) {
	    String tmp = _5_longestPalindrome_extends(s, i, i);
	    if (tmp.length() > max.length())
		max = tmp;

	    tmp = _5_longestPalindrome_extends(s, i, i + 1);
	    if (tmp.length() > max.length())
		max = tmp;
	}

	return max;
    }

    private String _5_longestPalindrome_extends(String s, int begin, int end) {
	while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
	    begin--;
	    end++;
	}

	return s.substring(begin + 1, end);
    }

    public int _7_reverse(int x) {
	int minus = 1;
	if (x < 0)
	    minus = -1;

	x = Math.abs(x);

	long number = 0;

	while (x > 0) {
	    number = number * 10 + x % 10;

	    x /= 10;
	}

	if (number > Integer.MAX_VALUE || number < Integer.MIN_VALUE)
	    return 0;

	return (int) number * minus;
    }

    public boolean _9_isPalindrome(int x) {
	if (x < 0)
	    return false;

	return x == _7_reverse(x);
    }

    public int _11_maxArea(int[] height) {
	int left = 0;
	int right = height.length - 1;
	int maxArea = 0;

	while (left < right) {
	    int localArea = Math.min(height[left], height[right]) * (right - left);
	    maxArea = Math.max(maxArea, localArea);

	    if (height[left] < height[right])
		left++;
	    else
		right--;
	}

	return maxArea;
    }

    public String _12_intToRoman(int num) {
	Map<Integer, String> map = new LinkedHashMap<Integer, String>();
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

	StringBuilder sb = new StringBuilder();

	for (Map.Entry<Integer, String> entry : map.entrySet()) {
	    while (num / entry.getKey() > 0) {
		sb.append(entry.getValue());
		num = num - entry.getKey();
	    }
	}

	return sb.toString();
    }

    public int _13_romanToInt(String s) {
	int number = 0;

	for (int slow = 0, fast = 1; fast < s.length(); slow++, fast++)
	    if (_13_romanToInt(s.charAt(slow)) < _13_romanToInt(s.charAt(fast)))
		number -= _13_romanToInt(s.charAt(slow));
	    else
		number += _13_romanToInt(s.charAt(slow));

	return number + _13_romanToInt(s.charAt(s.length() - 1));
    }

    private int _13_romanToInt(char cChar) {
	switch (cChar) {
	case 'M':
	    return 1000;
	case 'D':
	    return 500;
	case 'C':
	    return 100;
	case 'L':
	    return 50;
	case 'X':
	    return 10;
	case 'V':
	    return 5;
	case 'I':
	    return 1;
	default:
	    throw new IllegalArgumentException();
	}
    }

    public String _14_longestCommonPrefix(String[] strs) {
	String longestPrefix = strs[0];

	for (int i = longestPrefix.length() - 1; i >= 0; i--)
	    for (String str : strs)
		if (i >= str.length() || str.charAt(i) != longestPrefix.charAt(i)) {
		    longestPrefix = longestPrefix.substring(0, i);
		    break;
		}

	return longestPrefix;
    }

    public List<List<Integer>> _15_threeSum(int[] nums) {
	Set<List<Integer>> groups = new HashSet<>();

	Arrays.sort(nums);

	for (int i = 0; i < nums.length; i++) {
	    int l = i + 1;
	    int h = nums.length - 1;

	    while (l < h) {
		if (nums[i] + nums[l] + nums[h] < 0)
		    l++;
		else if (nums[i] + nums[l] + nums[h] > 0)
		    h--;
		else
		    groups.add(Arrays.asList(nums[i], nums[l++], nums[h--]));
	    }
	}

	return new ArrayList<>(groups);
    }

    public int _16_threeSumClosest(int[] nums, int target) {
	Arrays.sort(nums);

	int closestSum = Integer.MAX_VALUE - 1;

	for (int i = 0; i < nums.length; i++) {
	    int l = i + 1;
	    int h = nums.length - 1;

	    while (l < h) {
		int sum = nums[i] + nums[l] + nums[h];

		if (Math.abs(target - sum) < Math.abs(target - closestSum))
		    closestSum = sum;

		if (sum > target)
		    h--;
		else if (sum < target)
		    l++;
		else
		    return sum;
	    }
	}

	return closestSum;
    }

    public List<String> _17_letterCombinations(String digits) {
	if (digits == null || digits.isEmpty())
	    return new ArrayList<>();

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

	_17_letterCombinations(digits.toCharArray(), output, new ArrayList<>(), 0, map);

	return output;
    }

    private void _17_letterCombinations(char[] digits, List<String> output, List<Character> tmp, int index,
	    Map<Character, List<Character>> map) {
	if (tmp.size() == digits.length)
	    output.add(tmp.stream().map(val -> String.valueOf(val)).collect(Collectors.joining()));
	else {
	    for (Character cChar : map.get(digits[index])) {
		tmp.add(cChar);
		_17_letterCombinations(digits, output, tmp, index + 1, map);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public ListNode _19_removeNthFromEnd(ListNode head, int n) {
	List<ListNode> nodes = new ArrayList<>();

	ListNode current = head;

	while (current != null) {
	    nodes.add(current);
	    current = current.next;
	}

	if (n == nodes.size())
	    return nodes.get(0).next;
	else {
	    ListNode node = nodes.get(nodes.size() - n - 1);
	    node.next = node.next.next;
	    return head;
	}
    }

    public boolean _20_isValid(String s) {
	Deque<Character> stack = new LinkedList<>();

	for (char bracked : s.toCharArray())
	    if (bracked == '(' || bracked == '[' || bracked == '{')
		stack.push(bracked);
	    else if (bracked == ')' && !stack.isEmpty() && stack.peek() == '(')
		stack.pop();
	    else if (bracked == ']' && !stack.isEmpty() && stack.peek() == '[')
		stack.pop();
	    else if (bracked == '}' && !stack.isEmpty() && stack.peek() == '{')
		stack.pop();
	    else
		return false;

	return stack.isEmpty();
    }

    public ListNode _21_mergeTwoLists(ListNode l1, ListNode l2) {
	ListNode head = new ListNode(-1);
	ListNode l3 = head;

	while (l1 != null && l2 != null) {
	    if (l1.val < l2.val) {
		l3.next = l1;

		l1 = l1.next;
		l3 = l3.next;
	    } else {
		l3.next = l2;

		l2 = l2.next;
		l3 = l3.next;
	    }
	}

	if (l1 != null)
	    l3.next = l1;

	if (l2 != null)
	    l3.next = l2;

	return head.next;
    }

    public List<String> _22_generateParenthesis(int n) {
	List<String> output = new ArrayList<>();

	_22_generateParenthesis_backtracking(output, "", n, 0, 0);

	return output;
    }

    private void _22_generateParenthesis_backtracking(List<String> output, String tmp, int n, int open, int close) {
	if (tmp.length() == 2 * n)
	    output.add(tmp);
	else {
	    if (open >= close) {
		if (open < n)
		    _22_generateParenthesis_backtracking(output, tmp + "(", n, open + 1, close);
		if (close < n)
		    _22_generateParenthesis_backtracking(output, tmp + ")", n, open, close + 1);
	    }
	}
    }

    public ListNode _23_mergeKLists(ListNode[] lists) {
	return _23_mergeKLists_divide(lists, 0, lists.length - 1);
    }

    private ListNode _23_mergeKLists_divide(ListNode[] lists, int l, int r) {
	if (l == r)
	    return lists[l];
	else if (l < r) {
	    int m = l + (r - l) / 2;

	    ListNode l1 = _23_mergeKLists_divide(lists, l, m);
	    ListNode l2 = _23_mergeKLists_divide(lists, m + 1, r);

	    return _23_mergeKLists_merge(l1, l2);
	} else
	    return null;
    }

    private ListNode _23_mergeKLists_merge(ListNode l1, ListNode l2) {
	ListNode head = new ListNode(-1);
	ListNode l3 = head;

	while (l1 != null && l2 != null) {
	    if (l1.val < l2.val) {
		l3.next = l1;

		l3 = l3.next;
		l1 = l1.next;
	    } else {
		l3.next = l2;

		l3 = l3.next;
		l2 = l2.next;
	    }
	}

	if (l1 != null)
	    l3.next = l1;

	if (l2 != null)
	    l3.next = l2;

	return head.next;
    }

    public ListNode _24_swapPairs(ListNode head) {
	if (head == null || head.next == null)
	    return head;

	ListNode dummy = new ListNode(-1);
	ListNode current = dummy;

	ListNode slow = head;
	ListNode fast = head.next;

	while (fast != null) {
	    ListNode next = fast.next;
	    slow.next = null;
	    fast.next = null;

	    current.next = fast;
	    current = current.next;
	    current.next = slow;
	    current = current.next;

	    slow = next;
	    fast = next != null ? next.next : null;
	}

	if (slow != null)
	    current.next = slow;

	return dummy.next;
    }

    public int _26_removeDuplicates(int[] nums) {
	int slow = 0;
	int fast = 0;

	while (fast < nums.length) {
	    if (nums[slow] != nums[fast])
		nums[++slow] = nums[fast];
	    fast++;
	}

	return slow + 1;
    }

    public int _27_removeElement(int[] nums, int val) {
	int slow = 0;
	int fast = 0;

	while (fast < nums.length) {
	    if (nums[fast] != val)
		nums[slow++] = nums[fast];
	    fast++;
	}

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
	int l = 0;
	int h = nums.length - 1;

	while (l < h) {
	    int m = l + (h - l) / 2;

	    if (nums[m] > nums[h])
		l = m + 1;
	    else
		h = m;
	}

	int pivot = l;

	l = 0;
	h = nums.length - 1;

	if (target >= nums[pivot] && target <= nums[h])
	    l = pivot;
	else
	    h = pivot - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;

	    if (target > nums[m])
		l = m + 1;
	    else if (target < nums[m])
		h = m - 1;
	    else
		return m;
	}

	return -1;
    }

    public int[] _34_searchRange(int[] nums, int target) {
	int l = _34_searchRange_lr(nums, target, true);
	int r = _34_searchRange_lr(nums, target, false);

	return new int[] { l, r };
    }

    public int _34_searchRange_lr(int[] nums, int target, boolean left) {
	int l = 0;
	int h = nums.length - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;

	    if (target < nums[m])
		h = m - 1;
	    else if (target > nums[m])
		l = m + 1;
	    else {
		if (left) {
		    if (m > 0 && nums[m - 1] == nums[m])
			h = m - 1;
		    else
			return m;
		} else {
		    if (m < nums.length - 1 && nums[m + 1] == nums[m])
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

	    if (target < nums[m])
		h = m - 1;
	    else if (target > nums[m])
		l = m + 1;
	    else
		return m;
	}

	return l;
    }

    public boolean _36_isValidSudoku(char[][] board) {
	Set<String> set = new HashSet<>();

	for (int row = 0; row < board.length; row++)
	    for (int col = 0; col < board[row].length; col++)
		if (Character.isDigit(board[row][col])) {

		    String r = "R" + row + board[row][col];
		    String c = "C" + col + board[row][col];
		    String b = "B" + row / 3 + col / 3 + board[row][col];

		    if (set.contains(r) || set.contains(c) || set.contains(b))
			return false;
		    else {
			set.add(r);
			set.add(c);
			set.add(b);
		    }
		}

	return true;
    }

    public List<List<Integer>> _39_combinationSum(int[] candidates, int target) {
	List<List<Integer>> output = new ArrayList<>();

	_39_combinationSum_backtracking(output, new ArrayList<>(), candidates, target, 0);

	return output;
    }

    private void _39_combinationSum_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int remain,
	    int begin) {

	if (remain == 0)
	    output.add(new ArrayList<>(tmp));
	else if (remain < 0)
	    return;
	else {
	    for (int i = begin; i < nums.length; i++) {
		tmp.add(nums[i]);
		_39_combinationSum_backtracking(output, tmp, nums, remain - nums[i], i);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public List<List<Integer>> _40_combinationSum2(int[] candidates, int target) {
	List<List<Integer>> output = new ArrayList<>();

	Arrays.sort(candidates);

	_40_combinationSum2_backtracking(output, new ArrayList<>(), candidates, target, 0);

	return output;
    }

    private void _40_combinationSum2_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int remain,
	    int begin) {

	if (remain == 0)
	    output.add(new ArrayList<>(tmp));
	else if (remain < 0)
	    return;
	else {
	    for (int i = begin; i < nums.length; i++) {
		if (i > begin && nums[i] == nums[i - 1])
		    continue;

		tmp.add(nums[i]);
		_40_combinationSum2_backtracking(output, tmp, nums, remain - nums[i], i + 1);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    public int _41_firstMissingPositive(int[] nums) {
	Arrays.sort(nums);

	int res = 1;

	for (int num : nums)
	    if (num == res)
		res++;

	return res;
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

	Arrays.sort(nums);

	_47_permuteUnique_backtracking(output, new ArrayList<>(), nums, new boolean[nums.length]);

	return output;
    }

    private void _47_permuteUnique_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums,
	    boolean[] used) {
	if (tmp.size() == nums.length) {
	    output.add(new ArrayList<>(tmp));
	} else {
	    for (int i = 0; i < nums.length; i++) {
		if (used[i] == true || (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == true))
		    continue;

		tmp.add(nums[i]);
		used[i] = true;
		_47_permuteUnique_backtracking(output, tmp, nums, used);
		tmp.remove(tmp.size() - 1);
		used[i] = false;
	    }
	}
    }

    public List<List<String>> _49_groupAnagrams(String[] strs) {
	Map<String, List<String>> map = new HashMap<>();

	for (String str : strs) {
//	    String key = str.chars().sorted()
//		    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	    char[] chars = str.toCharArray();
	    Arrays.sort(chars);

	    String key = new String(chars);

	    List<String> values = map.getOrDefault(key, new ArrayList<>());
	    values.add(str);
	    map.put(key, values);
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

    public double _50_myPow(double x, double n) {
	if (n == 0)
	    return 1;

	double temp = _50_myPow(x, n / 2.0);

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
	int max = Integer.MIN_VALUE;
	int sum = 0;

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
	List<Integer> values = new ArrayList<>();

	int colBegin = 0;
	int colEnd = matrix[0].length - 1;
	int rowBegin = 0;
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
	List<List<Integer>> output = new ArrayList<>();

	_60_getPermutation_backtracking(output, new ArrayList<>(), IntStream.range(1, n + 1).toArray());

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

	int length = 1;
	ListNode current = head;

	while (current.next != null) {
	    length++;
	    current = current.next;
	}

	k = k % length;
	current.next = head; // loop

	for (int i = 0; i < length - k; i++)
	    current = current.next;

	head = current.next;
	current.next = null;

	return head;
    }

    public int[] _66_plusOne(int[] digits) {
	for (int i = digits.length - 1; i >= 0; i--) {
	    if (digits[i] == 9)
		digits[i] = 0;
	    else {
		digits[i] = digits[i] + 1;
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
	    sum += i >= 0 ? Integer.parseInt(String.valueOf(a.charAt(i--))) : 0;
	    sum += j >= 0 ? Integer.parseInt(String.valueOf(b.charAt(j--))) : 0;

	    sb.append(sum % 2);
	    carry = sum / 2;
	}

	if (carry != 0)
	    sb.append(carry);

	return sb.reverse().toString();
    }

    public int _69_mySqrt(int x) {
	if (x == 0)
	    return 0;

	long l = 0;
	long h = Integer.MAX_VALUE;
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
	if (n <= 2)
	    return n;

	int firstStep = 1;
	int secondStep = 2;
	n = n - 2;

	while (n-- > 0) {
	    int tmp = firstStep;
	    firstStep = secondStep;
	    secondStep = tmp + secondStep;
	}

	return secondStep;
    }

    public String _71_simplifyPath(String path) {
	StringBuilder sb = new StringBuilder();
	String[] cmds = path.split("/");

	Deque<String> stack = new LinkedList<>();
	for (String cmd : cmds) {
	    if (cmd.equals("/") || cmd.equals("") || cmd.equals("."))
		continue;
	    else if (cmd.equals("..")) {
		if (!stack.isEmpty())
		    stack.pop();
	    } else
		stack.push(cmd);

	}

	if (stack.isEmpty())
	    sb.append("/");
	else
	    while (!stack.isEmpty())
		sb.append("/" + stack.pollLast());

	return sb.toString();
    }

    public void _73_setZeroes(int[][] matrix) {
	Set<Integer> rows = new HashSet<>();
	Set<Integer> cols = new HashSet<>();

	for (int row = 0; row < matrix.length; row++)
	    for (int col = 0; col < matrix[row].length; col++)
		if (matrix[row][col] == 0) {
		    rows.add(row);
		    cols.add(col);
		}

	for (int row = 0; row < matrix.length; row++)
	    for (int col = 0; col < matrix[row].length; col++)
		if (cols.contains(col) || rows.contains(row))
		    matrix[row][col] = 0;
    }

    public boolean _74_searchMatrix(int[][] matrix, int target) {
	if (matrix == null || matrix.length == 0)
	    return false;

	int l = 0;
	int h = matrix.length * matrix[0].length - 1;

	while (l <= h) {
	    int m = l + (h - l) / 2;
	    int col = m % matrix[0].length;
	    int row = m / matrix[0].length;

	    if (target < matrix[row][col])
		h = m - 1;
	    else if (target > matrix[row][col])
		l = m + 1;
	    else
		return true;
	}

	return false;
    }

    public void _75_sortColors(int[] nums) {
	_75_sortColors_quicksort(nums, 0, nums.length - 1);
    }

    private void _75_sortColors_quicksort(int[] nums, int l, int h) {
	if (l <= h) {
	    int splitPoint = _75_sortColors_partition(nums, l, h);

	    _75_sortColors_quicksort(nums, l, splitPoint - 1);
	    _75_sortColors_quicksort(nums, splitPoint + 1, h);
	}

    }

    private int _75_sortColors_partition(int[] nums, int left, int right) {
	int pivot = nums[right];
	int lowerIndex = left - 1;

	for (int currentIndex = left; currentIndex < right; currentIndex++) {
	    if (nums[currentIndex] < pivot) {
		lowerIndex++;

		int tmp = nums[currentIndex];
		nums[currentIndex] = nums[lowerIndex];
		nums[lowerIndex] = tmp;
	    }
	}

	lowerIndex++;
	int tmp = nums[lowerIndex];
	nums[lowerIndex] = nums[right];
	nums[right] = tmp;

	return lowerIndex;
    }

    public List<List<Integer>> _77_combine(int n, int k) {
	List<List<Integer>> output = new ArrayList<>();
	int[] nums = IntStream.range(1, n + 1).toArray();

	_77_combine_backtracking(output, new ArrayList<>(), nums, k, 0);

	return output;
    }

    private void _77_combine_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int k, int begin) {
	if (tmp.size() == k)
	    output.add(new ArrayList<>(tmp));
	else {
	    for (int i = begin; i < nums.length; i++) {
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

    private void _78_subsets_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int begin) {
	output.add(new ArrayList<>(tmp));

	for (int i = begin; i < nums.length; i++) {
	    tmp.add(nums[i]);
	    _78_subsets_backtracking(output, tmp, nums, i + 1);
	    tmp.remove(tmp.size() - 1);
	}
    }

    public boolean _79_exist(char[][] board, String word) {
	char[] wChars = word.toCharArray();

	for (int row = 0; row < board.length; row++)
	    for (int col = 0; col < board[row].length; col++)
		if (_79_exist_search(board, wChars, row, col, 0))
		    return true;

	return false;
    }

    private boolean _79_exist_search(char[][] board, char[] wChars, int row, int col, int i) {
	if (i == wChars.length)
	    return true;
	if (row < 0 || row >= board.length || col < 0 || col >= board[row].length)
	    return false;

	if (board[row][col] == wChars[i]) {
	    char tmp = board[row][col];
	    board[row][col] = '*';

	    boolean isFound = _79_exist_search(board, wChars, row + 1, col, i + 1)
		    || _79_exist_search(board, wChars, row - 1, col, i + 1)
		    || _79_exist_search(board, wChars, row, col + 1, i + 1)
		    || _79_exist_search(board, wChars, row, col - 1, i + 1);

	    board[row][col] = tmp;

	    return isFound;
	} else
	    return false;
    }

    public int _80_removeDuplicates(int[] nums) {
	int slow = 1;
	int count = 1;

	for (int fast = 1; fast < nums.length; fast++) {
	    if (nums[fast] == nums[fast - 1])
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

	    if (target == nums[m])
		return true;
	    else if (nums[m] == nums[h])
		h--;
	    else if (nums[m] == nums[l])
		l++;
	    else if (nums[m] > nums[h]) {// unsorted
		if (target >= nums[l] && target < nums[m])
		    h = m - 1;
		else
		    l = m + 1;
	    } else if (nums[m] < nums[h]) {// sorted
		if (target > nums[m] && target <= nums[h])
		    l = m + 1;
		else
		    h = m - 1;
	    }
	}

	return false;
    }

    public ListNode _82_deleteDuplicates(ListNode head) {
	if (head == null || head.next == null)
	    return head;

	ListNode dummy = new ListNode(-1);
	dummy.next = head;

	ListNode slow = dummy;
	ListNode fast = dummy.next;

	while (fast != null) {
	    while (fast.next != null && fast.val == fast.next.val)
		fast = fast.next;

	    if (slow.next != fast) {
		slow.next = fast.next;
		fast = slow.next;
	    } else {
		slow = slow.next;
		fast = fast.next;
	    }
	}

	return dummy.next;
    }

    public ListNode _83_deleteDuplicates(ListNode head) {
	if (head == null || head.next == null)
	    return head;

	ListNode curr = head;
	ListNode fast = head;

	while (fast != null) {
	    if (curr.val == fast.val)
		fast = fast.next;
	    else {
		curr.next = fast;
		curr = curr.next;

		fast = fast.next;
	    }
	}

	curr.next = null;

	return head;
    }

    public ListNode _86_partition(ListNode head, int x) {
	ListNode cNodeBeforeX = new ListNode(-1);
	ListNode hNodeBeforeX = cNodeBeforeX;

	ListNode cNodeAfterX = new ListNode(-1);
	ListNode hNodeAfterX = cNodeAfterX;

	while (head != null) {
	    if (head.val < x) {
		cNodeBeforeX.next = head;
		cNodeBeforeX = cNodeBeforeX.next;

		head = head.next;
	    } else {
		cNodeAfterX.next = head;
		cNodeAfterX = cNodeAfterX.next;

		head = head.next;
	    }
	}

	cNodeBeforeX.next = hNodeAfterX.next;
	cNodeAfterX.next = null;

	return hNodeBeforeX.next;
    }

    public void _88_merge(int[] nums1, int m, int[] nums2, int n) {
	for (int i = m + n - 1, j = m - 1, k = n - 1; i >= 0; i--) {
	    if (j >= 0 && k >= 0) {
		if (nums1[j] > nums2[k])
		    nums1[i] = nums1[j--];
		else
		    nums1[i] = nums2[k--];
	    } else {
		if (j >= 0)
		    nums1[i] = nums1[j--];
		else
		    nums1[i] = nums2[k--];
	    }
	}
    }

    public List<List<Integer>> _90_subsetsWithDup(int[] nums) {
	List<List<Integer>> output = new ArrayList<>();

	Arrays.sort(nums);

	_90_subsetsWithDup_backtracking(output, new ArrayList<>(), nums, 0);

	return output;
    }

    private void _90_subsetsWithDup_backtracking(List<List<Integer>> output, List<Integer> tmp, int[] nums, int begin) {
	output.add(new ArrayList<>(tmp));

	for (int i = begin; i < nums.length; i++) {
	    if (i > begin && nums[i - 1] == nums[i])
		continue;

	    tmp.add(nums[i]);
	    _90_subsetsWithDup_backtracking(output, tmp, nums, i + 1);
	    tmp.remove(tmp.size() - 1);
	}
    }

    public ListNode _92_reverseBetween(ListNode head, int m, int n) {
	ListNode dummy = new ListNode(-1);
	dummy.next = head;

	ListNode current = dummy;

	for (int i = 1; i < m; i++)
	    current = current.next;

	ListNode curr = current.next;
	ListNode next = null;
	ListNode prev = null;
	ListNode last = current.next;

	for (int i = m; i <= n; i++) {
	    next = curr.next;

	    curr.next = prev;
	    prev = curr;
	    curr = next;
	}

	current.next = prev;
	last.next = curr;

	return dummy.next;
    }

    public List<Integer> _94_inorderTraversal(TreeNode root) {
	if (root == null)
	    return new ArrayList<>();

	List<Integer> values = new ArrayList<>();
	Deque<TreeNode> stack = new LinkedList<>();
	TreeNode current = root;

	while (!stack.isEmpty() || current != null)
	    if (current != null) {
		stack.push(current);
		current = current.left;
	    } else {
		current = stack.pop();
		values.add(current.val);
		current = current.right;
	    }

	return values;
    }

    public boolean _98_isValidBST(TreeNode root) {
	Deque<TreeNode> stack = new LinkedList<>();
	TreeNode current = root;
	TreeNode previous = null;

	while (!stack.isEmpty() || current != null) {
	    if (current != null) {
		stack.push(current);
		current = current.left;
	    } else {
		current = stack.pop();

		if (previous != null && previous.val >= current.val)
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

	Deque<TreeNode> queue1 = new LinkedList<>();
	Deque<TreeNode> queue2 = new LinkedList<>();

	queue1.add(p);
	queue2.add(q);

	while (!queue1.isEmpty() && !queue2.isEmpty()) {
	    TreeNode tn1 = queue1.poll();
	    TreeNode tn2 = queue2.poll();

	    if (tn1.left != null && tn2.left == null || tn1.left == null && tn2.left != null)
		return false;
	    if (tn1.right != null && tn2.right == null || tn1.right == null && tn2.right != null)
		return false;
	    if (tn1.val != tn2.val)
		return false;

	    if (tn1.left != null)
		queue1.add(tn1.left);
	    if (tn1.right != null)
		queue1.add(tn1.right);

	    if (tn2.left != null)
		queue2.add(tn2.left);
	    if (tn2.right != null)
		queue2.add(tn2.right);
	}

	return queue1.isEmpty() && queue2.isEmpty();
    }

    public boolean _101_isSymmetric(TreeNode root) {
	if (root == null)
	    return true;

	Deque<TreeNode> queue1 = new LinkedList<>();
	Deque<TreeNode> queue2 = new LinkedList<>();

	queue1.add(root.left);
	queue2.add(root.right);

	while (!queue1.isEmpty() && !queue2.isEmpty()) {
	    TreeNode tn1 = queue1.poll();
	    TreeNode tn2 = queue2.poll();

	    if (tn1 == null && tn2 == null)
		continue;
	    if (tn1 == null || tn2 == null)
		return false;
	    if (tn1.val != tn2.val)
		return false;

	    queue1.add(tn1.left);
	    queue2.add(tn2.right);
	    queue1.add(tn1.right);
	    queue2.add(tn2.left);
	}

	return true;
    }

    public List<List<Integer>> _102_levelOrder(TreeNode root) {
	List<List<Integer>> levels = new ArrayList<>();

	if (root == null)
	    return levels;

	Queue<TreeNode> queue = new LinkedList<>();

	queue.add(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();
	    List<Integer> level = new ArrayList<>();

	    while (size-- > 0) {
		TreeNode tn = queue.poll();

		level.add(tn.val);

		if (tn.left != null)
		    queue.add(tn.left);
		if (tn.right != null)
		    queue.add(tn.right);
	    }

	    levels.add(level);
	}

	return levels;
    }

    public List<List<Integer>> _103_zigzagLevelOrder(TreeNode root) {
	List<List<Integer>> levels = new ArrayList<>();

	if (root == null)
	    return levels;

	int actualLevel = 0;

	Queue<TreeNode> queue = new ArrayDeque<>();

	queue.add(root);

	while (!queue.isEmpty()) {
	    actualLevel++;
	    int size = queue.size();
	    List<Integer> level = new ArrayList<>();

	    while (size-- > 0) {
		TreeNode tn = queue.poll();

		level.add(tn.val);

		if (tn.left != null)
		    queue.add(tn.left);
		if (tn.right != null)
		    queue.add(tn.right);
	    }

	    if (actualLevel % 2 == 0) {
		Collections.reverse(level);

		levels.add(level);
	    } else
		levels.add(level);
	}

	return levels;
    }

    public int _104_maxDepth(TreeNode root) {
	if (root == null)
	    return 0;

	int depth = 0;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();
	    depth++;
	    while (size-- > 0) {
		TreeNode tn = queue.poll();

		if (tn.left != null)
		    queue.add(tn.left);
		if (tn.right != null)
		    queue.add(tn.right);
	    }
	}

	return depth;
    }

    public List<List<Integer>> _107_levelOrderBottom(TreeNode root) {
	if (root == null)
	    return new ArrayList<>();

	Deque<List<Integer>> levels = new LinkedList<>();
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();
	    List<Integer> level = new ArrayList<>();

	    while (size-- > 0) {
		TreeNode tn = queue.poll();

		level.add(tn.val);

		if (tn.left != null)
		    queue.add(tn.left);
		if (tn.right != null)
		    queue.add(tn.right);
	    }

	    levels.addFirst(level);
	}

	return new ArrayList<>(levels);
    }

    public TreeNode _108_sortedArrayToBST(int[] nums) {
	return _108_sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode _108_sortedArrayToBST(int[] nums, int l, int h) {
	if (l <= h) {
	    int m = l + (h - l) / 2;

	    TreeNode tn = new TreeNode(nums[m]);

	    tn.left = _108_sortedArrayToBST(nums, l, m - 1);
	    tn.right = _108_sortedArrayToBST(nums, m + 1, h);

	    return tn;
	}
	return null;
    }

    public TreeNode _109_sortedListToBST(ListNode head) {
	List<Integer> nums = new ArrayList<>();

	while (head != null) {
	    nums.add(head.val);
	    head = head.next;
	}

	return _109_sortedListToBST(nums.stream().mapToInt(i -> i).toArray(), 0, nums.size() - 1);
    }

    private TreeNode _109_sortedListToBST(int[] nums, int l, int h) {
	if (l <= h) {
	    int m = l + (h - l) / 2;

	    TreeNode tn = new TreeNode(nums[m]);

	    tn.left = _109_sortedListToBST(nums, l, m - 1);
	    tn.right = _109_sortedListToBST(nums, m + 1, h);

	    return tn;
	}
	return null;
    }

    public boolean _110_isBalanced(TreeNode root) {
	if (root == null)
	    return true;

	int mLeft = _110_isBalanced_max(root.left);
	int mRight = _110_isBalanced_max(root.right);

	return Math.abs(mLeft - mRight) <= 1 && _110_isBalanced(root.left) && _110_isBalanced(root.right);
    }

    private int _110_isBalanced_max(TreeNode root) {
	if (root == null)
	    return 0;

	int actualLevel = 0;

	Queue<TreeNode> queue = new ArrayDeque<>();

	queue.add(root);

	while (!queue.isEmpty()) {
	    actualLevel++;
	    int size = queue.size();
	    while (size-- > 0) {
		TreeNode tn = queue.poll();

		if (tn.left != null)
		    queue.add(tn.left);
		if (tn.right != null)
		    queue.add(tn.right);
	    }
	}

	return actualLevel;
    }

    public int _111_minDepth(TreeNode root) {
	if (root == null)
	    return 0;

	Queue<TreeNode> queue = new LinkedList<>();

	queue.add(root);

	int level = 0;

	while (!queue.isEmpty()) {
	    level++;
	    int size = queue.size();
	    while (size-- > 0) {
		TreeNode tn = queue.poll();

		if (tn.left == null && tn.right == null)
		    return level;

		if (tn.left != null)
		    queue.add(tn.left);
		if (tn.right != null)
		    queue.add(tn.right);
	    }
	}

	return level;
    }

    public boolean _112_hasPathSum(TreeNode root, int sum) {
	if (root == null)
	    return false;

	Deque<TreeNode> stack = new LinkedList<>();
	Deque<Integer> paths = new LinkedList<>();

	stack.add(root);
	paths.add(root.val);

	while (!stack.isEmpty()) {
	    TreeNode tn = stack.pop();
	    Integer path = paths.pop();

	    if (tn.left == null && tn.right == null && path == sum)
		return true;

	    if (tn.right != null) {
		stack.push(tn.right);
		paths.push(path + tn.right.val);
	    }
	    if (tn.left != null) {
		stack.push(tn.left);
		paths.push(path + tn.left.val);
	    }
	}

	return false;
    }

    public List<List<Integer>> _113_pathSum(TreeNode root, int sum) {
	class PathEntry {
	    int sum;
	    List<Integer> path;

	    public PathEntry(int sum, List<Integer> path) {
		super();
		this.sum = sum;
		this.path = path;
	    }
	}

	if (root == null)
	    return new ArrayList<>();

	List<List<Integer>> validPaths = new ArrayList<>();
	Deque<TreeNode> stack = new LinkedList<>();
	Deque<PathEntry> paths = new LinkedList<>();

	stack.push(root);
	paths.push(new PathEntry(root.val, Arrays.asList(root.val)));

	while (!stack.isEmpty()) {
	    TreeNode tn = stack.pop();
	    PathEntry pathEntry = paths.pop();

	    if (tn.left == null && tn.right == null && pathEntry.sum == sum)
		validPaths.add(new ArrayList<>(pathEntry.path));

	    if (tn.right != null) {
		stack.push(tn.right);
		List<Integer> pValues = new ArrayList<>(pathEntry.path);
		pValues.add(tn.right.val);
		paths.push(new PathEntry(pathEntry.sum + tn.right.val, pValues));
	    }
	    if (tn.left != null) {
		stack.push(tn.left);
		List<Integer> pValues = new ArrayList<>(pathEntry.path);
		pValues.add(tn.left.val);
		paths.push(new PathEntry(pathEntry.sum + tn.left.val, pValues));
	    }
	}

	return validPaths;
    }

    public void _114_flatten(TreeNode root) {
	if (root == null)
	    return;

	Deque<TreeNode> stack = new LinkedList<>();
	stack.push(root);

	TreeNode previous = null;

	while (!stack.isEmpty()) {

	    TreeNode tn = stack.pop();

	    TreeNode left = tn.left;
	    TreeNode right = tn.right;

	    tn.left = null;
	    tn.right = null;

	    if (previous == null)
		previous = tn;
	    else {
		previous.right = tn;
		previous = previous.right;
	    }

	    if (right != null)
		stack.push(right);
	    if (left != null)
		stack.push(left);
	}
    }

    public Node3 _116_connect(Node3 root) {
	if (root == null)
	    return null;

	Queue<Node3> queue = new LinkedList<>();
	queue.add(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();

	    while (size-- > 0) {
		Node3 node = queue.poll();

		node.next = size == 0 ? null : queue.peek();

		if (node.left != null)
		    queue.add(node.left);
		if (node.right != null)
		    queue.add(node.right);
	    }
	}

	return root;
    }

    public Node3 _117_connect(Node3 root) {
	if (root == null)
	    return null;

	Queue<Node3> queue = new LinkedList<>();
	queue.add(root);

	while (!queue.isEmpty()) {
	    int size = queue.size();

	    while (size-- > 0) {
		Node3 node = queue.poll();

		node.next = size == 0 ? null : queue.peek();

		if (node.left != null)
		    queue.add(node.left);
		if (node.right != null)
		    queue.add(node.right);
	    }
	}

	return root;
    }

    public List<List<Integer>> _118_generate(int numRows) {
	List<List<Integer>> rows = new ArrayList<>();

	if (numRows == 0)
	    return rows;
	rows.add(Arrays.asList(1));
	if (numRows == 1)
	    return rows;
	rows.add(Arrays.asList(1, 1));
	if (numRows == 2)
	    return rows;

	for (int i = 2; i < numRows; i++) {
	    List<Integer> row = new ArrayList<>();

	    for (int j = 0; j <= i; j++) {
		if (j == 0)
		    row.add(1);
		else if (j == i)
		    row.add(1);
		else
		    row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
	    }

	    rows.add(row);
	}

	return rows;
    }

    public List<Integer> _119_getRow(int rowIndex) {
	List<List<Integer>> rows = new ArrayList<>();

	rows.add(Arrays.asList(1));
	if (rowIndex == 0)
	    return rows.get(rowIndex);

	rows.add(Arrays.asList(1, 1));
	if (rowIndex == 1)
	    return rows.get(rowIndex);

	for (int i = 2; i <= rowIndex; i++) {
	    List<Integer> row = new ArrayList<>();
	    for (int j = 0; j <= i; j++) {
		if (j == 0)
		    row.add(1);
		else if (j == i)
		    row.add(1);
		else
		    row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
	    }

	    rows.add(row);
	}

	return rows.get(rowIndex);
    }

    public int _121_maxProfit(int[] nums) {
	if (nums.length <= 1)
	    return 0;

	int max = 0;
	int min = nums[0];

	for (int i = 1; i < nums.length; i++)
	    if (nums[i] < min)
		min = nums[i];
	    else if (nums[i] - min > max)
		max = nums[i] - min;

	return max;

    }

    public int _122_maxProfit(int[] nums) {
	if (nums.length == 0)
	    return 0;

	int max = 0;

	for (int i = 1; i < nums.length; i++)
	    if (nums[i] - nums[i - 1] > 0)
		max += nums[i] - nums[i - 1];

	return max;
    }

    public boolean _125_isPalindrome(String s) {
	if (s == null)
	    return true;

	s = s.toLowerCase();
	int l = 0;
	int r = s.length() - 1;

	while (l < r) {
	    if (!Character.isAlphabetic(s.charAt(l)) && !Character.isDigit(s.charAt(l)))
		l++;
	    else if (!Character.isAlphabetic(s.charAt(r)) && !Character.isDigit(s.charAt(r)))
		r--;
	    else if (s.charAt(l) != s.charAt(r))
		return false;
	    else {
		l++;
		r--;
	    }
	}

	return true;
    }

    public int _129_sumNumbers(TreeNode root) {
	if (root == null)
	    return 0;

	Deque<TreeNode> stack = new LinkedList<>();
	Deque<Integer> sums = new LinkedList<>();

	int sumOfNumbers = 0;

	stack.push(root);
	sums.push(root.val);

	while (!stack.isEmpty()) {
	    TreeNode tn = stack.pop();
	    int sum = sums.pop();

	    if (tn.left == null && tn.right == null)
		sumOfNumbers += sum;

	    if (tn.right != null) {
		stack.push(tn.right);
		sums.push(sum * 10 + tn.right.val);
	    }
	    if (tn.left != null) {
		stack.push(tn.left);
		sums.push(sum * 10 + tn.left.val);
	    }
	}

	return sumOfNumbers;
    }

    public void _130_solve(char[][] board) {
	for (int row = 1; row < board.length - 1; row++)
	    for (int col = 1; col < board[row].length - 1; col++)
		if (board[row][col] == 'O')
		    check(board, col, row);
    }

    private void check(char[][] board, int col, int row) {
	if (row == 0 || col == 0 || row == board.length - 1 || col == board[row].length - 1)
	    return;

	if (row - 1 == 0 && board[row - 1][col] == 'O')
	    return;

	if (row + 1 == board.length - 1 && board[row + 1][col] == 'O')
	    return;

	if (col - 1 == 0 && board[row][col - 1] == 'O')
	    return;

	if (col + 1 == board.length - 1 && board[row][col + 1] == 'O')
	    return;

	if (row - 1 == 0 && board[row - 1][col] == 'X' || row + 1 == board.length - 1 && board[row + 1][col] == 'X'
		|| col - 1 == 0 && board[row][col - 1] == 'O'
		|| col + 1 == board.length - 1 && board[row][col + 1] == 'O')
	    board[row][col] = 'X';
    }

    public List<List<String>> _131_partition(String s) {
	List<List<String>> output = new ArrayList<>();

	_131_partition_backtracking(output, new ArrayList<>(), s, 0);

	return output;
    }

    private void _131_partition_backtracking(List<List<String>> output, List<String> tmp, String s, int begin) {
	if (begin == s.length())
	    output.add(new ArrayList<>(tmp));

	for (int i = begin; i < s.length(); i++) {
	    String ss = s.substring(begin, i + 1);

	    if (_131_partition_isPalindorme(ss)) {

		tmp.add(ss);
		_131_partition_backtracking(output, tmp, s, i + 1);
		tmp.remove(tmp.size() - 1);
	    }
	}
    }

    private boolean _131_partition_isPalindorme(String ss) {
	int l = 0;
	int r = ss.length() - 1;
	while (l < r)
	    if (ss.charAt(l++) != ss.charAt(r--))
		return false;

	return true;
    }

    public Node _133_cloneGraph(Node node) {
	if (node == null)
	    return null;

	Map<Integer, Node> map = new HashMap<>();
	Queue<Node> queue = new LinkedList<>();

	map.put(node.val, new Node(node.val));
	queue.add(node);

	while (!queue.isEmpty()) {
	    Node n = queue.poll();
	    for (Node child : n.children) {
		if (!map.containsKey(child.val)) {
		    map.put(child.val, new Node(child.val));
		    queue.add(child);
		}
		map.get(n.val).children.add(map.get(child.val));
	    }
	}

	return map.get(node.val);
    }

    public int _136_singleNumber(int[] nums) {
	Set<Integer> set = new HashSet<>();

	for (int num : nums)
	    if (set.contains(num))
		set.remove(num);
	    else
		set.add(num);

	return set.iterator().next();
    }

    public int _137_singleNumber(int[] nums) {
	Arrays.sort(nums);

	int i = 2;
	while (i < nums.length) {
	    if (nums[i - 2] != nums[i])
		return nums[i - 2];

	    i = i + 3;
	}

	if (nums.length < 3)
	    return nums[0];

	return nums[nums.length - 1];
    }

    public Node2 _138_copyRandomList(Node2 head) {
	if (head == null)
	    return head;

	Map<Node2, Node2> map = new HashMap<>();

	Deque<Node2> stack = new LinkedList<>();
	stack.push(head);

	Node2 current = head;

	while (current != null) {
	    map.put(current, new Node2(current.val));
	    current = current.next;
	}

	while (!stack.isEmpty()) {
	    Node2 node = stack.pop();

	    map.get(node).next = map.getOrDefault(node.next, null);
	    map.get(node).random = map.getOrDefault(node.random, null);

	    if (node.next != null)
		stack.push(node.next);
	}

	return map.get(head);
    }

    public boolean _139_wordBreak(String target, List<String> wordDict) {
	List<String> output = new ArrayList<>();

	wordBreak_backtracking(output, target, "", wordDict);

	return output.size() > 0;
    }

    private void wordBreak_backtracking(List<String> output, String target, String tmp, List<String> wordDict) {
	if (tmp.length() > target.length())
	    return;
	else if (tmp.toString().equals(target))
	    output.add(tmp.toString());
	else
	    for (int i = 0; i < wordDict.size(); i++)
		wordBreak_backtracking(output, target, tmp + wordDict.get(i), wordDict);
    }

    public boolean _141_hasCycle(ListNode head) {
	Set<ListNode> set = new HashSet<>();
	ListNode current = head;

	while (current != null) {
	    if (set.contains(current.next))
		return true;

	    set.add(current);
	    current = current.next;
	}

	return false;
    }

    public ListNode _142_detectCycle(ListNode head) {
	Set<ListNode> set = new HashSet<>();

	ListNode current = head;

	while (current != null) {
	    if (set.contains(current.next))
		return current.next;

	    set.add(current);
	    current = current.next;
	}

	return null;
    }

    // 1 2 3 4 5
    // 1 2
    // 5 4 3
    // 1 5 2 4 3
    public void _143_reorderList(ListNode head) {
	if (head == null || head.next == null)
	    return;

	ListNode slow = head;
	ListNode fast = head.next.next;

	while (fast != null && fast.next != null) {
	    slow = slow.next;
	    fast = fast.next.next;
	}

	ListNode current = slow.next;
	slow.next = null;
	ListNode previous = null;
	ListNode next = null;

	while (current != null) {
	    next = current.next;

	    current.next = previous;

	    previous = current;
	    current = next;
	}

	current = head;
	ListNode middle = previous;

	while (current != null && current.next != null) {
	    ListNode tmp = current.next;

	    current.next = middle;

	    middle = middle.next;
	    current.next.next = tmp;
	    current = tmp;
	}

	current.next = middle;
    }

    public List<Integer> _144_preorderTraversal(TreeNode root) {
	if (root == null)
	    return new ArrayList<>();

	List<Integer> values = new ArrayList<>();
	Deque<TreeNode> stack = new LinkedList<>();
	stack.push(root);

	while (!stack.isEmpty()) {
	    TreeNode tn = stack.pop();

	    values.add(tn.val);

	    if (tn.right != null)
		stack.push(tn.right);
	    if (tn.left != null)
		stack.push(tn.left);
	}

	return values;
    }

    public List<Integer> _145_postorderTraversal(TreeNode root) {
	if (root == null)
	    return new ArrayList<>();

	Deque<TreeNode> stack1 = new LinkedList<>();
	Deque<TreeNode> stack2 = new LinkedList<>();
	List<Integer> values = new ArrayList<>();

	stack1.push(root);

	while (!stack1.isEmpty()) {
	    TreeNode tn = stack1.pop();

	    stack2.push(tn);

	    if (tn.left != null)
		stack1.push(tn.left);
	    if (tn.right != null)
		stack1.push(tn.right);
	}

	while (!stack2.isEmpty())
	    values.add(stack2.pop().val);

	return values;
    }

    class LRUCache {

	class Node5 {
	    public Node5(int key2, int value) {
		key=key2;
		val = value;
	    }

	    int key;
	    int val;
	    Node5 next;
	    Node5 previous;
	}

	private Map<Integer, Node5> map;
	private Node5 head;
	private Node5 tail;
	private int capacity;

	public LRUCache(int size) {
	    capacity = size;
	    map = new HashMap<>();

	    head = new Node5(0, 0);
	    tail = new Node5(0, 0);

	    head.next = tail;
	    tail.previous = head;
	}

	public int get(int key) {
	    if (!map.containsKey(key))
		return -1;

	    Node5 node = map.get(key);
	    updateNode(node);

	    return node.val;
	}

	public void put(int key, int value) {
	    if (map.size() < capacity)
		if (!map.containsKey(key)) {
		    Node5 node = new Node5(key, value);

		    addNode(node);
		    map.put(key, node);
		} else {
		    Node5 node = map.get(key);
		    node.val = value;

		    updateNode(node);
		}
	    else {
		if (!map.containsKey(key)) {
		    Node5 node = new Node5(key, value);

		    map.remove(tail.previous.key);
		    removeNode(tail.previous);

		    addNode(node);
		    map.put(key, node);
		} else {
		    Node5 node = map.get(key);
		    node.val = value;

		    updateNode(node);
		}
	    }
	}

	private void updateNode(Node5 node) {
	    removeNode(node);
	    addNode(node);
	}

	private void removeNode(Node5 node) {
	    Node5 before = node.previous;
	    Node5 after = node.next;

	    before.next = after;
	    after.previous = before;
	}

	private void addNode(Node5 node) {
	    Node5 after = head.next;
	    head.next = node;
	    node.previous = head;
	    node.next = after;
	    after.previous = node;
	}
    }

    public LRUCache _146_lruCache(int capacity) {
	return new LRUCache(capacity);
    }

}
