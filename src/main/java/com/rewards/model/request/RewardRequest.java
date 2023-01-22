package com.rewards.model.request;

import lombok.Data;
import java.util.List;

@Data
public class RewardRequest implements Request{
    List<Transaction> transactionList;
}
