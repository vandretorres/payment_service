package model.services;

public interface OnlinePaymentService {
	
	public Double payment(Double amount);
	public Double interest(Double amount, Integer months);

}
