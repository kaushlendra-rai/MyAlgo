package com.kausha.algo.ds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> {
	private Map<K, Node<K, V>> cache = new ConcurrentHashMap<K, Node<K, V>>();
	private Node<K, V> topNode;
	private int size;
	
	public LRUCache(int size){
		this.size = size;
	}
	
	public void put(K key, V value){
		// Check if the key already exists in the cache
		Node<K, V> node = cache.get(key);
		
		// New value to be added
		if(node == null){
			if(cache.size() >= size){
				// Remove the last node
				remove(topNode.prev.key);
			}
			
			// Add a new node
			node = new Node<K, V>(key, value);
			addNode(node);
		}else{
			// Update the existing value. Remove the existing node
			remove(key);
			// Assign new updated value to the node & update cache
			node.value = value;
			addNode(node);
		}
	}
	
	private void addNode(Node<K, V> node) {
		// Check if the current node is the first node in the cache. If yes, do the needful
		if(topNode == null){
			topNode = node;
			node.prev = node;
			node.next = node;
		}else{
			// We only need to add the node to the top
			node.prev = topNode.prev;
			node.next = topNode;
			topNode.prev = node;
				
			// Re-assign the top node as the recently added new node
			topNode = node;
		}
		
		// Add to cache
		cache.put(node.key, node);
	}

	public void remove(K key){
		Node<K, V> node = cache.get(key);
		
		if(node != null){
			if(node == topNode)
				topNode = topNode.next;
			
			// Remove the node from it's existing location
			node.prev.next = node.next;
			node.next.prev = node.prev;
			
			cache.remove(key);
		}
	}
	
	public V get(K key){
		Node<K, V> node = cache.get(key);
		V value = null;
		
		if(node != null){
			value = node.value;
			remove(key);
			addNode(node);
		}
		
		return value;
	}
	
	/**
	 * It is a double linked list
	 * @author sinkar
	 *
	 * @param <K> Key for the Map
	 * @param <V> value of the cache
	 */
	private class Node<K, V>{
		private Node<K, V> prev;
		private Node<K, V> next;
		
		private K key;
		private V value;
		
		Node(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
}