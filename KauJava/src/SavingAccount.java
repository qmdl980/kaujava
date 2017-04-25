
public class SavingAccount extends Account implements Valuable{
	private double interest;
	private int monthCount;
	
	public SavingAccount(double balance, double interest){
		super(balance);
		this.interest = interest;
		monthCount = 0;
	}
	
	public void debit(double amount) throws Exception{

		if(monthCount < 12){
			throw new Exception("���� ����� �� �����ϴ�.");
		}else if(amount < 0){
			throw new Exception(" �����Է�!");
		}else if(amount > getBalance()){
			throw new Exception("Debit amount exceeded account balance.");
		} else {
			changeBalance(getBalance() - amount);
		}
	} 
	
	public double EstimateValue(int time){
		return getBalance() * Math.pow((1 + interest), time);
	}
	public double EstimateValue(){
		return getBalance() * (1 + interest);
	}
	
	public String toString(){
		return String.format("SavingAccount_Balance: %.2f", getBalance());
	}
	public double getWithdrawableAccount(){
		if(monthCount < 12){
			return 0;
		} else {
			return getBalance();
		}
	}
	
	public void passTime(int time){
		monthCount += time;
		if(monthCount >= 12){
			changeBalance(getBalance() * Math.pow((1 + interest), 12));
		}
	}
	public void passTime(){
		monthCount++;
		if(monthCount == 12){
			changeBalance(getBalance() * Math.pow((1 + interest), 12));
		}
	}
};
