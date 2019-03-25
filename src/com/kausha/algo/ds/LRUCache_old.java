package com.kausha.algo.ds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LRU cache with O(1) operations for add/remove/get operations.
 * @author sinkar
 *
 * @param <K>
 * @param <V>
 */
public class LRUCache_old<K, V> {
	private Map<K, Node<K, V>> cache = new ConcurrentHashMap<K, Node<K, V>>();
	private Node<K, V> lastNode;
	private Node<K, V> topNode;
	
	private int size;
	
	public LRUCache_old(int size){
		this.size = size;
	}
	
	/**
	 * Add an element to the cache
	 * @param key
	 * @param value
	 */
	public synchronized boolean put(K key, V value){
		boolean status = false;
		
		if(key != null){
			Node<K, V> node = new Node<K, V>(key, value);
			
			if(lastNode == null){
				// First node in cache
				cache.put(key, node);
				
				// The new Node is the last node
				lastNode = node;
				topNode = node;
			}else{// lastNode already exists.
				
				// Check if the node already exists
				if(cache.containsKey(key)){
					//Remove the object from the current position and put the NEW node as the topNode
					Node<K, V> oldNode = cache.get(key);
					
					if(oldNode == topNode){
						node.next = oldNode.next;
						topNode = node;
					}else if(oldNode == lastNode){
						lastNode = lastNode.prev;
						
						// Put the New node on top
						node.next = topNode;
						topNode.prev = node;
						
						// Re-assign the top node as the recently added new node
						topNode = node;
					}else if(topNode == lastNode){
						topNode = node;
						lastNode = node;
					}else{
						// Remove the current node from the list
						if(oldNode.prev != null)
							oldNode.prev.next = oldNode.next;
						
						// Put the New node on top
						node.next = topNode;
						topNode.prev = node;
						
						// Re-assign the top node as the recently added new node
						topNode = node;
					}
				}else if(cache.size() < size){ // Check if the cache has reached it's size.
					// Still elements can be added without eviction of other elements
					// And it is a new element to the cache
					// Put the New node on top
					node.next = topNode;
					topNode.prev = node;
					
					// Re-assign the top node as the recently added new node
					topNode = node;
					
				}else{// Cache has reached it's limit.
					// First remove the Last Node.
					Node<K, V> removeNode = lastNode;
					lastNode = lastNode.prev;
					
					// Remove data of removeNode
					cache.remove(removeNode.key);
					
					// Put the New node on top
					node.next = topNode;
					topNode.prev = node;
					
					// Re-assign the top node as the recently added new node
					topNode = node;
				}
				
				cache.put(key, node);
			}
		}
		
		return status;
	}
	
	/**
	 * Getting a value from the cache alters the sequence of the node in the internal double linked list.
	 * It puts the accessed node on the top
	 * @param key Key for the cached object
	 * @return
	 */
	public synchronized V get(K key){
		
		Node<K, V> node = cache.get(key);
		
		if(node != null){
			if(node == topNode){
				// Make no change anywhere
			}else if(node == lastNode){
				// remove the last node
				lastNode = lastNode.prev;
				
				// Put the New node on top
				node.next = topNode;
				topNode.prev = node;
				
				// Re-assign the top node as the recently added new node
				topNode = node;
			}else{
				//Remove the object from the current position and put the node as the topNode
				node.prev.next = node.next;
				
				// Put the New node on top
				node.next = topNode;
				topNode.prev = node;
				
				// Re-assign the top node as the recently added new node
				topNode = node;
			}
			
			return node.value;
		}
		
		return null;
	}
	
	public synchronized void remove(K key){
		Node<K, V> node = cache.get(key);
		
		if(node != null){
			if(node == topNode){
				topNode = topNode.next;
			}else if(node == lastNode){
				lastNode = lastNode.prev;
			}else if(topNode == lastNode){// If it is the only node in cache
				topNode = null;
				lastNode = null;
			}else{
				node.prev.next = node.next;
			}
			
			// remove the associated data
			cache.remove(key);
		}
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