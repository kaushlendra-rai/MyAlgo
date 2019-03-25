package com.kausha.design.itrator;

import java.util.List;

public class IterateOverListOfList {

	private List<List<Integer>> list;
	
	public IterateOverListOfList(List<List<Integer>> list){
		this.list = list;
	}
	
	public Iterator<Integer> getIterator(){
		Iterator<Integer> itr = new InternalIterator();
		return itr;
	}
	
	class InternalIterator implements Iterator<Integer>{
		int externalListIndex = 0;
		int internalListIndex = 0;
		
		@Override
		public boolean hasNext() {
			
			while(externalListIndex < list.size()){
				List<Integer> list1 = list.get(externalListIndex);
				
				if(list1 != null && list1.size() > internalListIndex){
					internalListIndex++;
					return true;
				}else{
					externalListIndex++;
					internalListIndex = 0;
				}
			}
			
			return false;
		}

		@Override
		public Integer next() {
			List<Integer> list1 = list.get(externalListIndex);
			
			return list1.get(internalListIndex-1);
		}
	}
}