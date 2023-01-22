package com.rewards.model.service;

import com.rewards.model.request.Transaction;

public class MonthlySum {
    VendorSum sportCheck;
    VendorSum timHortons;
    VendorSum subway;
    VendorSum other;

    public void addTransaction(Transaction transaction) {

        switch (VendorType.getType(transaction.getMerchant_code())) {
            case SportsCheck -> sportCheck.addValue(transaction.getAmount_cents());
            case TimHortons -> timHortons.addValue(transaction.getAmount_cents());
            case Subway -> subway.addValue(transaction.getAmount_cents());
            default -> other.addValue(transaction.getAmount_cents());
        }
    }

    public MonthlySum(Transaction transaction) {
        sportCheck = new VendorSum();
        timHortons = new VendorSum();
        subway = new VendorSum();
        other = new VendorSum();

        addTransaction(transaction);
    }


}
