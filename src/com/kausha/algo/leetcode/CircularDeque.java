package com.kausha.algo.leetcode;

// https://leetcode.com/problems/design-circular-deque/
// Design your implementation of the circular double-ended queue (deque).
public class CircularDeque {

	public static void main(String[] args) {
		MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
		System.out.println(circularDeque.insertLast(1));			// return true
		System.out.println(circularDeque.insertLast(2));			// return true
		System.out.println(circularDeque.insertFront(3));			// return true
		System.out.println(circularDeque.insertFront(4));			// return false, the queue is full
		System.out.println(circularDeque.getRear());  			// return 2
		System.out.println(circularDeque.isFull());				// return true
		System.out.println(circularDeque.deleteLast());			// return true
		System.out.println(circularDeque.insertFront(4));			// return true
		System.out.println(circularDeque.getFront());			// return 4

	}
}

class MyCircularDeque {
	int size;
	int head;
	int tail;
	int currSize;
	int[] buffer;
	
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
    	size = k;
    	buffer = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
    	if(currSize == size) // return -1 if the buffer is full;
        	return false;
        
    	tail = tail-1;
        if (tail < 0)
    		tail = size-1;
        buffer[tail] = value;
        currSize++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if(currSize == size) // return -1 if the buffer is full;
        	return false;
        
    	buffer[head] = value;
        head = (head+1)%size;
        currSize++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(currSize == 0)
        	return false;

        // Perform the operation to remove the element from tail.
        tail = (tail+1)%size;
        currSize--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if(currSize == 0)
        	return false;
    	
    	head = head-1;
        if (head < 0)
    		head = size-1;
        currSize--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
    	if (currSize == 0)
    		return -1;
    	return buffer[tail];   
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    	if (currSize == 0)
    		return -1;
    	int rearLoc = head-1;
    	if (rearLoc < 0)
    		rearLoc = size-1;
    	return buffer[rearLoc];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
    	if (currSize == 0)
        	return true;
        else
        	return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
    	if (currSize == size)
        	return true;
        else
        	return false;
    }
}