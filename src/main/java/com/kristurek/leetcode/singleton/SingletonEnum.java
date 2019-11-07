package com.kristurek.leetcode.singleton;

public enum SingletonEnum {
	INSTANCE;

	int value;

	int getValue() {
		return value;
	}

	void setValue(int val) {
		value = val;
	}

}
