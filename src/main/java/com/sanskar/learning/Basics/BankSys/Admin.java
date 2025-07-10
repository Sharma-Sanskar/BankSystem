package com.sanskar.learning.Basics.BankSys;

import java.util.Scanner;

public class Admin extends Account {
    Scanner sc = new Scanner(System.in);
    private int accNum = 999;
    private String password = "root";

    Admin() {
        super("Admin", 0, 999, "root");
    }

    public static boolean adminAccountAccess(int accNum, String password) {
        return (accNum == 999) && password.equals("root");
    }

    public int getAccNum() {
        return accNum;
    }

    public void updateAdmin(int adminNum, String adminPassword) {
        accNum = adminNum;
        password = adminPassword;
    }

    public String getPassword() {
        return password;
    }

    public void handleAccountDetails(Bank bank) {
        System.out.println("Enter Account number to check details: \n 1 to search by name");
        int accNum = sc.nextInt();
        Account selectedACC;

        if (accNum == 1) {
            System.out.println("Enter Name");
            String name = sc.next();
            selectedACC = bank.searchAccByName(name);

        } else {
            selectedACC = bank.searchAcc(accNum);
        }
        if (selectedACC == null) {
            System.out.println("Account doesn't exist.");
            return;
        }
        System.out.println("Account Selected: ");
        selectedACC.accDetails();
        System.out.println("_____________________");
        System.out.println("Do you want to update this Account's details?: Y/N");
        String yes = sc.next().toLowerCase();
        if (yes.equalsIgnoreCase("y")) {
            int flag;
            do {
                System.out.println("1. Update Name: ");
                System.out.println("2. Delete Account: ");
                System.out.println("3. Change Password: ");
                System.out.println("4. Update Admin Details");
                System.out.println("0. Accept Changes: ");
                flag = sc.nextInt();
                switch (flag) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> {
                        System.out.println("Current Name: ");
                        System.out.println(selectedACC.getName());
                        System.out.print("Enter New Name : ");
                        String newName = sc.nextLine();
                        selectedACC.setName(newName);
                    }
                    case 2 -> {
                        System.out.println("Are you Sure? : 1/0");
                        int confirm = sc.nextInt();
                        if (confirm == 1) {
                            bank.deleteAcc(selectedACC.getAccNum());
                        }
                    }
                    case 3 -> {
                        System.out.println("Old password: ");
                        System.out.println(selectedACC.getPassword());
                        System.out.println("Update? Y/N");
                        String confirm = sc.next();
                        if (confirm.equalsIgnoreCase("y")) {
                            System.out.println("Enter new Password");
                            String newPassword = sc.next();
                            System.out.println("Confirm?: Y/N");
                            confirm = sc.next();
                            if (confirm.equalsIgnoreCase("y")) {
                                selectedACC.setPassword(newPassword);
                                System.out.println("Password updated successfully");
                            }
                        }
                    }
                    case 4 -> updateAdmin(999, "root");
                }
            } while (true);
        }
    }

    public void getTransactionDetails(Bank bank) {
        System.out.println("All transaction Details below:");
        for (Account acc : bank.getAccounts()) {
            System.out.println("Transaction History of account: " + acc.getAccNum() + "\n" + acc.getName());
            if (acc.transactionHistory.isEmpty()) {
                System.out.println("No transactions");
                System.out.println("______________________");
            } else {
                System.out.println("Total Transactions: " + acc.transactionHistory.size());
                for (String transaction : acc.transactionHistory) {
                    System.out.println(transaction);
                }
                System.out.println("_______________________");
            }
        }
    }

    public void printAllAccounts(Bank bank) {
        System.out.println("All accounts listed below:");
        for (Account acc : bank.getAccounts()) {
            acc.accDetails();
        }
    }


    public void controlPanel(Bank bank) {
        System.out.println("Welcome Admin");
        System.out.println("What are we going to do today?");
        System.out.println("1. See All Accounts");
        System.out.println("2. See all transactions of an Account");
        System.out.println("3. Check account details.");
        int choice;
        do {
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> printAllAccounts(bank);
                case 2 -> getTransactionDetails(bank);
                case 3 -> handleAccountDetails(bank);
            }

        } while (choice != 0);
    }

}
