package com.kristurek.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.kristurek.leetcode.common.TreeNode;

class BSTIterator {

	private List<Integer> values = new ArrayList<Integer>();
	private int index = -1;

	public BSTIterator(TreeNode root) {
		Deque<TreeNode> que = new LinkedList<>();
		TreeNode current = root;

		while (current != null || !que.isEmpty()) {
			if (current != null) {
				que.addLast(current);
				current = current.left;
			} else {
				current = que.removeLast();
				values.add(current.val);
				current = current.right;
			}
		}
	}

	/** @return the next smallest number */
	public int next() {
		return values.get(++index);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return index + 1 < values.size();
	}
}