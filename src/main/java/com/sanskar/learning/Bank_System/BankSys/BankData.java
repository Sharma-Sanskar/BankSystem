package com.sanskar.learning.Bank_System.BankSys;


import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

// This to save data needed for new test runs
public class BankData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Store version ID
    public ArrayList<Account> accounts; // Only initialize accounts arraylist
    //    public ArrayList<String> transactionHistory;
    public int initialAccountNum;

    BankData(ArrayList<Account> accounts, int initialAccountNum) {
        this.accounts = accounts;
        this.initialAccountNum = initialAccountNum;
//        this.transactionHistory = transactionHistory;
    }

}
