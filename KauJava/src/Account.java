
public abstract class Account implements Valuable{
	protected double balance;
	
	public Account(double balance){
		this.balance = balance;
	}
	
	public void credit(double add){
		balance = balance + add;
	}
	public void debit(double minus) throws Exception{
		balance -= minus;
	}
	public double getBalance(){
		return balance;
	}
	protected void changeBalance(double money){
		balance = money;
	}
	public abstract double getWithdrawableAccount();
	public abstract void passTime(int time);
	public abstract void passTime();
};
