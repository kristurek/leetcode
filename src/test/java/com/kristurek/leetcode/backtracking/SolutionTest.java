package com.kristurek.leetcode.backtracking;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SolutionTest {

	private SolutionBacktracking solution = new SolutionBacktracking();

	@Test
	void _78_subsets() {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList());
		answer.add(Arrays.asList(1));
		answer.add(Arrays.asList(1, 2));
		answer.add(Arrays.asList(1, 2, 3));
		answer.add(Arrays.asList(1, 3));
		answer.add(Arrays.asList(2));
		answer.add(Arrays.asList(2, 3));
		answer.add(Arrays.asList(3));

		assertThat(solution._78_subsets(new int[] { 1, 2, 3 }), is(answer));
	}

	@Test
	void _90_subsetsWithDup() {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList());
		answer.add(Arrays.asList(1));
		answer.add(Arrays.asList(1, 2));
		answer.add(Arrays.asList(1, 2, 2));
		answer.add(Arrays.asList(2));
		answer.add(Arrays.asList(2, 2));

		assertThat(solution._90_subsetsWithDup(new int[] { 2, 1, 2 }), is(answer));
	}

	@Test
	void _46_permute() {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(1, 2));
		answer.add(Arrays.asList(2, 1));

		assertThat(solution._46_permute(new int[] { 1, 2 }), is(answer));
	}

	@Test
	void _47_permuteUnique() {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(1, 1, 2));
		answer.add(Arrays.asList(1, 2, 1));
		answer.add(Arrays.asList(2, 1, 1));

		assertThat(solution._47_permuteUnique(new int[] { 1, 2, 1 }), is(answer));
	}

	@Test
	void _39_combinationSum() {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(2, 2, 3));
		answer.add(Arrays.asList(7));

		assertThat(solution._39_combinationSum(new int[] { 2, 3, 6, 7 }, 7), is(answer));
	}

	@Test
	void _40_combinationSum2() {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(7));

		assertThat(solution._40_combinationSum2(new int[] { 2, 3, 6, 7 }, 7), is(answer));
	}

	@Test
	void _131_partition() {
		List<List<String>> answer = new ArrayList<>();
		answer.add(Arrays.asList("a", "a", "b"));
		answer.add(Arrays.asList("aa", "b"));

		assertThat(solution._131_partition("aab"), is(answer));
	}

	@Test
	void _60_getPermutation() {
		assertEquals("213", solution._60_getPermutation(3, 3));
	}

	@Test
	void _77_combine() {
		List<List<Integer>> answer = new ArrayList<>();
		answer.add(Arrays.asList(1, 2));
		answer.add(Arrays.asList(1, 3));
		answer.add(Arrays.asList(1, 4));
		answer.add(Arrays.asList(2, 3));
		answer.add(Arrays.asList(2, 4));
		answer.add(Arrays.asList(3, 4));

		assertThat(solution._77_combine(4, 2), is(answer));
	}

}
