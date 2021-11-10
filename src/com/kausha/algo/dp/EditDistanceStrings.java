package com.kausha.algo.dp;

// https://www.ideserve.co.in/learn/edit-distance-dynamic-programming
public class EditDistanceStrings 
{
    final static int ERROR_INPUT = -1;
    
	private int findDistance_rec(String str1, String str2) {
		return findDistance_rec(str1, str2, 0, 0);
	}

	// We can improve this recursion by using memoization with str1+str2 and count.
	private int findDistance_rec(String str1, String str2, int idx1, int idx2) {
		if(str1.length() == idx1)
			return str2.length() - idx2;
		if(str2.length() == idx2)
			return str1.length() - idx1;
		
		if(str1.charAt(idx1) == str2.charAt(idx2))
			return findDistance_rec(str1, str2, idx1+1, idx2+1);
		else {
			return 1 + Math.min(findDistance_rec(str1, str2, idx1, idx2+1), // Insert
					Math.min(findDistance_rec(str1, str2, idx1+1, idx2+1), // Update
							findDistance_rec(str1, str2, idx1+1, idx2) // Delete
					));
		}
	}
	
	public int findDistance(String str1, String str2){
	     if (str1 == null || str2 == null)
	            return ERROR_INPUT;
	        
	        int[][] distanceTable = new int[str1.length()+1][str2.length()+1];
	        
	        int numRows = str1.length() + 1;
	        int numCols = str2.length() + 1;
	         
	        for (int m = 0; m < numRows; m++) {
	            for (int  n = 0; n < numCols; n++) {

                if (m == 0)
                    distanceTable[m][n] = n;
                else if (n == 0)
                	distanceTable[m][n] = m;
	            else if (str1.charAt(m-1) == str2.charAt(n-1))
	                distanceTable[m][n] = distanceTable[m-1][n-1]; 
	            else
	            	distanceTable[m][n] = Math.min(
	                    1 + distanceTable[m-1][n], Math.min(
	                    1 + distanceTable[m][n-1],
	                    1 + distanceTable[m-1][n-1]
	                ));
	            }
	        }
	        
	        return distanceTable[numRows-1][numCols-1];
	    }
	    
	    public static void main(String[] args) {
	        EditDistanceStrings solution = new EditDistanceStrings();
	        System.out.println("2D table: " + solution.findDistance("intention" , "execution" ));
	        System.out.println("Recursion: " + solution.findDistance_rec("intention" , "execution" ));
	    }
}