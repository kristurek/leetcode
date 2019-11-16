package com.kristurek.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionBacktracking {

	public List<List<Integer>> _77_combine(int n, int k) {
		int[] nums = IntStream.range(1, n + 1).toArray();

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		_77_combine_backtracking(results, new ArrayList<Integer>(), k, nums, 0);

		return results;
	}

	private void _77_combine_backtracking(List<List<Integer>> results, ArrayList<Integer> tmp, int k, int[] nums,
			int from) {
		if (tmp.size() == k)
			results.add(new ArrayList<>(tmp));
		else {
			for (int i = from; i < nums.length; i++) {
				if (tmp.contains(nums[i]))
					continue;

				tmp.add(nums[i]);
				_77_combine_backtracking(results, tmp, k, nums, i);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> _78_subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		_78_subsets_backtracking(results, new ArrayList<Integer>(), 0, nums);

		return results;
	}

	private void _78_subsets_backtracking(List<List<Integer>> results, List<Integer> tmpResult, int from, int[] nums) {
		results.add(new ArrayList<>(tmpResult));

		for (int i = from; i < nums.length; i++) {
			tmpResult.add(nums[i]);
			_78_subsets_backtracking(results, tmpResult, i + 1, nums);
			tmpResult.remove(tmpResult.size() - 1);
		}
	}

	public List<List<Integer>> _90_subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();

		Arrays.sort(nums);

		_90_subsetsWithDup_backtracking(results, new ArrayList<Integer>(), 0, nums);

		return results;
	}

	private void _90_subsetsWithDup_backtracking(List<List<Integer>> results, List<Integer> tmpResult, int from,
			int[] nums) {
		results.add(new ArrayList<>(tmpResult));

		for (int i = from; i < nums.length; i++) {
			if (i > from && nums[i] == nums[i - 1])
				continue;

			tmpResult.add(nums[i]);
			_90_subsetsWithDup_backtracking(results, tmpResult, i + 1, nums);
			tmpResult.remove(tmpResult.size() - 1);
		}
	}

	public List<List<Integer>> _46_permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		_46_permute_backtracking(results, new ArrayList<>(), nums);

		return results;
	}

	private void _46_permute_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums) {
		if (tmpList.size() == nums.length)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (tmpList.contains(nums[i]))
					continue;

				tmpList.add(nums[i]);
				_46_permute_backtracking(results, tmpList, nums);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public List<List<Integer>> _47_permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		Arrays.sort(nums);

		_47_permuteUnique_backtracking(results, new ArrayList<>(), nums, new boolean[nums.length]);

		return results;
	}

	private void _47_permuteUnique_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums,
			boolean[] used) {
		if (tmpList.size() == nums.length)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]))
					continue;

				tmpList.add(nums[i]);
				used[i] = true;
				_47_permuteUnique_backtracking(results, tmpList, nums, used);
				tmpList.remove(tmpList.size() - 1);
				used[i] = false;
			}
		}
	}

	public List<List<Integer>> _39_combinationSum(int[] candidates, int target) {

		List<List<Integer>> results = new ArrayList<List<Integer>>();

		_39_combinationSum_backtracking(results, new ArrayList<>(), candidates, target, 0);

		return results;
	}

	private void _39_combinationSum_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums,
			int remained, int from) {
		if (remained < 0)
			return;
		else if (remained == 0)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = from; i < nums.length; i++) {
				tmpList.add(nums[i]);
				_39_combinationSum_backtracking(results, tmpList, nums, remained - nums[i], i);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public List<List<Integer>> _40_combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();

		Arrays.sort(candidates);

		_40_combinationSum2_backtracking(results, new ArrayList<>(), candidates, target, 0);

		return results;
	}

	private void _40_combinationSum2_backtracking(List<List<Integer>> results, List<Integer> tmpList, int[] nums,
			int remained, int from) {
		if (remained < 0)
			return;
		else if (remained == 0)
			results.add(new ArrayList<>(tmpList));
		else {
			for (int i = from; i < nums.length; i++) {
				if (i > from && nums[i] == nums[i - 1])
					continue;

				tmpList.add(nums[i]);
				_40_combinationSum2_backtracking(results, tmpList, nums, remained - nums[i], i + 1);
				tmpList.remove(tmpList.size() - 1);
			}
		}
	}

	public List<List<String>> _131_partition(String s) {
		List<List<String>> list = new ArrayList<>();
		_131_partition_backtracking(list, new ArrayList<>(), s, 0);
		return list;
	}

	private void _131_partition_backtracking(List<List<String>> list, List<String> tempList, String s, int start) {
		if (start == s.length())
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < s.length(); i++) {
				if (_131_partition_isPalindrome(s, start, i)) {
					tempList.add(s.substring(start, i + 1));
					_131_partition_backtracking(list, tempList, s, i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

	private boolean _131_partition_isPalindrome(String s, int low, int high) {
		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}

	public String _60_getPermutation(int n, int k) {
		int[] nums = IntStream.range(1, n + 1).toArray();
		List<List<Integer>> results = new ArrayList<>();

		_60_getPermutation_Backtracking(results, new ArrayList<>(), nums);

		return results.get(k - 1).stream().map(p -> String.valueOf(p)).collect(Collectors.joining());
	}

	private void _60_getPermutation_Backtracking(List<List<Integer>> results, List<Integer> tmp, int[] nums) {
		if (tmp.size() == nums.length) {
			results.add(new ArrayList<>(tmp));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tmp.contains(nums[i]))
					continue;

				tmp.add(nums[i]);
				_60_getPermutation_Backtracking(results, tmp, nums);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

}
