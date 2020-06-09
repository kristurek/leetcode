package com.kristurek.leetcode.common;

import java.util.List;

public class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;

	public Employee(int id, int importance, List<Integer> subordinates) {
		super();
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}

}
