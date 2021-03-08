package com.kausha.algo.leetcode;

import java.util.Arrays;

// Given meetings and the hours it exists for, find the maximum number of hours the room can stay occupied.
// It must be noted that we do not have meeting start and end times. we just have hours.

// 0/1 Knapsack Problem Dynamic Programming
// https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr

// Out here in the Knapsack problem, the weight is the hours of meeting and the value will be same as weight for each meeting.

// The solutions considers having multiple meeting with same durations.
/**
 * For an input {2, 3, 3, 7} and 12 hours time limit for meeting
 * 		|	0	1	2	3	4	5	6	7	8	9	10	11	12
 * 		|------------------------------------------------------
 * 	0	|	0	0	0	0	0	0	0	0	0	0	0	0	0
 * 	2	|	0	0	2	2	2	2	2	2	2	2	2	2	2
 * 	3	|	0	0	2	3	3	5	5	5	5	5	5	5	5
 * 	3	|	0	0	2	3	3	5	6	6	8	8	8	8	8
 * 	7	|	0	0	2	3	3	5	6	7	7	9	10	10	12
 * 
 * @author sinkar
 *
 */
public class MeetingsOptimizationForLongestHour_DP {

	public static void main(String[] args) {
		int[] meetingHours = new int[] {4, 6, 6, 14};
		
		int[] maxMeetingHours = printMeetingsWithMaximumHours(meetingHours);
	}

	private static int[] printMeetingsWithMaximumHours(int[] meetingHours) {
		if (meetingHours == null)
			return null;
		// We do an ascending sort of meeting hours.
		Arrays.sort(meetingHours);
		int[][]  meetingHourGrid = new int[meetingHours.length + 1][25];
		
		for(int i=1; i <= meetingHours.length; i++) {
			for(int j = 1; j <=24; j++) {
			
				if(j < meetingHours[i-1])
					meetingHourGrid[i][j] = meetingHourGrid[i-1][j];
				else {
					meetingHourGrid[i][j] = Math.max(meetingHourGrid[i-1][j], meetingHours[i-1] + meetingHourGrid[i-1][j-meetingHours[i-1]]);
				}
			}
		}
//		for(int i=1; i <= meetingHours.length; i++) {
//			for(int j = 1; j <=24; j++) {
//				System.out.print(meetingHourGrid[i][j] + " ");
//			}
//			System.out.println("");
//		}
		
		// Now print the meeting hours that got picked.
		// If the right corner block value is same as that of above, it implies that the block has not been 
		// Included in the final meeting schedule. Move one row above.
		// If however they differ, it implies that the current meeting hours was used. We print it and then
		// we check for the next hours left in the meeting until we reach the '0' hours indicating that all meeting
		// slots have been visited.
		for(int i=meetingHours.length; i >0 ;) {
			for(int j = 24; j > 0; ) {
				if(meetingHourGrid[i][j] > 0) {
					if(meetingHourGrid[i][j] == meetingHourGrid[i-1][j]) {
						i--;
					}else {
						System.out.println(meetingHours[i-1]);
						j = j - meetingHours[i-1];
						i--;
					}
				}
			}
		}
		return null;
	}

}