package com.kristurek.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
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

import com.kristurek.leetcode.Solution.CombinationIterator;
import com.kristurek.leetcode.Solution.PeekingIterator;
import com.kristurek.leetcode.Solution.Trie;
import com.kristurek.leetcode.Solution.WordDictionary;
import com.kristurek.leetcode.common.Employee;
import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.Node;
import com.kristurek.leetcode.common.Node2;
import com.kristurek.leetcode.common.Node3;
import com.kristurek.leetcode.common.TreeNode;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class SolutionTest {

    private Solution solution = new Solution();

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
    void _43_multiply() {
	assertEquals("56088", solution._43_multiply("123", "456"));
    }

    @Test
    void _44_isMatch() {
	assertTrue(solution._44_isMatch("adceb", "a*b"));
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
    void _50_myPow() {
	assertEquals(8, solution._50_myPow(2, 3));
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
    void _64_minPathSum() {
	int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
	assertEquals(7, solution._64_minPathSum(grid));
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
    void _105_buildTree() {
	TreeNode root = new TreeNode(3);

	root.left = new TreeNode(9);
	root.right = new TreeNode(20);

	root.right.left = new TreeNode(15);
	root.right.right = new TreeNode(7);

	TreeNode actual = solution._105_buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });

	assertEquals(root.val, actual.val);
	assertEquals(root.left.val, actual.left.val);
	assertEquals(root.right.val, actual.right.val);
	assertEquals(root.right.left.val, actual.right.left.val);
	assertEquals(root.right.right.val, actual.right.right.val);
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
	List<Integer> results = solution._119_getRow_v2(4);

	assertThat(results, is(Arrays.asList(1, 4, 6, 4, 1)));
    }

    @Test
    void _120_minimumTotal() {
	List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
		Arrays.asList(4, 1, 8, 3));

	assertEquals(11, solution._120_minimumTotal(triangle));
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
    void _146_lruCache() {
	Solution.LRUCache cache = solution._146_lruCache(2);

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

    @Test
    void _148_sortList() {
	ListNode head = new ListNode(4);
	head.next = new ListNode(2);
	head.next.next = new ListNode(1);
	head.next.next.next = new ListNode(3);

	head = solution._148_sortList(head);

	assertEquals(1, head.val);
	assertEquals(2, head.next.val);
	assertEquals(3, head.next.next.val);
	assertEquals(4, head.next.next.next.val);
	assertNull(head.next.next.next.next);
    }

    @Test
    void _151_reverseWords() {
	assertEquals("example good a", solution._151_reverseWords("a good   example"));
    }

    @Test
    void _153_findMin() {
	assertEquals(8, solution._153_findMin(new int[] { 8, 9 }));
	assertEquals(1, solution._153_findMin(new int[] { 3, 4, 5, 1, 2 }));
	assertEquals(0, solution._153_findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
    }

    @Test
    void _155_minStack() {
	Solution.MinStack minStack = solution._155_minStack();
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
    void _162_findPeakElement() {
	assertEquals(2, solution._162_findPeakElement(new int[] { 1, 2, 3, 1 }));
	assertEquals(5, solution._162_findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
    }

    @Test
    void _165_compareVersion() {
	assertEquals(-1, solution._165_compareVersion("0.1", "1.1"));
	assertEquals(1, solution._165_compareVersion("1.0.1", "1"));
	assertEquals(-1, solution._165_compareVersion("7.5.2.4", "7.5.3"));
	assertEquals(0, solution._165_compareVersion("1.01", "1.001"));
	assertEquals(0, solution._165_compareVersion("1.0", "1.0.0"));
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
    void _173_BSTIterator() {
	TreeNode root = new TreeNode(7);
	root.left = new TreeNode(3);
	root.right = new TreeNode(15);
	root.right.left = new TreeNode(9);
	root.right.right = new TreeNode(20);

	Solution.BSTIterator iterator = solution._173_BSTIterator(root);
	assertEquals(3, iterator.next());
	assertEquals(7, iterator.next());
	assertTrue(iterator.hasNext());
	assertEquals(9, iterator.next());
	assertTrue(iterator.hasNext());
	assertEquals(15, iterator.next());
	assertTrue(iterator.hasNext());
	assertEquals(20, iterator.next());
	assertFalse(iterator.hasNext());
    }

    @Test
    void _179_largestNumber() {
	assertEquals("0", solution._179_largestNumber(new int[] { 0, 0 }));
	assertEquals("210", solution._179_largestNumber(new int[] { 10, 2 }));
	assertEquals("9534330", solution._179_largestNumber(new int[] { 3, 30, 34, 5, 9 }));
    }

    @Test
    void _187_findRepeatedDnaSequences() {
	List<String> actual = solution._187_findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
	List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");

	assertEquals(expected, actual);
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
    void _199_rightSideView() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);

	List<Integer> actual = solution._199_rightSideView(root);

	assertEquals(1, actual.get(0));
	assertEquals(3, actual.get(1));
	assertEquals(4, actual.get(2));
    }

    @Test
    void _200_numIslands() {
	assertEquals(1, solution._200_numIslands(new char[][] { { '1', '1', '1', '1', '0' },
		{ '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
	assertEquals(3, solution._200_numIslands(new char[][] { { '1', '1', '0', '0', '0' },
		{ '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
    }

    @Test
    void _201_rangeBitwiseAnd() {
	assertEquals(4, solution._201_rangeBitwiseAnd(5, 7));
	assertEquals(0, solution._201_rangeBitwiseAnd(0, 1));
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
    void _206_reverseList() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);

	ListNode actual = solution._206_reverseList(head);

	assertEquals(4, actual.val);
	assertEquals(3, actual.next.val);
	assertEquals(2, actual.next.next.val);
	assertEquals(1, actual.next.next.next.val);
	assertNull(actual.next.next.next.next);
    }

    @Test
    void _208_trie() {
	Trie trie = solution._208_trie();

	trie.insert("apple");
	assertTrue(trie.search("apple"));
	assertFalse(trie.search("app"));
	assertTrue(trie.startsWith("app"));
	trie.insert("app");
	assertTrue(trie.search("app"));
    }

    @Test
    void _211_wordDictionary() {
	WordDictionary wordDictionary = solution._211_wordDictionary();

	wordDictionary.addWord("bad");
	wordDictionary.addWord("dad");
	wordDictionary.addWord("mad");
	assertFalse(wordDictionary.search("pad"));
	assertTrue(wordDictionary.search("bad"));
	assertTrue(wordDictionary.search(".ad"));
	assertTrue(wordDictionary.search("..."));
    }

    @Test
    void _213_rob() {
	assertEquals(3, solution._213_rob(new int[] { 2, 3, 2 }));
	assertEquals(4, solution._213_rob(new int[] { 1, 2, 3, 1 }));
    }

    @Test
    void _215_findKthLargest() {
	assertEquals(5, solution._215_findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
	assertEquals(4, solution._215_findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    }

    @Test
    void _216_combinationSum3() {
	List<List<Integer>> actual = solution._216_combinationSum3(3, 7);

	assertEquals(1, actual.size());
	assertEquals(Arrays.asList(1, 2, 4), actual.get(0));
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
    void _220_containsNearbyAlmostDuplicate() {
	assertTrue(solution._220_containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
	assertTrue(solution._220_containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2));
	assertFalse(solution._220_containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
	// assertTrue(solution._220_containsNearbyAlmostDuplicate(new int[] { 7, 1, 3 },
	// 2, 3));
    }

    @Test
    void _225_myStack() {
	Solution.MyStack stack = solution._225_MyStack();

	stack.push(1);
	stack.push(2);
	assertEquals(2, stack.top());
	assertEquals(2, stack.pop());
	assertFalse(stack.empty());
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
    void _227_calculate() {
	assertEquals(7, solution._227_calculate("3+2*2"));
	assertEquals(1, solution._227_calculate("3/2"));
	assertEquals(5, solution._227_calculate("3+5/2"));
    }

    @Test
    void _228_summaryRanges() {
	List<String> actual = solution._228_summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 });
	List<String> expected = Arrays.asList("0->2", "4->5", "7");
	assertEquals(expected, actual);

	actual = solution._228_summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 });
	expected = Arrays.asList("0", "2->4", "6", "8->9");
	assertEquals(expected, actual);
    }

    @Test
    void _229_majorityElement() {
	assertEquals(Arrays.asList(3), solution._229_majorityElement(new int[] { 3, 2, 3 }));
	assertEquals(Arrays.asList(1, 2), solution._229_majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }));
    }

    @Test
    void _230_kthSmallest() {
	TreeNode root = new TreeNode(3);

	root.left = new TreeNode(2);
	root.right = new TreeNode(5);

	root.left.left = new TreeNode(1);

	root.right.left = new TreeNode(4);
	root.right.right = new TreeNode(6);

	assertEquals(1, solution._230_kthSmallest(root, 1));
	assertEquals(2, solution._230_kthSmallest(root, 2));
	assertEquals(3, solution._230_kthSmallest(root, 3));
    }

    @Test
    void _231_isPowerOfTwo() {
	assertTrue(solution._231_isPowerOfTwo(1));
	assertTrue(solution._231_isPowerOfTwo(16));
	assertFalse(solution._231_isPowerOfTwo(218));
    }

    @Test
    void _232_MyQueue() {
	Solution.MyQueue queue = solution._232_MyQueue();

	queue.push(1);
	queue.push(2);
	assertEquals(1, queue.peek());
	assertEquals(1, queue.pop());
	assertFalse(queue.empty());
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
    void _236_lowestCommonAncestor() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.right = new TreeNode(5);

	assertEquals(root, solution._236_lowestCommonAncestor(root, root.left.right, root.right));
    }

    @Test
    void _237_deleteNode() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);

	solution._237_deleteNode(head.next);

	assertEquals(1, head.val);
	assertEquals(3, head.next.val);
	assertEquals(4, head.next.next.val);
	assertNull(head.next.next.next);
    }

    @Test
    void _238_productExceptSelf() {
	assertArrayEquals(IntStream.of(24, 12, 8, 6).toArray(),
		solution._238_productExceptSelf(IntStream.of(1, 2, 3, 4).toArray()));
    }

    @Test
    void _240_searchMatrix() {
	int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
		{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };

	assertTrue(solution._240_searchMatrix(matrix, 5));
	assertFalse(solution._240_searchMatrix(matrix, 28));
    }

    @Test
    void _257_binaryTreePaths() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.right = new TreeNode(5);

	List<String> actual = solution._257_binaryTreePaths(root);
	List<String> expected = Arrays.asList("1->2->5", "1->3");

	assertEquals(expected, actual);
    }

    @Test
    void _260_singleNumber() {
	assertArrayEquals(new int[] { 3, 5 }, solution._260_singleNumber(new int[] { 1, 2, 1, 3, 2, 5 }));
    }

    @Test
    void _264_nthUglyNumber() {
	assertEquals(12, solution._264_nthUglyNumber(10));
    }

    @Test
    void _268_missingNumber() {
	assertEquals(1, solution._268_missingNumber(new int[] { 0 }));
	assertEquals(2, solution._268_missingNumber(new int[] { 3, 0, 1 }));
	assertEquals(8, solution._268_missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
    }

    @Test
    void _274_hIndex() {
	assertEquals(3, solution._274_hIndex(new int[] { 3, 0, 6, 1, 5 }));
    }

    @Test
    void _283_moveZeroes() {
	int[] nums = IntStream.of(0, 1, 0, 3, 12).toArray();
	int[] answer = IntStream.of(1, 3, 12, 0, 0).toArray();
	solution._283_moveZeroes(nums);

	assertArrayEquals(answer, nums);
    }

    @Test
    void _284_PeekingIterator() {
	List<Integer> nums = Arrays.asList(1, 2, 3);
	PeekingIterator iterator = solution._284_PeekingIterator(nums.iterator());

	assertTrue(iterator.hasNext());
	assertEquals(1, iterator.peek());
	assertEquals(1, iterator.next());

	assertEquals(2, iterator.peek());
	assertEquals(2, iterator.next());

	assertEquals(3, iterator.next());
	assertFalse(iterator.hasNext());
	assertNull(iterator.peek());
    }

    @Test
    void _287_findDuplicate() {
	assertEquals(2, solution._287_findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
    }

    @Test
    void _290_wordPattern() {
	assertTrue(solution._290_wordPattern("abba", "dog cat cat dog"));
	assertFalse(solution._290_wordPattern("abba", "dog cat cat fish"));
	assertFalse(solution._290_wordPattern("aaaa", "dog cat cat dog"));
	assertTrue(solution._290_wordPattern(
		"ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",
		"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
    }

    @Test
    void _313_nthSuperUglyNumber() {
	assertEquals(1, solution._313_nthSuperUglyNumber_v2(12, new int[] { 1 }));
	assertEquals(32, solution._313_nthSuperUglyNumber_v2(12, new int[] { 2, 7, 13, 19 }));
    }

    @Test
    void _318_maxProduct() {
	assertEquals(16, solution._318_maxProduct(new String[] { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" }));
	assertEquals(4, solution._318_maxProduct(new String[] { "a", "ab", "abc", "d", "cd", "bcd", "abcd" }));
	assertEquals(0, solution._318_maxProduct(new String[] { "a", "aa", "aaa", "aaaa" }));
    }

    @Test
    void _322_coinChange() {
	assertEquals(3, solution._322_coinChange(new int[] { 1, 2, 5 }, 11));
	assertEquals(-1, solution._322_coinChange(new int[] { 2 }, 3));
    }

    @Test
    void _324_wiggleSort() {
	int[] actual = new int[] { 1, 5, 1, 1, 6, 4 };
	int[] expected = new int[] { 1, 6, 1, 5, 1, 4 };

	solution._324_wiggleSort(actual);

	assertArrayEquals(expected, actual);
    }

    @Test
    void _328_oddEvenList() {
	ListNode head = new ListNode(3);
	head.next = new ListNode(2);
	head.next.next = new ListNode(1);
	head.next.next.next = new ListNode(0);

	head = solution._328_oddEvenList(head);

	assertEquals(3, head.val);
	assertEquals(1, head.next.val);
	assertEquals(2, head.next.next.val);
	assertEquals(0, head.next.next.next.val);
    }

    @Test
    void _334_increasingTriplet() {
	assertTrue(solution._334_increasingTriplet(new int[] { 1, 0, 2, 0, 3 }));
    }

    @Test
    void _342_isPowerOfFour() {
	assertTrue(solution._342_isPowerOfFour(4));
	assertTrue(solution._342_isPowerOfFour(16));
	assertFalse(solution._342_isPowerOfFour(5));
    }

    @Test
    void _344_reverseString() {
	char[] actual = new char[] { 'h', 'e', 'l', 'l', 'o' };
	char[] expected = new char[] { 'o', 'l', 'l', 'e', 'h' };

	solution._344_reverseString(actual);

	assertArrayEquals(expected, actual);
    }

    @Test
    void _345_reverseVowels() {
	assertEquals("holle", solution._345_reverseVowels("hello"));
    }

    @Test
    void _349_intersection() {
	assertArrayEquals(new int[] { 4, 9 },
		solution._349_intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
    }

    @Test
    void _350_intersect() {
	assertArrayEquals(new int[] { 9, 4 },
		solution._350_intersect(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
    }

    @Test
    void _355_twitter() {
	Solution.Twitter twitter = solution._355_twitter();

	// User 1 posts a new tweet (id = 5).
	twitter.postTweet(1, 5);

	// User 1's news feed should return a list with 1 tweet id -> [5].
	assertEquals(1, twitter.getNewsFeed(1).size());

	// User 1 follows user 2.
	twitter.follow(1, 2);

	// User 2 posts a new tweet (id = 6).
	twitter.postTweet(2, 6);

	// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
	// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
	List<Integer> newsFeed = twitter.getNewsFeed(1);
	assertEquals(2, newsFeed.size());

	// User 1 unfollows user 2.
	twitter.unfollow(1, 2);

	// User 1's news feed should return a list with 1 tweet id -> [5],
	// since user 1 is no longer following user 2.
	newsFeed = twitter.getNewsFeed(1);
	assertEquals(1, newsFeed.size());
    }

    @Test
    void _373_kSmallestPairs() {
	List<List<Integer>> answer = solution._373_kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);

	assertEquals(3, answer.size());
	assertEquals(Arrays.asList(1, 2), answer.get(0));
	assertEquals(Arrays.asList(1, 4), answer.get(1));
	assertEquals(Arrays.asList(1, 6), answer.get(2));
    }

    @Test
    void _377_combinationSum4() {
	assertEquals(7, solution._377_combinationSum4(new int[] { 1, 2, 3 }, 4));
    }

    @Test
    void _380_randomizedSet() {
	Solution.RandomizedSet randomSet = solution._380_randomizedSet();

	// Inserts 1 to the set. Returns true as 1 was inserted successfully.
	assertTrue(randomSet.insert(1));

	// Returns false as 2 does not exist in the set.
	assertFalse(randomSet.remove(2));

	// Inserts 2 to the set, returns true. Set now contains [1,2].
	assertTrue(randomSet.insert(2));

	// getRandom should return either 1 or 2 randomly.
	assertThat(randomSet.getRandom(), anyOf(is(1), is(2)));

	// Removes 1 from the set, returns true. Set now contains [2].
	assertTrue(randomSet.remove(1));

	// 2 was already in the set, so return false.
	assertFalse(randomSet.insert(2));

	// Since 2 is the only number in the set, getRandom always return 2.
	assertThat(randomSet.getRandom(), anyOf(is(2)));
    }

    @Test
    void _387_firstUniqChar() {
	assertEquals(0, solution._387_firstUniqChar("hello"));
	assertEquals(2, solution._387_firstUniqChar("loveleetcode"));
    }

    @Test
    void _389_findTheDifference() {
	assertEquals('e', solution._389_findTheDifference("abcd", "abced"));
    }

    @Test
    void _392_isSubsequence() {
	assertTrue(solution._392_isSubsequence("abc", "ahbgdc"));
	assertFalse(solution._392_isSubsequence("axc", "ahbgdc"));
    }

    @Test
    void _404_sumOfLeftLeaves() {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);

	assertEquals(4, solution._404_sumOfLeftLeaves(root));
    }

    @Test
    void _409_longestPalindrome() {
	assertEquals(7, solution._409_longestPalindrome("abccccdd"));
	assertEquals(3, solution._409_longestPalindrome("ccc"));
    }

    @Test
    void _412_fizzBuzz() {
	assertEquals(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7"), solution._412_fizzBuzz(7));
    }

    @Test
    void _429_levelOrder() {
	Node root = new Node(1, Arrays.asList(new Node(), new Node(), new Node()));
	root.children.get(0).val = 3;
	root.children.get(1).val = 2;
	root.children.get(2).val = 4;
	root.children.get(0).children = Arrays.asList(new Node(), new Node());
	root.children.get(0).children.get(0).val = 5;
	root.children.get(0).children.get(1).val = 6;

	List<List<Integer>> answer = new ArrayList<List<Integer>>();
	answer.add(Arrays.asList(1));
	answer.add(Arrays.asList(3, 2, 4));
	answer.add(Arrays.asList(5, 6));

	assertEquals(answer, solution._429_levelOrder(root));
    }

    @Test
    void _435_eraseOverlapIntervals() {
	assertEquals(2,
		solution._435_eraseOverlapIntervals(new int[][] { { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 } }));
	assertEquals(1, solution._435_eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }));
	assertEquals(2, solution._435_eraseOverlapIntervals(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }));
	assertEquals(0, solution._435_eraseOverlapIntervals(new int[][] { { 1, 2 }, { 2, 3 } }));
    }

    @Test
    void _450_deleteNode() {
	TreeNode root = new TreeNode(5);
	root.left = new TreeNode(3);
	root.right = new TreeNode(6);
	root.left.left = new TreeNode(2);
	root.left.right = new TreeNode(4);
	root.right.right = new TreeNode(7);

	root = solution._450_deleteNode(root, 3);

	assertEquals(5, root.val);
	assertEquals(4, root.left.val);
	assertEquals(6, root.right.val);
	assertEquals(2, root.left.left.val);
	assertEquals(7, root.right.right.val);
    }

    @Test
    void _459_repeatedSubstringPattern() {
	assertTrue(solution._459_repeatedSubstringPattern("abab"));
	assertFalse(solution._459_repeatedSubstringPattern("aba"));
	assertTrue(solution._459_repeatedSubstringPattern("abcabcabcabc"));
    }

    @Test
    void _467_findRightInterval() {
	assertArrayEquals(new int[] { -1 }, solution._467_findRightInterval(new int[][] { { 1, 2 } }));
	assertArrayEquals(new int[] { -1, 0, 1 },
		solution._467_findRightInterval(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } }));
	assertArrayEquals(new int[] { -1, 2, -1 },
		solution._467_findRightInterval(new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } }));
    }

    @Test
    void _497_Solution() {
	Solution._497_Solution sol = solution._497_solution(new int[][] { { -2, -2, -1, -1 }, { 1, 0, 3, 0 } });

//	System.out.println(Arrays.toString(sol.pick()));
//	System.out.println(Arrays.toString(sol.pick()));
//	System.out.println(Arrays.toString(sol.pick()));
//	System.out.println(Arrays.toString(sol.pick()));
//	System.out.println(Arrays.toString(sol.pick()));
//	System.out.println(Arrays.toString(sol.pick()));
//	System.out.println(Arrays.toString(sol.pick()));
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
    void _520_detectCapitalUse() {
	assertTrue(solution._520_detectCapitalUse("USA"));
	assertTrue(solution._520_detectCapitalUse("Usa"));
	assertTrue(solution._520_detectCapitalUse("U"));
	assertTrue(solution._520_detectCapitalUse("u"));
	assertFalse(solution._520_detectCapitalUse("FlaG"));
	assertFalse(solution._520_detectCapitalUse("FlAg"));
    }

    @Test
    void _525_findMaxLength() {
	assertThat(solution._525_findMaxLength(IntStream.of(0, 1).toArray()), is(equalTo(2)));
	assertThat(solution._525_findMaxLength(IntStream.of(0, 1, 0).toArray()), is(equalTo(2)));
    }

    @Test
    void _535_codec() {
	Solution.Codec codec = solution._535_codec();

	String url = "https://leetcode.com/problems/design-tinyurl";
	String encodeUrl = codec.encode(url);
	String decodeUrl = codec.decode(encodeUrl);

	assertEquals(url, decodeUrl);
    }

    @Test
    void _540_singleNonDuplicate() {
	assertEquals(2, solution._540_singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
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
    void _557_reverseWords() {
	assertEquals("s'teL ekat edoCteeL tsetnoc", solution._557_reverseWords("Let's take LeetCode contest"));
    }

    @Test
    void _559_maxDepth() {
	Node root = new Node(1, Arrays.asList(new Node(3), new Node(2), new Node(4)));
	root.children.get(0).children = Arrays.asList(new Node(5), new Node(6));

	assertEquals(3, solution._559_maxDepth(root));
    }

    @Test
    void _560_subarraySum() {
	assertEquals(2, solution._560_subarraySum(IntStream.of(1, 1, 1).toArray(), 2));
    }

    @Test
    void _561_arrayPairSum() {
	assertEquals(4, solution._561_arrayPairSum(new int[] { 1, 4, 3, 2 }));
    }

    @Test
    void _589_preorder() {
	Node root = new Node(1, Arrays.asList(new Node(3), new Node(2), new Node(4)));
	root.children.get(0).children = Arrays.asList(new Node(5), new Node(6));

	List<Integer> answer = Arrays.asList(1, 3, 5, 6, 2, 4);

	assertEquals(answer, solution._589_preorder(root));
    }

    @Test
    void _590_postorder() {
	Node root = new Node(1, Arrays.asList(new Node(3), new Node(2), new Node(4)));
	root.children.get(0).children = Arrays.asList(new Node(5), new Node(6));

	List<Integer> answer = Arrays.asList(5, 6, 3, 2, 4, 1);

	assertEquals(answer, solution._590_postorder(root));
    }

    @Test
    void _617_mergeTrees() {
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
    void _657_judgeCircle() {
	assertTrue(solution._657_judgeCircle("UD"));
	assertFalse(solution._657_judgeCircle("LL"));
    }

    @Test
    void _665_checkPossibility() {
	assertTrue(solution._665_checkPossibility(new int[] {}));
	assertTrue(solution._665_checkPossibility(new int[] { 3 }));
	assertTrue(solution._665_checkPossibility(new int[] { 4, 2, 3 }));
	assertTrue(solution._665_checkPossibility(new int[] { 2, 3, 3, 2 }));
	assertFalse(solution._665_checkPossibility(new int[] { 4, 2, 1 }));
	assertTrue(solution._665_checkPossibility(new int[] { 3, 4, 2, 4 }));
    }

    @Test
    void _678_checkValidString() {
	assertTrue(solution._678_checkValidString("()"));
	assertTrue(solution._678_checkValidString("(*)"));
	assertTrue(solution._678_checkValidString("(*))"));
    }

    @Test
    void _690_getImportance() {
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
    void _700_searchBST() {
	TreeNode root = new TreeNode(4);

	root.left = new TreeNode(2);
	root.right = new TreeNode(7);

	root.left.left = new TreeNode(1);
	root.left.right = new TreeNode(3);

	assertEquals(root.left, solution._700_searchBST(root, 2));
    }

    @Test
    void _705_myHashSet() {
	Solution.MyHashSet myHashSet = solution._705_myHashSet();

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
    void _709_toLowerCase() {
	assertEquals("", solution._709_toLowerCase(""));
	assertNull(solution._709_toLowerCase(null));
	assertEquals("123!~", solution._709_toLowerCase("123!~"));
	assertEquals("abc", solution._709_toLowerCase("abc"));
	assertEquals("abc", solution._709_toLowerCase("ABC"));
	assertEquals("abcd", solution._709_toLowerCase("aBcD"));
    }

    @Test
    void _728_selfDividingNumbers() {
	List<Integer> list = Arrays.asList((new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22 }));
	assertEquals(list, solution._728_selfDividingNumbers(1, 22));
    }

    @Test
    void _763_partitionLabels() {
	List<Integer> actual = solution._763_partitionLabels("ababcbacadefegdehijhklij");
	List<Integer> expected = Arrays.asList(9, 7, 8);

	assertEquals(expected, actual);
    }

    @Test
    void _771_numJewelsInStones() {
	assertEquals(3, solution._771_numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    void _796_rotateString() {
	assertTrue(solution._796_rotateString("abcde", "cdeab"));
	assertFalse(solution._796_rotateString("abcde", "abced"));
    }

    @Test
    void _804_uniqueMorseRepresentations() {
	assertEquals(2, solution._804_uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
    }

    @Test
    void _811_subdomainVisits() {
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
    void _821_shortestToChar() {
	int[] answer = new int[] { 3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0 };

	assertArrayEquals(answer, solution._821_shortestToChar("loveleetcode", 'e'));
    }

    @Test
    void _824_toGoatLatin() {
	assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", solution._824_toGoatLatin("I speak Goat Latin"));
	assertEquals(
		"heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
		solution._824_toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    @Test
    void _832_flipAndInvertImage() {
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
    void _852_peakIndexInMountainArray() {
	assertEquals(1, solution._852_peakIndexInMountainArray(new int[] { 0, 1, 0 }));
	assertEquals(1, solution._852_peakIndexInMountainArray(new int[] { 0, 2, 1, 0 }));
    }

    @Test
    void _876_middleNode() {
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	head.next.next.next = new ListNode(4);

	assertEquals(3, solution._876_middleNode(head).val);
    }

    @Test
    void _905_sortArrayByParity() {
	assertArrayEquals(new int[] { 2, 4, 3, 1 }, solution._905_sortArrayByParity(new int[] { 1, 2, 3, 4 }));
    }

    @Test
    void _922_sortArrayByParityII() {
	assertArrayEquals(new int[] { 4, 5, 2, 7 }, solution._922_sortArrayByParityII(new int[] { 4, 2, 5, 7 }));
    }

    @Test
    void _929_numUniqueEmails() {
	assertEquals(2, solution._929_numUniqueEmails(new String[] { "test.email+alex@leetcode.com",
		"test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com" }));

	assertEquals(1, solution
		._929_numUniqueEmails(new String[] { "test.email+alex@leetcode.com", "test.email@leetcode.com" }));
    }

    @Test
    void _937_reorderLogFiles() {
	String[] expected = new String[] { "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1",
		"dig2 3 6" };
	assertArrayEquals(expected, solution._937_reorderLogFiles(
		new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" }));
    }

    @Test
    void _938_rangeSumBST() {
	TreeNode root = new TreeNode(10);
	root.left = new TreeNode(5);
	root.right = new TreeNode(15);
	root.left.left = new TreeNode(3);
	root.left.right = new TreeNode(7);
	root.right.right = new TreeNode(18);

	assertEquals(32, solution._938_rangeSumBST(root, 7, 15));
    }

    @Test
    void _942_diStringMatch() {
	assertArrayEquals(new int[] { 0, 4, 1, 3, 2 }, solution._942_diStringMatch("IDID"));
	assertArrayEquals(new int[] { 3, 2, 0, 1 }, solution._942_diStringMatch("DDI"));
	assertArrayEquals(new int[] { 0, 1, 2, 3 }, solution._942_diStringMatch("III"));
	assertArrayEquals(new int[] { 3, 2, 1, 0 }, solution._942_diStringMatch("DDD"));
    }

    @Test
    void _944_minDeletionSize() {
	assertEquals(1, solution._944_minDeletionSize(new String[] { "cba", "daf", "ghi" }));
	assertEquals(2, solution._944_minDeletionSize(new String[] { "rrjk", "furt", "guzm" }));
	assertEquals(3, solution._944_minDeletionSize(new String[] { "zyx", "wvu", "tsr" }));
    }

    @Test
    void _949_largestTimeFromDigits() {
	assertEquals("23:41", solution._949_largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
	assertEquals("", solution._949_largestTimeFromDigits(new int[] { 5, 5, 5, 5 }));
    }

    @Test
    void _961_repeatedNTimes() {
	assertEquals(3, solution._961_repeatedNTimes(new int[] { 1, 2, 3, 3 }));
	assertEquals(2, solution._961_repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
	assertEquals(5, solution._961_repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
    }

    @Test
    void _967_numsSameConsecDiff() {
	assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, solution._967_numsSameConsecDiffV2(1, 0));
	assertArrayEquals(new int[] { 181, 292, 707, 818, 929 }, solution._967_numsSameConsecDiffV2(3, 7));
	assertArrayEquals(new int[] { 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98 },
		solution._967_numsSameConsecDiffV2(2, 1));
    }

    @Test
    void _987_verticalTraversal() {
	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(9);
	root.right = new TreeNode(20);
	root.right.left = new TreeNode(15);
	root.right.right = new TreeNode(7);

	List<List<Integer>> answer = solution._987_verticalTraversal(root);

	assertEquals(4, answer.size());

	assertEquals(Arrays.asList(9), answer.get(0));
	assertEquals(Arrays.asList(3, 15), answer.get(1));
	assertEquals(Arrays.asList(20), answer.get(2));
	assertEquals(Arrays.asList(7), answer.get(3));
    }

    @Test
    void _994_orangesRotting() {
	assertEquals(4, solution._994_orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
	assertEquals(-1, solution._994_orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
	assertEquals(0, solution._994_orangesRotting(new int[][] { { 0, 2 } }));
	assertEquals(1, solution._994_orangesRotting(new int[][] { { 1, 2 } }));
    }

    @Test
    void _1002_commonChars() {
	assertThat(solution._1002_commonChars(new String[] { "bella", "label", "roller" }),
		containsInAnyOrder(new String[] { "e", "l", "l" }));
	assertThat(solution._1002_commonChars(new String[] { "cool", "lock", "cook" }),
		containsInAnyOrder(new String[] { "c", "o" }));
    }

    @Test
    void _1008_bstFromPreorder() {
	TreeNode expected = new TreeNode(8);
	expected.left = new TreeNode(5);
	expected.right = new TreeNode(10);
	expected.left.left = new TreeNode(1);
	expected.left.right = new TreeNode(7);
	expected.right.right = new TreeNode(12);

	TreeNode actual = solution._1008_bstFromPreorder(IntStream.of(8, 5, 1, 7, 10, 12).toArray());

	assertEquals(expected.val, actual.val);
	assertEquals(expected.left.val, actual.left.val);
	assertEquals(expected.right.val, actual.right.val);
	assertEquals(expected.left.left.val, actual.left.left.val);
	assertEquals(expected.left.right.val, actual.left.right.val);
	assertEquals(expected.right.right.val, actual.right.right.val);
    }

    @Test
    void _1021_removeOuterParentheses() {
	assertEquals("()()()()(())", solution._1021_removeOuterParentheses("(()())(())(()(()))"));
	assertEquals("()()()", solution._1021_removeOuterParentheses("(()())(())"));
	assertEquals("", solution._1021_removeOuterParentheses("()()"));
    }

    @Test
    void _1022_sumRootToLeaf() {
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(0);
	root.right = new TreeNode(1);
	root.left.left = new TreeNode(0);
	root.left.right = new TreeNode(1);
	root.right.left = new TreeNode(0);
	root.right.right = new TreeNode(1);

	assertEquals(22, solution._1022_sumRootToLeaf(root));
    }

    @Test
    void _1032_streamChecker() {
	Solution.StreamChecker streamChecker = solution._1032_streamChecker(new String[] { "cd", "f", "kl" });

	assertFalse(streamChecker.query('a'));
	assertFalse(streamChecker.query('b'));
	assertFalse(streamChecker.query('c'));
	assertTrue(streamChecker.query('d'));
	assertFalse(streamChecker.query('e'));
	assertTrue(streamChecker.query('f'));
	assertFalse(streamChecker.query('g'));
	assertFalse(streamChecker.query('h'));
	assertFalse(streamChecker.query('i'));
	assertFalse(streamChecker.query('j'));
	assertFalse(streamChecker.query('k'));
	assertTrue(streamChecker.query('l'));
    }

    @Test
    void _1046_lastStoneWeight() {
	assertThat(solution._1046_lastStoneWeight(IntStream.of(2, 7, 4, 1, 8, 1).toArray()), is(equalTo(1)));
    }

    @Test
    void _1047_removeDuplicates() {
	assertEquals("ca", solution._1047_removeDuplicates("abbaca"));
	assertEquals("a", solution._1047_removeDuplicates("a"));
	assertEquals("", solution._1047_removeDuplicates(""));
	assertNull(solution._1047_removeDuplicates(null));
    }

    @Test
    void _1051_heightChecker() {
	assertEquals(3, solution._1051_heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
    }

    @Test
    void _1078_findOcurrences() {
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
    void _1108_defangIPaddr() {
	assertEquals("192[.]168[.]1[.]1", solution._1108_defangIPaddr("192.168.1.1"));
    }

    @Test
    void _1103_distributeCandies() {
	assertArrayEquals(new int[] { 1, 2, 3, 1 }, solution._1103_distributeCandies(7, 4));
	assertArrayEquals(new int[] { 5, 2, 3 }, solution._1103_distributeCandies(10, 3));
    }

    @Test
    void _1122_relativeSortArray() {
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
    void _1286_CombinationIterator() {
	CombinationIterator iterator = solution._1286_CombinationIterator("abc", 2);

	assertTrue(iterator.hasNext());
	assertEquals("ab", iterator.next());
	assertTrue(iterator.hasNext());
	assertEquals("ac", iterator.next());
	assertTrue(iterator.hasNext());
	assertEquals("bc", iterator.next());
	assertFalse(iterator.hasNext());
	assertNull(iterator.next());
    }

    @Test
    void _1305_getAllElements() {
	TreeNode root1 = new TreeNode(8);
	root1.left = new TreeNode(5);
	root1.right = new TreeNode(10);
	root1.left.left = new TreeNode(1);
	root1.left.right = new TreeNode(7);
	root1.right.right = new TreeNode(12);

	TreeNode root2 = new TreeNode(1);
	root2.left = new TreeNode(15);
	root2.right = new TreeNode(8);
	root2.left.right = new TreeNode(71);
	root2.left.right.left = new TreeNode(2);

	List<Integer> actual = solution._1305_getAllElements(root1, root2);
	List<Integer> expected = Arrays.asList(1, 1, 2, 5, 7, 8, 8, 10, 12, 15, 71);

	assertEquals(expected, actual);
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
