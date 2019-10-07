package com.kristurek.leetcode.search;

public class BinarySearch {

	public static int search1(int[] arr, int target) {
		return binarySearchIterative(arr, target);
	}

	public static int search2(int[] arr, int target) {
		return binarySearchRecursive(arr, target, 0, arr.length - 1);
	}

	private static int binarySearchIterative(int[] arr, int target) {
		int l = 0;
		int r = arr.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (target > arr[m])
				l = m + 1;
			else if (target < arr[m])
				r = m - 1;
			else
				return m;
		}

		return -1;
	}

	private static int binarySearchRecursive(int[] arr, int target, int l, int r) {
		if (l <= r) {
			int m = l + (r - l) / 2;

			if (target > arr[m])
				return binarySearchRecursive(arr, target, m + 1, r);
			else if (target < arr[m])
				return binarySearchRecursive(arr, target, l, m - 1);
			else
				return m;
		}

		return -1;
	}
}
