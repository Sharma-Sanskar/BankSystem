package com.sanskar.learning.Basics;
import com.sanskar.learning.Basics.BankSys.*;

import java.util.Locale;
import java.util.Scanner;

public class Main2  {
    public static void main(String[] args) {
        int choice;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to your Bank!");
            System.out.println("Enter your Acc no.");
            Bank b1 = new Bank();
            int acc = sc.nextInt();
            Account currentAcc = b1.searchAcc(acc);

            if(currentAcc == null){
                System.out.println("Account not found, create one?: Y/N");
                String option = sc.next().trim().toLowerCase();

                if (option.equals("y")){
                    int accNum = b1.createAcc(); // Create a new Account and store it's newly created account number to accNum
                    Account current = b1.searchAcc(accNum);
                }
                else {
                    System.out.println("Visit again!");
                }
            }


            System.out.println("What do you want to do?");
            System.out.println("1. Print Account details.");
            choice = sc.nextInt();
            switch (choice){
                case 1:
//                    currentAcc
            }
        }while(choice != 0);

    }
}
