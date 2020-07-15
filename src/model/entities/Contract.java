package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	Integer number;
	Date date;
	Double totalValue;
	
	List<Installment> installment = new ArrayList<>();

	public Contract() {
	
	}

	public Contract(Integer number, Date date, Double totalValue) {
		
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		
	}

	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

	public void setInstallment(List<Installment> installment) {
		this.installment = installment;
	}
	
	public void addInstallment(Installment ins) {
		
		installment.add(ins);
		
	}
	
	public void removeInstallment(Installment ins) {
		
		installment.remove(ins);
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String st = "Installments \n";
		
		for (Installment i : installment) {
			
			st += sdf.format(i.getDueDate()) + " - " + String.format("%.2f", i.getAmount()) + "\n";
			
			
		}
				
		return st;
	}
	
	
	
	
	
	

}
