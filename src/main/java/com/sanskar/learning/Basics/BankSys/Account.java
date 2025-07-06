package com.sanskar.learning.Basics.BankSys;

public class Account {
    final private int accNum;
    protected String name;
    protected double balance;

    Account(String name, double balance,int accNum){
        this.name = name;
        this.balance = balance;
        this.accNum = accNum;
    }

    protected void withdraw(double amount){
        if (balance < amount){
            System.out.println("Insufficient Balance");
            return;
        }
        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
        System.out.println("Remaining Balance: " + balance);
    }

    protected void deposit(double amount){
        balance += amount;
        System.out.println("Deposited amount: " + amount);
        System.out.println("New balance: " + balance);
    }

    public double getBalance(){
        return balance;
    }

    public int getAccNum(){
        return accNum;
    }
    protected void accDetails(){
        System.out.println("Name: " + name);
        System.out.println("Account No.: " + accNum);
        System.out.println("Balance: "+ balance);
    }
}
