package com.mybank.domain;


public class SavingsAccount extends Account{

    private double interestRate=0;
    
public SavingsAccount(double initBalance,double interestRate) {
	super(initBalance);
	this.interestRate=interestRate;
    }

}
