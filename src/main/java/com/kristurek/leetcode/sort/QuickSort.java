package com.kristurek.leetcode.sort;

public class QuickSort {

    public static void sort0(int[] nums) {
	quicksort0(nums, 0, nums.length - 1);
    }

    private static void quicksort0(int[] nums, int l, int h) {
	if (l < h) {
	    int splitPoint = partition0(nums, l, h);

	    quicksort0(nums, l, splitPoint - 1);
	    quicksort0(nums, splitPoint + 1, h);
	}
    }

    private static int partition0(int[] nums, int left, int right) {
	int pivot = nums[right];
	int lowerIndex = left - 1;// index of values lower than pivot

	for (int currentIndex = left; currentIndex < right; currentIndex++) { // currentIndex < right --> right is pivot
	    if (nums[currentIndex] < pivot) {
		lowerIndex++;

		int tmp = nums[currentIndex];
		nums[currentIndex] = nums[lowerIndex];
		nums[lowerIndex] = tmp;
	    }
	}
	// move pivot value to correct position
	lowerIndex++;

	int tmp = nums[lowerIndex];
	nums[lowerIndex] = nums[right];
	nums[right] = tmp;

	return lowerIndex;
    }

    public static void sort1(int[] arr) {
	if (arr == null || arr.length == 0)
	    return;

	quickSort1(arr, 0, arr.length - 1);
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

	if (j > left)
	    quickSort1(arr, left, j);
	if (i < right)
	    quickSort1(arr, i, right);
    }

    public static void sort2(int[] arr) {
	quickSort2(arr, 0, arr.length - 1);
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
