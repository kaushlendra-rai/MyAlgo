package com.kausha.algo;


public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] array1 = {1, 5, 15, 22, 27, 35, 38, 40};
		int[] array2 = {1, 2, 3, 4, 6, 7, 9, 10, 13, 18, 21, 25, 30};
		
		/*
		int[] array1 = {1, 5, 15, 22, 27, 35};
		int[] array2 = {1, 2, 3, 4, 6, 7, 9};
		*/
		//getMeanApproach2(array1, array2, 0, array1.length-1, 0,  array2.length-1, 0);
		System.out.println("Median of merged array = " + getMedian(array1, array2));
		
		System.out.println("***** getMedianEfficient Median of merged array = " + getMedianEfficient(array1, array2));
	}

	// https://www.youtube.com/watch?v=LPFhl65R7ww
	// Complexity O(log(min(m , n))
	private static double getMedianEfficient(int[] array1, int[] array2){
		double median = 0;
		
		if(array1.length > array2.length)
			return getMedianEfficient(array2, array1);
		
		int x= array1.length;
		int y = array2.length;
		
		int start = 0;
		int end = x;
		
		while(start <= end) {
			int midX = start + (end-start)/2;
			int midY = (x + y + 1)/2 - midX;
			System.out.println("midX: " + midX + " , midY: " + midY);
			int maxLeftX = midX == 0 ? Integer.MIN_VALUE : array1[midX-1];
			int minRightX = midX == x ? Integer.MAX_VALUE : array1[midX];
			
			int maxLeftY = midY == 0 ? Integer.MIN_VALUE : array2[midY-1];
			int minRightY = midY == y ? Integer.MAX_VALUE : array2[midY];
			
			if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if((x + y)%2 == 0)
					median =  (double)(Math.max(maxLeftX, maxLeftY) + Math.max(minRightX, minRightY))/2;
				else
					median = (double)Math.max(maxLeftX, maxLeftY);

				break;
			}else if (maxLeftX > minRightY){
				end = midX -1;
			}else {
				start = midX+1;
			}
		}
		
		return median;
	}
	
	/**
	 * Complexity O(n+m)
	 * @param array1
	 * @param array2
	 * @return
	 */
	private static int getMedian(int[] array1, int[] array2){
		int mean = 0;
		int loopMax = (array1.length + array2.length)/2;
		
		boolean evenMean = true;
		boolean meanInFirstArray = true;
		
		if((array1.length + array2.length)%2 == 1){
			evenMean = false;
			loopMax++;
		}
		
		int arrayIndex1 = 0;
		int arrayIndex2 = 0; 
		
		for(int i=0; i < loopMax; i++){
			if(array1.length > arrayIndex1 && array2.length > arrayIndex2){
				if(array1[arrayIndex1] < array2[arrayIndex2]){
					arrayIndex1++;
					meanInFirstArray = true;
				}else{
					arrayIndex2++;
					meanInFirstArray = false;
				}
			}else if(array1.length > arrayIndex1){
				arrayIndex1++;
				meanInFirstArray = true;
			}else if(array2.length > arrayIndex2){
				arrayIndex2++;
				meanInFirstArray = false;
			}
		}
		
		if(meanInFirstArray)
			mean = array1[arrayIndex1 -1];
		else
			mean = array2[arrayIndex2 -1];
		
		return mean;
	}
	
	private static void getMeanApproach2(int[] array1, int[] array2, int start1, int end1, int start2, int end2, int meanCounter){
		
		System.out.println("start1 = " + start1 + "   , end1 = " + end1);
		System.out.println("start2 = " + start2 + "   , end2 = " + end2);
		int mean1 = array1[start1 + (end1 - start1)/2];
		int mean2 = array2[start2 + (end2 - start2)/2];
		
		System.out.println("meanCounter = " + meanCounter);
		System.out.println("mean1 = " + mean1);
		System.out.println("mean2 = " + mean2);
		if(meanCounter >= (array1.length + array2.length)/2){
			if(mean1 < mean2)
				System.out.println("Mean = " + mean1);
			else
				System.out.println("Mean = " + mean2);
			return;
		}
		
		if(mean1 <= mean2){
			meanCounter += (end1 - start1)/2 +1;
			start1 += (end1 - start1)/2 +1;
			end2 = start2 + (end2 - start2)/2;
			
			getMeanApproach2(array1, array2, start1, end1, start2, end2, meanCounter);
		}else{
			meanCounter += (end2 - start2)/2 + 1;
			start2 += (end2 - start2)/2 + 1;
			end1 = start1 + (end1 - start1)/2;
			
			getMeanApproach2(array1, array2, start1, end1, start2, end2, meanCounter);
		}
	}
}