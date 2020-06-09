package com.kristurek.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

	public int _543_diameterOfBinaryTree(TreeNode root) {
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
}
