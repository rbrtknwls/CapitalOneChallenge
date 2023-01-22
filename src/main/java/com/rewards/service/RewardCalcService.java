package com.rewards.service;


import com.rewards.model.request.RewardRequest;
import com.rewards.model.request.Transaction;
import com.rewards.model.response.RewardResponse;
import com.rewards.model.service.MonthlySum;
import com.rewards.model.service.TransactionsByMonth;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardCalcService {

    public RewardResponse calculateReward(RewardRequest rewardRequest) {

        List<Transaction> transactions = rewardRequest.getTransactionList();
        TransactionsByMonth transactionsByMonth = new TransactionsByMonth();

        transactions.forEach(transactionsByMonth::addTransaction);


        return new RewardResponse();

    }


}
