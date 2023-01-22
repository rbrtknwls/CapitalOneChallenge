package com.rewards.model.service;

public class VendorSum {
    long total_sum;

    public void addValue(long amount) {
        total_sum += amount;
    }

    public VendorSum() {
        total_sum = 0;
    }


}
