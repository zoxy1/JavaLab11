package com.mybank.domain;

public class Account {

     private double balance;
     private double overdraftAmount;
     private double currentOverdraftAmount;
     
     Account(double initBalance) {
	balance=initBalance;
	
    }
    public void setOverdraftAmount(double overdraftAmount) {
	this.overdraftAmount=overdraftAmount;
	
    }
    public double GetOverdraftAmount() {
	
	return overdraftAmount;
    }
    public double getBalance() {
	
	return balance;
    }

    public boolean setBalance(double balance) {
	this.balance=balance;
	return true;
    }
    public boolean deposit (double amt){
	this.balance=balance+amt;
	return true;
    }
    public boolean withdraw(double amt){
	
        if((amt>0)&&(amt <= balance)){
            balance = balance - amt;
            return true;
        }
        else{
            return false;    
        }
        
    }
    public double getCurrentOverdraftAmount() {
	return currentOverdraftAmount;
    }
    public void setCurrentOverdraftAmount(double currentOverdraftAmount) {
	this.currentOverdraftAmount = currentOverdraftAmount;
    }

}
