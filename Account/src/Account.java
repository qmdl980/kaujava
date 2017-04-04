
public abstract class Account {
	private double balance;
	
	public Account(double balance){
		this.balance = balance;
	}
	
	public void credit(double add){
		balance = balance + add;
	}
	public void debit(double minus){
		if(balance > minus){
			balance = balance - minus;
		} else{
			System.out.print("Balance is not enough! \n");
		}
	}
	public double getBalance(){
		return balance;
	}
	protected void changeBalance(double money){
		balance = money;
	}
	public abstract double getWithdrawableAccount();
	public abstract void passTime(int time);
};
