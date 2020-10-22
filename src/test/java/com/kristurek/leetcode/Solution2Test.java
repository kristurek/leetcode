package com.kristurek.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.Node;
import com.kristurek.leetcode.common.Node2;
import com.kristurek.leetcode.common.Node3;
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
    void _4_findMedianSortedArrays() {
	assertEquals(2.0, solution._4_findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
	assertEquals(2.5, solution._4_findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
	assertEquals(100000.5, solution._4_findMedianSortedArrays(new int[] { 100000 }, new int[] { 100001 }));
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
	assertEquals(-2, solution._16_threeSumClosest(new int[] { -3, -2, -5, 3, -4 }, -1));
    }

    @Test
    void _17_letterCombinations() {
	assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
		solution._17_letterCombinations("23"));
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
    void _23_mergeKLists() {
	ListNode head1 = new ListNode(1);
	head1.next = new ListNode(2);
	head1.next.next = new ListNode(4);

	ListNode head2 = new ListNode(1);
	head2.next = new ListNode(3);
	head2.next.next = new ListNode(4);

	ListNode head3 = new ListNode(5);

	ListNode head = solution._23_mergeKLists(new ListNode[] { head1, head2, head3 });

	assertEquals(1, head.val);
	assertEquals(1, head.next.val);
	assertEquals(2, head.next.next.val);
	assertEquals(3, head.next.next.next.val);
	assertEquals(4, head.next.next.next.next.val);
	assertEquals(4, head.next.next.next.next.next.val);
	assertEquals(5, head.next.next.next.next.next.next.val);
    }

    @Test
    void _24_swapPairs() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);

	head = solution._24_swapPairs(head);

	assertEquals(2, head.val);
	assertEquals(1, head.next.val);
	assertEquals(3, head.next.next.val);
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
	assertEquals(0, solution._28_strStr("a", "a"));
	assertEquals(2, solution._28_strStr("hello", "ll"));
	assertEquals(-1, solution._28_strStr("aaaaa", "bba"));
	assertEquals(-1, solution._28_strStr("mississippi", "issipi"));

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
    void _40_combinationSum2() {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(Arrays.asList(7));

	assertThat(solution._40_combinationSum2(new int[] { 2, 3, 6, 7 }, 7), is(answer));
    }

    @Test
    void _41_firstMissingPositive() {
	assertEquals(1, solution._41_firstMissingPositive(new int[] { 3, 7, 8, 9 }));
	assertEquals(2, solution._41_firstMissingPositive(new int[] { 1, 3, 7, 8, 9 }));
	assertEquals(4, solution._41_firstMissingPositive(new int[] { 1, 2, 3, 7, 8, 9 }));
	assertEquals(2, solution._41_firstMissingPositive(new int[] { -1, 1, 3, 4 }));
	assertEquals(1, solution._41_firstMissingPositive(new int[] {}));
	assertEquals(1, solution._41_firstMissingPositive(new int[] { 0 }));
    }

    @Test
    void _46_permute() {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(Arrays.asList(1, 2));
	answer.add(Arrays.asList(2, 1));

	assertThat(solution._46_permute(new int[] { 1, 2 }), is(answer));
    }

    @Test
    void _47_permuteUnique() {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(Arrays.asList(1, 1, 2));
	answer.add(Arrays.asList(1, 2, 1));
	answer.add(Arrays.asList(2, 1, 1));

	assertThat(solution._47_permuteUnique(new int[] { 1, 2, 1 }), is(answer));
    }

    @Test
    void _49_groupAnagrams() {
	String[] input = Stream.of("eat", "tea", "tan", "ate", "nat", "bat").toArray(String[]::new);

	List<String> l1 = Stream.of("eat", "tea", "ate").collect(Collectors.toList());
	List<String> l2 = Stream.of("tan", "nat").collect(Collectors.toList());
	List<String> l3 = Stream.of("bat").collect(Collectors.toList());

	List<List<String>> expected = new ArrayList<>();
	expected.add(l1);
	expected.add(l2);
	expected.add(l3);

	assertThat(solution._49_groupAnagrams(input), containsInAnyOrder(expected.toArray()));
    }

    @Test
    @Disabled
    void _50_myPow() {
	assertEquals(8, solution._50_myPow(2, 3.0));
	assertEquals(0, solution._50_myPow(2, -2147483648));
    }

    @Test
    void _53_maxSubArray() {
	assertEquals(6, solution._53_maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    @Test
    void _54_spiralOrder() {
	assertThat(solution._54_spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }),
		is(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));
    }

    @Test
    void _58_lengthOfLastWord() {
	assertEquals(5, solution._58_lengthOfLastWord("Hello World"));
    }

    @Test
    void _60_getPermutation() {
	assertEquals("213", solution._60_getPermutation(3, 3));
    }

    @Test
    void _61_rotateRight() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);

	head = solution._61_rotateRight(head, 2);

	assertEquals(3, head.val);
	assertEquals(4, head.next.val);
	assertEquals(1, head.next.next.val);
	assertEquals(2, head.next.next.next.val);
	assertNull(head.next.next.next.next);
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
	assertEquals(1, solution._69_mySqrt(2));
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
    void _71_simplifyPath() {
	assertEquals("/home", solution._71_simplifyPath("/home/"));
	assertEquals("/", solution._71_simplifyPath("/../"));
	assertEquals("/home/foo", solution._71_simplifyPath("/home//foo/"));
	assertEquals("/c", solution._71_simplifyPath("/a/./b/../../c/"));
	assertEquals("/c", solution._71_simplifyPath("/a/../../b/../c//.//"));
	assertEquals("/a/b/c", solution._71_simplifyPath("/a//b////c/d//././/.."));
    }

    @Test
    void _73_setZeroes() {
	int[][] actual = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
	int[][] expected = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };

	solution._73_setZeroes(actual);

	assertArrayEquals(expected[0], actual[0]);
	assertArrayEquals(expected[1], actual[1]);
	assertArrayEquals(expected[2], actual[2]);
    }

    @Test
    void _74_searchMatrix() {
	assertTrue(solution._74_searchMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 7));
    }

    @Test
    void _75_sortColors() {
	int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };

	solution._75_sortColors(nums);

	assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 2 }, nums);
    }

    @Test
    void _77_combine() {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(Arrays.asList(1, 2));
	answer.add(Arrays.asList(1, 3));
	answer.add(Arrays.asList(1, 4));
	answer.add(Arrays.asList(2, 3));
	answer.add(Arrays.asList(2, 4));
	answer.add(Arrays.asList(3, 4));

	assertThat(solution._77_combine(4, 2), is(answer));
    }

    @Test
    void _78_subsets() {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(Arrays.asList());
	answer.add(Arrays.asList(1));
	answer.add(Arrays.asList(1, 2));
	answer.add(Arrays.asList(1, 2, 3));
	answer.add(Arrays.asList(1, 3));
	answer.add(Arrays.asList(2));
	answer.add(Arrays.asList(2, 3));
	answer.add(Arrays.asList(3));

	assertThat(solution._78_subsets(new int[] { 1, 2, 3 }), is(answer));
    }

    @Test
    void _79_exist_search() {
	assertTrue(solution._79_exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' },
		new char[] { 'S', 'F', 'C', 'S' }, new char[] { 'A', 'D', 'E', 'E' } }, "ABCCED"));
	assertTrue(solution._79_exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' },
		new char[] { 'S', 'F', 'C', 'S' }, new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));
	assertFalse(solution._79_exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' },
		new char[] { 'S', 'F', 'C', 'S' }, new char[] { 'A', 'D', 'E', 'E' } }, "ABAB"));
    }

    @Test
    void _80_removeDuplicates() {
	int[] nums = { 1, 1, 1, 2, 2, 3 };
	int length = solution._80_removeDuplicates(nums);

	assertEquals(5, length);
	assertEquals(1, nums[0]);
	assertEquals(1, nums[1]);
	assertEquals(2, nums[2]);
	assertEquals(2, nums[3]);
	assertEquals(3, nums[4]);
    }

    @Test
    void _81_search() {
	assertTrue(solution._81_search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 0));
	assertFalse(solution._81_search(new int[] { 2, 5, 6, 0, 0, 1, 2 }, 3));
	assertTrue(solution._81_search(new int[] { 1, 1, 3, 1 }, 3));
	assertTrue(solution._81_search(new int[] { 3, 1, 1 }, 3));
    }

    @Test
    void _82_deleteDuplicates() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(1);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);

	head = solution._82_deleteDuplicates(head);

	assertEquals(3, head.val);
	assertEquals(4, head.next.val);
	assertNull(head.next.next);
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
    void _86_partition() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(4);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(2);
	head.next.next.next.next = new ListNode(5);
	head.next.next.next.next.next = new ListNode(2);

	head = solution._86_partition(head, 3);

	assertEquals(1, head.val);
	assertEquals(2, head.next.val);
	assertEquals(2, head.next.next.val);
	assertEquals(4, head.next.next.next.val);
	assertEquals(3, head.next.next.next.next.val);
	assertEquals(5, head.next.next.next.next.next.val);
	assertNull(head.next.next.next.next.next.next);
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
    void _90_subsetsWithDup() {
	List<List<Integer>> answer = new ArrayList<>();
	answer.add(Arrays.asList());
	answer.add(Arrays.asList(1));
	answer.add(Arrays.asList(1, 2));
	answer.add(Arrays.asList(1, 2, 2));
	answer.add(Arrays.asList(2));
	answer.add(Arrays.asList(2, 2));

	assertThat(solution._90_subsetsWithDup(new int[] { 2, 1, 2 }), is(answer));
    }

    @Test
    void _92_reverseBetween() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);
	head.next.next.next.next = new ListNode(5);
	head.next.next.next.next.next = new ListNode(6);

	head = solution._92_reverseBetween(head, 3, 4);

	assertEquals(1, head.val);
	assertEquals(2, head.next.val);
	assertEquals(4, head.next.next.val);
	assertEquals(3, head.next.next.next.val);
	assertEquals(5, head.next.next.next.next.val);
	assertEquals(6, head.next.next.next.next.next.val);
	assertNull(head.next.next.next.next.next.next);
    }

    @Test
    void _94_inorderTraversal() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	List<Integer> values = solution._94_inorderTraversal(root);

	assertThat(values, is(Arrays.asList(4, 2, 5, 1, 6, 3, 7)));
    }

    @Test
    void _98_isValidBST() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	assertFalse(solution._98_isValidBST(root));
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
    void _102_levelOrder() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	List<List<Integer>> results = Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6, 7));

	assertThat(solution._102_levelOrder(root), is(results));
    }

    @Test
    void _103_zigzagLevelOrder() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	List<List<Integer>> results = Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2), Arrays.asList(4, 5, 6, 7));

	assertThat(solution._103_zigzagLevelOrder(root), is(results));
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
    void _109_sortedListToBST() {
	ListNode head = new ListNode(-10);
	head.next = new ListNode(-3);
	head.next.next = new ListNode(0);
	head.next.next.next = new ListNode(5);
	head.next.next.next.next = new ListNode(9);

	TreeNode root = solution._109_sortedListToBST(head);
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
    void _113_pathSum() {
	TreeNode root = new TreeNode(5);

	root.left = new TreeNode(4);
	root.right = new TreeNode(8);

	root.left.left = new TreeNode(11);

	root.right.left = new TreeNode(13);
	root.right.right = new TreeNode(4);

	root.left.left.left = new TreeNode(7);
	root.left.left.right = new TreeNode(2);

	root.right.right.left = new TreeNode(5);
	root.right.right.right = new TreeNode(1);

	List<List<Integer>> paths = solution._113_pathSum(root, 22);
	assertEquals(2, paths.size());
	assertEquals(Arrays.asList(5, 4, 11, 2), paths.get(0));
	assertEquals(Arrays.asList(5, 8, 4, 5), paths.get(1));
    }

    @Test
    void _114_flatten() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(5);

	root.left.left = new TreeNode(3);
	root.left.right = new TreeNode(4);

	root.right.right = new TreeNode(6);

	solution._114_flatten(root);

	assertEquals(1, root.val);
	assertEquals(2, root.right.val);
	assertEquals(3, root.right.right.val);
	assertEquals(4, root.right.right.right.val);
	assertEquals(5, root.right.right.right.right.val);
	assertEquals(6, root.right.right.right.right.right.val);
    }

    @Test
    void _116_connect() {
	Node3 root = new Node3(1);

	root.left = new Node3(2);
	root.right = new Node3(3);

	root = solution._116_connect(root);

	assertNull(root.next);
	assertEquals(3, root.left.next.val);
	assertNull(root.right.next);
    }

    @Test
    void _117_connect() {
	Node3 root = new Node3(1);

	root.left = new Node3(2);
	root.right = new Node3(3);

	root.left.left = new Node3(4);
	root.right.right = new Node3(5);

	root = solution._117_connect(root);

	assertNull(root.next);
	assertEquals(3, root.left.next.val);
	assertNull(root.right.next);
	assertEquals(5, root.left.left.next.val);
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
    void _129_sumNumbers() {
	TreeNode root = new TreeNode(4);
	root.left = new TreeNode(9);
	root.right = new TreeNode(0);
	root.left.left = new TreeNode(5);
	root.left.right = new TreeNode(1);

	assertEquals(1026, solution._129_sumNumbers(root));
    }

    @Test
    void _130_solve() {
	char[][] actual = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
		{ 'X', 'O', 'X', 'X' } };
	char[][] expected = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
		{ 'X', 'O', 'X', 'X' } };

	solution._130_solve(actual);

	assertArrayEquals(expected[0], actual[0]);
	assertArrayEquals(expected[1], actual[1]);
	assertArrayEquals(expected[2], actual[2]);
	assertArrayEquals(expected[3], actual[3]);
    }

    @Test
    void _131_partition() {
	List<List<String>> answer = new ArrayList<>();
	answer.add(Arrays.asList("a", "a", "b"));
	answer.add(Arrays.asList("aa", "b"));

	assertThat(solution._131_partition("aab"), is(answer));
    }

    @Test
    void _133_cloneGraph() {
	Node n1 = new Node(1);
	Node n2 = new Node(2);
	Node n3 = new Node(3);
	Node n4 = new Node(4);

	n1.children.add(n2);
	n1.children.add(n4);

	n2.children.add(n1);
	n2.children.add(n3);

	n3.children.add(n2);
	n3.children.add(n4);

	n4.children.add(n1);
	n4.children.add(n3);

	Node actual = solution._133_cloneGraph(n1);

	assertEquals(1, actual.val);
	assertEquals(2, actual.children.get(0).val);
	assertEquals(1, actual.children.get(0).children.get(0).val);
	assertEquals(3, actual.children.get(0).children.get(1).val);
    }

    @Test
    void _136_singleNumber() {
	assertEquals(1, solution._136_singleNumber(new int[] { 3, 5, 1, 2, 3, 5, 2 }));
    }

    @Test
    void _137_singleNumber() {
	assertEquals(99, solution._137_singleNumber(new int[] { 0, 0, 0, 99 }));
	assertEquals(99, solution._137_singleNumber(new int[] { 99, 0, 0, 0 }));
	assertEquals(99, solution._137_singleNumber(new int[] { 99 }));
	assertEquals(1, solution._137_singleNumber(new int[] { 0, 0, 0, 1, 2, 2, 2 }));
	assertEquals(1, solution._137_singleNumber(new int[] { 3, 5, 3, 5, 3, 1, 2, 3, 5, 2 }));
	assertEquals(1, solution._137_singleNumber(new int[] { 3, 5, 3, 5, 3, 1, 2, 3, 5, 2 }));
    }

    @Test
    void _138_copyRandomList() {
	Node2 head = new Node2(1);
	head.next = new Node2(2);
	head.next.next = new Node2(3);

	head.random = head.next.next;

	Node2 actual = solution._138_copyRandomList(head);

	assertEquals(1, actual.val);
	assertEquals(2, actual.next.val);
	assertEquals(3, actual.next.next.val);
	assertEquals(3, actual.random.val);
	assertNull(actual.next.next.next);
    }

    @Test
    void _139_wordBreak() {
	assertTrue(solution._139_wordBreak("leetcode", Arrays.asList("leet", "code")));
	assertTrue(solution._139_wordBreak("applepenapple", Arrays.asList("apple", "pen")));
	assertFalse(solution._139_wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
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
    void _142_detectCycle() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);
	head.next.next.next.next = head.next;

	assertEquals(head.next, solution._142_detectCycle(head));
    }

    @Test
    void _143_reorderList() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);
	head.next.next.next.next = new ListNode(5);

	solution._143_reorderList(head);

	assertEquals(1, head.val);
	assertEquals(5, head.next.val);
	assertEquals(2, head.next.next.val);
	assertEquals(4, head.next.next.next.val);
	assertEquals(3, head.next.next.next.next.val);

	head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);

	solution._143_reorderList(head);

	assertEquals(1, head.val);
	assertEquals(4, head.next.val);
	assertEquals(2, head.next.next.val);
	assertEquals(3, head.next.next.next.val);
    }

    @Test
    void _144_preorderTraversal() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	assertEquals(Arrays.asList(1, 2, 4, 5, 3, 6, 7), solution._144_preorderTraversal(root));
    }

    @Test
    void _145_postorderTraversal() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	assertEquals(Arrays.asList(4, 5, 2, 6, 7, 3, 1), solution._145_postorderTraversal(root));
    }


    @Test
    void _146_lruCache() {
	Solution2.LRUCache cache = solution._146_lruCache(2);

	cache.put(1, 1);
	cache.put(2, 2);
	assertEquals(1, cache.get(1));
	cache.put(3, 3); // evicts key 2
	assertEquals(-1, cache.get(2)); // returns -1 (not found)
	cache.put(4, 4); // evicts key 1
	assertEquals(-1, cache.get(1)); // returns -1 (not found)
	assertEquals(3, cache.get(3)); // returns 3
	assertEquals(4, cache.get(4)); // returns 4
    }

//    @Test
//    void _148_sortList() {
//	ListNode head = new ListNode(4);
//	head.next = new ListNode(2);
//	head.next.next = new ListNode(1);
//	head.next.next.next = new ListNode(3);
//
//	head = solution._148_sortList(head);
//
//	assertEquals(1, head.val);
//	assertEquals(2, head.next.val);
//	assertEquals(3, head.next.next.val);
//	assertEquals(4, head.next.next.next.val);
//	assertNull(head.next.next.next.next);
//    }
//
//    @Test
//    void _151_reverseWords() {
//	assertEquals("example good a", solution._151_reverseWords("a good   example"));
//    }
//
//    @Test
//    void _153_findMin() {
//	assertEquals(8, solution._153_findMin(new int[] { 8, 9 }));
//	assertEquals(1, solution._153_findMin(new int[] { 3, 4, 5, 1, 2 }));
//	assertEquals(0, solution._153_findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
//    }

}
