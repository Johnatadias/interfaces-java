package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double quota = contract.getTotalValue() / months;
		
		for(int i=1; i<= months; i++) {
			Date date = addMonth(contract.getDate(), i);
			double quota1 = quota + onlinePaymentService.interest(quota, i);
			double quota2 = quota1 + onlinePaymentService.paymentFee(quota1);
			contract.addList(new Installment(date, quota2));
		}
	}
	
	public Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
