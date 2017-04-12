import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args){
		Account acc1 = new CheckingAccount(100.0, 50.0, 0.01, 0.07);
		Account acc2 = new SavingAccount(100,0.05);
		Scanner scan = new Scanner(System.in);
		double amount;
		try{

			System.out.println("Enter deposit amount for Account1: ");
			amount = scan.nextDouble();
			acc1.debit(amount);
			System.out.println("Account1 balance: $"+acc1.getBalance());

			System.out.println("Enter deposit amount for Account1: ");
			amount = scan.nextDouble();
			acc2.debit(amount);
			System.out.println("Account1 balance: $"+acc2.getBalance());
			
		}catch(InputMismatchException ex){
			System.out.println("예외발생 : 숫자를 입력하세요\n" + ex.toString());
		}catch(Exception ex){
			System.out.println("예외발생:  " + ex.toString());
		}finally{
			acc1.passTime(2);
			System.out.println("2 month later account1 : " + acc1.getBalance());
		}
	}
};