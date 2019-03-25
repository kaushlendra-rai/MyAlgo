package com.kausha.algo2;


/**
 * Given an array os 0s and 1s, and another input m, I was supposed to tell the longest continuous streak of 1s after 
 * flipping m 0s to 1s. E.g., Array is {1,1,0,0,1,1,1,0,1,1} m = 1 (which means I can flip ‘m’ one 0 to 1)
Answer: 6 (if we flip 0 at index 7, we get the longest continuous streak of 1s having length 6)
 * @author sinkar
 *
 */
public class Flip0To1ToGetLongestStreakOf1InArray {

	public static void main(String[] args){
		//int index = getFlipIndex(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1});
		//int index = getFlipIndex(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1});
		int index = getFlipIndex(new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1});
		//int index = getFlipIndex(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1});
		//int index = getFlipIndex(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0});
		
		//int index = getFlipIndex(new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1});
		
		//int index = getFlipIndex(new int[]{0, 0, 0, 0});
		if(index==-1)
			System.out.println("There were no '0' present in the input array");
		else
			System.out.println("Index = " + index);
	}
	
	private static int getFlipIndex(int[] nums){
		int index =-1;
		int maxCount = -1;
		boolean initialFlipDone = false;
		
		int firstLocalIndex=0;
		int firstLocalMaxCount = 0;
		
		int secondLocalIndex=0;
		int secondLocalMaxCount = 0;
		
		boolean firstFlipDone = false;
		
		for(int i=0; i< nums.length; i++){
			if(nums[i] == 0)
				initialFlipDone = true;
			
			if(nums[i] == 0 && !firstFlipDone){
				if(secondLocalMaxCount > maxCount){
					maxCount = secondLocalMaxCount;
					index = secondLocalIndex;
					
					System.out.println("secondLocalMaxCount = " + secondLocalMaxCount + "  secondLocalIndex = " + secondLocalIndex);
				}
				secondLocalMaxCount = 0;
				
				firstLocalIndex=i;
				firstLocalMaxCount++;
				
				firstFlipDone = true;
			}else if(nums[i] == 0 && firstFlipDone){
				if(firstLocalMaxCount > maxCount){
					maxCount = firstLocalMaxCount;
					index = firstLocalIndex;
					
					System.out.println("firstLocalMaxCount = " + firstLocalMaxCount + "  firstLocalIndex = " + firstLocalIndex);
				}
				firstLocalMaxCount = 0;
				
				secondLocalIndex=i;
				secondLocalMaxCount++;
				
				firstFlipDone = false;
			}else{
				firstLocalMaxCount++;
				
				if(initialFlipDone)
					secondLocalMaxCount++;
			}
		}
		
		// Checks for values after last iteration
		if(firstLocalMaxCount > secondLocalMaxCount && firstLocalMaxCount > maxCount && maxCount!= -1)
			index = firstLocalIndex;
		else if(secondLocalMaxCount > maxCount  && maxCount!= -1)
			index = secondLocalIndex;
		
		return index;
	}
}