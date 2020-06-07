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
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

import com.kristurek.leetcode.common.ListNode;

public class Solution {

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

	private void letterCombinations(List<String> output, String digits, int i, String current, Map<Character, String> map) {
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
					if (set.contains("r" + row + val) || set.contains("c" + col + val) || set.contains("b" + cube + val))
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
		double temp = x;
		if (n == 0)
			return 1;
		temp = _50_myPow(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else {
			if (n > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
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

			if (rowBegin <= rowEnd) {
				for (int j = colEnd; j >= colBegin; j--) {
					res.add(matrix[rowEnd][j]);
				}
			}
			rowEnd--;

			if (colBegin <= colEnd) {
				for (int j = rowEnd; j >= rowBegin; j--) {
					res.add(matrix[j][colBegin]);
				}
			}
			colBegin++;
		}

		return res;
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

		current.next = head;

		k = k % length;
		for (int i = 0; i < length - k; i++)
			current = current.next;

		ListNode newH = current.next;
		current.next = null;

		return newH;
	}

	public String _71_simplifyPath(String path) {
		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

		for (String dir : path.split("/")) {
			if (dir.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (skip.contains(dir))
				;
			else
				stack.push(dir);
		}

		String res = "";
		for (String dir : stack)
			res = "/" + dir + res;

		return res.isEmpty() ? "/" : res;
	}

	public boolean _74_searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;

		int rLength = matrix.length;
		int cLength = matrix[0].length;

		int l = 0;
		int r = cLength * rLength - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;// 1,2,3,4, ->5<- ,6,7,8,9 --- 5value->4index --- 4/3=1 4%3=1 [i][j]=[1][1]=5

			int midValue = matrix[mid / cLength][mid % cLength];
			if (midValue < target)
				l = mid + 1;
			else if (midValue > target)
				r = mid - 1;
			else
				return true;
		}

		return false;
	}

	public void _75_sortColors(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		_75_sortColorsQuickSort(nums, 0, nums.length - 1);
	}

	private void _75_sortColorsQuickSort(int[] nums, int left, int right) {
		int i = left;
		int j = right;
		int pivot = left;// + (right - left) / 2;

		while (i <= j) {
			while (nums[i] < nums[pivot])
				i++;
			while (nums[j] > nums[pivot])
				j--;

			if (i <= j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;

				i++;
				j--;
			}
		}

		if (j > left)
			_75_sortColorsQuickSort(nums, left, j);
		if (i < right)
			_75_sortColorsQuickSort(nums, i, right);
	}

	public int _80_removeDuplicates(int[] nums) {
		int j = 1;
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i])
				count++;
			else
				count = 1;

			if (count <= 2) {
				nums[j++] = nums[i];
			}
		}
		return j;
	}

	public boolean _81_search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;

		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return true;
			if (nums[mid] == nums[r])
				r--;
			else if (nums[mid] < nums[r]) {
				if (target > nums[mid] && target <= nums[r])
					l = mid + 1;
				else
					r = mid - 1;
			} else {
				if (target >= nums[l] && target < nums[mid])
					r = mid - 1;
				else
					l = mid + 1;
			}
		}
		return false;
	}

	public ListNode _82_deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode fast = head;
		ListNode slow = dummy;

		slow.next = fast;
		while (fast != null) {
			while (fast.next != null && fast.val == fast.next.val) {
				fast = fast.next; // while loop to find the last node of the dups.
			}
			if (slow.next != fast) { // duplicates detected.
				slow.next = fast.next; // remove the dups.
				fast = slow.next; // reposition the fast pointer.
			} else { // no dup, move down both pointer.
				slow = slow.next;
				fast = fast.next;
			}

		}
		return dummy.next;
	}

	public ListNode _86_partition(ListNode head, int x) {
		ListNode beforeHead = new ListNode(-1);
		ListNode before = beforeHead;
		ListNode afterHead = new ListNode(-1);
		ListNode after = afterHead;

		while (head != null) {
			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}

			head = head.next;
		}

		after.next = null;
		before.next = afterHead.next;
		return beforeHead.next;
	}

	public ListNode _92_reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode tail = dummy;
		ListNode previousTail = null;
		for (int i = 0; i < m; i++) {
			previousTail = tail;
			tail = tail.next;
		}

		ListNode current = tail;
		ListNode previous = previousTail;
		ListNode tmp;

		for (int i = m; i <= n; i++) {
			tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}

		previousTail.next = previous;
		tail.next = current;

		return dummy.next;
	}

	public int _137_singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else {
				if ((map.get(nums[i]) + 1) == 3)
					map.remove(nums[i]);
				else {
					map.put(nums[i], map.get(nums[i]) + 1);
				}
			}
		}

		return map.entrySet().stream().findFirst().get().getKey();
	}

	public ListNode _142_detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();

		while (head != null) {
			if (!set.contains(head))
				set.add(head);
			else
				return head;

			head = head.next;
		}

		return null;
	}

	public int _172_trailingZeroes(int n) {
		int count = 0;

		while (n > 0) {
			n = n / 5;
			count += n;
		}

		return count;
	}

	public void _189_rotate(int[] nums, int k) {
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

		int oneDayAgo = 0; // in first iteration dummy value
		int twoDayAgo = 0; // in first iteration dummy value

		for (int num : nums) {
			int tmp = oneDayAgo;
			oneDayAgo = Math.max(twoDayAgo + num, oneDayAgo);
			twoDayAgo = tmp;
		}
		return oneDayAgo;
	}

	public int _200_numIslands(char[][] matrix) {
		int count = 0;

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1')
					count++;
				_200_numIslands_search_island(matrix, i, j);
			}

		return count;
	}

	private void _200_numIslands_search_island(char[][] matrix, int i, int j) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == '1') {
			matrix[i][j] = '0';

			_200_numIslands_search_island(matrix, i + 1, j);
			_200_numIslands_search_island(matrix, i - 1, j);
			_200_numIslands_search_island(matrix, i, j + 1);
			_200_numIslands_search_island(matrix, i, j - 1);
		}
	}

	public ListNode _203_removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode current = dummy;

		while (current.next != null) {
			if (current.next.val == val)
				current.next = current.next.next;
			else
				current = current.next;
		}

		return dummy.next;
	}

	public boolean _205_isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++)
			if (map.containsKey(s.charAt(i)))
				if (map.get(s.charAt(i)) == t.charAt(i))
					continue;
				else
					return false;
			else if (!map.containsValue(t.charAt(i)))
				map.put(s.charAt(i), t.charAt(i));
			else
				return false;

		return true;
	}

	public boolean _217_containsDuplicate(int[] nums) {
		if (nums == null)
			return false;

		Set<Integer> set = new HashSet<>();

		for (int num : nums)
			if (set.contains(num))
				return true;
			else
				set.add(num);

		return false;
	}

	public boolean _219_containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null)
			return false;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
			if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
				return true;
			else
				map.put(nums[i], i);

		return false;
	}

	public boolean _231_isPowerOfTwo(int n) {
		if (n <= 0)
			return false;

		while (n % 2 == 0)
			n /= 2;

		return n == 1;
	}

	public boolean _234_isPalindrome(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) { // odd nodes
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public boolean _202_isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (!set.contains(n)) {
			set.add(n);

			int sumOfSquare = 0;
			while (n > 0) {
				int remain = n % 10;
				sumOfSquare += remain * remain;

				n = n / 10;
			}

			if (sumOfSquare == 1)
				return true;

			n = sumOfSquare;
		}

		return false;
	}

	public void _283_moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int slow = 0;
		for (int num : nums)
			if (num != 0)
				nums[slow++] = num;

		while (slow < nums.length)
			nums[slow++] = 0;
	}

	public List<List<String>> _49_groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();

			Arrays.sort(charArray);

			String key = String.valueOf(charArray);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());

			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public String _5_longestPalindrome(String s) { // Time Limit Exceeded
		if (s == null || s.isEmpty() || s.length() == 1)
			return s;

		int iMax = 0;
		int jMax = 0;
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++)
			for (int j = i; j < chars.length; j++)
				if (_5_longestPalindrome_isPalindrome(chars, i, j) && j - i >= jMax - iMax) {
					iMax = i;
					jMax = j + 1;
				}

		return String.valueOf(Arrays.copyOfRange(chars, iMax, jMax));
	}

	private boolean _5_longestPalindrome_isPalindrome(char[] chars, int begin, int end) {
		while (begin <= end)
			if (chars[begin++] != chars[end--])
				return false;

		return true;
	}

	public boolean _844_backspaceCompare(String S, String T) {
		return _844_backspaceCompare_build(S).equals(_844_backspaceCompare_build(T));
	}

	private String _844_backspaceCompare_build(String t) {
		Deque<Character> stack = new LinkedList<>();

		for (char character : t.toCharArray()) {
			if (character != '#')
				stack.push(character);
			else if (!stack.isEmpty())
				stack.pop();
		}

		return stack.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
	}

	public int _525_findMaxLength(int[] nums) {
		return -1;
	}

	public int _1046_lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((v1, v2) -> v2 - v1);

		for (int stone : stones)
			queue.add(stone);

		while (queue.size() >= 2) {
			int val1 = queue.poll();
			int val2 = queue.poll();
			int val3 = Math.abs(val1 - val2);

			if (val3 != 0)
				queue.add(val3);
		}

		return queue.isEmpty() ? 0 : queue.element();
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
		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++)
				if (nums[j] < nums[i])
					count++;

			results.add(count);
		}

		return results.stream().mapToInt(Integer::intValue).toArray();
	}

	public String _1374_generateTheString(int n) {
		return "b" + "ab".substring(n % 2, 1 + n % 2).repeat(n - 1);
	}

	public List<Integer> _1380_luckyNumbers(int[][] matrix) {

		Set<Integer> minVal = new HashSet<>();
		for (int[] row : matrix) {
			int min = row[0];
			for (int cell : row)
				min = Math.min(min, cell);
			minVal.add(min);
		}

		Set<Integer> maxVal = new HashSet<>();
		for (int col = 0; col < matrix[0].length; col++) {
			int max = matrix[0][col];
			for (int row = 0; row < matrix.length; row++)
				max = Math.max(max, matrix[row][col]);

			maxVal.add(max);
		}

		// minVal.retainAll(maxVal);

		return minVal.stream().filter(maxVal::contains).collect(Collectors.toList());
	}

	public int[] _1389_createTargetArray(int[] nums, int[] indexs) {
		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < nums.length; i++)
			results.add(indexs[i], nums[i]);

		return results.stream().mapToInt(Integer::intValue).toArray();
	}

	public int _1399_countLargestGroup(int n) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			int sumOfDigits = _1399_countLargestGroup_sumOfDigits(i);

			map.put(sumOfDigits, map.getOrDefault(sumOfDigits, 0) + 1);
		}

		int maxSize = map.values().stream().max(Integer::compare).get();
		int countMaxSize = (int) map.values().stream().filter(v -> v == maxSize).count();

//		int maxSize = 0;
//		for (int size : map.values())
//			maxSize = size > maxSize ? size : maxSize;
//
//		int countMaxSize = 0;
//		for (int size : map.values())
//			countMaxSize = size == maxSize ? countMaxSize + 1 : countMaxSize;

		return countMaxSize;
	}

	public int _1394_findLucky(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);

		Optional<Integer> max = map.entrySet().stream().filter(e -> e.getKey() == e.getValue()).map(e -> e.getKey()).max(Integer::compare);

		return max.orElse(-1);
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
