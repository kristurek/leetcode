package com.kristurek.leetcode.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class HashTableTest {

    @Test
    void hashTable() {
	HashTable ht = new HashTable();

	ht.put(1, 1);
	ht.put(129, 2);
	assertEquals(1, ht.get(1));
	assertEquals(2, ht.get(129));
	assertEquals(2, ht.remove(129));
	assertThrows(IllegalArgumentException.class, () -> {
	    ht.remove(129);
	});
	assertThrows(IllegalArgumentException.class, () -> {
	    ht.remove(109);
	});
    }
}
