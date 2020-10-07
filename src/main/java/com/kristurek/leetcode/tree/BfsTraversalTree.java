package com.kristurek.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.kristurek.leetcode.common.TreeNode;

//Breadth-first search, BFS
public class BfsTraversalTree {

    public static List<Integer> traverseIterative(TreeNode root) {
	if (root == null)
	    return new LinkedList<Integer>();

	Deque<TreeNode> queue = new LinkedList<>();
	List<Integer> values = new LinkedList<>();

	queue.add(root);

	while (!queue.isEmpty()) {
	    TreeNode tn = queue.poll();

	    values.add(tn.val);

	    if (tn.left != null)
		queue.add(tn.left);
	    if (tn.right != null)
		queue.add(tn.right);

	}

	return values;
    }

    public static List<Integer> traverseRecursive(TreeNode root) {
	Deque<TreeNode> queue = new LinkedList<>();
	List<Integer> values = new LinkedList<>();

	queue.addLast(root);
	traverseRecursive(queue, values);

	return values;
    }

    private static void traverseRecursive(Deque<TreeNode> queue, List<Integer> values) {
	if (!queue.isEmpty()) {
	    TreeNode tn = queue.removeFirst();
	    values.add(tn.val);

	    if (tn.left != null)
		queue.addLast(tn.left);
	    if (tn.right != null)
		queue.addLast(tn.right);

	    traverseRecursive(queue, values);
	}
    }
}
