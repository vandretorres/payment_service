package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	OnlinePaymentService onlinePaymentService;

	public ContractService() {

	}

	public ContractService(OnlinePaymentService onlinePaymentService) {

		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {


		double dueAmount = contract.getTotalValue() / months;
		for ( int i = 1 ; i <= months; i++) {

			Date dueDate = addMonths(contract.getDate(),i);			
			double sum = dueAmount + onlinePaymentService.interest(dueAmount, i);
			sum += onlinePaymentService.payment(sum);
			contract.addInstallment(new Installment(dueDate, sum));

		}


	}


	private Date addMonths(Date date , int n) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);		
		return cal.getTime();
	}




}
