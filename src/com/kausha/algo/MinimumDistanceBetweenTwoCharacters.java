package com.kausha.algo;

public class MinimumDistanceBetweenTwoCharacters {
	public static void main(String[] args) {
		String str = "axcaerrade";
		int distance = findMinimumDistance(str, 'a', 'e');
		System.out.println("Distance = " + distance);
	}

	private static int findMinimumDistance(String str, char str1,char str2) {
		int minDistance = Integer.MAX_VALUE;
		
		int str1Index = -1;
		int str2Index = -1;
		
		for(int i=0; i < str.length(); i++){
			boolean valueChanged = false;
			
			if(str.charAt(i) == str1){
				str1Index = i;
				valueChanged = true;
			}else if(str.charAt(i) == str2){
				str2Index = i;
				valueChanged = true;
			}
			
			// Check for distance only when at least both characters have been encountered once
			if(valueChanged && str1Index >= 0 && str2Index >= 0){
				if(str1Index >= 0 && str2Index >= 0){
					int localDist = str1Index  - str2Index;
					if(localDist < 0)
						localDist = localDist * -1;
					
					if(minDistance > localDist)
						minDistance = localDist;
				}
				
				valueChanged = false;
			}
		}
		
		return minDistance;
	}
}