package com.kausha.design.cache;

public interface EvictionPolicy<K> {
	void accessedKey(K key);
	// If the cache is full, any addition of new record would add a new entry and 
	// return the record to be evicted from cache.
	K evictKey() throws Exception;
	void delete(K key);
}
