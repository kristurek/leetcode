package com.kristurek.leetcode.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.TreeNode;

public class DfsTraversalTreeTest {

	@Test
	void traversePreOrder() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<Integer> values = DfsTraversalTree.traversePreOrder(root);

		assertThat(values, is(Arrays.asList(1, 2, 4, 5, 3, 6, 7)));
	}

	@Test
	void traverseInOrder() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<Integer> values = DfsTraversalTree.traverseInOrder(root);

		assertThat(values, is(Arrays.asList(4, 2, 5, 1, 6, 3, 7)));
	}

	@Test
	void traversePostOrder() {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<Integer> values = DfsTraversalTree.traversePostOrder(root);

		assertThat(values, is(Arrays.asList(4, 5, 2, 6, 7, 3, 1)));
	}

}
