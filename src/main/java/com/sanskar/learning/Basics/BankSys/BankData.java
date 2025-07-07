package com.sanskar.learning.Basics.BankSys;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

// This to save data needed for new test runs
public class BankData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L; // Store version ID
    public ArrayList<Account> accounts; // Only initialize accounts arraylist
    public int initialAccountNum = 100;

    BankData(ArrayList<Account> accounts, int initialAccountNum) {
        this.accounts = accounts;
        this.initialAccountNum = initialAccountNum;
    }
}
