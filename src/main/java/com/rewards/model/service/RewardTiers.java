package com.rewards.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RewardTiers {

    Stream<Rules> allContRules = Stream.of(Rules.Rule1, Rules.Rule2, Rules.Rule3,
                                           Rules.Rule4, Rules.Rule5, Rules.Rule6);
    public MonthlySum CalculateRewards(MonthlySum monthlySum) {
        List<MonthlySum> possibleResults = new ArrayList<>();

        // Loop through each rule (not including 7), see if it can apply
        allContRules.forEach((rule) -> {
            if (monthlySum.canApplyRule(rule)) {
                possibleResults.add(monthlySum.applyRule(rule));
            }
        });

        // 7 can always apply, calculate what the points from it would be
        MonthlySum convertAllToPoints = monthlySum.applyRule(Rules.Rule7);

        // if no other possible rule can be used, use 7
        if (possibleResults.size() == 0) {
            return convertAllToPoints;
        }

        // Calculate point max if we used the other rules
        Stream<MonthlySum> rewardPossibilities = possibleResults.stream()
                                                                .map(this::CalculateRewards);

        // Return the maximum point total
        return rewardPossibilities.reduce(convertAllToPoints, (acc, newVal) -> {
            if (acc.pointTotal < newVal.pointTotal) {
                return newVal;
            } else {
                return acc;
            }
        });
    }


}
