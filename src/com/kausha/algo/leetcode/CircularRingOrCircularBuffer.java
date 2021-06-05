package com.kausha.algo.leetcode;

// https://leetcode.com/problems/design-circular-queue/submissions/
public class CircularRingOrCircularBuffer {

	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		System.out.println(myCircularQueue.enQueue(1)); // return True
		System.out.println(myCircularQueue.enQueue(2)); // return True
		System.out.println(myCircularQueue.enQueue(3)); // return True
		System.out.println(myCircularQueue.enQueue(4)); // return False
		System.out.println(myCircularQueue.Rear());     // return 3
		System.out.println(myCircularQueue.isFull());   // return True
		System.out.println(myCircularQueue.deQueue());  // return True
		System.out.println(myCircularQueue.enQueue(4)); // return True
		System.out.println(myCircularQueue.Rear());     // return 4		

	}

}

class MyCircularQueue {
	int size;
	int head;
	int tail;
	int currSize;
	int[] buffer;
	
    public MyCircularQueue(int k) {
    	size = k;
    	buffer = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(currSize == size) // return -1 if the buffer is full;
        	return false;
        
        buffer[head] = value;
        head = (head+1)%size;
        currSize++;
        return true;
    }
    
    public boolean deQueue() {
        if(currSize == 0)
        	return false;

        // Perform the operation to remove the element from tail.
        tail = (tail+1)%size;
        currSize--;
        return true; 
    }
    
    public int Front() {
    	if (currSize == 0)
    		return -1;
    	return buffer[tail];
    }
    
    public int Rear() {
    	if (currSize == 0)
    		return -1;
    	int rearLoc = head-1;
    	if (rearLoc < 0)
    		rearLoc = size-1;
    	return buffer[rearLoc];
    }
    
    public boolean isEmpty() {
        if (currSize == 0)
        	return true;
        else
        	return false;
    }
    
    public boolean isFull() {
        if (currSize == size)
        	return true;
        else
        	return false;
    }
}