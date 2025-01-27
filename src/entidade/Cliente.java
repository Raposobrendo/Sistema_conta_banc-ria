package entidade;

import java.util.Scanner;

public class Cliente {
	private String name;
	private int account;
	private double balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (this.name == null) {
			this.name = name;
		} else {
			System.out.printf("Name exists, change name? (y/n): ");
			Scanner sc = new Scanner(System.in);
			char changeName = sc.next().charAt(0);
			while (changeName != 'y' || changeName != 'n') {
				if (changeName == 'y') {
					System.out.printf("Enter new name: ");
					name = sc.next();
					this.name = name;
					break;
				} else if (changeName == 'n') {
					System.out.printf("Name wasn't changed.");
					break;
				} else {
					System.out.printf("Wrong input, try again");
					changeName = sc.next().charAt(0);
				}
			}
			sc.close();
		}
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		if (this.account == 0) {
			this.account = account;
		} else {
			System.out.printf("Numero de conta j� existente");
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public void accountData() {
		System.out.printf("Account %d, Holder %s, Balance $ %.2f.", getAccount(), getName(), getBalance());
	}

	public void initialDeposit() {
		System.out.printf("Is there a first deposit? (y/n): ");
		Scanner scan = new Scanner(System.in);
		char first = scan.next().charAt(0);
		while (first != 'y' || first != 'n') {
			if (first == 'y') {
				System.out.printf("Enter initial deposit value: ");
				double deposit1 = scan.nextDouble();
				this.balance += deposit1;
				break;
			} else if (first == 'n') {
				this.balance += 0;
				break;
			} else {
				System.out.printf("Wrong input, try again");
				first = scan.next().charAt(0);
			}
		}
	}
	
	public void changeBalance(){
		System.out.printf("\nDo you want to do deposit, withdraw or exit?\n");
		System.out.printf("1 - Deposit\n2 - Withdraw\n3 - Exit\n");
		Scanner sc = new Scanner(System.in);
		int decision = sc.nextInt();
		while (decision != 1 || decision != 2 || decision != 3 ) {
			if (decision == 1) {
				System.out.println("How much to deposit?");
				double deposit = sc.nextDouble();
				this.balance += deposit;
				accountData();
				System.out.println("\nChoose another operation or exit");
				System.out.printf("1 - Deposit\n2 - Withdraw\n3 - Exit\n");
				decision = sc.nextInt();
			}
			else if (decision == 2) {
				System.out.println("How much to withdraw? (Charge of 5$) ");
				double withdraw = sc.nextDouble();
				this.balance -= withdraw + 5;
				accountData();
				System.out.println("\nChoose another operation or exit");
				System.out.printf("1 - Deposit\n2 - Withdraw\n3 - Exit\n");
				decision = sc.nextInt();
			}
			else if (decision == 3) {
				break;
			}
			else {
				System.out.println("Invalid choice, enter another option.");
				decision = sc.nextInt();
			}
		}
		sc.close();
		sc.close();
	}
}