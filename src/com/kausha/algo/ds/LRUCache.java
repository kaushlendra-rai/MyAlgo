package com.kausha.algo.ds;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LRUCache<K, V> {
	int cacheSize;
	int maxCacheSize;
	
	public LRUCache(int maxCacheSize){
		this.maxCacheSize = maxCacheSize;
	}
	// Root implemented as Circular LinkedList.
	CacheNode<K, V> root = null;
	ConcurrentMap<K, CacheNode<K, V>> cache = new ConcurrentHashMap<K, CacheNode<K, V>>();
	
	public V get(K key) {
		// Update usage sequence for access.
		CacheNode<K, V> node = cache.get(key);
		if(node != null) {
			updateUsageSequence(key, node.value);
			return node.value;
		}
		
		return null;
	}
	
	public void put(K key, V value) {
		if(cache.containsKey(key)) {
			remove(key);
		}else if(cacheSize > maxCacheSize) {
			// Remove the least recently used node and then add the new node.
			remove(root.prev.key);	
		}
		
		// update the usage sequence
		updateUsageSequence(key, value);

		// Put the value in the cache.
		CacheNode<K, V> node = new CacheNode<K, V>(key, value);
		cache.put(key, node);
	}
	
	private void updateUsageSequence(K key, V value) {
		if(root == null) {
			// First node.
			CacheNode<K, V> root = new CacheNode<K, V>(key, value);
			root.next = root;
			root.prev = root;
		}else {
			CacheNode<K,V> temp = root.prev;
			CacheNode<K, V> newNode = new CacheNode<K, V>(key, value);
			
			root.prev = newNode;
			newNode.prev = temp;
			newNode.next = root;
			temp.next = newNode;
			
			root = newNode;
		}
	}
	
	public void remove(K key) {
		// Remove node from Circular DLL
		CacheNode<K, V> node = cache.get(key);
		// Check if this is not the only node, if yes, root becomes null.
		if(node != null && node.next.key.equals(node.key))
			root = null;
		if(node != null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		
		cache.remove(key);
	}
	
	class CacheNode<K, V>{
		CacheNode<K, V> next;
		CacheNode<K, V> prev;
		public CacheNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
		K key;
		V value;
	}
}