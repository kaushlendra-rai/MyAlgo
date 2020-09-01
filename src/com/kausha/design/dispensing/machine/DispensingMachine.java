package com.kausha.design.dispensing.machine;

/**
 * Question from: https://medium.com/swlh/vending-machine-design-a-state-design-pattern-approach-5b7e1a026cd2
 * Vending Machine must keep track of the inventory
 * A person should be able to insert cash into the machine & choose an item
 * The Machine should confirm the inserted cash with the price of the selected item
 * The machine must display an error in case of insufficient cash or unavailable item
 * Finally, if all the above steps succeed then the user gets the selected item
 * 
 * 
 * We can use the state machine but with single method 'execute()' interface flavour.
 * Defining state:
 * 1) Machine is in Ready state
 * 2) First a person enters money. Any other action is invalid.
 * 3) Person can now either:
 * 		a) Enter more money
 * 		b) Select an item he wants to buy
 * 		c) Cancel the transaction.
 * 4) Person selected the item
 * 		a) The item does not exists Return error and Cancel the transaction automatically. 
 * 			Canceling the transaction must dispense the full money back as entered by the person.
 * 		b) The machine does not have change to be returned based on money given by customer, change in the machine and the price of the item.
 * 		c)  The Item is dispensed to the user.
 * 5) Change if any need to be dispensed to the user.
 * 		If we have got here, it implies that there is change in the machine.
 * 6) Transaction is Complete. Return the machine to 'Ready' state to accept new fresh order.
 * 
 * 
 * @author sinkar
 *
 */
public class DispensingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
