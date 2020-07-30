package com.wipro.ccbill.entity;
import java.util.Date;

import com.wipro.ccbill.exception.InputValidationException;
public class CreditCardBill {
private String creditCardNo;
private String customerId;
private Date billDate;
private Transaction monthTransactions[];
public CreditCardBill() {
	super();
}
public CreditCardBill(String creditCardNo,String customerId,Date billDate,Transaction monthTransactions[])
{
	this.creditCardNo=creditCardNo;
	this.customerId=customerId;
	this.billDate=this.billDate;
	this.monthTransactions=monthTransactions;
}
public double getTotalAmount(String transactionType) {
	double amount=0.0;
	if(!(transactionType.equals("DB")|| transactionType.equals("CR"))) {
		return 0.0;
	}
	else {
		for(int i=0;i<monthTransactions.length;i++) {
			if(monthTransactions[i].getTransactionType().equals(transactionType)) {
				amount=amount+monthTransactions[i].getTransactionAmount();
			}
		}
		return amount;
	}
}
public double calculateBillAmount()  {
	try {
	double db=0.0,cr=0.0,diff,intrest;
	if(validateDate().equals("valid")) {
		if(monthTransactions.length>0) {
			db=getTotalAmount("DB");
			cr=getTotalAmount("CR");
			diff=db-cr;
			intrest=(diff*19.9/100)/12;
			return intrest+diff;
		}
		else
			return 0.0;
		
	}
	}catch(InputValidationException e) {
		return 0.0;
	}
	return 0.0;
}
public String validateDate() throws InputValidationException{
	if(creditCardNo!=null && creditCardNo.length()==16) {
		if(customerId!=null && customerId.length()>=6) {
			return "valid";
		}
	}
	else {
		throw new InputValidationException();
	}
	return "invalid";
	
}
}
