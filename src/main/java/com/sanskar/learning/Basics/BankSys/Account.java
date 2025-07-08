package com.sanskar.learning.Basics.BankSys;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    final private int accNum;
    private final String name;
    private double balance;
    private String password;

    Account(String name, double balance, int accNum, String password) {
        this.name = name;
        this.balance = balance;
        this.accNum = accNum;
        this.password = password;
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient Balance");
            return;
        }
        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
        System.out.println("Remaining Balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited amount: " + amount);
        System.out.println("New balance: " + balance);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNum() {
        return accNum;
    }

    public String getPassword() {
        return password;
    }

    public void accDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Account No.: " + getAccNum());
        System.out.println("Balance: " + getBalance());
    }
}
