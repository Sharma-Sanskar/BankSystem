package com.sanskar.learning.Basics;

import com.sanskar.learning.Basics.BankSys.*;

import java.util.Scanner;

public class BankSystem {

    private static void pause(Scanner sc) { // helps cli to stop a second before running away
        System.out.println("Press Enter to continue");
        sc.nextLine();
        sc.nextLine();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank b1 = new Bank();
        b1.loadDataFromFile();
//        pause(sc);

        System.out.println("Welcome to your Bank!");
        System.out.println("Enter your Acc no.");
        int accNum = sc.nextInt();
        sc.nextLine(); // Consume /n from above input

        System.out.println("Enter your Password");
        String accPassword = sc.nextLine();


        Account acc = b1.userAuth(accNum, accPassword);
        if (acc instanceof Admin) {
            ((Admin) acc).controlPanel(b1);
            return;
        }

        if (acc == null) {
            System.out.println("Account not found, create one?: Y/N");
            String option = sc.next().trim().toLowerCase();

            if (option.equals("y")) {
                accNum = b1.createAcc(); // Create account, Store Account Number
                pause(sc);
                acc = b1.searchAcc(accNum); // search Account based on Acc Num
            } else {
                System.out.println("Visit again!");
                return;
            }
        }


        if (acc == null) {
            System.out.println("Account not found");
        } else {
            int choice;
            do {
                System.out.println("What do you want to do?");
                System.out.println("1. Print Account details.");
                System.out.println("2. Withdraw Amount.");
                System.out.println("3. Deposit Amount.");
                System.out.println("4. Delete Account.");
                System.out.println("0. Exit Application.");
                choice = sc.nextInt();
                int amount;
                switch (choice) {
                    case 0:
                        System.out.println("Thanks, visit again! ");
                        break;
                    case 1:
                        acc.accDetails();
                        pause(sc);
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw: ");
                        amount = sc.nextInt();
                        acc.withdraw(amount);
//                        b1.saveDataToFile();
                        pause(sc);
                        break;
                    case 3:
                        System.out.println("Enter amount to deposit");
                        amount = sc.nextInt();
                        acc.deposit(amount);
//                        b1.saveDataToFile();
                        pause(sc);
                        break;
                    case 4:
                        System.out.println("Do you wish to delete your account?");
                        System.out.print("Enter your account number to continue: ");
                        int accNumber = sc.nextInt();
                        if (accNumber == acc.getAccNum()) {
                            b1.deleteAcc(acc.getAccNum());
                            return;
                        } else {
                            System.out.println("Wrong acc number.");
                        }
                        b1.saveDataToFile();
                        pause(sc);
                        break;
                }
                System.out.println(acc.transactionHistory);
            } while (choice != 0);
            b1.saveDataToFile();
        }
    }
}
