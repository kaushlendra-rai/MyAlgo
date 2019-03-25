package com.kausha.algo.ds;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LRUCacheNew <K, V>{
	public static void main(String[] args) {
	}
	
	CacheNode<K, V> latestNode;
	ConcurrentMap<K, CacheNode<K, V>> cache = new ConcurrentHashMap<K, CacheNode<K, V>>();
	int size;
	public LRUCacheNew(int size) {
		this.size = size;
	}
	
	public void add(K key, V value){
		if(key == null)
			throw new RuntimeException("key is null.");
		if(cache.containsKey(key)){
			// Update an existing value
			CacheNode<K, V> node = cache.get(key);
			deletedNodeRelations(node);
			addNodeRelations(node);
		}if(cache.size() < size){
			// Add new element to the cache
			addNewNode(key, value);
		}else{
			// Eviction Policy needs to be used
			// Find & delete the Least Recently Used node
			if(latestNode != null){
				CacheNode<K, V> deleteNode = latestNode.prev;
				deletedNodeRelations(deleteNode);
				cache.remove(deleteNode.key);
			}
			
			// Add new element to the cache
			addNewNode(key, value);
		}
	}

	private void addNewNode(K key, V value) {
		CacheNode<K, V> node = new CacheNode<K, V>(key, value);
		
		addNodeRelations(node);
		
		cache.put(key, node);
	}

	private void addNodeRelations(CacheNode<K, V> node){
		if(latestNode != null){
			//Node needs to be added at the top of the List
			CacheNode<K, V> temp = latestNode.prev;
			latestNode.prev = node;
			node.next = latestNode;
			node.prev = temp;
			latestNode = node;
		}else{
			latestNode = node;
		}
	}
	
	public V get(K key){
		CacheNode<K, V> node = cache.get(key);
		
		if(node != null){
			// Move the current node to latest
			deletedNodeRelations(node);
			addNodeRelations(node);
		}
		
		return node == null ? null : node.value;
	}
	
	public void delete(K key){
		CacheNode<K, V> node = cache.get(key);
		if(node != null){
			deletedNodeRelations(node);
			cache.remove(node.key);
		}
	}
	
	private void deletedNodeRelations(CacheNode<K, V> node) {
		if(node != null){
			// Remove the relation
			CacheNode<K, V> temp = node.prev;
			node.prev.prev = node.next;
			node.next = temp;
		}
	}
	
	private class CacheNode<X, Y>{
		X key;
		Y value;
		CacheNode<X, Y> prev;
		CacheNode<X, Y> next;
		
		public CacheNode(X key, Y value){
			this.key = key;
			this.value = value;
			
			prev = this;
			next = this;
		}
	}
}