
public class CheckingAccount extends Account{
	private double credit_limit;
	private double interest;
	private double loan_interest;
	
	CheckingAccount(double balance, double credit_limit, double interest, double loan_interest){
		super(balance);
		this.credit_limit = credit_limit;
		this.interest = interest;
		this.loan_interest = loan_interest;
	}
	
	public boolean isBankrupted(){
		if(getBalance() < -(credit_limit)){
			return true;
		}else{
			return false;
		}
	}
	
	@Override public void debit(double minus) throws Exception{
		if(minus < 0){
			throw new Exception(" 음수입력!");
		}else if(minus > getBalance() + credit_limit){
			throw new Exception("Debit amount exceeded account balance.");
		}
		else{
			changeBalance(getBalance() - minus);
		}
	}
	
	@Override public void passTime(int time){
		if(getBalance() < 0){
			changeBalance(getBalance() * (1 + (loan_interest * time)));
		} else {
			changeBalance(getBalance() * (1 + (interest * time)));
		}
	}
	
	public double getWithdrawableAccount(){
		if(getBalance() < -(credit_limit)){
			return 0;
		}else{
			return (getBalance() + credit_limit);
		}
	}
};
