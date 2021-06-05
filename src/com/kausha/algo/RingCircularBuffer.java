package com.kausha.algo;

public class RingCircularBuffer<E> {

	int size;
	int count;
	int read; // From where read happens
	int write; // Last index where a readable content will exist
	E[] buffer;
	
	public static void main(String[] args) {
		RingCircularBuffer<Integer> rcb = new RingCircularBuffer<>(4);
		System.out.println(rcb.offer(1));
		System.out.println(rcb.offer(2));
		System.out.println(rcb.offer(3));
		System.out.println(rcb.offer(4));
		System.out.println(rcb.offer(5));
		System.out.println(rcb.poll());
		System.out.println(rcb.offer(5));
		System.out.println(rcb.offer(5));
	}
	
	public RingCircularBuffer(int size) {
		this.size = size;
		buffer = (E[])new Object[size];
		read = 0;
		write = 0;
	}
	
	public boolean offer(E element) {
		if(count == size) {
			System.out.println("Full");
			return false;
		}
		
		buffer[write] = element;
		write = (write + 1)%size;
		System.out.println("Write write: " + write);
		
		count++;
		return true;
	}

	public E poll() {
		// Check if buffer is empty.
		if(count == 0)
			return null;
		System.out.println("Read IDX: " + read);
		count--;
		E val = buffer[read];
		read = (read+1) % size;
		
		return val;
	}
}
