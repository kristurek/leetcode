package com.kristurek.leetcode.common;

public class Node3 {
    public int val;
    public Node3 left;
    public Node3 right;
    public Node3 next;

    public Node3() {
    }

    public Node3(int _val) {
	val = _val;
    }

    public Node3(int _val, Node3 _left, Node3 _right, Node3 _next) {
	val = _val;
	left = _left;
	right = _right;
	next = _next;
    }

    @Override
    public String toString() {
	return "Node3 [val=" + val + ", left=" + left + ", right=" + right + ", next=" + next + "]";
    }

}