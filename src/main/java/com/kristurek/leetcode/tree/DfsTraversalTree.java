package com.kristurek.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.kristurek.leetcode.common.TreeNode;

public class DfsTraversalTree {

	public static List<Integer> traversePreOrder(TreeNode root) {
		List<Integer> values = new LinkedList<Integer>();
		Deque<TreeNode> queue = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {
			TreeNode tn = queue.removeLast();

			values.add(tn.val);

			if (tn.right != null)
				queue.addLast(tn.right);
			if (tn.left != null)
				queue.addLast(tn.left);
		}

		return values;
	}

	public static List<Integer> traverseInOrder(TreeNode root) {
		List<Integer> values = new LinkedList<Integer>();
		Deque<TreeNode> queue = new LinkedList<>();

		TreeNode current = root;

		while (!queue.isEmpty() || current != null) {
			if (current != null) {
				queue.addLast(current);
				current = current.left;
			} else {
				current = queue.removeLast();
				values.add(current.val);
				current = current.right;
			}
		}

		return values;
	}

	public static List<Integer> traversePostOrder(TreeNode root) {
		List<Integer> values = new LinkedList<Integer>();
		Deque<TreeNode> s1 = new LinkedList<>();
		Deque<TreeNode> s2 = new LinkedList<>();

		s1.push(root);

		while (!s1.isEmpty()) {
			TreeNode temp = s1.pop();
			s2.push(temp);

			if (temp.left != null)
				s1.push(temp.left);
			if (temp.right != null)
				s1.push(temp.right);
		}

		while (!s2.isEmpty()) {
			TreeNode temp = s2.pop();
			values.add(temp.val);
		}

		return values;
	}

}
