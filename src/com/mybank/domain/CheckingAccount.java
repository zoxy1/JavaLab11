package com.mybank.domain;

public class CheckingAccount extends Account {
    
       
    public CheckingAccount(double initBalance, double overdraftAmount) {
	super(initBalance);
	super.setOverdraftAmount(overdraftAmount);
	super.setCurrentOverdraftAmount(overdraftAmount);
    }

   
    public CheckingAccount(double initBalance) {
	super(initBalance);
	setOverdraftAmount(0.0d);
    }

    public boolean withdraw(double amt) {

	boolean result = false;
	
	if(super.GetOverdraftAmount()<=0){
	    result=super.withdraw(amt);
	}
 else {
	    if (super.getBalance() >= 0) {
		if (amt <= super.getBalance() + super.getCurrentOverdraftAmount()) {
		    if (amt > super.getBalance()) {
			super.setCurrentOverdraftAmount(super.getCurrentOverdraftAmount()-amt + super.getBalance());
		    }
		    result = super.setBalance(super.getBalance() - amt);
		    
		}
	    } else {
		
		  if(amt<=super.getCurrentOverdraftAmount()){
		  result=super.setBalance(super.getBalance()-amt);
		  
		  super.setCurrentOverdraftAmount(super.getCurrentOverdraftAmount()-amt); 
		  }
		 
	    }
	}
	
	return result;
    }
    public boolean deposit (double amt){
	super.setBalance(super.getBalance()+amt);
	if(super.getBalance()<0){
	    super.setCurrentOverdraftAmount(super.GetOverdraftAmount()+super.getBalance());
	}
	else{
	    
	    super.setCurrentOverdraftAmount(500.0d);   
	}
	
	
	return true;
    }
}
