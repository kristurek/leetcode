package com.kristurek.leetcode.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HashTableTest {

	@Test
	void hashTable() {
		HashTable ht = new HashTable();

		ht.put(0, 0);
		ht.put(0, 1);
		assertEquals(1, ht.get(0));
	}
}
