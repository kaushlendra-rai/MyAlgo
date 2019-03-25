package fun.atm;

public class TestATM {

	public static void main(String[] args) {
		
		ATM atm = new BankATM();
		
		atm.addDenominationsToATM(1000, 1);
		atm.addDenominationsToATM(500, 5);
		atm.addDenominationsToATM(100, 10);
		
		try{
			atm.withdraw(2000);
		}catch(ATMException e){
			System.out.println("Unable to Withdraw the amount.\nReason - " + e.getMsg());
		}
	}
}