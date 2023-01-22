package com.rewards.model.service;

import com.rewards.model.request.Transaction;
import com.rewards.model.response.RewardResponseData;
import org.apache.tomcat.util.digester.Rule;

import java.util.ArrayList;
import java.util.List;

public class MonthlySum {
    VendorSum sportCheck;
    VendorSum timHortons;
    VendorSum subway;
    VendorSum other;

    long pointTotal;
    List<Rules> rulesList;

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

        pointTotal = 0;
        rulesList = new ArrayList<>();

        addTransaction(transaction);
    }

    public MonthlySum(MonthlySum monthlySum) {
        sportCheck = monthlySum.sportCheck;
        timHortons = monthlySum.timHortons;
        subway = monthlySum.subway;
        other = monthlySum.other;

        pointTotal = monthlySum.pointTotal;
        rulesList = monthlySum.rulesList;
    }


    public boolean canApplyRule(Rules rules) {
        if (rules == Rules.Rule7) {
            return true;
        } else {
            return (sportCheck.isEqualOrGreaterThen(rules.sportCost) &&
                    timHortons.isEqualOrGreaterThen(rules.timCost) &&
                    subway.isEqualOrGreaterThen(rules.subCost));
        }
    }

    public MonthlySum applyRule(Rules rules) {
        if (rules == Rules.Rule7) {
            return applyRule7();
        } else {
            MonthlySum newMonthlySum = new MonthlySum(this);

            newMonthlySum.sportCheck.subValue(rules.sportCost);
            newMonthlySum.timHortons.subValue(rules.timCost);
            newMonthlySum.subway.subValue(rules.subCost);

            newMonthlySum.rulesList.add(rules);
            newMonthlySum.pointTotal += rules.pointVal;

            return newMonthlySum;
        }
    }

    public MonthlySum applyRule7() {
        MonthlySum newMonthlySum = new MonthlySum(this);

        long total_points = (long) Math.floor((sportCheck.total_sum + timHortons.total_sum +
                            subway.total_sum + other.total_sum)/1000.0f);

        newMonthlySum.sportCheck.subValue(sportCheck.total_sum);
        newMonthlySum.timHortons.subValue(timHortons.total_sum);
        newMonthlySum.subway.subValue(subway.total_sum);
        newMonthlySum.other.subValue(other.total_sum);

        Rules rule7 = Rules.Rule7;
        rule7.updatePoint(total_points);

        newMonthlySum.rulesList.add(rule7);
        newMonthlySum.pointTotal += total_points;

        return newMonthlySum;
    }

    public RewardResponseData toRuleData(String date) {
        RewardResponseData responseData = RewardResponseData.builder()
                .Date(date)
                .rule1Count(0)
                .rule2Count(0)
                .rule3Count(0)
                .rule4Count(0)
                .rule5Count(0)
                .rule6Count(0)
                .rule7Count(0)
                .build();

        rulesList.forEach(rules -> {
            switch (rules) {
                case Rule1:
                    responseData.setRule1Count(responseData.getRule1Count() + 1);
                case Rule2:
                    responseData.setRule2Count(responseData.getRule2Count() + 1);
                case Rule3:
                    responseData.setRule3Count(responseData.getRule3Count() + 1);
                case Rule4:
                    responseData.setRule4Count(responseData.getRule4Count() + 1);
                case Rule5:
                    responseData.setRule5Count(responseData.getRule5Count() + 1);
                case Rule6:
                    responseData.setRule6Count(responseData.getRule6Count() + 1);
                default:
                    responseData.setRule7Count((int) rules.pointVal);
            }
        });
        return responseData;
    }




}
