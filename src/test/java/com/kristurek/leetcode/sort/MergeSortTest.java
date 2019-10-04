package com.kristurek.leetcode.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeSortTest {

	@Test
	void mergeSort1() {
		int[] arr = new int[] { 9, 7, 1, 2, 8, 6, 4, 3, 5, 10 };

		MergeSort.sort(arr);

		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, arr);
	}

	@Test
	void mergeSort2() {
		int[] arr = new int[] { 9 };

		MergeSort.sort(arr);

		assertArrayEquals(new int[] { 9 }, arr);
	}

	@Test
	void mergeSort3() {
		int[] arr = new int[] {};

		MergeSort.sort(arr);

		assertArrayEquals(new int[] {}, arr);
	}

	@Test
	void mergeSort4() {
		int[] arr = new int[] { 1, 1, 1, 0 };

		MergeSort.sort(arr);

		assertArrayEquals(new int[] { 0, 1, 1, 1 }, arr);
	}
}
