
import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args){
		CheckingAccount acc1 = new CheckingAccount(100.0, 50.0, 0.01, 0.07);
		SavingAccount acc2 = new SavingAccount(100,0.05);
		Scanner scan = new Scanner(System.in);
		double amount;
		
		System.out.printf("Account1 balance: $ %.2f\t 현재 출금 가능액: $ %.2f\n",acc1.getBalance(), acc1.getWithdrawableAccount());
		System.out.println("Enter withdrawal amount for Account1: ");
		amount = scan.nextDouble();
		acc1.debit(amount);
		System.out.printf("Account1 balance: $ %.2f\t 현재 출금 가능액: $ %.2f\n",acc1.getBalance(), acc1.getWithdrawableAccount());
		if(acc1.isBankrupted()){
			System.out.println("account1 went Bankrupt! \n");
		}
		acc1.passTime(1);
		System.out.printf("Account1 balance: $ %.2f\t 현재 출금 가능액: $ %.2f\n",acc1.getBalance(), acc1.getWithdrawableAccount());
		if(acc1.isBankrupted()){
			System.out.println("account1 went Bankrupt! \n");
		}	
		acc1.passTime(5);
		System.out.printf("Account1 balance: $ %.2f\t 현재 출금 가능액: $ %.2f\n",acc1.getBalance(), acc1.getWithdrawableAccount());
		if(acc1.isBankrupted()){
			System.out.println("account1 went Bankrupt! \n");
		}
		
		System.out.println();
		System.out.printf("Account2 balance: $ %.2f \t현재 출금 가능액: $ %.2f\n",acc2.getBalance(),acc2.getWithdrawableAccount());
		
		System.out.println("6 Month later!");
		acc2.passTime(6);
		System.out.printf("Account2 balance: $ %.2f \t현재 출금 가능액: $ %.2f\n",acc2.getBalance(),acc2.getWithdrawableAccount());
		acc2.debit(50);
		
		System.out.println("next 6 Month later!");
		acc2.passTime(6);
		System.out.printf("Account2 balance: $ %.2f \t현재 출금 가능액: $ %.2f\n",acc2.getBalance(),acc2.getWithdrawableAccount());
		
		System.out.println("next 1 Month later!");
		acc2.passTime(1);
		System.out.printf("Account2 balance: $ %.2f \t현재 출금 가능액: $ %.2f\n",acc2.getBalance(),acc2.getWithdrawableAccount());
		acc2.debit(50);
		
		System.out.printf("Account2 balance: $ %.2f \t현재 출금 가능액: $ %.2f\n",acc2.getBalance(),acc2.getWithdrawableAccount());
		
	}
};