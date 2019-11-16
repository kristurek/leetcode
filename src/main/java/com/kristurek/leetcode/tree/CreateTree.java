package com.kristurek.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.TreeNode;

public class CreateTree {

	public TreeNode _108_sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		return _108_sortedArrayToBST_Recursive(nums, 0, nums.length - 1);
	}

	private TreeNode _108_sortedArrayToBST_Recursive(int[] nums, int l, int r) {
		if (l > r)
			return null;

		int m = l + (r - l) / 2;
		TreeNode tn = new TreeNode(nums[m]);

		tn.left = _108_sortedArrayToBST_Recursive(nums, l, m - 1);
		tn.right = _108_sortedArrayToBST_Recursive(nums, m + 1, r);

		return tn;
	}

	public TreeNode _109_sortedListToBST(ListNode head) {
		ListNode current = head;

		int size = 0;
		while (current != null) {
			current = current.next;
			size++;
		}
		this.head = head;
		return _109_sortedListToBST_Recursive(1, size);
	}

	private ListNode head;

	private TreeNode _109_sortedListToBST_Recursive(int l, int r) {
		// Invalid case
		if (l > r) {
			return null;
		}

		int mid = (l + r) / 2;

		// First step of simulated inorder traversal. Recursively form
		// the left half
		TreeNode left = this._109_sortedListToBST_Recursive(l, mid - 1);

		// Once left half is traversed, process the current node
		TreeNode node = new TreeNode(head.val);
		node.left = left;

		// Maintain the invariance mentioned in the algorithm
		head = head.next;

		// Recurse on the right hand side and form BST out of them
		node.right = this._109_sortedListToBST_Recursive(mid + 1, r);
		return node;
	}

	
	public static TreeNode createPreOrder(int[] nums) {
		TreeNode root = new TreeNode(nums[0]);

		Deque<TreeNode> s = new LinkedList<>();

		s.push(root);

		for (int i = 1; i < nums.length; ++i) {
			TreeNode temp = null;

			while (!s.isEmpty() && nums[i] > s.peek().val) {
				temp = s.pop();
			}

			if (temp != null) {
				temp.right = new TreeNode(nums[i]);
				s.push(temp.right);
			}

			else {
				temp = s.peek();
				temp.left = new TreeNode(nums[i]);
				s.push(temp.left);
			}
		}

		return root;

	}

}
