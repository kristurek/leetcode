package com.kristurek.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.kristurek.leetcode.common.Employee;
import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.Node;
import com.kristurek.leetcode.common.TreeNode;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Solution2Test {

    private Solution2 solution = new Solution2();

    @Test
    void solution() {
	assertNotNull(solution);
    }

    @Test
    void _1_twoSum() {
	assertArrayEquals(new int[] { 1, 0 }, solution._1_twoSum(new int[] { 2, 7, 11, 15 }, 9));
	assertArrayEquals(new int[] { 3, 0 }, solution._1_twoSum(new int[] { 2, 7, 11, 15 }, 17));
    }

    @Test
    void _2_addTwoNumbers() {
	ListNode l1 = new ListNode(2);
	l1.next = new ListNode(4);
	l1.next.next = new ListNode(3);

	ListNode l2 = new ListNode(5);
	l2.next = new ListNode(6);
	l2.next.next = new ListNode(4);

	ListNode l3 = solution._2_addTwoNumbers(l1, l2);

	assertEquals(7, l3.val);
	assertEquals(0, l3.next.val);
	assertEquals(8, l3.next.next.val);
    }

    @Test
    void _3_lengthOfLongestSubstring() {
	assertEquals(3, solution._3_lengthOfLongestSubstring("abcabcbb"));
	assertEquals(1, solution._3_lengthOfLongestSubstring("bbbbb"));
	assertEquals(3, solution._3_lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void _3_lengthOfLongestSubstring_v2() {
	assertEquals(3, solution._3_lengthOfLongestSubstring_v2("abcabcbb"));
	assertEquals(1, solution._3_lengthOfLongestSubstring_v2("bbbbb"));
	assertEquals(3, solution._3_lengthOfLongestSubstring_v2("pwwkew"));
    }

    @Test
    void _5_longestPalindrome() {
	assertEquals("bab", solution._5_longestPalindrome("babad"));
	assertEquals("bb", solution._5_longestPalindrome("cbbd"));
	assertEquals("a", solution._5_longestPalindrome("a"));
	assertEquals("a", solution._5_longestPalindrome("abc"));
	assertEquals("bb", solution._5_longestPalindrome("abb"));

	String expected = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
	String input = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
	assertEquals(expected, solution._5_longestPalindrome(input));
    }

    @Test
    void _7_reverse() {
	assertEquals(321, solution._7_reverse(123));
	assertEquals(-321, solution._7_reverse(-123));
	assertEquals(21, solution._7_reverse(120));
    }

    @Test
    void _9_isPalindrome() {
	assertTrue(solution._9_isPalindrome(121));
	assertTrue(solution._9_isPalindrome(0));
	assertFalse(solution._9_isPalindrome(-123));
	assertFalse(solution._9_isPalindrome(10));
    }

    @Test
    void _11_maxArea() {
	assertEquals(49, solution._11_maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    @Test
    void _12_intToRoman() {
	assertEquals("III", solution._12_intToRoman(3));
	assertEquals("IV", solution._12_intToRoman(4));
	assertEquals("IX", solution._12_intToRoman(9));
	assertEquals("LVIII", solution._12_intToRoman(58));
	assertEquals("MCMXCIV", solution._12_intToRoman(1994));
    }

    @Test
    void _13_romanToInt() {
	assertEquals(3, solution._13_romanToInt("III"));
	assertEquals(4, solution._13_romanToInt("IV"));
	assertEquals(9, solution._13_romanToInt("IX"));
	assertEquals(58, solution._13_romanToInt("LVIII"));
	assertEquals(1994, solution._13_romanToInt("MCMXCIV"));
    }

    @Test
    void _14_longestCommonPrefix() {
	assertEquals("fl", solution._14_longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
	assertEquals("", solution._14_longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
    }

    @Test
    void _15_threeSum() {
	List<List<Integer>> answer = solution._15_threeSum(new int[] { -1, 0, 1, 2, -1 });
	List<List<Integer>> l = new ArrayList<>();
	l.add(Arrays.asList(-1, -1, 2));
	l.add(Arrays.asList(-1, 0, 1));

	assertThat(answer, is(l));

	answer = solution._15_threeSum(new int[] { 0, 0, 0, 0 });
	l = new ArrayList<>();
	l.add(Arrays.asList(0, 0, 0));

	assertThat(answer, is(l));

	answer = solution._15_threeSum(new int[] { -2, 0, 1, 1, 2 });
	l = new ArrayList<>();
	l.add(Arrays.asList(-2, 1, 1));
	l.add(Arrays.asList(-2, 0, 2));

	assertThat(answer, is(l));
    }

    @Test
    void _16_threeSumClosest() {
	assertEquals(0, solution._16_threeSumClosest(new int[] { -2, 0, 1, 1, 2 }, 0));
	assertEquals(2, solution._16_threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
    }

    @Test
    void _17_letterCombinations() {
	assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
		solution._17_letterCombinations("23"));
    }

    @Test
    void _18_fourSum() {
	List<List<Integer>> answer = solution._18_fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
	List<List<Integer>> l = new ArrayList<>();

	l.add(Arrays.asList(-2, 0, 0, 2));
	l.add(Arrays.asList(-2, -1, 1, 2));
	l.add(Arrays.asList(-1, 0, 0, 1));

	assertThat(answer, is(l));
    }

    @Test
    void _19_removeNthFromEnd() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);

	head = solution._19_removeNthFromEnd(head, 3);

	assertEquals(2, head.val);
	assertEquals(3, head.next.val);
    }

    @Test
    void _20_isValid() {
	assertTrue(solution._20_isValid("()"));
	assertTrue(solution._20_isValid("()[]{}"));
	assertFalse(solution._20_isValid("(]"));
	assertFalse(solution._20_isValid("([)]"));
	assertTrue(solution._20_isValid("{[]}"));
    }

    @Test
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

    @Test
    void _22_generateParenthesis() {
	List<String> list = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
	assertThat(solution._22_generateParenthesis(3), is(list));
    }

    @Test
    void _26_removeDuplicates() {
	int[] arr = new int[] { 1, 1, 1, 2, 2, 2 };

	assertEquals(2, solution._26_removeDuplicates(arr));

	assertEquals(1, arr[0]);
	assertEquals(2, arr[1]);
    }

    @Test
    void _27_removeElement() {
	int[] arr = new int[] { 1, 1, 2 };

	assertEquals(1, solution._27_removeElement(arr, 1));

	assertEquals(2, arr[0]);
    }

    @Test
    void _28_strStr() {
	assertEquals(2, solution._28_strStr("hello", "ll"));
	assertEquals(-1, solution._28_strStr("aaaaa", "bba"));
    }

    @Test
    void _33_search() {
	assertEquals(4, solution._33_search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
	assertEquals(-1, solution._33_search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
    }

    @Test
    void _34_searchRange() {
	assertArrayEquals(new int[] { 3, 4 }, solution._34_searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
	assertArrayEquals(new int[] { -1, -1 }, solution._34_searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
    }

    @Test
    void _35_searchInsert() {
	assertEquals(2, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 5));
	assertEquals(1, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 2));
	assertEquals(4, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 7));
	assertEquals(0, solution._35_searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    }

    @Test
    void _39_combinationSum() {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(Arrays.asList(2, 2, 3));
	answer.add(Arrays.asList(7));

	assertThat(solution._39_combinationSum(new int[] { 2, 3, 6, 7 }, 7), is(answer));
    }

    @Test
    void _53_maxSubArray() {
	assertEquals(6, solution._53_maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    @Test
    void _58_lengthOfLastWord() {
	assertEquals(5, solution._58_lengthOfLastWord("Hello World"));
    }

    @Test
    void _66_plusOne() {
	assertArrayEquals(IntStream.of(1, 0, 0, 0).toArray(), solution._66_plusOne(IntStream.of(9, 9, 9).toArray()));
	assertArrayEquals(IntStream.of(9, 9, 1).toArray(), solution._66_plusOne(IntStream.of(9, 9, 0).toArray()));
    }

    @Test
    void _67_addBinary() {
	assertEquals("100", solution._67_addBinary("1", "11"));
    }

    @Test
    void _69_mySqrt() {
	assertEquals(2, solution._69_mySqrt(4));
	assertEquals(4, solution._69_mySqrt(16));
	assertEquals(2, solution._69_mySqrt(8));
    }

    @Test
    void _70_climbStairs() {
	assertEquals(0, solution._70_climbStairs(0));
	assertEquals(1, solution._70_climbStairs(1));
	assertEquals(2, solution._70_climbStairs(2));
	assertEquals(3, solution._70_climbStairs(3));
	assertEquals(5, solution._70_climbStairs(4));
	assertEquals(8, solution._70_climbStairs(5));
    }

    @Test
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

    @Test
    void _88_merge() {
	int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
	int[] nums2 = new int[] { 2, 5, 6 };
	int[] nums3 = new int[] { 1, 2, 2, 3, 5, 6 };

	solution._88_merge(nums1, 3, nums2, 3);

	assertArrayEquals(nums3, nums1);
    }

    @Test
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

    @Test
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

    @Test
    void _104_maxDepth() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.right = new TreeNode(4);

	assertEquals(3, solution._104_maxDepth(root));
    }

    @Test
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

    @Test
    void _108_sortedArrayToBST() {
	TreeNode root = solution._108_sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
	assertEquals(0, root.val);
	assertEquals(-10, root.left.val);
	assertEquals(5, root.right.val);
	assertEquals(-3, root.left.right.val);
	assertEquals(9, root.right.right.val);
    }

    @Test
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

    @Test
    void _111_minDepth() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.right.left = new TreeNode(6);

	assertEquals(3, solution._111_minDepth(root));
    }

    @Test
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

    @Test
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

    @Test
    void _119_getRow() {
	List<Integer> results = solution._119_getRow(4);

	assertThat(results, is(Arrays.asList(1, 4, 6, 4, 1)));
    }

    @Test
    void _121_maxProfit() {
	assertEquals(5, solution._121_maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	assertEquals(0, solution._121_maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    @Test
    void _122_maxProfit() {
	assertEquals(7, solution._122_maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
	assertEquals(9, solution._122_maxProfit(new int[] { 7, 1, 5, 10 }));
	assertEquals(0, solution._122_maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    @Test
    void _125_isPalindrome() {
	assertTrue(solution._125_isPalindrome("   "));
	assertTrue(solution._125_isPalindrome("A man, a plan, a canal: Panama"));
	assertFalse(solution._125_isPalindrome("race a car"));
    }

    @Test
    void _136_singleNumber() {
	assertEquals(1, solution._136_singleNumber(new int[] { 3, 5, 1, 2, 3, 5, 2 }));
    }

    @Test
    void _141_hasCycle() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);
	head.next.next.next.next = head.next;

	assertTrue(solution._141_hasCycle(head));
    }

    @Test
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

    @Test
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

    @Test
    void _167_twoSum() {
	assertArrayEquals(new int[] { 1, 2 }, solution._167_twoSum(new int[] { 2, 7, 11, 15 }, 9));
    }

    @Test
    void _168_convertToTitle() {
	assertEquals("A", solution._168_convertToTitle(1));
	assertEquals("Z", solution._168_convertToTitle(26));
	assertEquals("AA", solution._168_convertToTitle(27));
	assertEquals("AMJ", solution._168_convertToTitle(1024));
    }

    @Test
    void _169_majorityElement() {
	assertEquals(3, solution._169_majorityElement(IntStream.of(3, 2, 3).toArray()));
	assertEquals(2, solution._169_majorityElement(IntStream.of(2, 2, 1, 1, 1, 2, 2).toArray()));
	assertEquals(3, solution._169_majorityElement(IntStream.of(3, 3, 4).toArray()));
    }

    @Test
    void _171_titleToNumber() {
	assertEquals(1, solution._171_titleToNumber("A"));
	assertEquals(26, solution._171_titleToNumber("Z"));
	assertEquals(27, solution._171_titleToNumber("AA"));
	assertEquals(1024, solution._171_titleToNumber("AMJ"));
    }

    @Test
    void _172_trailingZeroes() {
	assertEquals(0, solution._172_trailingZeroes(0));
	assertEquals(0, solution._172_trailingZeroes(4));
	assertEquals(1, solution._172_trailingZeroes(5));
	assertEquals(2, solution._172_trailingZeroes(10));
	assertEquals(7, solution._172_trailingZeroes(30));
    }

    @Test
    void _189_rotate() {
	int[] nums = IntStream.of(1, 2, 3, 4, 5, 6, 7).toArray();
	solution._189_rotate(nums, 3);

	assertArrayEquals(IntStream.of(5, 6, 7, 1, 2, 3, 4).toArray(), nums);
    }

    @Test
    void _198_rob() {
	assertEquals(4, solution._198_rob(IntStream.of(1, 2, 3, 1).toArray()));
	assertEquals(12, solution._198_rob(IntStream.of(2, 7, 9, 3, 1).toArray()));
    }

    @Test
    void _202_isHappy() {
	assertTrue(solution._202_isHappy(19));
	assertFalse(solution._202_isHappy(2));
    }

    @Test
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

    @Test
    void _205_isIsomorphic() {
	assertTrue(solution._205_isIsomorphic("egg", "add"));
	assertFalse(solution._205_isIsomorphic("foo", "bar"));
	assertTrue(solution._205_isIsomorphic("paper", "title"));
	assertFalse(solution._205_isIsomorphic("ab", "aa"));
    }

    @Test
    void _217_containsDuplicate() {
	assertFalse(solution._217_containsDuplicate(null));
	assertFalse(solution._217_containsDuplicate(new int[] {}));
	assertTrue(solution._217_containsDuplicate(new int[] { 1, 2, 3, 1 }));
	assertFalse(solution._217_containsDuplicate(new int[] { 1, 2, 3, 4 }));
	assertTrue(solution._217_containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

    @Test
    void _219_containsNearbyDuplicate() {
	assertTrue(solution._219_containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
	assertTrue(solution._219_containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));
	assertFalse(solution._219_containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
    }

    @Test
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

    @Test
    void _231_isPowerOfTwo() {
	assertTrue(solution._231_isPowerOfTwo(1));
	assertTrue(solution._231_isPowerOfTwo(16));
	assertFalse(solution._231_isPowerOfTwo(218));
    }

    @Test
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

    @Test
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

    @Test
    public void _700_searchBST() {
	TreeNode root = new TreeNode(4);

	root.left = new TreeNode(2);
	root.right = new TreeNode(7);

	root.left.left = new TreeNode(1);
	root.left.right = new TreeNode(3);

	assertEquals(root.left, solution._700_searchBST(root, 2));
    }

    @Test
    public void _705_myHashSet() {
	Solution2.MyHashSet myHashSet = solution._705_myHashSet();

	myHashSet.add(3);
	assertTrue(myHashSet.contains(3));
	myHashSet.remove(3);
	assertFalse(myHashSet.contains(3));
	myHashSet.add(3);
	myHashSet.add(9);
	assertTrue(myHashSet.contains(3));
	assertFalse(myHashSet.contains(1));
    }

    @Test
    public void _709_toLowerCase() {
	assertEquals("", solution._709_toLowerCase(""));
	assertNull(solution._709_toLowerCase(null));
	assertEquals("123!~", solution._709_toLowerCase("123!~"));
	assertEquals("abc", solution._709_toLowerCase("abc"));
	assertEquals("abc", solution._709_toLowerCase("ABC"));
	assertEquals("abcd", solution._709_toLowerCase("aBcD"));
    }

    @Test
    public void _728_selfDividingNumbers() {
	List<Integer> list = Arrays.asList((new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22 }));
	assertEquals(list, solution._728_selfDividingNumbers(1, 22));
    }

    @Test
    public void _771_numJewelsInStones() {
	assertEquals(3, solution._771_numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    void _796_rotateString() {
	assertTrue(solution._796_rotateString("abcde", "cdeab"));
	assertFalse(solution._796_rotateString("abcde", "abced"));
    }

    @Test
    public void _804_uniqueMorseRepresentations() {
	assertEquals(2, solution._804_uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
    }

    @Test
    public void _811_subdomainVisits() {
	List<String> answer = Arrays.asList("9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com");

	assertThat(solution._811_subdomainVisits(new String[] { "9001 discuss.leetcode.com" }),
		containsInAnyOrder(answer.toArray()));

	answer = Arrays.asList("901 mail.com", "50 yahoo.com", "900 google.mail.com", "5 wiki.org", "5 org",
		"1 intel.mail.com", "951 com");

	assertThat(
		solution._811_subdomainVisits(
			new String[] { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" }),
		containsInAnyOrder(answer.toArray()));
    }

    @Test
    public void _821_shortestToChar() {
	int[] answer = new int[] { 3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0 };

	assertArrayEquals(answer, solution._821_shortestToChar("loveleetcode", 'e'));
    }

    @Test
    public void _832_flipAndInvertImage() {
	assertArrayEquals(new int[][] { { 1, 0, 0 } }, solution._832_flipAndInvertImage(new int[][] { { 1, 1, 0 } }));
	assertArrayEquals(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } },
		solution._832_flipAndInvertImage(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } }));
    }

    @Test
    void _844_backspaceCompare() {
	assertTrue(solution._844_backspaceCompare("", ""));
	assertTrue(solution._844_backspaceCompare("ab#c", "ad#c"));
	assertTrue(solution._844_backspaceCompare("ab##", "c#d#"));
	assertTrue(solution._844_backspaceCompare("a##c", "#a#c"));
	assertFalse(solution._844_backspaceCompare("a#c", "b"));
    }

    @Test
    public void _852_peakIndexInMountainArray() {
	assertEquals(1, solution._852_peakIndexInMountainArray(new int[] { 0, 1, 0 }));
	assertEquals(1, solution._852_peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
    }

    @Test
    public void _876_middleNode() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);

	assertEquals(3, solution._876_middleNode(head).val);
    }

    @Test
    public void _905_sortArrayByParity() {
	assertArrayEquals(new int[] { 2, 4, 3, 1 }, solution._905_sortArrayByParity(new int[] { 1, 2, 3, 4 }));
    }

    @Test
    public void _922_sortArrayByParityII() {
	assertArrayEquals(new int[] { 4, 5, 2, 7 }, solution._922_sortArrayByParityII(new int[] { 4, 2, 5, 7 }));
    }

    @Test
    public void _929_numUniqueEmails() {
	assertEquals(2, solution._929_numUniqueEmails(new String[] { "test.email+alex@leetcode.com",
		"test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));

	assertEquals(1, solution
		._929_numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.email@leetcode.com" }));
    }

    @Test
    public void _937_reorderLogFiles() {
	String[] expected = new String[] { "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1",
		"dig2 3 6" };
	assertArrayEquals(expected, solution._937_reorderLogFiles(
		new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" }));
    }

    @Test
    public void _938_rangeSumBST() {
	TreeNode root = new TreeNode(10);
	root.left = new TreeNode(5);
	root.right = new TreeNode(15);
	root.left.left = new TreeNode(3);
	root.left.right = new TreeNode(7);
	root.right.right = new TreeNode(18);

	assertEquals(32, solution._938_rangeSumBST(root, 7, 15));
    }

    @Test
    public void _942_diStringMatch() {
	assertArrayEquals(new int[] { 0, 4, 1, 3, 2 }, solution._942_diStringMatch("IDID"));
	assertArrayEquals(new int[] { 3, 2, 0, 1 }, solution._942_diStringMatch("DDI"));
	assertArrayEquals(new int[] { 0, 1, 2, 3 }, solution._942_diStringMatch("III"));
	assertArrayEquals(new int[] { 3, 2, 1, 0 }, solution._942_diStringMatch("DDD"));
    }

    @Test
    public void _944_minDeletionSize() {
	assertEquals(1, solution._944_minDeletionSize(new String[] { "cba", "daf", "ghi" }));
	assertEquals(2, solution._944_minDeletionSize(new String[] { "rrjk", "furt", "guzm" }));
	assertEquals(3, solution._944_minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
    }

    @Test
    public void _961_repeatedNTimes() {
	assertEquals(3, solution._961_repeatedNTimes(new int[] { 1, 2, 3, 3 }));
	assertEquals(2, solution._961_repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
	assertEquals(5, solution._961_repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
    }

    @Test
    public void _1002_commonChars() {
	assertThat(solution._1002_commonChars(new String[] { "bella", "label", "roller" }),
		containsInAnyOrder(new String[] { "e", "l", "l" }));
	assertThat(solution._1002_commonChars(new String[] { "cool", "lock", "cook" }),
		containsInAnyOrder(new String[] { "c", "o" }));
    }

    @Test
    public void _1021_removeOuterParentheses() {
	assertEquals("()()()()(())", solution._1021_removeOuterParentheses("(()())(())(()(()))"));
	assertEquals("()()()", solution._1021_removeOuterParentheses("(()())(())"));
	assertEquals("", solution._1021_removeOuterParentheses("()()"));
    }

    @Test
    void _1046_lastStoneWeight() {
	assertThat(solution._1046_lastStoneWeight(IntStream.of(2, 7, 4, 1, 8, 1).toArray()), is(equalTo(1)));
    }

    @Test
    public void _1047_removeDuplicates() {
	assertEquals("ca", solution._1047_removeDuplicates("abbaca"));
	assertEquals("a", solution._1047_removeDuplicates("a"));
	assertEquals("", solution._1047_removeDuplicates(""));
	assertNull(solution._1047_removeDuplicates(null));
    }

    @Test
    public void _1051_heightChecker() {
	assertEquals(3, solution._1051_heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
    }

    @Test
    public void _1078_findOcurrences() {
	assertArrayEquals(new String[] { "girl", "student" },
		solution._1078_findOcurrences("alice is a good girl she is a good student", "a", "good"));
	assertArrayEquals(new String[] { "we", "rock" },
		solution._1078_findOcurrences("we will we will rock you", "we", "will"));
    }

    @Test
    void _1089_duplicateZeros() {
	int[] param = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
	solution._1089_duplicateZeros(param);

	assertArrayEquals(new int[] { 1, 0, 0, 2, 3, 0, 0, 4 }, param);
    }

    @Test
    public void _1108_defangIPaddr() {
	assertEquals("192[.]168[.]1[.]1", solution._1108_defangIPaddr("192.168.1.1"));
    }

    @Test
    public void _1122_relativeSortArray() {
	int[] answer = new int[] { 2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19 };

	assertArrayEquals(answer, solution._1122_relativeSortArray(new int[] { 2, 3, 1, 3, 2, 4, 6, 19, 9, 2, 7 },
		new int[] { 2, 1, 4, 3, 9, 6 }));
    }

    @Test
    void _1154_dayOfYear() {
	assertEquals(9, solution._1154_dayOfYear("2019-01-09"));
	assertEquals(41, solution._1154_dayOfYear("2019-02-10"));
	assertEquals(60, solution._1154_dayOfYear("2003-03-01"));
	assertEquals(61, solution._1154_dayOfYear("2004-03-01"));
    }

    @Test
    void _1160_countCharacters() {
	assertEquals(6, solution._1160_countCharacters(new String[] { "cat", "bt", "hat", "tree" }, "attach"));
	assertEquals(10,
		solution._1160_countCharacters(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));

	assertEquals(0, solution._1160_countCharacters(new String[] {
		"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
		"ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
		"boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
		"nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
		"hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
		"juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
		"oxgaskztzroxuntiwlfyufddl",
		"tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
		"qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv",
		"sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
		"hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
		"cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob",
		"qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
		"qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs" },
		"usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp"));
    }

    @Test
    void _1360_daysBetweenDates() {
	assertThat(solution._1360_daysBetweenDates("2019-06-29", "2019-06-30"), is(equalTo(1)));
	assertThat(solution._1360_daysBetweenDates("2020-01-15", "2019-12-31"), is(equalTo(15)));
    }

    @Test
    void _1365_smallerNumbersThanCurrent() {
	assertArrayEquals(IntStream.of(4, 0, 1, 1, 3).toArray(),
		solution._1365_smallerNumbersThanCurrent(IntStream.of(8, 1, 2, 2, 3).toArray()));
	assertArrayEquals(IntStream.of(2, 1, 0, 3).toArray(),
		solution._1365_smallerNumbersThanCurrent(IntStream.of(6, 5, 4, 8).toArray()));
	assertArrayEquals(IntStream.of(0, 0, 0, 0).toArray(),
		solution._1365_smallerNumbersThanCurrent(IntStream.of(7, 7, 7, 7).toArray()));
    }

    @Test
    void _1374_generateTheString() {
	assertThat(solution._1374_generateTheString(4), is(equalTo("aaab")));
	assertThat(solution._1374_generateTheString(2), is(equalTo("ab")));
	assertThat(solution._1374_generateTheString(7), is(equalTo("aaaaaaa")));
    }

    @Test
    void _1380_luckyNumbers() {
	int[][] matrix = Stream.of(new int[] { 3, 7, 8 }, new int[] { 9, 11, 13 }, new int[] { 15, 16, 17 })
		.toArray(int[][]::new);

	assertThat(solution._1380_luckyNumbers(matrix), is(equalTo(Stream.of(15).collect(Collectors.toList()))));
    }

    @Test
    void _1389_createTargetArray() {
	assertArrayEquals(IntStream.of(0, 4, 1, 3, 2).toArray(), solution
		._1389_createTargetArray(IntStream.of(0, 1, 2, 3, 4).toArray(), IntStream.of(0, 1, 2, 2, 1).toArray()));
	assertArrayEquals(IntStream.of(0, 1, 2, 3, 4).toArray(), solution
		._1389_createTargetArray(IntStream.of(1, 2, 3, 4, 0).toArray(), IntStream.of(0, 1, 2, 3, 0).toArray()));
	assertArrayEquals(IntStream.of(1).toArray(),
		solution._1389_createTargetArray(IntStream.of(1).toArray(), IntStream.of(0).toArray()));
    }

    @Test
    void _1394_findLucky() {
	assertThat(solution._1394_findLucky(IntStream.of(2, 2, 3, 4).toArray()), is(equalTo(2)));
	assertThat(solution._1394_findLucky(IntStream.of(1, 2, 2, 3, 3, 3).toArray()), is(equalTo(3)));
	assertThat(solution._1394_findLucky(IntStream.of(2, 2, 2, 3, 3).toArray()), is(equalTo(-1)));
	assertThat(solution._1394_findLucky(IntStream.of(5).toArray()), is(equalTo(-1)));
    }

    @Test
    void _1399_countLargestGroup() {
	assertEquals(4, solution._1399_countLargestGroup(13));
	assertEquals(2, solution._1399_countLargestGroup(2));
	assertEquals(6, solution._1399_countLargestGroup(15));
	assertEquals(5, solution._1399_countLargestGroup(24));
    }

    @Test
    void _1403_minSubsequence() {
	assertThat(solution._1403_minSubsequence(IntStream.of(4, 3, 10, 9, 8).toArray()),
		is(Stream.of(10, 9).collect(Collectors.toList())));

	assertThat(solution._1403_minSubsequence(IntStream.of(4, 4, 7, 6, 7).toArray()),
		is(Stream.of(7, 7, 6).collect(Collectors.toList())));
    }
}
