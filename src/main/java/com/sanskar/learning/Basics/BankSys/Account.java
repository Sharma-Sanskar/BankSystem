package com.sanskar.learning.Basics.BankSys;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public String getDateAndTime() {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formatted = timeStamp.format(formatter); // formatted date and time
        return timeStamp.format(formatter);
    }


    public ArrayList<String> transactionHistory = new ArrayList<>();
    final private int accNum;
    private String name;
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
        String log = "Amount withdrawn: " + amount + "\n" + "Remaining Balance: " + getBalance() + "\n" + "Time: " + getDateAndTime() + "\n";
        System.out.println(log);
        transactionHistory.add(log);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited amount: " + amount);
        System.out.println("New balance: " + balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
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

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public void accDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Account No.: " + getAccNum());
        System.out.println("Balance: " + getBalance());
    }
}
