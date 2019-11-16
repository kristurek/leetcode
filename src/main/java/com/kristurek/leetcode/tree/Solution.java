package com.kristurek.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.TreeNode;

public class Solution {

	public List<Integer> _94_inorderTraversal(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();

		TreeNode current = root;

		while (!queue.isEmpty() || current != null) {
			if (current != null) {
				queue.addLast(current);
				current = current.left;
			} else {
				current = queue.removeLast();
				results.add(current.val);
				current = current.right;
			}
		}

		return results;
	}

	public boolean _98_isValidBST(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();

		TreeNode current = root;
		TreeNode previous = null;

		while (!queue.isEmpty() || current != null) {
			if (current != null) {
				queue.addLast(current);
				current = current.left;
			} else {
				current = queue.removeLast();

				if (previous != null && current.val <= previous.val)
					return false;
				previous = current;

				results.add(current.val);
				current = current.right;
			}
		}

		return true;
	}

	public boolean _100_isSameTree(TreeNode p, TreeNode q) {
		Deque<TreeNode> queue1 = new LinkedList<>();
		Deque<TreeNode> queue2 = new LinkedList<>();

		queue1.addLast(p);
		queue2.addLast(q);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode tn1 = queue1.removeFirst();
			TreeNode tn2 = queue2.removeFirst();

			if (tn1.left != null && tn2.left == null)
				return false;
			if (tn1.left == null && tn2.left != null)
				return false;
			if (tn1.right != null && tn2.right == null)
				return false;
			if (tn1.right == null && tn2.right != null)
				return false;
			if (tn1.val != tn2.val)
				return false;

			if (tn1.left != null)
				queue1.addLast(tn1.left);
			if (tn1.right != null)
				queue1.addLast(tn1.right);

			if (tn2.left != null)
				queue2.addLast(tn2.left);
			if (tn2.right != null)
				queue2.addLast(tn2.right);
		}

		return queue1.isEmpty() && queue2.isEmpty();
	}

	public boolean _101_isSymmetric(TreeNode root) {
		Deque<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode t1 = q.removeFirst();
			TreeNode t2 = q.removeFirst();

			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;

			q.addLast(t1.left);
			q.addLast(t2.right);
			q.addLast(t1.right);
			q.addLast(t2.left);
		}
		return true;
	}

	private boolean _101_isSymmetric_mirror(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;
		if (left.val != right.val)
			return false;

		return _101_isSymmetric_mirror(left.left, right.right) && _101_isSymmetric_mirror(left.right, right.left);
	}

	public List<List<Integer>> _102_levelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();

		List<List<Integer>> results = new ArrayList<>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> result = new ArrayList<Integer>();
			while (size-- > 0) {
				TreeNode tn = queue.removeFirst();

				result.add(tn.val);

				if (tn.left != null)
					queue.addLast(tn.left);
				if (tn.right != null)
					queue.addLast(tn.right);
			}

			results.add(result);
		}

		return results;
	}

	public List<List<Integer>> _103_zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return new ArrayList<List<Integer>>();

		List<List<Integer>> results = new ArrayList<>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 1;

		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> result = new ArrayList<Integer>();
			while (size-- > 0) {
				TreeNode tn = queue.removeFirst();

				result.add(tn.val);

				if (tn.left != null)
					queue.addLast(tn.left);
				if (tn.right != null)
					queue.addLast(tn.right);
			}

			if (level % 2 == 0)
				Collections.reverse(result);

			results.add(result);
			level++;
		}

		return results;
	}

	public int _104_maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		int level = 0;

		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode tn = queue.removeFirst();

				if (tn.left != null)
					queue.addLast(tn.left);
				if (tn.right != null)
					queue.addLast(tn.right);
			}

			level++;
		}

		return level;
	}

	public List<List<Integer>> _107_levelOrderBottom(TreeNode root) {
		if (root == null)
			return new LinkedList<>();

		List<List<Integer>> results = new ArrayList<>();
		Deque<TreeNode> queue = new LinkedList<>();

		queue.addLast(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> result = new LinkedList<Integer>();
			while (size-- > 0) {
				TreeNode tn = queue.removeFirst();

				result.add(tn.val);

				if (tn.left != null)
					queue.addLast(tn.left);
				if (tn.right != null)
					queue.addLast(tn.right);
			}

			results.add(result);

		}

		Collections.reverse(results);

		return results;
	}


	public boolean _110_isBalanced(TreeNode root) {
		if (root == null)
			return true;

		int left = _110_isBalanced_depth(root.left);
		int right = _110_isBalanced_depth(root.right);

		return Math.abs(left - right) <= 1 && _110_isBalanced(root.left) && _110_isBalanced(root.right);
	}

	private int _110_isBalanced_depth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(_110_isBalanced_depth(root.left), _110_isBalanced_depth(root.right)) + 1;
	}

	public int _111_minDepth(TreeNode root) {
		if (root == null)
			return 0;

		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);

		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode tn = queue.removeFirst();

				if (tn.left != null)
					queue.addLast(tn.left);

				if (tn.right != null)
					queue.addLast(tn.right);

				if (tn.left == null && tn.right == null)
					return level;
			}
			level++;
		}

		return level;
	}

	public boolean _112_hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		Deque<Integer> sumOfPaths = new LinkedList<Integer>();
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		Deque<TreeNode> queue2 = new LinkedList<TreeNode>();

		queue.addLast(root);
		queue2.addLast(root);
		sumOfPaths.push(root.val);

		while (!queue.isEmpty()) {
			TreeNode tn = queue.removeLast();
			Integer sumOfPath = sumOfPaths.removeLast();

			if (tn.left == null && tn.right == null && sum == sumOfPath)
				return true;
			else {
				if (tn.right != null) {
					queue.addLast(tn.right);
					sumOfPaths.addLast(sumOfPath + tn.right.val);
				}
				if (tn.left != null) {
					queue.addLast(tn.left);
					sumOfPaths.addLast(sumOfPath + tn.left.val);
				}
			}
		}

		return false;
	}

	public List<Integer> _113_pathSum(TreeNode root, int sum) {// Only first result
//		if (root == null)
//			return new ArrayList<>();
//
//		List<Integer> result = new ArrayList<Integer>();
//
//		Deque<Integer> sumOfPaths = new LinkedList<Integer>();
//		Deque<TreeNode> queue = new LinkedList<TreeNode>();
//
//		queue.addLast(root);
//		
//		sumOfPaths.push(root.val);
//
//		while (!queue.isEmpty()) {
//			TreeNode tn = queue.removeLast();
//			result.add(tn.val);
//			Integer sumOfPath = sumOfPaths.removeLast();
//
//			if (tn.left == null && tn.right == null) {
//				if (sum == sumOfPath)
//					return result;
//				result.remove(result.size() - 1); //
//			} else {
//				if (tn.right != null) {
//					queue.addLast(tn.right);
//					sumOfPaths.addLast(sumOfPath + tn.right.val);
//				}
//				if (tn.left != null) {
//					queue.addLast(tn.left);
//					sumOfPaths.addLast(sumOfPath + tn.left.val);
//				}
//			}
//		}
//
		return new ArrayList<Integer>();
	}

}
