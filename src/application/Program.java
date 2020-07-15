package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Enter Contract data");
		
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Date ( dd/mm/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		
		System.out.print("Enter number of installments: ");
		int months = sc.nextInt();
		sc.nextLine();
		
		Contract contract = new Contract(number, date, totalValue);
		
		ContractService cs = new ContractService(new PaypalService());
		
		cs.processContract(contract, months);
		
		System.out.println(contract);
		
		sc.close();
		

	}

}
