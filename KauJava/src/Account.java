import java.util.*;
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
	public static double sumForAccount(ArrayList<? extends Account> list){
		double sum = 0;
		for(Account account : list){
			sum+= account.getBalance();
		}
		return sum;
	}
	public static void passTimeForList(ArrayList<? extends Account> list,int month){
		for(Account account : list){
			account.passTime(month);
		}
	}
	public abstract double getWithdrawableAccount();
	public abstract void passTime(int time);
	public abstract void passTime();
};
