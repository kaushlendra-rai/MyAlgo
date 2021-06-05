package com.kausha.algo.leetcode;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// https://leetcode.com/problems/lru-cache/
public class LRUCacheImpl {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(1, 8);
		System.out.println(cache.get(1));
		//System.out.println(cache.get(2));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		
//		cache.put(1, 0);
//		cache.put(2, 2);
//		System.out.println(cache.get(1));
//		cache.put(3, 3);
//		System.out.println(cache.get(2));
//		cache.put(4, 4);
//		System.out.println(cache.get(1));
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(4));
	}

}

class LRUCache {
	int capacity = 0;
	ConcurrentMap<Integer, CacheNode> cache = new ConcurrentHashMap<>();
	CacheNode top ;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	//System.out.println("GET key: " + key);
    	CacheNode node = cache.get(key);
    	if(node != null) {
    		// Put the recent accessed node at the top.
    		removeNodeFromDLL(node);
    		//System.out.println("GET top: " + top.val + " , top.next.val: " + top.next.val);
    		putNodeOnTop(node);
    		//System.out.println("GET22 top: " + top.val + " , top.next.val: " + top.next.val);
    		return node.val;
    	}
    	
        return -1;
    }
    
    public void put(int key, int value) {
    	//System.out.println("PUT cache.size: " + cache.size() + ", key: " + key + " , value: " + value);
    	CacheNode node = cache.get(key);
    	if(node != null) { // Update
    		node.val = value;
    		removeNodeFromDLL(node);
    		putNodeOnTop(node);
    	}else {// Add for first time
    		// The cache is full, evict the Least recently used node.
    		if(cache.size() >= capacity) {
    			//System.out.println("Cache overflow. top: " + top.val + " , delete: " + top.prev.val + " cache.size: " + cache.size());
    			// Remove the LRU node;
    			cache.remove(top.prev.key);
    			removeNodeFromDLL(top.prev);
    		}
    		node = new CacheNode(key, value);
			node.prev = node;
			node.next = node;
			cache.put(key, node);
    		if(top == null) { // If first element in the cache.
    			top = node;
    		}else {
    			putNodeOnTop(node);
    		}
    	}
    }
    
    private void removeNodeFromDLL(CacheNode node) {
		CacheNode temp = node.prev;
		temp.next = node.next;
		node.next.prev = temp;
		
		if(node.val == top.val)
			top = temp.next;
	}

	private CacheNode putNodeOnTop(CacheNode node) {
		//System.out.println("@@@@@ cache.size: " + cache.size() + ", node.val: " + node.val + ", top.val: " + top.val + ", top.prev.val: " + top.prev.val);
		CacheNode last = top.prev;
    	node.next = top;
    	node.prev = last;
    	
    	top.prev = node;
    	last.next = node;
    	
    	// Now top points to the newly added node.
    	top = node;
    	//System.out.println("******  top.val: " + top.val + " , top.next.val=" + top.next.val);
    	return node;
    }
}

class CacheNode{
	public CacheNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
	CacheNode prev;
	CacheNode next;
	int val;
	int key;
}