package com.rewards.model.service.calc;

public enum Rules {
    Rule1(7500, 2500, 2500, 500),
    Rule2(7500, 2500, 0, 300),
    Rule3(7500, 0, 0, 200),
    Rule4(2500, 1000, 1000, 150),
    Rule5(2500, 1000, 0, 75),
    Rule6(2000, 0, 0, 75),
    Rule7(0, 0, 0, 0);

    public final long sportCost;
    public final long subCost;
    public final long timCost;
    public long pointVal;

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
