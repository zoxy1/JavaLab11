package com.mybank.test;

import com.mybank.domain.*;

public class TestBanking {

  public static void main(String[] args) {
    Bank bank = new Bank();
    Customer customer;
    Account account;

    //
    // �������� �������� ����� � �� ������
    //

    System.out.println("�������� ������� Jane Simms.");
    bank.addCustomer("Jane", "Simms");
    customer = bank.getCustomer(0);
    System.out.println("�������� �� ����� ���� �������������� ���� � ��������� �������� 500.00 � ������� 3%");
    customer.setAccount(new SavingsAccount(500.00, 0.03));

    System.out.println("�������� ������� Owen Bryant.");
    bank.addCustomer("Owen", "Bryant");
    customer = bank.getCustomer(1);
    System.out.println("�������� ��� ����� ���� �� ������������� � ��������� �������� 500.00 ��� ����������.");
    customer.setAccount(new CheckingAccount(500.00));

    System.out.println("�������� ������� Tim Soley.");
    bank.addCustomer("Tim", "Soley");
    customer = bank.getCustomer(2);
    System.out.println("�������� ��� ����� ���� �� ������������� � ��������� �������� 500.00 � � ����. ����������� 500.00");
    customer.setAccount(new CheckingAccount(500.00, 500.00));

    System.out.println("�������� ������� Maria Soley.");
    bank.addCustomer("Maria", "Soley");
    customer = bank.getCustomer(3);
    System.out.println("Maria ����� ���������� ���� �� ������������� � ����� �� ����� Tim.");
    customer.setAccount(bank.getCustomer(2).getAccount());

    System.out.println();

    //
    // ������������� ��������� ������ ���������� ����
    //

    // ��������� ����������� �������������� ����
    System.out.println("������. ���������� � ������� Jane Smith � �� ����� ���� �������������� ����.");
    customer = bank.getCustomer(0);
    account = customer.getAccount();
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ��������� ������: " + account.getBalance());
    // ��������� ���������� ��� ������ 
    System.out.println("��������� ���������� ��� ������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("������ 150.00: " + account.withdraw(150.00));
    System.out.println("�������� 22.50: " + account.deposit(22.50));
    System.out.println("������ 47.62: " + account.withdraw(47.62));
    System.out.println("������ 400.00: " + account.withdraw(400.00));
    // ������ ��������� ������� ����� ���������� 
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ������: " + account.getBalance());

    System.out.println();

    // ��������� ���� �� ������������� ��� ����������
    System.out.println("������. ���������� � ������� Owen Bryant � ��� ����� �� ������������� ��� ����������.");
    customer = bank.getCustomer(1);
    account = customer.getAccount();
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ��������� ������: " + account.getBalance());
    // ��������� ���������� ��� ������
    System.out.println("��������� ���������� ��� ������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("������ 150.00: " + account.withdraw(150.00));
    System.out.println("�������� 22.50: " + account.deposit(22.50));
    System.out.println("������ 47.62: " + account.withdraw(47.62));
    System.out.println("������ 400.00: " + account.withdraw(400.00));
    // ������ ��������� ������� ����� ���������� 
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ������: " + account.getBalance());

    System.out.println();

    // ��������� ���� �� ������������� � �����������
    System.out.println("������. ���������� � ������� Tim Soley � ��� ����� �� ������������� � �����������.");
    customer = bank.getCustomer(2);
    account = customer.getAccount();
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ��������� ������: " + account.getBalance()+", ��������� ��������:"+account.GetOverdraftAmount());
    // ��������� ���������� ��� ������
    System.out.println("��������� ���������� ��� ������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("������ 150.00: " + account.withdraw(150.00));
    System.out.println("�������� 22.50: " + account.deposit(22.50));
    System.out.println("������ 47.62: " + account.withdraw(47.62));
    System.out.println("������ 400.00: " + account.withdraw(400.00));
  //System.out.println("������ 400.00: " + account.withdraw(400.00));
  //System.out.println("������ 50.00: " + account.withdraw(50.00));
  //System.out.println("������ 600.00: " + account.deposit(600.00));
    
    // ������ ��������� ������� ����� ���������� 
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ������: " + account.getBalance()+", ��������� ������� ���������:"+account.getCurrentOverdraftAmount());

    System.out.println();

    // ��������� ���� �� ������������� � �����������
    System.out.println("������. ���������� � ������� Maria Soley � �� ���������� ����� �� ������������� � ����� �� ����� Tim.");
    customer = bank.getCustomer(3);
    account = customer.getAccount();
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ��������� ������: " + account.getBalance());
    // ��������� ���������� ��� ������
    System.out.println("��������� ���������� ��� ������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("�������� 150.00: " + account.deposit(150.00));
    System.out.println("������ 750.00: " + account.withdraw(750.00));
    // ������ ��������� ������� ����� ���������� 
    System.out.println("������ [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] ����� ������: " + account.getBalance());

  }
}
