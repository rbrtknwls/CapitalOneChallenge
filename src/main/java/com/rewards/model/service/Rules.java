package com.rewards.model.service;

public enum Rules {
    Rule1(75000, 25000, 25000, 500),
    Rule2(75000, 25000, 0, 300),
    Rule3(75000, 0, 0, 200),
    Rule4(25000, 10000, 10000, 150),
    Rule5(25000, 10000, 0, 75),
    Rule6(20000, 0, 0, 75),
    Rule7(0, 0, 0, 0);

    final long sportCost;
    final long subCost;
    final long timCost;
    long pointVal;

    Rules(long sportCost, long subCost, long timCost, long pointVal) {
        this.sportCost = sportCost;
        this.subCost = subCost;
        this.timCost = timCost;
        this.pointVal = pointVal;
    }

    public void updatePoint(long pointVal) {
        this.pointVal = pointVal;
    }




}
