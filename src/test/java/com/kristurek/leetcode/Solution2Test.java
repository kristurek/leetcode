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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.ListNode;
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
}
