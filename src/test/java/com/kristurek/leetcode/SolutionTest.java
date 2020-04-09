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
	void removeDuplicates() {
		int[] arr = new int[] { 1, 1, 2 };

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
		assertEquals(2, solution._69_mySqrt(8));
		assertEquals(2, solution._69_mySqrt(4));
		assertEquals(4, solution._69_mySqrt(16));
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
	void _74_searchMatrix() {
		assertTrue(solution._74_searchMatrix(
				new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } }, 7));
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
	void _83_deleteDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);

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
	void _125_isPalindrome() {
		assertTrue(solution._125_isPalindrome("A man, a plan, a canal: Panama"));
		assertFalse(solution._125_isPalindrome("race a car"));
	}

	@Test
	void _121_maxProfit() {
		assertEquals(5, solution._121_maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		assertEquals(0, solution._121_maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	@Test
	void _122_maxProfit() {
		assertEquals(7, solution._122_maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		assertEquals(0, solution._122_maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	@Test
	void _136_singleNumber() {
		assertEquals(1, solution._136_singleNumber(new int[] { 3, 5, 1, 2, 3, 5, 2 }));
	}

	@Test
	void _137_singleNumber() {
		assertEquals(1, solution._137_singleNumber(new int[] { 3, 5, 3, 5, 3, 1, 2, 3, 5, 2 }));
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
		assertThat(solution._1374_generateTheString(4), is(equalTo("baaa")));
		assertThat(solution._1374_generateTheString(2), is(equalTo("ba")));
		assertThat(solution._1374_generateTheString(7), is(equalTo("bbbbbbb")));
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
