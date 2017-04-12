
public class SavingAccount extends Account{
	private double interest;
	private int monthCount = 0;
	
	public SavingAccount(double balance, double interest){
		super(balance);
		this.interest = interest;
	}
	
	public void debit(double amount) throws Exception{

		if(monthCount < 12){
			throw new Exception("아직 출금할 수 없습니다.");
		}else if(amount < 0){
			throw new Exception(" 음수입력!");
		}else if(amount > getBalance()){
			throw new Exception("Debit amount exceeded account balance.");
		} else {
			changeBalance(getBalance() - amount);
		}
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
		if(monthCount == 12){
			changeBalance(getBalance() * Math.pow((1 + interest), 12));
		}
	}
};
