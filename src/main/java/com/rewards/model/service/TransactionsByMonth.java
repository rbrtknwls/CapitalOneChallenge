package com.rewards.model.service;

import com.rewards.model.request.Transaction;
import com.rewards.model.response.RewardResponse;
import com.rewards.model.response.RewardResponseData;

import java.time.Year;
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



    public RewardResponse toResponse() {
        List<RewardResponseData> rewardResponse = new ArrayList<>();

        listOfTransactions.forEach((yearMonth, data) ->
                rewardResponse.add(RewardResponseData.builder()
                        .Date(formatYearMonth(yearMonth))
                        .totaltim(data.timHortons.total_sum)
                        .totalsport(data.sportCheck.total_sum)
                        .totaloth(data.other.total_sum)
                        .totalsub(data.subway.total_sum)
                .build()));

        return RewardResponse.builder()
                             .rewardResponseData(rewardResponse)
                             .build();
    }

    public TransactionsByMonth(List<Transaction> transactionList) {
        listOfTransactions = new HashMap<>();

        transactionList.forEach(this::addTransaction);

    }





}
