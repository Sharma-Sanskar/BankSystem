package com.sanskar.learning.Basics;
import com.sanskar.learning.Basics.BankSys.*;

import java.util.Locale;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to your Bank!");
        System.out.println("Enter your Acc no. and password");
        Bank b1 = new Bank();
        int acc = sc.nextInt();
        Account currentAcc = b1.searchAcc(acc);

        if(currentAcc == null){
            System.out.println("Account not found, create one?: Y/N");
            String option = sc.next().trim().toLowerCase();

            if (option.equals("y")){
                b1.createAcc();
            }
            else {
                System.out.println("Visit again!");
            }
        }

        int choice = 0;
        do{
            System.out.println("What do you want to do?");
            System.out.println("1. Print Account details.");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    currentAcc
            }
        }while(choice != 0);

    }
}
