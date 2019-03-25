package fun.atm;

public class ATMException extends Exception {
	private String msg;
	
	public ATMException(String msg){
		super(msg);
		this.msg = msg;
	}
	
	public String toString(){
		return msg;
	}

	public String getMsg() {
		return msg;
	}
}
