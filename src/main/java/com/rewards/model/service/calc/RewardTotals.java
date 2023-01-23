package com.rewards.model.service.calc;

import com.rewards.model.response.RewardResponseData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RewardTotals {
    int rule1Count;
    int rule2Count;
    int rule3Count;
    int rule4Count;
    int rule5Count;
    int rule6Count;
    int rule7Count;

    public RewardResponseData toResponseData(String date) {

        int sum = rule1Count * ((int) Rules.Rule1.pointVal) +
                  rule2Count * ((int) Rules.Rule2.pointVal) +
                  rule3Count * ((int) Rules.Rule3.pointVal) +
                  rule4Count * ((int) Rules.Rule4.pointVal) +
                  rule5Count * ((int) Rules.Rule5.pointVal) +
                  rule6Count * ((int) Rules.Rule6.pointVal) +
                  rule7Count;

        return RewardResponseData.builder()
                .Date(date)
                .T1(rule1Count * ((int) Rules.Rule1.pointVal))
                .T2(rule2Count * ((int) Rules.Rule2.pointVal))
                .T3(rule3Count * ((int) Rules.Rule3.pointVal))
                .T4(rule4Count * ((int) Rules.Rule4.pointVal))
                .T5(rule5Count * ((int) Rules.Rule5.pointVal))
                .T6(rule6Count * ((int) Rules.Rule6.pointVal))
                .T7(rule7Count)
                .Total(sum)
                .build();
    }
}
