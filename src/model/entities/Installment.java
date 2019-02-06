package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dueDat;
	private Double amount;
	
	public Installment(Date dueDat, Double amount) {
		this.dueDat = dueDat;
		this.amount = amount;
	}

	public Date getDueDat() {
		return dueDat;
	}

	public void setDueDat(Date dueDat) {
		this.dueDat = dueDat;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return sdf.format(dueDat) + " - " + String.format("%.2f", amount);
	}
}
