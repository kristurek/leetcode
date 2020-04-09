package com.kristurek.leetcode.challenge;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void singleNumber() {
		assertEquals(1, solution.singleNumber(IntStream.of(2, 2, 1).toArray()));
		assertEquals(4, solution.singleNumber(IntStream.of(4, 1, 2, 1, 2).toArray()));
		assertThrows(NoSuchElementException.class,
				() -> solution.singleNumber(IntStream.of(4, 1, 2, 1, 2, 4).toArray()));
	}

	@Test
	void isHappy() {
		assertTrue(solution.isHappy(19));
	}

	@Test
	void maxSubArray() {
		assertEquals(6, solution.maxSubArray(IntStream.of(-2, 1, -3, 4, -1, 2, 1, -5, 4).toArray()));
	}

	@Test
	void moveZeroes() {
		int[] nums = IntStream.of(0, 1, 0, 3, 12).toArray();
		int[] answer = IntStream.of(1, 3, 12, 0, 0).toArray();
		solution.moveZeroes(nums);

		assertArrayEquals(answer, nums);
	}

	@Test
	void maxProfit() {
		assertEquals(7, solution.maxProfit(IntStream.of(7, 1, 5, 3, 6, 4).toArray()));
		assertEquals(0, solution.maxProfit(IntStream.of(7, 6, 4, 3, 1).toArray()));
		assertEquals(0, solution.maxProfit(IntStream.of().toArray()));
		assertEquals(0, solution.maxProfit(null));
	}

	@Test
	void groupAnagrams() {
		String[] input = Stream.of("eat", "tea", "tan", "ate", "nat", "bat").toArray(String[]::new);

		List<String> l1 = Stream.of("eat", "tea", "ate").collect(Collectors.toList());
		List<String> l2 = Stream.of("tan", "nat").collect(Collectors.toList());
		List<String> l3 = Stream.of("bat").collect(Collectors.toList());

		List<List<String>> expected = new ArrayList<>();
		expected.add(l1);
		expected.add(l2);
		expected.add(l3);

		assertThat(solution.groupAnagrams(input), containsInAnyOrder(expected.toArray()));
	}

	@Test
	void countElements() {
		assertThat(solution.countElements(null), is(equalTo(0)));
		assertThat(solution.countElements(IntStream.of().toArray()), is(equalTo(0)));
		assertThat(solution.countElements(IntStream.of(1).toArray()), is(equalTo(0)));
		assertThat(solution.countElements(IntStream.of(1, 1, 2).toArray()), is(equalTo(2)));
		assertThat(solution.countElements(IntStream.of(1, 1, 1, 3).toArray()), is(equalTo(0)));
		assertThat(solution.countElements(IntStream.of(1, 2, 1, 2, 2, 2, 2, 2).toArray()), is(equalTo(2)));
		assertThat(solution.countElements(IntStream.of(1, 2, 3).toArray()), is(equalTo(2)));
		assertThat(solution.countElements(IntStream.of(1, 1, 3, 3, 5, 5, 7, 7).toArray()), is(equalTo(0)));
		assertThat(solution.countElements(IntStream.of(1, 3, 2, 3, 5, 0).toArray()), is(equalTo(3)));
		assertThat(solution.countElements(IntStream.of(1, 1, 2, 2).toArray()), is(equalTo(2)));
		assertThat(solution.countElements(IntStream.of(1, 1, 3, 3, 4, 4, 5, 5, 7, 7).toArray()), is(equalTo(4)));
	}

	@Test
	void backspaceCompare() {
		assertTrue(solution.backspaceCompare("", ""));
		assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
		assertTrue(solution.backspaceCompare("ab##", "c#d#"));
		assertTrue(solution.backspaceCompare("a##c", "#a#c"));
		assertFalse(solution.backspaceCompare("a#c", "b"));
	}
}
