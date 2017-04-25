
public class CheckingAccount extends Account implements Valuable{
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
	
	@Override public void debit(double amount) throws Exception{
		if(amount < 0){
			throw new Exception(" 음수입력!");
		}else if(amount > getBalance() + credit_limit){
			throw new Exception("Debit amount exceeded account balance.");
		}
		else{
			changeBalance(getBalance() - amount);
		}
	}
	public double EstimateValue(int time){
		return getBalance() * (1 + (interest * time));
	}
	
	public double EstimateValue(){
		return getBalance() * (1 + interest);
	}
	public String toString(){
		return String.format("CheckingAccount_Balance: %.2f", getBalance());
	}
	
	public void passTime(int time){
		if(getBalance() < 0){
			changeBalance(getBalance() * (1 + (loan_interest * time)));
		} else {
			changeBalance(getBalance() * (1 + (interest * time)));
		}
	}
	public void passTime(){
		if(getBalance() < 0){
			changeBalance(getBalance() * (1 + (loan_interest * 1)));
		} else {
			changeBalance(getBalance() * (1 + (interest * 1)));
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
