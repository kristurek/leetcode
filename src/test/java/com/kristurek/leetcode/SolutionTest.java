package com.kristurek.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.ListNode;

public class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void _1_twoSum() {
		assertArrayEquals(new int[] { 0, 1 }, solution._1_twoSum(new int[] { 2, 7, 11, 15 }, 9));
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
	void _7_reverse() {
		assertEquals(321, solution._7_reverse(123));
		assertEquals(-321, solution._7_reverse(-123));
		assertEquals(21, solution._7_reverse(120));
	}

	@Test
	void _9_isPalindrome() {
		assertTrue(solution._9_isPalindrome(121));
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
		List<String> list = Arrays.asList("()()()", "()(())", "(())()", "(()())", "((()))");
		assertThat(solution._22_generateParenthesis(3), is(list));
	}
}
