package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
public boolean validate(int currentReading,int previousReading,String type) throws InvalidReadingException,InvalidConnectionException
{
if(currentReading<previousReading || currentReading<0 || previousReading<0) {
	throw new InvalidReadingException();
}
	else {
if(!(type.equals("commercial" )|| type.equals("domestic"))) {
	throw new InvalidConnectionException();
}
else
	return true;
}
}
public float calculateBillAmt(int currentReading,int previousReading,String type) {
	float amt=0.0f;
	try {
		if(validate(currentReading,previousReading,type)==true) {
			if(type.equals("domestic")) {
				float[] slabs = {2.3f, 4.2f, 5.5f};
				Domestic c=new Domestic(currentReading,previousReading,slabs);
				amt=c.computeBill();
			}
			else if(type.equals("commercial")){
				float[] slabs= {5.2f, 6.8f, 8.3f};
				Commercial c=new Commercial(currentReading,previousReading,slabs);
			   amt=c.computeBill();
		}
			return amt;
		}
		else {
			return 0.0f;
		}
		
	}catch(InvalidReadingException e) {
		return -1;
	}
	catch(InvalidConnectionException c) {
		return -2;
	}
}
public String generateBill(int currentReading,int previousReading,String type) {
	float res=calculateBillAmt(currentReading,previousReading,type);
	if(res==-1) {
		return "Incorrect Reading";
	}
	else if(res==-2) {
		return "Invalid connection type";
	}
	else
		return "Amount to be paid:"+res;
}
}
