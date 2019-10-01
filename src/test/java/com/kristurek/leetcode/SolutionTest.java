package com.kristurek.leetcode;

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
}
