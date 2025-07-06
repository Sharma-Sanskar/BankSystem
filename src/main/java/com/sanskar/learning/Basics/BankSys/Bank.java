package com.sanskar.learning.Basics.BankSys;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void createAcc(){

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Deposit initial balance: ");
        double balance = sc.nextDouble();

        int accNum = (int)(Math.random() * 900) + 100;
        Account a1 = new Account(name, balance,accNum);
        accounts.add(a1);

        System.out.println("Account created successfully");
        System.out.println("Details: ");
        a1.accDetails();
    }

    public Account searchAcc(int accNum){

        for (Account account : accounts) {
            if (account.getAccNum() == accNum) {
                return account;
            }
        }
        return null;
    }


}
