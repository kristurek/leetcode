package com.kristurek.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
