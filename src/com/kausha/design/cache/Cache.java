package com.kausha.design.cache;

public class Cache<K, V> {
	final EvictionPolicy<K> evictionPolicy;
	final DataStore<K, V> storage;
	
	public Cache(EvictionPolicy<K> evictionPolicy, DataStore<K, V> storage) {
		this.evictionPolicy = evictionPolicy;
		this.storage = storage;
	}
	
	
}
