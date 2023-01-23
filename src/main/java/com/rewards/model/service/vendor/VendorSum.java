package com.rewards.model.service.vendor;

public class VendorSum implements Cloneable {
    public long total_sum;

    public void addValue(long amount) {
        total_sum += amount;
    }

    public void subValue(long amount) {total_sum -= amount; }

    public Boolean isEqualOrGreaterThen(long amount) { return total_sum >= amount; }

    public VendorSum() {
        total_sum = 0;
    }

    public Object clone()
    {
        try {
            return super.clone();
        } catch (CloneNotSupportedException exception) {
            return new VendorSum();
        }
    }

}
