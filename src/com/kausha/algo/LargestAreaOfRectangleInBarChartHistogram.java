package com.kausha.algo;

import java.util.Stack;

// https://www.youtube.com/watch?v=E5C5W6waHlo
// https://www.youtube.com/watch?v=zx5Sw9130L0
public class LargestAreaOfRectangleInBarChartHistogram {
	
	public static void main(String[] args) {
		//int[] charts = {2, 2, 3, 4, 5, 3, 1};
		//int[] charts = {1, 2, 3, 4, 5, 1, 1, 4, 1, 1, 1, 2};
		int[] charts = {1, 2, 3, 4, 4, 1, 2, 3, 4, 15, 5, 5, 5};
		
		System.out.println(getAreaOflargestRectangle(charts));
	}

	private static int getAreaOflargestRectangle(int[] charts){
		int area = 0;
		
		Stack<Integer> height = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		
		for(int i=0; i < charts.length; i++){
			int tempArea = 0;
			if(height.isEmpty() || charts[i] >= height.peek()){
				height.push(charts[i]);
				index.push(i);
			}else if(charts[i] < height.peek()){
				
				int lastIndex = 0;
				
				while(!height.isEmpty() && height.peek() > charts[i]){
					lastIndex = index.pop(); 
					tempArea=  (i - lastIndex) * height.pop();
					
					if(tempArea > area)
						area = tempArea;
				}
				
				height.push(charts[i]);
				//index.push(lastIndex); // Why this ?? Could not Find why was it required in main link above.
				index.push(i); // I'm using 'i' instead of lastIndex and it seems to work fine.
			}
		}
		System.out.println(area);
		while(!height.isEmpty()){
			System.out.println("height = " + height.pop());
		}
		
		while(!index.isEmpty())
			System.out.println("index = " + index.pop());
			
		// This section calculates the area of the last monotonically increasing bar chart if still left 
		while(!height.isEmpty()){
			int tempArea = height.pop() * (charts.length - index.pop());
			
			if(area < tempArea)
				area = tempArea;
		}
		
		return area;
	}
}