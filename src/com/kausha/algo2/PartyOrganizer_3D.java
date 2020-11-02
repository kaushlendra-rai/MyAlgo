package com.kausha.algo2;

/**
 * Given that friends live in a 3D coordinates.
 * {"Ram", {1, 2, 3}}
 * {"Shayam", {3, 1, 5}}
 * {"Sonu", {7, 4, 9}}
 * {"Kaushal", {6, 2, 7}}
 * 
 *  Find the person from whose house is most centarally located for all to come to his house for party.
 *  
 * @author sinkar
 *
 */
public class PartyOrganizer_3D {

	public static void main(String[] args) {
		Friend[] friends = new Friend[] {new Friend("Ram", 1, 1, 1), new Friend("Shayam", 3, 6, 8), new Friend("Sonu", 4, 2, 3)};
		System.out.println(getPartyOrganizer(friends));
	}
	
	//This algorithm has a complexity of O(n^2)
	// It assumes center as one friend at a time and calculates total distance that all friend would have to travel. 
	public static Friend getPartyOrganizer(Friend[] friends ) {
		Friend partyOrganizer = null;
		double minDistance = Integer.MAX_VALUE;
		
		for(Friend self : friends) {
			double distance = 0;
			for(Friend friend : friends) {
				if(self != friend)
					distance += Math.sqrt(Math.pow(self.x - friend.x, 2) + Math.pow(self.y - friend.y, 2)  + Math.pow(self.z - friend.z, 2)); 
			}
			if(distance < minDistance) {
				minDistance = distance;
				partyOrganizer = self;
			}
		}
		
		return partyOrganizer;
	}
	
	// An alternative approach could be to:
	// 1) Find the median for all X, Y & Z axis of all coordinates. O(nlogn)
	// 2) Find the closest Friend to this new median coordinates. O(n)
	// This algorithm would give us over all O(nlogn) complexity as against O(n^2) in the above case.
	public static Friend getPartyOrganizer_Optimized(Friend[] friends ) {
		Friend partyOrganizer = null;
		
		return partyOrganizer;
	}
}

class Friend{
	String name;
	int x;
	int y; 
	int z;
	
	@Override
	public String toString() {
		return "Friend [name=" + name + ", x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
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
		Friend other = (Friend) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	public Friend(String name, int x, int y, int z) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}