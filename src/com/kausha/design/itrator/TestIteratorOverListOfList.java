package com.kausha.design.itrator;

import java.util.ArrayList;
import java.util.List;

public class TestIteratorOverListOfList {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(11);
		list2.add(12);
		list2.add(13);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(31);
		
		List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
		listOfList.add(list1);
		listOfList.add(list2);
		listOfList.add(list3);
		
		IterateOverListOfList lol = new IterateOverListOfList(listOfList);
		Iterator< Integer> itr = lol.getIterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}