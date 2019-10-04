package com.kristurek.leetcode.sort;

public class MergeSort {

	public static void sort(int[] arr) {
		if (arr == null || arr.length == 1)
			return;
		divide(arr, 0, arr.length - 1);
	}

	private static void divide(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + (r - l) / 2;

			divide(arr, l, mid);
			divide(arr, mid + 1, r);

			merge(arr, l, mid, r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int[] tmp = new int[r - l + 1];

		int i = l;
		int j = m + 1;
		int k = 0;

		while (i <= m && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[k] = arr[i];
				k++;
				i++;
			} else {
				tmp[k] = arr[j];
				k++;
				j++;
			}
		}

		while (i <= m) {
			tmp[k] = arr[i];
			k++;
			i++;
		}

		while (j <= r) {
			tmp[k] = arr[j];
			k++;
			j++;
		}

		for (i = l; i <= r; i++)
			arr[i] = tmp[i - l];
	}

}
