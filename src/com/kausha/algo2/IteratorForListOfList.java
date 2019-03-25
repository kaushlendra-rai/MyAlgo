package com.kausha.algo2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


// http://www.careercup.com/question?id=5732059047788544
public class IteratorForListOfList<K> implements Iterable<K>{

	private List<List<K>> values;
	public IteratorForListOfList(List<List<K>> values){
		this.values = values;
	}
	
	public void add(List<List<K>> values){
		this.values = values;
	}


	@Override
	public Iterator<K> iterator() {
		return new ListListIterator();
	}
	
	private class ListListIterator implements Iterator<K>{
		
		private Iterator<K> innerItr;
		private Iterator<List<K>> outerItr;
		
		public ListListIterator(){
			this.outerItr = IteratorForListOfList.this.values.iterator();
		}
		
		@Override
		public boolean hasNext() {
			if(this.innerItr == null || !this.innerItr.hasNext()){
				if(outerItr.hasNext()){
					this.innerItr = this.outerItr.next().iterator();
					return true;
				}else
					return false;
			}else
				return true;
		}

		@Override
		public K next() {
			if(this.innerItr == null || !this.innerItr.hasNext())
				if(this.outerItr.hasNext())
					this.innerItr = this.outerItr.next().iterator();
			
			return this.innerItr.next();
		}

		@Override
		public void remove() {
			innerItr.remove();
		}
		
	}
	
	public static void main(String[] args) {
		List<String> inner1 = new ArrayList<String>();
		inner1.add("a");
		inner1.add("b");
		inner1.add("c");
		
		List<String> inner2 = new ArrayList<String>();
		inner2.add("d");
		inner2.add("e");
		inner2.add("f");
		
		List<String> inner3 = new ArrayList<String>();
		inner3.add("g");
		inner3.add("h");
		inner3.add("i");
		
		List<String> inner4 = new ArrayList<String>();
		inner4.add("j");
		
		List<List<String>> outer = new ArrayList<List<String>>();
		outer.add(inner1);
		outer.add(inner2);
		outer.add(inner3);
		outer.add(inner4);
		
		IteratorForListOfList<String> myItr = new IteratorForListOfList<String>(outer);
		Iterator<String> itr = myItr.iterator();
		
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}