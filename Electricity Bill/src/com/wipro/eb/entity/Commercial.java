package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int currentReading, int previousReading,float slabs[]){
		super(currentReading, previousReading, slabs);
	}
  public float computeBill(){
	  float bill=0.0f;
	  int units=currentReading-previousReading;
	  if(units<=50) {
		bill=bill+units*slabs[0];  
	  }
	  else if(units>50 &&units<=100){
		bill=bill+(50*slabs[0])+((units-50)*slabs[1]);
	  }
	  else {
	  int first=units-50;
	  bill=bill+slabs[0]*(units-50);
	  int second=first-50;
	  bill=bill+slabs[1]*(first-50);
	  bill=bill+slabs[2]*second;
  }
	  if(bill>=10000){
			return bill*1.09f;
		} else if(bill>=5000){
			return bill*1.06f;
		} else {
			return bill*1.02f;
		}
  }
}
