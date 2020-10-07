package com.kristurek.leetcode.tree;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.TreeNode;

public class BfsTraversalTreeTest {

    @Test
    void traverseIterative() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	List<Integer> values = BfsTraversalTree.traverseIterative(root);

	assertThat(values, is(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void traverseRecursive() {
	TreeNode root = new TreeNode(1);

	root.left = new TreeNode(2);
	root.right = new TreeNode(3);

	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	root.right.left = new TreeNode(6);
	root.right.right = new TreeNode(7);

	List<Integer> values = BfsTraversalTree.traverseRecursive(root);

	assertThat(values, is(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }
}
