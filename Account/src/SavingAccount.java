
public class SavingAccount extends Account{
	private double interest;
	private int monthCount = 0;
	
	public SavingAccount(double balance, double interest){
		super(balance);
		this.interest = interest;
	}
	
	public void debit(double amount){
		if(getBalance() > 0){
			if(monthCount < 12){
				System.out.println("아직 출금할 수 없습니다.");
			} else {
				changeBalance(getBalance() - amount);
			}
		} else {
			System.out.println("잔고가 없습니다.");
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
