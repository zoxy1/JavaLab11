package com.mybank.test;

import com.mybank.domain.*;

public class TestBanking {

  public static void main(String[] args) {
    Bank bank = new Bank();
    Customer customer;
    Account account;

    //
    // Создание клиентов банка и их счетов
    //

    System.out.println("Создание клиента Jane Simms.");
    bank.addCustomer("Jane", "Simms");
    customer = bank.getCustomer(0);
    System.out.println("Создание ее счета вида Сберегательный счет с начальным балансом 500.00 и ставкой 3%");
    customer.setAccount(new SavingsAccount(500.00, 0.03));

    System.out.println("Создание клиента Owen Bryant.");
    bank.addCustomer("Owen", "Bryant");
    customer = bank.getCustomer(1);
    System.out.println("Создание его счета вида До востребования с начальным балансом 500.00 без овердрафта.");
    customer.setAccount(new CheckingAccount(500.00));

    System.out.println("Создание клиента Tim Soley.");
    bank.addCustomer("Tim", "Soley");
    customer = bank.getCustomer(2);
    System.out.println("Создание его счета вида До востребования с начальным балансом 500.00 и с макс. овердрафтом 500.00");
    customer.setAccount(new CheckingAccount(500.00, 500.00));

    System.out.println("Создание клиента Maria Soley.");
    bank.addCustomer("Maria", "Soley");
    customer = bank.getCustomer(3);
    System.out.println("Maria имеет совместный счет До востребования с мужем по имени Tim.");
    customer.setAccount(bank.getCustomer(2).getAccount());

    System.out.println();

    //
    // Демонстрирует поведение счетов различного вида
    //

    // Тестируем стандартный Сберегательный счет
    System.out.println("Извлеч. информации о клиенте Jane Smith и ее счете вида Сберегательный счет.");
    customer = bank.getCustomer(0);
    account = customer.getAccount();
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет начальный баланс: " + account.getBalance());
    // Выполняем транзакции над счетом 
    System.out.println("Выполняем транзакции над счетом [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("Снятие 150.00: " + account.withdraw(150.00));
    System.out.println("Внесение 22.50: " + account.deposit(22.50));
    System.out.println("Снятие 47.62: " + account.withdraw(47.62));
    System.out.println("Снятие 400.00: " + account.withdraw(400.00));
    // Печать конечного баланса после транзакций 
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет баланс: " + account.getBalance());

    System.out.println();

    // Тестируем счет До востребования без овердрафта
    System.out.println("Извлеч. информации о клиенте Owen Bryant и его счете До востребования без овердрафта.");
    customer = bank.getCustomer(1);
    account = customer.getAccount();
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет начальный баланс: " + account.getBalance());
    // Выполняем транзакции над счетом
    System.out.println("Выполняем транзакции над счетом [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("Снятие 150.00: " + account.withdraw(150.00));
    System.out.println("Внесение 22.50: " + account.deposit(22.50));
    System.out.println("Снятие 47.62: " + account.withdraw(47.62));
    System.out.println("Снятие 400.00: " + account.withdraw(400.00));
    // Печать конечного баланса после транзакций 
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет баланс: " + account.getBalance());

    System.out.println();

    // Тестируем счет До востребования с овердрафтом
    System.out.println("Извлеч. информации о клиенте Tim Soley и его счете До востребования с овердрафтом.");
    customer = bank.getCustomer(2);
    account = customer.getAccount();
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет начальный баланс: " + account.getBalance()+", начальный оведрафт:"+account.GetOverdraftAmount());
    // Выполняем транзакции над счетом
    System.out.println("Выполняем транзакции над счетом [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("Снятие 150.00: " + account.withdraw(150.00));
    System.out.println("Внесение 22.50: " + account.deposit(22.50));
    System.out.println("Снятие 47.62: " + account.withdraw(47.62));
    System.out.println("Снятие 400.00: " + account.withdraw(400.00));
  //System.out.println("Снятие 400.00: " + account.withdraw(400.00));
  //System.out.println("Снятие 50.00: " + account.withdraw(50.00));
  //System.out.println("Внести 600.00: " + account.deposit(600.00));
    
    // Печать конечного баланса после транзакций 
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет баланс: " + account.getBalance()+", доступный текущий овердрафт:"+account.getCurrentOverdraftAmount());

    System.out.println();

    // Тестируем счет До востребования с овердрафтом
    System.out.println("Извлеч. информации о клиенте Maria Soley и ее совместном счете До востребования с мужем по имени Tim.");
    customer = bank.getCustomer(3);
    account = customer.getAccount();
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет начальный баланс: " + account.getBalance());
    // Выполняем транзакции над счетом
    System.out.println("Выполняем транзакции над счетом [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "]:");
    System.out.println("Внесение 150.00: " + account.deposit(150.00));
    System.out.println("Снятие 750.00: " + account.withdraw(750.00));
    // Печать конечного баланса после транзакций 
    System.out.println("Клиент [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] имеет баланс: " + account.getBalance());

  }
}
