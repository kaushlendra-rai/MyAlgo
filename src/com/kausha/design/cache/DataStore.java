package com.kausha.design.cache;

public interface DataStore<K, V> {
	void put(K key, V value);
	V get(K key);
	void delete(K key);
}
