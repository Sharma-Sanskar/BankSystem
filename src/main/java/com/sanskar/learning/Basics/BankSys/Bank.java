package com.sanskar.learning.Basics.BankSys;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    Scanner sc = new Scanner(System.in);

    private ArrayList<Account> accounts = new ArrayList<>(); // Store all accounts
    private int initialAccountNum = 100;

    public int createAcc() {

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Deposit initial balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        System.out.println("Create a new Password");
        String password = sc.nextLine();

//        int accNum = (int)(Math.random() * 900) + 100; // random 3 digit, redundant
        int accNum = initialAccountNum++;
//        initialAccountNum++;
        Account a1 = new Account(name, balance, accNum, password);

        accounts.add(a1); // Add the newly created account to the arrayList

        System.out.println("Account created successfully");
        System.out.println("Details: ");
        a1.accDetails();
        return accNum;
    }

    public Account userAuth(int accNum, String password) {
        for (Account acc : accounts) {
            if (acc.getAccNum() == accNum && acc.getPassword().equals(password)) {
                System.out.println("Welcome " + acc.getName());
                return acc;
            }
        }
        return null;
    }

    public void loadBankData() {

    }

    public void deleteAcc(int accNum) {
        Account acc = searchAcc(accNum);
        if (acc != null) {
            accounts.remove(acc);
            System.out.println("Account deleted Successfully!");
        } else {
            System.out.println("account not found!");
        }
    }

    public Account searchAcc(int accNum) {
        for (Account account : accounts) {
            if (account.getAccNum() == accNum) {
                return account;
            }
        }
        return null;
    }

}
