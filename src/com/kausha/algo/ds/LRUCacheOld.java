package com.kausha.algo.ds;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LRUCacheOld<K, V> {

	private ConcurrentMap<K, DataNode> cache = new ConcurrentHashMap<K, DataNode>();
	
	//Circular Linked List
	private DataNode<K, V> topNode;
	
	public LRUCacheOld(int maxCache){
		maxCacheSize = maxCache;
	}
	int maxCacheSize = 100;
	
	public void put(K key, V value) {
		//Check if the value already exists.
		if(cache.get(key) != null) {
			updateValue(key, value);
		}else {
			addNewValue(key, value);
		}
	}

	private void updateValue(K key, V value) {
		//Delete current node and then add the value
		delete(key);
		addNode(key, value);
	}

	private void addNewValue(K key, V value) {
		if(cache.size() >= maxCacheSize) {
			// First delete one node that is Least Recently Used and then add the node to cache
			delete(topNode.prev.key);
		}
		// Add directly to cache
		addNode(key, value);
	}
	
	private void addNode(K key, V value) {
		DataNode<K, V> node = new DataNode<K, V>();
		node.key = key;
		node.value = value;
		addRelation(node);
		cache.put(key, node);
	}
	
	public boolean delete(K key) {
		DataNode<K, V> node = cache.get(key); 
		if(node != null) {
			deleteRelation(node);
			cache.remove(key);
			
			return true;
		}else
			return false;
	}
	
	public V get(K key) {
		DataNode<K, V> node = cache.get(key);
		if(node != null) {
			deleteRelation(node);
			addRelation(node);
			
			return node.value;
		}
		
		return null;
	}
	
	private void deleteRelation(DataNode<K, V> node) {
		if(cache.size() == 1)
			topNode = null;
		else if(topNode.key == node.key) {
			DataNode<K, V> prev = topNode.prev; 
			topNode = topNode.next;
			topNode.prev = prev;
		}else {
			DataNode<K, V> next = node.next;
			node.next.prev = node.prev;
			node.prev.next = next;
		}
	}
	
	private void addRelation(DataNode<K, V> node) {
		// Maintain Relations in Circular DLL for new node.
		if(topNode == null) {
			topNode = node;
			topNode.prev = topNode;
			topNode.next = topNode;
		}else {
			DataNode<K, V> lastNode = topNode.prev;
			topNode.prev = node;
			node.next = topNode;
			
			lastNode.next = node;
			node.prev = lastNode;
		}
		
		topNode = node;
	}
}

class DataNode<K, V>{
	DataNode<K, V> next;
	DataNode<K, V> prev;
	K key;
	V value;
}
