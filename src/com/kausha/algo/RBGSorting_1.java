package com.kausha.algo;

//http://en.wikipedia.org/wiki/Dutch_national_flag_problem
public class RBGSorting_1 {
	public static void main(String[] args) {
		int[] data = {2, 0, 0, 0, 1, 2, 0, 0, 1, 2, 2, 2, 0, 1, 2, 2};

		threeWayPartition(data, 1, 2);
		
		for(int num : data)
			System.out.print(num + " ");
	}
	
	private static void threeWayPartition(int data[], int low, int high) {
		int p = -1;
		int q = data.length;
		
		for (int i = 0; i < q;) {
			if (data[i] < low) {
				swap(data, i, ++p);
				++i;
			} else if (data[i] >= high) {
				swap(data, i, --q);
			} else {
				++i;
			}
		}
	}

	private static void swap(int data[], int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}