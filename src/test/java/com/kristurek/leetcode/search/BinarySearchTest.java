package com.kristurek.leetcode.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	@Test
	void binarySearch1() {
		assertEquals(0, BinarySearch.search1(new int[] { 0, 1, 2, 3, 4 }, 0));
		assertEquals(2, BinarySearch.search1(new int[] { 0, 1, 3, 3, 4 }, 3));
	}
	
	@Test
	void binarySearch2() {
		assertEquals(0, BinarySearch.search2(new int[] { 0, 1, 2, 3, 4 }, 0));
		assertEquals(2, BinarySearch.search2(new int[] { 0, 1, 3, 3, 4 }, 3));
	}

}
