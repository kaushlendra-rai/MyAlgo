package com.kausha.design.cache;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

	// Use DLL for LRU cache implementation.
	
	@Override
	public void accessedKey(K key) {
		
	}

	@Override
	public K evictKey() throws Exception {
		return null;
	}

	@Override
	public void delete(K key) {
		
	}

}
