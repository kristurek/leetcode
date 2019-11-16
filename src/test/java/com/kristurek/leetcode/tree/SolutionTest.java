package com.kristurek.leetcode.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.TreeNode;

public class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void _94_inorderTraversal() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<Integer> values = solution._94_inorderTraversal(root);

		assertThat(values, is(Arrays.asList(4, 2, 5, 1, 6, 3, 7)));
	}

	@Test
	void _98_isValidBST() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		assertFalse(solution._98_isValidBST(root));
	}

	@Test
	void _100_isSameTree() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		assertTrue(solution._100_isSameTree(root, root));
	}

	@Test
	void _101_isSymmetric() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(2);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		assertTrue(solution._101_isSymmetric(root));
	}

	@Test
	void _102_levelOrder() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<List<Integer>> results = Arrays.asList(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6, 7));

		assertThat(solution._102_levelOrder(root), is(results));
	}

	@Test
	void _103_zigzagLevelOrder() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<List<Integer>> results = Arrays.asList(Arrays.asList(1), Arrays.asList(3, 2), Arrays.asList(4, 5, 6, 7));

		assertThat(solution._103_zigzagLevelOrder(root), is(results));
	}

	@Test
	void _104_maxDepth() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.right = new TreeNode(4);

		assertEquals(3, solution._104_maxDepth(root));
	}

	@Test
	void _107_levelOrderBottom() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<List<Integer>> results = Arrays.asList(Arrays.asList(4, 5, 6, 7), Arrays.asList(2, 3), Arrays.asList(1));

		assertThat(solution._107_levelOrderBottom(root), is(results));
	}

	@Test
	void _110_isBalanced() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.right = new TreeNode(7);

		assertFalse(solution._110_isBalanced(root));
	}

	@Test
	void _111_minDepth() {
		TreeNode root = new TreeNode(1);

		// root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		// root.right.right = new TreeNode(7);
		// root.right.right.right = new TreeNode(7);
		// root.right.right.right.right = new TreeNode(7);

		assertEquals(3, solution._111_minDepth(root));
	}

	@Test
	void _112_hasPathSum() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.right = new TreeNode(7);

		assertTrue(solution._112_hasPathSum(root, 7));
	}

	@Test
	@Disabled
	void _113_pathSum() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(3);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(7);
		root.right.right.right.right = new TreeNode(7);

		assertThat(solution._113_pathSum(root, 7), is(Arrays.asList(Arrays.asList(1, 2, 4))));
	}

}
