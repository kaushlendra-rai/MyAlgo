package com.kausha.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindNumberOfRectanglesGIvenNumberOfPointsIn2D {

	public static void main(String[] args) {
		// Points/Rectangles all on X axis only.
		//Point[] points = new Point[] {new Point(1, 1),new Point(1, 5),new Point(4, 1),new Point(4, 5),new Point(6, 1),
		//		new Point(6, 5)};
		
		// X-axis based rectangle.
		Point[] points = new Point[] {new Point(1, 1),new Point(1, 5),new Point(4, 1),new Point(4, 5),new Point(6, 1),
				new Point(6, 5),new Point(9, 1),new Point(9, 5)};

		// Y-axis based rectangles
		// Point[] points = new Point[] {new Point(1, 1),new Point(5, 1),new Point(1, 4),new Point(5, 4),new Point(1, 6),
		//		new Point(5, 6),new Point(1, 9),new Point(5, 9),};
		
		System.out.println("Total Rectangles: " + getRectangleCounts(points));
		
		//System.out.println("Total Rectangles: " + getRectangleCounts_1(points));
	}
	
	public static int getRectangleCounts(Point[] points) {
		int rectangleCount = 0;
		// Put all the points in HashSet for  quick lookup
		Set<Point> uniquePoints = new HashSet<Point>();
		for(Point point : points)
			uniquePoints.add(point);
		
		// (1, 1) & (4, 5) => Check for (1,5) & (4, 1) 
		for(Point point : points) {
			for(Point innerPoint : points) {
				if(point != innerPoint) {
					Point dia1 = new Point(point.x, innerPoint.y);
					Point dia2 = new Point(innerPoint.x, point.y);
					
					// The co-ordinates of a diagonal cannot be on same X or Y axis.
					// Also, check if the other two diagonals are in the provided Point list. If yes, we have a match.
					if(!(point.x == innerPoint.x || point.y == innerPoint.y) && uniquePoints.contains(dia1) && uniquePoints.contains(dia2)) {
						rectangleCount++;
						// System.out.println("ORG:: " + point +  "  " + innerPoint);
						// System.out.println("Diag:: " + dia1 +  "  " + dia2);
					}
				}
			}
		}
		
		// The rectangle count has duplication:
		// 1) The same pair would be processed 2 times- once by outer loop & then later the inner loop. Hence divide
		// the total number of rectangles by '2' for this.
		// 2) The same rectangle would be added 2 times for this logic due to two set of diametrically opposite points.
		// Hence divide the rectangle by '2' again for this.
		// Hence, over all we divide the rectangle count by '4' times.
		return rectangleCount/4;
	}
	
	// This works only for X axis or Y-axis based rectangles.
	// Could not figure out an approach to fix this for x & y coordinates rectangles  :(
	public static int getRectangleCounts_1(Point[] points) {
		int rectangleCount = 0;
		Map<String, Integer> count = new HashMap<String, Integer>();
		for(Point pointAbove : points) {
			for(Point pointLow : points) {
				String key = null;
				if(pointAbove.x == pointLow.x && pointAbove.y > pointLow.y)
					key = "y-" + pointAbove.y + "-" + pointLow.y;
				//else if (pointAbove.y == pointLow.y && pointAbove.x > pointLow.x)
				//	key = "x-" + pointAbove.x + "-" + pointLow.x;
				
				if(key != null) {
					if(count.get(key) == null)
						count.put(key, 0);
					else
						count.put(key, 1 + count.get(key));
					
					System.out.println("Key: " + key + ", Count: " + count.get(key));
				}
			}
		}
		
		// Total number of Rectangles for one entry = n*(n+1)/2
		for(String value : count.keySet()) {
//			if (value.startsWith("y"))
//				rectangleCount += count.get(value) * (count.get(value)+1)/2 -1;
//			else
				rectangleCount += count.get(value) * (count.get(value)+1)/2;
		}
		
		return rectangleCount;
	}

}

class Point{
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	int x;
	int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}