package com.kristurek.leetcode.common;

public class Node2 {
    public int val;
    public Node2 next;
    public Node2 random;

    public Node2(int val) {
	this.val = val;
	this.next = null;
	this.random = null;
    }

    @Override
    public String toString() {
	return "Node2 [val=" + val + ", next=" + next + ", random=" + random + "]";
    }

}
