package com.rewards.model.service;

import com.rewards.model.request.Transaction;
import com.rewards.model.response.RewardResponse;
import com.rewards.model.response.RewardResponseData;
import com.rewards.model.service.calc.RewardTiers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionsByMonth {

    HashMap<Integer, MonthlySum> listOfTransactions;

    private void addTransaction(Transaction transaction) {
        Integer transactionYearMonth = transaction.getDate().getYear() * 12 + transaction.getDate().getMonthValue();

        if (listOfTransactions.get(transactionYearMonth) == null) {
            listOfTransactions.put(transactionYearMonth, new MonthlySum(transaction));
        } else {
            listOfTransactions.get(transactionYearMonth).addTransaction(transaction);
        }
    }

    private String formatYearMonth(Integer yearMonth) {
        Integer year = yearMonth/12;
        Integer month = yearMonth%12;

        return "Year: " + year + " | Month: " + month;
    }



    public void calculate() {
        RewardTiers rewardTier = new RewardTiers();
        listOfTransactions.forEach((yearMonth, data) -> {
            listOfTransactions.put(yearMonth, rewardTier.CalculateRewards(data));
        });
    }


    public RewardResponse toResponse() {
        List<RewardResponseData> rewardResponse = new ArrayList<>();

        listOfTransactions.forEach((yearMonth, data) ->
                rewardResponse.add(data.toRuleData().toResponseData(formatYearMonth(yearMonth)))
        );

        return RewardResponse.builder()
                             .rewardResponseData(rewardResponse)
                             .build();
    }

    public TransactionsByMonth(List<Transaction> transactionList) {
        listOfTransactions = new HashMap<>();

        transactionList.forEach(this::addTransaction);

    }





}
