package com.kristurek.leetcode.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class QuickSortTest {

	@Test
	void quickSort1_1() {
		int[] arr = new int[] { 9, 7, 1, 2, 8, 6, 4, 3, 5, 10 };

		QuickSort.sort1(arr);

		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, arr);
	}

	@Test
	void quickSort1_2() {
		int[] arr = new int[] { 9 };

		QuickSort.sort1(arr);

		assertArrayEquals(new int[] { 9 }, arr);
	}

	@Test
	void quickSort1_3() {
		int[] arr = new int[] {};

		QuickSort.sort1(arr);

		assertArrayEquals(new int[] {}, arr);
	}

	@Test
	void quickSort1_4() {
		int[] arr = new int[] { 1, 1, 1, 0 };

		QuickSort.sort1(arr);

		assertArrayEquals(new int[] { 0, 1, 1, 1 }, arr);
	}

	@Test
	void quickSort1_5() {
		int[] arr = { 4, 2, 7, 5, 9, 1, 3, 6, 8 };
		QuickSort.sort2(arr);

		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, arr);
	}

	@Test
	void quickSort2() {
		int[] arr = new int[] { 9, 7, 1, 2, 8, 6, 4, 3, 5, 10 };

		QuickSort.sort2(arr);

		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, arr);
	}
}
