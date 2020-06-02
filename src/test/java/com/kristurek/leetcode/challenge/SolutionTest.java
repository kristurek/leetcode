package com.kristurek.leetcode.challenge;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
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

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.TreeNode;

public class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void singleNumber() {
		assertEquals(1, solution.singleNumber(IntStream.of(2, 2, 1).toArray()));
		assertEquals(4, solution.singleNumber(IntStream.of(4, 1, 2, 1, 2).toArray()));
		assertThrows(NoSuchElementException.class, () -> solution.singleNumber(IntStream.of(4, 1, 2, 1, 2, 4).toArray()));
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

	@Test
	void minStack() {
		Solution.MinStack minStack = solution.minStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		assertThat(minStack.getMin(), is(equalTo(-3)));
		minStack.pop();
		assertThat(minStack.top(), is(equalTo(0)));
		assertThat(minStack.getMin(), is(equalTo(-2)));
	}

	@Disabled
	@Test
	void diameterOfBinaryTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		assertThat(solution.diameterOfBinaryTree(root), is(equalTo(3)));
	}

	@Disabled
	@Test
	void _lastStoneWeight() {
		assertThat(solution.lastStoneWeight(IntStream.of(2, 7, 4, 1, 8, 1).toArray()), is(equalTo(1)));
	}

	@Disabled
	@Test
	void findMaxLength() {
		assertThat(solution.findMaxLength(IntStream.of(0, 1).toArray()), is(equalTo(2)));
		assertThat(solution.findMaxLength(IntStream.of(0, 1, 0).toArray()), is(equalTo(2)));
	}

	@Test
	void stringShift() {
		assertThat(solution.stringShift("abc", new int[][] { { 0, 1 }, { 1, 1 } }), is(equalTo("abc")));
		assertThat(solution.stringShift("abc", new int[][] { { 0, 1 } }), is(equalTo("bca")));
		assertThat(solution.stringShift("abc", new int[][] { { 1, 1 } }), is(equalTo("cab")));
		assertThat(solution.stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } }), is(equalTo("cab")));
		assertThat(solution.stringShift("abcdefg", new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } }), is(equalTo("efgabcd")));
		assertThat(solution.stringShift("yisxjwry", new int[][] { { 1, 8 }, { 1, 4 }, { 1, 3 }, { 1, 6 }, { 0, 6 }, { 1, 4 }, { 0, 2 }, { 0, 1 } }), is(equalTo("yisxjwry")));
	}

	@Test
	void productExceptSelf() {
		assertArrayEquals(IntStream.of(24, 12, 8, 6).toArray(), solution.productExceptSelf(IntStream.of(1, 2, 3, 4).toArray()));
	}

	@Test
	void checkValidString() {
		assertTrue(solution.checkValidString("()"));
		assertTrue(solution.checkValidString("(*)"));
		assertTrue(solution.checkValidString("(*))"));
	}

	@Test
	void numIslands() {
		assertEquals(1, solution.numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
		assertEquals(3, solution.numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
	}

	@Test
	void minPathSum() {
		assertEquals(7, solution.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
	}

	@Test
	void search() {
		assertThat(solution.search(IntStream.of(4, 5, 6, 7, 0, 1, 2).toArray(), 0), is(equalTo(4)));
		assertThat(solution.search(IntStream.of(4, 5, 6, 7, 0, 1, 2).toArray(), 3), is(equalTo(-1)));
		assertThat(solution.search(IntStream.of(5, 1, 3).toArray(), 1), is(equalTo(1)));
	}

	@Test
	void bstFromPreorder() {
		TreeNode expected = new TreeNode(8);
		expected.left = new TreeNode(5);
		expected.right = new TreeNode(10);
		expected.left.left = new TreeNode(1);
		expected.left.right = new TreeNode(7);
		expected.right.right = new TreeNode(12);

		TreeNode actual = solution.bstFromPreorder(IntStream.of(8, 5, 1, 7, 10, 12).toArray());

		assertEquals(expected.val, actual.val);
		assertEquals(expected.left.val, actual.left.val);
		assertEquals(expected.right.val, actual.right.val);
		assertEquals(expected.left.left.val, actual.left.left.val);
		assertEquals(expected.left.right.val, actual.left.right.val);
		assertEquals(expected.right.right.val, actual.right.right.val);
	}

	@Test
	void leftMostColumnWithOne() {
		BinaryMatrix bm = new BinaryMatrix() {

			int counter = 0;
			int[][] m = { { 0, 0 }, { 0, 1 } };

			@Override
			public int get(int x, int y) {
				System.out.println(++counter);
				return m[y][x];
			}

			@Override
			public List<Integer> dimensions() {
				return Stream.of(2, 2).collect(Collectors.toList());
			}
		};

		assertEquals(1, solution.leftMostColumnWithOne(bm));
	}

	@Test
	void subarraySum() {
		assertEquals(2, solution.subarraySum(IntStream.of(1, 1, 1).toArray(), 2));
	}
}