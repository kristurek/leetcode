package com.kristurek.leetcode.hash;

public class HashTable {

	private final static int SIZE = 128;

	public class HashEntry {
		private int key;
		private int value;
		HashEntry next;

		HashEntry(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}
	}

	private HashEntry[] buckets;

	public HashTable() {
		super();
		this.buckets = new HashEntry[SIZE];
	}

	public int get(int key) {
		int hash = getHash(key);
		HashEntry he = buckets[hash];

		while (he != null) {
			if (he.key == key)
				return he.value;
			he = he.next;
		}

		return -1;
	}

	public void put(int key, int value) {
		int hash = getHash(key);
		HashEntry hashEntry = buckets[hash];

		if (hashEntry == null)
			buckets[hash] = new HashEntry(key, value);
		else {
			while (hashEntry != null) {
				if (hashEntry.key == key) {
					hashEntry.value = value;
					break;
				} else {
					if (hashEntry.next != null)
						hashEntry = hashEntry.next;
					else
						hashEntry.next = new HashEntry(key, value);
				}
			}
		}
	}

	private int getHash(int key) {
		return key % SIZE;
	}

}
