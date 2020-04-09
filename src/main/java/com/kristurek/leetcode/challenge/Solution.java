package com.kristurek.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kristurek.leetcode.common.ListNode;

public class Solution {

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums)
			if (set.contains(num))
				set.remove(num);
			else
				set.add(num);

		return set.stream().findAny().orElseThrow();
	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (!set.contains(n)) {
			set.add(n);

			int sumOfSquare = 0;
			while (n > 0) {
				int remain = n % 10;
				sumOfSquare += remain * remain;

				n = n / 10;
			}

			if (sumOfSquare == 1)
				return true;

			n = sumOfSquare;
		}

		return false;
	}

	public int maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (sum < 0)
				sum = nums[i];
			else
				sum += nums[i];

			if (sum > max)
				max = sum;
		}

		return max;
	}

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int slow = 0;
		for (int num : nums)
			if (num != 0)
				nums[slow++] = num;

		while (slow < nums.length)
			nums[slow++] = 0;

	}

	public int maxProfit(int[] prices) {
		if (prices == null)
			return 0;

		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++)
			if (prices[i] > prices[i - 1])
				maxProfit += prices[i] - prices[i - 1];

		return maxProfit;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();

			Arrays.sort(charArray);

			String key = String.valueOf(charArray);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());

			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public int countElements(int[] arr) {
		if (arr == null)
			return 0;

		int count = 0;

		Set<Integer> set = new HashSet<>();
		for (int num : arr)
			set.add(num);

		for (int num : arr)
			if (set.contains(num + 1))
				count++;

		return count;
	}

	public ListNode middleNode(ListNode head) {
		int size = 1;

		ListNode current = head;
		while (current.next != null) {
			size++;
			current = current.next;
		}

		current = head;
		int max = Math.round(size / 2);
		int i = 1;
		while (i++ <= max) {
			current = current.next;
		}

		return current;
	}

	public boolean backspaceCompare(String S, String T) {
		return backspaceCompare_build(S).equals(backspaceCompare_build(T));
	}

	private String backspaceCompare_build(String t) {
		Deque<Character> stack = new LinkedList<>();

		for (char character : t.toCharArray()) {
			if (character != '#')
				stack.push(character);
			else if (!stack.isEmpty())
				stack.pop();
		}

		return stack.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
	}
}
