package com.kristurek.leetcode.sort;

public class QuickSort {

	public static void sort1(int[] arr) {
		if (arr == null || arr.length == 0)
			return;

		quickSort1(arr, 0, arr.length - 1);
	}

	public static void sort2(int[] arr) {
		quickSort2(arr, 0, arr.length - 1);
	}

	private static void quickSort1(int[] arr, int left, int right) {
		int i = left;
		int j = right;

		int pivot = arr[left + (right - left) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;

			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;

				i++;
				j--;
			}
		}
		if (i < right)// i++, i++, i++ so must be < right
			quickSort1(arr, left, i);

		if (j > left)// j--,j--,j-- so must be > left
			quickSort1(arr, j, right);
	}

	private static void quickSort2(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort2(arr, left, index - 1);
		if (index < right)
			quickSort2(arr, index, right);
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left, j = right;

		while (i <= j) {

			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;

			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;

				i++;
				j--;
			}
		}

		return i;
	}

}
