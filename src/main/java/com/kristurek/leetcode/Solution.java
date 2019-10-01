package com.kristurek.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.kristurek.leetcode.common.ListNode;

public class Solution {

	public int[] _1_twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int search = target - nums[i];
			if (map.containsKey(search))
				return new int[] { map.get(search), i };
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No found");
	}

	public ListNode _2_addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;

		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;

			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;

			if (p != null)
				p = p.next;
			if (q != null)
				q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	public int _3_lengthOfLongestSubstring(String s) {
		String max = "";
		String curr = "";

		for (int i = 0; i < s.length(); i++) {
			curr = Character.toString(s.charAt(i));

			for (int j = i + 1; j < s.length(); j++) {
				if (!curr.contains(Character.toString(s.charAt(j))))
					curr = curr + Character.toString(s.charAt(j));
				else
					break;
			}

			if (curr.length() > max.length())
				max = curr;
		}

		return max.length();
	}

	public double _4_findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];

		int i = 0, i1 = 0, i2 = 0;

		while (i1 < nums1.length && i2 < nums2.length) {
			if (nums1[i1] < nums2[i2])
				nums[i++] = nums1[i1++];
			else if (nums1[i1] > nums2[i2])
				nums[i++] = nums2[i2++];
			else
				nums[i++] = nums1[i1++];
		}

		if (i1 < nums1.length)
			while (i1 < nums1.length)
				nums[i++] = nums1[i1++];

		if (i2 < nums2.length)
			while (i2 < nums2.length)
				nums[i++] = nums2[i2++];

		if (nums.length % 2 != 0)
			return nums[nums.length / 2];
		else
			return ((double) (nums[(nums.length / 2) - 1] + nums[nums.length / 2])) / 2.0;
	}
}
