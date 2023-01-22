package com.rewards.model.service;

import com.rewards.model.request.Transaction;
import java.util.HashMap;

public class TransactionsByMonth {

    HashMap<Integer, MonthlySum> listOfTransactions;

    public void addTransaction(Transaction transaction) {
        Integer transactionYearMonth = transaction.getDate().getYear() * 12 + transaction.getDate().getMonthValue();

        if (listOfTransactions.get(transactionYearMonth) == null) {
            listOfTransactions.put(transactionYearMonth, new MonthlySum(transaction));
        } else {
            listOfTransactions.get(transactionYearMonth).addTransaction(transaction);
        }
    }

    public TransactionsByMonth() {
        listOfTransactions = new HashMap<>();

    }



}
