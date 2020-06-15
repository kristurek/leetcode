package com.kristurek.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.kristurek.leetcode.common.Employee;
import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.Node;
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

	public int _136_singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums)
			if (set.contains(num))
				set.remove(num);
			else
				set.add(num);

		return set.stream().findFirst().get();
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
		String[] MORS = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
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

		return map.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
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
}
