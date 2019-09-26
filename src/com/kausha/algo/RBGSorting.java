package com.kausha.algo;

public class RBGSorting {
	public static void main(String[] args) {
		int[] data = {2, 0, 0, 0, 1, 2, 0, 0, 1, 2, 2, 2, 0, 1, 2, 2};

		threeWayPartition(data, 1, 2);
		
		for(int num : data)
			System.out.print(num + " ");

	}

	private static void threeWayPartition(int[] data, int i, int j) {
		
		int start = 0;
		int end = data.length-1;
		int counter = 0;
		
		while(counter <= end){
			while(data[start] == 0){
				System.out.println("+++");
				start++;
				counter++;
			}
			
			while(data[end] == 2){
				end--;
			}
			
			if(data[counter] == 2){
				data[counter] = data[end];
				data[end--] = 2;
			}else if(data[counter] == 1){
				counter++;
			}else{
				System.out.println("*");
				data[counter++] = data[start];
				data[start++] = 0;
			}
		}	
	}
}
