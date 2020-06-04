package com.kristurek.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.TreeNode;

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

	public int _58_lengthOfLastWord(String s) {
		if (s == null || s.isBlank())
			return 0;

		String[] ss = s.split(" ");
		return ss[ss.length - 1].length();
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

		int l = 0;
		int h = x;
		int answer = -1;

		while (l <= h) {
			int m = l + (h - l) / 2;

			if (m * m < x) {
				l = m + 1;
				answer = m;
			} else if (m * m > x)
				h = m - 1;
			else
				return m;
		}

		return answer;
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

	public ListNode _83_deleteDuplicates(ListNode ln) {
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

	public int _121_maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int min = prices[0];// buy stock by min value
		int max = 0;// max profit -> buy min value sell max value

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
}
