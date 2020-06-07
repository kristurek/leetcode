package com.kristurek.leetcode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.ListNode;

public class SolutionTest {

	private Solution solution = new Solution();

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
		assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), solution._17_letterCombinations("23"));
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
	void _22_generateParenthesis() {
		List<String> list = Arrays.asList("()()()", "()(())", "(())()", "(()())", "((()))");
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
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);

		ListNode head = solution._24_swapPairs(head1);

		assertEquals(2, head.val);
		assertEquals(1, head.next.val);
		assertEquals(4, head.next.next.val);
		assertEquals(3, head.next.next.next.val);
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
	void _41_firstMissingPositive() {
		assertEquals(1, solution._41_firstMissingPositive(new int[] { 3, 7, 8, 9 }));
		assertEquals(2, solution._41_firstMissingPositive(new int[] { 1, 3, 7, 8, 9 }));
		assertEquals(4, solution._41_firstMissingPositive(new int[] { 1, 2, 3, 7, 8, 9 }));
		assertEquals(2, solution._41_firstMissingPositive(new int[] { -1, 1, 3, 4 }));
		assertEquals(1, solution._41_firstMissingPositive(new int[] {}));
		assertEquals(1, solution._41_firstMissingPositive(new int[] { 0 }));
	}

	@Test
	void _42_trap() {
		assertEquals(6, solution._42_trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
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
	void _45_jump() {
		assertEquals(1, solution._45_jump(new int[] { 2, 3, 1, 1, 4 }));
	}

	@Test
	void _48_rotate() {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		solution._48_rotate(matrix);

		assertArrayEquals(new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } }, matrix);
	}

	@Test
	void _50_myPow() {
		assertEquals(8, solution._50_myPow(2, 3));
		assertEquals(0, solution._50_myPow(2, -2147483648));
	}

	@Test
	void _54_spiralOrder() {
		assertThat(solution._54_spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }), is(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));
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
	void _61_rotateRight2() {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);

		head = solution._61_rotateRight(head, 4);

		assertEquals(2, head.val);
		assertEquals(0, head.next.val);
		assertEquals(1, head.next.next.val);
		assertNull(head.next.next.next);
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
	void _74_searchMatrix() {
		assertTrue(solution._74_searchMatrix(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } }, 7));
	}

	@Test
	void _75_sortColors() {
		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };

		solution._75_sortColors(nums);

		assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 2 }, nums);
	}

	@Test
	void _75_sortColors2() {
		int[] nums = new int[] { 2, 0, 1 };

		solution._75_sortColors(nums);

		assertArrayEquals(new int[] { 0, 1, 2 }, nums);
	}

	@Test
	void _75_sortColors3() {
		int[] nums = new int[] { 1, 2, 0, 0 };

		solution._75_sortColors(nums);

		// System.out.println(Arrays.toString(nums));

		assertArrayEquals(new int[] { 0, 0, 1, 2 }, nums);
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
	void _92_reverseBetween() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		head = solution._92_reverseBetween(head, 1, 6);

		assertEquals(6, head.val);
		assertEquals(5, head.next.val);
		assertEquals(4, head.next.next.val);
		assertEquals(3, head.next.next.next.val);
		assertEquals(2, head.next.next.next.next.val);
		assertEquals(1, head.next.next.next.next.next.val);
		assertNull(head.next.next.next.next.next.next);
	}

	@Test
	void _137_singleNumber() {
		assertEquals(1, solution._137_singleNumber(new int[] { 3, 5, 3, 5, 3, 1, 2, 3, 5, 2 }));
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
	void _200_numIslands() {
		assertEquals(1, solution._200_numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
		assertEquals(3, solution._200_numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
	}

	@Test
	void _203_removeElements() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(1);

		head = solution._203_removeElements(head, 1);

		assertEquals(head.val, 2);
		assertEquals(head.next.val, 3);
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
	void _202_isHappy() {
		assertTrue(solution._202_isHappy(19));
	}

	@Test
	void _283_moveZeroes() {
		int[] nums = IntStream.of(0, 1, 0, 3, 12).toArray();
		int[] answer = IntStream.of(1, 3, 12, 0, 0).toArray();
		solution._283_moveZeroes(nums);

		assertArrayEquals(answer, nums);
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
	void _5_longestPalindrome() {
		assertEquals("bab", solution._5_longestPalindrome("babad"));
		assertEquals("bb", solution._5_longestPalindrome("cbbd"));
		assertEquals("a", solution._5_longestPalindrome("a"));
		assertEquals("a", solution._5_longestPalindrome("abc"));
		assertEquals(
				"dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd",
				solution._5_longestPalindrome(
						"dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd"));
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
	void _525_findMaxLength() {
		assertThat(solution._525_findMaxLength(IntStream.of(0, 1).toArray()), is(equalTo(2)));
		assertThat(solution._525_findMaxLength(IntStream.of(0, 1, 0).toArray()), is(equalTo(2)));
	}

	@Test
	void _1046_lastStoneWeight() {
		assertThat(solution._1046_lastStoneWeight(IntStream.of(2, 7, 4, 1, 8, 1).toArray()), is(equalTo(1)));
	}

	@Test
	void _1360_daysBetweenDates() {
		assertThat(solution._1360_daysBetweenDates("2019-06-29", "2019-06-30"), is(equalTo(1)));
		assertThat(solution._1360_daysBetweenDates("2020-01-15", "2019-12-31"), is(equalTo(15)));
	}

	@Test
	void _1365_smallerNumbersThanCurrent() {
		assertArrayEquals(IntStream.of(4, 0, 1, 1, 3).toArray(), solution._1365_smallerNumbersThanCurrent(IntStream.of(8, 1, 2, 2, 3).toArray()));
		assertArrayEquals(IntStream.of(2, 1, 0, 3).toArray(), solution._1365_smallerNumbersThanCurrent(IntStream.of(6, 5, 4, 8).toArray()));
		assertArrayEquals(IntStream.of(0, 0, 0, 0).toArray(), solution._1365_smallerNumbersThanCurrent(IntStream.of(7, 7, 7, 7).toArray()));
	}

	@Test
	void _1374_generateTheString() {
		assertThat(solution._1374_generateTheString(4), is(equalTo("baaa")));
		assertThat(solution._1374_generateTheString(2), is(equalTo("ba")));
		assertThat(solution._1374_generateTheString(7), is(equalTo("bbbbbbb")));
	}

	@Test
	void _1380_luckyNumbers() {
		int[][] matrix = Stream.of(new int[] { 3, 7, 8 }, new int[] { 9, 11, 13 }, new int[] { 15, 16, 17 }).toArray(int[][]::new);

		assertThat(solution._1380_luckyNumbers(matrix), is(equalTo(Stream.of(15).collect(Collectors.toList()))));
	}

	@Test
	void _1389_createTargetArray() {
		assertArrayEquals(IntStream.of(0, 4, 1, 3, 2).toArray(), solution._1389_createTargetArray(IntStream.of(0, 1, 2, 3, 4).toArray(), IntStream.of(0, 1, 2, 2, 1).toArray()));
		assertArrayEquals(IntStream.of(0, 1, 2, 3, 4).toArray(), solution._1389_createTargetArray(IntStream.of(1, 2, 3, 4, 0).toArray(), IntStream.of(0, 1, 2, 3, 0).toArray()));
		assertArrayEquals(IntStream.of(1).toArray(), solution._1389_createTargetArray(IntStream.of(1).toArray(), IntStream.of(0).toArray()));
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
		assertThat(solution._1403_minSubsequence(IntStream.of(4, 3, 10, 9, 8).toArray()), is(Stream.of(10, 9).collect(Collectors.toList())));

		assertThat(solution._1403_minSubsequence(IntStream.of(4, 4, 7, 6, 7).toArray()), is(Stream.of(7, 7, 6).collect(Collectors.toList())));
	}
}
