package aplicação;

import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;

public class SysBank {
	public static void SysBanc() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Cliente cliente = new Cliente();
		
		System.out.println("Welcome to The Bank, enter the info needed to open an account.");
		System.out.printf("Enter your account number: ");
		int account = sc.nextInt();
		cliente.setAccount(account);
		
		System.out.printf("Enter your name: ");
		sc.nextLine();
		String name = sc.next();
		cliente.setName(name);
		
		cliente.initialDeposit();
		
		cliente.accountData();
		
		cliente.changeBalance();
		
		System.out.println("======= END =======");
		sc.close();
	}
}