package com.kristurek.leetcode.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import com.kristurek.leetcode.common.ListNode;
import com.kristurek.leetcode.common.TreeNode;

public class Solution {

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums)
			if (set.contains(num))
				set.remove(num);
			else
				set.add(num);

		return set.stream().findAny().orElseThrow();
	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();

		while (!set.contains(n)) {
			set.add(n);

			int sumOfSquare = 0;
			while (n > 0) {
				int remain = n % 10;
				sumOfSquare += remain * remain;

				n = n / 10;
			}

			if (sumOfSquare == 1)
				return true;

			n = sumOfSquare;
		}

		return false;
	}

	public int maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (sum < 0)
				sum = nums[i];
			else
				sum += nums[i];

			if (sum > max)
				max = sum;
		}

		return max;
	}

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int slow = 0;
		for (int num : nums)
			if (num != 0)
				nums[slow++] = num;

		while (slow < nums.length)
			nums[slow++] = 0;

	}

	public int maxProfit(int[] prices) {
		if (prices == null)
			return 0;

		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++)
			if (prices[i] > prices[i - 1])
				maxProfit += prices[i] - prices[i - 1];

		return maxProfit;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<>();

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] charArray = str.toCharArray();

			Arrays.sort(charArray);

			String key = String.valueOf(charArray);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());

			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}

	public int countElements(int[] arr) {
		if (arr == null)
			return 0;

		int count = 0;

		Set<Integer> set = new HashSet<>();
		for (int num : arr)
			set.add(num);

		for (int num : arr)
			if (set.contains(num + 1))
				count++;

		return count;
	}

	public ListNode middleNode(ListNode head) {
		int size = 1;

		ListNode current = head;
		while (current.next != null) {
			size++;
			current = current.next;
		}

		current = head;
		int max = Math.round(size / 2);
		int i = 1;
		while (i++ <= max) {
			current = current.next;
		}

		return current;
	}

	public boolean backspaceCompare(String S, String T) {
		return backspaceCompare_build(S).equals(backspaceCompare_build(T));
	}

	private String backspaceCompare_build(String t) {
		Deque<Character> stack = new LinkedList<>();

		for (char character : t.toCharArray()) {
			if (character != '#')
				stack.push(character);
			else if (!stack.isEmpty())
				stack.pop();
		}

		return stack.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
	}

	public MinStack minStack() {
		return new MinStack();
	}

	public class MinStack {

		private int min = Integer.MAX_VALUE;
		private Stack<Integer> stack = new Stack<Integer>();

		public void push(int x) {
			// only push the old minimum value when the current
			// minimum value changes after pushing the new value x
			if (x <= min) {
				stack.push(min);
				min = x;
			}
			stack.push(x);
		}

		public void pop() {
			// if pop operation could result in the changing of the current minimum value,
			// pop twice and change the current minimum value to the last minimum value.
			if (stack.pop() == min)
				min = stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return min;
		}
	}

	public int diameterOfBinaryTree(TreeNode root) {
		return -1;
	}

	public int lastStoneWeight(int[] stones) {
		return -1;
	}

	public int findMaxLength(int[] nums) {
		return -1;
	}

	public String stringShift(String s, int[][] shifts) {
//		int cShifts = 0;
//
//		for (int[] shift : shifts)
//			if (shift[0] == 0)
//				cShifts -= shift[1];
//			else
//				cShifts += shift[1];

		int sumOfShifts = Arrays.stream(shifts).map(shift -> shift[0] == 0 ? -shift[1] : shift[1]).mapToInt(Integer::valueOf).sum() % s.length();

		return (s + s + s).substring(s.length() - sumOfShifts, s.length() - sumOfShifts + s.length());

//		if (cShifts < 0)
//			return (s + s + s).substring(s.length() - cShifts, s.length() - cShifts + s.length());// left shift so move forward
//		else if (cShifts > 0)
//			return (s + s + s).substring(s.length() - cShifts, s.length() - cShifts + s.length());// right shift so move backward
//		else
//			return s;
	}

	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		Arrays.fill(res, 1);

		int right = 1, left = 1;

		for (int i = 0; i < nums.length; i++) {
			res[i] *= left;
			left *= nums[i];
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}

		return res;
	}

	public boolean checkValidString(String s) {
		int length = s.length() - 1;
		int openCount = 0, closedCount = 0;

		for (int i = 0; i <= length; i++) {
			if (s.charAt(i) == '*' || s.charAt(i) == '(')
				openCount++;
			else
				openCount--;

			if (s.charAt(length - i) == '*' || s.charAt(length - i) == ')')
				closedCount++;
			else
				closedCount--;

			if (openCount < 0 || closedCount < 0)
				return false;
		}

		return true;
	}

	public int numIslands(char[][] matrix) {
		int count = 0;

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1')
					count++;
				search_island(matrix, i, j);
			}

		return count;
	}

	private void search_island(char[][] matrix, int i, int j) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] == '1') {
			matrix[i][j] = '0';

			search_island(matrix, i + 1, j);
			search_island(matrix, i - 1, j);
			search_island(matrix, i, j + 1);
			search_island(matrix, i, j - 1);
		}
	}

	public int minPathSum(int[][] grid) {
		int width = grid[0].length;
		int[] dist = new int[width];

		for (int i = 1; i < width; i++)
			dist[i] = Integer.MAX_VALUE;

		for (int[] row : grid) {
			for (int i = 0; i < width; i++) {
				if (i == 0)
					dist[i] = dist[i] + row[i];
				else
					dist[i] = row[i] + Math.min(dist[i], dist[i - 1]);
			}
		}
		return dist[width - 1];
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int l = 0;
		int r = nums.length - 1;

		while (l < r) {
			int m = l + (r - l) / 2;
			if (nums[m] > nums[r]) {
				l = m + 1;
			} else {
				r = m;
			}
		}

		int s = l;
		l = 0;
		r = nums.length - 1;
		if (target >= nums[s] && target <= nums[r])
			l = s;
		else
			r = s;

		while (l <= r) {
			int m = l + (r - l) / 2;
			if (nums[m] == target)
				return m;
			else if (nums[m] > target)
				r = m - 1;
			else
				l = m + 1;
		}

		return -1;
	}

	public TreeNode bstFromPreorder(int[] nums) {
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

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int lengthRow = dimensions.get(0);
		int lengthCol = dimensions.get(1);

		Set<Integer> set = new HashSet<>();

		for (int row = 0; row < lengthRow; row++) {
			int l = 0;
			int r = lengthCol - 1;

			while (l <= r) {
				int m = l + (r - l) / 2;
				int mVal = binaryMatrix.get(row, m);
				if (1 > mVal)
					l = m + 1;
				else if (1 < mVal)
					r = m - 1;
				else {
					if (m == 0 || binaryMatrix.get(row, m - 1) != 1) {
						set.add(m);
                        break;
                    } else
						r = m - 1;
				}
			}
		}

		return set.stream().min((v1, v2) -> v1 - v2).orElse(-1);
	}
	
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        
        map.put(0, 1);
        
        for(int num : nums) {
            sum += num;
            
            if(map.containsKey(sum - k))
                result += map.get(sum - k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return result; 
    }
}

interface BinaryMatrix {
	int get(int x, int y);

	List<Integer> dimensions();
}
