package com.kristurek.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.TreeNode;

public class BSTIteratorTest {

	@Test
	void _173_BSTIterator() {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BSTIterator iterator = new BSTIterator(root);
		assertEquals(3, iterator.next());
		assertEquals(7, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(9, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(15, iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals(20, iterator.next());
		assertFalse(iterator.hasNext());
	}

}
