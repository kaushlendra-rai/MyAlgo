package com.kausha.design.onlineReservation;

import java.util.Date;

//Each review can also be linked to a list of images that the user can upload.
public class ReviewComment {
	String commentId;
	String resturantId;
	String parentCommentId;
	String userId;
	String commentText;
	Date creationDate;
	Date updateDate;
	
	boolean verified; // Try to see if we can link the Review to an order that the customer might have made through this platform
	// to ensure that it is indeed a genuine review and and a bogus review.
}
