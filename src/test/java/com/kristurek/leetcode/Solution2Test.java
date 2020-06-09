package com.kristurek.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.Employee;
import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.Node;
import com.kristurek.leetcode.common.TreeNode;

public class Solution2Test {

	private Solution2 solution = new Solution2();

	@Test
	void solution() {
		assertNotNull(solution);
	}

	@Test // T
	void _1_twoSum() {
		assertArrayEquals(new int[] { 1, 0 }, solution._1_twoSum(new int[] { 2, 7, 11, 15 }, 9));
		assertArrayEquals(new int[] { 3, 0 }, solution._1_twoSum(new int[] { 2, 7, 11, 15 }, 17));
	}

	@Test // T
	void _7_reverse() {
		assertEquals(321, solution._7_reverse(123));
		assertEquals(-321, solution._7_reverse(-123));
		assertEquals(21, solution._7_reverse(120));
	}

	@Test // T
	void _9_isPalindrome() {
		assertTrue(solution._9_isPalindrome(121));
		assertTrue(solution._9_isPalindrome(0));
		assertFalse(solution._9_isPalindrome(-123));
		assertFalse(solution._9_isPalindrome(10));
	}

	@Test // T
	void _13_romanToInt() {
		assertEquals(3, solution._13_romanToInt("III"));
		assertEquals(4, solution._13_romanToInt("IV"));
		assertEquals(9, solution._13_romanToInt("IX"));
		assertEquals(58, solution._13_romanToInt("LVIII"));
		assertEquals(1994, solution._13_romanToInt("MCMXCIV"));
	}

	@Test // T
	void _14_longestCommonPrefix() {
		assertEquals("fl", solution._14_longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		assertEquals("", solution._14_longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
	}

	@Test // T
	void _20_isValid() {
		assertTrue(solution._20_isValid("()"));
		assertTrue(solution._20_isValid("()[]{}"));
		assertFalse(solution._20_isValid("(]"));
		assertFalse(solution._20_isValid("([)]"));
		assertTrue(solution._20_isValid("{[]}"));
	}

	@Test // T
	void _21_mergeTwoLists() {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);

		ListNode head3 = solution._21_mergeTwoLists(head1, head2);

		assertEquals(1, head3.val);
		assertEquals(1, head3.next.val);
		assertEquals(2, head3.next.next.val);
		assertEquals(3, head3.next.next.next.val);
		assertEquals(4, head3.next.next.next.next.val);
		assertEquals(4, head3.next.next.next.next.next.val);
	}

	@Test // T
	void _26_removeDuplicates() {
		int[] arr = new int[] { 1, 1, 1, 2, 2, 2 };

		assertEquals(2, solution._26_removeDuplicates(arr));

		assertEquals(1, arr[0]);
		assertEquals(2, arr[1]);
	}

	@Test // T
	void _27_removeElement() {
		int[] arr = new int[] { 1, 1, 2 };

		assertEquals(1, solution._27_removeElement(arr, 1));

		assertEquals(2, arr[0]);
	}

	@Test // T
	void _28_strStr() {
		assertEquals(2, solution._28_strStr("hello", "ll"));
		assertEquals(-1, solution._28_strStr("aaaaa", "bba"));
	}

	@Test // T
	void _35_searchInsert() {
		assertEquals(2, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		assertEquals(1, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		assertEquals(4, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		assertEquals(0, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 0));
	}

	@Test // T
	void _53_maxSubArray() {
		assertEquals(6, solution._53_maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}

	@Test // T
	void _58_lengthOfLastWord() {
		assertEquals(5, solution._58_lengthOfLastWord("Hello World"));
	}

	@Test // T
	void _66_plusOne() {
		assertArrayEquals(IntStream.of(1, 0, 0, 0).toArray(), solution._66_plusOne(IntStream.of(9, 9, 9).toArray()));
		assertArrayEquals(IntStream.of(9, 9, 1).toArray(), solution._66_plusOne(IntStream.of(9, 9, 0).toArray()));
	}

	@Test // T
	void _67_addBinary() {
		assertEquals("100", solution._67_addBinary("1", "11"));
	}

	@Test // T
	void _69_mySqrt() {
		assertEquals(2, solution._69_mySqrt(4));
		assertEquals(4, solution._69_mySqrt(16));
		assertEquals(2, solution._69_mySqrt(8));
	}

	@Test // T
	void _70_climbStairs() {
		assertEquals(0, solution._70_climbStairs(0));
		assertEquals(1, solution._70_climbStairs(1));
		assertEquals(2, solution._70_climbStairs(2));
		assertEquals(3, solution._70_climbStairs(3));
		assertEquals(5, solution._70_climbStairs(4));
		assertEquals(8, solution._70_climbStairs(5));
	}

	@Test // T
	void _83_deleteDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(4);

		head = solution._83_deleteDuplicates(head);

		assertEquals(1, head.val);
		assertEquals(3, head.next.val);
		assertEquals(4, head.next.next.val);
		assertNull(head.next.next.next);

	}

	@Test // T
	void _88_merge() {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		int[] nums3 = new int[] { 1, 2, 2, 3, 5, 6 };

		solution._88_merge(nums1, 3, nums2, 3);

		assertArrayEquals(nums3, nums1);
	}

	@Test // T
	void _100_isSameTree() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		assertTrue(solution._100_isSameTree(root, root));
	}

	@Test // T
	void _101_isSymmetric() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		assertTrue(solution._101_isSymmetric(root));
	}

	@Test // T
	void _104_maxDepth() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.right = new TreeNode(4);

		assertEquals(3, solution._104_maxDepth(root));
	}

	@Test // T
	void _107_levelOrderBottom() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<List<Integer>> results = Arrays.asList(Arrays.asList(4, 5, 6, 7), Arrays.asList(2, 3), Arrays.asList(1));

		assertThat(solution._107_levelOrderBottom(root), is(results));
	}

	@Test // T
	void _108_sortedArrayToBST() {
		TreeNode root = solution._108_sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		assertEquals(0, root.val);
		assertEquals(-10, root.left.val);
		assertEquals(5, root.right.val);
		assertEquals(-3, root.left.right.val);
		assertEquals(9, root.right.right.val);
	}

	@Test // T
	void _110_isBalanced() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.right = new TreeNode(7);

		assertFalse(solution._110_isBalanced(root));
	}

	@Test // T
	void _111_minDepth() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(6);

		assertEquals(3, solution._111_minDepth(root));
	}

	@Test // T
	void _112_hasPathSum() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.right = new TreeNode(7);

		assertTrue(solution._112_hasPathSum(root, 7));
	}

	@Test // T
	void _118_generate() {
		List<List<Integer>> results = solution._118_generate(5);
		List<List<Integer>> allRows = new LinkedList<>();
		allRows.add(Arrays.asList(1));
		allRows.add(Arrays.asList(1, 1));
		allRows.add(Arrays.asList(1, 2, 1));
		allRows.add(Arrays.asList(1, 3, 3, 1));
		allRows.add(Arrays.asList(1, 4, 6, 4, 1));

		assertThat(results, is(allRows));
	}

	@Test // T
	void _119_getRow() {
		List<Integer> results = solution._119_getRow(4);

		assertThat(results, is(Arrays.asList(1, 4, 6, 4, 1)));
	}

	@Test // T
	void _121_maxProfit() {
		assertEquals(5, solution._121_maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		assertEquals(0, solution._121_maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	@Test // T
	void _122_maxProfit() {
		assertEquals(7, solution._122_maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		assertEquals(9, solution._122_maxProfit(new int[] { 7, 1, 5, 10 }));
		assertEquals(0, solution._122_maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	// Tested
	@Test
	void _125_isPalindrome() {
		assertTrue(solution._125_isPalindrome("   "));
		assertTrue(solution._125_isPalindrome("A man, a plan, a canal: Panama"));
		assertFalse(solution._125_isPalindrome("race a car"));
	}

	@Test // T
	void _136_singleNumber() {
		assertEquals(1, solution._136_singleNumber(new int[] { 3, 5, 1, 2, 3, 5, 2 }));
	}

	@Test // T
	void _141_hasCycle() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next;

		assertTrue(solution._141_hasCycle(head));
	}

	@Test // T
	void _155_minStack() {
		Solution2.MinStack minStack = solution._155_minStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		assertThat(minStack.getMin(), is(equalTo(-3)));
		minStack.pop();
		assertThat(minStack.top(), is(equalTo(0)));
		assertThat(minStack.getMin(), is(equalTo(-2)));
	}

	@Test // T
	void _160_getIntersectionNode() {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);

		ListNode head2 = new ListNode(7);
		head2.next = new ListNode(6);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);

		ListNode head3 = solution._160_getIntersectionNode(head1, head2);

		assertEquals(3, head3.val);
		assertEquals(4, head3.next.val);
		assertEquals(5, head3.next.next.val);
		assertNull(head3.next.next.next);
	}

	@Test // T
	void _167_twoSum() {
		assertArrayEquals(new int[] { 1, 2 }, solution._167_twoSum(new int[] { 2, 7, 11, 15 }, 9));
	}

	@Test // T
	void _168_convertToTitle() {
		assertEquals("A", solution._168_convertToTitle(1));
		assertEquals("Z", solution._168_convertToTitle(26));
		assertEquals("AA", solution._168_convertToTitle(27));
		assertEquals("AMJ", solution._168_convertToTitle(1024));
	}

	@Test // T
	void _169_majorityElement() {
		assertEquals(3, solution._169_majorityElement(IntStream.of(3, 2, 3).toArray()));
		assertEquals(2, solution._169_majorityElement(IntStream.of(2, 2, 1, 1, 1, 2, 2).toArray()));
		assertEquals(3, solution._169_majorityElement(IntStream.of(3, 3, 4).toArray()));
	}

	@Test // T
	void _171_titleToNumber() {
		assertEquals(1, solution._171_titleToNumber("A"));
		assertEquals(26, solution._171_titleToNumber("Z"));
		assertEquals(27, solution._171_titleToNumber("AA"));
		assertEquals(1024, solution._171_titleToNumber("AMJ"));
	}

	@Test // T
	void _172_trailingZeroes() {
		assertEquals(0, solution._172_trailingZeroes(0));
		assertEquals(0, solution._172_trailingZeroes(4));
		assertEquals(1, solution._172_trailingZeroes(5));
		assertEquals(2, solution._172_trailingZeroes(10));
		assertEquals(7, solution._172_trailingZeroes(30));
	}

	@Test // T
	void _189_rotate() {
		int[] nums = IntStream.of(1, 2, 3, 4, 5, 6, 7).toArray();
		solution._189_rotate(nums, 3);

		assertArrayEquals(IntStream.of(5, 6, 7, 1, 2, 3, 4).toArray(), nums);
	}

	@Test // T
	void _198_rob() {
		assertEquals(4, solution._198_rob(IntStream.of(1, 2, 3, 1).toArray()));
		assertEquals(12, solution._198_rob(IntStream.of(2, 7, 9, 3, 1).toArray()));
	}

	@Test // T
	void _202_isHappy() {
		assertTrue(solution._202_isHappy(19));
		assertFalse(solution._202_isHappy(2));
	}

	@Test // T
	void _203_removeElements() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(1);

		head = solution._203_removeElements(head, 1);

		assertEquals(2, head.val);
		assertEquals(3, head.next.val);
		assertNull(head.next.next);
	}

	@Test // T
	void _205_isIsomorphic() {
		assertTrue(solution._205_isIsomorphic("egg", "add"));
		assertFalse(solution._205_isIsomorphic("foo", "bar"));
		assertTrue(solution._205_isIsomorphic("paper", "title"));
		assertFalse(solution._205_isIsomorphic("ab", "aa"));
	}

	@Test // T
	void _217_containsDuplicate() {
		assertFalse(solution._217_containsDuplicate(null));
		assertFalse(solution._217_containsDuplicate(new int[] {}));
		assertTrue(solution._217_containsDuplicate(new int[] { 1, 2, 3, 1 }));
		assertFalse(solution._217_containsDuplicate(new int[] { 1, 2, 3, 4 }));
		assertTrue(solution._217_containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
	}

	@Test // T
	void _219_containsNearbyDuplicate() {
		assertTrue(solution._219_containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		assertTrue(solution._219_containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
		assertFalse(solution._219_containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
	}

	@Test // T
	void _226_invertTree() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		root = solution._226_invertTree(root);

		assertEquals(1, root.val);
		assertEquals(3, root.left.val);
		assertEquals(2, root.right.val);

		assertEquals(7, root.left.left.val);
		assertEquals(6, root.left.right.val);
		assertEquals(5, root.right.left.val);
		assertEquals(4, root.right.right.val);
	}

	@Test // T
	void _231_isPowerOfTwo() {
		assertTrue(solution._231_isPowerOfTwo(1));
		assertTrue(solution._231_isPowerOfTwo(16));
		assertFalse(solution._231_isPowerOfTwo(218));
	}

	@Test // T
	void _234_isPalindrome() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		assertFalse(solution._234_isPalindrome(head));

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		assertTrue(solution._234_isPalindrome(head));
	}

	@Test // T
	void _283_moveZeroes() {
		int[] nums = IntStream.of(0, 1, 0, 3, 12).toArray();
		int[] answer = IntStream.of(1, 3, 12, 0, 0).toArray();
		solution._283_moveZeroes(nums);

		assertArrayEquals(answer, nums);
	}

	@Test
	void _344_reverseString() {
		char[] actual = new char[] { 'h', 'e', 'l', 'l', 'o' };
		char[] expected = new char[] { 'o', 'l', 'l', 'e', 'h' };

		solution._344_reverseString(actual);

		assertArrayEquals(expected, actual);
	}

	@Test
	void _509_fib() {
		assertEquals(0, solution._509_fib(0));
		assertEquals(1, solution._509_fib(1));
		assertEquals(1, solution._509_fib(2));
		assertEquals(2, solution._509_fib(3));
		assertEquals(3, solution._509_fib(4));
	}

	@Test
	void _543_diameterOfBinaryTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		assertThat(solution._543_diameterOfBinaryTree(root), is(equalTo(3)));
	}

	@Test
	public void _557_reverseWords() {
		assertEquals("s'teL ekat edoCteeL tsetnoc", solution._557_reverseWords("Let's take LeetCode contest"));
	}

	@Test
	public void _561_arrayPairSum() {
		assertEquals(4, solution._561_arrayPairSum(new int[] { 1, 4, 3, 2 }));
	}

	@Test
	public void _589_preorder() {
		Node root = new Node(1, Arrays.asList(new Node(3), new Node(2), new Node(4)));
		root.children.get(0).children = Arrays.asList(new Node(5), new Node(6));

		List<Integer> answer = Arrays.asList(1, 3, 5, 6, 2, 4);

		assertEquals(answer, solution._589_preorder(root));
	}

	@Test
	public void _590_postorder() {
		Node root = new Node(1, Arrays.asList(new Node(3), new Node(2), new Node(4)));
		root.children.get(0).children = Arrays.asList(new Node(5), new Node(6));

		List<Integer> answer = Arrays.asList(5, 6, 3, 2, 4, 1);

		assertEquals(answer, solution._590_postorder(root));
	}

	@Test
	public void _617_mergeTrees() {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);

		TreeNode root2 = new TreeNode(5);
		root2.left = new TreeNode(6);
		root2.right = new TreeNode(7);
		root2.right.right = new TreeNode(8);

		TreeNode root3 = solution._617_mergeTrees(root1, root2);

		assertEquals(6, root3.val);
		assertEquals(8, root3.left.val);
		assertEquals(10, root3.right.val);
		assertEquals(4, root3.left.left.val);
		assertEquals(5, root3.left.right.val);
		assertNull(root3.right.left);
		assertEquals(8, root3.right.right.val);
	}

	@Test
	public void _657_judgeCircle() {
		assertTrue(solution._657_judgeCircle("UD"));
		assertFalse(solution._657_judgeCircle("LL"));
	}

	@Test
	public void _665_checkPossibility() {
		assertTrue(solution._665_checkPossibility(new int[] {}));
		assertTrue(solution._665_checkPossibility(new int[] { 3 }));
		assertTrue(solution._665_checkPossibility(new int[] { 4, 2, 3 }));
		assertTrue(solution._665_checkPossibility(new int[] { 2, 3, 3, 2 }));
		assertFalse(solution._665_checkPossibility(new int[] { 4, 2, 1 }));
		assertTrue(solution._665_checkPossibility(new int[] { 3, 4, 2, 4 }));
	}

	@Test
	public void _690_getImportance() {
		// [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
		List<Employee> workers = new ArrayList<>();

		Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
		Employee e2 = new Employee(2, 3, new ArrayList<>());
		Employee e3 = new Employee(3, 3, new ArrayList<>());

		workers.add(e1);
		workers.add(e2);
		workers.add(e3);

		assertEquals(11, solution._690_getImportance(workers, 1));
	}
}
