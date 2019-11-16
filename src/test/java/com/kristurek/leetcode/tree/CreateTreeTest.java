package com.kristurek.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.TreeNode;

public class CreateTreeTest {

	private CreateTree solution = new CreateTree();
	
	@Test
	void _108_sortedArrayToBST() {
		TreeNode root = solution._108_sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		assertEquals(0, root.val);
		assertEquals(-10, root.left.val);
		assertEquals(5, root.right.val);
		assertEquals(-3, root.left.right.val);
		assertEquals(9, root.right.right.val);
	}

	@Test
	void _109_sortedListToBST() {
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);

		TreeNode root = solution._109_sortedListToBST(head);
		assertEquals(0, root.val);
		assertEquals(-10, root.left.val);
		assertEquals(5, root.right.val);
		assertEquals(-3, root.left.right.val);
		assertEquals(9, root.right.right.val);
	}

	
	@Test
	void createPreOrder() {
		TreeNode root = CreateTree.createPreOrder(IntStream.of(10, 5, 1, 7, 40, 50).toArray());

		assertEquals(10, root.val);

		assertEquals(5, root.left.val);
		assertEquals(40, root.right.val);

		assertEquals(1, root.left.left.val);
		assertEquals(7, root.left.right.val);

		assertEquals(50, root.right.right.val);
	}
	
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

}
