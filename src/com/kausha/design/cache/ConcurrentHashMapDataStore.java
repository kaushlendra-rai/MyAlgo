package com.kausha.design.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapDataStore<K, V> implements DataStore<K, V> {

	final ConcurrentMap<K, V> data = new ConcurrentHashMap<>();
	
	@Override
	public void put(K key, V value) {
		data.put(key, value);
	}

	@Override
	public V get(K key) {
		return data.get(key);
	}

	@Override
	public void delete(K key) {
		data.remove(key);
	}

}
