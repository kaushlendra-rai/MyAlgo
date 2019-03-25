package com.kausha.algo;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Lets say that there is a Funds transfer between parties.
 * For a given list of transfers, we need to figure out the minimum number of Transfers actually needed to be performed after soft reconciliation of funds movement
 * across accounts.
 * E.g. A -> B (100), B -> C (50), C -> D (50), D -> A (50)
 * Effective transfer required: A -> B (50) 
 * @author sinkar
 *
 */
public class BankAccountsReconciliation {

	public static void main(String[] args) {
		PriorityQueue<TransferTuple> transferTuples = new PriorityQueue<TransferTuple>(TransferTuple.ascendingComparator);
		
		// Below Final transfers:   C -> A (300), C -> B (50) , C -> D (50)
		transferTuples.add(new TransferTuple("A", "A", 100)); // Self-referencing transfers
		transferTuples.add(new TransferTuple("B", "B", 100)); // Self-referencing transfers
		transferTuples.add(new TransferTuple("A", "B", 100));
		transferTuples.add(new TransferTuple("B", "C", 50));
		transferTuples.add(new TransferTuple("C", "D", 50));
		transferTuples.add(new TransferTuple("C", "A", 150));
		transferTuples.add(new TransferTuple("C", "A", 250));
		
		
		/*pQueue.add(new TransferTuple("A", "B", 50));
		pQueue.add(new TransferTuple("B", "C", 100));*/
		
		// Below Final result:   A -> B (50)
		/*transferTuples.add(new TransferTuple("A", "B", 100));
		transferTuples.add(new TransferTuple("B", "C", 50));
		transferTuples.add(new TransferTuple("C", "D", 50));
		transferTuples.add(new TransferTuple("D", "A", 50));*/
		
		
		sanitizeData(transferTuples);
		
		ConcurrentMap<String, PriorityQueue<TransferTuple>> accountTransfers = getAccountTransferMap(transferTuples);
		
		reconciliate(transferTuples, accountTransfers);
		
		List<TransferTuple> finalTuples = performConsolidationOfTransferOnSameAccounts(accountTransfers);
		
		System.out.println(finalTuples);
	}
	
	/**
	 * Self-referencing transfers MUST be removed from the list as they are not meaningful and can cause infinite loop in teh transfer logic
	 * @param pQueue
	 */
	private static void sanitizeData(PriorityQueue<TransferTuple> transferTuples) {
		for(Iterator<TransferTuple> itr = transferTuples.iterator(); itr.hasNext(); ) {
			TransferTuple transferTuple = itr.next();
			if(transferTuple.getFrom().equals(transferTuple.getTo()))
					itr.remove();
		}
	}
	
	/**
	 * Group the transfer based on the Source Account for easy management of funds. The corresponding Queue of transfer for individual must be sorted in ascending order of amount. 
	 * @param transferTuples
	 * @return
	 */
	private static ConcurrentMap<String, PriorityQueue<TransferTuple>> getAccountTransferMap(PriorityQueue<TransferTuple> transferTuples){
		ConcurrentMap<String, PriorityQueue<TransferTuple>> accountTransfers = new ConcurrentHashMap<String, PriorityQueue<TransferTuple>>();
		for(Iterator<TransferTuple> itr = transferTuples.iterator(); itr.hasNext();) {
			TransferTuple tuple = itr.next();
			
			if(accountTransfers.get(tuple.getFrom()) != null)
				accountTransfers.get(tuple.getFrom()).add(tuple);
			else {
				PriorityQueue<TransferTuple> queue = new PriorityQueue<TransferTuple>();
				queue.add(tuple);
				accountTransfers.put(tuple.getFrom(), queue);
			}
		}
		
		return accountTransfers;
	}

	/**
	 * There could be multiple entries of TransferTuple from A -> B (50), A->C (100), A->B (200).
	 * Since we are reducing the number of transactions, we need to merge such transactions. E.g. above transactions converge to : A -> C (100), A -> B (250)
	 * @param accountTransfers
	 */
	private static List<TransferTuple> performConsolidationOfTransferOnSameAccounts(Map<String, PriorityQueue<TransferTuple>> accountTransfers) {
		List<TransferTuple> finalTuples = new ArrayList<TransferTuple>();
		
		for(String key : accountTransfers.keySet()) {
			PriorityQueue<TransferTuple> groupedTuples = new PriorityQueue<TransferTuple>(TransferTuple.targetAccoutComparator);
			groupedTuples.addAll(accountTransfers.get(key));
			
			while(!groupedTuples.isEmpty()) {
				TransferTuple transferTuple = groupedTuples.poll();
				
				if(!groupedTuples.isEmpty()) {
					TransferTuple peekedTransferTuple = groupedTuples.peek();
					
					if(transferTuple.getTo().equals(peekedTransferTuple.getTo())) {
						peekedTransferTuple.setAmount(peekedTransferTuple.getAmount() + transferTuple.getAmount());
					}else
						finalTuples.add(transferTuple);
				}else
					finalTuples.add(transferTuple);
			}
		}
		
		return finalTuples;
	}

	/**
	 * Actual transfer logic happens here.
	 * We transfer funds with smallest amounts settled first. This approach helps us reduce the maximum number of transfers.
	 * After each transfer, we put the balance between accounts back on processing list to allow for further propagation of the newly transferred funds to other account for 
	 * circulation of money to further reduce the number of actual transfers. 
	 * 
	 * @param tupleList
	 * @param accountTransfers
	 */
	public static void reconciliate(PriorityQueue<TransferTuple> transferTuples, ConcurrentMap<String, PriorityQueue<TransferTuple>> accountTransfers) {
		for(; !transferTuples.isEmpty();) {
			TransferTuple tuple = transferTuples.poll();
			PriorityQueue<TransferTuple> accountTransfer = accountTransfers.get(tuple.getTo());
			
			if(accountTransfer != null && !accountTransfer.isEmpty()) {
				
				if(!accountTransfer.isEmpty()) {
					TransferTuple targetTuple = accountTransfer.poll();
					
					// Remove Target tuple from the TransferQueue
					transferTuples.remove(targetTuple);
					
					/*System.out.println("Source Tuple: " + tuple);
					System.out.println("Target Tuple: " + targetTuple);*/
					if(tuple.getAmount() >= targetTuple.getAmount()) {
						
						// Add a new entry in the Map with appropriate target as "From" value changes.
						PriorityQueue<TransferTuple> set = accountTransfers.get(tuple.getFrom());

						TransferTuple newTuple = new TransferTuple(tuple.getFrom(), targetTuple.getTo(), targetTuple.getAmount());						
						set.add(newTuple);
						transferTuples.add(newTuple);

						// Update the remaining amount of tuple in processing list.
						if(tuple.getAmount() > targetTuple.getAmount()) {
							tuple.setAmount(tuple.getAmount() - targetTuple.getAmount());
							transferTuples.add(tuple);
						}else
							accountTransfers.get(tuple.getFrom()).remove(tuple);
						
						if(accountTransfers.get(tuple.getTo()) != null)
							accountTransfers.get(tuple.getTo()).remove(targetTuple);

					}else {
						accountTransfers.get(tuple.getTo()).remove(targetTuple);
						
						tuple.setTo(targetTuple.getTo());
						transferTuples.add(tuple);
						
						targetTuple.setAmount(targetTuple.getAmount() - tuple.getAmount());
						transferTuples.add(targetTuple);
						
						accountTransfers.get(targetTuple.getFrom()).add(targetTuple);
					}
				}
			}
		}
		
		for(String key : accountTransfers.keySet())
			System.out.println("@@@@ Key : " + key + "      =>"+ accountTransfers.get(key));
	}
}

class TransferTuple implements Comparable{
	
	public TransferTuple(String from, String to, int amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	}
	
	private String from;
	private String to;
	private int amount;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public int hashCode() {
		System.out.println("abc");
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		TransferTuple other = (TransferTuple) obj;
		if (amount != other.amount)
			return false;
		
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Object obj) {
		return amount - ((TransferTuple)obj).getAmount();
	}
	@Override
	public String toString() {
		return "TransferTuple [from=" + from + ", to=" + to + ", amount=" + amount + "]";
	}
	
	public static Comparator<TransferTuple> ascendingComparator = new Comparator<TransferTuple>() {
		@Override
		public int compare(TransferTuple t1, TransferTuple t2) {
			return t1.getAmount() - t2.getAmount();
		}
	};
	
	
	public static Comparator<TransferTuple> targetAccoutComparator = new Comparator<TransferTuple>() {
		@Override
		public int compare(TransferTuple t1, TransferTuple t2) {
			return t1.getTo().compareTo(t2.getTo());
		}
	};
}